package org.sharebook.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    private Long id;
    private Long userId;
    private String content;
    private int entityType;
    private Long entityId;
    private Date createTime;
    private Date updateTime;

    public Comment(Long userId, String content,
                   int entityType, Long entityId) {
        this.userId = userId;
        this.entityType = entityType;
        this.entityId = entityId;
        this.content = content;
    }
}
