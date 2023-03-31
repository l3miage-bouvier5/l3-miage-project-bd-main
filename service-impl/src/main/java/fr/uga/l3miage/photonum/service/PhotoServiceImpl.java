package fr.uga.l3miage.photonum.service;

import fr.uga.l3miage.photonum.data.domain.Photo;
import fr.uga.l3miage.photonum.data.repo.PhotoRepository;
//import fr.uga.l3miage.photonum.data.repo.PhotoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.uga.l3miage.photonum.data.domain.Photo;


import java.util.Collection;

@Service
@Transactional
public class PhotoServiceImpl implements PhotoService {


    private final PhotoRepository photoRepository;

    @Autowired
    public PhotoServiceImpl(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }
    
    @Override
    public Photo get(Long id) throws EntityNotFoundException {
        
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public Collection<Photo> list() {
        return photoRepository.all();
    }

    @Override
    public Photo update(Photo object) throws EntityNotFoundException {
        return photoRepository.save(object);
    }

    @Override
    public Photo save(Photo photo) {
        return photoRepository.save(photo);    }

    @Override
    public void delete(Long id) throws EntityNotFoundException {
        Photo photo = get(id);
        if (photo == null) {
            throw new EntityNotFoundException("photo with id=%d not found".formatted(id));
        }

        photoRepository.delete(photo);
    }
    
}
