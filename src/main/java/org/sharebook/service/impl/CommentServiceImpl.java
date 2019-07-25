package org.sharebook.service.impl;

import org.sharebook.model.Comment;
import org.sharebook.repository.CommentRepository;
import org.sharebook.repository.impl.CommentRepositoryImpl;
import org.sharebook.service.CommentService;

import java.util.Date;

public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    public CommentServiceImpl() {
        this.commentRepository = new CommentRepositoryImpl();
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
}
