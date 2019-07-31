package org.sharebook.repository;

import org.sharebook.model.Article;

import java.util.List;

public interface ArticleRepository extends CurdRepository<Article,Long>{

    //TODO 需改成分页形式
    List<Article> findAll();

    /**
     * 后台查询所有文章
     * @param page
     * @param size
     * @return
     */
    List<Article> findAll(int page,int size);

    /**
     * 后台获取文章总数
     * @return
     */
    long getArticlesCount();

    List<Article> findArticlesByIds(List<Long> ids);

    List<Article> findByKeyword(String keyword);

    List<Article> findByUerId(long userId);
}
