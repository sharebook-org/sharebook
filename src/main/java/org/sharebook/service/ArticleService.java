package org.sharebook.service;

import org.sharebook.model.Article;

import java.util.List;

public interface ArticleService {
    boolean publish(Article article);

    boolean browse(Article article);

    Article getArticle(Long id);

    List<Article> getArticles(List<Long> ids);

    List<Article> getArticles();

    List<Article> getArticles(String keyword);

    List<Article> getArticles(long userId);
}
