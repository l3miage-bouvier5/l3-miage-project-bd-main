package fr.uga.l3miage.photonum.data.repo;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import fr.uga.l3miage.photonum.data.domain.Client;
import fr.uga.l3miage.photonum.data.domain.Impression;
import static org.assertj.core.api.Assertions.assertThat;

class ImpressionRepositoryTest extends Base {

    @Autowired
    ImpressionRepository impressionRepository;

    @Test
    void all(){
        Client c1 = Fixtures.newClient();
        c1.setNom("nom");
        Date d = new Date();
        System.out.println(d);
        Impression i1 = Fixtures.newImpression(c1, d);

        Impression i2 = Fixtures.newImpression(c1, d);

        entityManager.persist(c1);
        entityManager.persist(i1);
        entityManager.persist(i2);

        entityManager.flush();
        entityManager.detach(c1);
        entityManager.detach(i1);
        entityManager.detach(i2);

        List<Impression> impressions = impressionRepository.all();
        assertThat(impressions)
                .hasSize(2); 
    }

}
