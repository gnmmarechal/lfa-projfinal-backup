public class ShowPlugin implements Plugin
{
	private String[] args = {"image"};
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
		return "show";
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
				"	cv2.imshow(\"Result\", image)\n" +
				"	cv2.waitKey(0)\n" +
				"	cv2.destroyAllWindows()";
	}
}
 
