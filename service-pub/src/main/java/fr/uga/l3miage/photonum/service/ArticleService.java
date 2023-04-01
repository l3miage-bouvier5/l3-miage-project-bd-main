package fr.uga.l3miage.photonum.service;

import fr.uga.l3miage.photonum.data.domain.Article;
import fr.uga.l3miage.photonum.service.base.BaseService;


public interface ArticleService extends BaseService<Article, Long> {

    Article save(Article article);

    Article get(Long id) throws EntityNotFoundException;

    Article update(Article article) throws EntityNotFoundException;

    void delete(Long id) throws EntityNotFoundException;

}