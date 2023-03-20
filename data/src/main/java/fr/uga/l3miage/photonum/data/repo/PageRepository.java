package fr.uga.l3miage.photonum.data.repo;

import fr.uga.l3miage.photonum.data.domain.Page;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PageRepository implements CRUDRepository<Long, Page> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Page save(Page page) {
        entityManager.persist(page);
        return page;
    }

    @Override
    public Page get(Long id) {
        return entityManager.find(Page.class, id);
    }


    @Override
    public void delete(Page page) {
        entityManager.remove(page);
    }


    /**
     * Renvoie toutes les pages
     *
     * @return une liste des pages trié par id
     */
    @Override
    public List<Page> all() {
        return entityManager.createQuery("select p from Page p order by p.id", Page.class).getResultList();
    }

}
