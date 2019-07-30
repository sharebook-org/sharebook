package org.sharebook.service.impl;

import org.sharebook.constant.EntityType;
import org.sharebook.model.Article;
import org.sharebook.model.Comment;
import org.sharebook.repository.ArticleRepository;
import org.sharebook.repository.CommentRepository;
import org.sharebook.repository.impl.ArticleRepositoryImpl;
import org.sharebook.repository.impl.CommentRepositoryImpl;
import org.sharebook.service.CommentService;

import java.util.List;

public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final ArticleRepository articleRepository;

    public CommentServiceImpl() {
        this.commentRepository = new CommentRepositoryImpl();
        this.articleRepository = new ArticleRepositoryImpl();
    }

    @Override
    public List<Comment> getCommentList(int entityType, Long entityId) {
        return commentRepository.findAll(entityType, entityId);
    }

    @Override
    public Comment findById(Long id) {
        return commentRepository.findById(id);
    }

    @Override
    public boolean comments(Comment comment) {
        synchronized (this) {
            if (comment != null) {
                boolean result = addCommentNum(comment);
                if (result) {
                    int count = commentRepository.save(comment);
                    return count > 0;
                }
            }
            return false;
        }
    }

    /**
     * 添加评论数
     *
     * @param comment
     * @return
     */
    private boolean addCommentNum(Comment comment) {
        if (comment != null) {
            if (comment.getEntityType() == EntityType.ARTICLE) {
                Article article = articleRepository.findById(comment.getEntityId());
                Long currentCommentNum = article.getCommentNum();
                if (currentCommentNum == null) {
                    currentCommentNum = Long.valueOf(0);
                }
                article.setCommentNum(currentCommentNum + 1);
                int result = articleRepository.update(article);
                return result > 0;
            }
        }
        return false;
    }
}
