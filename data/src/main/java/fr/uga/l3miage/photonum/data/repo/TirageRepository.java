package fr.uga.l3miage.photonum.data.repo;

import fr.uga.l3miage.photonum.data.domain.Tirage;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TirageRepository implements CRUDRepository<Long, Tirage> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Tirage save(Tirage tirage) {
        entityManager.persist(tirage);
        return tirage;
    }

    @Override
    public Tirage get(Long id) {
        return entityManager.find(Tirage.class, id);
    }


    @Override
    public void delete(Tirage tirage) {
        entityManager.remove(tirage);
    }


    /**
     * Renvoie toutes les tirages
     *
     * @return une liste des tirages 
     */
    @Override
    public List<Tirage> all() {
        return entityManager.createQuery("select t from Tirage t", Tirage.class).getResultList();
    }

}
