public class BrightnessPlugin implements Plugin
{
	private String[] args = {"image","x"};
	private String[] deps = {"cv2","numpy"};
	private String[] pluginDeps = {"colours"};
	
	public LFACodeGenerator.TargetLanguage getFunctionLanguage()
	{
		return LFACodeGenerator.TargetLanguage.Python;
	}
	
	private String getArgString()
	{
		String retString = "";
		for (int i = 0; i < args.length - 1; i++)
		{
			retString += args[i] + ", ";
		}
		retString += args[args.length-1];
		return retString;
		
	}
	public String getFunctionName()
	{
		return "brightness";
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
		return "def " + this.getFunctionName() + "(" + this.getArgString() + "):\n" +
				"\tif x < 0 or x > 100:\n" +
				"\t\tprint(\"Invalid brightness value. Values: 0 - 100\")\n" +
				"\t\treturn image\n" +
				"\treturn colours(image,1,x-50)\n";
	}
}
