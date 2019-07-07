import java.util.HashMap;
import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class mylistener extends CommandsBaseListener {
    
    int repeatvalue = 0;
    HashMap<String,String> values = new HashMap<String,String>(); 
    private LFACodeGenerator cg;

    public mylistener(LFACodeGenerator cg){
        super();
        this.cg = cg;
    }

    @Override public void exitProgram(CommandsParser.ProgramContext ctx) 
    { 
        System.out.println(cg.generateCode());
    }

    @Override public void exitGray(CommandsParser.GrayContext ctx) 
    {   
        do{
            try
            {
                String x = ctx.IMAGE().getText();
                File f = new File(x);
                if(f.exists() && !f.isDirectory()) { 
                    cg.callFunction("gray",x);
                }
                else{System.out.println(ctx.IMAGE().getText() + " is not a valid image");
                    System.exit(0);}
            }
            catch (Exception e)
            {
            }
            try
            {
                String x = ctx.ID().getText();
                String y = values.get(x);
                File f = new File(y);
                if(f.exists() && !f.isDirectory()) { 
                    cg.callFunction("gray",y);
                }
                else{System.out.println(ctx.ID().getText() + " is not a valid image!");
                    System.exit(0);}
            }  
            catch (Exception e)
            {
            }
            System.out.println("Falhou! Comando Inválido");
            repeatvalue = repeatvalue -1;
        }while(repeatvalue>-1);
        
    }
    
    @Override public void exitBlur(CommandsParser.BlurContext ctx) { 


        do{
            String num = ctx.NUM().getText();
            try
            {   
                String x = ctx.IMAGE().getText();
                List<String> lista = new LinkedList<String>();
                lista.add(num);
                lista.add(x);
                File f = new File(x);
                if(f.exists() && !f.isDirectory()) { 
                    cg.callFunction("blur",lista);
                }
                else{System.out.println(ctx.IMAGE().getText() + " is not a valid image");
                    System.exit(0);}
            }
            catch (Exception e)
            {
            }
            try
            {
                String x = ctx.ID().getText();
                String y = values.get(x);
                List<String> lista = new LinkedList<String>();
                lista.add(num);
                lista.add(y);
                File f = new File(y);
                if(f.exists() && !f.isDirectory()) { 
                   cg.callFunction("blur",lista);
                }
                else{System.out.println(ctx.ID().getText() + " is not a valid image!");
                    System.exit(0);}
            }  
            catch (Exception e)
            {
            }
            System.out.println("Falhou! Comando Inválido");
            repeatvalue = repeatvalue -1;
        }while(repeatvalue>-1);
    }
    @Override public void exitCrop(CommandsParser.CropContext ctx) { 

        do{
            String num0 = ctx.NUM(0).getText();
            String num1 = ctx.NUM(1).getText();
            String num2 = ctx.NUM(2).getText();
            String num3 = ctx.NUM(3).getText();

            try
            {
                String x = ctx.IMAGE().getText();
                List<String> lista = new LinkedList<String>();
                lista.add(num0);
                lista.add(num1);
                lista.add(num2);
                lista.add(num3);
                lista.add(x);
                File f = new File(x);
                if(f.exists() && !f.isDirectory()) { 
                    cg.callFunction("crop",lista);
                }
                else{System.out.println(ctx.IMAGE().getText() + " is not a valid image");
                    System.exit(0);}
            }
            catch (Exception e)
            {
            }
            try
            {
                String x = ctx.ID().getText();
                String y = values.get(x);
                List<String> lista = new LinkedList<String>();
                lista.add(num0);
                lista.add(num1);
                lista.add(num2);
                lista.add(num3);
                lista.add(y);
                File f = new File(y);
                if(f.exists() && !f.isDirectory()) { 
                    cg.callFunction("crop",lista);
                }
                else{System.out.println(ctx.ID().getText() + " is not a valid image!");
                    System.exit(0);}
            }  
            catch (Exception e)
            {
            }
            System.out.println("Falhou! Comando Inválido");
            repeatvalue = repeatvalue -1;
        }while(repeatvalue>-1);
    }
    @Override public void exitBrightness(CommandsParser.BrightnessContext ctx) { 

        do{
            String num = ctx.NUM().getText();
            try
            {
                String x = ctx.IMAGE().getText();
                List<String> lista = new LinkedList<String>();
                lista.add(num);
                lista.add(x);
                File f = new File(x);
                if(f.exists() && !f.isDirectory()) { 
                    cg.callFunction("brightness",lista);
                }
                else{System.out.println(ctx.IMAGE().getText() + " is not a valid image");
                    System.exit(0);}
            }
            catch (Exception e)
            {
            }
            try
            {
                String x = ctx.ID().getText();
                String y = values.get(x);
                List<String> lista = new LinkedList<String>();
                lista.add(num);
                lista.add(y);
                File f = new File(y);
                if(f.exists() && !f.isDirectory()) { 
                    cg.callFunction("brightness",lista);
                }
                else{System.out.println(ctx.ID().getText() + " is not a valid image!");
                    System.exit(0);}
            }  
            catch (Exception e)
            {
            }
            System.out.println("Falhou! Comando Inválido");
            repeatvalue = repeatvalue -1;
        }while(repeatvalue>-1);
    }
    @Override public void exitEdges(CommandsParser.EdgesContext ctx) {

        do{
            try
            {
                String x = ctx.IMAGE().getText();
                File f = new File(x);
                if(f.exists() && !f.isDirectory()) { 
                    cg.callFunction("edges",x);
                }
                else{System.out.println(ctx.IMAGE().getText() + " is not a valid image");
                    System.exit(0);}
            }
            catch (Exception e)
            {
            }
            try
            {
                String x = ctx.ID().getText();
                String y = values.get(x);
                File f = new File(y);
                if(f.exists() && !f.isDirectory()) { 
                    cg.callFunction("edges",y);
                }
                else{System.out.println(ctx.ID().getText() + " is not a valid image!");
                    System.exit(0);}
            }  
            catch (Exception e)
            {
            }
            System.out.println("Falhou! Comando Inválido");
            repeatvalue = repeatvalue -1;
        }while(repeatvalue>-1);
     }
    @Override public void exitContrast(CommandsParser.ContrastContext ctx) { 

        do{
            String num = ctx.NUM().getText();
            try
            {
                String x = ctx.IMAGE().getText();
                List<String> lista = new LinkedList<String>();
                lista.add(num);
                lista.add(x);
                File f = new File(x);

                if(f.exists() && !f.isDirectory()) { 
                    cg.callFunction("contrast",lista);
                }
                else{System.out.println(ctx.IMAGE().getText() + " is not a valid image");
                    System.exit(0);}
            }
            catch (Exception e)
            {
            }
            try
            {
                String x = ctx.ID().getText();
                String y = values.get(x);
                List<String> lista = new LinkedList<String>();
                lista.add(num);
                lista.add(y);
                File f = new File(y);
                if(f.exists() && !f.isDirectory()) { 
                    cg.callFunction("contrast",lista);
                }
                else{System.out.println(ctx.ID().getText() + " is not a valid image!");
                    System.exit(0);}
            }  
            catch (Exception e)
            {
            }
            System.out.println("Falhou! Comando Inválido");
            repeatvalue = repeatvalue -1;
        }while(repeatvalue>-1);
    }
    @Override public void exitRotate(CommandsParser.RotateContext ctx) { 

        do{
            String num = ctx.NUM().getText();
            try
            {
                String x = ctx.IMAGE().getText();
                List<String> lista = new LinkedList<String>();
                lista.add(num);
                lista.add(x);
                File f = new File(x);
                if(f.exists() && !f.isDirectory()) { 
                    cg.callFunction("rotate",lista);
                }
                else{System.out.println(ctx.IMAGE().getText() + " is not a valid image");
                    System.exit(0);}
            }
            catch (Exception e)
            {
            }
            try
            {
                String x = ctx.ID().getText();
                String y = values.get(x);
                List<String> lista = new LinkedList<String>();
                lista.add(num);
                lista.add(y);
                File f = new File(y);
                if(f.exists() && !f.isDirectory()) { 
                    cg.callFunction("rotate",lista);
                }
                else{System.out.println(ctx.ID().getText() + " is not a valid image!");
                    System.exit(0);}
            }  
            catch (Exception e)
            {
            }
            System.out.println("Falhou! Comando Inválido");
            repeatvalue = repeatvalue -1;
        }while(repeatvalue>-1);
    }
    @Override public void exitScale(CommandsParser.ScaleContext ctx) { 

        do{
            String num = ctx.NUM().getText();
            try
            {
                String x = ctx.IMAGE().getText();
                List<String> lista = new LinkedList<String>();
                lista.add(num);
                lista.add(x);
                File f = new File(x);
                if(f.exists() && !f.isDirectory()) { 
                    cg.callFunction("scale",lista);
                }
                else{System.out.println(ctx.IMAGE().getText() + " is not a valid image");
                    System.exit(0);}
            }
            catch (Exception e)
            {
            }
            try
            {
                String x = ctx.ID().getText();
                String y = values.get(x);
                List<String> lista = new LinkedList<String>();
                lista.add(num);
                lista.add(y);
                File f = new File(y);
                if(f.exists() && !f.isDirectory()) { 
                    System.out.println(cg.callFunction("scale",lista));
                }
                else{System.out.println(ctx.ID().getText() + " is not a valid image!");
                    System.exit(0);}
            }  
            catch (Exception e)
            {
            }
            System.out.println("Falhou! Comando Inválido");
            repeatvalue = repeatvalue -1;
        }while(repeatvalue>-1);
    }
    @Override public void exitResize(CommandsParser.ResizeContext ctx) { 

        do{
            String num0 = ctx.NUM(0).getText();
            String num1 = ctx.NUM(1).getText();
            try
            {
                String x = ctx.IMAGE().getText();
                List<String> lista = new LinkedList<String>();
                lista.add(num0);
                lista.add(num1);
                lista.add(x);
                File f = new File(x);
                if(f.exists() && !f.isDirectory()) { 
                    cg.callFunction("resize",lista);
                }
                else{System.out.println(ctx.IMAGE().getText() + " is not a valid image");
                    System.exit(0);}
            }
            catch (Exception e)
            {
            }
            try
            {
                String x = ctx.ID().getText();
                String y = values.get(x);
                List<String> lista = new LinkedList<String>();
                lista.add(num0);
                lista.add(num1);
                lista.add(y);
                File f = new File(y);
                if(f.exists() && !f.isDirectory()) { 
                    System.out.println(cg.callFunction("resize",lista));
                }
                else{System.out.println(ctx.ID().getText() + " is not a valid image!");
                    System.exit(0);}
            }  
            catch (Exception e)
            {
            }
            System.out.println("Falhou! Comando Inválido");
            repeatvalue = repeatvalue -1;
        }while(repeatvalue>-1);
    }
    @Override public void exitExtract(CommandsParser.ExtractContext ctx) {
        do{
            try
            {
                String x = ctx.IMAGE().getText();
                File f = new File(x);
                if(f.exists() && !f.isDirectory()) { 
                    cg.callFunction("extract",x);
                }
                else{System.out.println(ctx.IMAGE().getText() + " is not a valid image");
                    System.exit(0);}
            }
            catch (Exception e)
            {
            }
            try
            {
                String x = ctx.ID().getText();
                String y = values.get(x);
                File f = new File(y);
                if(f.exists() && !f.isDirectory()) { 
                    System.out.println(cg.callFunction("extract",y));
                }
                else{System.out.println(ctx.ID().getText() + " is not a valid image!");
                    System.exit(0);}
            }  
            catch (Exception e)
            {
            }
            System.out.println("Falhou! Comando Inválido");
            repeatvalue = repeatvalue -1;
        }while(repeatvalue>-1);
     }
    @Override public void exitDifference(CommandsParser.DifferenceContext ctx) {
        do{
            try
            {
                String x = ctx.ID(0).getText();
                String y = ctx.ID(1).getText();
                String z0 = values.get(x);
                String z1 = values.get(y);
                List<String> lista = new LinkedList<String>();
                lista.add(z0);
                lista.add(z1);
                File f0 = new File(z0);
                File f1 = new File(z1);
                if(f0.exists() && !f0.isDirectory() && f1.exists() && !f1.isDirectory()) { 
                    cg.callFunction("difference",lista);
                }
                else{System.out.println(x + " or" + y + " is not a valid image");
                    System.exit(0);}
            }
            catch (Exception e)
            {
            }
            
            
            try
            {
                String x = ctx.IMAGE(0).getText();
                String y = ctx.ID(0).getText();
                String z = values.get(y);
                List<String> lista = new LinkedList<String>();
                lista.add(x);
                lista.add(z);
                File f0 = new File(x);
                File f1 = new File(z);
                if(f0.exists() && !f0.isDirectory() && f1.exists() && !f1.isDirectory()) { 
                    cg.callFunction("difference",lista);
                }
                else{System.out.println(x + " or" + y + " is not a valid image");
                    System.exit(0);}
            }
            catch (Exception e)
            {
            }
            try
            {
                String x = ctx.IMAGE(0).getText();
                String y = ctx.IMAGE(1).getText();
                List<String> lista = new LinkedList<String>();
                lista.add(x);
                lista.add(y);
                File f0 = new File(x);
                File f1 = new File(y);
                if(f0.exists() && !f0.isDirectory() && f1.exists() && !f1.isDirectory()) { 
                    cg.callFunction("difference",lista);
                }
                else{System.out.println(x + " or" + y + " is not a valid image");
                    System.exit(0);}
            }
            catch (Exception e)
            {
            }
            
            System.out.println("Falhou! Comando Inválido");
            repeatvalue = repeatvalue -1;
        }while(repeatvalue>-1);
     }
    @Override public void exitConvert(CommandsParser.ConvertContext ctx) { 
        do{ 
            String num = ctx.NUM().getText();
            try
            {   
                String x = ctx.IMAGE().getText();
                List<String> lista = new LinkedList<String>();
                lista.add(num);
                lista.add(x);
                File f = new File(x);
                if(f.exists() && !f.isDirectory()) { 
                    cg.callFunction("convert",lista);
                }
                else{System.out.println(ctx.IMAGE().getText() + " is not a valid image");
                    System.exit(0);}
            }
            catch (Exception e)
            {
            }
            try
            {
                String x = ctx.ID().getText();
                String y = values.get(x);
                List<String> lista = new LinkedList<String>();
                lista.add(num);
                lista.add(y);
                File f = new File(y);
                if(f.exists() && !f.isDirectory()) { 
                    System.out.println(cg.callFunction("convert",lista));
                }
                else{System.out.println(ctx.ID().getText() + " is not a valid image!");
                    System.exit(0);}
            }  
            catch (Exception e)
            {
            }
            System.out.println("Falhou! Comando Inválido");
            repeatvalue = repeatvalue -1;
        }while(repeatvalue>-1);
    }
    @Override public void exitSaveFile(CommandsParser.SaveFileContext ctx) {
        do{
            try
            {
                String x = ctx.ID().getText();
                File f = new File(x);
                if(f.exists() && !f.isDirectory()) { 
                    cg.callFunction("save",x);
                }
                else{System.out.println(ctx.ID().getText() + " is not a valid image");
                    System.exit(0);} 
            }
            catch (Exception e)
            {
            }
            System.out.println("Falhou! Comando Inválido");
            repeatvalue = repeatvalue -1;
        }while(repeatvalue>-1);
    }
    @Override public void exitShowImage(CommandsParser.ShowImageContext ctx) {
        do{
            try
            {
                String x = ctx.IMAGE().getText();
                File f = new File(x);
                if(f.exists() && !f.isDirectory()) { 
                    cg.callFunction("show",x);
                }
                else{System.out.println(ctx.IMAGE().getText() + " is not a valid image");
                    System.exit(0);}
            }
            catch (Exception e)
            {
            }
            try
            {
                String x = ctx.ID().getText();
                String y = values.get(x);
                File f = new File(y);
                if(f.exists() && !f.isDirectory()) { 
                    System.out.println(cg.callFunction("show",y));
                }
                else{System.out.println(ctx.ID().getText() + " is not a valid image!");
                    System.exit(0);}
            }  
            catch (Exception e)
            {
            }
            System.out.println("Falhou! Comando Inválido");
            repeatvalue = repeatvalue -1;
        }while(repeatvalue>-1);
     }


    @Override public void exitAssignment(CommandsParser.AssignmentContext ctx) { 
        try
            {
                String x = ctx.IMAGE().getText();
                String y = ctx.ID(0).getText();
                File f = new File(x);
                if(f.exists() && !f.isDirectory()) { 
                    values.put(y,x);
                }
                else{System.out.println(ctx.IMAGE().getText() + " is not a valid image");
                    System.exit(0);}
            }
            catch (Exception e)
            {
            }
            try
            {
                String x = ctx.ID(0).getText();
                String y = ctx.ID(1).getText();
                
                if(values.containsKey(y)){
                    String z = values.get(y);
                    values.put(x,y);
                }
                else{System.out.println(ctx.ID(1).getText() + " variable does not exist!");
                    System.exit(0);}
            }  
            catch (Exception e)
            {
            }
            System.out.println("Falhou! Comando Inválido");
            repeatvalue = repeatvalue -1;
    }
    
    @Override public void enterRepeat(CommandsParser.RepeatContext ctx) 
    {
        repeatvalue = Integer.parseInt(ctx.NUM().getText());
    }
	
	@Override public void exitRepeat(CommandsParser.RepeatContext ctx) { 
        repeatvalue = 0;
    }

    /*
	@Override public void enterStatement(CommandsParser.StatementContext ctx) { }
	@Override public void exitStatement(CommandsParser.StatementContext ctx) { }
	@Override public void enterInstruction(CommandsParser.InstructionContext ctx) { }
	@Override public void exitInstruction(CommandsParser.InstructionContext ctx) { 
	@Override public void enterBlock(CommandsParser.BlockContext ctx) { }
	@Override public void exitBlock(CommandsParser.BlockContext ctx) { }
	@Override public void enterAssignment(CommandsParser.AssignmentContext ctx) { }
	@Override public void enterWriting(CommandsParser.WritingContext ctx) { }
	@Override public void exitWriting(CommandsParser.WritingContext ctx) { }
	@Override public void enterWriting2(CommandsParser.Writing2Context ctx) { }
	@Override public void exitWriting2(CommandsParser.Writing2Context ctx) { }
	@Override public void enterGray(CommandsParser.GrayContext ctx) { }
	@Override public void enterBlur(CommandsParser.BlurContext ctx) { }
	@Override public void enterCrop(CommandsParser.CropContext ctx) { }
	@Override public void enterBrightness(CommandsParser.BrightnessContext ctx) { }
	@Override public void enterEdges(CommandsParser.EdgesContext ctx) { }
	@Override public void enterContrast(CommandsParser.ContrastContext ctx) { }
	@Override public void enterRotate(CommandsParser.RotateContext ctx) { }
	@Override public void enterScale(CommandsParser.ScaleContext ctx) { }
	@Override public void enterResize(CommandsParser.ResizeContext ctx) { }
	@Override public void enterExtract(CommandsParser.ExtractContext ctx) { }
	@Override public void enterDifference(CommandsParser.DifferenceContext ctx) { }
	@Override public void enterConvert(CommandsParser.ConvertContext ctx) { }
	@Override public void enterSaveFile(CommandsParser.SaveFileContext ctx) { }
	@Override public void enterShowImage(CommandsParser.ShowImageContext ctx) { }
	@Override public void enterEveryRule(ParserRuleContext ctx) { }
	@Override public void exitEveryRule(ParserRuleContext ctx) { }
	@Override public void visitTerminal(TerminalNode node) { }
    @Override public void visitErrorNode(ErrorNode node) { }
    */

}