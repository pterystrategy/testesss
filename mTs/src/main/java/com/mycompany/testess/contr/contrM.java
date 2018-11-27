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
import br.com.prodrigues.trabalhopratico.dao.AbstractDao;
import br.com.prodrigues.trabalhopratico.dao.AutorDao;
import br.com.prodrigues.trabalhopratico.dao.ClienteDao;
import br.com.prodrigues.trabalhopratico.dao.EditoraDao;
import br.com.prodrigues.trabalhopratico.dao.EnderecoDao;
import br.com.prodrigues.trabalhopratico.dao.LivroDao;
import gerarDados.GeradorCPF;
import gerarDados.GeradorDate;
import gerarDados.GerarDados;
import java.text.ParseException;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author pedro
 */
public class contrM {

    public static Autor  autor;
    public static AbstractDao dao;
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
        dao = new ClienteDao();
        GerarDados gerarDados = new GerarDados();
        nome = gerarDados.gerarString(6);
        cpf = geradorCPF.mostraResultado();
        email = gerarDados.gerarString(6) +"@"+ gerarDados.gerarString(4)+".com";
        cliente = new Cliente();
        cliente.setName(nome);
        cliente.setCpf(cpf);
        cliente.setEmail(email);
        cliente.setRegistro("");
        Cliente create = (Cliente) dao.create(cliente);
        cliente = create;
    }    
    public static Autor criarAutor() throws ParseException{
        String nome;
        
        dao = new AutorDao();
        
        GerarDados gerarDados = new GerarDados();
        nome = gerarDados.gerarString(7);
        Date date = geradorDate.gerarData();
        autor = new Autor(date, nome);
        Autor create = (Autor) dao.create(autor);
        autor = create;
        return create;
    }

    public static Editora criarE() throws ParseException{
        String nome, email;
        
        
        dao = new EditoraDao();
        GerarDados gerarDados = new GerarDados();
        nome = gerarDados.gerarString(6);
        email = gerarDados.gerarString(6) +"@"+ gerarDados.gerarString(4)+".com";
        editora = new Editora(nome, email);
        
        Editora create = (Editora) dao.create(editora);
        editora = create;
        return create;   
    }
    
     public static Endereco criarEnd() throws Exception{
        String logradouro, localidade, bairro, cep; 
        AbstractDao dao;
        dao = new EnderecoDao();
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
        
       Endereco create  = (Endereco) dao.create(endereco);
        
        return create;
     }
    public static Livro criarLivro() throws ParseException{
        String titulo, sinopse;
        Random random = new Random();
        Classificacao[] values = Classificacao.values();
        Date dataDeLancamento;
        dao = new LivroDao();
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
        
        Livro create = (Livro) dao.create(livro);
        livro = create;
        return create;
    }
}