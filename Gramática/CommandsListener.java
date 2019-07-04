// Generated from Commands.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CommandsParser}.
 */
public interface CommandsListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CommandsParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(CommandsParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link CommandsParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(CommandsParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by {@link CommandsParser#movie}.
	 * @param ctx the parse tree
	 */
	void enterMovie(CommandsParser.MovieContext ctx);
	/**
	 * Exit a parse tree produced by {@link CommandsParser#movie}.
	 * @param ctx the parse tree
	 */
	void exitMovie(CommandsParser.MovieContext ctx);
	/**
	 * Enter a parse tree produced by {@link CommandsParser#open}.
	 * @param ctx the parse tree
	 */
	void enterOpen(CommandsParser.OpenContext ctx);
	/**
	 * Exit a parse tree produced by {@link CommandsParser#open}.
	 * @param ctx the parse tree
	 */
	void exitOpen(CommandsParser.OpenContext ctx);
	/**
	 * Enter a parse tree produced by {@link CommandsParser#save}.
	 * @param ctx the parse tree
	 */
	void enterSave(CommandsParser.SaveContext ctx);
	/**
	 * Exit a parse tree produced by {@link CommandsParser#save}.
	 * @param ctx the parse tree
	 */
	void exitSave(CommandsParser.SaveContext ctx);
	/**
	 * Enter a parse tree produced by {@link CommandsParser#show}.
	 * @param ctx the parse tree
	 */
	void enterShow(CommandsParser.ShowContext ctx);
	/**
	 * Exit a parse tree produced by {@link CommandsParser#show}.
	 * @param ctx the parse tree
	 */
	void exitShow(CommandsParser.ShowContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Gray}
	 * labeled alternative in {@link CommandsParser#function}.
	 * @param ctx the parse tree
	 */
	void enterGray(CommandsParser.GrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Gray}
	 * labeled alternative in {@link CommandsParser#function}.
	 * @param ctx the parse tree
	 */
	void exitGray(CommandsParser.GrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link CommandsParser#function}.
	 * @param ctx the parse tree
	 */
	void enterVariable(CommandsParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link CommandsParser#function}.
	 * @param ctx the parse tree
	 */
	void exitVariable(CommandsParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Argument}
	 * labeled alternative in {@link CommandsParser#function}.
	 * @param ctx the parse tree
	 */
	void enterArgument(CommandsParser.ArgumentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Argument}
	 * labeled alternative in {@link CommandsParser#function}.
	 * @param ctx the parse tree
	 */
	void exitArgument(CommandsParser.ArgumentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Rotate}
	 * labeled alternative in {@link CommandsParser#function}.
	 * @param ctx the parse tree
	 */
	void enterRotate(CommandsParser.RotateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Rotate}
	 * labeled alternative in {@link CommandsParser#function}.
	 * @param ctx the parse tree
	 */
	void exitRotate(CommandsParser.RotateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Brightness}
	 * labeled alternative in {@link CommandsParser#function}.
	 * @param ctx the parse tree
	 */
	void enterBrightness(CommandsParser.BrightnessContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Brightness}
	 * labeled alternative in {@link CommandsParser#function}.
	 * @param ctx the parse tree
	 */
	void exitBrightness(CommandsParser.BrightnessContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Saturation}
	 * labeled alternative in {@link CommandsParser#function}.
	 * @param ctx the parse tree
	 */
	void enterSaturation(CommandsParser.SaturationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Saturation}
	 * labeled alternative in {@link CommandsParser#function}.
	 * @param ctx the parse tree
	 */
	void exitSaturation(CommandsParser.SaturationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Resize}
	 * labeled alternative in {@link CommandsParser#function}.
	 * @param ctx the parse tree
	 */
	void enterResize(CommandsParser.ResizeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Resize}
	 * labeled alternative in {@link CommandsParser#function}.
	 * @param ctx the parse tree
	 */
	void exitResize(CommandsParser.ResizeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Scale}
	 * labeled alternative in {@link CommandsParser#function}.
	 * @param ctx the parse tree
	 */
	void enterScale(CommandsParser.ScaleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Scale}
	 * labeled alternative in {@link CommandsParser#function}.
	 * @param ctx the parse tree
	 */
	void exitScale(CommandsParser.ScaleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Extract}
	 * labeled alternative in {@link CommandsParser#function}.
	 * @param ctx the parse tree
	 */
	void enterExtract(CommandsParser.ExtractContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Extract}
	 * labeled alternative in {@link CommandsParser#function}.
	 * @param ctx the parse tree
	 */
	void exitExtract(CommandsParser.ExtractContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Difference}
	 * labeled alternative in {@link CommandsParser#function}.
	 * @param ctx the parse tree
	 */
	void enterDifference(CommandsParser.DifferenceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Difference}
	 * labeled alternative in {@link CommandsParser#function}.
	 * @param ctx the parse tree
	 */
	void exitDifference(CommandsParser.DifferenceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SaveImage}
	 * labeled alternative in {@link CommandsParser#function}.
	 * @param ctx the parse tree
	 */
	void enterSaveImage(CommandsParser.SaveImageContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SaveImage}
	 * labeled alternative in {@link CommandsParser#function}.
	 * @param ctx the parse tree
	 */
	void exitSaveImage(CommandsParser.SaveImageContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Imagem}
	 * labeled alternative in {@link CommandsParser#function}.
	 * @param ctx the parse tree
	 */
	void enterImagem(CommandsParser.ImagemContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Imagem}
	 * labeled alternative in {@link CommandsParser#function}.
	 * @param ctx the parse tree
	 */
	void exitImagem(CommandsParser.ImagemContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Edges}
	 * labeled alternative in {@link CommandsParser#function}.
	 * @param ctx the parse tree
	 */
	void enterEdges(CommandsParser.EdgesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Edges}
	 * labeled alternative in {@link CommandsParser#function}.
	 * @param ctx the parse tree
	 */
	void exitEdges(CommandsParser.EdgesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Contrast}
	 * labeled alternative in {@link CommandsParser#function}.
	 * @param ctx the parse tree
	 */
	void enterContrast(CommandsParser.ContrastContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Contrast}
	 * labeled alternative in {@link CommandsParser#function}.
	 * @param ctx the parse tree
	 */
	void exitContrast(CommandsParser.ContrastContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Crop}
	 * labeled alternative in {@link CommandsParser#function}.
	 * @param ctx the parse tree
	 */
	void enterCrop(CommandsParser.CropContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Crop}
	 * labeled alternative in {@link CommandsParser#function}.
	 * @param ctx the parse tree
	 */
	void exitCrop(CommandsParser.CropContext ctx);
	/**
	 * Enter a parse tree produced by the {@code OpenImage}
	 * labeled alternative in {@link CommandsParser#function}.
	 * @param ctx the parse tree
	 */
	void enterOpenImage(CommandsParser.OpenImageContext ctx);
	/**
	 * Exit a parse tree produced by the {@code OpenImage}
	 * labeled alternative in {@link CommandsParser#function}.
	 * @param ctx the parse tree
	 */
	void exitOpenImage(CommandsParser.OpenImageContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Contour}
	 * labeled alternative in {@link CommandsParser#function}.
	 * @param ctx the parse tree
	 */
	void enterContour(CommandsParser.ContourContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Contour}
	 * labeled alternative in {@link CommandsParser#function}.
	 * @param ctx the parse tree
	 */
	void exitContour(CommandsParser.ContourContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ShowImage}
	 * labeled alternative in {@link CommandsParser#function}.
	 * @param ctx the parse tree
	 */
	void enterShowImage(CommandsParser.ShowImageContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ShowImage}
	 * labeled alternative in {@link CommandsParser#function}.
	 * @param ctx the parse tree
	 */
	void exitShowImage(CommandsParser.ShowImageContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Blur}
	 * labeled alternative in {@link CommandsParser#function}.
	 * @param ctx the parse tree
	 */
	void enterBlur(CommandsParser.BlurContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Blur}
	 * labeled alternative in {@link CommandsParser#function}.
	 * @param ctx the parse tree
	 */
	void exitBlur(CommandsParser.BlurContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Zoom}
	 * labeled alternative in {@link CommandsParser#function}.
	 * @param ctx the parse tree
	 */
	void enterZoom(CommandsParser.ZoomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Zoom}
	 * labeled alternative in {@link CommandsParser#function}.
	 * @param ctx the parse tree
	 */
	void exitZoom(CommandsParser.ZoomContext ctx);
}