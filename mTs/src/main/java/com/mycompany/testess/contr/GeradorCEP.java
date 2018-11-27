/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testess.contr;

import java.util.Random;

/**
 *
 * @author pedro
 */
public class GeradorCEP {
    
    private final Random numeroAleatorio;
    private String numerosContatenados;

    public GeradorCEP() {
        this.numeroAleatorio = new Random();
    }
    
    private String geraCEP() throws Exception{
      //numeros gerados
     int n1 = numeroAleatorio.nextInt(10);
     int n2 = numeroAleatorio.nextInt(10);
     int n3 = numeroAleatorio.nextInt(10);
     int n4 = numeroAleatorio.nextInt(10);
     int n5 = numeroAleatorio.nextInt(10);
     int n6 = numeroAleatorio.nextInt(10);
     int n7 = numeroAleatorio.nextInt(10);
     int n8 = numeroAleatorio.nextInt(10);
     int n9 = numeroAleatorio.nextInt(10);
     
    this.numerosContatenados = String.valueOf(n1) + String.valueOf(n2) + String.valueOf(n3) + String.valueOf(n4) +
                           String.valueOf(n5) + String.valueOf(n6) +"-"+ String.valueOf(n7) +String.valueOf(n8)  +
                           String.valueOf(n9);
     
     return this.numerosContatenados;
     
    }
    
    public String resultadoCep() throws Exception{
        return geraCEP();
    }
            
}
