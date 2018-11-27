package br.com.prodrigues.trabalhopratico.dao;

import br.com.prodrigues.trabalhopratico.model.Endereco;
import java.util.List;

public class EnderecoDao extends AbstractDao<Endereco> {

    @Override
    public boolean delete(Endereco entity) {
        em.getTransaction().begin();
        Endereco endereco;
        endereco = em.getReference(Endereco.class, entity.getId());
        
        if (endereco.equals(entity)) {
            em.remove(entity);
            em.getTransaction().commit();
            return true;
        }
        return false;
    }

    @Override
    public Endereco findById(long id) {
        return this.em.find(Endereco.class, id);
    }

    @Override
    public List<Endereco> find(Endereco entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Endereco> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}