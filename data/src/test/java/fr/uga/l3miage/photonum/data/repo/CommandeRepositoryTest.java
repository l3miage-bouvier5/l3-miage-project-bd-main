package fr.uga.l3miage.photonum.data.repo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import fr.uga.l3miage.photonum.data.domain.Commande;

public class CommandeRepositoryTest extends Base {
    
    @Autowired
    CommandeRepository commandeRepository;

    @Test
    void all(){
       Commande c1 = Fixtures.newCommande();
       Commande c2 = Fixtures.newCommande();
       Commande c3 = Fixtures.newCommande();

        entityManager.persist(c1);
        entityManager.persist(c2);
        entityManager.persist(c3);
    }
}
