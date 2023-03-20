package fr.uga.l3miage.photonum.service;

import fr.uga.l3miage.photonum.data.domain.Album;
import fr.uga.l3miage.photonum.service.base.BaseService;

import java.util.Collection;

public interface AlbumService extends BaseService<Album, Long> {

    Album save(Album album);


}