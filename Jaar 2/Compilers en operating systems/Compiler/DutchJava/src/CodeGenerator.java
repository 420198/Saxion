import Model.*;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by thama on 13-6-2017.
 */
public class CodeGenerator extends DutchJavaBaseVisitor {
    /**
     * Global scope
     */
    private Scope globalScope;

    /**
     * Our print writer
     */
    private PrintWriter printWriter;

    /**
     * The parse trees
     */
    private ParseTreeProperty parseTreeProperty;
    private ParseTreeProperty varMethTree;
    private ParseTreeProperty valExprTypeTree;

    /**
     * The filename
     */
    private String filename;

    /**
     * Schrijf expressie (for printing bool expressions)
     */
    private int schrijfExpr = 0;

    /**
     * Our latest called value expression
     */
    private ValueExpression latestExpression;

    /**
     * Our latest called is reken symbol
     */
    private Symbol isRekenSymbol = null;

    /**
     * Constructor for the code generator
     *
     * @param fileName          file name to be written too
     * @param parseTreeProperty scope tree
     * @param varMethTree       variable and method tree
     * @param valExprTypeTree   int/float expressions
     * @param globalScope       globalscope
     * @throws IOException
     */
    public CodeGenerator(String fileName, ParseTreeProperty parseTreeProperty, ParseTreeProperty varMethTree, ParseTreeProperty valExprTypeTree, Scope globalScope) throws IOException {
        this.globalScope = globalScope;

        this.varMethTree = varMethTree;
        this.valExprTypeTree = valExprTypeTree;
        this.parseTreeProperty = parseTreeProperty;

        this.filename = fileName.substring(0, fileName.length() - 7);

        printWriter = new PrintWriter(fileName, "UTF-8");
        printWriter.println(".class public " + this.filename
                + "\r\n.super java/lang/Object" +
                "\r\n\r\n.method public <init>()V" +
                "\r\n\t.limit stack 5" +
                "\r\n\t.limit locals 1" +
                "\r\n\taload_0" +
                "\r\n\tinvokespecial java/lang/Object/<init>()V" +
                "\r\n\treturn" +
                "\r\n.end method\r\n");
    }

    /**
     * Visitor for parse, prints "run" method to the file
     *
     * @param ctx context
     * @return null
     */
    @Override
    public Object visitParse(DutchJavaParser.ParseContext ctx) {
        printWriter.println(".method public static main([Ljava/lang/String;)V");
        printWriter.println("\t.limit stack 5");
        printWriter.println("\t.limit locals 1");
        printWriter.println("\r\n\taload 0");
        printWriter.println("\r\n\tnew " + filename);
        printWriter.println("\tdup");
        printWriter.println("\tinvokespecial " + filename + "/<init>()V");
        printWriter.println("\tinvokespecial " + filename + "/startpunt()V");
        printWriter.println("\r\n\treturn");
        printWriter.println(".end method");

        printWriter.println("\r\n.method public startpunt()V");
        printWriter.println("\t.limit stack " + (globalScope.getLocalStack() + 1));
        printWriter.println("\t.limit locals " + (globalScope.getLocalAmount()) + "\r\n");
        visitChildren(ctx.blok());
        printWriter.println("\r\n\treturn");
        printWriter.println(".end method\r\n");
        if (ctx.methodeUITVOERING() != null) {
            for (int i = 0; i < ctx.methodeUITVOERING().size(); i++) {
                visit(ctx.methodeUITVOERING(i));
                printWriter.println("");
            }
        }
        return null;
    }

    /**
     * Visitor for statement blok
     *
     * @param ctx context
     * @return null
     */
    @Override
    public Object visitStatementBlok(DutchJavaParser.StatementBlokContext ctx) {
        visitChildren(ctx);
        return null;
    }

    /**
     * Visitor method for minminplusplus
     *
     * @param ctx context
     * @return null
     */
    @Override
    public Object visitMinminPlusPlusExpr(DutchJavaParser.MinminPlusPlusExprContext ctx) {
        Symbol s = (Symbol) varMethTree.get(ctx);
        if (s.getType() == Type.INT) {
            if (ctx.op.getText().equals("--")) {
                printWriter.println("\tiinc " + s.getPosition() + " -1");
            } else {
                printWriter.println("\tiinc " + s.getPosition() + " 1");
            }
        } else {
            if (ctx.op.getText().equals("--")) {
                printWriter.println("\tfload " + s.getPosition());
                printWriter.println("\tfconst_1");
                printWriter.println("\tfsub");
            } else {
                printWriter.println("\tfload " + s.getPosition());
                printWriter.println("\tfconst_1");
                printWriter.println("\tfadd");
            }
            printWriter.println("\tfstore " + s.getPosition());
        }
        return null;
    }

    /**
     * Visitor for plus min expr
     *
     * @param ctx context
     * @return null
     */
    @Override
    public Object visitPlusMinExpr(DutchJavaParser.PlusMinExprContext ctx) {
        this.latestExpression = (ValueExpression) valExprTypeTree.get(ctx);
        Type left = (Type) visitChildren(ctx.leftExpr);
        if (this.latestExpression.getExpressionType() == Type.FLOAT && left == Type.INT) {
            printWriter.println("\ti2f");
        }
        Type right = (Type) visitChildren(ctx.rightExpr);
        if (this.latestExpression.getExpressionType() == Type.FLOAT && right == Type.INT) {
            printWriter.println("\ti2f");
        }
        if (ctx.op.getText().equals("+")) {
            if (this.latestExpression.getExpressionType() == Type.FLOAT) {
                printWriter.println("\tfadd");
            } else {
                printWriter.println("\tiadd");
            }
        } else {
            if (this.latestExpression.getExpressionType() == Type.FLOAT) {
                printWriter.println("\tfsub");
            } else {
                printWriter.println("\tisub");
            }
        }
        return null;
    }

    /**
     * Visitor for keer gedeelddoor modulo expr
     *
     * @param ctx context
     * @return null
     */
    @Override
    public Object visitKeerGddModExpr(DutchJavaParser.KeerGddModExprContext ctx) {
        this.latestExpression = (ValueExpression) valExprTypeTree.get(ctx);
        Type left = (Type) visitChildren(ctx.leftExpr);
        if (this.latestExpression.getExpressionType() == Type.FLOAT && left == Type.INT) {
            printWriter.println("\ti2f");
        }
        Type right = (Type) visitChildren(ctx.rightExpr);
        if (this.latestExpression.getExpressionType() == Type.FLOAT && right == Type.INT) {
            printWriter.println("\ti2f");
        }
        if (ctx.op.getText().equals("*")) {
            if (this.latestExpression.getExpressionType() == Type.FLOAT) {
                printWriter.println("\tfmul");
            } else {
                printWriter.println("\timul");
            }
        } else if (ctx.op.getText().equals("/")) {
            if (this.latestExpression.getExpressionType() == Type.FLOAT) {
                printWriter.println("\tfdiv");
            } else {
                printWriter.println("\tidiv");
            }
        } else {
            if (this.latestExpression.getExpressionType() == Type.FLOAT) {
                printWriter.println("\tfrem");
            } else {
                printWriter.println("\tirem");
            }
        }
        return null;
    }

    /**
     * Visitor for is reken expr
     *
     * @param ctx context
     * @return null
     */
    @Override
    public Object visitIsRekenExpr(DutchJavaParser.IsRekenExprContext ctx) {
        this.latestExpression = (ValueExpression) valExprTypeTree.get(ctx);
        Type left = (Type) visitChildren(ctx.leftExpr);
        this.isRekenSymbol = (Symbol) varMethTree.get(ctx);
        if (this.latestExpression.getExpressionType() == Type.FLOAT && left == Type.INT) {
            printWriter.println("\ti2f");
        }
        Type right = (Type) visitChildren(ctx.rightExpr);
        if (this.latestExpression.getExpressionType() == Type.FLOAT && right == Type.INT) {
            printWriter.println("\ti2f");
        }

        if (ctx.op.getText().equals("*=") || ctx.op.getText().equals("=*")) {
            if (this.latestExpression.getExpressionType() == Type.FLOAT) {
                printWriter.println("\tfmul");
            } else {
                printWriter.println("\timul");
            }
        } else if (ctx.op.getText().equals("/=") || ctx.op.getText().equals("=/")) {
            if (this.latestExpression.getExpressionType() == Type.FLOAT) {
                printWriter.println("\tfdiv");
            } else {
                printWriter.println("\tidiv");
            }
        } else if (ctx.op.getText().equals("-=") || ctx.op.getText().equals("=-")) {
            if (this.latestExpression.getExpressionType() == Type.FLOAT) {
                printWriter.println("\tfsub");
            } else {
                printWriter.println("\tisub");
            }
        } else {
            if (this.latestExpression.getExpressionType() == Type.FLOAT) {
                printWriter.println("\tfadd");
            } else {
                printWriter.println("\tiadd");
            }
        }
        storehelper(this.isRekenSymbol.getType(), this.isRekenSymbol.getPosition());
        return null;
    }

    /**
     * Visitor for voor statement
     *
     * @param ctx context
     * @return null
     */
    @Override
    public Object visitVoor_statement(DutchJavaParser.Voor_statementContext ctx) {
        Scope forScope = (Scope) parseTreeProperty.get(ctx);
        Symbol symbol = (Symbol) varMethTree.get(ctx);
        if (ctx.verand != null) {
            int pos = symbol.getPosition();
            loadHelperSymbol(symbol.getType(), pos);

            visitChildren(ctx.verand.value_expressie());

            storehelper(symbol.getType(), pos);
        } else if (ctx.toek != null) {
            visitChildren(ctx.toekenning().value_expressie());

            int pos = symbol.getPosition();
            storehelper(symbol.getType(), pos);
        }
        printWriter.println("\t" + forScope.getName() + ":");

        visit(ctx.expressie());
        printWriter.println(forScope.getName() + "_end");
        visitChildren(ctx.stat_blok());
        visit(ctx.value_expressie());
        printWriter.println("\tgoto " + forScope.getName());
        printWriter.println("\t" + forScope.getName() + "_end:");
        return null;
    }

    /**
     * Visitor for methode uitvoering
     *
     * @param ctx context
     * @return null
     */
    @Override
    public Object visitMethodeUITVOERING(DutchJavaParser.MethodeUITVOERINGContext ctx) {
        if (ctx.argument_uitvoering() != null) {
            Method method = (Method) varMethTree.get(ctx);
            printWriter.print(".method public " + ctx.ID().getText() + "(" + argumentHelper(method).toString() + ")");
        } else {
            printWriter.print(".method public " + ctx.ID().getText() + "()");
        }
        Type type = Type.getType(ctx.DATATYPE().getText());
        printWriter.println(type.getMnenonic());

        visitFunc_stat_blokHelper(ctx.func_stat_blok(), type, ctx.ID().getText());
        printWriter.println(".end method");
        return null;
    }

    @Override
    public Object visitMethodeAANROEP(DutchJavaParser.MethodeAANROEPContext ctx) {
        Scope scope = (Scope) parseTreeProperty.get(ctx);
        MethodScope methodScope = ((Scope) parseTreeProperty.get(ctx)).lookFunctie(ctx.ID().getText());
        Method method = methodScope.getMethod();

        printWriter.println("\taload 0");
        if (ctx.argument() != null) {
            for (int i = 0; i < ctx.argument().argument_type().size(); i++) {
                methodeAanroepHelper(ctx.argument().argument_type().get(i), scope);
            }
            printWriter.println("\tinvokevirtual " + filename + "/" + method.getName() + "(" + argumentHelper(method).toString() + ")" + method.getReturnType().getMnenonic());
        } else {
            printWriter.println("\tinvokevirtual " + filename + "/" + method.getName() + "()" + method.getReturnType().getMnenonic());

        }

        return null;
    }

    /**
     * Visitor for atom int
     *
     * @param ctx context
     * @return niks nada noppes
     */
    @Override
    public Type visitAtomInt(DutchJavaParser.AtomIntContext ctx) {
        Integer integer = new Integer(ctx.INT().getText());
        if (integer >= 0 && integer < 128) {
            printWriter.println("\tbipush " + integer);
        } else if (integer >= 128 && integer < 32768) {
            printWriter.println("\tsipush " + integer);
        } else {
            printWriter.println("\tldc " + integer);
        }
        return Type.INT;
    }

    /**
     * Visitor for atom boolean
     *
     * @param ctx context
     * @return niks nada noppes
     */
    @Override
    public Type visitAtomBoolean(DutchJavaParser.AtomBooleanContext ctx) {
        if (ctx.BOOLEAN().getText().equals("waar")) {
            printWriter.println("\ticonst_1");
        } else {
            printWriter.println("\ticonst_0");
        }
        return Type.BOOL;
    }

    /**
     * Visitor for atom float
     *
     * @param ctx context
     * @return null
     */
    @Override
    public Type visitAtomFloat(DutchJavaParser.AtomFloatContext ctx) {
        printWriter.println("\tldc " + new Float(ctx.FLOAT().getText()));
        return Type.FLOAT;
    }

    /**
     * Visitor for atom string
     *
     * @param ctx context
     * @return null
     */
    @Override
    public Type visitAtomString(DutchJavaParser.AtomStringContext ctx) {
        printWriter.println("\tldc " + ctx.STRING().getText());
        return Type.STRING;
    }

    /**
     * Visitor for atom id
     *
     * @param ctx DutchJavaParser.AtomIdContext
     * @return null
     */
    @Override
    public Type visitAtomId(DutchJavaParser.AtomIdContext ctx) {
        Symbol var = ((Scope) parseTreeProperty.get(ctx)).lookVariable(ctx.ID().getText());
        loadHelperSymbol(var.getType(), var.getPosition());
        return var.getType();
    }

    /**
     * Visitor for als statement
     *
     * @param ctx context
     * @return null
     */
    @Override
    public Object visitAls_statement(DutchJavaParser.Als_statementContext ctx) {
        Scope scope = (Scope) parseTreeProperty.get(ctx);
        String endIf = scope.getName() + "_end";

        for (int i = 0; i < ctx.conditie_block().size(); i++) {
            DutchJavaParser.Conditie_blockContext conditie_blockContext = ctx.conditie_block(i);
            Scope scope1 = scope.getChildScopes().get(i);

            Scope next = null;
            if (ctx.stat_blok() != null) {
                if (i + 1 <= ctx.conditie_block().size()) {
                    next = scope.getChildScopes().get(i + 1);
                }
            } else {
                if (i + 1 <= ctx.conditie_block().size() - 1) {
                    next = scope.getChildScopes().get(i + 1);
                }
            }

            printWriter.println("\t" + scope1.getName() + ":");
            visitChildren(conditie_blockContext.expressie());
            if (next != null) {
                printWriter.println(next.getName());
            } else {
                printWriter.println(endIf);
            }
            visitChildren(conditie_blockContext.stat_blok());

            printWriter.println("\tgoto " + scope.getName() + "_end");
        }
        if (ctx.stat_blok() != null) {
            Scope lastScope = scope.getChildScopes().get(scope.getChildScopes().size() - 1);
            printWriter.println("\t" + lastScope.getName() + ":");
            visitChildren(ctx.stat_blok());
        }
        printWriter.println("\t" + scope.getName() + "_end:");
        return null;
    }

    /**
     * Visitor for zolang statement
     *
     * @param ctx context
     * @return null
     */
    @Override
    public Object visitZolang_statement(DutchJavaParser.Zolang_statementContext ctx) {
        Scope scope = (Scope) parseTreeProperty.get(ctx.stat_blok());
        printWriter.println("\t" + scope.getName() + ":");
        visitChildren(ctx.expressie());
        printWriter.println(scope.getName() + "_end");
        visitChildren(ctx.stat_blok());
        printWriter.println("\tgoto " + scope.getName());
        printWriter.println("\t" + scope.getName() + "_end:");
        return null;
    }

    /**
     * Visitor for toekenning
     *
     * @param ctx context
     * @return null
     */
    @Override
    public Object visitToekenning(DutchJavaParser.ToekenningContext ctx) {
        Symbol symbol = (Symbol) varMethTree.get(ctx);
        visit(ctx.value_expressie());

        int pos = symbol.getPosition();
        storehelper(symbol.getType(), pos);
        return null;
    }

    /**
     * Visitor for declarering
     *
     * @param ctx context
     * @return null
     */
    @Override
    public Object visitDeclarering(DutchJavaParser.DeclareringContext ctx) {
        Symbol symbol = (Symbol) varMethTree.get(ctx);
        switch (symbol.getType()) {
            case FLOAT:
                printWriter.println("\tfconst_0");
                break;
            case INT:
                printWriter.println("\ticonst_0");
                break;
            case BOOL:
                printWriter.println("\ticonst_0");
                break;
            case STRING:
                printWriter.println("\tldc \"\"");
                break;
        }

        storehelper(symbol.getType(), symbol.getPosition());
        return super.visitDeclarering(ctx);
    }

    /**
     * Visitor for toekenning with method
     *
     * @param ctx context
     * @return null
     */
    @Override
    public Object visitToekenningWithMethod(DutchJavaParser.ToekenningWithMethodContext ctx) {
        Symbol s = (Symbol) varMethTree.get(ctx);
        Scope scope = (Scope) parseTreeProperty.get(ctx);
        int pos = s.getPosition();

        MethodScope methodScope = ((Scope) parseTreeProperty.get(ctx)).lookFunctie(ctx.methodeAANROEP().ID().getText());
        Method method = methodScope.getMethod();

        printWriter.println("\taload 0");
        if (ctx.methodeAANROEP().argument() != null) {
            for (int i = 0; i < ctx.methodeAANROEP().argument().argument_type().size(); i++) {
                methodeAanroepHelper(ctx.methodeAANROEP().argument().argument_type().get(i), scope);
            }
            printWriter.println("\tinvokevirtual " + filename + "/" + method.getName() + "(" + argumentHelper(method).toString() + ")" + method.getReturnType().getMnenonic());
        } else {
            printWriter.println("\tinvokevirtual " + filename + "/" + method.getName() + "()" + method.getReturnType().getMnenonic());

        }
        storehelper(s.getType(), pos);

        return null;
    }

    /**
     * Visitor for verandering
     *
     * @param ctx context
     * @return null
     */
    @Override
    public Object visitVerandering(DutchJavaParser.VeranderingContext ctx) {
        Symbol symbol = (Symbol) varMethTree.get(ctx);
        int pos = symbol.getPosition();

        visitChildren(ctx.value_expressie());

        storehelper(symbol.getType(), pos);
        return null;
    }

    /**
     * Visitor for verandering with method
     *
     * @param ctx context
     * @return null
     */
    @Override
    public Object visitVeranderingWithMethod(DutchJavaParser.VeranderingWithMethodContext ctx) {
        Symbol s = (Symbol) varMethTree.get(ctx);
        Scope scope = (Scope) parseTreeProperty.get(ctx);
        int pos = s.getPosition();
        MethodScope methodScope = ((Scope) parseTreeProperty.get(ctx)).lookFunctie(ctx.methodeAANROEP().ID().getText());
        Method method = methodScope.getMethod();
        printWriter.println("\taload 0");
        if (ctx.methodeAANROEP().argument() != null) {
            for (int i = 0; i < ctx.methodeAANROEP().argument().argument_type().size(); i++) {
                methodeAanroepHelper(ctx.methodeAANROEP().argument().argument_type().get(i), scope);
            }
            printWriter.println("\tinvokevirtual " + filename + "/" + method.getName() + "(" + argumentHelper(method).toString() + ")" + method.getReturnType().getMnenonic());
        } else {
            printWriter.println("\tinvokevirtual " + filename + "/" + method.getName() + "()" + method.getReturnType().getMnenonic());

        }
        storehelper(s.getType(), pos);

        return null;
    }

    /**
     * Visitor for vergelijking expressie
     *
     * @param ctx context
     * @return null
     */
    @Override
    public Object visitVergelijkingExpr(DutchJavaParser.VergelijkingExprContext ctx) {
        Type type = (Type) visitChildren(ctx.leftExpr);
        if (type == Type.FLOAT) {
            printWriter.println("\tf2i");
        }
        Type type2 = (Type) visitChildren(ctx.rightExpr);
        if (type2 == Type.FLOAT) {
            printWriter.println("\tf2i");
        }
        if (ctx.op.getText().equals("<=")) {
            printWriter.print("\tif_icmpgt ");
        } else if (ctx.op.getText().equals(">=")) {
            printWriter.print("\tif_icmplt ");
        } else if (ctx.op.getText().equals("<")) {
            printWriter.print("\tif_icmpge ");
        } else if (ctx.op.getText().equals(">")) {
            printWriter.print("\tif_icmple ");
        }
        return null;
    }

    /**
     * Visitor for gelijkheids expr
     *
     * @param ctx context
     * @return null
     */
    @Override
    public Object visitGelijkheidExpr(DutchJavaParser.GelijkheidExprContext ctx) {
        Type type = (Type) visitChildren(ctx.leftExpr);
        if (type == Type.FLOAT) {
            printWriter.println("\tf2i");
        }
        Type type2 = (Type) visitChildren(ctx.rightExpr);
        if (type2 == Type.FLOAT) {
            printWriter.println("\tf2i");
        }
        if (ctx.op.getText().equals("!=")) {
            printWriter.print("\tif_icmpeq ");
        } else {
            printWriter.print("\tif_icmpne ");
        }
        return null;
    }

    /**
     * Visitor for schrijf id
     *
     * @param ctx context
     * @return null
     */
    @Override
    public Object visitSchrijfId(DutchJavaParser.SchrijfIdContext ctx) {
        Scope scope = (Scope) parseTreeProperty.get(ctx);
        Symbol s = scope.lookVariable(ctx.ID().getText());
        printWriter.println("\tgetstatic java/lang/System/out Ljava/io/PrintStream;");
        loadHelperSymbol(s.getType(), s.getPosition());
        switch (s.getType()) {
            case STRING:
                printWriter.println("\tinvokevirtual java/io/PrintStream/println(Ljava/lang/String;)V");
                break;
            case BOOL:
                printWriter.println("\tinvokevirtual java/io/PrintStream/println(Z)V");
                break;
            case INT:
                printWriter.println("\tinvokevirtual java/io/PrintStream/println(I)V");
                break;
            case FLOAT:
                printWriter.println("\tinvokevirtual java/io/PrintStream/println(F)V");
                break;
        }
        return super.visitSchrijfId(ctx);
    }

    /**
     * Visitor for schrijf string
     *
     * @param ctx context
     * @return null
     */
    @Override
    public Object visitSchrijfString(DutchJavaParser.SchrijfStringContext ctx) {
        printWriter.println("\tgetstatic java/lang/System/out Ljava/io/PrintStream;");
        printWriter.println("\tldc " + ctx.STRING().getText());
        printWriter.println("\tinvokevirtual java/io/PrintStream/println(Ljava/lang/String;)V");
        return null;
    }

    /**
     * Visitor for schrijf bool expression
     *
     * @param ctx context
     * @return null
     */
    @Override
    public Object visitSchrijfExpr(DutchJavaParser.SchrijfExprContext ctx) {
        schrijfExpr++;

        visit(ctx.expressie());
        printWriter.println("schrijfexpr_" + schrijfExpr + "_else");
        printWriter.println("\tgetstatic java/lang/System/out Ljava/io/PrintStream;");
        printWriter.println("\ticonst_1");
        printWriter.println("\tinvokevirtual java/io/PrintStream/println(Z)V");

        printWriter.println("\tgoto schrijfexpr_" + schrijfExpr + "_end");

        printWriter.println("\tschrijfexpr_" + schrijfExpr + "_else:");
        printWriter.println("\tgetstatic java/lang/System/out Ljava/io/PrintStream;");
        printWriter.println("\ticonst_0");
        printWriter.println("\tinvokevirtual java/io/PrintStream/println(Z)V");

        printWriter.println("\tgoto schrijfexpr_" + schrijfExpr + "_end");
        printWriter.println("\tschrijfexpr_" + schrijfExpr + "_end:");

        return null;
    }

    /**
     * Visitor for schrijf value expression
     *
     * @param ctx context
     * @return null
     */
    @Override
    public Object visitSchrijfValExpr(DutchJavaParser.SchrijfValExprContext ctx) {
        printWriter.println("\tgetstatic java/lang/System/out Ljava/io/PrintStream;");
        visit(ctx.value_expressie());
        if (this.isRekenSymbol != null) {
            if (this.isRekenSymbol.getType() == Type.INT) {
                printWriter.println("\tiload " + this.isRekenSymbol.getPosition());
            } else {
                printWriter.println("\tfload " + this.isRekenSymbol.getPosition());
            }
            this.isRekenSymbol = null;
        }
        if (this.latestExpression.getExpressionType() == Type.INT) {
            printWriter.println("\tinvokevirtual java/io/PrintStream/println(I)V");

        } else {
            printWriter.println("\tinvokevirtual java/io/PrintStream/println(F)V");
        }
        return null;
    }

    /**
     * Visitor for read input statement
     *
     * @param ctx context
     * @return null
     */
    @Override
    public Object visitRead_statement(DutchJavaParser.Read_statementContext ctx) {
        Scope scope = (Scope) parseTreeProperty.get(ctx);
        int i = scope.lookVariable(ctx.ID().getText()).getPosition();
        Symbol var = (Symbol) varMethTree.get(ctx);
        loadHelperSymbol(var.getType(), i);

        printWriter.println("\tnew java/util/Scanner");
        printWriter.println("\tdup");
        printWriter.println("\tgetstatic java/lang/System/in Ljava/io/InputStream;");
        printWriter.println("\tinvokespecial java/util/Scanner/<init>(Ljava/io/InputStream;)V");
        switch (ctx.DATATYPE().getText()) {
            case "draad":
                printWriter.println("\tinvokevirtual java/util/Scanner/nextLine()Ljava/lang/String;");
                printWriter.println("\tastore " + i);
                break;
            case "nummer":
                printWriter.println("\tinvokevirtual java/util/Scanner/nextInt()I");
                printWriter.println("\tistore " + i);
                break;
            case "vliegend":
                printWriter.println("\tinvokevirtual java/util/Scanner/nextFloat()F");
                printWriter.println("\tfstore " + i);
                break;
            case "booleaans":
                printWriter.println("\tinvokevirtual java/util/Scanner/nextBoolean()Z");
                printWriter.println("\tistore" + i);
                break;
        }
        return super.visitRead_statement(ctx);
    }

    /**
     * Custom visit methode voor func stat blok
     *
     * @param ctx  context
     * @param type wat voor een type was de functie, voor return type
     * @param meth methode naam
     * @return null
     */
    private void visitFunc_stat_blokHelper(DutchJavaParser.Func_stat_blokContext ctx, Type type, String meth) {
        Scope scope = ((Scope) parseTreeProperty.get(ctx));
        printWriter.println("\t.limit stack " + (scope.getLocalStack() + 1));
        printWriter.println("\t.limit locals " + (scope.getLocalAmount() + 1) + "\r\n");
        visitChildren(ctx.blok());
        if (ctx.GEEFTERUG() != null) {
            visit(ctx.ID());
            Symbol symbol = scope.lookVariable(ctx.ID().getText());
            loadHelperSymbol(symbol.getType(), symbol.getPosition());
            switch (type) {
                case STRING:
                    printWriter.println("\r\n\tareturn");
                    break;
                case BOOL:
                    printWriter.println("\r\n\tireturn");
                    break;
                case INT:
                    printWriter.println("\n\tireturn");
                    break;
                case FLOAT:
                    printWriter.println("\r\n\tfreturn");
                    break;
            }
        } else {
            printWriter.println("\r\n\treturn");
        }
    }

    /**
     * Helper for method calling
     *
     * @param argument_typeContext argument context
     * @param scope                scope to find a variable ine
     */
    private void methodeAanroepHelper(DutchJavaParser.Argument_typeContext argument_typeContext, Scope scope) {
        if (argument_typeContext.BOOLEAN() != null) {
            visit(argument_typeContext.BOOLEAN());
            if (argument_typeContext.BOOLEAN().getText().equals("waar")) {
                printWriter.println("\ticonst_1");
            } else {
                printWriter.println("\ticonst_0");
            }
        } else if (argument_typeContext.ID() != null) {
            Symbol var = scope.lookVariable(argument_typeContext.ID().getText());
            loadHelperSymbol(var.getType(), var.getPosition());
        } else if (argument_typeContext.FLOAT() != null) {
            printWriter.println("\tldc " + new Float(argument_typeContext.FLOAT().getText()));
        } else if (argument_typeContext.INT() != null) {
            Integer integer = new Integer(argument_typeContext.INT().getText());
            if (integer >= 0 && integer < 128) {
                printWriter.println("\tbipush " + integer);
            } else if (integer >= 128 && integer < 32768) {
                printWriter.println("\tsipush " + integer);
            } else {
                printWriter.println("\tldc " + integer);
            }
        } else if (argument_typeContext.STRING() != null) {
            printWriter.println("\tldc " + argument_typeContext.STRING().getText());
        }
    }

    /**
     * Loading helper for symbol
     *
     * @param type is the type to switch
     * @param pos  is the pos
     */
    private int loadHelperSymbol(Type type, int pos) {
        switch (type) {
            case FLOAT:
                printWriter.println("\tfload " + pos);
                break;
            case INT:
                printWriter.println("\tiload " + pos);
                break;
            case BOOL:
                printWriter.println("\tiload " + pos);
                break;
            case STRING:
                printWriter.println("\taload " + pos);
                break;
        }
        return pos;
    }

    /**
     * Storing helper
     *
     * @param type type
     * @param pos  position
     */
    private void storehelper(Type type, int pos) {
        switch (type) {
            case STRING:
                printWriter.println("\tastore " + pos);
                break;
            case INT:
                printWriter.println("\tistore " + pos);
                break;
            case FLOAT:
                printWriter.println("\tfstore " + pos);
                break;
            case BOOL:
                printWriter.println("\tistore " + pos);
                break;
        }
    }

    /**
     * Argument builder
     *
     * @param method method
     * @return builder
     */
    private StringBuilder argumentHelper(Method method) {
        StringBuilder builder = new StringBuilder();
        for (Symbol var : method.getParameters()) {
            Type type = var.getType();
            builder.append(type.getMnenonic());
        }
        return builder;
    }

    public PrintWriter getPrintWriter() {
        return printWriter;
    }
}