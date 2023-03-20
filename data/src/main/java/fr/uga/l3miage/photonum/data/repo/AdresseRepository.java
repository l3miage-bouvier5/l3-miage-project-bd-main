package fr.uga.l3miage.photonum.data.repo;

import fr.uga.l3miage.photonum.data.domain.Adresse;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdresseRepository implements CRUDRepository<Long, Adresse> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Adresse save(Adresse adresse) {
        entityManager.persist(adresse);
        return adresse;
    }

    @Override
    public Adresse get(Long id) {
        return entityManager.find(Adresse.class, id);
    }


    @Override
    public void delete(Adresse adresse) {
        entityManager.remove(adresse);
    }


    /**
     * Renvoie toutes les adresses
     *
     * @return une liste d'adresses trié par la ville
     */
    @Override
    public List<Adresse> all() {
        return entityManager.createQuery("select a from Adresse a order by a.ville", Adresse.class).getResultList();
    }

}
