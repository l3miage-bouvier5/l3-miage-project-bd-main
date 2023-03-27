package fr.uga.l3miage.photonum.data.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import fr.uga.l3miage.photonum.data.domain.Image;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class ImageRepository implements CRUDRepository<Long, Image> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Image save(Image entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Override
    public Image get(Long id) {
        return entityManager.find(Image.class, id);
    }

    @Override
    public void delete(Image entity) {
        entityManager.remove(entity);
    }

    @Override
    public List<Image> all() {
        return entityManager.createQuery("select i from Image i order by i.id", Image.class).getResultList();
    }
    

    // Test pour les images partagées
    public List<Image> allShared() {
        return entityManager.createQuery("select i from Image i where i.estPartage = true order by i.id", Image.class).getResultList();
    }


    // Test pour les images d'un client donné
    public List<Image> allClient(Long id) {
        return entityManager.createQuery("select i from Image i where i.proprietaireImage.id = :id order by i.id", Image.class)
        .setParameter("id", id)
        .getResultList();
    }
}
