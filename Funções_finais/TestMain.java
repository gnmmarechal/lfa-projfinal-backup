import java.util.*;
public class TestMain {
	
	public static void main (String[] args) {
		Plugin cropPlugin = new CropPlugin();
		System.out.println("Function Name: " + cropPlugin.getFunctionName());
		System.out.println("Argument Count: " + cropPlugin.getFunctionArgumentCount());
		System.out.println("Arguments: " + Arrays.toString(cropPlugin.getFunctionArguments()));
		System.out.println("Dependencies: " + Arrays.toString(cropPlugin.getFunctionDependencies()));
		System.out.println("Function Body:\n" + cropPlugin.getFunction());
	}
}

