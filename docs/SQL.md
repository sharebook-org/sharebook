# SQL

## User用户表

```
CREATE TABLE `User` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
	`username` VARCHAR(20) NOT NULL COMMENT '用户昵称',
	`password` VARCHAR(20) NOT NULL COMMENT '密码',
	`salt` VARCHAR(10) NULL DEFAULT NULL COMMENT '四位随机字符串，用于用户密码加密',
	`introduction` VARCHAR(1024) NULL DEFAULT NULL COMMENT '介绍',
	`sex` TINYINT(1) NULL DEFAULT NULL COMMENT '性别',
	`birth` DATE NULL DEFAULT NULL COMMENT '生日',
	`location` VARCHAR(20) NULL DEFAULT NULL COMMENT '地区',
	`status` TINYINT(1) NOT NULL DEFAULT '0' COMMENT '0为账号正常，1为账号封禁',
	`role` TINYINT(1) NOT NULL DEFAULT '0' COMMENT '0为普通用户，1为大V用户，9为管理员',
	`avatar` VARCHAR(1024) NULL DEFAULT NULL COMMENT '头像链接',
	`create_time` DATE NULL DEFAULT NULL COMMENT '创建时间',
	`update_time` DATE NULL DEFAULT NULL COMMENT '更新时间',
	PRIMARY KEY (`id`)
)
COMMENT='用户表'
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
;
```

