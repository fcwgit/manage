/*
 Navicat MySQL Data Transfer

 Source Server         : localhost
 Source Server Version : 50710
 Source Host           : localhost
 Source Database       : manage

 Target Server Version : 50710
 File Encoding         : utf-8

 Date: 06/26/2018 09:58:12 AM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `branch`
-- ----------------------------
DROP TABLE IF EXISTS `branch`;
CREATE TABLE `branch` (
  `id` varchar(64) NOT NULL COMMENT 'id',
  `num` varchar(30) NOT NULL COMMENT '机构编号',
  `master` varchar(10) NOT NULL COMMENT '机构类别：政策性银行、邮储银行、国有银行、股份制银行、城商行、农商行、村镇银行、外资银行、外国银行、资产管理公司、信托公司、财务公司、汽车金融公司、金融租赁公司、消费金融公司、货币经济公司、专营机构\n分行、法人、分公司、卡中心、业务中心',
  `slaver` varchar(10) NOT NULL COMMENT '机构类型：法人、股份制',
  `label` varchar(200) NOT NULL COMMENT '机构名称',
  `state` varchar(1) NOT NULL DEFAULT '0' COMMENT '状态——0:正常;1:被删除;',
  `author` varchar(64) NOT NULL COMMENT '添加人',
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `branch`
-- ----------------------------
BEGIN;
INSERT INTO `branch` VALUES ('000000000', '100000007', '10001', '20001', '中国银行北京分行', '0', 'chaoji', '2018-06-23 16:01:55'), ('111111111', '10000000029', '10004', '20002', '重庆商行', '0', 'chaoji', '2018-06-23 16:06:50'), ('123456789', '100000009', '10004', '20003', '浙商银行', '0', 'chaoji', '2018-06-23 16:02:46'), ('222222222', '10000000090', '10008', '20002', '乐山商行', '0', 'chaoji', '2018-06-23 16:05:32'), ('333333333', '10000000091', '10008', '20002', '乐山商行', '0', 'chaoji', '2018-06-23 16:04:48'), ('444444444', '100000001', '10001', '20001', '工商银行北京分行', '1', '9527', '2018-06-17 23:10:11'), ('555555555', '1000000010', '10002', '20001', '哈尔滨商行2', '0', 'chaoji', '2018-06-23 16:03:48'), ('666666666', '100000002', '10001', '20002', '交通银行北京分行', '1', '9527', '2018-06-17 23:10:11'), ('777777777', '100000003', '10001', '20003', '建设银行北京分行', '1', '9527', '2018-06-17 23:10:11'), ('888888888', '100000004', '10004', '20001', '齐鲁银行', '1', '9527', '2018-06-17 23:10:11'), ('999999999', '100000005', '10004', '20003', '北京农商银行', '1', '9527', '2018-06-17 23:10:11');
COMMIT;

-- ----------------------------
--  Table structure for `dict`
-- ----------------------------
DROP TABLE IF EXISTS `dict`;
CREATE TABLE `dict` (
  `type` varchar(20) NOT NULL COMMENT '类型',
  `code` varchar(5) NOT NULL COMMENT 'key',
  `message` varchar(20) NOT NULL COMMENT 'value',
  `mark` varchar(40) NOT NULL COMMENT '备注',
  PRIMARY KEY (`type`,`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `dict`
-- ----------------------------
BEGIN;
INSERT INTO `dict` VALUES ('branch_master_type', '10001', '财务公司', '一级机构类型'), ('branch_master_type', '10002', '城商银行', '一级机构类型'), ('branch_master_type', '10003', '村镇银行', '一级机构类型'), ('branch_master_type', '10004', '股份制银行', '一级机构类型'), ('branch_master_type', '10005', '国有银行', '一级机构类型'), ('branch_master_type', '10006', '货币经济公司', '一级机构类型'), ('branch_master_type', '10007', '金融租赁公司', '一级机构类型'), ('branch_master_type', '10008', '农商银行', '一级机构类型'), ('branch_master_type', '10009', '汽车金融公司', '一级机构类型'), ('branch_master_type', '10010', '外国银行', '一级机构类型'), ('branch_master_type', '10011', '外资银行', '一级机构类型'), ('branch_master_type', '10012', '消费金融公司', '一级机构类型'), ('branch_master_type', '10013', '信托公司', '一级机构类型'), ('branch_master_type', '10014', '邮储银行', '一级机构类型'), ('branch_master_type', '10015', '政策性银行', '一级机构类型'), ('branch_master_type', '10016', '专营机构', '一级机构类型'), ('branch_master_type', '10017', '资产管理公司', '一级机构类型'), ('branch_rate', '50', '一般', '检查对象优先级'), ('branch_rate', '70', '较高级', '检查对象优先级'), ('branch_rate', '90', '高级', '检查对象优先级'), ('branch_slaver_type', '20001', '分行', '二级机构类型'), ('branch_slaver_type', '20002', '法人', '二级机构类型'), ('branch_slaver_type', '20003', '政策', '二级机构类型'), ('branch_state', '0', '正常', '机构状态'), ('branch_state', '1', '注销', '机构状态'), ('manager_state', '0', '正常', '管理员状态'), ('manager_state', '1', '密码初始化', '管理员状态'), ('manager_state', '2', '注销', '管理员状态'), ('manager_type', '0', '超级管理员', '管理员等级'), ('manager_type', '1', '普通管理员', '管理员等级'), ('project_state', '0', '正常', '项目状态'), ('project_state', '1', '注销', '项目状态'), ('user_state', '0', '正常', '检查人员状态'), ('user_state', '1', '注销', '检查人员状态');
COMMIT;

-- ----------------------------
--  Table structure for `error`
-- ----------------------------
DROP TABLE IF EXISTS `error`;
CREATE TABLE `error` (
  `code` varchar(6) NOT NULL,
  `message` varchar(100) NOT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `error`
-- ----------------------------
BEGIN;
INSERT INTO `error` VALUES ('000000', '处理成功'), ('100001', '用户名不能为空'), ('100002', '用户名或密码错误'), ('100003', '密码错误次数超限，请明天再试'), ('100004', '请修改密码'), ('100005', '原密码错误'), ('100006', '请重新登录'), ('200001', '机构编号已经存在');
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
  `alias` varchar(10) NOT NULL,
  `section` varchar(30) NOT NULL COMMENT '管理员所属处室',
  `post` varchar(30) NOT NULL COMMENT '管理员职位',
  `password` varchar(64) NOT NULL COMMENT '管理员密码',
  `type` varchar(1) NOT NULL COMMENT '管理员类型 0:超级管理员;1:普通管理员;',
  `number` int(2) NOT NULL DEFAULT '0' COMMENT '当日密码错误次数',
  `date` varchar(10) NOT NULL DEFAULT '20180619' COMMENT '密码错误日期',
  `state` varchar(1) NOT NULL DEFAULT '1' COMMENT '状态 0:正常;1:修改密码;2:注销;',
  `author` varchar(10) NOT NULL COMMENT '新增记录管理员',
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加日期',
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `manager`
-- ----------------------------
BEGIN;
INSERT INTO `manager` VALUES ('chaoji', '超级', '核查一室', '局长', 'E10ADC3949BA59ABBE56E057F20F883E', '0', '0', '20180619', '0', 'chaoji', '2018-06-21 20:39:11'), ('chaojichao', '超级01', '稽查', '组长', 'E10ADC3949BA59ABBE56E057F20F883E', '0', '0', '20180619', '1', 'chaoji', '2018-06-22 13:46:59'), ('fefeef', 'fe\'fe', 'fe\'fe', '分分', 'E10ADC3949BA59ABBE56E057F20F883E', '1', '0', '20180619', '1', 'chaoji', '2018-06-22 13:47:39'), ('fefefe', '凤飞飞', '分分', '分分', 'E10ADC3949BA59ABBE56E057F20F883E', '0', '0', '20180619', '1', 'chaoji', '2018-06-22 13:47:16'), ('lisi', '李四', '核查一室', '组员', 'E10ADC3949BA59ABBE56E057F20F883E', '1', '0', '20180619', '1', 'chaoji', '2018-06-21 20:39:11'), ('sunqi', '孙七', '三室', '组长', 'E10ADC3949BA59ABBE56E057F20F883E', '1', '0', '20180619', '1', 'chaoji', '2018-06-22 10:07:09'), ('wangw', '王五', '三室', '科员', 'E10ADC3949BA59ABBE56E057F20F883E', '1', '0', '20180619', '1', 'chaoji', '2018-06-22 09:28:04'), ('wujiu', '吴九', '二室', '测试', 'E10ADC3949BA59ABBE56E057F20F883E', '1', '0', '20180619', '1', 'chaoji', '2018-06-22 13:46:11'), ('zhangsan', '张三', '核查二室', '科长', 'E10ADC3949BA59ABBE56E057F20F883E', '1', '0', '20180619', '0', 'chaoji', '2018-06-21 20:39:11'), ('zhaoliu', '赵六', '三室', '组长', 'E10ADC3949BA59ABBE56E057F20F883E', '1', '0', '20180619', '1', 'chaoji', '2018-06-22 09:54:23'), ('zhouba', '周八', '三室', '测试', 'E10ADC3949BA59ABBE56E057F20F883E', '0', '0', '20180619', '1', 'chaoji', '2018-06-22 13:45:32');
COMMIT;

-- ----------------------------
--  Table structure for `param`
-- ----------------------------
DROP TABLE IF EXISTS `param`;
CREATE TABLE `param` (
  `id` varchar(20) NOT NULL COMMENT '参数id',
  `param` varchar(100) NOT NULL COMMENT '参数值',
  `mark` varchar(30) NOT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `param`
-- ----------------------------
BEGIN;
INSERT INTO `param` VALUES ('filePath', '/Users/fanchengwei/Desktop/img/', '文件保存路径'), ('init_password', '123456', '初始化密码'), ('page_size', '20', '每页显示记录数');
COMMIT;

-- ----------------------------
--  Table structure for `project`
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project` (
  `id` varchar(64) NOT NULL COMMENT '项目id',
  `name` varchar(200) NOT NULL COMMENT '项目名称',
  `des` text NOT NULL COMMENT '项目描述',
  `state` varchar(1) NOT NULL DEFAULT '0' COMMENT '0:正常;1:关闭;',
  `date` varchar(12) NOT NULL COMMENT '检查月份',
  `author` varchar(64) NOT NULL COMMENT '管理员id',
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '项目创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `project`
-- ----------------------------
BEGIN;
INSERT INTO `project` VALUES ('006adcab-a5e1-4463-bd25-38e3f839fbce', '飞凤飞飞凤飞飞', '菲儿飞飞飞飞飞', '0', '2018-02', 'chaoji', '2018-06-25 17:31:26'), ('0180aa2a-3b74-4b34-acd0-29dded92538b', 'projectService', 'projectServiceprojectServiceprojectServiceprojectServiceprojectService', '0', '2018-07', 'chaoji', '2018-06-25 22:43:19'), ('01f560eb-87f9-4ff7-bb47-7f94f33a721a', '飞凤飞飞', '额凤飞飞 非非', '0', '2018-06', 'chaoji', '2018-06-25 07:07:16'), ('03f88be9-4b6e-49d2-be29-3f4ac651f788', '啊啊啊啊啊啊啊', 'a\'a\'a\'a\'a\'a\'a\'a\'a\'a\'a', '0', '2018-10', 'chaoji', '2018-06-24 22:04:20'), ('0934b5df-4cef-4f12-9ce2-c28119723cda', '22222222222222', '222222222222', '0', '2018-10', 'chaoji', '2018-06-24 22:24:18'), ('100001', '安全检查', '安全检查', '0', '2018-06', '9527', '2018-06-24 19:08:50'), ('15392e64-395f-40a9-84dc-7b2db8b93370', '飞凤飞飞凤飞飞付付付付', '飞凤飞飞凤飞飞付付付吧吧吧吧吧吧吧吧v', '0', '2018-08', 'chaoji', '2018-06-25 14:38:51'), ('280c0bbf-e1ca-4a1d-94d7-4c55b109f1b9', 'fefefefe', 'fefefefe', '0', '2018-10', 'chaoji', '2018-06-24 22:34:44'), ('284b85fa-7bfd-447f-b625-a0c505afb2af', '新建检查项目1', '新建检查项目1新建检查项目1新建检查项目1新建检查项目1新建检查项目1新建检查项目1新建检查项目1新建检查项目1新建检查项目1新建检查项目1新建检查项目1新建检查项目1新建检查项目1新建检查项目1新建检查项目1新建检查项目1新建检查项目1新建检查项目1新建检查项目1新建检查项目1新建检查项目1新建检查项目1新建检查项目1新建检查项目1新建检查项目1新建检查项目1', '0', '2018-10', 'chaoji', '2018-06-24 21:10:06'), ('2c2b4077-9825-40ae-8d5c-e61d33bc69a2', 'fefef', 'fefefe', '0', '2018-12', 'chaoji', '2018-06-24 23:00:51'), ('2d0c9f4d-90d9-43cc-b11c-6b41756c72e5', 'fefefef', 'fefefeffefef', '0', '2018-03', 'chaoji', '2018-06-25 09:58:59'), ('2f273a86-1603-4da1-bd72-745bd0969115', '6c37b128-000c-4a2d-9c5e-2e584d5898b7', '6c37b128-000c-4a2d-9c5e-2e584d5898b76c37b128-000c-4a2d-9c5e-2e584d5898b76c37b128-000c-4a2d-9c5e-2e584d5898b7', '0', '2018-10', 'chaoji', '2018-06-25 10:37:40'), ('3f700d35-9824-46a3-a550-df412e265ac6', '11111111111111111111', '1111111111111111', '0', '2018-01', 'chaoji', '2018-06-24 22:20:51'), ('42bdbb05-3be6-498c-9239-412717a13c46', '非飞凤飞飞凤飞飞付付付付付付付付付付付', '非飞凤飞飞凤飞飞付付付付付付付付付付付非飞凤飞飞凤飞飞付付付付付付付付付付付非飞凤飞飞凤飞飞付付付付付付付付付付付非飞凤飞飞凤飞飞付付付付付付付付付付付', '0', '2018-06', 'chaoji', '2018-06-25 10:42:51'), ('45233735-2ad5-4399-803e-b9a5ef79ebc5', '飞飞飞飞飞', '飞凤飞飞', '0', '2018-02', 'chaoji', '2018-06-25 22:35:37'), ('471c4ad8-ad3d-4ad5-ba0a-eeeb0e23f379', '飞凤飞飞凤飞飞付付付付付付付付付付付', '飞凤飞飞凤飞飞付付付付付付付付付付付飞凤飞飞凤飞飞付付付付付付付付付付付飞凤飞飞凤飞飞付付付付付付付付付付付', '0', '2018-05', 'chaoji', '2018-06-25 17:14:34'), ('4a96f222-3c68-4411-a5bc-b5b9eca6f1d0', '3333333', '3333333333333333', '0', '2018-01', 'chaoji', '2018-06-24 22:37:57'), ('4afcc6e2-9965-460e-a485-8228e6254802', 'f\'f\'f\'f\'f\'f', '凤飞飞', '0', '2018-09', 'chaoji', '2018-06-25 22:38:07'), ('4d7b9e27-b3de-46d9-bdbd-b465f8cb9f94', 'deleterdeleterdeleterdeleter', 'deleterdeleterdeleterdeleter', '0', '2018-10', 'chaoji', '2018-06-25 23:07:31'), ('4e6fd8c2-0cb9-4208-b7cd-2866698580a2', '菲儿飞飞飞飞飞分分', '菲儿飞飞飞飞飞分分菲儿飞飞飞飞飞分分菲儿飞飞飞飞飞分分菲儿飞飞飞飞飞分分菲儿飞飞飞飞飞分分', '0', '2018-06', 'chaoji', '2018-06-25 00:27:21'), ('4efd2d4c-c52f-495f-b523-3779dd6f517d', 'fe\'fe\'f', '分分', '0', '2018-07', 'chaoji', '2018-06-24 23:38:09'), ('51b8f4a8-f181-4b14-a64b-8107b2a3b805', 'fefefef', 'fefefef', '0', '2018-06', 'chaoji', '2018-06-24 23:23:10'), ('550276be-7fd0-49f7-a44f-4890fce631b4', '飞飞飞飞飞', '飞凤飞飞凤飞飞', '0', '2018-10', 'chaoji', '2018-06-25 09:07:43'), ('58e7c396-52b3-409f-9158-07ba6babdf57', '飞凤飞飞', '飞飞飞飞飞', '0', '2018-09', 'chaoji', '2018-06-25 22:32:47'), ('62216ed9-f016-416c-8b60-b8bb84d9ab3d', '分分非', '菲儿二二二二二二二二二二二二二二二二二二二二二二二二二二二二', '0', '2018-07', 'chaoji', '2018-06-25 00:31:04'), ('63f1f7ff-3592-4a4a-93d7-e2390dea4607', 'fe\'fe\'f', '飞凤飞飞', '0', '2018-06', 'chaoji', '2018-06-24 23:28:13'), ('6a239ba4-5b44-4445-8af7-516e75bdbf1e', '飞凤飞飞', '非额   凤飞飞', '0', '2018-02', 'chaoji', '2018-06-25 11:13:53'), ('6c37b128-000c-4a2d-9c5e-2e584d5898b7', '飞凤飞飞凤飞飞付付付付付付付付付付付', '飞凤飞飞凤飞飞付付付付付付付付付付付', '0', '2018-10', 'chaoji', '2018-06-25 10:32:03'), ('70c45e98-a575-4abc-bdd9-81620429b4dd', '菲儿二二二二二二', '点我点我多无多无多无', '0', '2018-05', 'chaoji', '2018-06-25 17:28:07'), ('74cc7ea2-46c8-4cc6-910e-abfdf34ba0e9', '分分fe\'f', 'fe\'ffe\'fe', '0', '2018-10', 'chaoji', '2018-06-24 22:49:14'), ('77f7962c-8a93-40b6-98a7-252280fa8d36', 'fefefe', 'fefefe', '0', '2018-10', 'chaoji', '2018-06-24 22:25:20'), ('7da8ff03-87f2-47c8-b90d-9419a4a7c2df', '飞凤飞飞凤飞飞付付', '飞凤飞飞凤飞飞付付f\'f\'f\'f\'f\'f\'f\'f\'f\'f\'f', '0', '2018-06', 'chaoji', '2018-06-25 11:38:03'), ('8afc6809-045c-4e5b-90b5-88d559cc32cf', '飞凤飞飞凤飞飞付', '飞凤飞飞凤飞飞付付付付付', '0', '2018-10', 'chaoji', '2018-06-25 16:32:55'), ('8d980d01-af29-4075-9ebf-93b9a4f6bb18', '飞飞飞飞飞', '菲儿飞飞飞飞飞', '0', '2018-09', 'chaoji', '2018-06-24 22:17:31'), ('8dbed989-b266-479b-bb99-851ea597015c', '删除文件', '删除文件删除文件删除文件', '0', '2018-10', 'chaoji', '2018-06-25 22:57:28'), ('9079cfe7-e466-4101-8ba2-22a6299a4861', '飞凤飞飞二二二二二二二二', '飞飞飞飞飞', '0', '2018-08', 'chaoji', '2018-06-25 15:53:06'), ('9eefdf92-155c-4f8a-97a9-6f053ee8915f', 'b\'b\'b\'b\'b\'b\'b\'b\'b', '版本版本不不不不不不不不不', '0', '2018-10', 'chaoji', '2018-06-24 22:30:41'), ('9f27f667-1aa9-4ea3-bfaf-e699e7ccbb7f', '飞凤飞飞凤飞飞付付付付付付', '菲儿二二二二二二二二二二二二二二二二二二二二二二二二二二二二', '0', '2018-06', 'chaoji', '2018-06-25 10:11:45'), ('a213c9d9-b81d-4edd-9291-73deb4389f26', '飞飞飞飞飞', '飞凤飞飞', '0', '2018-02', 'chaoji', '2018-06-24 23:48:53'), ('a2d5790e-a516-44a3-abdc-6b8d04c5558f', 'fileIdfileIdfileIdfileId', 'fileIdfileIdfileIdfileIdfileIdfileIdfileIdfileId', '0', '2018-09', 'chaoji', '2018-06-25 23:03:42'), ('a7f7bd2f-5223-49f1-96b4-43da84d000c7', '非额菲儿飞飞飞飞飞分分', '菲儿飞飞飞飞飞', '0', '2018-01', 'chaoji', '2018-06-25 14:31:55'), ('b1e8039b-6c9d-4462-87b6-c2d3d435b598', '那你那你女女女女女女女女女女女', '那你那你女女女女女女女女女女女', '0', '2018-06', 'chaoji', '2018-06-25 16:54:15'), ('b20601fb-0974-496a-9743-9e8f04207a95', '分分分分', '分分备份', '0', '2018-10', 'chaoji', '2018-06-24 23:29:21'), ('bb279d5e-919e-4123-b657-72454d95a3e1', 'fefefefef', 'efefefefefe', '0', '2018-02', 'chaoji', '2018-06-24 22:36:50'), ('bf49e023-5733-4a1a-ab88-064a66434d66', '检查项目名称2', '检查项目名称2检查项目名称2检查项目名称2检查项目名称2检查项目名称2检查项目名称2检查项目名称2检查项目名称2', '0', '2018-10', 'chaoji', '2018-06-24 21:18:02'), ('bf83f2ae-77c5-448f-921b-c627f5215641', '11111111111111111111', '1111111111111111', '0', '2018-01', 'chaoji', '2018-06-24 22:22:58'), ('cd5f8a44-3a8a-4096-b322-ec854aa94ce9', 'fe\'e\'e\'e\'e\'e\'e\'e\'e\'e\'e\'e', 'fe\'e\'e\'e\'e\'e\'e\'e\'e\'e\'e\'e\'e', '0', '2018-10', 'chaoji', '2018-06-24 22:27:42'), ('e079f0a8-10d0-4091-9794-3db556edabd0', 'ffefee', 'fefefe', '0', '2018-12', 'chaoji', '2018-06-24 23:00:11'), ('e4fda86a-0829-4d1e-8477-16968545de91', '飞飞飞飞飞', '凤飞飞', '0', '2018-01', 'chaoji', '2018-06-25 09:18:44'), ('e5405a42-8ebf-4b02-8afb-5d9fc5161c85', '飞凤飞飞凤飞飞付付付付付付付付付付付', '飞凤飞飞凤飞飞付付付付付付付付付付付', '0', '2018-01', 'chaoji', '2018-06-25 16:12:42'), ('e5ccdac4-297c-4818-bf9a-bb8f639703d9', '飞飞飞飞飞', '菲儿飞飞飞飞飞', '0', '2018-09', 'chaoji', '2018-06-25 09:20:23'), ('ed9b17ed-8441-48e9-a180-848252b9e1ff', '新建检查项目1新建检查项目1新建检查项目1新建检查项目1新建检查项目1新建检查项目1新建检查项目1新建检查项目1', '新建检查项目1新建检查项目1新建检查项目1新建检查项目1新建检查项目1新建检查项目1新建检查项目1新建检查项目1新建检查项目1新建检查项目1新建检查项目1新建检查项目1新建检查项目1新建检查项目1新建检查项目1新建检查项目1新建检查项目1新建检查项目1新建检查项目1新建检查项目1新建检查项目1新建检查项目1新建检查项目1新建检查项目1新建检查项目1新建检查项目1新建检查项目1新建检查项目1新建检查项目1新建检查项目1新建检查项目1', '0', '2018-10', 'chaoji', '2018-06-24 21:12:21'), ('fa395175-6bd4-4f74-bb34-273735780f4b', 'fefefe', 'fefe', '0', '2018-02', 'chaoji', '2018-06-24 23:21:15'), ('fac8b4d7-986c-45c5-abd0-ffb9f916438c', '凤飞飞', 'fe\'fe\'fe', '0', '2018-03', 'chaoji', '2018-06-24 23:17:13');
COMMIT;

-- ----------------------------
--  Table structure for `project_branch_relation`
-- ----------------------------
DROP TABLE IF EXISTS `project_branch_relation`;
CREATE TABLE `project_branch_relation` (
  `project_id` varchar(64) NOT NULL,
  `branch_id` varchar(64) NOT NULL,
  `num` varchar(30) NOT NULL,
  `label` varchar(200) NOT NULL,
  `master` varchar(10) NOT NULL,
  `masterDisplay` varchar(12) NOT NULL,
  `slaver` varchar(10) NOT NULL,
  `slaverDisplay` varchar(20) NOT NULL,
  `opt` varchar(5) NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `author` varchar(10) NOT NULL,
  `deleter` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`project_id`,`branch_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `project_branch_relation`
-- ----------------------------
BEGIN;
INSERT INTO `project_branch_relation` VALUES ('15392e64-395f-40a9-84dc-7b2db8b93370', '444444444', '100000001', '工商银行北京分行', '10001', '财务公司', '20001', '分行', '70', '2018-06-26 09:24:46', 'chaoji', null), ('15392e64-395f-40a9-84dc-7b2db8b93370', '666666666', '100000002', '交通银行北京分行', '10001', '财务公司', '20002', '法人', '90', '2018-06-26 09:24:46', 'chaoji', null), ('15392e64-395f-40a9-84dc-7b2db8b93370', '777777777', '100000003', '建设银行北京分行', '10001', '财务公司', '20003', '政策', '50', '2018-06-26 09:24:46', 'chaoji', null), ('b1e8039b-6c9d-4462-87b6-c2d3d435b598', '123456789', '100000009', '浙商银行', '10004', '股份制银行', '20003', '政策', '70', '2018-06-25 16:54:40', 'chaoji', null), ('b1e8039b-6c9d-4462-87b6-c2d3d435b598', '888888888', '100000004', '齐鲁银行', '10004', '股份制银行', '20001', '分行', '90', '2018-06-25 16:54:40', 'chaoji', null), ('b1e8039b-6c9d-4462-87b6-c2d3d435b598', '999999999', '100000005', '北京农商银行', '10004', '股份制银行', '20003', '政策', '50', '2018-06-25 16:54:40', 'chaoji', null), ('e5405a42-8ebf-4b02-8afb-5d9fc5161c85', '111111111', '10000000029', '重庆商行', '10004', '股份制银行', '20002', '法人', '50', '2018-06-25 16:13:09', 'chaoji', null), ('e5405a42-8ebf-4b02-8afb-5d9fc5161c85', '123456789', '100000009', '浙商银行', '10004', '股份制银行', '20003', '政策', '70', '2018-06-25 16:13:09', 'chaoji', null), ('e5405a42-8ebf-4b02-8afb-5d9fc5161c85', '999999999', '100000005', '北京农商银行', '10004', '股份制银行', '20003', '政策', '50', '2018-06-25 16:13:09', 'chaoji', null);
COMMIT;

-- ----------------------------
--  Table structure for `project_branch_relation_log`
-- ----------------------------
DROP TABLE IF EXISTS `project_branch_relation_log`;
CREATE TABLE `project_branch_relation_log` (
  `project_id` varchar(64) COLLATE utf8_bin NOT NULL,
  `branch_id` varchar(64) COLLATE utf8_bin NOT NULL,
  `num` varchar(30) COLLATE utf8_bin NOT NULL,
  `label` varchar(200) COLLATE utf8_bin NOT NULL,
  `master` varchar(10) COLLATE utf8_bin NOT NULL,
  `masterDisplay` varchar(12) COLLATE utf8_bin NOT NULL,
  `slaver` varchar(10) COLLATE utf8_bin NOT NULL,
  `slaverDisplay` varchar(20) COLLATE utf8_bin NOT NULL,
  `opt` varchar(5) COLLATE utf8_bin NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `author` varchar(10) COLLATE utf8_bin NOT NULL,
  `deleter` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `deletetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Records of `project_branch_relation_log`
-- ----------------------------
BEGIN;
INSERT INTO `project_branch_relation_log` VALUES ('15392e64-395f-40a9-84dc-7b2db8b93370', '123456789', '100000009', '浙商银行', '10004', '股份制银行', '20003', '政策', '70', '2018-06-25 14:39:30', 'chaoji', 'chaoji', '2018-06-25 14:39:49'), ('15392e64-395f-40a9-84dc-7b2db8b93370', '888888888', '100000004', '齐鲁银行', '10004', '股份制银行', '20001', '分行', '90', '2018-06-25 14:39:30', 'chaoji', 'chaoji', '2018-06-25 14:39:49'), ('15392e64-395f-40a9-84dc-7b2db8b93370', '999999999', '100000005', '北京农商银行', '10004', '股份制银行', '20003', '政策', '50', '2018-06-25 14:39:30', 'chaoji', 'chaoji', '2018-06-25 14:39:49'), ('15392e64-395f-40a9-84dc-7b2db8b93370', '111111111', '10000000029', '重庆商行', '10004', '股份制银行', '20002', '法人', '50', '2018-06-25 14:39:49', 'chaoji', 'chaoji', '2018-06-25 14:45:41'), ('15392e64-395f-40a9-84dc-7b2db8b93370', '123456789', '100000009', '浙商银行', '10004', '股份制银行', '20003', '政策', '70', '2018-06-25 14:39:49', 'chaoji', 'chaoji', '2018-06-25 14:45:41'), ('e5405a42-8ebf-4b02-8afb-5d9fc5161c85', '123456789', '100000009', '浙商银行', '10004', '股份制银行', '20003', '政策', '70', '2018-06-25 16:13:01', 'chaoji', 'chaoji', '2018-06-25 16:13:09'), ('e5405a42-8ebf-4b02-8afb-5d9fc5161c85', '888888888', '100000004', '齐鲁银行', '10004', '股份制银行', '20001', '分行', '90', '2018-06-25 16:13:01', 'chaoji', 'chaoji', '2018-06-25 16:13:09'), ('b1e8039b-6c9d-4462-87b6-c2d3d435b598', '123456789', '100000009', '浙商银行', '10004', '股份制银行', '20003', '政策', '70', '2018-06-25 16:54:35', 'chaoji', 'chaoji', '2018-06-25 16:54:40'), ('b1e8039b-6c9d-4462-87b6-c2d3d435b598', '888888888', '100000004', '齐鲁银行', '10004', '股份制银行', '20001', '分行', '90', '2018-06-25 16:54:35', 'chaoji', 'chaoji', '2018-06-25 16:54:40'), ('15392e64-395f-40a9-84dc-7b2db8b93370', '123456789', '100000009', '浙商银行', '10004', '股份制银行', '20003', '政策', '70', '2018-06-25 14:45:41', 'chaoji', 'chaoji', '2018-06-26 09:24:46'), ('15392e64-395f-40a9-84dc-7b2db8b93370', '999999999', '100000005', '北京农商银行', '10004', '股份制银行', '20003', '政策', '90', '2018-06-25 14:45:41', 'chaoji', 'chaoji', '2018-06-26 09:24:46');
COMMIT;

-- ----------------------------
--  Table structure for `project_file_relation`
-- ----------------------------
DROP TABLE IF EXISTS `project_file_relation`;
CREATE TABLE `project_file_relation` (
  `project_id` varchar(64) NOT NULL COMMENT '项目id',
  `file_id` varchar(64) NOT NULL COMMENT '文件id',
  `name` varchar(100) NOT NULL,
  `original` varchar(100) NOT NULL,
  `path` varchar(100) NOT NULL,
  `author` varchar(10) NOT NULL,
  `deleter` varchar(10) DEFAULT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`project_id`,`file_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `project_file_relation`
-- ----------------------------
BEGIN;
INSERT INTO `project_file_relation` VALUES ('4d7b9e27-b3de-46d9-bdbd-b465f8cb9f94', '41df6066-0571-4af0-8c5c-814b9fffbcd2', '41df6066-0571-4af0-8c5c-814b9fffbcd2.jpeg', 'WechatIMG53.jpeg', 'img/41df6066-0571-4af0-8c5c-814b9fffbcd2.jpeg', 'chaoji', null, '2018-06-25 23:18:21');
COMMIT;

-- ----------------------------
--  Table structure for `project_file_relation_log`
-- ----------------------------
DROP TABLE IF EXISTS `project_file_relation_log`;
CREATE TABLE `project_file_relation_log` (
  `project_id` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '项目id',
  `file_id` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '文件id',
  `name` varchar(100) COLLATE utf8_bin NOT NULL,
  `original` varchar(100) COLLATE utf8_bin NOT NULL,
  `path` varchar(100) COLLATE utf8_bin NOT NULL,
  `author` varchar(10) COLLATE utf8_bin NOT NULL,
  `deleter` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Records of `project_file_relation_log`
-- ----------------------------
BEGIN;
INSERT INTO `project_file_relation_log` VALUES ('4d7b9e27-b3de-46d9-bdbd-b465f8cb9f94', 'a6d13ca1-2153-4fec-bd85-da62d0bde82a', 'a6d13ca1-2153-4fec-bd85-da62d0bde82a.jpeg', 'WechatIMG53.jpeg', 'img/a6d13ca1-2153-4fec-bd85-da62d0bde82a.jpeg', 'chaoji', 'chaoji', '2018-06-25 23:08:09');
COMMIT;

-- ----------------------------
--  Table structure for `project_user_relation`
-- ----------------------------
DROP TABLE IF EXISTS `project_user_relation`;
CREATE TABLE `project_user_relation` (
  `project_id` varchar(64) NOT NULL COMMENT '项目id',
  `user_id` varchar(64) NOT NULL COMMENT '检查人员id（组长、主查、检查人员）',
  `type` varchar(1) NOT NULL COMMENT '0:组长;1:主查;2:组员;3:副组长;4:副主查;',
  `name` varchar(10) NOT NULL,
  `pinyin` varchar(20) NOT NULL,
  `section` varchar(40) NOT NULL,
  `post` varchar(40) NOT NULL,
  `specialty` varchar(100) NOT NULL,
  `author` varchar(10) NOT NULL,
  `deleter` varchar(10) DEFAULT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`project_id`,`user_id`,`type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `project_user_relation`
-- ----------------------------
BEGIN;
INSERT INTO `project_user_relation` VALUES ('006adcab-a5e1-4463-bd25-38e3f839fbce', '100003', '4', '王五', 'wangwu', '核查一室', '科员', 'docker、zookeeper', 'chaoji', null, '2018-06-25 17:32:56'), ('006adcab-a5e1-4463-bd25-38e3f839fbce', '100005', '4', '孙七', 'sunqi', '核查四室', '司长', 'ActiveMQ、zookeeper', 'chaoji', null, '2018-06-25 17:32:56');
COMMIT;

-- ----------------------------
--  Table structure for `project_user_relation_log`
-- ----------------------------
DROP TABLE IF EXISTS `project_user_relation_log`;
CREATE TABLE `project_user_relation_log` (
  `project_id` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '项目id',
  `user_id` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '检查人员id（组长、主查、检查人员）',
  `type` varchar(1) COLLATE utf8_bin NOT NULL COMMENT '0:组长;1:主查;2:组员;3:副组长;4:副主查;',
  `name` varchar(10) COLLATE utf8_bin NOT NULL,
  `pinyin` varchar(20) COLLATE utf8_bin NOT NULL,
  `section` varchar(40) COLLATE utf8_bin NOT NULL,
  `post` varchar(40) COLLATE utf8_bin NOT NULL,
  `specialty` varchar(100) COLLATE utf8_bin NOT NULL,
  `author` varchar(10) COLLATE utf8_bin NOT NULL,
  `deleter` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `deletetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Records of `project_user_relation_log`
-- ----------------------------
BEGIN;
INSERT INTO `project_user_relation_log` VALUES ('006adcab-a5e1-4463-bd25-38e3f839fbce', '100002', '4', '李四', 'lisi', '核查二室', '局长', 'dubbo、zookeeper', 'chaoji', 'chaoji', '2018-06-25 17:32:42', '2018-06-25 17:32:56'), ('006adcab-a5e1-4463-bd25-38e3f839fbce', '100003', '4', '王五', 'wangwu', '核查一室', '科员', 'docker、zookeeper', 'chaoji', 'chaoji', '2018-06-25 17:32:42', '2018-06-25 17:32:56'), ('006adcab-a5e1-4463-bd25-38e3f839fbce', '100004', '4', '赵六', 'zhaoliu', '核查三室', '组长', 'Kafka、zookeeper', 'chaoji', 'chaoji', '2018-06-25 17:32:42', '2018-06-25 17:32:56'), ('006adcab-a5e1-4463-bd25-38e3f839fbce', '100005', '4', '孙七', 'sunqi', '核查四室', '司长', 'ActiveMQ、zookeeper', 'chaoji', 'chaoji', '2018-06-25 17:32:42', '2018-06-25 17:32:56');
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
  `pinyin` varchar(20) NOT NULL COMMENT '姓名拼音',
  `section` varchar(40) NOT NULL COMMENT '处室',
  `post` varchar(40) NOT NULL COMMENT '职位',
  `specialty` varchar(100) NOT NULL COMMENT '特长',
  `author` varchar(10) NOT NULL,
  `state` varchar(1) NOT NULL COMMENT '0:正常;1:注销;',
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `user`
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES ('100001', '张三', 'zhangsan', '核查一室', '科长', 'java、zookeeper', '100001', '0', '2018-06-22 16:05:42'), ('100002', '李四', 'lisi', '核查二室', '局长', 'dubbo、zookeeper', '100001', '0', '2018-06-22 16:05:42'), ('100003', '王五', 'wangwu', '核查一室', '科员', 'docker、zookeeper', '100001', '0', '2018-06-22 16:05:42'), ('100004', '赵六', 'zhaoliu', '核查三室', '组长', 'Kafka、zookeeper', '100001', '0', '2018-06-22 16:05:42'), ('100005', '孙七', 'sunqi', '核查四室', '司长', 'ActiveMQ、zookeeper', '100001', '0', '2018-06-22 16:05:42'), ('100006', '周八', 'zhouba', '核查四室', '科员', 'MongoDB、zookeeper', '100001', '0', '2018-06-22 16:05:42'), ('100007', '吴九', 'wujiu', '核查一室', '科员', 'SpringBoot、zookeeper', '100001', '0', '2018-06-22 16:05:42'), ('1f01f44d-d559-4858-bb11-6b361d1fe1ca', '超人', 'chaoren', '三室', '总裁', 'zookeeper、d', 'chaoji', '0', '2018-06-22 21:12:31');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
