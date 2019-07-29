package org.sharebook.repository;

import org.sharebook.model.Comment;

import java.util.List;

public interface CommentRepository extends CurdRepository<Comment, Long> {
    List<Comment> findAll(int entityType,long entityId);
}
