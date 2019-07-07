public class SavePlugin implements Plugin
{
	private String[] args = {"image"};
	private String[] deps = {"cv2","numpy","os.path","pathlib"};
	private String[] pluginDeps = {"Image"};
	
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
		return "save";
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
				"\tdest = \"copy_of_\" + image.name + \".\" + image.extension\n" +
				"\ttarget_file = pathlib.Path(dest)\n" +
				"\tif target_file.is_file():\n" +
				"\t\ti = 0\n" +
				"\t\twhile(target_file.is_file()):\n" +
				"\t\t\ti = i + 1\n" +
				"\t\t\tdest = \"copy_of_\" + image.name + \" (\" + str(i) + \") .\" + image.extension\n" +
				"\t\t\ttarget_file = pathlib.Path(dest)\n" +
				"\tcv2.imwrite(dest, image.elem)\n";
	
	
	}
}
