public class ClassImagePlugin implements Plugin
{
	private String[] args = {};
	private String[] deps = {"cv2"};
	private String[] pluginDeps = {};
	
	public LFACodeGenerator.TargetLanguage getFunctionLanguage()
	{
		return LFACodeGenerator.TargetLanguage.Python;
	}
	
	public String getFunctionName()
	{
		return "Image";
	}
	public String[] getFunctionArguments()
	{
		return args;
	}
	public int getFunctionArgumentCount()
	{
		return this.getFunctionArguments().length;
	}
	public String[] getFunctionDependencies()
	{
		return deps;
	}
	public String[] getPluginDependencies()
	{
		return pluginDeps;
	}
	public String getFunction()
	{
		return "class " + this.getFunctionName() + ":\n" +
				"\tdef __init__(self,elem,path):\n" +
				"\t\tself.elem = elem\n" +
				"\t\tself.path = path\n" +
				"\t\tself.name = self.searchName(path)\n" +
				"\t\tself.extension = self.searchExtension(path)\n" +
				"\t@staticmethod" + 
				"\tdef searchName(path):\n" +
				"\t\tp = path.split(\"/\")" +
				"\t\tn = p[len(p)-1].split(\".\")\n" +
				"\t\treturn n[0]\n" +
				"\t@staticmethod" + 
				"\tdef searchExtension(path):\n" +
				"\t\tp = path.split(\".\")" +
				"\t\treturn p[len(p)-1]\n";
				
	}
}
