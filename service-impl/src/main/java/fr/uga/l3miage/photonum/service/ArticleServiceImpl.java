package fr.uga.l3miage.photonum.service;

import fr.uga.l3miage.photonum.data.domain.Article;
import fr.uga.l3miage.photonum.data.repo.ArticleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;

    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }


    @Override
    public Article save(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public Article get(Long id) throws EntityNotFoundException {
        return articleRepository.get(id);
    }

    @Override
    public Collection<Article> list() {
        return articleRepository.all();
    }

    @Override
    public Article update(Article object) throws EntityNotFoundException {
        return articleRepository.save(object);
    }
}
