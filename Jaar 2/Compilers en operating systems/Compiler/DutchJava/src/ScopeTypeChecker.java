import Model.Exceptions.*;
import Model.*;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

/**
 * Created by thama on 16-5-2017.
 */
public class ScopeTypeChecker extends DutchJavaBaseVisitor {
    /**
     * Scope counters
     */
    private static int IF_NAME = 0;
    private static int IF_ELSE_SCOPE_NAME = 0;
    private static int METHOD_SCOPE_NAME = 0;
    private static int WHILE_SCOPE_NAME = 0;
    private static int FOR_SCOPE_NAME = 0;

    /**
     * All parse trees needed for code generation
     */
    private ParseTreeProperty valExprTypeTree;
    private ParseTreeProperty scopeTree;
    private ParseTreeProperty varMethTree;

    /**
     * Current scope and method scope
     */
    private Scope scope;
    private MethodScope methodScope;

    /**
     * Name for the scope
     */
    private String latestname;

    /**
     * Constructor for the scope/typechecker
     */
    public ScopeTypeChecker() {
        scopeTree = new ParseTreeProperty();
        varMethTree = new ParseTreeProperty();
        valExprTypeTree = new ParseTreeProperty();

        METHOD_SCOPE_NAME += 1;
        scope = new Scope(null, "method_" + METHOD_SCOPE_NAME);

        Symbol symbol = new Symbol("args", Type.STRING);
        scope.addVariable(symbol);
        scope.assignPosition(symbol);

    }

    /**
     * Visitor for statement blok
     *
     * @param ctx context
     * @return null
     */
    @Override
    public Object visitStatementBlok(DutchJavaParser.StatementBlokContext ctx) {
        scopeTree.put(ctx, this.scope);
        Scope scope = this.scope.createChild(latestname);
        this.scope = scope;

        this.scope.getParent().addChildScope(this.scope);

        visitChildren(ctx);
        this.scope = this.scope.closeChild();

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
        scopeTree.put(ctx, scope);
        scope.addToStack();
        Symbol s = new Symbol(ctx.ID().getText(), Type.getType(ctx.DATATYPE().getText()));
        Type type = Type.getType(ctx.DATATYPE().getText());

        if (type == Type.INVALID || visit(ctx.value_expressie()) != type) {
            throw new InvalidTypeException("Variable " + ctx.ID().getText() + " has incorrect type");
        }

        if (scope.addVariable(s)) {
            varMethTree.put(ctx, s);
            scope.assignPosition(s);
            return null;
        } else {
            throw new AlreadyExistsException("Variable " + ctx.ID().getText() + " already exists!");
        }
    }

    /**
     * Visitor for declarering
     *
     * @param ctx context
     * @return null
     */
    @Override
    public Object visitDeclarering(DutchJavaParser.DeclareringContext ctx) {
        scopeTree.put(ctx, scope);
        scope.addToStack();
        Symbol s = new Symbol(ctx.ID().getText(), Type.getType(ctx.DATATYPE().getText()));
        Type type = Type.getType(ctx.DATATYPE().getText());

        if (type == Type.INVALID) {
            throw new InvalidTypeException("Variable " + ctx.ID().getText() + " has incorrect type");
        }
        if (scope.addVariable(s)) {
            varMethTree.put(ctx, s);
            scope.assignPosition(s);
            return null;
        } else {
            throw new AlreadyExistsException("Variable " + ctx.ID().getText() + " already exists!");
        }
    }

    /**
     * Visitor for toekenning with a method
     *
     * @param ctx context
     * @return null
     */
    @Override
    public Object visitToekenningWithMethod(DutchJavaParser.ToekenningWithMethodContext ctx) {
        scopeTree.put(ctx, scope);
        scope.addToStack();
        visitMethodeAANROEP(ctx.methodeAANROEP());
        MethodScope methodScope = scope.lookFunctie(ctx.methodeAANROEP().ID().getText());
        Method method = null;
        if (methodScope != null) {
            method = methodScope.getMethod();
        } else {
            throw new DoesNotExistException("Method " + ctx.methodeAANROEP().ID().getText() + " does not exist");
        }
        Symbol s = new Symbol(ctx.ID().getText(), Type.getType(ctx.DATATYPE().getText()));

        Type returnType = Type.getType(ctx.DATATYPE().getText());

        if (returnType == method.getReturnType()) {
            if (scope.addVariable(s)) {
                varMethTree.put(ctx, s);
                scope.assignPosition(s);
                return null;
            } else {
                throw new AlreadyExistsException("Variable " + ctx.ID().getText() + " already exists!");
            }
        } else {
            throw new InvalidTypeException("Return types do not match for " + ctx.ID().getText());
        }

    }

    /**
     * Visit verandering with method
     *
     * @param ctx context
     * @return null
     */
    @Override
    public Object visitVeranderingWithMethod(DutchJavaParser.VeranderingWithMethodContext ctx) {
        scopeTree.put(ctx, scope);
        visitMethodeAANROEP(ctx.methodeAANROEP());
        MethodScope methodScope = scope.lookFunctie(ctx.methodeAANROEP().ID().getText());
        Method method = null;
        if (methodScope != null) {
            method = methodScope.getMethod();
        } else {
            throw new DoesNotExistException("Method " + ctx.methodeAANROEP().ID().getText() + " does not exist");
        }
        Symbol var = scope.lookVariable(ctx.ID().getText());

        varMethTree.put(ctx, var);

        if (method != null) {
            if (var != null) {
                if (var.getType() == method.getReturnType()) {
                    return null;
                } else {
                    throw new InvalidTypeException("Datatypes do not match for " + ctx.ID().getText());
                }
            } else {
                throw new DoesNotExistException("Variable " + ctx.ID().getText() + " does not exist!");
            }
        }
        throw new DoesNotExistException("Method " + ctx.methodeAANROEP().ID().getText() + " does not exist");
    }

    /**
     * Visitor for verandering
     *
     * @param ctx context
     * @return null
     */
    @Override
    public Object visitVerandering(DutchJavaParser.VeranderingContext ctx) {
        scopeTree.put(ctx, scope);
        Symbol var = scope.lookVariable(ctx.id.getText());
        varMethTree.put(ctx, var);
        if (var != null) {
            if (visit(ctx.expr) == var.getType()) {
                return null;
            } else {
                throw new DataTypesDontMatchException("Datatypes do not match for " + ctx.id.getText());
            }
        }
        throw new DoesNotExistException("Variable " + ctx.id.getText() + " does not exist");
    }

    /**
     * Visitor for methode aanroep
     *
     * @param ctx context
     * @return null
     */
    @Override
    public Object visitMethodeAANROEP(DutchJavaParser.MethodeAANROEPContext ctx) {
        scopeTree.put(ctx, scope);
        MethodScope methodScope = scope.lookFunctie(ctx.ID().getText());
        Method method = null;
        if (methodScope != null) {
            method = methodScope.getMethod();
        } else {
            throw new DoesNotExistException("Method " + ctx.ID().getText() + " does not exist");
        }
        if (ctx.argument() == null && method.getParameters().size() > 0) {
            throw new MissingParamatersException("Method " + ctx.ID().getText() + " is missing parameters");
        } else if (ctx.argument().argument_type() == null && method.getParameters().size() > 0) {
            throw new MissingParamatersException("Method " + ctx.ID().getText() + " is missing parameters");
        } else if (ctx.argument().argument_type().size() < method.getParameters().size()) {
            throw new MissingParamatersException("Method " + ctx.ID().getText() + " is missing parameters");
        } else if (ctx.argument().argument_type().size() > method.getParameters().size()) {
            throw new TooManyParamatersException("Method " + ctx.ID().getText() + " has too many parameters");
        }
        for (int i = 0; i < method.getParameters().size(); i++) {
            Symbol p = method.getParameters().get(i);
            Type type = Type.INVALID;
            scope.addToStack();
            if (ctx.argument().argument_type(i).BOOLEAN() != null) {
                type = Type.BOOL;
            } else if (ctx.argument().argument_type(i).STRING() != null) {
                type = Type.STRING;
            } else if (ctx.argument().argument_type(i).INT() != null) {
                type = Type.INT;
            } else if (ctx.argument().argument_type(i).FLOAT() != null) {
                type = Type.FLOAT;
            } else if (ctx.argument().argument_type(i).ID() != null) {
                Symbol var = scope.lookVariable(ctx.argument().argument_type(i).getText());
                if (var != null) {
                    type = var.getType();
                } else {
                    throw new DoesNotExistException("Variable " + ctx.argument().argument_type(i).getText() + " does not exist");
                }
            }
            if (p.getType() != type) {
                throw new DataTypesDontMatchException("Datatypes do not match");
            }
        }

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
        scopeTree.put(ctx, scope);

        if (scope.lookFunctie(ctx.ID().getText()) == null) {
            DutchJavaParser.Argument_uitvoeringContext apc = ctx.argument_uitvoering();
            Type type2 = Type.getType(ctx.DATATYPE().getText());

            Method method = new Method(ctx.ID().getText(), type2);

            if (apc != null) {
                for (int i = 0; i < apc.argument_type().size(); i++) {
                    DutchJavaParser.Argument_typeContext e = apc.argument_type(i);
                    Type type = Type.getType(apc.DATATYPE(i).getText());
                    Symbol s = new Symbol(e.getText(), type);
                    boolean exists = false;
                    if (method.getParameters().size() > 0) {
                        for (int j = 0; j < method.getParameters().size(); j++) {
                            if (method.getParameters().get(j).getName().equals(s.getName())) {
                                exists = true;
                            }
                        }
                    }
                    if (!exists) {
                        method.addParameter(new Symbol(e.getText(), type));
                    } else {
                        throw new AlreadyExistsException("Method " + method.getName() + " already has parameter " + s.getName());
                    }
                }
            }

            scope.addFunctie(method);
            this.scope = scope.lookFunctie(method.getName());

            varMethTree.put(ctx, method);
        } else {
            throw new AlreadyExistsException("Method " + ctx.ID().getText() + " already exists");
        }

        visit(ctx.func_stat_blok());
        return null;
    }

    /**
     * Visitor for function statement blok
     *
     * @param ctx context
     * @return null
     */
    @Override
    public Object visitFunc_stat_blok(DutchJavaParser.Func_stat_blokContext ctx) {
        METHOD_SCOPE_NAME += 1;
        latestname = "method_" + METHOD_SCOPE_NAME;
        Scope scope = this.scope.createChild(latestname, 0);

        this.methodScope = (MethodScope) this.scope;
        this.methodScope.setName(latestname);
        scopeTree.put(ctx, this.scope);
        visitChildren(ctx.blok());


        if (this.methodScope.getMethod().getReturnType() != Type.VOID) {
            if (ctx.GEEFTERUG() != null && ctx.ID() != null && ctx.SEMICOL() != null) {
                Symbol s = scope.lookVariable(ctx.ID().getText());
                if (s != null) {
                    if (this.methodScope.getMethod().getReturnType() != s.getType()) {
                        throw new InvalidReturnTypeException("Return types not matching");
                    }
                } else {
                    throw new DoesNotExistException("Variable " + ctx.ID().getText() + " does not exist!");
                }
            } else {
                throw new InvalidReturnTypeException("No return type found for method " + this.methodScope.getMethod().getName());
            }
        } else {
            if (ctx.GEEFTERUG() != null && ctx.ID().getText().length() > 0) {
                throw new InvalidReturnTypeException("No return type allowed for void");
            }
        }
        this.scope = this.scope.closeChild();

        methodScope = null;

        return null;
    }

    /**
     * Visitor read statement
     *
     * @param ctx context
     * @return null
     */
    @Override
    public Object visitRead_statement(DutchJavaParser.Read_statementContext ctx) {
        scopeTree.put(ctx, scope);
        scope.addToStack();
        if (!ctx.DATATYPE().getText().equals("leegte")) {
            Symbol var = scope.lookVariable(ctx.ID().getText());
            varMethTree.put(ctx, var);
            visit(ctx.ID());
            if (var != null) {
                if (var.getType() == Type.getType(ctx.DATATYPE().getText())) {
                    return null;
                } else {
                    throw new DataTypesDontMatchException("Datatypes dont match for " + ctx.ID().getText());
                }
            } else {
                throw new DoesNotExistException("Variable " + ctx.ID().getText() + " doesn't exist!");
            }
        } else {
            throw new InvalidTypeException("Datatype is void for " + ctx.ID().getText());
        }
    }

    /**
     * Visitor for schrijf id
     *
     * @param ctx context
     * @return null
     */
    @Override
    public Object visitSchrijfId(DutchJavaParser.SchrijfIdContext ctx) {
        Symbol s = scope.lookVariable(ctx.ID().getText());
        scope.addToStack();
        if (s != null) {
            scopeTree.put(ctx, scope);
            scope.addToStack();
            return null;
        }
        throw new DoesNotExistException("Variable " + ctx.ID().getText() + " does not exist");
    }

    /**
     * Visitor for schrijf string
     *
     * @param ctx context
     * @return null
     */
    @Override
    public Object visitSchrijfString(DutchJavaParser.SchrijfStringContext ctx) {
        scopeTree.put(ctx, scope);
        scope.addToStack();
        return super.visitSchrijfString(ctx);
    }

    /**
     * Visitor for voor statement
     *
     * @param ctx context
     * @return null
     */
    @Override
    public Object visitVoor_statement(DutchJavaParser.Voor_statementContext ctx) {
        FOR_SCOPE_NAME++;
        latestname = "for_loop_" + FOR_SCOPE_NAME;
        Scope scope = this.scope.createChild(latestname);
        this.scope = scope;

        this.scope.getParent().addChildScope(this.scope);

        scopeTree.put(ctx, this.scope);

        if (ctx.verand != null) {
            visitChildren(ctx.verand);
            Symbol var = scope.lookVariable(ctx.verand.id.getText());
            if (var == null) {
                throw new DoesNotExistException("Variable " + ctx.toek.ID().getText() + " doesn't exist!");
            }

            varMethTree.put(ctx, var);
        } else if (ctx.toek != null) {
            if (this.scope.lookVariable(ctx.toekenning().ID().getText()) == null) {
                Symbol var = new Symbol(ctx.toekenning().ID().getText(), Type.getType(ctx.toekenning().DATATYPE().getText()));
                this.scope.addVariable(var);
                this.scope.assignPosition(var);
                varMethTree.put(ctx, var);
            } else {
                throw new AlreadyExistsException("Variable " + ctx.toek.ID().getText() + " already exists");
            }
        }
        if (visit(ctx.expressie()) != Type.BOOL) {
            throw new InvalidTypeException("Expression is not a boolean");
        }
        visit(ctx.value_expressie());
        visitChildren(ctx.stat_blok());
        this.scope = this.scope.closeChild();
        return null;
    }

    /**
     * Visitor for zolang statement
     *
     * @param ctx context
     * @return null
     */
    @Override
    public Type visitZolang_statement(DutchJavaParser.Zolang_statementContext ctx) {
        WHILE_SCOPE_NAME++;
        latestname = "zolang_" + WHILE_SCOPE_NAME;
        Scope scope = this.scope.createChild(latestname);
        this.scope = scope;

        this.scope.getParent().addChildScope(this.scope);

        scopeTree.put(ctx, this.scope);
        if (visit(ctx.expressie()) == Type.BOOL) {
            visit(ctx.stat_blok());
            this.scope = this.scope.closeChild();
            return Type.BOOL;
        }
        throw new InvalidTypeException("While does not contain a boolean");
    }

    /**
     * Visitor for als statement
     *
     * @param ctx context
     * @return null
     */
    @Override
    public Object visitAls_statement(DutchJavaParser.Als_statementContext ctx) {
        IF_NAME++;
        latestname = "als_" + IF_NAME;
        Scope scope = this.scope.createChild(latestname);
        this.scope = scope;

        this.scope.getParent().addChildScope(this.scope);

        scopeTree.put(ctx, this.scope);
        for (int i = 0; i < ctx.conditie_block().size(); i++) {
            IF_ELSE_SCOPE_NAME++;
            latestname = "alsstate_" + IF_ELSE_SCOPE_NAME;
            if (visit(ctx.conditie_block(i)) != Type.BOOL) {
                throw new InvalidTypeException("Als statement does not contain a boolean");
            }
        }
        if (ctx.stat_blok() != null) {
            IF_ELSE_SCOPE_NAME++;
            latestname = "alsstate_" + IF_ELSE_SCOPE_NAME;
            visit(ctx.stat_blok());
        }
        this.scope = this.scope.closeChild();
        return Type.BOOL;
    }

    /**
     * Visitor for conditie block
     *
     * @param ctx context
     * @return null
     */
    @Override
    public Type visitConditie_block(DutchJavaParser.Conditie_blockContext ctx) {
        scopeTree.put(ctx, scope);

        if (visit(ctx.expressie()) == Type.BOOL) {
            visit(ctx.stat_blok());
            return Type.BOOL;
        }
        throw new InvalidTypeException(ctx.expr.getText() + " condition does not result in a boolean");

    }

    /**
     * Visitor for atomexpressie
     *
     * @param ctx context
     * @return null
     */
    @Override
    public Object visitAtomexpressie(DutchJavaParser.AtomexpressieContext ctx) {
        scopeTree.put(ctx, scope);
        if (ctx.value_expressie() != null) {
            return visit(ctx.value_expressie());
        }
        return visit(ctx.expressie());
    }

    /**
     * Visitor for vergelijking expressie
     *
     * @param ctx context
     * @return null
     */
    @Override
    public Type visitVergelijkingExpr(DutchJavaParser.VergelijkingExprContext ctx) {
        scopeTree.put(ctx, scope);
        return expressieHelper(visitChildren(ctx.leftExpr), visitChildren(ctx.rightExpr));
    }

    /**
     * Visitor for gelijkheid expressie
     *
     * @param ctx context
     * @return null
     */
    @Override
    public Type visitGelijkheidExpr(DutchJavaParser.GelijkheidExprContext ctx) {
        scopeTree.put(ctx, scope);
        return expressieHelper(visitChildren(ctx.leftExpr), visitChildren(ctx.rightExpr));
    }

    /**
     * Helper methode for expressions
     *
     * @param leftType  left type
     * @param rightType right type
     * @return type
     */
    private Type expressieHelper(Object leftType, Object rightType) {
        Type l = (Type) leftType;
        Type r = (Type) rightType;

        if ((l == Type.BOOL || l == Type.FLOAT || l == Type.INT) &&
                (r == Type.BOOL || r == Type.FLOAT || r == Type.INT)) {
            return Type.BOOL;
        }
        throw new InvalidTypeException("Expression is not a boolean");
    }

    /**
     * Visitor for atom id
     *
     * @param ctx context
     * @return null
     */
    @Override
    public Type visitAtomId(DutchJavaParser.AtomIdContext ctx) {
        scopeTree.put(ctx, scope);
//        scope.addToStack();
        Symbol s = scope.lookVariable(ctx.ID().getText());
        if (s != null) {
            return s.getType();
        }
        throw new DoesNotExistException("Variable " + ctx.ID().getText() + " does not exist!");
    }

    /**
     * Visitor for plus min expr
     *
     * @param ctx context
     * @return null
     */
    @Override
    public Type visitPlusMinExpr(DutchJavaParser.PlusMinExprContext ctx) {
        scopeTree.put(ctx, scope);
        if (ctx.op.getText().equals("+") || ctx.op.getText().equals("-")) {
            if (visit(ctx.leftExpr) == Type.INT && visit(ctx.rightExpr) == Type.INT) {
                ValueExpression valueExpression = new ValueExpression(Type.INT);
                valExprTypeTree.put(ctx, valueExpression);
                return Type.INT;
            } else if ((visit(ctx.leftExpr) == Type.INT && visit(ctx.rightExpr) == Type.FLOAT) ||
                    (visit(ctx.leftExpr) == Type.FLOAT && visit(ctx.rightExpr) == Type.INT) ||
                    (visit(ctx.leftExpr) == Type.FLOAT && visit(ctx.rightExpr) == Type.FLOAT)) {
                ValueExpression valueExpression = new ValueExpression(Type.FLOAT);
                valExprTypeTree.put(ctx, valueExpression);
                return Type.FLOAT;
            }
        }
        throw new IllegalArgumentException("Unsupported expression");
    }

    /**
     * Visitor for keer gedeeld door en modulo expr
     *
     * @param ctx context
     * @return null
     */
    @Override
    public Type visitKeerGddModExpr(DutchJavaParser.KeerGddModExprContext ctx) {
        scopeTree.put(ctx, scope);
        if (ctx.op.getText().equals("%") || ctx.op.getText().equals("*") || ctx.op.getText().equals("/")) {
            if (visit(ctx.leftExpr) == Type.INT && visit(ctx.rightExpr) == Type.INT) {
                ValueExpression valueExpression = new ValueExpression(Type.INT);
                valExprTypeTree.put(ctx, valueExpression);
                return Type.INT;
            } else if ((visit(ctx.leftExpr) == Type.INT && visit(ctx.rightExpr) == Type.FLOAT) ||
                    (visit(ctx.leftExpr) == Type.FLOAT && visit(ctx.rightExpr) == Type.INT) ||
                    (visit(ctx.leftExpr) == Type.FLOAT && visit(ctx.rightExpr) == Type.FLOAT)) {
                ValueExpression valueExpression = new ValueExpression(Type.FLOAT);
                valExprTypeTree.put(ctx, valueExpression);
                return Type.FLOAT;
            }
        }
        throw new IllegalArgumentException("Unsupported expression");
    }

    /**
     * Visitor for is reken expressie
     *
     * @param ctx context
     * @return null
     */
    @Override
    public Type visitIsRekenExpr(DutchJavaParser.IsRekenExprContext ctx) {
        Symbol symbol = scope.lookVariable(ctx.leftExpr.getText());
        scopeTree.put(ctx, scope);
        if (symbol != null) {
            if (visit(ctx.leftExpr) == Type.INT && visit(ctx.rightExpr) == Type.INT) {
                ValueExpression valueExpression = new ValueExpression(Type.INT);
                valExprTypeTree.put(ctx, valueExpression);
                varMethTree.put(ctx, symbol);
                return Type.INT;
            } else if ((visit(ctx.leftExpr) == Type.INT && visit(ctx.rightExpr) == Type.FLOAT) ||
                    (visit(ctx.leftExpr) == Type.FLOAT && visit(ctx.rightExpr) == Type.INT) ||
                    (visit(ctx.leftExpr) == Type.FLOAT && visit(ctx.rightExpr) == Type.FLOAT)) {
                ValueExpression valueExpression = new ValueExpression(Type.FLOAT);
                valExprTypeTree.put(ctx, valueExpression);
                varMethTree.put(ctx, symbol);
                return Type.FLOAT;
            } else {
                throw new IllegalArgumentException("Unsupported expression");
            }
        } else {
            throw new DoesNotExistException("Variable " + ctx.leftExpr.getText() + " does not exist!");
        }
    }

    /**
     * Visitor for -- and ++ expressions
     *
     * @param ctx context
     * @return null
     */
    @Override
    public Type visitMinminPlusPlusExpr(DutchJavaParser.MinminPlusPlusExprContext ctx) {
        scopeTree.put(ctx, scope);
        Symbol var = scope.lookVariable(ctx.leftExpr.getText());
        varMethTree.put(ctx, var);
        if (var != null) {
            if (visit(ctx.leftExpr) == Type.FLOAT) {
                scope.addToStack();
                ValueExpression valueExpression = new ValueExpression(Type.FLOAT);
                valExprTypeTree.put(ctx, valueExpression);
                return Type.FLOAT;
            } else if (visit(ctx.leftExpr) == Type.INT) {
                ValueExpression valueExpression = new ValueExpression(Type.INT);
                valExprTypeTree.put(ctx, valueExpression);
                return Type.INT;
            }
            throw new InvalidTypeException(ctx.leftExpr.getText() + " expression has incorrect type");
        } else {
            throw new DoesNotExistException("Variable " + ctx.leftExpr.getText() + " does not exist!");
        }
    }

    /**
     * Visitor for atom int
     *
     * @param ctx context
     * @return null
     */
    @Override
    public Type visitAtomInt(DutchJavaParser.AtomIntContext ctx) {
        scopeTree.put(ctx, scope);
        scope.addToStack();
        return Type.INT;
    }

    /**
     * Visitor for atom string
     *
     * @param ctx context
     * @return null
     */
    @Override
    public Type visitAtomString(DutchJavaParser.AtomStringContext ctx) {
        scopeTree.put(ctx, scope);
        scope.addToStack();
        return Type.STRING;
    }

    /**
     * Visitor for atom float
     *
     * @param ctx context
     * @return null
     */
    @Override
    public Type visitAtomFloat(DutchJavaParser.AtomFloatContext ctx) {
        scopeTree.put(ctx, scope);
        scope.addToStack();
        return Type.FLOAT;
    }

    /**
     * Visitor for atom boolean
     *
     * @param ctx context
     * @return null
     */
    @Override
    public Type visitAtomBoolean(DutchJavaParser.AtomBooleanContext ctx) {
        scopeTree.put(ctx, scope);
        scope.addToStack();
        return Type.BOOL;
    }

    /**
     * Getters
     */
    public ParseTreeProperty getScopeTree() {
        return scopeTree;
    }

    public Scope getGlobalScope() {
        return scope.getTopParent();
    }

    public ParseTreeProperty getVarMethTree() {
        return varMethTree;
    }

    public ParseTreeProperty getValExprTypeTree() {
        return valExprTypeTree;
    }
}