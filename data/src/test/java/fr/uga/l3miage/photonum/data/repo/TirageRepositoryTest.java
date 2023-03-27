package fr.uga.l3miage.photonum.data.repo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import fr.uga.l3miage.photonum.data.domain.Tirage;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;


class TirageRepositoryTest extends Base {

    @Autowired
    TirageRepository tirageRepository;

    @Test
    void all() {
        Tirage a1 = Fixtures.newTirage();
        Tirage a2 = Fixtures.newTirage();
        Tirage a3 = Fixtures.newTirage();
        entityManager.persist(a1);
        entityManager.persist(a2);
        entityManager.persist(a3);
        entityManager.flush();
        entityManager.detach(a1);
        entityManager.detach(a2);
        entityManager.detach(a3);

        List<Tirage> tirages = tirageRepository.all();
        System.out.println(tirages);
        assertThat(tirages.size() == 3);
    }

}
