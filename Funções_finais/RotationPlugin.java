public class RotationPlugin implements Plugin
{
	private String[] args = {"image", "graus"};
	private String[] deps = {"cv2","numpy"};
	private String[] pluginDeps = {};
	
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
				"\t(h, w) = image.shape[:2]\n" +
				"\tcenter = (w / 2, h / 2)\n" +
				"\tif isinstance(graus, str):\n" +
				"\t\ttry:\n" +
				"\t\t\tgraus = int(graus)\n" +
				"\t\texcept ValueError:\n" +
				"\t\t\tprint(\"Given value is not a number\")\n" +
				"\tM = cv2.getRotationMatrix2D(center, graus, 1.0)\n" +
				"\trotated = cv2.warpAffine(image, M, (w, h))\n" +
				"\treturn rotated\n";
	}
}
