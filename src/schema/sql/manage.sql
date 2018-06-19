/*
 Navicat MySQL Data Transfer

 Source Server         : localhost
 Source Server Version : 50710
 Source Host           : localhost
 Source Database       : manage

 Target Server Version : 50710
 File Encoding         : utf-8

 Date: 06/19/2018 11:16:55 AM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `branch`
-- ----------------------------
DROP TABLE IF EXISTS `branch`;
CREATE TABLE `branch` (
  `id` varchar(64) NOT NULL COMMENT '机构id',
  `num` varchar(30) NOT NULL COMMENT '机构编号',
  `master` varchar(4) NOT NULL COMMENT '机构类别：政策性银行、邮储银行、国有银行、股份制银行、城商行、农商行、村镇银行、外资银行、外国银行、资产管理公司、信托公司、财务公司、汽车金融公司、金融租赁公司、消费金融公司、货币经济公司、专营机构\n分行、法人、分公司、卡中心、业务中心',
  `slaver` varchar(4) NOT NULL COMMENT '机构类型：',
  `name` varchar(200) NOT NULL COMMENT '机构名称',
  `state` varchar(1) NOT NULL COMMENT '状态——0:正常;1:被删除;',
  `author` varchar(64) NOT NULL COMMENT '添加人',
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `branch`
-- ----------------------------
BEGIN;
INSERT INTO `branch` VALUES ('100001', '100000001', '国有', '分行', '工商银行北京分行', '1', '9527', '2018-06-17 23:10:11'), ('100002', '100000002', '国有', '分行', '交通银行北京分行', '1', '9527', '2018-06-17 23:10:11'), ('100003', '100000003', '国有', '分行', '建设银行北京分行', '1', '9527', '2018-06-17 23:10:11'), ('100004', '100000004', '城商行', '法人', '齐鲁银行', '1', '9527', '2018-06-17 23:10:11'), ('100005', '100000005', '农商行', '法人', '北京农商银行', '1', '9527', '2018-06-17 23:10:11');
COMMIT;

-- ----------------------------
--  Table structure for `file`
-- ----------------------------
DROP TABLE IF EXISTS `file`;
CREATE TABLE `file` (
  `id` varchar(64) NOT NULL COMMENT '文件id',
  `name` varchar(100) NOT NULL COMMENT '文件名称',
  `path` varchar(100) NOT NULL COMMENT '文件路径',
  `state` varchar(1) NOT NULL COMMENT '状态——0:正常;1:删除;',
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '添加时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `file`
-- ----------------------------
BEGIN;
INSERT INTO `file` VALUES ('100001', '安全检查', 'c:/', '0', '2018-06-18 00:38:04');
COMMIT;

-- ----------------------------
--  Table structure for `manager`
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `name` varchar(10) NOT NULL COMMENT '管理员姓名',
  `section` varchar(30) NOT NULL COMMENT '管理员所属处室',
  `post` varchar(30) NOT NULL COMMENT '管理员职位',
  `password` varchar(64) NOT NULL COMMENT '管理员密码',
  `type` varchar(1) NOT NULL COMMENT '管理员类型 0:超级管理员;1:普通管理员;',
  `number` int(2) NOT NULL COMMENT '当日密码错误次数',
  `date` date NOT NULL COMMENT '密码错误日期',
  PRIMARY KEY (`name`),
  UNIQUE KEY `manager_name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `manager`
-- ----------------------------
BEGIN;
INSERT INTO `manager` VALUES ('chaoji', '核查一室', '局长', '123456', '0', '0', '0000-00-00');
COMMIT;

-- ----------------------------
--  Table structure for `project`
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project` (
  `id` varchar(64) NOT NULL COMMENT '项目id',
  `name` varchar(200) NOT NULL COMMENT '项目名称',
  `desc` text NOT NULL COMMENT '项目描述',
  `state` varchar(1) NOT NULL COMMENT '0:正常;1:关闭;',
  `date` varchar(12) NOT NULL COMMENT '检查月份',
  `manager_id` varchar(64) NOT NULL COMMENT '管理员id',
  `manager_name` varchar(100) NOT NULL COMMENT '管理员姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `project`
-- ----------------------------
BEGIN;
INSERT INTO `project` VALUES ('100001', '安全检查', '安全检查', '0', '2018-06', '9527', '9527');
COMMIT;

-- ----------------------------
--  Table structure for `project_branch_relation`
-- ----------------------------
DROP TABLE IF EXISTS `project_branch_relation`;
CREATE TABLE `project_branch_relation` (
  `project_id` varchar(64) NOT NULL,
  `branch_id` varchar(64) NOT NULL,
  PRIMARY KEY (`project_id`,`branch_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `project_branch_relation`
-- ----------------------------
BEGIN;
INSERT INTO `project_branch_relation` VALUES ('100001', '100001'), ('100001', '100002'), ('100001', '100003');
COMMIT;

-- ----------------------------
--  Table structure for `project_file_relation`
-- ----------------------------
DROP TABLE IF EXISTS `project_file_relation`;
CREATE TABLE `project_file_relation` (
  `project_id` varchar(64) NOT NULL COMMENT '项目id',
  `file_id` varchar(64) NOT NULL COMMENT '文件id',
  PRIMARY KEY (`project_id`,`file_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `project_file_relation`
-- ----------------------------
BEGIN;
INSERT INTO `project_file_relation` VALUES ('100001', '100001');
COMMIT;

-- ----------------------------
--  Table structure for `project_user_relation`
-- ----------------------------
DROP TABLE IF EXISTS `project_user_relation`;
CREATE TABLE `project_user_relation` (
  `project_id` varchar(64) NOT NULL COMMENT '项目id',
  `user_id` varchar(64) NOT NULL COMMENT '检查人员id（组长、主查、检查人员）',
  `type` varchar(1) NOT NULL COMMENT '0:组长;1:主查;2:组员;',
  PRIMARY KEY (`project_id`,`user_id`,`type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `project_user_relation`
-- ----------------------------
BEGIN;
INSERT INTO `project_user_relation` VALUES ('100001', '100001', '0'), ('100001', '100002', '1'), ('100001', '100003', '1'), ('100001', '100004', '2'), ('100001', '100005', '2'), ('100001', '100007', '2');
COMMIT;

-- ----------------------------
--  Table structure for `transfer`
-- ----------------------------
DROP TABLE IF EXISTS `transfer`;
CREATE TABLE `transfer` (
  `id` varchar(64) NOT NULL COMMENT '流水id',
  `name` varchar(100) NOT NULL COMMENT '交易名称',
  `author_id` varchar(64) NOT NULL COMMENT '操作者id',
  `author_name` varchar(100) NOT NULL COMMENT '操作者姓名',
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `state` varchar(1) NOT NULL COMMENT '0:成功;1:失败;',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(64) NOT NULL COMMENT '用户编号',
  `name` varchar(10) NOT NULL COMMENT '用户名',
  `section` varchar(40) NOT NULL COMMENT '处室',
  `post` varchar(40) NOT NULL COMMENT '职位',
  `specialty` varchar(100) NOT NULL COMMENT '特长',
  `manager_id` varchar(64) NOT NULL,
  `manager_name` varchar(100) NOT NULL,
  `state` varchar(1) NOT NULL COMMENT '0:正常;1:注销;',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `user`
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES ('100001', '张三', '核查一室', '科长', 'java、zookeeper', '100001', 'chaoji', '0'), ('100002', '李四', '核查二室', '局长', 'dubbo、zookeeper', '100001', 'chaoji', '0'), ('100003', '王五', '核查一室', '科员', 'docker、zookeeper', '100001', 'chaoji', '0'), ('100004', '赵六', '核查三室', '组长', 'Kafka、zookeeper', '100001', 'chaoji', '0'), ('100005', '孙七', '核查四室', '司长', 'ActiveMQ、zookeeper', '100001', 'chaoji', '0'), ('100006', '周八', '核查四室', '科员', 'MongoDB、zookeeper', '100001', 'chaoji', '0'), ('100007', '吴九', '核查一室', '科员', 'SpringBoot、zookeeper', '100001', 'chaoji', '0');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
