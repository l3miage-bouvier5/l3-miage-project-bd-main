package fr.uga.l3miage.photonum.commande;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import fr.uga.l3miage.photonum.data.domain.Article;
import fr.uga.l3miage.photonum.data.domain.Commande;
import fr.uga.l3miage.photonum.service.CommandeService;
import fr.uga.l3miage.photonum.service.EntityNotFoundException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

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

    @GetMapping("/commandes")
    public Collection<CommandeDTO> commandes(){
        return commandeMapper.entityToDTO(commandeService.list());
    }
    
    @GetMapping("/commandes/{id}")
    public CommandeDTO commande(@PathVariable("id") @NotNull Long id){
        try{
            return commandeMapper.entityToDTO(commandeService.get(id));
        } catch (EntityNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, null, e);
        }
    }

    @GetMapping("/clients/{id}/commandes/{idCommande}")
    public CommandeDTO commandeClient(@PathVariable("id") @NotNull Long id,@PathVariable("idCommande") Long idCommande) throws EntityNotFoundException{
        return commandeMapper.entityToDTO(commandeService.getCommandeByClientId(id, idCommande));
    }

    @PostMapping("/clients/{id}/commandes")
    @ResponseStatus(HttpStatus.CREATED)
    public CommandeDTO newCommande(@PathVariable("id") @NotNull Long articleId, @RequestBody @Valid CommandeDTO commande) throws EntityNotFoundException{
        Commande entity = commandeService.save(articleId,commandeMapper.dtoToEntity(commande));
        return commandeMapper.entityToDTO(entity);
    }

    @PutMapping("/commandes/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CommandeDTO updateCommande(@PathVariable("id") @NotNull Long id, @RequestBody @Valid CommandeDTO commande){
        try{
            Commande entity = commandeService.update(commandeMapper.dtoToEntity(commande));
            return commandeMapper.entityToDTO(entity);
        } catch (EntityNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, null, e);
        }
    }

    @DeleteMapping("/commandes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCommande(@PathVariable("id") @NotNull Long id){
        try{
            commandeService.delete(id);
        } catch (EntityNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, null, e);
        }
    }

}
