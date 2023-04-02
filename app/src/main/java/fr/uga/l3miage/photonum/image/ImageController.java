package fr.uga.l3miage.photonum.image;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

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

import fr.uga.l3miage.photonum.data.domain.Image;
import fr.uga.l3miage.photonum.data.domain.Page;
import fr.uga.l3miage.photonum.data.domain.Impression;
import fr.uga.l3miage.photonum.data.domain.Photo;
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
            return imageMapper.entityToDTO(image);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, null, e);
            // e.printStackTrace();
        }
    }


    @PutMapping(value = "/images/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ImageDTO updateImage(@PathVariable("id") @NotNull Long id, @RequestBody @Valid ImageDTO imageDTO) {
        try {
            Image image = imageMapper.dtoToEntity(imageDTO);
            if (imageService.get(id).getEstPartage() && !image.getEstPartage()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                        "Une image partagée ne peut pas être départagée");
            } else {
                imageService.update(image);
            }
            return imageMapper.entityToDTO(image);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, null, e);
        }
    }

    @DeleteMapping("/images/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteImage(@PathVariable("id") @NotNull Long id) {
        try {
            if (imageService.get(id).getEstPartage()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                        "Une image partagée ne peut pas être supprimée");
            } else {
                List<Photo> photos = imageService.get(id).getPhotos();
                List<Impression> impressions = new ArrayList<Impression>();
                // dans cadre
                for (Photo photo : photos) {
                    impressions.addAll(photo.getCadres());
                    impressions.addAll(photo.getTirages());
                    impressions.addAll(photo.getAlbums());
                    List<Page> pages = photo.getPages();
                    for (Page page : pages) {
                        impressions.addAll(page.getAlbums());
                        impressions.addAll(page.getCalendriers());
                    }
                }
                for (Impression impression : impressions) {
                    LocalDate date = impression.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                    if ( LocalDate.now().isBefore(date)) {
                        throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                                "Une image liée à une impression en cours ne peut pas être supprimée");
                    }
                }
                imageService.delete(id);
            }
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, null, e);
        }
    }
}
