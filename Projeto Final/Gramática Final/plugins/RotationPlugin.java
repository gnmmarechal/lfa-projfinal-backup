public class RotationPlugin implements Plugin
{
	private String[] args = {"img", "d"};
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
		return "rotation";
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
				"\timage = copy(img)\n" +
				"\t(h, w) = image.shape[:2]\n" +
				"\tcenter = (w / 2, h / 2)\n" +
				"\tM = cv2.getRotationMatrix2D(center, d, 1.0)\n" +
				"\timage.elem = cv2.warpAffine(image.elem, M, (w, h))\n" +
				"\treturn image\n";
	}
}
