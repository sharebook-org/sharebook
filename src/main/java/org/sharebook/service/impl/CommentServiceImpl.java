package org.sharebook.service.impl;

import org.sharebook.model.Comment;
import org.sharebook.repository.CommentRepository;
import org.sharebook.repository.impl.CommentRepositoryImpl;
import org.sharebook.service.CommentService;

public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    public CommentServiceImpl(){
        this.commentRepository=new CommentRepositoryImpl();
    }
    @Override
    public boolean comments(Comment comment) {
        if (comment!=null){
            commentRepository.save(comment);
            return true;
        }
        return false;
    }
}
