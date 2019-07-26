package org.sharebook.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Like {
    private long id;
    //评论的实体类型,0为文章类型，1为评论类型
    private int entityType;
    //当前点赞实体的编号
    private long entityId;
    //用户编号
    private long userId;
    //0为未点赞，1为已点赞
    private int liked;
    private Date createTime;
    private Date updatTime;

}
