/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufscar.dc.compiladores.expr.parser3;

import br.ufscar.dc.compiladores.expr.parser3.ExpressoesParser.ProgramaContext;
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
        CharStream cs = CharStreams.fromFileName(args[0]); //construindo
        ExpressoesLexer lexer = new ExpressoesLexer(cs); 
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExpressoesParser parser = new ExpressoesParser(tokens);
        ProgramaContext arvore = parser.programa();
        Calculador c = new Calculador(); // inicializando o calculador - Analisador Semantico
        double val = c.visitPrograma(arvore); // chamando a regra
        System.out.println("Valor calculado: " + val);

    }
}
