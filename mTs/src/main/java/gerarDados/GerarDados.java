/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerarDados;

import java.util.Random;

/**
 *
 * @author pedro
 */
public class GerarDados {

    private String nome;

    private final Random rand;
    private final char[] letras;

    public GerarDados() {
        rand = new Random();
        letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZÁÉÍÓÚÃÕÂÊÎÔÛÀÈÌÒÙÇ".toCharArray();
        nome = "";
    }

    public String gerarString(int tam) {
         StringBuilder sb = new StringBuilder();
    for (int i = 0; i <tam; i++) {
        int ch = rand.nextInt (letras.length);
        sb.append (letras [ch]);
    }
    nome = sb.toString();
    return nome;  
    }
}
