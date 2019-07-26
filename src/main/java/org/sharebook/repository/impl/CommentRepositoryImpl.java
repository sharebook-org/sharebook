package org.sharebook.repository.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.sharebook.model.Comment;
import org.sharebook.repository.CommentRepository;
import org.sharebook.utils.JDBCUtils;

import java.sql.SQLException;

public class CommentRepositoryImpl implements CommentRepository {
    private final QueryRunner queryRunner;

    public CommentRepositoryImpl() {
        this.queryRunner = JDBCUtils.getQueryRunner();
    }

    @Override
    public Comment findById(Long id) {
        return null;
    }

    @Override
    public int save(Comment comment) {
        int count = 0;
        String sql = "insert into `comment`(`id`,`user_id`," +
                "`entity_type`,`entity_id`,`content`,`create_time`," +
                "`update_time`) values(?,?,?,?,?,?,?)";
        try {
            count = queryRunner.execute(
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
        }
        return count;
    }

    @Override
    public int update(Comment comment) {
        return 0;
    }

    @Override
    public int delete(Long id) {
        return 0;
    }
}
