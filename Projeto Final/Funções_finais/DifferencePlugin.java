public class DifferencePlugin implements Plugin
{
	private String[] args = {"image1","image2"};
	private String[] deps = {"cv2","numpy"};
	private String[] pluginDeps = {};
	
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
				"\t\treturn cv2.absdiff(new_img1,new_img2)\n" + 
				"\treturn cv2.absdiff(image1,image2)";
				/*
	if image1.shape[0] != image2.shape[0] or image1.shape[1] != image2.shape[1]:
		if image1.shape[0] >= image2.shape[0]:
			h = image2.shape[0]
		else:
			h = image1.shape[0]
		if image1.shape[1] >= image2.shape[1]:
			w = image2.shape[1]
		else:
			w = image1.shape[1]
		
		new_img1 = resize(image1,w,h)
		new_img2 = resize(image2,w,h)
		return cv2.absdiff(new_img1,new_img2)
	return cv2.absdiff(image1,image2)
	* */
	}
}
