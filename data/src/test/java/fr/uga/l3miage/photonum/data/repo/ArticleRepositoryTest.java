package fr.uga.l3miage.photonum.data.repo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import fr.uga.l3miage.photonum.data.domain.Article;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;


class ArticleRepositoryTest extends Base {

    @Autowired
    ArticleRepository articleRepository;

    @Test
    void all() {
        Article a1 = Fixtures.newArticle();
        a1.setId(Long.valueOf(120));
        Article a2 = Fixtures.newArticle();
        a2.setId(Long.valueOf(78));
        Article a3 = Fixtures.newArticle();
        a3.setId(Long.valueOf(13));
        entityManager.persist(a1);
        entityManager.persist(a2);
        entityManager.persist(a3);
        entityManager.flush();
        entityManager.detach(a1);
        entityManager.detach(a2);
        entityManager.detach(a3);

        List<Article> articles = articleRepository.all();
        assertThat(articles.size() == 3);
        assertThat(articles.get(0)).isEqualTo(a3);
        assertThat(articles.get(1)).isEqualTo(a2);
        assertThat(articles.get(2)).isEqualTo(a1);
        assertThat(articles)
                .hasSize(3)
                .extracting("id")
                .containsExactly(13, 78, 120);
    }

}
