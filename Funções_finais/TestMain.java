import java.util.*;
public class TestMain {
	
	public static void main (String[] args) {
		System.out.println("Basic Plugin Test:\n");
		Plugin cropPlugin = new CropPlugin();
		System.out.println("Function Name: " + cropPlugin.getFunctionName());
		System.out.println("Argument Count: " + cropPlugin.getFunctionArgumentCount());
		System.out.println("Arguments: " + Arrays.toString(cropPlugin.getFunctionArguments()));
		System.out.println("Dependencies: " + Arrays.toString(cropPlugin.getFunctionDependencies()));
		System.out.println("Function Body:\n" + cropPlugin.getFunction() + "\n");
		
		System.out.println("Code Generator Test:\n");
		
		LFACodeGenerator codeGen = new LFACodeGenerator();
		
		System.out.println("Loaded plugins: " + Arrays.toString(LFACodeGenerator.getPluginNames(codeGen.getLoadedPlugins()).toArray()));
		
		System.out.println("Used plugins: " + Arrays.toString(LFACodeGenerator.getPluginNames(codeGen.getUsedPlugins()).toArray()));
		
		System.out.println("Requiring crop function...");
		codeGen.requireFunction("crop");
		
		System.out.println("Used plugins: " + Arrays.toString(LFACodeGenerator.getPluginNames(codeGen.getUsedPlugins()).toArray()));
	}
}

