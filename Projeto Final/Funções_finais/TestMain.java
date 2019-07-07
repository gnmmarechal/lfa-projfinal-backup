import java.util.*;
public class TestMain {
	
	public static void main (String[] args) throws Exception{
		System.out.println("Basic Plugin Test:\n");
		Plugin cropPlugin = new CropPlugin();
		printSpecs(cropPlugin);
		Plugin cropIntPlugin = new CropIntPlugin();
		printSpecs(cropIntPlugin);
		Plugin rotatePlugin = new RotationPlugin();
		printSpecs(rotatePlugin);
		Plugin savePlugin = new SavePlugin();
		printSpecs(savePlugin);
		Plugin showPlugin = new ShowPlugin();
		printSpecs(showPlugin);
		Plugin grayPlugin = new GrayPlugin();
		printSpecs(grayPlugin);
		Plugin openPlugin = new OpenPlugin();
		printSpecs(openPlugin);
		Plugin blurPlugin = new BlurPlugin();
		printSpecs(blurPlugin);
		Plugin edgePlugin = new EdgesPlugin();
		printSpecs(edgePlugin);
		Plugin resPlugin = new ResizePlugin();
		printSpecs(resPlugin);
		Plugin scaPlugin = new ScalePlugin();
		printSpecs(scaPlugin);
		Plugin extPlugin = new ExtractPlugin();
		printSpecs(extPlugin);
		Plugin difPlugin = new DifferencePlugin();
		printSpecs(difPlugin);
		Plugin colPlugin = new ColoursPlugin();
		printSpecs(colPlugin);
		Plugin briPlugin = new BrightnessPlugin();
		printSpecs(briPlugin);
		Plugin conPlugin = new ContrastPlugin();
		printSpecs(conPlugin);
		Plugin filPlugin = new FilterPlugin();
		printSpecs(filPlugin);
		Plugin convPlugin = new ConvertPlugin();
		printSpecs(convPlugin);
		
		
		System.out.println("Code Generator Test:\n");
		
		LFACodeGenerator codeGen = new LFACodeGenerator();
		
		System.out.println("Loaded plugins: " + Arrays.toString(LFACodeGenerator.getPluginNames(codeGen.getLoadedPlugins()).toArray()));
		
		System.out.println("Used plugins: " + Arrays.toString(LFACodeGenerator.getPluginNames(codeGen.getUsedPlugins()).toArray()));
		
		System.out.println("Requiring crop function...");
		codeGen.requireFunction("crop");
		
		System.out.println("Requiring rotation function...");
		codeGen.requireFunction("rotation");
		
		System.out.println("Requiring save function...");
		codeGen.requireFunction("save");
		
		System.out.println("Requiring show function...");
		codeGen.requireFunction("show");
		
		System.out.println("Requiring gray function...");
		codeGen.requireFunction("gray");
		
		
		System.out.println("Calling function...");
		String[] arg = {"image", "1", "2", "3", "4"};
		System.out.println(codeGen.callFunction("crop", Arrays.asList(arg)));
		
		System.out.println("Setting variable...");
		String[] argss = {"image", "1", "2", "3", "4"};
		System.out.println(codeGen.setVariable("img", "crop", Arrays.asList(argss)));
		
		System.out.println("Used plugins: " + Arrays.toString(LFACodeGenerator.getPluginNames(codeGen.getUsedPlugins()).toArray()));
		
		System.out.println("Current import block:\n" + codeGen.getImportBlock());
		
		System.out.println("Code output:\n" + codeGen.generateCode());
		
	}
	//Função para simplificar o teste
	private static void printSpecs(Plugin p) {
		System.out.println("Function Name: " + p.getFunctionName());
		System.out.println("Argument Count: " + p.getFunctionArgumentCount());
		System.out.println("Arguments: " + Arrays.toString(p.getFunctionArguments()));
		System.out.println("Dependencies: " + Arrays.toString(p.getFunctionDependencies()));
		System.out.println("Function Body:\n" + p.getFunction() + "\n");
	}
}


