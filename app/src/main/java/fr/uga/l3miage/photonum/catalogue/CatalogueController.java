package fr.uga.l3miage.photonum.catalogue;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.uga.l3miage.photonum.data.domain.Catalogue;
import fr.uga.l3miage.photonum.service.CatalogueService;
import fr.uga.l3miage.photonum.service.EntityNotFoundException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.codec.DecodingException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.Collection;

@RestController
@RequestMapping(value = "/api/v1", produces = "application/json")
public class CatalogueController {

    private final CatalogueMapper catalogueMapper;
    private final CatalogueService catalogueService;


    @Autowired
    public CatalogueController(CatalogueMapper catalogueMapper, CatalogueService catalogueService){
        this.catalogueMapper  = catalogueMapper;
        this.catalogueService = catalogueService;
    }

    @GetMapping("/catalogues")
    public Collection<CatalogueDTO> articles() {
        Collection<Catalogue> catalogues;
        catalogues = catalogueService.list();
        
        return catalogues.stream()
                .map(catalogueMapper::entityToDTO)
                .toList();
    }


    @GetMapping("/catalogues/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CatalogueDTO article(@PathVariable("id") @NotNull Long id) {
        try {
            return catalogueMapper.entityToDTO(catalogueService.get(id));
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, null, e);
        }
    }


    @PostMapping(value = "/catalogues", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public CatalogueDTO newArticle(@RequestBody @Valid CatalogueDTO article) {
        Catalogue saved = catalogueService.save(catalogueMapper.dtoToEntity(article));
        return catalogueMapper.entityToDTO(saved);
    }
    
    @PutMapping(value = "/catalogues/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public CatalogueDTO updateArticle(@RequestBody @Valid CatalogueDTO catalogue, @NotNull @PathVariable("id") Long id) {
        try {
            if (catalogue.id().equals(id)) {
                catalogueService.get(id);
                Catalogue updated = catalogueService.update(catalogueMapper.dtoToEntity(catalogue));
                return catalogueMapper.entityToDTO(updated);
            }
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "article is not found", e);
        }
    }


    @DeleteMapping("/catalogues/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteArticle(@PathVariable("id") @NotNull Long id) {
        try {
            catalogueService.delete(id);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, null, e);
        } catch (DecodingException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, null, e);
        }
    }

}
