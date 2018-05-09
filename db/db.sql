DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id 编号',
  `
  create_time` timestamp default null COMMENT '创建时间',
  `update_time` timestamp default null COMMENT '更新时间',
	`user_name` VARCHAR(30) DEFAULT NULL,
	`pass_word` VARCHAR(30) DEFAULT NULL,
	PRIMARY KEY (`id`)
);

insert into user_info(user_name,pass_word) values ('tom','123');