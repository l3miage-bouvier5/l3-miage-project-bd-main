package fr.uga.l3miage.photonum.adresse;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import fr.uga.l3miage.photonum.data.domain.Adresse;
import fr.uga.l3miage.photonum.service.AdresseService;
import fr.uga.l3miage.photonum.service.EntityNotFoundException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;


// import org.springframework.http.HttpStatus;
// import org.springframework.web.bind.annotation.*;
// import org.springframework.web.server.ResponseStatusException;

// import java.util.Collection;

@RestController
@RequestMapping(value = "/api/v1", produces = "application/json")
public class AdresseController {

    private final AdresseService adresseService;
    private final AdresseMapper adresseMapper;

    @Autowired
    public AdresseController(AdresseService adresseService, AdresseMapper adresseMapper) {
        this.adresseService = adresseService;
        this.adresseMapper = adresseMapper;       
    }

    @GetMapping("/adresses")
    public Collection<AdresseDTO> adresses() {
        Collection<Adresse> adresses;
        adresses = adresseService.list();
    
        return adresses.stream()
                .map(adresseMapper::entityToDTO)
                .toList();
    }

    @GetMapping("/adresses/{id}")
    public AdresseDTO adresse(@PathVariable("id") @NotNull Long id) {
        try {
            return adresseMapper.entityToDTO(adresseService.get(id));
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, null, e);
        }
    }

    @PostMapping(value = "clients/{id}/adresses", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public AdresseDTO newAdresse(@PathVariable("id") @NotNull Long id,@RequestBody @Valid AdresseDTO adresse) throws EntityNotFoundException {
        var saved = adresseService.save(id, adresseMapper.dtoToEntity(adresse));
        return adresseMapper.entityToDTO(saved);
    }

    @PutMapping(value = "/adresses/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public AdresseDTO updateAdresse(@RequestBody @Valid AdresseDTO adresse, @NotNull @PathVariable("id") Long id) {
        try {
            if (adresse.id().equals(id)) {
                adresseService.get(id);
                var updated = adresseService.update(adresseMapper.dtoToEntity(adresse));
                return adresseMapper.entityToDTO(updated);
            }
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "adresse is not found", e);
        }
    }

    @DeleteMapping("/adresses/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAdresse(@PathVariable("id") @NotNull Long id) {
        try {
            adresseService.delete(id);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, null, e);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, null, e);
        }
    }


}
