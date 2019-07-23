package org.sharebook.service.impl;

import org.sharebook.model.Article;
import org.sharebook.repository.ArticleRepository;
import org.sharebook.repository.impl.ArticleRepositoryImpl;
import org.sharebook.service.ArticleService;

public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository articleRepository;
    public ArticleServiceImpl(){
        this.articleRepository=new ArticleRepositoryImpl();
    }
    @Override
    public boolean publish(Article article) {
        if (article!=null){
            articleRepository.save(article);
            return true;
        }
        return false;
    }

    @Override
    public boolean browse(Article article) {
        if (article!=null){
            articleRepository.findAllArticle();
            return true;
        }
        return false;
    }

}
