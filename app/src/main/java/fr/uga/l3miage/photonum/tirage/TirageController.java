package fr.uga.l3miage.photonum.tirage;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import fr.uga.l3miage.photonum.data.domain.Tirage;
import fr.uga.l3miage.photonum.service.EntityNotFoundException;
import fr.uga.l3miage.photonum.service.TirageService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping(value = "/api/v1", produces = "application/json")
public class TirageController {

    private final TirageService tirageService;
    private final TirageMapper tirageMapper;

    @Autowired
    public TirageController(TirageService tirageService, TirageMapper tirageMapper) {
        this.tirageService = tirageService;
        this.tirageMapper = tirageMapper;
    }

    @GetMapping("/tirage")
    public Collection<TirageDTO> impressions() {
        Collection<Tirage> impressions = null;
        
        impressions = tirageService.list();

        return impressions.stream()
                .map(tirageMapper::entityToDTO)
                .toList();
    }

    @GetMapping("/tirage/{id}")
    public TirageDTO impression(@PathVariable("id") @NotNull Long id) {
        try {
            return tirageMapper.entityToDTO(tirageService.get(id));
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, null, e);
        }
    }

    @PostMapping(value = "client/{clientId}/tirage", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public TirageDTO newImpression(@PathVariable("clientId") @NotNull Long clientId,@RequestBody @Valid TirageDTO tirage) throws EntityNotFoundException {
        var saved = tirageService.save(clientId, tirageMapper.dtoToEntity(tirage));
        return tirageMapper.entityToDTO(saved);
    }

    

    @DeleteMapping("/tirage/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAuthor(@PathVariable("id") @NotNull Long id) {
        try {
            tirageService.delete(id);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, null, e);
        }
    }

}
