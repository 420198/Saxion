// Generated from D:/School/kwartiel 3/Compilers en operating systems/DutchJava2\DutchJava.g4 by ANTLR 4.7

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link DutchJavaParser}.
 */
public interface DutchJavaListener extends ParseTreeListener {
    /**
     * Enter a parse tree produced by {@link DutchJavaParser#parse}.
     *
     * @param ctx the parse tree
     */
    void enterParse(DutchJavaParser.ParseContext ctx);

    /**
     * Exit a parse tree produced by {@link DutchJavaParser#parse}.
     *
     * @param ctx the parse tree
     */
    void exitParse(DutchJavaParser.ParseContext ctx);

    /**
     * Enter a parse tree produced by {@link DutchJavaParser#blok}.
     *
     * @param ctx the parse tree
     */
    void enterBlok(DutchJavaParser.BlokContext ctx);

    /**
     * Exit a parse tree produced by {@link DutchJavaParser#blok}.
     *
     * @param ctx the parse tree
     */
    void exitBlok(DutchJavaParser.BlokContext ctx);

    /**
     * Enter a parse tree produced by {@link DutchJavaParser#statement}.
     *
     * @param ctx the parse tree
     */
    void enterStatement(DutchJavaParser.StatementContext ctx);

    /**
     * Exit a parse tree produced by {@link DutchJavaParser#statement}.
     *
     * @param ctx the parse tree
     */
    void exitStatement(DutchJavaParser.StatementContext ctx);

    /**
     * Enter a parse tree produced by {@link DutchJavaParser#read_statement}.
     *
     * @param ctx the parse tree
     */
    void enterRead_statement(DutchJavaParser.Read_statementContext ctx);

    /**
     * Exit a parse tree produced by {@link DutchJavaParser#read_statement}.
     *
     * @param ctx the parse tree
     */
    void exitRead_statement(DutchJavaParser.Read_statementContext ctx);

    /**
     * Enter a parse tree produced by the {@code schrijfId}
     * labeled alternative in {@link DutchJavaParser#print_statement}.
     *
     * @param ctx the parse tree
     */
    void enterSchrijfId(DutchJavaParser.SchrijfIdContext ctx);

    /**
     * Exit a parse tree produced by the {@code schrijfId}
     * labeled alternative in {@link DutchJavaParser#print_statement}.
     *
     * @param ctx the parse tree
     */
    void exitSchrijfId(DutchJavaParser.SchrijfIdContext ctx);

    /**
     * Enter a parse tree produced by the {@code schrijfString}
     * labeled alternative in {@link DutchJavaParser#print_statement}.
     *
     * @param ctx the parse tree
     */
    void enterSchrijfString(DutchJavaParser.SchrijfStringContext ctx);

    /**
     * Exit a parse tree produced by the {@code schrijfString}
     * labeled alternative in {@link DutchJavaParser#print_statement}.
     *
     * @param ctx the parse tree
     */
    void exitSchrijfString(DutchJavaParser.SchrijfStringContext ctx);

    /**
     * Enter a parse tree produced by the {@code schrijfValExpr}
     * labeled alternative in {@link DutchJavaParser#print_statement}.
     *
     * @param ctx the parse tree
     */
    void enterSchrijfValExpr(DutchJavaParser.SchrijfValExprContext ctx);

    /**
     * Exit a parse tree produced by the {@code schrijfValExpr}
     * labeled alternative in {@link DutchJavaParser#print_statement}.
     *
     * @param ctx the parse tree
     */
    void exitSchrijfValExpr(DutchJavaParser.SchrijfValExprContext ctx);

    /**
     * Enter a parse tree produced by the {@code schrijfExpr}
     * labeled alternative in {@link DutchJavaParser#print_statement}.
     *
     * @param ctx the parse tree
     */
    void enterSchrijfExpr(DutchJavaParser.SchrijfExprContext ctx);

    /**
     * Exit a parse tree produced by the {@code schrijfExpr}
     * labeled alternative in {@link DutchJavaParser#print_statement}.
     *
     * @param ctx the parse tree
     */
    void exitSchrijfExpr(DutchJavaParser.SchrijfExprContext ctx);

    /**
     * Enter a parse tree produced by {@link DutchJavaParser#als_statement}.
     *
     * @param ctx the parse tree
     */
    void enterAls_statement(DutchJavaParser.Als_statementContext ctx);

    /**
     * Exit a parse tree produced by {@link DutchJavaParser#als_statement}.
     *
     * @param ctx the parse tree
     */
    void exitAls_statement(DutchJavaParser.Als_statementContext ctx);

    /**
     * Enter a parse tree produced by {@link DutchJavaParser#zolang_statement}.
     *
     * @param ctx the parse tree
     */
    void enterZolang_statement(DutchJavaParser.Zolang_statementContext ctx);

    /**
     * Exit a parse tree produced by {@link DutchJavaParser#zolang_statement}.
     *
     * @param ctx the parse tree
     */
    void exitZolang_statement(DutchJavaParser.Zolang_statementContext ctx);

    /**
     * Enter a parse tree produced by {@link DutchJavaParser#voor_statement}.
     *
     * @param ctx the parse tree
     */
    void enterVoor_statement(DutchJavaParser.Voor_statementContext ctx);

    /**
     * Exit a parse tree produced by {@link DutchJavaParser#voor_statement}.
     *
     * @param ctx the parse tree
     */
    void exitVoor_statement(DutchJavaParser.Voor_statementContext ctx);

    /**
     * Enter a parse tree produced by {@link DutchJavaParser#declarering}.
     *
     * @param ctx the parse tree
     */
    void enterDeclarering(DutchJavaParser.DeclareringContext ctx);

    /**
     * Exit a parse tree produced by {@link DutchJavaParser#declarering}.
     *
     * @param ctx the parse tree
     */
    void exitDeclarering(DutchJavaParser.DeclareringContext ctx);

    /**
     * Enter a parse tree produced by {@link DutchJavaParser#toekenning}.
     *
     * @param ctx the parse tree
     */
    void enterToekenning(DutchJavaParser.ToekenningContext ctx);

    /**
     * Exit a parse tree produced by {@link DutchJavaParser#toekenning}.
     *
     * @param ctx the parse tree
     */
    void exitToekenning(DutchJavaParser.ToekenningContext ctx);

    /**
     * Enter a parse tree produced by {@link DutchJavaParser#toekenningWithMethod}.
     *
     * @param ctx the parse tree
     */
    void enterToekenningWithMethod(DutchJavaParser.ToekenningWithMethodContext ctx);

    /**
     * Exit a parse tree produced by {@link DutchJavaParser#toekenningWithMethod}.
     *
     * @param ctx the parse tree
     */
    void exitToekenningWithMethod(DutchJavaParser.ToekenningWithMethodContext ctx);

    /**
     * Enter a parse tree produced by {@link DutchJavaParser#verandering}.
     *
     * @param ctx the parse tree
     */
    void enterVerandering(DutchJavaParser.VeranderingContext ctx);

    /**
     * Exit a parse tree produced by {@link DutchJavaParser#verandering}.
     *
     * @param ctx the parse tree
     */
    void exitVerandering(DutchJavaParser.VeranderingContext ctx);

    /**
     * Enter a parse tree produced by {@link DutchJavaParser#veranderingWithMethod}.
     *
     * @param ctx the parse tree
     */
    void enterVeranderingWithMethod(DutchJavaParser.VeranderingWithMethodContext ctx);

    /**
     * Exit a parse tree produced by {@link DutchJavaParser#veranderingWithMethod}.
     *
     * @param ctx the parse tree
     */
    void exitVeranderingWithMethod(DutchJavaParser.VeranderingWithMethodContext ctx);

    /**
     * Enter a parse tree produced by {@link DutchJavaParser#conditie_block}.
     *
     * @param ctx the parse tree
     */
    void enterConditie_block(DutchJavaParser.Conditie_blockContext ctx);

    /**
     * Exit a parse tree produced by {@link DutchJavaParser#conditie_block}.
     *
     * @param ctx the parse tree
     */
    void exitConditie_block(DutchJavaParser.Conditie_blockContext ctx);

    /**
     * Enter a parse tree produced by the {@code statementBlok}
     * labeled alternative in {@link DutchJavaParser#stat_blok}.
     *
     * @param ctx the parse tree
     */
    void enterStatementBlok(DutchJavaParser.StatementBlokContext ctx);

    /**
     * Exit a parse tree produced by the {@code statementBlok}
     * labeled alternative in {@link DutchJavaParser#stat_blok}.
     *
     * @param ctx the parse tree
     */
    void exitStatementBlok(DutchJavaParser.StatementBlokContext ctx);

    /**
     * Enter a parse tree produced by {@link DutchJavaParser#func_stat_blok}.
     *
     * @param ctx the parse tree
     */
    void enterFunc_stat_blok(DutchJavaParser.Func_stat_blokContext ctx);

    /**
     * Exit a parse tree produced by {@link DutchJavaParser#func_stat_blok}.
     *
     * @param ctx the parse tree
     */
    void exitFunc_stat_blok(DutchJavaParser.Func_stat_blokContext ctx);

    /**
     * Enter a parse tree produced by {@link DutchJavaParser#methodeAANROEP}.
     *
     * @param ctx the parse tree
     */
    void enterMethodeAANROEP(DutchJavaParser.MethodeAANROEPContext ctx);

    /**
     * Exit a parse tree produced by {@link DutchJavaParser#methodeAANROEP}.
     *
     * @param ctx the parse tree
     */
    void exitMethodeAANROEP(DutchJavaParser.MethodeAANROEPContext ctx);

    /**
     * Enter a parse tree produced by {@link DutchJavaParser#methodeUITVOERING}.
     *
     * @param ctx the parse tree
     */
    void enterMethodeUITVOERING(DutchJavaParser.MethodeUITVOERINGContext ctx);

    /**
     * Exit a parse tree produced by {@link DutchJavaParser#methodeUITVOERING}.
     *
     * @param ctx the parse tree
     */
    void exitMethodeUITVOERING(DutchJavaParser.MethodeUITVOERINGContext ctx);

    /**
     * Enter a parse tree produced by {@link DutchJavaParser#argument}.
     *
     * @param ctx the parse tree
     */
    void enterArgument(DutchJavaParser.ArgumentContext ctx);

    /**
     * Exit a parse tree produced by {@link DutchJavaParser#argument}.
     *
     * @param ctx the parse tree
     */
    void exitArgument(DutchJavaParser.ArgumentContext ctx);

    /**
     * Enter a parse tree produced by {@link DutchJavaParser#argument_uitvoering}.
     *
     * @param ctx the parse tree
     */
    void enterArgument_uitvoering(DutchJavaParser.Argument_uitvoeringContext ctx);

    /**
     * Exit a parse tree produced by {@link DutchJavaParser#argument_uitvoering}.
     *
     * @param ctx the parse tree
     */
    void exitArgument_uitvoering(DutchJavaParser.Argument_uitvoeringContext ctx);

    /**
     * Enter a parse tree produced by {@link DutchJavaParser#argument_type}.
     *
     * @param ctx the parse tree
     */
    void enterArgument_type(DutchJavaParser.Argument_typeContext ctx);

    /**
     * Exit a parse tree produced by {@link DutchJavaParser#argument_type}.
     *
     * @param ctx the parse tree
     */
    void exitArgument_type(DutchJavaParser.Argument_typeContext ctx);

    /**
     * Enter a parse tree produced by the {@code vergelijkingExpr}
     * labeled alternative in {@link DutchJavaParser#expressie}.
     *
     * @param ctx the parse tree
     */
    void enterVergelijkingExpr(DutchJavaParser.VergelijkingExprContext ctx);

    /**
     * Exit a parse tree produced by the {@code vergelijkingExpr}
     * labeled alternative in {@link DutchJavaParser#expressie}.
     *
     * @param ctx the parse tree
     */
    void exitVergelijkingExpr(DutchJavaParser.VergelijkingExprContext ctx);

    /**
     * Enter a parse tree produced by the {@code ofofExpr}
     * labeled alternative in {@link DutchJavaParser#expressie}.
     *
     * @param ctx the parse tree
     */
    void enterOfofExpr(DutchJavaParser.OfofExprContext ctx);

    /**
     * Exit a parse tree produced by the {@code ofofExpr}
     * labeled alternative in {@link DutchJavaParser#expressie}.
     *
     * @param ctx the parse tree
     */
    void exitOfofExpr(DutchJavaParser.OfofExprContext ctx);

    /**
     * Enter a parse tree produced by the {@code gelijkheidExpr}
     * labeled alternative in {@link DutchJavaParser#expressie}.
     *
     * @param ctx the parse tree
     */
    void enterGelijkheidExpr(DutchJavaParser.GelijkheidExprContext ctx);

    /**
     * Exit a parse tree produced by the {@code gelijkheidExpr}
     * labeled alternative in {@link DutchJavaParser#expressie}.
     *
     * @param ctx the parse tree
     */
    void exitGelijkheidExpr(DutchJavaParser.GelijkheidExprContext ctx);

    /**
     * Enter a parse tree produced by the {@code enenExpr}
     * labeled alternative in {@link DutchJavaParser#expressie}.
     *
     * @param ctx the parse tree
     */
    void enterEnenExpr(DutchJavaParser.EnenExprContext ctx);

    /**
     * Exit a parse tree produced by the {@code enenExpr}
     * labeled alternative in {@link DutchJavaParser#expressie}.
     *
     * @param ctx the parse tree
     */
    void exitEnenExpr(DutchJavaParser.EnenExprContext ctx);

    /**
     * Enter a parse tree produced by the {@code atomCondExpr}
     * labeled alternative in {@link DutchJavaParser#expressie}.
     *
     * @param ctx the parse tree
     */
    void enterAtomCondExpr(DutchJavaParser.AtomCondExprContext ctx);

    /**
     * Exit a parse tree produced by the {@code atomCondExpr}
     * labeled alternative in {@link DutchJavaParser#expressie}.
     *
     * @param ctx the parse tree
     */
    void exitAtomCondExpr(DutchJavaParser.AtomCondExprContext ctx);

    /**
     * Enter a parse tree produced by the {@code keerGddModExpr}
     * labeled alternative in {@link DutchJavaParser#value_expressie}.
     *
     * @param ctx the parse tree
     */
    void enterKeerGddModExpr(DutchJavaParser.KeerGddModExprContext ctx);

    /**
     * Exit a parse tree produced by the {@code keerGddModExpr}
     * labeled alternative in {@link DutchJavaParser#value_expressie}.
     *
     * @param ctx the parse tree
     */
    void exitKeerGddModExpr(DutchJavaParser.KeerGddModExprContext ctx);

    /**
     * Enter a parse tree produced by the {@code minminPlusPlusExpr}
     * labeled alternative in {@link DutchJavaParser#value_expressie}.
     *
     * @param ctx the parse tree
     */
    void enterMinminPlusPlusExpr(DutchJavaParser.MinminPlusPlusExprContext ctx);

    /**
     * Exit a parse tree produced by the {@code minminPlusPlusExpr}
     * labeled alternative in {@link DutchJavaParser#value_expressie}.
     *
     * @param ctx the parse tree
     */
    void exitMinminPlusPlusExpr(DutchJavaParser.MinminPlusPlusExprContext ctx);

    /**
     * Enter a parse tree produced by the {@code isRekenExpr}
     * labeled alternative in {@link DutchJavaParser#value_expressie}.
     *
     * @param ctx the parse tree
     */
    void enterIsRekenExpr(DutchJavaParser.IsRekenExprContext ctx);

    /**
     * Exit a parse tree produced by the {@code isRekenExpr}
     * labeled alternative in {@link DutchJavaParser#value_expressie}.
     *
     * @param ctx the parse tree
     */
    void exitIsRekenExpr(DutchJavaParser.IsRekenExprContext ctx);

    /**
     * Enter a parse tree produced by the {@code minusExpr}
     * labeled alternative in {@link DutchJavaParser#value_expressie}.
     *
     * @param ctx the parse tree
     */
    void enterMinusExpr(DutchJavaParser.MinusExprContext ctx);

    /**
     * Exit a parse tree produced by the {@code minusExpr}
     * labeled alternative in {@link DutchJavaParser#value_expressie}.
     *
     * @param ctx the parse tree
     */
    void exitMinusExpr(DutchJavaParser.MinusExprContext ctx);

    /**
     * Enter a parse tree produced by the {@code plusMinExpr}
     * labeled alternative in {@link DutchJavaParser#value_expressie}.
     *
     * @param ctx the parse tree
     */
    void enterPlusMinExpr(DutchJavaParser.PlusMinExprContext ctx);

    /**
     * Exit a parse tree produced by the {@code plusMinExpr}
     * labeled alternative in {@link DutchJavaParser#value_expressie}.
     *
     * @param ctx the parse tree
     */
    void exitPlusMinExpr(DutchJavaParser.PlusMinExprContext ctx);

    /**
     * Enter a parse tree produced by the {@code atomValueExpr}
     * labeled alternative in {@link DutchJavaParser#value_expressie}.
     *
     * @param ctx the parse tree
     */
    void enterAtomValueExpr(DutchJavaParser.AtomValueExprContext ctx);

    /**
     * Exit a parse tree produced by the {@code atomValueExpr}
     * labeled alternative in {@link DutchJavaParser#value_expressie}.
     *
     * @param ctx the parse tree
     */
    void exitAtomValueExpr(DutchJavaParser.AtomValueExprContext ctx);

    /**
     * Enter a parse tree produced by the {@code atomexpressie}
     * labeled alternative in {@link DutchJavaParser#atom}.
     *
     * @param ctx the parse tree
     */
    void enterAtomexpressie(DutchJavaParser.AtomexpressieContext ctx);

    /**
     * Exit a parse tree produced by the {@code atomexpressie}
     * labeled alternative in {@link DutchJavaParser#atom}.
     *
     * @param ctx the parse tree
     */
    void exitAtomexpressie(DutchJavaParser.AtomexpressieContext ctx);

    /**
     * Enter a parse tree produced by the {@code atomInt}
     * labeled alternative in {@link DutchJavaParser#atom}.
     *
     * @param ctx the parse tree
     */
    void enterAtomInt(DutchJavaParser.AtomIntContext ctx);

    /**
     * Exit a parse tree produced by the {@code atomInt}
     * labeled alternative in {@link DutchJavaParser#atom}.
     *
     * @param ctx the parse tree
     */
    void exitAtomInt(DutchJavaParser.AtomIntContext ctx);

    /**
     * Enter a parse tree produced by the {@code atomFloat}
     * labeled alternative in {@link DutchJavaParser#atom}.
     *
     * @param ctx the parse tree
     */
    void enterAtomFloat(DutchJavaParser.AtomFloatContext ctx);

    /**
     * Exit a parse tree produced by the {@code atomFloat}
     * labeled alternative in {@link DutchJavaParser#atom}.
     *
     * @param ctx the parse tree
     */
    void exitAtomFloat(DutchJavaParser.AtomFloatContext ctx);

    /**
     * Enter a parse tree produced by the {@code atomBoolean}
     * labeled alternative in {@link DutchJavaParser#atom}.
     *
     * @param ctx the parse tree
     */
    void enterAtomBoolean(DutchJavaParser.AtomBooleanContext ctx);

    /**
     * Exit a parse tree produced by the {@code atomBoolean}
     * labeled alternative in {@link DutchJavaParser#atom}.
     *
     * @param ctx the parse tree
     */
    void exitAtomBoolean(DutchJavaParser.AtomBooleanContext ctx);

    /**
     * Enter a parse tree produced by the {@code atomId}
     * labeled alternative in {@link DutchJavaParser#atom}.
     *
     * @param ctx the parse tree
     */
    void enterAtomId(DutchJavaParser.AtomIdContext ctx);

    /**
     * Exit a parse tree produced by the {@code atomId}
     * labeled alternative in {@link DutchJavaParser#atom}.
     *
     * @param ctx the parse tree
     */
    void exitAtomId(DutchJavaParser.AtomIdContext ctx);

    /**
     * Enter a parse tree produced by the {@code atomString}
     * labeled alternative in {@link DutchJavaParser#atom}.
     *
     * @param ctx the parse tree
     */
    void enterAtomString(DutchJavaParser.AtomStringContext ctx);

    /**
     * Exit a parse tree produced by the {@code atomString}
     * labeled alternative in {@link DutchJavaParser#atom}.
     *
     * @param ctx the parse tree
     */
    void exitAtomString(DutchJavaParser.AtomStringContext ctx);
}