public class RotationPlugin implements Plugin
{
	private String[] args = {"image", "graus"};
	private String[] deps = {"cv2"};
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
				"	(h, w) = image.shape[:2]\n" +
				"	center = (w / 2, h / 2)\n" +
				"	if isinstance(graus, str):\n" +
				"	\ttry:\n" +
				"	\t\tgraus = int(graus)\n" +
				"	\texcept ValueError:\n" +
				"	\t\tprint(\"given argument is not a number\")\n" +
				"	M = cv2.getRotationMatrix2D(center, graus, 1.0)\n" +
				"	rotated = cv2.warpAffine(image, M, (w, h))\n" +
				"	return rotated";
	}
}
