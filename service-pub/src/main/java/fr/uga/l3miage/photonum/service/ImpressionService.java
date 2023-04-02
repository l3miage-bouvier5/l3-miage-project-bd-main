package fr.uga.l3miage.photonum.service;

import fr.uga.l3miage.photonum.data.domain.Impression;
import fr.uga.l3miage.photonum.service.base.BaseService;


public interface ImpressionService extends BaseService<Impression, Long> {

    /**
     * Saves an impression object
     *
     * @param impression to be saved
     * @return the impression with an id
     */
    Impression saveImpressionWithClientID(Long id,Impression impression) throws EntityNotFoundException;

    /**
     * Deletes an impression
     *
     * @param id id of the impression to delete
     * @throws EntityNotFoundException when the entity do not already exists
     */
    void delete(Long id) throws EntityNotFoundException;


    Impression save(Impression impression) throws EntityNotFoundException;

}