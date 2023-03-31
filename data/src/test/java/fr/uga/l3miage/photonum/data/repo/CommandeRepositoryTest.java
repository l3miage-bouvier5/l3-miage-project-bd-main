package fr.uga.l3miage.photonum.data.repo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import fr.uga.l3miage.photonum.data.domain.Commande;

import static org.assertj.core.api.Assertions.assertThat;

public class CommandeRepositoryTest extends Base {
    
    @Autowired
    CommandeRepository commandeRepository;

    @Test
    void all(){
        Commande c1 = Fixtures.newCommande();
        c1.setPrixTotal((float) 420.0);
        Commande c2 = Fixtures.newCommande();
        c2.setPrixTotal((float) 44.0);
        Commande c3 = Fixtures.newCommande();
        c3.setPrixTotal((float) 33.0);

        entityManager.persist(c1);
        entityManager.persist(c2);
        entityManager.persist(c3);

        entityManager.flush();

        entityManager.detach(c1);
        entityManager.detach(c2);
        entityManager.detach(c3);

        List<Commande> commandes = commandeRepository.all();
        assertThat(commandes)
                .hasSize(3)
                .extracting("prixTotal")
                .containsExactly((float) 420.0, (float) 44.0, (float) 33.0);
    }
}
