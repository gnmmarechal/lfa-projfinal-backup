public class DifferencePlugin implements Plugin
{
	private String[] args = {"img1","img2"};
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
		return "difference";
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
				"\timage1 = img1.elem\n" +
				"\timage2 = img2.elem\n" +
				"\tif image1.shape[0] != image2.shape[0] or image1.shape[1] != image2.shape[1]:\n" +
				"\t\tif image1.shape[0] >= image2.shape[0]:\n" +
				"\t\t\th = image2.shape[0]\n" +
				"\t\telse:\n" +
				"\t\t\th = image1.shape[0]\n" +
				"\t\tif image1.shape[1] >= image2.shape[1]:\n" +
				"\t\t\tw = image2.shape[1]\n" +
				"\t\telse:\n" +
				"\t\t\tw = image1.shape[1]\n" +
				"\t\tnew_img1 = resize(image1,w,h)\n" +
				"\t\tnew_img2 = resize(image2,w,h)\n" +
				"\t\telem = cv2.absdiff(new_img1,new_img2)\n" + 
				"\telse:\n" + 
				"\t\telem = cv2.absdiff(image1,image2)\n" + 
				"\treturn(Image(elem,\"differenceOf_\" " + "+" + " img1.name " + "+" + " \"_and_\" " + "+" + " img2.name " + "+" + " \".\" " + "+" + " img1.extension))\n";
	}
}
