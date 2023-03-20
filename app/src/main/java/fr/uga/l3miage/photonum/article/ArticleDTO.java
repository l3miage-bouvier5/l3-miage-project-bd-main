package fr.uga.l3miage.photonum.article;

import fr.uga.l3miage.photonum.data.domain.Qualite;
import jakarta.validation.constraints.NotBlank;

public record ArticleDTO (
    Long id,

    @NotBlank(message = "ref of the article is mandatory")
    String ref,

    @NotBlank(message = "prix of the article is mandatory")
    float prix,

    @NotBlank(message = "quality of the article is mandatory")
    Qualite qualite,

    @NotBlank(message = "quantity of the article is mandatory")
    int quantite
) {}
