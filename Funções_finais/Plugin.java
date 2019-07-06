public interface Plugin
{
	public String getFunctionLanguage();
	public String getFunctionName();
	public int getFunctionArgumentCount();
	public String[] getFunctionArguments();
	public String[] getPluginDependencies();
	public String[] getFunctionDependencies();
	public String getFunction();
}
