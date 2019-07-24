package org.sharebook.repository.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.sharebook.model.Comment;
import org.sharebook.repository.CommentRepository;
import org.sharebook.utils.JDBCUtils;

import java.sql.SQLException;

public class CommentRepositoryImpl implements CommentRepository {
    private final QueryRunner queryRunner;
    public CommentRepositoryImpl(){
        this.queryRunner= JDBCUtils.getQueryRunner();
    }
    @Override
    public Comment findById(Long aLong) {
        return null;
    }

    @Override
    public int save(Comment comment) {
        String sql="insert into `comment`"+
                "(`id`,`user_id`,`entity_type`,`entity_id`,`content`,`create_time`,`update_time`)"+
                "values(?,?,?,?,?,?,?)";
        try {
            return queryRunner.execute(
                    sql,
                    comment.getId(),
                    comment.getUserId(),
                    comment.getEntityType(),
                    comment.getEntityId(),
                    comment.getContent(),
                    comment.getCreateTime(),
                    comment.getUpdateTime()
            );
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public int update(Comment comment) {
        return 0;
    }

    @Override
    public int delete(Long aLong) {
        return 0;
    }
}
