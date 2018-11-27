/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prodrigues.trabalhopratico.model;

/**
 *
 * @author prodrigues
 */
public enum Classificacao {
    
    LINGUAS_LINGUISTICA("LINGUAS_LINGUISTICA"),
    CIENCIAS_EXATAS("CIENCIAS_EXATAS"),
    FILOSOFIA("FILOSOFIA");
    
    private final String classificacao;

    private Classificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    @Override
    public String toString() {
        return classificacao;
    }

    public String getClassificacao() {
        return classificacao;
    }   
}
