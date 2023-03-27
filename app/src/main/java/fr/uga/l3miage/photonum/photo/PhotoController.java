package fr.uga.l3miage.photonum.photo;

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
import org.springframework.web.service.annotation.PutExchange;

import fr.uga.l3miage.photonum.data.domain.Photo;
import fr.uga.l3miage.photonum.service.EntityNotFoundException;
import fr.uga.l3miage.photonum.service.PhotoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping(value = "/api/v1", produces = "application/json")
public class PhotoController {

    private final PhotoService photoService;
    private final PhotoMapper photoMapper;

    @Autowired
    public PhotoController(PhotoService photoService, PhotoMapper photoMapper) {
        this.photoService = photoService;
        this.photoMapper = photoMapper;
    }

    @GetMapping("/photos")
    public Collection<PhotoDTO> photos() {
        Collection<Photo> photos = null;
        
        photos = photoService.list();

        return photos.stream()
                .map(photoMapper::entityToDTO)
                .toList();
    }

    @GetMapping("/photos/{id}")
    public PhotoDTO photo(@PathVariable("id") @NotNull Long id) {
        try {
            return photoMapper.entityToDTO(photoService.get(id));
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, null, e);
        }
    }

    @PostMapping(value = "/photos", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public PhotoDTO createPhoto(@RequestBody @Valid PhotoDTO photoDTO) {
        var saved = photoService.save(photoMapper.dtoToEntity(photoDTO));
        return photoMapper.entityToDTO(saved);
    }
    
    @PutMapping(value = "/photos/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public PhotoDTO updatePhoto(@PathVariable("id") @NotNull Long id, @RequestBody @Valid PhotoDTO photoDTO) {
        try {
            var saved = photoService.update(photoMapper.dtoToEntity(photoDTO));
            return photoMapper.entityToDTO(saved);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, null, e);
        }
    }

    @DeleteMapping("/photos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePhoto(@PathVariable("id") @NotNull Long id) throws EntityNotFoundException {
        photoService.delete(id);
    }
    
}
