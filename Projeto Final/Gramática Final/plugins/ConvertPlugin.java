public class ConvertPlugin implements Plugin
{
	private String[] args = {"img","type"};
	private String[] deps = {"cv2"};
	private String[] pluginDeps = {"filter","copy","Image"};
	
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
				"\timage = copy(img)\n" +
				"\tif type == 1:\n" +
				"\t\timage.elem =  filter(image.elem,1,0,0)\n" +
				"\telif type == 2:\n" +
				"\t\timage.elem =  filter(image.elem,0,1,0)\n" +
				"\telif type == 3:\n" +
				"\t\timage.elem =  filter(image.elem,0,0,1)\n" +
				"\telif type == 4:\n" +
				"\t\timage.elem =  cv2.cvtColor(image.elem, cv2.COLOR_BGR2GRAY)\n" +
				"\telif type == 5:\n" +
				"\t\timage.elem =  cv2.cvtColor(image.elem, cv2.COLOR_BGR2HLS)\n" +
				"\telif type == 6:\n" +
				"\t\timage.elem =  cv2.cvtColor(image.elem, cv2.COLOR_BGR2LUV)\n" +
				"\telif type == 7:\n" +
				"\t\timage.elem =  cv2.cvtColor(image.elem, cv2.COLOR_BGR2XYZ)\n" +
				"\telif type == 8:\n" +
				"\t\timage.elem =  cv2.cvtColor(image.elem, cv2.COLOR_BGR2RGB)\n" +
				"\telif type == 9:\n" +
				"\t\timage.elem =  cv2.cvtColor(image.elem, cv2.COLOR_BGR2YUV)\n" +
				"\telif type == 12:\n" +
				"\t\timage.elem =  filter(image.elem,1,1,0)\n" +
				"\telif type == 13:\n" +
				"\t\timage.elem =  filter(image.elem,1,0,1)\n" +
				"\telif type == 23:\n" +
				"\t\timage.elem =  filter(image.elem,0,1,1)\n" +	
				"\telse:\n" +		
				"\t\tprint(\"Type not recognized\")\n" +
				"\treturn image\n";
	}
}
