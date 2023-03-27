package fr.uga.l3miage.photonum.service;

import java.util.Collection;
import fr.uga.l3miage.photonum.data.domain.Photo;
import fr.uga.l3miage.photonum.service.base.BaseService;

public interface PhotoService extends BaseService<Photo, Long>{
    
    /**
     * Saves a photo object
     *
     * @param photo to be saved
     * @return the photo with an id
     */
    Photo save(Photo photo);

    /**
     * Deletes a photo
     *
     * @param id id of the photo to delete
     * @throws EntityNotFoundException when the entity do not already exists
     */
    void delete(Long id);

}