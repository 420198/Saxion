// Generated from D:/School/kwartiel 3/Compilers en operating systems/DutchJava2\DutchJava.g4 by ANTLR 4.7

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link DutchJavaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 *            operations with no return type.
 */
public interface DutchJavaVisitor<T> extends ParseTreeVisitor<T> {
    /**
     * Visit a parse tree produced by {@link DutchJavaParser#parse}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitParse(DutchJavaParser.ParseContext ctx);

    /**
     * Visit a parse tree produced by {@link DutchJavaParser#blok}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitBlok(DutchJavaParser.BlokContext ctx);

    /**
     * Visit a parse tree produced by {@link DutchJavaParser#statement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitStatement(DutchJavaParser.StatementContext ctx);

    /**
     * Visit a parse tree produced by {@link DutchJavaParser#read_statement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitRead_statement(DutchJavaParser.Read_statementContext ctx);

    /**
     * Visit a parse tree produced by the {@code schrijfId}
     * labeled alternative in {@link DutchJavaParser#print_statement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSchrijfId(DutchJavaParser.SchrijfIdContext ctx);

    /**
     * Visit a parse tree produced by the {@code schrijfString}
     * labeled alternative in {@link DutchJavaParser#print_statement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSchrijfString(DutchJavaParser.SchrijfStringContext ctx);

    /**
     * Visit a parse tree produced by the {@code schrijfValExpr}
     * labeled alternative in {@link DutchJavaParser#print_statement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSchrijfValExpr(DutchJavaParser.SchrijfValExprContext ctx);

    /**
     * Visit a parse tree produced by the {@code schrijfExpr}
     * labeled alternative in {@link DutchJavaParser#print_statement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSchrijfExpr(DutchJavaParser.SchrijfExprContext ctx);

    /**
     * Visit a parse tree produced by {@link DutchJavaParser#als_statement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitAls_statement(DutchJavaParser.Als_statementContext ctx);

    /**
     * Visit a parse tree produced by {@link DutchJavaParser#zolang_statement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitZolang_statement(DutchJavaParser.Zolang_statementContext ctx);

    /**
     * Visit a parse tree produced by {@link DutchJavaParser#voor_statement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitVoor_statement(DutchJavaParser.Voor_statementContext ctx);

    /**
     * Visit a parse tree produced by {@link DutchJavaParser#declarering}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDeclarering(DutchJavaParser.DeclareringContext ctx);

    /**
     * Visit a parse tree produced by {@link DutchJavaParser#toekenning}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitToekenning(DutchJavaParser.ToekenningContext ctx);

    /**
     * Visit a parse tree produced by {@link DutchJavaParser#toekenningWithMethod}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitToekenningWithMethod(DutchJavaParser.ToekenningWithMethodContext ctx);

    /**
     * Visit a parse tree produced by {@link DutchJavaParser#verandering}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitVerandering(DutchJavaParser.VeranderingContext ctx);

    /**
     * Visit a parse tree produced by {@link DutchJavaParser#veranderingWithMethod}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitVeranderingWithMethod(DutchJavaParser.VeranderingWithMethodContext ctx);

    /**
     * Visit a parse tree produced by {@link DutchJavaParser#conditie_block}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitConditie_block(DutchJavaParser.Conditie_blockContext ctx);

    /**
     * Visit a parse tree produced by the {@code statementBlok}
     * labeled alternative in {@link DutchJavaParser#stat_blok}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitStatementBlok(DutchJavaParser.StatementBlokContext ctx);

    /**
     * Visit a parse tree produced by {@link DutchJavaParser#func_stat_blok}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFunc_stat_blok(DutchJavaParser.Func_stat_blokContext ctx);

    /**
     * Visit a parse tree produced by {@link DutchJavaParser#methodeAANROEP}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitMethodeAANROEP(DutchJavaParser.MethodeAANROEPContext ctx);

    /**
     * Visit a parse tree produced by {@link DutchJavaParser#methodeUITVOERING}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitMethodeUITVOERING(DutchJavaParser.MethodeUITVOERINGContext ctx);

    /**
     * Visit a parse tree produced by {@link DutchJavaParser#argument}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitArgument(DutchJavaParser.ArgumentContext ctx);

    /**
     * Visit a parse tree produced by {@link DutchJavaParser#argument_uitvoering}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitArgument_uitvoering(DutchJavaParser.Argument_uitvoeringContext ctx);

    /**
     * Visit a parse tree produced by {@link DutchJavaParser#argument_type}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitArgument_type(DutchJavaParser.Argument_typeContext ctx);

    /**
     * Visit a parse tree produced by the {@code vergelijkingExpr}
     * labeled alternative in {@link DutchJavaParser#expressie}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitVergelijkingExpr(DutchJavaParser.VergelijkingExprContext ctx);

    /**
     * Visit a parse tree produced by the {@code ofofExpr}
     * labeled alternative in {@link DutchJavaParser#expressie}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitOfofExpr(DutchJavaParser.OfofExprContext ctx);

    /**
     * Visit a parse tree produced by the {@code gelijkheidExpr}
     * labeled alternative in {@link DutchJavaParser#expressie}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitGelijkheidExpr(DutchJavaParser.GelijkheidExprContext ctx);

    /**
     * Visit a parse tree produced by the {@code enenExpr}
     * labeled alternative in {@link DutchJavaParser#expressie}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitEnenExpr(DutchJavaParser.EnenExprContext ctx);

    /**
     * Visit a parse tree produced by the {@code atomCondExpr}
     * labeled alternative in {@link DutchJavaParser#expressie}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitAtomCondExpr(DutchJavaParser.AtomCondExprContext ctx);

    /**
     * Visit a parse tree produced by the {@code keerGddModExpr}
     * labeled alternative in {@link DutchJavaParser#value_expressie}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitKeerGddModExpr(DutchJavaParser.KeerGddModExprContext ctx);

    /**
     * Visit a parse tree produced by the {@code minminPlusPlusExpr}
     * labeled alternative in {@link DutchJavaParser#value_expressie}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitMinminPlusPlusExpr(DutchJavaParser.MinminPlusPlusExprContext ctx);

    /**
     * Visit a parse tree produced by the {@code isRekenExpr}
     * labeled alternative in {@link DutchJavaParser#value_expressie}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitIsRekenExpr(DutchJavaParser.IsRekenExprContext ctx);

    /**
     * Visit a parse tree produced by the {@code minusExpr}
     * labeled alternative in {@link DutchJavaParser#value_expressie}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitMinusExpr(DutchJavaParser.MinusExprContext ctx);

    /**
     * Visit a parse tree produced by the {@code plusMinExpr}
     * labeled alternative in {@link DutchJavaParser#value_expressie}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitPlusMinExpr(DutchJavaParser.PlusMinExprContext ctx);

    /**
     * Visit a parse tree produced by the {@code atomValueExpr}
     * labeled alternative in {@link DutchJavaParser#value_expressie}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitAtomValueExpr(DutchJavaParser.AtomValueExprContext ctx);

    /**
     * Visit a parse tree produced by the {@code atomexpressie}
     * labeled alternative in {@link DutchJavaParser#atom}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitAtomexpressie(DutchJavaParser.AtomexpressieContext ctx);

    /**
     * Visit a parse tree produced by the {@code atomInt}
     * labeled alternative in {@link DutchJavaParser#atom}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitAtomInt(DutchJavaParser.AtomIntContext ctx);

    /**
     * Visit a parse tree produced by the {@code atomFloat}
     * labeled alternative in {@link DutchJavaParser#atom}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitAtomFloat(DutchJavaParser.AtomFloatContext ctx);

    /**
     * Visit a parse tree produced by the {@code atomBoolean}
     * labeled alternative in {@link DutchJavaParser#atom}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitAtomBoolean(DutchJavaParser.AtomBooleanContext ctx);

    /**
     * Visit a parse tree produced by the {@code atomId}
     * labeled alternative in {@link DutchJavaParser#atom}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitAtomId(DutchJavaParser.AtomIdContext ctx);

    /**
     * Visit a parse tree produced by the {@code atomString}
     * labeled alternative in {@link DutchJavaParser#atom}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitAtomString(DutchJavaParser.AtomStringContext ctx);
}