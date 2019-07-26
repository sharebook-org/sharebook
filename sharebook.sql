CREATE TABLE `user` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
	`username` VARCHAR(50) NOT NULL COMMENT '用户昵称',
	`email` VARCHAR(50) NULL DEFAULT NULL COMMENT '邮箱',
	`phone` INT(11) NULL DEFAULT NULL COMMENT '手机号',
	`password` VARCHAR(50) NOT NULL COMMENT '密码',
	`salt` VARCHAR(10) NOT NULL COMMENT '四位随机加密字符串',
	`introduction` VARCHAR(200) NULL DEFAULT NULL COMMENT '用户简介',
	`sex` INT(1) NULL DEFAULT '2' COMMENT '性别',
	`birth` DATETIME NULL DEFAULT NULL COMMENT '生日',
	`location` VARCHAR(50) NULL DEFAULT NULL COMMENT '地区',
	`status` INT(1) NOT NULL DEFAULT '0' COMMENT '用户状态',
	`role` INT(1) NOT NULL DEFAULT '0' COMMENT '用户角色',
	`avatar` VARCHAR(512) NULL DEFAULT NULL COMMENT '头像链接',
	`create_time` DATETIME NULL DEFAULT NULL COMMENT '创建时间',
	`update_time` DATETIME NULL DEFAULT NULL COMMENT '更新时间',
	PRIMARY KEY (`id`)
)
COMMENT='用户表'
    DEFAULT CHARSET = utf8
    AUTO_INCREMENT = 1
    ENGINE=InnoDB;

CREATE TABLE `follow` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
	`user_id` BIGINT(20) NOT NULL COMMENT '用户编号',
	`follow_user_id` BIGINT(20) NOT NULL COMMENT '被关注用户编号',
	`create_time` DATETIME NULL DEFAULT NULL COMMENT '创建时间',
	`update_time` DATETIME NULL DEFAULT NULL COMMENT '更新时间',
	PRIMARY KEY (`id`)
)
COMMENT='关注表'
    DEFAULT CHARSET = utf8
    AUTO_INCREMENT = 1
    ENGINE=InnoDB;

CREATE TABLE `article` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '文章编号',
	`user_id` BIGINT(20) NOT NULL COMMENT '用户编号',
	`content` VARCHAR(512) NOT NULL COMMENT '文章内容',
	`images` VARCHAR(1024) NULL DEFAULT NULL COMMENT '文章图片链接',
	`status` INT(1) NOT NULL DEFAULT '0' COMMENT '文章状态',
	`comment_num` BIGINT(20) NULL DEFAULT NULL COMMENT '评论数',
	`like_num` BIGINT(20) NULL DEFAULT NULL COMMENT '点赞数',
	`create_time` DATETIME NULL DEFAULT NULL COMMENT '创建时间',
	`update_time` DATETIME NULL DEFAULT NULL COMMENT '更新时间',
	PRIMARY KEY (`id`)
)
COMMENT='文章表'
    DEFAULT CHARSET = utf8
    AUTO_INCREMENT = 1
    ENGINE=InnoDB;

CREATE TABLE `like` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
	`entity_type` INT(1) NOT NULL COMMENT '点赞实体类型',
	`entity_id` BIGINT(20) NOT NULL COMMENT '当前点赞实体的编号',
	`user_id` BIGINT(20) NOT NULL COMMENT '用户编号',
	`liked` INT(1) NOT NULL DEFAULT '0' COMMENT '点赞状态',
	`create_time` DATETIME NULL DEFAULT NULL COMMENT '创建时间',
	`update_time` DATETIME NULL DEFAULT NULL COMMENT '更新时间',
	PRIMARY KEY (`id`)
)
COMMENT='点赞表'
    DEFAULT CHARSET = utf8
    AUTO_INCREMENT = 1
    ENGINE=InnoDB;

CREATE TABLE `comment` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '评论编号',
	`user_id` BIGINT(20) NOT NULL COMMENT '发表评论的用户编号',
	`entity_type` INT(1) NOT NULL COMMENT '评论的实体类型',
	`entity_id` BIGINT(20) NOT NULL COMMENT '当前评论实体类型的编号',
	`content` VARCHAR(512) NOT NULL COMMENT '评论内容',
	`create_time` DATETIME NULL DEFAULT NULL COMMENT '创建时间',
	`update_time` DATETIME NULL DEFAULT NULL COMMENT '更新时间',
	PRIMARY KEY (`id`)
)
COMMENT='评论表'
    DEFAULT CHARSET = utf8
    AUTO_INCREMENT = 1
    ENGINE=InnoDB;

CREATE TABLE `active_status` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
	`user_id` BIGINT(20) NOT NULL COMMENT '用户编号',
	`code` VARCHAR(50) NOT NULL COMMENT '激活码',
	`status` INT(1) NOT NULL COMMENT '激活状态',
	`create_time` DATETIME NULL DEFAULT NULL COMMENT '创建时间',
	`update_time` DATETIME NULL DEFAULT NULL COMMENT '更新时间',
	PRIMARY KEY (`id`)
)
COMMENT='激活状态表'
    DEFAULT CHARSET = utf8
    AUTO_INCREMENT = 1
    ENGINE=InnoDB;

INSERT INTO `article`(`user_id`, `content`)
VALUES ('1', 'test');
INSERT INTO `user`(`username`, `email`, `password`, `salt`)
VALUES ('czq','925727227@qq.com', '1234', 'salt');
INSERT INTO `user`(`username`, `email`, `password`, `salt`)
VALUES ('wyx','925727227@qq.com', '1234', 'salt');
INSERT INTO `comment`(`user_id`, `entity_type`, `entity_id`, `content`)
VALUES ('1', '0', '1', 'test content');
