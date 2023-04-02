package fr.uga.l3miage.photonum.data.repo;

import fr.uga.l3miage.photonum.data.domain.Catalogue;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CatalogueRepository implements CRUDRepository<Long, Catalogue> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Catalogue save(Catalogue catalogue) {
        entityManager.persist(catalogue);
        return catalogue;
    }

    @Override
    public Catalogue get(Long id) {
        return entityManager.find(Catalogue.class, id);
    }


    @Override
    public void delete(Catalogue catalogue) {
        entityManager.remove(catalogue);
    }


    /**
     * Renvoie toutes les catalogues
     *
     * @return une liste d'catalogues trié par le prix
     */
    @Override
    public List<Catalogue> all() {
        return entityManager.createQuery("select a from Catalogue a order by a.prix", Catalogue.class).getResultList();
    }

}
