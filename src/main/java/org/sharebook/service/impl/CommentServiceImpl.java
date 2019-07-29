package org.sharebook.service.impl;

import jdk.nashorn.internal.runtime.regexp.joni.constants.EncloseType;
import org.sharebook.constant.EntityType;
import org.sharebook.model.Article;
import org.sharebook.model.Comment;
import org.sharebook.repository.ArticleRepository;
import org.sharebook.repository.CommentRepository;
import org.sharebook.repository.impl.ArticleRepositoryImpl;
import org.sharebook.repository.impl.CommentRepositoryImpl;
import org.sharebook.service.CommentService;

import java.util.Date;
import java.util.List;

public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final ArticleRepository articleRepository;

    public CommentServiceImpl() {
        this.commentRepository = new CommentRepositoryImpl();
        this.articleRepository= new ArticleRepositoryImpl();
    }

    @Override
    public List<Comment> getCommentList(int entityType, long entityId) {
        List<Comment> comments=commentRepository.findAll(entityType,entityId);
        return comments;
    }

    @Override
    public Comment findById(long id) {
        Comment comment=commentRepository.findById(id);
        if (comment!=null){
            return comment;
        }
        return null;
    }

    @Override
    public boolean comments(Comment comment) {
        if (comment != null) {
            comment.setCreateTime(new Date());
            comment.setUpdateTime(new Date());
            int count = commentRepository.save(comment);
            if (count > 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean addCommentNum(Comment comment) {
        if (comment!=null){
            if (comment.getEntityType()== EntityType.ARTICLE){
                Article article = articleRepository.findById(comment.getEntityId());
                Long currentCommentNum = article.getCommentNum();
                article.setCommentNum(currentCommentNum+1);
                int result=articleRepository.save(article);
                if (result>0){
                    return true;
                }
            }
        }
        return false;
    }
}
