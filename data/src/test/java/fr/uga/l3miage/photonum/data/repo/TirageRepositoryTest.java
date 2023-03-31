package fr.uga.l3miage.photonum.data.repo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import fr.uga.l3miage.photonum.data.domain.Tirage;

import static org.assertj.core.api.Assertions.assertThat;



class TirageRepositoryTest extends Base {

    @Autowired
    TirageRepository tirageRepository;

    @Test
    void all() {
        
        Tirage t1 = Fixtures.newTirage();

        Tirage t2 = Fixtures.newTirage();

        Tirage t3= Fixtures.newTirage();

        entityManager.persist(t1);
        entityManager.persist(t2);
        entityManager.persist(t3);

        entityManager.flush();
        entityManager.detach(t1);
        entityManager.detach(t2);
        entityManager.detach(t3);

        List<Tirage> tirages = tirageRepository.all();
        assertThat(tirages)
                .hasSize(3);
                
    }

}
