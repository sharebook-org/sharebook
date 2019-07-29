package org.sharebook.service;

import org.sharebook.model.Comment;

import java.util.List;

public interface CommentService {
    boolean comments(Comment comment);
    boolean addCommentNum(Comment comment);
    Comment findById(long id);
    List<Comment> getCommentList(int entityType,long entityId);
}
