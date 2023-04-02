package fr.uga.l3miage.photonum.data.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import fr.uga.l3miage.photonum.data.domain.Catalogue;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class CatalogueRepository implements CRUDRepository<Long, Catalogue> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Catalogue save(Catalogue entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Override
    public Catalogue get(Long id) {
        return entityManager.find(Catalogue.class, id);
    }

    @Override
    public void delete(Catalogue entity) {
        entityManager.remove(entity);
    }

    @Override
    public List<Catalogue> all() {
        return this.entityManager.createQuery("from Catalogue c",Catalogue.class).getResultList();
    }
    
}
