-- 创建支付表
CREATE TABLE payment(
	id bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
	serial varchar(200) DEFAULT '',
	PRIMARY KEY (id)
);