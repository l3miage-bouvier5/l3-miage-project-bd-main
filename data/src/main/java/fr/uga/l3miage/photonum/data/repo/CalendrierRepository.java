package fr.uga.l3miage.photonum.data.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import fr.uga.l3miage.photonum.data.domain.Calendrier;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class CalendrierRepository implements CRUDRepository<Long, Calendrier> {
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Calendrier save(Calendrier calendrier) {
        entityManager.persist(calendrier);
        return calendrier;
    }

    @Override
    public Calendrier get(Long id) {
        return entityManager.find(Calendrier.class, id);
    }

    @Override
    public void delete(Calendrier commande) {
        entityManager.remove(commande);
    }

    @Override
    public List<Calendrier> all() {
        return entityManager.createQuery("select c from Calendrier c order by c.id", Calendrier.class).getResultList();
    }
}
