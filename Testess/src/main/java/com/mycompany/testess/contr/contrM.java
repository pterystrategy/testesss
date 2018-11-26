/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testess.contr;

import br.com.prodrigues.trabalhopratico.model.Autor;
import br.com.prodrigues.trabalhopratico.model.Classificacao;
import br.com.prodrigues.trabalhopratico.model.Cliente;
import br.com.prodrigues.trabalhopratico.model.Editora;
import br.com.prodrigues.trabalhopratico.model.Endereco;
import br.com.prodrigues.trabalhopratico.model.Livro;
import com.mycompany.testess.AbstractDao;
import gerarDados.GeradorCPF;
import gerarDados.GeradorDate;
import gerarDados.GerarDados;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 *
 * @author pedro
 */
public class contrM {

    public static Autor  autor;
    public static Livro livro;
    public static Editora editora;
    public static Cliente cliente;
    public static int cont = 0;
    public static GeradorCEP geradorCEP = new GeradorCEP();
    public static GeradorCPF geradorCPF = new GeradorCPF();
    public static GeradorDate geradorDate = new GeradorDate();
    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 10; i++) {
            criarCliente();
            criarE();
            criarAutor();
            
            criarEnd();
            criarLivro();
        }
    }  
    
    
    public static void criarCliente() throws Exception{
        String nome, cpf, email;
        AbstractDao<Cliente> dao = new AbstractDao<Cliente>() {
            @Override
            public boolean delete(Cliente entity) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public Cliente findById(long id) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public List<Cliente> find(Cliente entity) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public List<Cliente> findAll() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        GerarDados gerarDados = new GerarDados();
        nome = gerarDados.gerarString(6);
        cpf = geradorCPF.mostraResultado();
        email = gerarDados.gerarString(6) +"@"+ gerarDados.gerarString(4)+".com";
        cliente = new Cliente();
        cliente.setName(nome);
        cliente.setCpf(cpf);
        cliente.setEmail(email);
        cliente.setRegistro("");
        Cliente create = dao.create(cliente);
        cliente = create;
    }    
    public static Autor criarAutor() throws ParseException{
        String nome;
        
        AbstractDao<Autor> dao = new AbstractDao<Autor>() {
            @Override
            public boolean delete(Autor entity) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public Autor findById(long id) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public List<Autor> find(Autor entity) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public List<Autor> findAll() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        GerarDados gerarDados = new GerarDados();
        nome = gerarDados.gerarString(7);
        Date date = geradorDate.gerarData();
        autor = new Autor(date, nome);
        Autor create = dao.create(autor);
        autor = create;
        return create;
    }

    public static Editora criarE() throws ParseException{
        String nome, email;
        
        AbstractDao<Editora> dao;
        dao = new AbstractDao<Editora>() {
            
            @Override
            public boolean delete(Editora entity) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public Editora findById(long id) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public List<Editora> find(Editora entity) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public List<Editora> findAll() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        GerarDados gerarDados = new GerarDados();
        nome = gerarDados.gerarString(6);
        email = gerarDados.gerarString(6) +"@"+ gerarDados.gerarString(4)+".com";
        editora = new Editora(nome, email);
        
        Editora create = dao.create(editora);
        editora = create;
        return create;   
    }
    
     public static Endereco criarEnd() throws Exception{
        String logradouro, localidade, bairro, cep; 
        AbstractDao <Endereco> dao;
        dao = new AbstractDao<Endereco>() {
            @Override
            public boolean delete(Endereco entity) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public Endereco findById(long id) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public List<Endereco> find(Endereco entity) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public List<Endereco> findAll() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        GerarDados gerarDados = new GerarDados();
        Endereco endereco = new Endereco();
        logradouro = gerarDados.gerarString(7);
        localidade = gerarDados.gerarString(9);
        bairro = gerarDados.gerarString(6);
        cep = geradorCEP.resultadoCep();
        endereco.setLogradouro(logradouro);
        endereco.setLocalidade(localidade);
        endereco.setBairro(bairro);
        endereco.setCep(cep);
         
        if (cont % 2 == 0) {
             endereco.setCliente(cliente);
             cont++;
         }
         else{
             endereco.setEditora(editora);
             ++cont;
         }
        
        Endereco create = dao.create(endereco);
        
        return create;
     }
    public static Livro criarLivro() throws ParseException{
        String titulo, sinopse;
        Random random = new Random();
        Classificacao[] values = Classificacao.values();
        Date dataDeLancamento;
        AbstractDao<Livro> dao = new AbstractDao<Livro>() {
            @Override
            public boolean delete(Livro entity) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public Livro findById(long id) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public List<Livro> find(Livro entity) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public List<Livro> findAll() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        GerarDados gerarDados = new GerarDados();
        dataDeLancamento = geradorDate.gerarData();
        sinopse =  gerarDados.gerarString(66);
        Classificacao value = values[random.nextInt(values.length)];
        titulo = gerarDados.gerarString(7);
        livro = new Livro(titulo);
        
        livro.setQuantidade(cont);
        livro.setDataDeLancamento(dataDeLancamento);
        livro.setSinopse(sinopse);
        livro.setClassificacao(value);
        livro.setAutor(autor);
        livro.setEditora(editora);
        
        Livro create = dao.create(livro);
        livro = create;
        return create;
    }
}