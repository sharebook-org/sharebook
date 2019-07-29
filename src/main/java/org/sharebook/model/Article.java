package org.sharebook.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
