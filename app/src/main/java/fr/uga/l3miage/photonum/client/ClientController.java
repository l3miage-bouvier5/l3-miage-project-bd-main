package fr.uga.l3miage.photonum.client;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.codec.DecodingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

import fr.uga.l3miage.photonum.data.domain.Client;
import fr.uga.l3miage.photonum.service.ClientService;
import fr.uga.l3miage.photonum.service.EntityNotFoundException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping(value = "/api/v1",produces = "application/json")
public class ClientController {
    private final ClientMapper clientMapper;
    private final ClientService clientService;

    @Autowired
    public ClientController(ClientMapper clientMapper, ClientService clientService){
        this.clientService  = clientService;
        this.clientMapper = clientMapper;
    }
    @GetMapping("/clients")
    public Collection<ClientDTO> clients() {
        Collection<Client> clients;
        clients = clientService.list();
        
        return clients.stream()
                .map(clientMapper::entityToDTO)
                .toList();
    }

    @GetMapping("/clients/{id}")
    public ClientDTO author(@PathVariable("id") @NotNull Long id) {
        try {
            return clientMapper.entityToDTO(clientService.get(id));
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, null, e);
        }
    }

    @PostMapping(value = "/clients", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ClientDTO newAuthor(@RequestBody @Valid ClientDTO client) {
        Client saved = clientService.save(clientMapper.dtoToEntity(client));
        return clientMapper.entityToDTO(saved);
    }

    @PutMapping(value = "/clients/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ClientDTO updateAuthor(@RequestBody @Valid ClientDTO client, @NotNull @PathVariable("id") Long id) {
        try {
            if (client.id().equals(id)) {
                clientService.get(id);
                Client updated = clientService.update(clientMapper.dtoToEntity(client));
                return clientMapper.entityToDTO(updated);
            }
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "author is not found", e);
        }
    }

    @DeleteMapping("/clients/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAuthor(@PathVariable("id") @NotNull Long id) {
        try {
            clientService.delete(id);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, null, e);
        } catch (DecodingException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, null, e);
        }
    }

    @GetMapping("/authors/{id}/books")
    public Collection<BookDTO> books(@PathVariable("id") @NotNull Long authorId) {
        try {
            var author = authorService.get(authorId);
            return booksMapper.entityToDTO(author.getBooks());
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, null, e);
        }
    }
}
