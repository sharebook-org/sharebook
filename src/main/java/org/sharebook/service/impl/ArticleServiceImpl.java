package org.sharebook.service.impl;

import org.sharebook.model.Article;
import org.sharebook.repository.ArticleRepository;
import org.sharebook.repository.impl.ArticleRepositoryImpl;
import org.sharebook.service.ArticleService;

import java.util.List;

public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleServiceImpl() {
        this.articleRepository = new ArticleRepositoryImpl();
    }

    @Override
    public boolean publish(Article article) {
        if (article != null) {
            articleRepository.save(article);
            return true;
        }
        return false;
    }

    @Override
    public boolean browse(Article article) {
        if (article != null) {
            articleRepository.findAll();
            return true;
        }
        return false;
    }

    @Override
    public Article getArticle(Long userId) {
        Article article=null;
        if (userId!=null){
            article = articleRepository.findById(userId);
            return article;
        }
        return article;
    }

    @Override
    public List<Article> getArticles(List<Long> ids) {
        List<Article> articles=null;
        articles = articleRepository.findArticlesByIds(ids);
        return articles;
    }


}
