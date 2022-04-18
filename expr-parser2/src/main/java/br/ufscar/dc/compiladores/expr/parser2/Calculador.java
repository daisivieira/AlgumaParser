/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufscar.dc.compiladores.expr.parser2;

import br.ufscar.dc.compiladores.expr.parser2.ExpressoesParser.FatorContext;
import br.ufscar.dc.compiladores.expr.parser2.ExpressoesParser.TermoContext;
/**
 *
 * @author daisi
 */
public class Calculador extends ExpressoesBaseVisitor<Double> {

    @Override
    public Double visitPrograma(ExpressoesParser.ProgramaContext ctx) {
        return visitExpressao(ctx.expressao());
    }

    @Override
    public Double visitExpressao(ExpressoesParser.ExpressaoContext ctx) {
        //calculo da expressao aritmetica
        double valor = visitTermo(ctx.termo1); // pegando valor - termo é obrigatorio
        for (int i = 0; i < ctx.outrosTermos.size(); i++) { // varrer lista de termos
            ExpressoesParser.Op1Context op1 = ctx.op1(i); // primeiro operador
            TermoContext ot = ctx.outrosTermos.get(i); // segundo termo
            String strOp1 = op1.getText();
            if (strOp1.equals("+")) {
                valor += visitTermo(ot);
            } else {
                valor -= visitTermo(ot);
            }
        }
        return valor;
    }

    @Override
    public Double visitTermo(ExpressoesParser.TermoContext ctx) {
        double valor = visitFator(ctx.fator1);
        for (int i = 0; i < ctx.outrosFatores.size(); i++) {
            ExpressoesParser.Op2Context op2 = ctx.op2(i);
            FatorContext of = ctx.outrosFatores.get(i);
            String strOp2 = op2.getText();
            if (strOp2.equals("*")) {
                valor *= visitFator(of);
            } else {
                valor /= visitFator(of);
            }
        }
        return valor;
    }

    @Override
    public Double visitFator(ExpressoesParser.FatorContext ctx) {
        if (ctx.NUM() != null) {
            return Double.parseDouble(ctx.NUM().getText());
        } else {
            return visitExpressao(ctx.expressao());
        }
    }
}
