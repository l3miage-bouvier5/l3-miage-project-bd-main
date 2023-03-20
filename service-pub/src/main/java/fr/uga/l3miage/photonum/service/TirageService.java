package fr.uga.l3miage.photonum.service;

import fr.uga.l3miage.photonum.data.domain.Tirage;
import fr.uga.l3miage.photonum.service.base.BaseService;

import java.util.Collection;

public interface TirageService extends BaseService<Tirage, Long> {

    Tirage save(Tirage tirage);


}