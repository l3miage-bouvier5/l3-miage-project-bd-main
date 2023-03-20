package fr.uga.l3miage.photonum.service;

import java.util.Collection;

import fr.uga.l3miage.photonum.data.domain.Commande;
import fr.uga.l3miage.photonum.service.base.BaseService;

public class CommandeService extends BaseService<Commande, Long> {
    
    /* Save command object */
    Commande save(Commande commande);

    /* Search command   */
    // Collection<Commande> searchByName(String name);

    /* Deletes command */
    // void delete(Long id) throws EntityNotFoundException, DeleteAuthorException;
}
