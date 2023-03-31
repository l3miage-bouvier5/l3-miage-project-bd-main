package fr.uga.l3miage.photonum.data.repo;

import fr.uga.l3miage.photonum.data.domain.Client;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientRepository implements CRUDRepository<Long, Client> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Client save(Client entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Override
    public Client get(Long id) {
        return entityManager.find(Client.class, id);
    }

    @Override
    public void delete(Client entity) {
        entityManager.remove(entity);
    }

    @Override
    public List<Client> all() {
        return this.entityManager.createQuery("from Client c order by c.nom",Client.class).getResultList();
    }

    
    
}
