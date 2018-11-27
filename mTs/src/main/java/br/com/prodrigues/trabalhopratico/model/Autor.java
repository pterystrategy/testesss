/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prodrigues.trabalhopratico.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author prodrigues
 */
@Entity
@Table(name = "TBAUTOR")
@DiscriminatorValue("AUTOR")
public class Autor extends Pessoa implements Serializable {

    @Override
    public Long getId() {
        return super.getId(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
    @JoinColumn(name = "FKAUTOR")
    private List<Livro> livros;
    
    @Column(name = "DTNASC", nullable = true)
    @Temporal(TemporalType.DATE)
    private Date nascimento;

    public Autor(Date nascimento, String name) {
        this(name);
        this.nascimento = nascimento;
    }
    
    public Autor() {
        
    }

    public Autor(String name) {
        super(name);
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }
    
    public String getDate(){
        return Integer.toString(this.nascimento.getDay()) +"-"
                + Integer.toString(this.nascimento.getMonth()) 
                + Integer.toString(this.nascimento.getYear());
    }
}
