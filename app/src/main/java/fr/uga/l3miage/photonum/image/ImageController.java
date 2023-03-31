package fr.uga.l3miage.photonum.image;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import fr.uga.l3miage.photonum.commande.CommandeDTO;
import fr.uga.l3miage.photonum.commande.CommandeMapper;
import fr.uga.l3miage.photonum.data.domain.Client;
import fr.uga.l3miage.photonum.data.domain.Image;
import fr.uga.l3miage.photonum.service.ClientService;
import fr.uga.l3miage.photonum.service.EntityNotFoundException;
import fr.uga.l3miage.photonum.service.ImageService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping(value = "/api/v1",produces = "application/json")
public class ImageController {

    private final ImageMapper imageMapper;
    private final ImageService imageService;


    @Autowired
    public ImageController(ImageMapper imageMapper, ImageService imageService){
        this.imageMapper = imageMapper;
        this.imageService = imageService;
    }

    @GetMapping("/images")
    public Collection<ImageDTO> images() {
        Collection<Image> images;
        images = imageService.list();
        
        return images.stream()
                .map(imageMapper::entityToDTO)
                .toList();
    }

    @GetMapping("/images/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ImageDTO image(@PathVariable("id") @NotNull Long id) {
        try {
            return imageMapper.entityToDTO(imageService.get(id));
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, null, e);
        }
    }


    @PostMapping(value = "/images", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ImageDTO createImage(@RequestBody @Valid ImageDTO imageDTO) {
        Image image = imageMapper.dtoToEntity(imageDTO);
        try {
            imageService.update(image);
        } catch (EntityNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return imageMapper.entityToDTO(image);
    }


    @PutMapping(value = "/images/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ImageDTO updateImage(@PathVariable("id") @NotNull Long id, @RequestBody @Valid ImageDTO imageDTO) {
        try {
            Image image = imageMapper.dtoToEntity(imageDTO);
            imageService.update(image);
            return imageMapper.entityToDTO(image);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, null, e);
        }
    }

    @DeleteMapping("/images/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteImage(@PathVariable("id") @NotNull Long id) {
        try {
            imageService.delete(id);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, null, e);
        }
    }
}
