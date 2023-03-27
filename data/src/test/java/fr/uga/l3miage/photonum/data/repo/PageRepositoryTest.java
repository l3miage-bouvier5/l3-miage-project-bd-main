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
        Page a1 = Fixtures.newPage();
        a1.setId(Long.valueOf(1));
        Page a2 = Fixtures.newPage();
        a2.setId(Long.valueOf(290));
        Page a3 = Fixtures.newPage();
        a3.setId(Long.valueOf(3));
        entityManager.persist(a1);
        entityManager.persist(a2);
        entityManager.persist(a3);
        entityManager.flush();
        entityManager.detach(a1);
        entityManager.detach(a2);
        entityManager.detach(a3);

        List<Page> pages = pageRepository.all();
        System.out.println(pages);
        assertThat(pages.size() == 3);
        assertThat(pages.get(0)).isEqualTo(a1);
        assertThat(pages.get(1)).isEqualTo(a3);
        assertThat(pages.get(2)).isEqualTo(a2);
    }

}
