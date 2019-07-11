# SQL

## User用户表

```sql
CREATE TABLE `user` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
	`username` VARCHAR(20) NOT NULL COMMENT '用户昵称',
	`password` VARCHAR(20) NOT NULL COMMENT '密码',
	`salt` VARCHAR(10) NOT NULL COMMENT '四位随机字符串，用于用户密码加密',
	`introduction` VARCHAR(200) NULL DEFAULT NULL COMMENT '介绍',
	`sex` TINYINT(1) NULL DEFAULT '2' COMMENT '女：0，男：1，其他：2',
	`birth` DATE NULL DEFAULT NULL COMMENT '生日',
	`location` VARCHAR(20) NULL DEFAULT NULL COMMENT '地区',
	`status` TINYINT(1) NOT NULL DEFAULT '0' COMMENT '正常：0，封禁：1',
	`role` TINYINT(1) NOT NULL DEFAULT '0' COMMENT '普通用户：0，大V用户：1，管理员用户：9',
	`avatar` VARCHAR(512) NULL DEFAULT NULL COMMENT '头像链接',
	`create_time` DATETIME NULL DEFAULT NULL COMMENT '创建时间',
	`update_time` DATETIME NULL DEFAULT NULL COMMENT '更新时间',
	PRIMARY KEY (`id`)
)
COMMENT='用户表'
ENGINE=InnoDB
;
```
## Follow关注表

```sql
CREATE TABLE `follow` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
	`user_id` BIGINT(20) NOT NULL COMMENT '用户编号',
	`follow_user_id` BIGINT(20) NOT NULL COMMENT '被关注用户编号',
	`create_time` DATETIME NULL DEFAULT NULL COMMENT '创建时间',
	`update_time` DATETIME NULL DEFAULT NULL COMMENT '更新时间',
	PRIMARY KEY (`id`)
)
COMMENT='关注表'
ENGINE=InnoDB
```
## Article文章表

```sql
CREATE TABLE `article` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '文章编号',
	`user_id` BIGINT(20) NOT NULL COMMENT '用户编号',
	`content` VARCHAR(512) NOT NULL COMMENT '文章内容',
	`images` VARCHAR(1024) NULL DEFAULT NULL COMMENT '文章图片链接',
	`status` TINYINT(1) NOT NULL DEFAULT '0' COMMENT '正常：0，删除：1',
	`comment_num` BIGINT(20) NULL DEFAULT NULL COMMENT '评论数',
	`like_num` BIGINT(20) NULL DEFAULT NULL COMMENT '点赞数',
	`create_time` DATETIME NULL DEFAULT NULL COMMENT '创建时间',
	`update_time` DATETIME NULL DEFAULT NULL COMMENT '更新时间',
	PRIMARY KEY (`id`)
)
COMMENT='文章表'
ENGINE=InnoDB
;
```
## Like点赞表

```sql
CREATE TABLE `like` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
	`entity_type` TINYINT(1) NOT NULL COMMENT '点赞实体类型 0为文章类型，1为评论类型',
	`entity_id` BIGINT(20) NOT NULL COMMENT '当前点赞实体的编号',
	`user_id` BIGINT(20) NOT NULL COMMENT '用户编号',
	`liked` TINYINT(1) NOT NULL DEFAULT '0' COMMENT '0为未点赞，1为已点赞',
	`create_time` DATETIME NULL DEFAULT NULL COMMENT '创建时间',
	`update_time` DATETIME NULL DEFAULT NULL COMMENT '更新时间',
	PRIMARY KEY (`id`)
)
COMMENT='点赞表'
ENGINE=InnoDB
;
```
## Comment评论表

```sql
CREATE TABLE `comment` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '评论编号',
	`user_id` BIGINT(20) NOT NULL COMMENT '发表评论的用户编号',
	`entity_type` TINYINT(1) NOT NULL COMMENT '评论的实体类型,0为文章类型，1为评论类型',
	`entity_id` BIGINT(20) NOT NULL COMMENT '当前评论实体类型的编号',
	`content` VARCHAR(512) NOT NULL COMMENT '评论内容',
	`create_time` DATETIME NULL DEFAULT NULL COMMENT '创建时间',
	`update_time` DATETIME NULL DEFAULT NULL COMMENT '更新时间',
	PRIMARY KEY (`id`)
)
COMMENT='评论表'
ENGINE=InnoDB
;
```

