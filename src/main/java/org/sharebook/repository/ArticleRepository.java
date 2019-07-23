package org.sharebook.repository;

import org.sharebook.model.Article;

import java.util.List;

public interface ArticleRepository extends CurdRepository<Article,Long>{
    List<Article> findAllArticle();
}
