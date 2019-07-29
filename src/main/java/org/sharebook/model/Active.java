package org.sharebook.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 对应激活状态表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Active {
    private Long id;
    private Long userId;
    private String code;
    private int status;
    private Date createTime;
    private Date updateTime;

    public Active(Long userId, String code, int status) {
        this.userId = userId;
        this.code = code;
        this.status = status;
        this.createTime = new Date();
        this.updateTime = new Date();
    }
}
