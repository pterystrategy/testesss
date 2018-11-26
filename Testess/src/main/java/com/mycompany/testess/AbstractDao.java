package com.mycompany.testess;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



public abstract class AbstractDao<T> implements IDAO<T> {

    protected EntityManagerFactory factory;
    protected EntityManager em;

    public AbstractDao() {
        factory = Persistence.createEntityManagerFactory("trabalhoPraticoPU");
        em = this.createEntityManager();
    }

    public EntityManager getEntityManager() {
        if (em == null) {
            em = this.createEntityManager();
        }
        return em;
    }

    private EntityManager createEntityManager() {
        return factory.createEntityManager();
    }
    /*#########################################################
    #                                                         #
    #                                                        #
    ########################################################*/
    @Override
    public T create( T entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.flush();
        em.getTransaction().commit();
        em.refresh(entity);
        return entity;
    }
    
    
     @Override
    public T update(T entity) {
        em.getTransaction().begin();
        T merge = this.getEntityManager().merge(entity);
        em.getTransaction().commit();
        
        return merge;
    }
    
    @Override
    public T findById(int id) {
        return this.findById((long)id);
    }
}
