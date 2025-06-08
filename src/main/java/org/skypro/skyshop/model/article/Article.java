package org.skypro.skyshop.model.article;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.skypro.skyshop.model.search.Searchable;

import java.util.Objects;
import java.util.UUID;

public final class Article implements Searchable {
    private String nameArticle;
    private String textArticle;
    private final UUID id;

    public Article(String nameArticle, String textArticle, UUID id) {
        this.nameArticle = nameArticle;
        this.textArticle = textArticle;
        this.id = id;
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Название статьи: " + nameArticle + '\n' +
                " Текст статьи: " + textArticle + '\'';
    }

    @Override
    public String getSearchTerm() {
        return "Название статьи: " + nameArticle;
    }

    @Override
    public String getTypeContent() {
        return "ARTICLE";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(nameArticle, article.nameArticle);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nameArticle);
    }
}
