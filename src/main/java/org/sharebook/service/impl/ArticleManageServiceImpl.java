package org.sharebook.service.impl;

import org.sharebook.model.Article;
import org.sharebook.repository.ArticleRepository;
import org.sharebook.repository.impl.ArticleRepositoryImpl;
import org.sharebook.service.ArticleManageService;

import java.util.List;

public class ArticleManageServiceImpl implements ArticleManageService {
    private final ArticleRepository articleRepository;

    public ArticleManageServiceImpl() {
        this.articleRepository = new ArticleRepositoryImpl();
    }

    @Override
    public List<Article> getAllArticles(int page, int size) {
        List<Article> articles = articleRepository.findAll(page, size);
        if (articles != null) {
            return articles;
        }
        return null;
    }

    @Override
    public int updateArticle(Article article) {
        int result = articleRepository.update(article);
        return result;
    }

    @Override
    public int deleteArticle(long id) {
        int result = articleRepository.delete(id);
        return result;
    }

    @Override
    public long getArticlesCount() {
        long num = articleRepository.getArticlesCount();
        return num;
    }

    @Override
    public Article getArticle(long id) {
        Article article=articleRepository.findById(id);
        return article;
    }
}
