package org.sharebook.repository.impl;

import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.ColumnHandler;
import org.apache.commons.dbutils.GenerousBeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.sharebook.constant.status.LikeStatus;
import org.sharebook.model.Like;
import org.sharebook.repository.LikeResposity;
import org.sharebook.utils.JDBCUtils;

import java.sql.SQLException;

public class LikeResposityImpl implements LikeResposity {

    private final QueryRunner queryRunner;

    public LikeResposityImpl() {
        this.queryRunner = JDBCUtils.getQueryRunner();
    }

    @Override
    public Like findByAllId(int entityType,long entityId,long userId) {
        String sql="select * from `like` where `entity_type`=? and `entity_id`=? and `user_id`=?";
        Like like=null;
        try {
            like=queryRunner.query(sql,
                    new BeanHandler<>(
                            Like.class,
                            new BasicRowProcessor(new GenerousBeanProcessor())),
                    entityType,entityId, userId
                    );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return like;
    }

    @Override
    public Integer findStatus(int entityType, long entityId, long userId) {
        Integer likedStatus= LikeStatus.UNLIKED;
        String sql="select `liked` from `like` where `entity_type`=? and `entity_id`=? and `user_id`=?";
        try {
            likedStatus = queryRunner.query(
                    sql,
                    new ScalarHandler<>(),
                    entityType,
                    entityId,
                    userId
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return likedStatus;
    }

    @Override
    public int save(Like like) {
        int result=0;
        String sql="insert into `like` (entity_type,entity_id,user_id,liked,create_time,update_time) values(?,?,?,?,?,?)";
        try {
            result=queryRunner.execute(sql,
                    like.getEntityType(),
                    like.getEntityId(),
                    like.getUserId(),
                    like.getLiked(),
                    like.getCreateTime(),
                    like.getUpdatTime()
                    );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int update(Like like) {
        int result=0;
        String sql="update `like` set entity_type=?,entity_id=?,user_id=?,liked=?," +
                "update_time=? where id=?";
        try {
            result=queryRunner.update(sql,
                    like.getEntityType(),
                    like.getEntityId(),
                    like.getUserId(),
                    like.getLiked(),
                    like.getUpdatTime(),
                    like.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    @Override
    public Long getLikeCount() {
        String sql="select count(*) from `like` where user_id=?";
        long count=0;
        try {
            count=queryRunner.query(sql,new ScalarHandler<>());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public Like findById(Long id) {
        /*String sql="select * from like where id=?";
        Like like=null;
        try {
            like=queryRunner.query(
                    sql,
                    new BeanHandler<>(
                            Like.class,
                            new BasicRowProcessor(new GenerousBeanProcessor())),
                    id
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
        return null;
    }
    @Override
    public int delete(Long aLong) {
        return 0;
    }
}
