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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.uga.l3miage.photonum.data.domain.Impression;
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
    public Collection<ImpressionDTO> impressions(@RequestParam(value = "q", required = false) String query) {
        Collection<Impression> authors;
        if (query == null) {
            authors = imprService.list();
        } else {
            authors = imprService.searchByOwner(query);
        }
        return authors.stream()
                .map(authorMapper::entityToDTO)
                .toList();
    }

    @GetMapping("/impressions/{id}")
    public ImpressionDTO impression(@PathVariable("id") @NotNull Long id) {
        // TODO
        return null;
    }

    @PostMapping(value = "/impressions", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ImpressionDTO newImpression(@RequestBody @Valid ImpressionDTO impression) {
        // TODO
        return null;
    }

    @PutMapping(value = "/impressions/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ImpressionDTO updateImpression(@RequestBody @Valid ImpressionDTO impression, @NotNull @PathVariable("id") Long id) {
        // TODO
        return null;
    }

    @DeleteMapping("/impressions/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteImpression(@PathVariable("id") @NotNull Long id) {
        // TODO
    }
}
