package org.sharebook.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Long id;
    private String username;
    private String password;
    private String salt;
    private String introduction;
    private Integer sex;
    private Date birth;
    private String location;
    private Integer status;
    private Integer role;
    private String avatar;
    private Date createTime;
    private Date updateTime;

    //constructor for register
    public User(String username, String password, String salt,
                Integer sex, Integer status, Integer role,
                String avatar, Date createTime, Date updateTime) {
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.sex = sex;
        this.status = status;
        this.role = role;
        this.avatar = avatar;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }
}
