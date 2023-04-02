package fr.uga.l3miage.photonum.calendrier;

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

import fr.uga.l3miage.photonum.data.domain.Calendrier;
import fr.uga.l3miage.photonum.service.CalendrierService;
import fr.uga.l3miage.photonum.service.EntityNotFoundException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;


@RestController
@RequestMapping(value = "/api/v1", produces = "application/json")
public class CalendrierController {
    private final CalendrierMapper calendrierMapper;
    private final CalendrierService calendrierService;


    @Autowired
    public CalendrierController(CalendrierMapper calendrierMapper, CalendrierService calendrierService){
        this.calendrierMapper = calendrierMapper;
        this.calendrierService = calendrierService;
    }

    @GetMapping("/calendriers")
    public Collection<CalendrierDTO> calendriers() {
        Collection<Calendrier> calendriers;
        calendriers = calendrierService.list();
        
        return calendriers.stream()
                .map(calendrierMapper::entityToDTO)
                .toList();
    }


    @GetMapping("/calendriers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CalendrierDTO calendrier(@PathVariable("id") @NotNull Long id) {
        try {
            return calendrierMapper.entityToDTO(calendrierService.get(id));
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, null, e);
        }
    }


    @PostMapping(value = "clients/{id}/calendriers", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public CalendrierDTO newCalendrier(@RequestBody @Valid CalendrierDTO calendrier,@PathVariable("id") Long id) throws EntityNotFoundException {
        Calendrier saved = calendrierService.save(calendrierMapper.dtoToEntity(calendrier),id);
        return calendrierMapper.entityToDTO(saved);
    }
    
    @PutMapping(value = "/calendriers/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public CalendrierDTO updateCalendrier(@RequestBody @Valid CalendrierDTO calendrier, @NotNull @PathVariable("id") Long id) {
        try {
            if (calendrier.id().equals(id)) 
            {
                calendrierService.get(id);
                Calendrier updated = calendrierService.update(calendrierMapper.dtoToEntity(calendrier));
                return calendrierMapper.entityToDTO(updated);
            }
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "article is not found", e);
        }
    }


    @DeleteMapping("/calendriers/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteArticle(@PathVariable("id") @NotNull Long id) {
        try {
            calendrierService.delete(id);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, null, e);
        } catch (DecodingException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, null, e);
        }
    }
}
