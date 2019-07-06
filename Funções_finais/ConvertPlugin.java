public class ConvertPlugin implements Plugin
{
	private String[] args = {"image","type"};
	private String[] deps = {"cv2","numpy"};
	private String[] pluginDeps = {"filter"};
	
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
		return "convert";
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
				"\tif type == 1:\n" +
				"\t\treturn filter(image,1,0,0)\n" +
				"\tif type == 2:\n" +
				"\t\treturn filter(image,0,1,0)\n" +
				"\tif type == 3:\n" +
				"\t\treturn filter(image,0,0,1)\n" +
				"\tif type == 4:\n" +
				"\t\treturn cv2.cvtColor(image, cv2.COLOR_BGR2GRAY)\n" +
				"\tif type == 5:\n" +
				"\t\treturn cv2.cvtColor(image, cv2.COLOR_BGR2HLS)\n" +
				"\tif type == 6:\n" +
				"\t\treturn cv2.cvtColor(image, cv2.COLOR_BGR2LUV)\n" +
				"\tif type == 7:\n" +
				"\t\treturn cv2.cvtColor(image, cv2.COLOR_BGR2XYZ)\n" +
				"\tif type == 8:\n" +
				"\t\treturn cv2.cvtColor(image, cv2.COLOR_BGR2RGB)\n" +
				"\tif type == 9:\n" +
				"\t\treturn cv2.cvtColor(image, cv2.COLOR_BGR2YUV)\n" +
				"\tif type == 12:\n" +
				"\t\treturn filter(image,1,1,0)\n" +
				"\tif type == 13:\n" +
				"\t\treturn filter(image,1,0,1)\n" +
				"\tif type == 23:\n" +
				"\t\treturn filter(image,0,1,1)\n" +			
				"\tprint(\"Type not recognized\")\n" +
				"\treturn image\n";
	}
}
