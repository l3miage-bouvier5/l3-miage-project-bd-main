package fr.uga.l3miage.photonum.data.repo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.assertj.core.api.Assertions.assertThat;

import fr.uga.l3miage.photonum.data.domain.Catalogue;


class CatalogueRepositoryTest extends Base {

    @Autowired
    CatalogueRepository catalogueRepository;

    @Test
    void all() {
        Catalogue a1 = Fixtures.newCatalogue();
        a1.setVille("paris");
        Catalogue a2 = Fixtures.newCatalogue();
        a2.setVille("grenoble");
        entityManager.persist(a1);
        entityManager.persist(a2);
        entityManager.flush();
        entityManager.detach(a1);
        entityManager.detach(a2);

        List<Catalogue> catalogues = catalogueRepository.all();
        assertThat(catalogues.size() == 2);
        assertThat(catalogues.get(0)).isEqualTo(a2);
        assertThat(catalogues.get(1)).isEqualTo(a1);
    }

}
