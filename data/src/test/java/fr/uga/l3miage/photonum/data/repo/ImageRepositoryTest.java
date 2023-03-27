package fr.uga.l3miage.photonum.data.repo;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import fr.uga.l3miage.photonum.data.domain.Client;
import fr.uga.l3miage.photonum.data.domain.Image;
import static org.assertj.core.api.Assertions.assertThat;


public class ImageRepositoryTest extends Base{

    @Autowired
    ImageRepository imageRepository;

    @Test
    void all(){
        Image i1 = Fixtures.newImage();
        i1.setCheminAcces("c:/image1.jpg");


        Image i2 = Fixtures.newImage();
        i2.setCheminAcces("c:/image2.jpg");

        Image i3 = Fixtures.newImage();
        i3.setCheminAcces("c:/image3.jpg");

        entityManager.persist(i1);
        entityManager.persist(i2);
        entityManager.persist(i3);
        entityManager.flush();
        entityManager.detach(i1);
        entityManager.detach(i2);
        entityManager.detach(i3);

        List<Image> images = imageRepository.all();
        assertThat(images)
            .hasSize(3)
            .extracting("cheminAcces")
            .containsExactly("c:/image1.jpg","c:/image2.jpg", "c:/image3.jpg");
    }

    @Test
    void allShared(){
        Image i1 = Fixtures.newImage();
        i1.setEstPartage(true);

        Image i2 = Fixtures.newImage();
        i2.setEstPartage(false);

        Image i3 = Fixtures.newImage();
        i3.setEstPartage(true);

        entityManager.persist(i1);
        entityManager.persist(i2);
        entityManager.persist(i3);
        entityManager.flush();
        entityManager.detach(i1);
        entityManager.detach(i2);
        entityManager.detach(i3);

        List<Image> images = imageRepository.allShared();
        assertThat(images)
            .hasSize(2)
            .extracting("estPartage")
            .containsExactly(true, true);
    }


    @Test
    void allClient(){
        Image i1 = Fixtures.newImage();
        Client c1 = Fixtures.newClient();


        i1.setProprietaireImage(c1);


        Image i2 = Fixtures.newImage();
        i2.setProprietaireImage(c1);
        Image i3 = Fixtures.newImage();
        i3.setProprietaireImage(Fixtures.newClient());

        entityManager.persist(i1);
        entityManager.persist(i2);
        entityManager.persist(i3);


        List<Image> images = imageRepository.allClient(c1.getId());
        assertThat(images)
            .hasSize(2)
            .extracting("proprietaireImage.id")
            .containsExactly(c1.getId(), c1.getId());
    }
    
}
