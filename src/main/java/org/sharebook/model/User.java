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
}
