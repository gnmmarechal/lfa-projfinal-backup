public class CropPlugin implements Plugin
{
	private String[] args = {"img","x","y","w","h"};
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
		return "crop";
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
				"\tif x < 0 or y < 0:\n" +
				"\t\tprint(\"Invalid coordinates.\")\n" +
				"\t\treturn img\n" +
				"\tif w < 0 or h < 0:\n" +
				"\t\tprint(\"Invalid rectangle size.\")\n" +
				"\t\treturn img\n" +
				"\timage = copy(img)\n" +
				"\timage.elem = image.elem[y:y+h, x:x+w]\n" +
				"\treturn image\n";
	}
}
