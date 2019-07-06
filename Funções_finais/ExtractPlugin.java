public class ExtractPlugin implements Plugin
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
		return "extract";
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
				"\tgray = cv2.cvtColor(image, cv2.COLOR_BGR2GRAY)\n" +
				"\tfaceCascade = cv2.CascadeClassifier(cv2.data.haarcascades + \"haarcascade_frontalface_default.xml\")\n" +
				"\tfaces = faceCascade.detectMultiScale(\n" +
				"\t\tgray,\n" +
				"\t\tscaleFactor=1.3,\n" +
				"\t\tminNeighbors=3,\n" +
				"\t\tminSize=(30,30)\n" +
				"\t)\n" +
				"\tprint(\"Found {0} Faces.\".format(len(faces)))\n" +
				"\tfor (x, y, w, h) in faces:\n" +
				"\t\tcv2.rectangle(image, (x, y), (x + w, y + h), (0, 0, 0), 2)\n" +
				"\t\troi_color = image[y:y + h, x:x + w]\n" +
				"\t\tprint(\"Face found. Saving.\")\n" +
				"\t\tcv2.imwrite(str(w) + str(h) + '_faces.jpg', roi_color)\n";
	}
}
