public class FilterPlugin implements Plugin
{
	private String[] args = {"img","r","g","b"};
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
		return "filter";
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
				"\tnew = numpy.zeros(img.shape, img.dtype)\n" +
				"\tfor h in range(img.shape[0]):\n" +
				"\t\tfor w in range(img.shape[1]):\n" +
				"\t\t\tnew[h,w] = [img[h,w][0] * b, image[h,w][1] * g, img[h,w][2] * r]\n" +
				"\treturn new\n";
	}
}
