/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prodrigues.trabalhopratico.dao;

import br.com.prodrigues.trabalhopratico.model.Emprestimo;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author prorodrigues
 */
public class EmprestimoDao extends AbstractDao<Emprestimo> {

    @Override
    public boolean delete(Emprestimo entity) {
        em.getTransaction().begin();
        Emprestimo reference = em.getReference(Emprestimo.class, entity.getId());

        if (entity.equals(reference)) {
            em.remove(reference);
            em.getTransaction().commit();
            return true;
        }
        return false;
    }
    
    @Override
    public Emprestimo findById(long id) {
        Emprestimo item = em.find(Emprestimo.class, id);
        return item;
    }

    @Override
    public List<Emprestimo> find(Emprestimo entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Emprestimo> findAll() {
        CriteriaQuery cq;
        cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Emprestimo.class));
        return em.createQuery(cq).getResultList();
    }
}
