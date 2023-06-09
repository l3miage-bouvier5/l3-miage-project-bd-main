package fr.uga.l3miage.photonum.data.repo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import fr.uga.l3miage.photonum.data.domain.Article;

import static org.assertj.core.api.Assertions.assertThat;

import jakarta.persistence.EntityManager;


public class ArticleRepositoryTest extends Base {

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    EntityManager entityManager;

    @Test
    
    void all() {
        Article a1 = Fixtures.newArticle();
        a1.setRef("10x15MAT");

        Article a2 = Fixtures.newArticle();
        a2.setRef("CALA4BRIL");
        
        Article a3 = Fixtures.newArticle();
        a3.setRef("10x13BRIL");

        entityManager.persist(a1);
        entityManager.persist(a2);
        entityManager.persist(a3);

        entityManager.flush();
        entityManager.detach(a1);
        entityManager.detach(a2);
        entityManager.detach(a3);

        List<Article> articles = articleRepository.all();
        assertThat(articles)
                .hasSize(3)
                .extracting("ref")
                .containsExactly("10x15MAT","CALA4BRIL", "10x13BRIL");
    }

}
