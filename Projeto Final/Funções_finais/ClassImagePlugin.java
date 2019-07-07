public class ClassImagePlugin implements Plugin
{
	private String[] args = {};
	private String[] deps = {"cv2","numpy"};
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
				"\t\tself.path = path\n";
	}
}
