package org.sharebook.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentVO {

    //用户
    private long userId;
    private String username;
    private String avatar;

    //评论
    private long id;
    private String content;
    private String createTime;

}
