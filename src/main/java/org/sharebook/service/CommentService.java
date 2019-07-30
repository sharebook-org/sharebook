package org.sharebook.service;

import org.sharebook.model.Comment;

import java.util.List;

public interface CommentService {
    boolean comments(Comment comment);

    Comment findById(Long id);

    List<Comment> getCommentList(int entityType, Long entityId);
}
