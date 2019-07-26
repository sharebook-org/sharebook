package org.sharebook.service;

import org.sharebook.model.Comment;

public interface CommentService {
    boolean comments(Comment comment);
    boolean addCommentNum(Comment comment);
}
