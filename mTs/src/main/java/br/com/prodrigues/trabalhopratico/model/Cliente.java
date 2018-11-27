/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prodrigues.trabalhopratico.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author prodrigues
 */
@Entity
@Table(name = "TBCLIENTE")
@DiscriminatorValue("ClIENTE")
public class Cliente extends Pessoa implements Serializable {

    @Override
    public Long getId() {
        return super.getId(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    @Column(name = "CPF", length = 16, nullable = false, unique = false)
    private String cpf;
    
    @Column(name = "EMAIL", length = 255, nullable = false)
    private String email;
    
    @Column(name = "REGISTRO", length = 20, nullable = true)
    private String registro;
    
    //Telefone
    @OneToMany(mappedBy = "cliente", orphanRemoval = true)
    private List<Telefone> telefones;
    
    //Endereço
    @OneToMany(mappedBy = "cliente", orphanRemoval = true)
    private List<Endereco> enderecos;
    
    @OneToMany(mappedBy = "cliente", cascade =
            {CascadeType.PERSIST, CascadeType.REMOVE}, 
              fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Reserva> reservas;
    
    @OneToMany(mappedBy = "cliente", cascade =
            {CascadeType.PERSIST, CascadeType.REMOVE}, 
              fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Emprestimo> emprestimos;
    
    public Cliente(String cpf, String registro, String name) {
        this(cpf, name);
        this.registro = registro;
    }
    

    public Cliente() {
    }
    
    public Cliente(String name){
        super(name);
    }

    public Cliente(String cpf, String name) {
        this(name);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }    

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(List<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }

    @Override
    public String toString() {
        return this.getId() + super.toString(); //To change body of generated methods, choose Tools | Templates.
    }    
    
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }    
}
