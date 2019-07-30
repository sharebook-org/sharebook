package org.sharebook.service.impl;

import org.sharebook.constant.EntityType;
import org.sharebook.constant.status.LikeStatus;
import org.sharebook.model.Article;
import org.sharebook.model.Like;
import org.sharebook.repository.ArticleRepository;
import org.sharebook.repository.LikeResposity;
import org.sharebook.repository.impl.ArticleRepositoryImpl;
import org.sharebook.repository.impl.LikeResposityImpl;
import org.sharebook.service.LikeService;

public class LikeServiceImpl implements LikeService {

    private final LikeResposity likeResposity;
    private final ArticleRepository articleRepository;

    public LikeServiceImpl() {
        this.likeResposity = new LikeResposityImpl();
        this.articleRepository = new ArticleRepositoryImpl();
    }

    @Override
    public boolean isLiked(int entityType, long entityId, long userId) {
        Like like = likeResposity.findByAllId(entityType, entityId, userId);
        if (like == null) {
            Like like1 = new Like();
            like1.setEntityType(entityType);
            like1.setEntityId(entityId);
            like1.setUserId(userId);
            like1.setLiked(LikeStatus.LIKED);
            if (entityType == EntityType.ARTICLE) {
                Article article = articleRepository.findById(entityId);
                long currentLikeNum = article.getLikeNum();
                article.setLikeNum(currentLikeNum + 1);
                int res = articleRepository.update(article);
            }

            int result = likeResposity.save(like1);
            return result != 0;
        } else {
            if (like.getLiked() == LikeStatus.UNLIKED) {
                like.setLiked(LikeStatus.LIKED);
                if (entityType == EntityType.ARTICLE) {
                    Article article = articleRepository.findById(entityId);
                    article.setLikeNum(article.getLikeNum() + 1);
                    articleRepository.update(article);
                }
                int result = likeResposity.update(like);
                return result != 0;
            }
        }
        return false;
    }

    @Override
    public boolean likedCancle(int entityType, long entityId, long userId) {
        Like like=likeResposity.findByAllId(entityType,entityId,userId);
        if (like!=null){
            like.setLiked(LikeStatus.UNLIKED);
            if (entityType==EntityType.ARTICLE){
                Article article=articleRepository.findById(entityId);
                article.setLikeNum(article.getLikeNum()-1);
                articleRepository.save(article);
            }
            int result=likeResposity.save(like);
            return result != 0;
        }
        return false;
    }
}
