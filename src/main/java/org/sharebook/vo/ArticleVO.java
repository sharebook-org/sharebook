package org.sharebook.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

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
    private Date createTime;
}
