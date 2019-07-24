package org.sharebook.repository.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.sharebook.model.Article;
import org.sharebook.repository.ArticleRepository;
import org.sharebook.utils.JDBCUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArticleRepositoryImpl implements ArticleRepository {

    private final QueryRunner queryRunner;

    public ArticleRepositoryImpl() {
        this.queryRunner = JDBCUtils.getQueryRunner();
    }


    @Override
    public Article findById(Long aLong) {
        return null;
    }

    @Override
    public List<Article> findAll() {
        List<Article> articles = new ArrayList<>();
        String sql = "select * from `article`";
        try {
            articles = queryRunner.query(sql, new BeanListHandler<>(Article.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return articles;
    }

    @Override
    public int save(Article article) {
        String sql = "INSERT INTO `article`" +
                "(`id`,`user_id`,`content`,`images`,`status`," +
                "`comment_num`,`like_num`,`create_time`,`update_time`)" +
                "VALUES(?,?,?,?,?,?,?,?,?)";

        try {
            return queryRunner.execute(
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
            throw new RuntimeException(e);
        }
    }

    @Override
    public int update(Article article) {
        return 0;
    }

    @Override
    public int delete(Long aLong) {
        return 0;
    }


}
