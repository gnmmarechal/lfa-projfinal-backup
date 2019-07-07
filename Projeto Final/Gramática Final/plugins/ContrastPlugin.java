public class ContrastPlugin implements Plugin
{
	private String[] args = {"img","x"};
	private String[] deps = {"cv2"};
	private String[] pluginDeps = {"colours","copy","Image"};
	
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
		return "contrast";
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
				"\tif x < 0 or x > 300:\n" +
				"\t\tprint(\"Invalid contrast value. Values: 0 - 300\")\n" +
				"\t\treturn img\n" +
				"\timage = copy(img)\n" +
				"\timage.elem = colours(image.elem,x/100,1))\n" +
				"\treturn image\n";
	}
}
