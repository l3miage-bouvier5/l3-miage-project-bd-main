package fr.uga.l3miage.photonum.data.repo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.EntityManager;

public class CommandeRepositoryTest extends Base {
    
    @Autowired
    CommandeRepository commandeRepository;

    @Autowired
    EntityManager entityManager;

    @Test
    void all(){
        //TODO A COMPLETER (svp laissez moi m'en occuper bisous, Vincent)
    }
}
