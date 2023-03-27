package fr.uga.l3miage.photonum.data.repo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.assertj.core.api.Assertions.assertThat;

import fr.uga.l3miage.photonum.data.domain.Adresse;


class AdresseRepositoryTest extends Base {

    @Autowired
    AdresseRepository adresseRepository;

    @Test
    void all() {
        Adresse a1 = Fixtures.newAdresse();
        a1.setVille("paris");
        Adresse a2 = Fixtures.newAdresse();
        a2.setVille("grenoble");
        entityManager.persist(a1);
        entityManager.persist(a2);
        entityManager.flush();
        entityManager.detach(a1);
        entityManager.detach(a2);

        List<Adresse> adresses = adresseRepository.all();
        assertThat(adresses.size() == 2);
        assertThat(adresses.get(0)).isEqualTo(a2);
        assertThat(adresses.get(1)).isEqualTo(a1);
    }

}
