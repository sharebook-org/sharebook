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
    private int entityType;
    private Long entityId;
    private String content;
    private Date createTime;
    private Date updateTime;
}
