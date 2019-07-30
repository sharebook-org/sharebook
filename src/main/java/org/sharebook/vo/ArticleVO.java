package org.sharebook.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sharebook.model.Article;
import org.sharebook.model.User;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleVO {
    private Long id;
    private Long userId;
    private String username;
    private String content;
    private String avatar;
    private String[] images;
    private int status;
    private Long commentNum;
    private Long likeNum;
    private String createTime;

    public ArticleVO(Article article, User user) {
        this.userId = user.getId();
        this.username = user.getUsername();
        this.avatar = user.getAvatar();
        this.id = article.getId();
        this.content = article.getContent();
        this.status = article.getStatus();
        this.commentNum = article.getCommentNum();
        this.likeNum = article.getLikeNum();
    }
}
