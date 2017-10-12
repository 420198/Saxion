import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sklar on 2/17/2017.
 */
public class DutchJava {

    /**
     * Evaluator
     *
     * @param filename file to be written to
     * @throws IOException
     * @throws InterruptedException
     */
    private static void evaluate(String filename) throws IOException, InterruptedException {
        // Create input stream
        ANTLRInputStream inputStream = new ANTLRFileStream(filename);

        // Create lexer
        DutchJavaLexer lexer = new DutchJavaLexer(inputStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // Create parser
        DutchJavaParser parser = new DutchJavaParser(tokens);
        ParseTree tree = parser.parse(); // begin parsing at expression rule

        // Scope and type checking
        ScopeTypeChecker scopeTypeChecker = new ScopeTypeChecker();
        scopeTypeChecker.visit(tree);

        // Create jasmin file
        String jasminFile = filename.substring(0, filename.length() - 5) + ".jasmin";

        // Code generation
        CodeGenerator codeGenerator = new CodeGenerator(jasminFile, scopeTypeChecker.getScopeTree(), scopeTypeChecker.getVarMethTree(), scopeTypeChecker.getValExprTypeTree(), scopeTypeChecker.getGlobalScope());
        codeGenerator.visit(tree);
        codeGenerator.getPrintWriter().flush();
        codeGenerator.getPrintWriter().close();

        // Process builder
        List<String> commands = new ArrayList<>();
        commands.add("java");
        commands.add("-jar");
        commands.add("jasmin.jar");
        commands.add("-g");
        commands.add(jasminFile);

        ProcessBuilder pb = new ProcessBuilder(commands);
        Process intermediaryProcess = pb.start();
        int intermediaryExitCode = intermediaryProcess.waitFor();

        System.exit(intermediaryExitCode);
    }

    /**
     * Main
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        try {
            evaluate("WorkingFile2.djpp");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
