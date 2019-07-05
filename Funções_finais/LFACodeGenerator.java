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

	public LFACodeGenerator() throws Exception
	{
		this.codeBlocks = new ArrayList<String>();
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
					if (loadedPluginList.isEmpty()) loadedPluginList.add(pluginToAdd);
					else
					{
						for (Plugin p : loadedPluginList) // Check for duplicates
						{
							if (!p.getFunctionName().equals(pluginToAdd.getFunctionName()))
							{
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
		for (String impVal : imports)
		{
			retBlock += "import " + impVal + "\n";
		}
		
		return retBlock;
	}
	
	public String getFunctionBlock() // Devolve o bloco de funções predefinidas da linguagem deste programa
	{
		String retBlock = "";
		for (Plugin p : usedPluginList)
		{
			retBlock += p.getFunction() + "\n";
		}
		return retBlock;
	}
	public String generateCode()
	{
		String codeOut = "#!/usr/bin/env python3" + // Starts with the shebang line
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
	
	public boolean setVariable(String variableName, String functionName, List<String> functionArgs) // Adiciona uma linha de código para definir uma variável para o valor de uma função. Também gere as dependências.
	{
		if (!this.requireFunction(functionName))
			return false;
		this.addCode(generateVariableSet(variableName, functionName, functionArgs));
		return true;
	}
	public static String generateFunctionCall(String functionName, List<String> functionArgs) // Gera uma linha de código de chamada de função 
	{
		String csvArgs = functionArgs.stream()
			.collect(Collectors.joining(", "));
		String functionCall = functionName + "(" + csvArgs + ")";
		return functionCall;
	}
	
	public static String generateFunctionDefinition(String functionName, List<String> argumentNames, List<String> lines) // Gera a definição de uma função
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
	public String generateChainedFunctionCall(String functionCall) //TO-DO
	{
		return null;
	}
	public static String generateVariableSet(String variableName, String functionName, List<String> functionArgs) // Gera uma linha de código do tipo var = func(args)
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

		this.addCode(generateFunctionCall(functionName, functionArgs));
		
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
