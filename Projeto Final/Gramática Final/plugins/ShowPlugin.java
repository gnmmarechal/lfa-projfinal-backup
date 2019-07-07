public class ShowPlugin implements Plugin
{
	private String[] args = {"image"};
	private String[] deps = {"cv2"};
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
		return "show";
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
				"\tif image.elem.shape[0] > 720 or image.elem.shape[0] > 1280:\n" +
				"\t\tshow(scale(image,70))\n" +
				"\telse:\n" +
				"\t\tcv2.imshow(\"Result\", image)\n" +
				"\t\tcv2.waitKey(0)\n" +
				"\t\tcv2.destroyAllWindows()";
	}
}
 
