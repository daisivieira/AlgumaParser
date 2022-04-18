/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufscar.dc.compiladores.expr.parser3;

import br.ufscar.dc.compiladores.expr.parser3.ExpressoesParser.DeclContext;
import br.ufscar.dc.compiladores.expr.parser3.ExpressoesParser.TermoContext;
import java.util.List;

/**
 *
 * @author daisi
 */
public class Calculador extends ExpressoesBaseVisitor<Double> {

    Escopos escoposAninhados = new Escopos(); 

    @Override
    public Double visitPrograma(ExpressoesParser.ProgramaContext ctx) {
        return visitExp(ctx.exp()); //fazendo uma visita na expressão
    }

    @Override
    public Double visitExp(ExpressoesParser.ExpContext ctx) {
        double valor = visitTermo(ctx.termo1); // pegar do termo 1
        for (TermoContext ot : ctx.outrosTermos) { // varrer os outros termos
            valor += visitTermo(ot); 
        }
        return valor;
    }

    @Override
    public Double visitTermo(ExpressoesParser.TermoContext ctx) {
        if (ctx.expParentesis != null) { //se for expressao de parenteses
            return visitExp(ctx.expParentesis); 
        } else if (ctx.constante != null) { // se for constante
            return Double.parseDouble(ctx.constante.getText()); 
        } else if (ctx.variavel != null) { //se for uma variavel
            List<TabelaDeSimbolos> escopos = escoposAninhados.percorrerEscoposAninhados();
            for (TabelaDeSimbolos ts : escopos) {
                EntradaTabelaDeSimbolos etds = ts.verificar(ctx.variavel.getText());
                if (etds != null) {
                    return etds.valor;
                }
            }
            throw new RuntimeException("Erro semântico: "
                    + ctx.variavel.getText() + " não foi declarada antes do uso");
        } else {
            escoposAninhados.criarNovoEscopo();
            visitListaDecl(ctx.listaDecl());
            double retorno = visitExp(ctx.subexp);
            escoposAninhados.abandonarEscopo();
            return retorno;
        }
    }

    @Override
    public Double visitDecl(ExpressoesParser.DeclContext ctx) {
        TabelaDeSimbolos escopoAtual = escoposAninhados.obterEscopoAtual();
        if (escopoAtual.verificar(ctx.nome.getText()) != null) {
            throw new RuntimeException("Erro semântico: " + ctx.nome.getText()
                    + " declarada duas vezes num mesmo escopo");
        } else {
            escopoAtual.inserir(ctx.nome.getText(), visitExp(ctx.exp()));
        }

        return null; // declaração não tem valor
    }

    @Override
    public Double visitListaDecl(ExpressoesParser.ListaDeclContext ctx) {
        for (DeclContext d : ctx.decl()) {
            visitDecl(d);
        }
        return null; // declaração não tem valor
    }
}
