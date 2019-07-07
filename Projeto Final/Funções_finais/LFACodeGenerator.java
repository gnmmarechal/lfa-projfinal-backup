//import org.stringtemplate.v4.*;
import java.util.*;
import java.io.*;
import java.util.stream.*;

public class LFACodeGenerator
{
	private List<Plugin> loadedPluginList; // Todos os plugins encontrados ficam nesta lista
	private List<Plugin> usedPluginList; // Todos os plugins usados são adicionados pelo gestor de dependências. Plugins podem ser adicionados por nome com requireFunction.
	private List<String> functionBlocks; // Blocos de definições de funções
	private List<String> codeBlocks; // Código do programa em si
	
	private TargetLanguage targetLang; 
	
	public enum TargetLanguage
	{
		Python, Java // Suporte de Java bastante incompleto, não funciona ainda, o código gerado ainda segue standards de Python
	}
	
	public LFACodeGenerator() throws Exception
	{
		this(TargetLanguage.Python);
	}
	public LFACodeGenerator(TargetLanguage language) throws Exception
	{
		this.targetLang = language;
		this.codeBlocks = new ArrayList<String>();
		this.functionBlocks = new ArrayList<String>();
		this.loadedPluginList = new ArrayList<Plugin>();
		this.usedPluginList = new ArrayList<Plugin>();
		// Load plugins
		String[] foundPluginArray = (new File("plugins").list());	
		if (foundPluginArray == null)
		{
			System.out.println("Error loading plugin directory!");
			Scanner sc = new Scanner(System.in);
			sc.nextLine();
			return;
		}
		
		for(String foundFile : foundPluginArray)
		{
			if (foundFile.endsWith(".class"))
			{
				try {
					Plugin pluginToAdd = PluginManager.load(foundFile.substring(0,foundFile.lastIndexOf('.')));
					if (loadedPluginList.isEmpty()) 
					{
						if (pluginToAdd.getFunctionLanguage() == this.targetLang)
							loadedPluginList.add(pluginToAdd);
					}
					else
					{
						for (Plugin p : loadedPluginList) // Check for duplicates
						{
							if (!p.getFunctionName().equals(pluginToAdd.getFunctionName()))
							{
								if (pluginToAdd.getFunctionLanguage() == this.targetLang)
									loadedPluginList.add(pluginToAdd);
							}
							else
							{
								System.err.println("WARNING: Function name conflict found (" + p.getFunctionName() + "). Skipping plugin.");
							}
						}
					}
					//System.out.println("Loaded plugin: " + pluginToAdd.getFunctionName());
				}
				catch (Exception e) {
					//System.out.println("Failed to load plugin : " + foundFile);
					//e.printStackTrace();
				}
			}
		}
		
		// Verificar dependências de plugins
		List<String> depList = new ArrayList<String>();
		for (Plugin p : loadedPluginList)
		{
			//System.out.println("Plugin : " + p.getFunctionName());
			//System.out.println(": " + Arrays.toString(depList.toArray()));
			for (String dep : p.getPluginDependencies())
			{
				if (!depList.contains(dep))
					depList.add(dep);
			}
		}
		
		for (String depName : depList)
		{
			boolean foundDep = false;
			for (Plugin p : loadedPluginList)
			{
				if (p.getFunctionName().equals(depName))
					foundDep = true;
			}
			// Se for false, não encontrou a dependência
			if (!foundDep)
				throw new Exception("Missing plugin dependency: " + depName);
		}
	}
	public boolean requireFunction(String functionName) // Returns true if successful, false if function isn't found
	{
		
		for (Plugin plg : loadedPluginList)
		{
			if (plg.getFunctionName().equals(functionName))
			{
				// Add plugin to used list
				for (String depName : plg.getPluginDependencies())
				{
					this.requireFunction(depName);
				}
				if (!usedPluginList.contains(plg))
					usedPluginList.add(plg);
				return true;
			}
		}
		return false;
		
	}
	
	public List<Plugin> getLoadedPlugins()
	{
		return loadedPluginList;
	}
	
	public List<Plugin> getUsedPlugins()
	{
		return usedPluginList;
	}
	
	public static List<String> getPluginNames(List<Plugin> list)
	{
		List<String> retList = new ArrayList<String>();
		for (Plugin p : list)
		{
			retList.add(p.getFunctionName());
		}
		
		return retList;
	}
	
	public List<String> getImports()
	{
		List<String> importList = new ArrayList<String>();
		for (Plugin p : usedPluginList)
		{
			for (String dep : p.getFunctionDependencies())
			{
				if (!importList.contains(dep))
					importList.add(dep);
			}
		}
		
		return importList;
	}
	
	public String getImportBlock() // Devolve o bloco de imports deste programa
	{
		String retBlock = "";
		List<String> imports = this.getImports();
		String semCol = "";
		if (targetLang == TargetLanguage.Java)
			semCol = ";";
		for (String impVal : imports)
		{
			// Função para importar apenas algo de uma library
			if (targetLang == TargetLanguage.Python && impVal.contains("#"))
			{
				// Formato library#thing -> from library import thing
				String[] libImp = impVal.split("#");
				if (libImp.length != 2) return "";
				retBlock += "from " + libImp[0] + " import " + libImp[1] + "\n";
			}
			else
				retBlock += "import " + impVal + semCol + "\n";
		}
		
		return retBlock;
	}
	
	public String getFunctionBlock() // Devolve o bloco de funções predefinidas da linguagem deste programa
	{
		String retBlock = "";
		for (Plugin p : usedPluginList)
		{
			retBlock += p.getFunction() + "\n"; // Isto não adiciona \t, isso terá de ser feito nos plugins
		}
		return retBlock;
	}
	public String generateCode()
	{
		String codeOut = "";
		
		if (targetLang == TargetLanguage.Java) // Incompleto
		{
			
			codeOut = "// Generated with LFACodeGenerator\n";
			codeOut += this.getImportBlock();
			codeOut += "public class Main {\n" +
					   "	public static void main(String[] args) {\n";
					   
			for (String line : codeBlocks)
			{
				codeOut += line + "\n";
			}
			
			codeOut += "	}\n//Function Block\n";
			
			for (String line : functionBlocks)
			{
				codeOut += "\t" + line + "\n";
			}
			
			codeOut += "// Language Function Block\n";
			
			codeOut += this.getFunctionBlock(); // Isto não adiciona \t, talvez tenha de ser feito directamente no outro método
			
			codeOut += "}\n// EOF - Generated with LFACodeGenerator";
			return codeOut;
		}
		
		codeOut = "#!/usr/bin/env python3" + // Starts with the shebang line
				"\n# Generated with LFACodeGenerator\n";
				
		// Adicionar o bloco de import
		
		codeOut += this.getImportBlock();
		
		// Adicionar as funções usadas
		
		codeOut += "# Language Functions\n" + this.getFunctionBlock();
		
		// Adicionar código do programa
		
		codeOut += "# Program\n";
		for (String line : functionBlocks)
		{
			codeOut += line + "\n";
		}
		for (String line : codeBlocks)
		{
			codeOut += line + "\n";
		}
		codeOut += "# EOF - Generated with LFACodeGenerator";
		return codeOut;
	}
	
	public boolean declareVariable(String variableType, String variableName, String functionName, List<String> functionArgs)
	{
		if (targetLang == TargetLanguage.Python)
			return false;
		if (!this.requireFunction(functionName))
			return false;
		this.addCode(generateJavaVariableDeclaration(variableType, variableName, functionName, functionArgs));
		return true;
	}
	public boolean setVariable(String variableName, String functionName, List<String> functionArgs) // Adiciona uma linha de código para definir uma variável para o valor de uma função. Também gere as dependências.
	{
		if (!this.requireFunction(functionName))
			return false;
		
		String varSet = "";
		switch(targetLang)
		{
			case Java:
				varSet = generateJavaVariableSet(variableName, functionName, functionArgs);
				break;
			case Python:
				varSet = generatePythonVariableSet(variableName, functionName, functionArgs);
				break;
		}
		this.addCode(varSet);
		return true;
	}
	public static String generateFunctionCall(String functionName, List<String> functionArgs) // Gera uma linha de código de chamada de função 
	{
		String csvArgs = functionArgs.stream()
			.collect(Collectors.joining(", "));
		String functionCall = functionName + "(" + csvArgs + ")";
		return functionCall;
	}
	
	public static String generatePythonFunctionDefinition(String functionName, List<String> argumentNames, List<String> lines) // Gera a definição de uma função
	{
		String args = argumentNames.stream()
			.collect(Collectors.joining(", "));
		String retVal = "def " + functionName + "(" + args + "):\n";
		for (String line : lines)
		{
			retVal += "\t" + line;
		}
		return retVal;
	}
	
	public static String generateJavaFunctionDefinition(String functionName, List<String> argumentNames, List<String> lines) // Gera a definição de uma função TO-DO
	{
		String args = argumentNames.stream()
			.collect(Collectors.joining(", "));
		String retVal = "def " + functionName + "(" + args + "):\n";
		for (String line : lines)
		{
			retVal += "\t" + line;
		}
		return retVal;
	}
	
	public String generateFunctionDefinition(String functionName, List<String> argumentNames, List<String> lines)
	{
		switch(this.targetLang)
		{
			case Java:
				return generateJavaFunctionDefinition(functionName, argumentNames, lines);
			case Python:
				return generatePythonFunctionDefinition(functionName, argumentNames, lines);
		}
		
		return "TARGET LANG?";
	}

	public static String generatePythonVariableSet(String variableName, String functionName, List<String> functionArgs) // Gera uma linha de código do tipo var = func(args)
	{
		return variableName + " = " + generateFunctionCall(functionName, functionArgs);
	}

	public static String generateJavaVariableDeclaration(String variableType, String variableName, String functionName, List<String> functionArgs) // Gera uma linha de código do tipo var = func(args)
	{
		return variableType + " " + variableName + " = " + generateFunctionCall(functionName, functionArgs) + ";";
	}
		
	public static String generateJavaVariableSet(String variableName, String functionName, List<String> functionArgs) // Gera uma linha de código do tipo var = func(args)
	{
		return variableName + " = " + generateFunctionCall(functionName, functionArgs);
	}
	
	public boolean callFunction(String functionName, String functionArg)
	{
		List<String> args = new ArrayList<String>();
		args.add(functionArg);
		return this.callFunction(functionName, args);
	}
	public boolean callFunction(String functionName, List<String> functionArgs) // Adiciona uma chamada de função ao código do programa
	{
		if (!this.requireFunction(functionName))
			return false;
		String funcCall = "";
		switch(targetLang)
		{
			case Python:
				funcCall = generateFunctionCall(functionName, functionArgs);
				break;
			case Java:
				funcCall = generateFunctionCall(functionName, functionArgs) + ";";
				break;
		}
		this.addCode(funcCall);
		
		return true;
		
	}
	
	public void addFunctionToBlock(String line) // Isto não usa requireFunction, talvez crie um tipo Function
	{
		this.functionBlocks.add(line);
	}
	public void addCode(String line) // Isto simplesmente adiciona um elemento aos blocos de código. Não deverá ser usado para chamar funções pois as dependências não são resolvidas automaticamente, mas se necessário, requireFunction pode ser usado para as resolver.
	{
		this.codeBlocks.add(line);
	}
}
