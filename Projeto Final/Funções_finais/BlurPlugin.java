public class BlurPlugin implements Plugin
{
	private String[] args = {"img","x"};
	private String[] deps = {"cv2"};
	private String[] pluginDeps = {"copy","Image"};
	
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
		return "blur";
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
				"\tif x < 1 or x > 100:\n" +
				"\t\tprint(\"Invalid blur value. Values: 1 - 100\")\n" +
				"\t\treturn img\n" +
				"\tif x%2 == 0:\n" +
				"\t\tx = x-1\n" +
				"\timage = copy(img)\n" +
				"\timage.elem = cv2.GaussianBlur(image.elem,(x,x),0))\n" +
				"\treturn image\n";
	}
}
