package org.sharebook.service;

import org.sharebook.model.Article;

public interface ArticleService {
    boolean publish(Article article);
    boolean browse(Article article);
}
