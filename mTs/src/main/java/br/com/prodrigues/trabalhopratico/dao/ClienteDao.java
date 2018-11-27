package br.com.prodrigues.trabalhopratico.dao;

import br.com.prodrigues.trabalhopratico.model.Cliente;
import java.util.List;

public class ClienteDao extends AbstractDao<Cliente> {

    @Override
    public boolean delete(Cliente t) {
        
        em.getTransaction().begin();
        Cliente cliente;
        cliente = em.getReference(Cliente.class, t.getId());

        if (t.equals(cliente)) {
            em.remove(cliente);
            em.getTransaction().commit();
            return true;
        }
        return false;
    }

    @Override
    public Cliente findById(long id) {
        Cliente item = em.find(Cliente.class, id);
        return item;
    }
    @Override
    public List<Cliente> findAll() {
        javax.persistence.criteria.CriteriaQuery cq;
        cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Cliente.class));
        return em.createQuery(cq).getResultList();
    } 


    @Override
    public List<Cliente> find(Cliente t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
}
