package fr.uga.l3miage.photonum.data.repo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import fr.uga.l3miage.photonum.data.domain.Client;
import jakarta.persistence.EntityManager;
import static org.assertj.core.api.Assertions.assertThat;

public class ClientRepositoryTest extends Base {
    
    @Autowired
    ClientRepository clientRepository;


    @Autowired
    EntityManager entityManager;
    @Test
    void all(){
        Client c1 = Fixtures.newClient();
        c1.setNom("Adrien");

        Client c2 = Fixtures.newClient();
        c2.setNom("Ficelle");

        Client c3 = Fixtures.newClient();
        c3.setNom("Bastien");

        entityManager.persist(c1);
        entityManager.persist(c2);
        entityManager.persist(c3);

        entityManager.flush();
        entityManager.detach(c1);
        entityManager.detach(c2);
        entityManager.detach(c3);

        List<Client> clients = clientRepository.all();
        assertThat(clients)
                .hasSize(3)
                .extracting("nom")
                .containsExactly("Adrien","Bastien", "Ficelle");
    }
}