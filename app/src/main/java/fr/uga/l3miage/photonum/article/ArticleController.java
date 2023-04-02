package fr.uga.l3miage.photonum.article;


import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.codec.DecodingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import fr.uga.l3miage.photonum.data.domain.Article;
import fr.uga.l3miage.photonum.service.ArticleService;
import fr.uga.l3miage.photonum.service.EntityNotFoundException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping(value = "/api/v1", produces = "application/json")
public class ArticleController {
    private final ArticleMapper articleMapper;
    private final ArticleService articleService;


    @Autowired
    public ArticleController(ArticleMapper articleMapper, ArticleService articleService){
        this.articleService  = articleService;
        this.articleMapper = articleMapper;
    }

    @GetMapping("/articles")
    public Collection<ArticleDTO> articles() {
        Collection<Article> articles;
        articles = articleService.list();
        
        return articles.stream()
                .map(articleMapper::entityToDTO)
                .toList();
    }


    @GetMapping("/articles/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ArticleDTO article(@PathVariable("id") @NotNull Long id) {
        try {
            return articleMapper.entityToDTO(articleService.get(id));
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, null, e);
        }
    }


    @PostMapping(value = "/articles", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ArticleDTO newArticle(@RequestBody @Valid ArticleDTO article) {
        Article saved = articleService.save(articleMapper.dtoToEntity(article));
        return articleMapper.entityToDTO(saved);
    }
    
    @PutMapping(value = "/articles/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ArticleDTO updateArticle(@RequestBody @Valid ArticleDTO article, @NotNull @PathVariable("id") Long id) {
        try {
            if (article.id().equals(id)) {
                articleService.get(id);
                Article updated = articleService.update(articleMapper.dtoToEntity(article));
                return articleMapper.entityToDTO(updated);
            }
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "article is not found", e);
        }
    }


    @DeleteMapping("/articles/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteArticle(@PathVariable("id") @NotNull Long id) {
        try {
            articleService.delete(id);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, null, e);
        } catch (DecodingException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, null, e);
        }
    }


}
