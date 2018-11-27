/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prodrigues.trabalhopratico.dao;

import br.com.prodrigues.trabalhopratico.model.Editora;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author prorodrigues
 */
public class EditoraDao extends AbstractDao<Editora>{

    @Override
    public boolean delete(Editora entity) {
        em.getTransaction().begin();
        Editora reference = em.getReference(Editora.class, entity.getId());

        if (entity.equals(reference)) {
            em.remove(reference);
            em.getTransaction().commit();
            return true;
        }
        return false;
    }

    @Override
    public Editora findById(long id) {
        Editora item;
        item = em.find(Editora.class, id);
        return item;
    }

    @Override
    public List<Editora> find(Editora entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Editora> findAll() {
        CriteriaQuery cq;
        cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Editora.class));
        return em.createQuery(cq).getResultList();
    }
    
}
