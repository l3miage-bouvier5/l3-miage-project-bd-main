package fr.uga.l3miage.photonum.article;

import fr.uga.l3miage.photonum.data.domain.Qualite;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ArticleDTO (
    Long id,

    @NotBlank(message = "ref of the article is mandatory")
    String ref,

    @NotNull(message = "prix of the article is mandatory")
    float prix,

    @NotNull(message = "quality of the article is mandatory")
    Qualite qualite

) {}
