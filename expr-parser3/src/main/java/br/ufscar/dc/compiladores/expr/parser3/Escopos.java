/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufscar.dc.compiladores.expr.parser3;

import java.util.LinkedList;
import java.util.List;
/**
 *
 * @author daisi
 */
public class Escopos {
    private LinkedList<TabelaDeSimbolos> pilhaDeTabelas;

    public Escopos() {
        pilhaDeTabelas = new LinkedList<>();
        criarNovoEscopo(); // começar com o escopo global
    }

    public void criarNovoEscopo() {
        pilhaDeTabelas.push(new TabelaDeSimbolos());
    }

    public TabelaDeSimbolos obterEscopoAtual() { // escopo autal
        return pilhaDeTabelas.peek(); // pegar o topo da pilha sem remover
    }

    public List<TabelaDeSimbolos> percorrerEscoposAninhados() {
        return pilhaDeTabelas; // retornar como lista
    }

    public void abandonarEscopo() {
        pilhaDeTabelas.pop(); // tirar do topo
    }
}
