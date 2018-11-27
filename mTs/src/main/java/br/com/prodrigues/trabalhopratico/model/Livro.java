/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prodrigues.trabalhopratico.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author prodrigues
 *
 */
@Entity
@Table(name = "TBLIVRO")
public class Livro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CDLIVRO", length = 10, nullable = false)
    private Long id;

    @Column(name = "TITULOLIVRO", length = 20)
    private String titulo;

    @Enumerated(EnumType.STRING)
    @Column(name = "CLASSIFICACAOLIVRO", length = 35)
    private Classificacao classificacao;
    
    @Column(name = "QTD", length = 3, nullable = false)
    private int quantidade;
    
    @ManyToMany(cascade = {
        CascadeType.PERSIST,CascadeType.PERSIST,
        CascadeType.REMOVE})
    @JoinTable(name = "TB_LIVRO_EMPRESTIMO",
        joinColumns = @JoinColumn(name = "FKLIVRO"),
        inverseJoinColumns = @JoinColumn(name = "FKEMPRESTIMO")
    )
    private List<Emprestimo> emprestimos = new ArrayList<>();
    
    @Temporal(TemporalType.DATE)
    @Column(name = "DATALANCAMENTO", nullable = true)
    private Date dataDeLancamento;

    @OneToOne(mappedBy = "livro", cascade
            = {CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.EAGER, optional = false)
    private Reserva reserva;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "FKAUTOR")
    private Autor autor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "FKEDITORA")
    private Editora editora;

    @Column(name = "SINOPSE", length = 125)
    private String sinopse;

//    @OneToMany(mappedBy = "livro", cascade
//            = {CascadeType.PERSIST, CascadeType.REMOVE},
//            fetch = FetchType.EAGER, orphanRemoval = true)
//    private List<Emprestimo> emprestimos;

    public Livro() {

    }

    public Livro(String titulo, Classificacao classificacao) {
        this.titulo = titulo;
        this.classificacao = classificacao;
    }

    public Livro(String titulo) {
        this.titulo = titulo;
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
        if (!(object instanceof Livro)) {
            return false;
        }
        Livro other = (Livro) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "com.trabalhopratico.prodrigues.app.model.Livro[ id=" + id + " ]";
    }

    public Classificacao getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(Classificacao classificacao) {
        this.classificacao = classificacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getDataDeLancamento() {
        return dataDeLancamento;
    }

    public void setDataDeLancamento(Date dataDeLancamento) {
        this.dataDeLancamento = dataDeLancamento;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(List<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }
    
     public void addEmprestimo(Emprestimo emprestimo) {
        this.emprestimos.add(emprestimo);
    }



    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

}
