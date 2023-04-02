package fr.uga.l3miage.photonum.article;

import java.util.Collection;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import fr.uga.l3miage.photonum.data.domain.Article;

@Mapper(componentModel = "spring")
public interface ArticleMapper {
    ArticleDTO entityToDTO(Article article);

    Collection<ArticleDTO> entityToDTO(Iterable<Article> articles);

    @Mapping(target = "id", ignore = true)
    Article dtoToEntity(ArticleDTO articleDTO);

    Collection<Article> dtoToEntity(Iterable<ArticleDTO> articlesDTO);
}
