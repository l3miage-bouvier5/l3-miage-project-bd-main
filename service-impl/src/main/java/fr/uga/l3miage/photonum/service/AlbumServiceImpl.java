package fr.uga.l3miage.photonum.service;

import fr.uga.l3miage.photonum.data.domain.Album;
import fr.uga.l3miage.photonum.data.repo.AlbumRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@Transactional
public class AlbumServiceImpl implements AlbumService {

    private final AlbumRepository albumRepository;

    @Autowired
    public AlbumServiceImpl(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }


    @Override
    public Album save(Album album) {
        return albumRepository.save(album);
    }

    @Override
    public Album get(Long id) throws EntityNotFoundException {
        return albumRepository.get(id);
    }

    @Override
    public Collection<Album> list() {
        return albumRepository.all();
    }

    @Override
    public Album update(Album object) throws EntityNotFoundException {
        return albumRepository.save(object);
    }
}
