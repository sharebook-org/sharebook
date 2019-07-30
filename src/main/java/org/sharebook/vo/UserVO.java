package org.sharebook.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sharebook.model.User;
import org.sharebook.utils.DateFormatUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVO {
    private Long id;
    private String username;
    private String email;
    private String phone;
    private String introduction;
    private Integer sex;
    private String birth;
    private String location;
    private Integer status;
    private Integer role;
    private String avatar;
    private String createTime;

    public UserVO(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.phone = user.getPhone();
        this.sex = user.getSex();
        this.location = user.getLocation();
        this.status = user.getStatus();
        this.role = user.getRole();
        this.avatar = user.getAvatar();

        //防止时间为空
        if (user.getBirth() != null) {
            this.birth = DateFormatUtils.simpleDateFormat(user.getBirth());
        }
        if (user.getCreateTime() != null) {
            this.createTime = DateFormatUtils.complexDateFormat(user.getCreateTime());
        }
    }
}
