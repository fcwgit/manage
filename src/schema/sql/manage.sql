/*
 Navicat MySQL Data Transfer

 Source Server         : localhost
 Source Server Version : 50710
 Source Host           : localhost
 Source Database       : manage

 Target Server Version : 50710
 File Encoding         : utf-8

 Date: 06/17/2018 23:55:06 PM
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
INSERT INTO `branch` VALUES ('1', '100000001', '国有', '分行', '工商银行北京分行', '1', '9527', '2018-06-17 23:10:11');
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
--  Table structure for `manager`
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `id` varchar(64) NOT NULL COMMENT '管理员编号',
  `name` varchar(10) NOT NULL COMMENT '管理员姓名',
  `section` varchar(30) NOT NULL COMMENT '管理员所属处室',
  `post` varchar(30) NOT NULL COMMENT '管理员职位',
  `password` varchar(64) NOT NULL COMMENT '管理员密码',
  `type` varchar(1) NOT NULL COMMENT '管理员类型 0:超级管理员;1:普通管理员;',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
  `user_id` varchar(64) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `project_branch_relation`
-- ----------------------------
DROP TABLE IF EXISTS `project_branch_relation`;
CREATE TABLE `project_branch_relation` (
  `id` varchar(64) NOT NULL,
  `project_id` varchar(64) NOT NULL,
  `branch_id` varchar(64) NOT NULL,
  `state` varchar(1) NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`,`project_id`,`branch_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `project_file_relation`
-- ----------------------------
DROP TABLE IF EXISTS `project_file_relation`;
CREATE TABLE `project_file_relation` (
  `id` varchar(64) NOT NULL,
  `project_id` varchar(64) NOT NULL COMMENT '项目id',
  `file_id` varchar(64) NOT NULL COMMENT '文件id',
  `state` varchar(1) NOT NULL COMMENT '0:正常;1:删除;',
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '添加时间',
  PRIMARY KEY (`id`,`project_id`,`file_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `project_user_relation`
-- ----------------------------
DROP TABLE IF EXISTS `project_user_relation`;
CREATE TABLE `project_user_relation` (
  `id` varchar(64) NOT NULL,
  `project_id` varchar(64) NOT NULL COMMENT '项目id',
  `user_id` varchar(64) NOT NULL COMMENT '检查人员id（组长、主查、检查人员）',
  `type` varchar(1) NOT NULL COMMENT '0:组长;1:主查;2:组员;',
  `state` varchar(1) NOT NULL COMMENT '0:正常;1:关闭;',
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  PRIMARY KEY (`id`,`project_id`,`user_id`,`type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
