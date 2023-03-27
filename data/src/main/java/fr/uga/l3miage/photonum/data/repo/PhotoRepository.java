package fr.uga.l3miage.photonum.data.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import fr.uga.l3miage.photonum.data.domain.Photo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class PhotoRepository implements CRUDRepository<Long, Photo> {

    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public Photo save(Photo entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Override
    public Photo get(Long id) {
        return entityManager.find(Photo.class, id);
    }

    @Override
    public void delete(Photo entity) {
        entityManager.remove(entity);
    }

    /**
     * Renvoie toutes les photos
     *
     * @return une liste d'photos trié par id
     */
    @Override
    public List<Photo> all() {
        return entityManager.createQuery("select p from Photo p order by p.id", Photo.class).getResultList();
    }
    
}
