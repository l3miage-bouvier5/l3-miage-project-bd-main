package fr.uga.l3miage.photonum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.uga.l3miage.photonum.data.domain.Commande;
import fr.uga.l3miage.photonum.data.repo.CommandeRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class CommandeServiceImpl implements CommandeService {
    
    private final CommandeRepository commandeRepository;

    @Autowired
    public CommandeServiceImpl(CommandeRepository CommandeRepository) {
        this.commandeRepository = commandeRepository;
    }

    @Override
    public Commande save(Commande commande) {
        return commandeRepository.save(commande);
    }
}
