package org.sharebook.repository.impl;

import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.GenerousBeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
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
        String sql="select * from `article` where `id`=?";
        Article article=null;
        try {
            article=queryRunner.query(sql,new BeanHandler<>(Article.class),id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return article;
    }

    @Override
    public List<Article> findAll() {
        List<Article> articles = null;
        String sql = "select * from `article`";
        try {
            articles = queryRunner.query(
                    sql,
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
        return 0;
    }

    @Override
    public int delete(Long id) {
        return 0;
    }


}
