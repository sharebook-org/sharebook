package org.sharebook.service;

import org.sharebook.model.Article;

import java.util.List;

public interface ArticleManageService {

    /**
     *获取文章
     * @param page
     * @param size
     * @return
     */
    List<Article> getAllArticles(int page,int size);

    /**
     * 修改文章
     * @param article
     * @return
     */
    int updateArticle(Article article);

    /**
     * 根据id删除文章
     * @param id
     * @return
     */
    int deleteArticle(long id);

    /**
     * 获取文章总数
     * @return
     */
    long getArticlesCount();

    /**
     * 获取单篇文章
     * @param id
     * @return
     */
    Article getArticle(long id);
}
