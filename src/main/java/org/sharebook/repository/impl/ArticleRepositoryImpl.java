package org.sharebook.repository.impl;

import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.GenerousBeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.sharebook.constant.status.ArticleStatus;
import org.sharebook.model.Article;
import org.sharebook.repository.ArticleRepository;
import org.sharebook.utils.JDBCUtils;

import java.sql.SQLException;
import java.util.List;

public class ArticleRepositoryImpl implements ArticleRepository {

    private final QueryRunner queryRunner;

    public ArticleRepositoryImpl() {
        this.queryRunner = JDBCUtils.getQueryRunner();
    }


    @Override
    public Article findById(Long id) {
        String sql = "SELECT * FROM `article` WHERE `id` = ?";
        Article article = null;
        try {
            article = queryRunner.query(
                    sql,
                    new BeanHandler<>(
                            Article.class,
                            new BasicRowProcessor(new GenerousBeanProcessor())
                    ),
                    id
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return article;
    }

    @Override
    public List<Article> findAll() {
        String sql = "SELECT * FROM `article` WHERE `status` = ?";
        List<Article> articles = null;
        try {
            articles = queryRunner.query(
                    sql,
                    new BeanListHandler<>(
                            Article.class,
                            new BasicRowProcessor(new GenerousBeanProcessor())
                    ),
                    ArticleStatus.NORMAL
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return articles;
    }

    @Override
    public List<Article> findAll(int page, int size) {
        int offset = (page - 1) * size;
        String sql = "SELECT * FROM `article` LIMIT ?, ?";
        List<Article> articles = null;
        try {
            articles = queryRunner.query(
                    sql,
                    new BeanListHandler<>(
                            Article.class,
                            new BasicRowProcessor(new GenerousBeanProcessor())
                    ),
                    offset,
                    size
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return articles;
    }

    @Override
    public int save(Article article) {
        int count = 0;
        String sql = "INSERT INTO `article`" +
                "(`id`,`user_id`,`content`,`images`,`status`," +
                "`comment_num`,`like_num`,`create_time`,`update_time`)" +
                "VALUES(?,?,?,?,?,?,?,?,?)";

        try {
            count = queryRunner.execute(
                    sql,
                    article.getId(),
                    article.getUserId(),
                    article.getContent(),
                    article.getImages(),
                    article.getStatus(),
                    article.getCommentNum(),
                    article.getLikeNum(),
                    article.getCreateTime(),
                    article.getUpdateTime()
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public int update(Article article) {
        int count = 0;
        String sql = "UPDATE `article` SET `user_id` = ?, `content` = ?," +
                " `images` = ?, `status` = ?, `comment_num` = ?, `like_num` = ?," +
                " `create_time` = ?, `update_time` = ? WHERE `id` = ?";
        try {
            count = queryRunner.update(
                    sql,
                    article.getUserId(),
                    article.getContent(),
                    article.getImages(),
                    article.getStatus(),
                    article.getCommentNum(),
                    article.getLikeNum(),
                    article.getCreateTime(),
                    article.getUpdateTime(),
                    article.getId()
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public int delete(Long id) {
        String sql = "UPDATE `article` SET `status` = ? WHERE `id` = ?";
        int count = 0;
        try {
            count = queryRunner.update(sql, ArticleStatus.DELETED, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public long getArticlesCount() {
        String sql = "SELECT COUNT(*) FROM `article`";
        long count = 0;
        try {
            count = queryRunner.query(sql, new ScalarHandler<>());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public List<Article> findArticlesByIds(List<Long> ids) {
        List<Article> articles = null;
        StringBuffer sql = new StringBuffer("SELECT * FROM `article` WHERE `user_id` IN(");
        for (int i = 0; i < ids.size(); i++) {
            if (i == ids.size() - 1) {
                sql.append(ids.get(i));
            } else {
                sql.append(ids.get(i));
                sql.append(",");
            }
        }
        sql.append(")");
        try {
            articles = queryRunner.query(
                    sql.toString(),
                    new BeanListHandler<>(
                            Article.class,
                            new BasicRowProcessor(new GenerousBeanProcessor())
                    )
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return articles;
    }

    @Override
    public List<Article> findByKeyword(String keyword) {
        String sql = "SELECT * FROM `article` WHERE `content` LIKE ?";
        List<Article> articles = null;
        try {
            articles = queryRunner.query(
                    sql,
                    new BeanListHandler<>(
                            Article.class,
                            new BasicRowProcessor(new GenerousBeanProcessor())
                    ),
                    "%" + keyword + "%"
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return articles;
    }

    @Override
    public List<Article> findByUerId(long userId) {
        String sql="SELECT * FROM `article` WHERE `user_id` = ?";
        List<Article> articles = null;
        try {
            articles = queryRunner.query(
                    sql,
                    new BeanListHandler<>(
                            Article.class,
                            new BasicRowProcessor(new GenerousBeanProcessor())
                    ),
                    userId
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return articles;
    }
}
