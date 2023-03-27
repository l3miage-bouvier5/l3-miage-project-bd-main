package fr.uga.l3miage.photonum.service;

import fr.uga.l3miage.photonum.data.domain.Commande;
import fr.uga.l3miage.photonum.service.base.BaseService;

public interface CommandeService extends BaseService<Commande, Long> {
    
    /* Save command object */
    Commande save(Commande commande);

    /* Search command */
    // Collection<Commande> searchById(Long id);

    /* Deletes command */
    void delete(Long id) throws EntityNotFoundException;
}
