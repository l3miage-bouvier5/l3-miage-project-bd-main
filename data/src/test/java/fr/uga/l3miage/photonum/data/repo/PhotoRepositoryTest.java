package fr.uga.l3miage.photonum.data.repo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.assertj.core.api.Assertions.assertThat;

import fr.uga.l3miage.photonum.data.domain.Photo;

public class PhotoRepositoryTest extends Base{
    
    @Autowired
    PhotoRepository photoRepository;

    @Test
    void all(){
        Photo p1 = Fixtures.newPhoto();
        p1.setTexteDescriptif("photo");
        
        Photo p2 = Fixtures.newPhoto();
        p2.setTexteDescriptif("photo2");

        entityManager.persist(p1);
        entityManager.persist(p2);

        entityManager.flush();
        entityManager.detach(p1);
        entityManager.detach(p2);

        List<Photo> photos = photoRepository.all();
        assertThat(photos)
                .hasSize(2)
                .extracting("texteDescriptif")
                .containsExactly("photo","photo2");
    }
}
