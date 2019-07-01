import org.stringtemplate.v4.*;
import java.util.*;

public class LFACodeGenerator
{
	private static String cropFunction = new ST(
	"def crop(image, r0, r1, r2, r3):\n" +
	"	r = cv2.selectROI(image"
	);
	public static String requireFunction(String functionName, List<String> functionArgs)
	{
		ST template;
		
		switch (String functionName)
		{
			case "crop":
				template = cropTemplate;
				break;
			default:
				break;
		}
	}
	
}