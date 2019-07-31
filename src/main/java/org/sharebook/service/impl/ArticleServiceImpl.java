package org.sharebook.service.impl;

import org.sharebook.constant.status.ArticleStatus;
import org.sharebook.model.Article;
import org.sharebook.model.User;
import org.sharebook.repository.ArticleRepository;
import org.sharebook.repository.UserRepository;
import org.sharebook.repository.impl.ArticleRepositoryImpl;
import org.sharebook.repository.impl.UserRepositoryImpl;
import org.sharebook.service.ArticleService;

import java.util.List;

public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;
    private final UserRepository userRepository;

    public ArticleServiceImpl() {
        this.articleRepository = new ArticleRepositoryImpl();
        this.userRepository = new UserRepositoryImpl();
    }

    @Override
    public List<Article> getArticles() {
        return articleRepository.findAll();
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
        Article article = null;
        User user = userRepository.findById(userId);
        if (user != null && user.getStatus().equals(ArticleStatus.NORMAL)) {
            article = articleRepository.findById(userId);
        }

        return article;
    }

    @Override
    public List<Article> getArticles(List<Long> ids) {
        return articleRepository.findArticlesByIds(ids);
    }

    @Override
    public List<Article> getArticles(String keyword) {
        return articleRepository.findByKeyword(keyword);
    }
}
