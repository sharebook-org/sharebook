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

    public User(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.introduction = user.getIntroduction();
        this.sex = user.getSex();
        this.birth = user.getBirth();
        this.location = user.getLocation();
        this.status = user.getStatus();
        this.role = user.getRole();
        this.avatar = user.getAvatar();
        this.createTime = user.getCreateTime();
        this.updateTime = user.getUpdateTime();
    }
}
