package fr.uga.l3miage.photonum.commande;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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

    @PostMapping("/commandes")
    @ResponseStatus(HttpStatus.CREATED)
    public CommandeDTO newCommande(@RequestBody @Valid CommandeDTO commande){
        try{
            final var entity = commandeService.save(commandeMapper.dtoToEntity(commande));
            return commandeMapper.entityToDTO(entity);
        } catch (EntityNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, null, e);
        } catch (IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, null, e);
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
