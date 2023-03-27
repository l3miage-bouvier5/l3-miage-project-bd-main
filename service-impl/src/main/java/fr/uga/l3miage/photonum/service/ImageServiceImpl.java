package fr.uga.l3miage.photonum.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import fr.uga.l3miage.photonum.data.domain.Image;
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
        imageRepository.delete(image);
    }
    
}
