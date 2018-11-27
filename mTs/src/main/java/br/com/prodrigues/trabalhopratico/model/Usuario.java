/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prodrigues.trabalhopratico.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author prodrigues
 */
@Entity
@Table(name = "TBUSUARIO")
@DiscriminatorValue("USUARIO")
public class Usuario extends Pessoa implements Serializable {

    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }
    
    @Override
    public Long getId() {
        return super.getId(); //To change body of generated methods, choose Tools | Templates.
    }

    @Column(name = "LOGIN", length = 15, nullable = false, unique = false)
    private String login;

    @Column(name = "SENHA", length = 20, nullable = false, unique = false)
    private String senha;

    public Usuario() {

    }

    public Usuario(String login, String senha, String name) {
        this(name);
        this.login = login;
        this.senha = senha;
    }

    public Usuario(String name) {
        super(name);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
