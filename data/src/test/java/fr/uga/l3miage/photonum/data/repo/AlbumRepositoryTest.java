package fr.uga.l3miage.photonum.data.repo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


class ImpressionRepositoryTest extends Base {

    @Autowired
    ImpressionRepository authorRepository;

    @Test
    void all() {
        Adresse a1 = Fixtures.newAdresse();
        a1.setVille("grenoble");
        Adresse a2 = Fixtures.newAdresse();
        a1.setVille("paris");
        entityManager.persist(a1);
        entityManager.persist(a2);
        entityManager.flush();
        entityManager.detach(a1);
        entityManager.detach(a2);

        List<Adresse> adresses = adresseRepository.all();
        System.out.println(adresses);
        assertThat(adresses.size() == 2);
        assertThat(adresses.get(0)).isEqualTo(a1);
        assertThat(adresses.get(1)).isEqualTo(a2);
    }

}
