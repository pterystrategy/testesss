/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prodrigues.trabalhopratico.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author prodrigues
 */
@Entity
@Table(name = "TBEDITORA")
public class Editora implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CDEDITORA", length = 10, nullable = false)
    private Long id;

    @Column(name = "NNEDITORA", length = 20)
    private String namepublisher;

    @Column(name = "EMAIL", length = 20)
    private String email;

    //Endereço
    @OneToMany(mappedBy = "editora", orphanRemoval = true, cascade = {CascadeType.REMOVE, CascadeType.MERGE})
    private List<Endereco> enderecos = new ArrayList<>();

    //Telefone
    @OneToMany(mappedBy = "editora", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
    private List<Telefone> telefones = new ArrayList<>();

    @OneToMany(orphanRemoval = true)
    @JoinColumn(name = "FKEDITORA")
    private List<Livro> livros;

    public Editora() {
    }

    public Editora(String namepublisher, String email) {
        this.namepublisher = namepublisher;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Editora)) {
            return false;
        }
        Editora other = (Editora) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "Editora[ id=" + id + " ]";
    }

    public String getNamepublisher() {
        return namepublisher;
    }

    public void setNamepublisher(String namepublisher) {
        this.namepublisher = namepublisher;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    public void addEndereco(Telefone add) {
        this.telefones.add(add);
    }

    public void addEndereco(Endereco add) {
        this.enderecos.add(add);
    }
}
