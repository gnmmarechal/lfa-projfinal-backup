public interface Plugin
{
	public LFACodeGenerator.TargetLanguage getFunctionLanguage();
	public String getFunctionName();
	public int getFunctionArgumentCount();
	public String[] getFunctionArguments();
	public String[] getPluginDependencies();
	public String[] getFunctionDependencies();
	public String getFunction();
}
