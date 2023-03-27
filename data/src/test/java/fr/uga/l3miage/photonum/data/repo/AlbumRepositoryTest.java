package fr.uga.l3miage.photonum.data.repo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.assertj.core.api.Assertions.assertThat;


import fr.uga.l3miage.photonum.data.domain.Album;


class AlbumRepositoryTest extends Base {

    @Autowired
    AlbumRepository albumRepository;

    @Test
    void all() {
        Album a1 = Fixtures.newAlbum();
        a1.setTitreCouverture("mon anniversaire");
        Album a2 = Fixtures.newAlbum();
        a2.setTitreCouverture("mon dernier jour au lycée");
        Album a3 = Fixtures.newAlbum();
        a3.setTitreCouverture("mes souvenirs d'été");
        entityManager.persist(a1);
        entityManager.persist(a2);
        entityManager.flush();
        entityManager.detach(a1);
        entityManager.detach(a2);

        List<Album> albums = albumRepository.all();
        System.out.println(albums);
        assertThat(albums.size() == 3);
        assertThat(albums.get(0)).isEqualTo(a3);
        assertThat(albums.get(1)).isEqualTo(a1);
        assertThat(albums.get(2)).isEqualTo(a2);
    }

}
