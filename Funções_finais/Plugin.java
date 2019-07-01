public interface Plugin
{
	public String getFunctionName();
	public int getFunctionArgumentCount();
	public String[] getFunctionArguments();
	public String[] getFunctionDependencies();
	public String getFunction();
}
