package org.sharebook.repository;

import org.sharebook.model.Article;

import java.util.List;

public interface ArticleRepository extends CurdRepository<Article,Long>{

    //TODO 需改成分页形式
    List<Article> findAll();
}
