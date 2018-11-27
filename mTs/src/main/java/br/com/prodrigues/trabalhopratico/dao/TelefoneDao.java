package br.com.prodrigues.trabalhopratico.dao;

import br.com.prodrigues.trabalhopratico.model.Telefone;
import java.util.List;

public class TelefoneDao extends AbstractDao<Telefone> {

    @Override
    public boolean delete(Telefone entity) {
          
        em.getTransaction().begin();
        Telefone reference = em.getReference(Telefone.class, entity.getId());

        if (entity.equals(reference)) {
            em.remove(reference);
            em.getTransaction().commit();
            return true;
        }
        return false;
    }
    
    @Override
    public Telefone findById(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Telefone> find(Telefone entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Telefone> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}