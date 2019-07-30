package org.sharebook.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Follow {
    private Long id;
    private Long userId;
    private Long followUserId;
    private Date createTime;
    private Date updateTime;

    public Follow(Long userId, Long followUserId) {
        this.userId = userId;
        this.followUserId = followUserId;
        this.createTime = new Date();
        this.updateTime = new Date();
    }
}
