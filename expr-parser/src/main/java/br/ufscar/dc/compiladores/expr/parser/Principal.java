/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufscar.dc.compiladores.expr.parser;

import java.io.IOException;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

/**
 *
 * @author daisi
 */
public class Principal {

    public static void main(String args[]) throws IOException {
        CharStream cs = CharStreams.fromFileName(args[0]);
        ExpressoesLexer lexer = new ExpressoesLexer(cs); // criando o lexico
        CommonTokenStream tokens = new CommonTokenStream(lexer); // fluxo de tokens
        ExpressoesParser parser = new ExpressoesParser(tokens);
        int val = parser.programa().val; // chamando a regra programa e pegando o valor
        System.out.println("Valor = " + val);

    }
}
