package br.com.prodrigues.trabalhopratico.dao;

import java.util.List;

public interface IDAO<T> {

    public T create(T entity);

    public boolean delete(T entity);

    public T update(T entity);

    public T findById(int id);

    public T findById(long id);

    public List<T> find(T entity);

    public List<T> findAll();
}
