package fr.uga.l3miage.photonum.commande;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.uga.l3miage.photonum.service.CommandeService;

@RestController
@RequestMapping(value = "/api/v1", produces = "application/json")
public class CommandeController {
    
    private final CommandeService commandeService;
    private final CommandeMapper commandeMapper;

    @Autowired
    public CommandeController(CommandeService commandeService, CommandeMapper commandeMapper){
        this.commandeService = commandeService;
        this.commandeMapper = commandeMapper;
    }
}
