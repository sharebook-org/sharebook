package org.sharebook.repository.impl;

import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.GenerousBeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.sharebook.model.Comment;
import org.sharebook.repository.CommentRepository;
import org.sharebook.utils.JDBCUtils;

import java.sql.SQLException;
import java.util.List;

public class CommentRepositoryImpl implements CommentRepository {

    private final QueryRunner queryRunner;

    public CommentRepositoryImpl() {
        this.queryRunner = JDBCUtils.getQueryRunner();
    }

    @Override
    public List<Comment> findAll(int entityType, Long entityId) {
        String sql = "SELECT * FROM `comment` WHERE `entity_type` = ? AND `entity_id` = ?";
        List<Comment> comments = null;
        try {
            comments = queryRunner.query(sql, new BeanListHandler<>(
                            Comment.class,
                            new BasicRowProcessor(new GenerousBeanProcessor())),
                    entityType, entityId
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comments;
    }

    @Override
    public Comment findById(Long id) {
        String sql = "SELECT * FROM `comment` WHERE `id` = ?";
        Comment comment = null;
        try {
            comment = queryRunner.query(sql,
                    new BeanHandler<>(
                            Comment.class,
                            new BasicRowProcessor(new GenerousBeanProcessor())
                    ),
                    id
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comment;
    }

    @Override
    public int save(Comment comment) {
        int count = 0;
        String sql = "INSERT INTO `comment`(`id`,`user_id`," +
                "`entity_type`,`entity_id`,`content`,`create_time`," +
                "`update_time`) VALUES (?,?,?,?,?,?,?)";
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
