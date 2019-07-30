package org.sharebook.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sharebook.constant.status.ArticleStatus;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article {
    private Long id;
    private Long userId;
    private String content;
    private String images;
    private int status;
    private Long commentNum;
    private Long likeNum;
    private Date createTime;
    private Date updateTime;

    public Article(Long userId, String content, String images) {
        this.userId = userId;
        this.content = content;
        this.images = images;
        this.status = ArticleStatus.NORMAL;
        this.commentNum = Long.valueOf(0);
        this.likeNum = Long.valueOf(0);
        this.createTime = new Date();
        this.updateTime = new Date();
    }
}
