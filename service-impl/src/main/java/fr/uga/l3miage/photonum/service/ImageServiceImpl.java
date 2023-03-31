package fr.uga.l3miage.photonum.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fr.uga.l3miage.photonum.data.domain.Album;
import fr.uga.l3miage.photonum.data.domain.Cadre;
import fr.uga.l3miage.photonum.data.domain.Image;
import fr.uga.l3miage.photonum.data.domain.Impression;
import fr.uga.l3miage.photonum.data.domain.Page;
import fr.uga.l3miage.photonum.data.domain.Photo;
import fr.uga.l3miage.photonum.data.domain.Tirage;
import fr.uga.l3miage.photonum.data.repo.ImageRepository;

public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;

    @Autowired
    public ImageServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }
    

    @Override
    public Image get(Long id) throws EntityNotFoundException {
        return imageRepository.get(id);
    }

    @Override
    public Collection<Image> list() {
        return imageRepository.all();
    }

    @Override
    public Image update(Image object) throws EntityNotFoundException {
        return imageRepository.save(object);
    }

    @Override
    public Image save(Image image) {
        return imageRepository.save(image);
    }

    


    @Override
    public void delete(Long id) throws EntityNotFoundException {
        Image image = get(id);
        if (image == null) {
            throw new EntityNotFoundException("image with id=%d not found".formatted(id));
        }
        if(image.getEstPartage()){
            throw new EntityNotFoundException("image with id=%d is shared".formatted(id));
        }
        List<Photo> photos = image.getPhotos();
        for(Photo photo : photos){
            List<Impression> impressions = photo.getImpressions();
            for(Impression impression : impressions){
                //SI la date de l'impression est supérieure à la java.util.date du jour, on ne peut pas supprimer l'image
                if(impression.getDate().after(new java.util.Date())){
                    throw new EntityNotFoundException("photo with id=%d is used in an impression".formatted(photo.getId()));
                }
                
            }
        }
        imageRepository.delete(image);
    }
    
}
