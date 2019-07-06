public class CropIntPlugin implements Plugin
{
	private String[] args = {"image"};
	private String[] deps = {"cv2","numpy"};
	private String[] pluginDeps = {};
	
	public String getFunctionLanguage()
	{
		return "Python";
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
		return "cropInt";
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
				"\tr = cv2.selectROI(image, False)\n" +
				"\tcv2.destroyAllWindows()\n" +
				"\tcropped = image[int(r[1]):int(r[1]+r[3]), int(r[0]):int(r[0]+r[2])]\n" +
				"\tif cropped.shape[0] <= 0 or cropped.shape[1] <= 0:\n" +
				"\t\treturn image\n" +
				"\treturn cropped\n";
	}
}
