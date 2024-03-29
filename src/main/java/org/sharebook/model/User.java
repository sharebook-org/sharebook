package org.sharebook.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sharebook.constant.Role;
import org.sharebook.constant.status.UserStatus;
import org.sharebook.utils.AvatarUtils;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Long id;
    private String username;
    private String password;
    private String salt;
    private String email;
    private String phone;
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
    public User(String username, String password, String email,
                String phone, Integer sex, Date birth, String location) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.sex = sex;
        this.birth = birth;
        this.location = location;
        this.status = UserStatus.NORMAL;
        this.role = Role.USER;
        this.avatar = AvatarUtils.getDefaultAvatar();
        this.createTime = new Date();
        this.updateTime = new Date();
    }

    public User(String username, String password, String salt,
                String email, String phone, String introduction,
                Integer sex, Date birth, String location,
                Integer status, Integer role, String avatar,
                Date createTime, Date updateTime) {
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.email = email;
        this.phone = phone;
        this.introduction = introduction;
        this.sex = sex;
        this.birth = birth;
        this.location = location;
        this.status = status;
        this.role = role;
        this.avatar = avatar;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public User(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.phone = user.getPhone();
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
