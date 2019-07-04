// Generated from Commands.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CommandsParser}.
 */
public interface CommandsListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CommandsParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(CommandsParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link CommandsParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(CommandsParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link CommandsParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(CommandsParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CommandsParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(CommandsParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CommandsParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterInstruction(CommandsParser.InstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CommandsParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitInstruction(CommandsParser.InstructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CommandsParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(CommandsParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link CommandsParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(CommandsParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link CommandsParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(CommandsParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link CommandsParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(CommandsParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link CommandsParser#writing}.
	 * @param ctx the parse tree
	 */
	void enterWriting(CommandsParser.WritingContext ctx);
	/**
	 * Exit a parse tree produced by {@link CommandsParser#writing}.
	 * @param ctx the parse tree
	 */
	void exitWriting(CommandsParser.WritingContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SaveImage}
	 * labeled alternative in {@link CommandsParser#operation}.
	 * @param ctx the parse tree
	 */
	void enterSaveImage(CommandsParser.SaveImageContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SaveImage}
	 * labeled alternative in {@link CommandsParser#operation}.
	 * @param ctx the parse tree
	 */
	void exitSaveImage(CommandsParser.SaveImageContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ShowImage}
	 * labeled alternative in {@link CommandsParser#operation}.
	 * @param ctx the parse tree
	 */
	void enterShowImage(CommandsParser.ShowImageContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ShowImage}
	 * labeled alternative in {@link CommandsParser#operation}.
	 * @param ctx the parse tree
	 */
	void exitShowImage(CommandsParser.ShowImageContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Gray}
	 * labeled alternative in {@link CommandsParser#operation}.
	 * @param ctx the parse tree
	 */
	void enterGray(CommandsParser.GrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Gray}
	 * labeled alternative in {@link CommandsParser#operation}.
	 * @param ctx the parse tree
	 */
	void exitGray(CommandsParser.GrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Blur}
	 * labeled alternative in {@link CommandsParser#operation}.
	 * @param ctx the parse tree
	 */
	void enterBlur(CommandsParser.BlurContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Blur}
	 * labeled alternative in {@link CommandsParser#operation}.
	 * @param ctx the parse tree
	 */
	void exitBlur(CommandsParser.BlurContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Crop}
	 * labeled alternative in {@link CommandsParser#operation}.
	 * @param ctx the parse tree
	 */
	void enterCrop(CommandsParser.CropContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Crop}
	 * labeled alternative in {@link CommandsParser#operation}.
	 * @param ctx the parse tree
	 */
	void exitCrop(CommandsParser.CropContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Zoom}
	 * labeled alternative in {@link CommandsParser#operation}.
	 * @param ctx the parse tree
	 */
	void enterZoom(CommandsParser.ZoomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Zoom}
	 * labeled alternative in {@link CommandsParser#operation}.
	 * @param ctx the parse tree
	 */
	void exitZoom(CommandsParser.ZoomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Brightness}
	 * labeled alternative in {@link CommandsParser#operation}.
	 * @param ctx the parse tree
	 */
	void enterBrightness(CommandsParser.BrightnessContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Brightness}
	 * labeled alternative in {@link CommandsParser#operation}.
	 * @param ctx the parse tree
	 */
	void exitBrightness(CommandsParser.BrightnessContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Edges}
	 * labeled alternative in {@link CommandsParser#operation}.
	 * @param ctx the parse tree
	 */
	void enterEdges(CommandsParser.EdgesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Edges}
	 * labeled alternative in {@link CommandsParser#operation}.
	 * @param ctx the parse tree
	 */
	void exitEdges(CommandsParser.EdgesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Contrast}
	 * labeled alternative in {@link CommandsParser#operation}.
	 * @param ctx the parse tree
	 */
	void enterContrast(CommandsParser.ContrastContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Contrast}
	 * labeled alternative in {@link CommandsParser#operation}.
	 * @param ctx the parse tree
	 */
	void exitContrast(CommandsParser.ContrastContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Rotate}
	 * labeled alternative in {@link CommandsParser#operation}.
	 * @param ctx the parse tree
	 */
	void enterRotate(CommandsParser.RotateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Rotate}
	 * labeled alternative in {@link CommandsParser#operation}.
	 * @param ctx the parse tree
	 */
	void exitRotate(CommandsParser.RotateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Scale}
	 * labeled alternative in {@link CommandsParser#operation}.
	 * @param ctx the parse tree
	 */
	void enterScale(CommandsParser.ScaleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Scale}
	 * labeled alternative in {@link CommandsParser#operation}.
	 * @param ctx the parse tree
	 */
	void exitScale(CommandsParser.ScaleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Resize}
	 * labeled alternative in {@link CommandsParser#operation}.
	 * @param ctx the parse tree
	 */
	void enterResize(CommandsParser.ResizeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Resize}
	 * labeled alternative in {@link CommandsParser#operation}.
	 * @param ctx the parse tree
	 */
	void exitResize(CommandsParser.ResizeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Extract}
	 * labeled alternative in {@link CommandsParser#operation}.
	 * @param ctx the parse tree
	 */
	void enterExtract(CommandsParser.ExtractContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Extract}
	 * labeled alternative in {@link CommandsParser#operation}.
	 * @param ctx the parse tree
	 */
	void exitExtract(CommandsParser.ExtractContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Contour}
	 * labeled alternative in {@link CommandsParser#operation}.
	 * @param ctx the parse tree
	 */
	void enterContour(CommandsParser.ContourContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Contour}
	 * labeled alternative in {@link CommandsParser#operation}.
	 * @param ctx the parse tree
	 */
	void exitContour(CommandsParser.ContourContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Difference}
	 * labeled alternative in {@link CommandsParser#operation}.
	 * @param ctx the parse tree
	 */
	void enterDifference(CommandsParser.DifferenceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Difference}
	 * labeled alternative in {@link CommandsParser#operation}.
	 * @param ctx the parse tree
	 */
	void exitDifference(CommandsParser.DifferenceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Convert}
	 * labeled alternative in {@link CommandsParser#operation}.
	 * @param ctx the parse tree
	 */
	void enterConvert(CommandsParser.ConvertContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Convert}
	 * labeled alternative in {@link CommandsParser#operation}.
	 * @param ctx the parse tree
	 */
	void exitConvert(CommandsParser.ConvertContext ctx);
	/**
	 * Enter a parse tree produced by {@link CommandsParser#forcycle}.
	 * @param ctx the parse tree
	 */
	void enterForcycle(CommandsParser.ForcycleContext ctx);
	/**
	 * Exit a parse tree produced by {@link CommandsParser#forcycle}.
	 * @param ctx the parse tree
	 */
	void exitForcycle(CommandsParser.ForcycleContext ctx);
}