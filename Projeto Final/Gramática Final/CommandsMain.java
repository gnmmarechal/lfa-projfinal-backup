import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.Arrays;

public class CommandsMain {

   public static void main(String[] args) throws Exception {

      LFACodeGenerator cg = new LFACodeGenerator();
      
      // create a CharStream that reads from standard input:
      CharStream input = CharStreams.fromStream(System.in);
      // create a lexer that feeds off of input CharStream:
      CommandsLexer lexer = new CommandsLexer(input);
      // create a buffer of tokens pulled from the lexer:
      CommonTokenStream tokens = new CommonTokenStream(lexer);
      // create a parser that feeds off the tokens buffer:
      CommandsParser parser = new CommandsParser(tokens);
      // replace error listener:
      //parser.removeErrorListeners(); // remove ConsoleErrorListener
      //parser.addErrorListener(new ErrorHandlingListener());
      // begin parsing at program rule:
      ParseTree tree = parser.program();
      if (parser.getNumberOfSyntaxErrors() == 0) {
         // print LISP-style tree:
         // System.out.println(tree.toStringTree(parser));
         ParseTreeWalker walker = new ParseTreeWalker();
         mylistener listener0 = new mylistener(cg);
         walker.walk(listener0, tree);
         //RefPhase ref = new RefPhase(listener0.globals, listener0.scopes);
         //walker.walk(ref, tree);
        
      }
   }
}
