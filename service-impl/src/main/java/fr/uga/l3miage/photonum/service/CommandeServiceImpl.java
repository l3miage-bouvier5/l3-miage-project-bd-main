package fr.uga.l3miage.photonum.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.uga.l3miage.photonum.data.domain.Adresse;
import fr.uga.l3miage.photonum.data.domain.Article;
import fr.uga.l3miage.photonum.data.domain.Client;
import fr.uga.l3miage.photonum.data.domain.Commande;
import fr.uga.l3miage.photonum.data.repo.ClientRepository;
import fr.uga.l3miage.photonum.data.repo.CommandeRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class CommandeServiceImpl implements CommandeService {
    
    private final CommandeRepository commandeRepository;
    private final ClientRepository clientRepository;

    @Autowired
    public CommandeServiceImpl(CommandeRepository commandeRepository, ClientRepository clientRepository) {
        this.commandeRepository = commandeRepository;
        this.clientRepository = clientRepository;
    }

    @Override
    public Commande save(Long id, Commande commande, List<Article> articles) throws EntityNotFoundException {
        commande.setArticles(articles);
        commandeRepository.save(commande);
        bind(id, commande);
        return commande;
    }

    @Override
    public Commande get(Long id) throws EntityNotFoundException {
        return commandeRepository.get(id);
    }

    @Override
    public Collection<Commande> list() {
        return commandeRepository.all();
    }

    @Override
    public void delete(Long id) throws EntityNotFoundException {
        Commande commande = get(id);
        if (commande == null) {
            throw new EntityNotFoundException("command with id=%d not found".formatted(id));
        }

        commandeRepository.delete(commande);
    }

    @Override
    public Commande update(Commande object) throws EntityNotFoundException {
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }


    public void bind(Long id, Commande commande) throws EntityNotFoundException {
        Client client = clientRepository.get(id);
        if (client == null) {
            throw new EntityNotFoundException("client with id=%d not found".formatted(id));
        }
        client.addCommande(commande);
        commande.setClient(client);
    }

    @Override
    public Commande getCommandeByClientId(Long idClient, Long idCommande) throws EntityNotFoundException{
        List<Commande> commandes = this.clientRepository.get(idClient).getCommandes();

        for (Commande c: commandes) {
            if (c.getId() == idCommande) {
                return c;
            }
        }
        return null;
    }

}
