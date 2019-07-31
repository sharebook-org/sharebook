package org.sharebook.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sharebook.model.Article;
import org.sharebook.model.User;
import org.sharebook.utils.DateFormatUtils;

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
    private int role;
    private Long commentNum;
    private int liked;
    private int followed;
    private Long likeNum;
    private String createTime;

    public ArticleVO(Article article, User user) {
        //用户
        this.userId = user.getId();
        this.username = user.getUsername();
        this.avatar = user.getAvatar();
        this.role = user.getRole();
        //文章
        this.id = article.getId();
        this.content = article.getContent();
        this.status = article.getStatus();
        this.commentNum = article.getCommentNum();
        this.likeNum = article.getLikeNum();
        if (article.getImages() != null) {
            String[] images = article.getImages().split("#");
            this.images = images;
        }
        if (article.getCreateTime() != null) {
            this.createTime = DateFormatUtils.complexDateFormat(article.getCreateTime());
        }
    }
}
