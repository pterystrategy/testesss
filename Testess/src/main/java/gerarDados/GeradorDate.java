/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerarDados;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author pedro
 */
public class GeradorDate {
    private final DateFormat formatter;
    private final Random random;

    public GeradorDate() {
        this.formatter = new SimpleDateFormat("yyyy-mm-dd");
        this.random = new Random();
    }
    
    
    
    public Date gerarData() throws ParseException{
        
        int day = this.numeroAleatorio(1, 31);
        int month = this.numeroAleatorio(1, 12);
        int year = numeroAleatorio(1967, 2018);
        String sDate = year+ "-"+ month +"-"+day;
        Date date = formatter.parse(sDate);
        
        return date;
    }
    
    private int numeroAleatorio(int min, int max){
    int randomNum = random.nextInt((max - min) + 1) + min;

    return randomNum;
}
}
