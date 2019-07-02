public class ImagePlacerPlugin implements Plugin
{
	private String[] args = {"image1, image2, corner"};
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
		return "imageplacer";
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
				"	if(corner == \"BL\"):\n" +
				"	\timage1[0:image2.shape[0], 0:image2.shape[1]] = image2\n" +
				"	elif(corner == \"BR\"):\n" +
				"	\timage1[image1.shape[0] - image2.shape[0]:image1.shape[0], image1.shape[1] - image2.shape[1]:image1.shape[0]] = image2\n" +
				"	elif(corner == \"UL\"):\n" +
				"	\timage1[image1.shape[0] - image2.shape[0]:image1.shape[0], 0:image2.shape[1]] = image2\n" +
				"	elif(corner == \"UR\"):\n" +
				"	\timage1[0:image2.shape[0], image1.shape[1] - image2.shape[1]:image1.shape[0]] = image2\n" +
				"	else:\n" +
				"	\tprint(\"invalid parameter\")\n" +
				"	return image1";
	}
}
