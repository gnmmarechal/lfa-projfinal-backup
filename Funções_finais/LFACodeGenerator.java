//import org.stringtemplate.v4.*;
import java.util.*;
import java.io.*;

public class LFACodeGenerator
{
	private String codeOut;
	private List<Plugin> loadedPluginList;
	private List<Plugin> usedPluginList;

	public LFACodeGenerator() throws Exception
	{
		codeOut = "";
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
				} catch (InstantiationException e)
				{
					//System.out.println("Found non-plugin class : " + foundFile);
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
	
	public String getImportBlock()
	{
		String retBlock = "";
		List<String> imports = this.getImports();
		for (String impVal : imports)
		{
			retBlock += "import " + impVal + "\n";
		}
		
		return retBlock;
	}
	
	public String getFunctionBlock()
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
		codeOut = "#!/usr/bin/env python3" + // Starts with the shebang line
				"\n# Generated with LFACodeGenerator\n";
				
		// Adicionar o bloco de import
		
		codeOut += this.getImportBlock();
		
		// Adicionar as funções usadas
		
		codeOut += this.getFunctionBlock();
		
		
		codeOut += "# EOF - Generated with LFACodeGenerator";
		return codeOut;
	}
}
