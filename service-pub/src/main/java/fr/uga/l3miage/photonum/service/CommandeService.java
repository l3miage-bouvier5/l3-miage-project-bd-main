package fr.uga.l3miage.photonum.service;

import java.util.Collection;
import java.util.List;

import fr.uga.l3miage.photonum.data.domain.Article;
import fr.uga.l3miage.photonum.data.domain.Commande;
import fr.uga.l3miage.photonum.service.base.BaseService;

public interface CommandeService extends BaseService<Commande, Long> {
    
    /* Save command object */
    Commande save(Long id, Commande commande, List<Article> articles) throws EntityNotFoundException;

    /* Search command */
    Commande getCommandeByClientId(Long idClient, Long idCommande) throws EntityNotFoundException;

    /* Deletes command */
    void delete(Long id) throws EntityNotFoundException;
}
