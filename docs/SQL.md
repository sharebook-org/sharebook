# SQL

## User用户表

```
USE sharebook;
CREATE TABLE `user` (
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
## Follow关注表

```
USE sharebook;
CREATE TABLE `follow`(
	`id` BIGINT(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
	`user_id` BIGINT(10) NOT NULL  COMMENT '用户编号',
	`follow_user_id` BIGINT(10) NOT NULL COMMENT '被关注用户编号',
	PRIMARY KEY (`id`)
)
	COMMENT='关注表'
	ENGINE=innoDB
	;
```
## Article文章表
```
use sharebook;
DROP TABLE IF EXISTS `article`;
CREATE TABLE Article(
`id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '文章编号',
`user_id` INT(20) NOT NULL COMMENT '用户编号',
`content` VARCHAR(1024) NOT NULL COMMENT '文章内容',
`status` INTEGER(1)  DEFAULT '0' COMMENT '文章状态 0 文章正常，1 文章已被删除',
`comment_num` BIGINT(254) COMMENT '评论数',
`like_num` BIGINT(254) COMMENT '点赞数',
`create_time` DATE  COMMENT '创建时间',
`update_time` DATE  COMMENT '更新时间',
PRIMARY KEY(`id`) USING BTREE
)
COMMENT='文章表'
ENGINE = INNODB;
;
```

## Like点赞表

```
USE sharebook;
CREATE TABLE `like`(
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
	`entity_type` INT(10) NOT NULL DEFAULT '0' COMMENT '点赞实体类型 0为文章类型，1为评论类型',
	`entity_id` INT(10) COMMENT '当前点赞实体的编号',
	`user_id` BIGINT(20) COMMENT '用户编号',
	`liked` INT(10) NOT NULL DEFAULT '0' COMMENT '0为未点赞，1为已点赞',
	PRIMARY KEY (`id`)
)
	COMMENT='点赞表'
	ENGINE=innoDB
	;
```

## Comment评论表
```sql
use sharebook;
drop TABLE IF EXISTS `comment`;
CREATE TABLE 	`comment`(
	`id` BIGINT(10) NOT NULL auto_increment COMMENT '评论编号',
	`user_id` BIGINT(11) NOT NULL COMMENT '发表评论的用户编号',
	`entity_type` INT(11) NOT NULL DEFAULT '0' COMMENT '	评论的实体类型,0为文章类型，1为评论类型',
 `entity_id` BIGINT(12) NOT NULL COMMENT '当前评论实体类型的编号',
 `content` VARCHAR(254) NOT NULL COMMENT '评论内容',
 `create_time` date COMMENT '创建时间',
 `update_time` date COMMENT '更新时间',
	PRIMARY KEY (`id`)
)
COMMENT='评论表'
 ENGINE = InnoDB
 CHARACTER SET = utf8mb4
 COLLATE = utf8mb4_general_ci
```