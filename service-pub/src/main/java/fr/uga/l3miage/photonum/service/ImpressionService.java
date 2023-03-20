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
    Impression save(Impression impression);


}