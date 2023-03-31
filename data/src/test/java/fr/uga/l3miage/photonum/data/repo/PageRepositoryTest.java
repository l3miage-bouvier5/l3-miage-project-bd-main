package fr.uga.l3miage.photonum.data.repo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import fr.uga.l3miage.photonum.data.domain.Page;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;


class PageRepositoryTest extends Base {

    @Autowired
    PageRepository pageRepository;

    @Test
    void all() {
        Page p1 = Fixtures.newPage();

        Page p2 = Fixtures.newPage();
        // p2.setId((long) 290);
        Page p3 = Fixtures.newPage();
        // p3.setId((long) 3);
        entityManager.merge(p1);
        entityManager.merge(p2);
        entityManager.merge(p3);
        // entityManager.persist(p1);
        // entityManager.persist(p2);
        // entityManager.persist(p3);
        entityManager.flush();
        entityManager.detach(p1);
        entityManager.detach(p2);
        entityManager.detach(p3);

        List<Page> pages = pageRepository.all();
        assertThat(pages)
                .hasSize(3)
                .extracting("id");
    }

}
