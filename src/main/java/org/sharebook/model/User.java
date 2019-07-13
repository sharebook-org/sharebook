package org.sharebook.model;

import lombok.Data;

import java.util.Date;

@Data
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
