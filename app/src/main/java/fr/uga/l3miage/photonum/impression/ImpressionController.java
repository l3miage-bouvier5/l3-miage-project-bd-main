package fr.uga.l3miage.photonum.impression;

import java.util.Collection;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
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

import fr.uga.l3miage.photonum.data.domain.Impression;
import fr.uga.l3miage.photonum.service.EntityNotFoundException;
import fr.uga.l3miage.photonum.service.ImpressionService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping(value = "/api/v1", produces = "application/json")
public class ImpressionController {

    private final ImpressionService imprService;
    private final ImpressionMapper imprMapper;

    @Autowired
    public ImpressionController(ImpressionService imprService, ImpressionMapper imprMapper) {
        this.imprService = imprService;
        this.imprMapper = imprMapper;
    }

    @GetMapping("/impressions")
    public Collection<ImpressionDTO> impressions() {
        Collection<Impression> impressions = null;
        
        impressions = imprService.list();

        return impressions.stream()
                .map(imprMapper::entityToDTO)
                .toList();
    }

    @GetMapping("/impressions/{id}")
    public ImpressionDTO impression(@PathVariable("id") @NotNull Long id) {
        try {
            return imprMapper.entityToDTO(imprService.get(id));
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, null, e);
        }
    }

    @PostMapping(value = "client/{clientId}/impressions", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ImpressionDTO newImpression(@PathVariable("clientId") @NotNull Long clientId,@RequestBody @Valid ImpressionDTO impression) throws EntityNotFoundException {
        var saved = imprService.save(clientId,imprMapper.dtoToEntity(impression));
        return imprMapper.entityToDTO(saved);
        
    }

    @PutMapping(value = "/impressions/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ImpressionDTO updateImpression(@RequestBody @Valid ImpressionDTO impression, @NotNull @PathVariable("id") Long id) {
        try {
            if (impression.id().equals(id)) {
                imprService.get(id);
                var updated = imprService.update(imprMapper.dtoToEntity(impression));
                return imprMapper.entityToDTO(updated);
            }
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "impression is not found", e);
        }
    }

    @DeleteMapping("/impressions/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAuthor(@PathVariable("id") @NotNull Long id) {
        try {
            imprService.delete(id);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, null, e);
        }
    }
}
