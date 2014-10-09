/*
Navicat MySQL Data Transfer

Source Server         : 192.168.10.121
Source Server Version : 50533
Source Host           : 192.168.10.121:3306
Source Database       : bcs

Target Server Type    : MYSQL
Target Server Version : 50533
File Encoding         : 65001

Date: 2014-09-15 15:27:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `bcs_account`
-- ----------------------------
DROP TABLE IF EXISTS `bcs_account`;
CREATE TABLE `bcs_account` (
  `account_id` int(10) NOT NULL AUTO_INCREMENT,
  `account_name` varchar(50) NOT NULL COMMENT '账户姓名',
  `account_balance` double(10,2) NOT NULL COMMENT '账户余额（可用余额）',
  `opt_site` int(4) DEFAULT NULL COMMENT '业务办理点 1-银海结算中心',
  `opt_user` varchar(50) DEFAULT NULL COMMENT '业务办理人',
  `status` int(2) NOT NULL COMMENT '账户状态 1-正常  2-锁定  3-注销',
  `add_time` datetime NOT NULL COMMENT '账户开通时间',
  `account_level` int(2) NOT NULL COMMENT '账户等级 1-普通账户；2-中级账户；3-高级账户；4-特殊账户',
  `card_type` int(2) DEFAULT NULL COMMENT '证件类型 1 - 身份证',
  `card_number` varchar(50) DEFAULT NULL COMMENT '证件号码',
  `father_account_id` int(10) NOT NULL COMMENT '父账户编号ID 默认为一级虚拟账户 其父账户编号为0',
  `account_pwd` varchar(50) NOT NULL COMMENT '账户密码',
  `lock_status` int(2) DEFAULT NULL COMMENT '锁定 1-未锁定 2- 已锁定 3 -已解锁',
  `locked_token` varchar(50) DEFAULT NULL COMMENT '账户锁定令牌  如已锁定状态  此字段不能为空值',
  `remark` varchar(254) DEFAULT NULL COMMENT '账户备注信息',
  PRIMARY KEY (`account_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1000000138 DEFAULT CHARSET=utf8 COMMENT='虚拟账户信息表';

-- ----------------------------
-- Records of bcs_account
-- ----------------------------
INSERT INTO `bcs_account` VALUES ('1', '白老板', '9968.59', '1', '超级用户', '1', '2014-05-04 09:19:22', '2', '1', '610111194401012026', '0', '96E79218965EB72C92A549DD5A330112', '1', '', '订单虚拟账户支付-交易');
INSERT INTO `bcs_account` VALUES ('3', '太阳岛', '6751.47', '1', '超级用户', '1', '2014-05-08 14:23:50', '1', '1', '610111194401012026', '0', '&MEIY123OUMIMAYYDJCBJ', '1', null, '订单交易20140617-测试');
INSERT INTO `bcs_account` VALUES ('4', '士兵突', '10.00', '1', '超级用户', '1', '2014-05-08 14:32:55', '1', '1', '610111194401012026', '0', '&MEIY123OUMIMAYYDJCBJ', '1', null, '暂无');
INSERT INTO `bcs_account` VALUES ('5', '张万达', '10.00', '1', '超级用户', '1', '2014-05-08 16:17:57', '1', '1', '610111194401012026', '0', '&MEIY123OUMIMAYYDJCBJ', '1', null, '暂无');
INSERT INTO `bcs_account` VALUES ('6', '长德集团', '10.00', '1', '超级用户', '1', '2014-05-09 10:18:16', '1', '1', '610111194401012026', '0', '&MEIY123OUMIMAYYDJCBJ', '1', null, '暂无');
INSERT INTO `bcs_account` VALUES ('7', '长德集团-泥水集团', '10.00', '1', '超级用户', '1', '2014-05-09 10:18:29', '1', '1', '610111194401012026', '6', '&MEIY123OUMIMAYYDJCBJ', '1', null, '暂无');
INSERT INTO `bcs_account` VALUES ('8', '长德集团-万达集团', '10.00', '1', '超级用户', '1', '2014-05-09 10:18:57', '1', '1', '610111194401012026', '6', '&MEIY123OUMIMAYYDJCBJ', '1', null, '暂无');
INSERT INTO `bcs_account` VALUES ('9', '长德集团-牛丸集团', '10.00', '1', '超级用户', '1', '2014-05-09 10:19:07', '1', '1', '610111194401012026', '6', '&MEIY123OUMIMAYYDJCBJ', '1', null, '暂无');
INSERT INTO `bcs_account` VALUES ('10', '长德集团总部', '100746.20', '1', '超级用户', '1', '2014-05-09 14:23:44', '2', '1', '610111194401012026', '0', '&MEIY123OUMIMAYYDJCBJ', '1', null, '订单虚拟账户支付-交易');
INSERT INTO `bcs_account` VALUES ('13', '周小泉', '10.00', '1', '陈万达', '3', '2014-05-12 15:52:09', '1', '1', '610111194401012026', '0', '&MEIY123OUMIMAYYDJCBJ', '1', null, '暂无');
INSERT INTO `bcs_account` VALUES ('14', '杜志良', '10.00', '1', '超级用户', '1', '2014-05-13 15:59:52', '1', '1', '511325199005275413', '0', '96E79218965EB72C92A549DD5A330112', '1', null, '暂无');
INSERT INTO `bcs_account` VALUES ('15', '张三林', '10.00', '1', '超级用户', '1', '2014-05-13 16:14:13', '1', '1', '511325199005275413', '0', '96E79218965EB72C92A549DD5A330112', '1', null, '暂无');
INSERT INTO `bcs_account` VALUES ('16', '李四', '10.00', '1', '超级用户', '1', '2014-05-13 16:15:29', '1', '1', '511325199005275413', '0', 'E3CEB5881A0A1FDAAD01296D7554868D', '1', null, '暂无');
INSERT INTO `bcs_account` VALUES ('17', '王五成', '10.00', '1', '超级用户', '3', '2014-05-13 16:17:16', '1', '1', '511325199005275413', '0', 'E10ADC3949BA59ABBE56E057F20F883E', '1', null, '暂无');
INSERT INTO `bcs_account` VALUES ('18', '周小泉', '10.00', '1', '陈万达', '1', '2014-05-14 14:36:20', '1', '1', '610111194401012026', '0', '&MEIY123OUMIMAYYDJCBJ', '1', null, '暂无');
INSERT INTO `bcs_account` VALUES ('19', '周小泉1', '10.00', '1', '超级用户', '1', '2014-05-14 15:53:25', '1', '1', '511325199005275413', '18', '96E79218965EB72C92A549DD5A330112', '1', null, '访问');
INSERT INTO `bcs_account` VALUES ('20', 'SheepSimpson', '10.00', null, null, '1', '2014-05-19 17:01:58', '1', '1', null, '0', '96E79218965EB72C92A549DD5A330112', '1', null, null);
INSERT INTO `bcs_account` VALUES ('21', 'SheepSimpson', '0.00', null, null, '1', '2014-05-19 17:03:52', '1', null, null, '0', '96E79218965EB72C92A549DD5A330112', '1', null, null);
INSERT INTO `bcs_account` VALUES ('22', 'SheepSimpson', '0.00', null, null, '1', '2014-05-19 17:11:10', '1', null, null, '0', '96E79218965EB72C92A549DD5A330112', '1', null, null);
INSERT INTO `bcs_account` VALUES ('23', 'SheepSimpson', '10.00', null, null, '1', '2014-05-19 17:11:44', '1', null, null, '0', '96E79218965EB72C92A549DD5A330112', '1', null, null);
INSERT INTO `bcs_account` VALUES ('24', '周小泉', '10.00', null, null, '1', '2014-05-19 17:13:00', '1', null, null, '0', '&MEIY123OUMIMAYYDJCBJ', '1', null, null);
INSERT INTO `bcs_account` VALUES ('25', 'SheepSimpson', '10.00', null, null, '1', '2014-05-19 17:14:23', '1', null, null, '0', '96E79218965EB72C92A549DD5A330112', '1', null, null);
INSERT INTO `bcs_account` VALUES ('26', 'SheepSimpson', '10.00', null, null, '1', '2014-05-19 17:15:25', '1', null, null, '0', '96E79218965EB72C92A549DD5A330112', '1', null, null);
INSERT INTO `bcs_account` VALUES ('27', 'SheepSimpson', '10.00', null, null, '1', '2014-05-19 17:16:18', '1', null, null, '0', '96E79218965EB72C92A549DD5A330112', '1', null, null);
INSERT INTO `bcs_account` VALUES ('28', 'SheepSimpson', '10.00', null, null, '1', '2014-05-19 17:16:39', '1', null, null, '0', '96E79218965EB72C92A549DD5A330112', '1', null, null);
INSERT INTO `bcs_account` VALUES ('29', 'SheepSimpson', '10.00', null, null, '1', '2014-05-19 17:17:12', '1', null, null, '0', '96E79218965EB72C92A549DD5A330112', '1', null, null);
INSERT INTO `bcs_account` VALUES ('30', 'SheepSimpson', '0.00', null, null, '3', '2014-05-19 17:25:24', '1', null, null, '0', '96E79218965EB72C92A549DD5A330112', '1', null, null);
INSERT INTO `bcs_account` VALUES ('31', 'SheepSimpson', '0.00', null, null, '1', '2014-05-19 17:27:20', '1', null, null, '0', '96E79218965EB72C92A549DD5A330112', '1', null, null);
INSERT INTO `bcs_account` VALUES ('32', 'duzl', '0.00', null, null, '1', '2014-05-20 16:54:49', '1', null, null, '0', '96E79218965EB72C92A549DD5A330112', '1', null, null);
INSERT INTO `bcs_account` VALUES ('33', 'kla770', '237534.76', null, null, '1', '2014-05-20 17:21:34', '1', null, null, '0', '96E79218965EB72C92A549DD5A330112', '1', null, '订单虚拟账户支付-交易');
INSERT INTO `bcs_account` VALUES ('34', 'ddd', '0.00', null, null, '1', '2014-05-21 16:04:08', '1', null, null, '0', '96E79218965EB72C92A549DD5A330112', '1', null, null);
INSERT INTO `bcs_account` VALUES ('35', 'ddd', '0.00', null, null, '1', '2014-05-21 16:07:38', '1', null, null, '0', '96E79218965EB72C92A549DD5A330112', '1', null, null);
INSERT INTO `bcs_account` VALUES ('36', 'ddd', '0.00', null, null, '1', '2014-05-21 16:09:11', '1', null, null, '0', '96E79218965EB72C92A549DD5A330112', '1', null, null);
INSERT INTO `bcs_account` VALUES ('37', 'ddd', '0.00', null, null, '1', '2014-05-21 16:09:25', '1', null, null, '0', '96E79218965EB72C92A549DD5A330112', '1', null, null);
INSERT INTO `bcs_account` VALUES ('38', '土肥原', '10.00', '1', '成龙', '1', '2014-05-21 17:24:18', '1', '1', '511325199005275413', '0', '96E79218965EB72C92A549DD5A330112', '1', null, '暂无');
INSERT INTO `bcs_account` VALUES ('39', 'ddd', '0.00', null, null, '1', '2014-05-22 09:55:36', '1', null, null, '0', '96E79218965EB72C92A549DD5A330112', '1', null, null);
INSERT INTO `bcs_account` VALUES ('40', 'ddd', '0.00', null, null, '1', '2014-05-22 09:57:03', '1', null, null, '0', '96E79218965EB72C92A549DD5A330112', '1', null, null);
INSERT INTO `bcs_account` VALUES ('41', 'ddd', '0.00', null, null, '1', '2014-05-22 09:58:24', '1', null, null, '0', '96E79218965EB72C92A549DD5A330112', '1', null, null);
INSERT INTO `bcs_account` VALUES ('42', 'ddd', '0.00', null, null, '1', '2014-05-22 10:06:37', '1', null, null, '0', '96E79218965EB72C92A549DD5A330112', '1', null, null);
INSERT INTO `bcs_account` VALUES ('43', 'ddd', '0.00', null, null, '1', '2014-05-22 10:55:29', '1', null, null, '0', '96E79218965EB72C92A549DD5A330112', '1', null, null);
INSERT INTO `bcs_account` VALUES ('44', 'ddd', '100.00', null, null, '1', '2014-05-22 11:16:13', '1', null, null, '0', '96E79218965EB72C92A549DD5A330112', '1', null, '账户资金增加');
INSERT INTO `bcs_account` VALUES ('45', 'ddd', '1791.96', null, null, '1', '2014-05-22 13:20:09', '1', null, null, '0', '96E79218965EB72C92A549DD5A330112', '1', null, '订单虚拟账户支付-交易');
INSERT INTO `bcs_account` VALUES ('46', 'yh', '1237466.00', null, null, '1', '2014-05-22 15:51:58', '1', null, null, '0', '1A100D2C0DAB19C4430E7D73762B3423', '2', 'U7s8cHHwei9923UUwcnnweuUUwciUUU', '订单虚拟账户支付-交易');
INSERT INTO `bcs_account` VALUES ('47', '白雪松', '400.00', '1', '白雪松', '3', '2014-05-22 16:17:50', '1', '1', '610111194401012026', '0', 'BUYAOMODIFYTHISACCOUNT', '1', null, '账户资金增加');
INSERT INTO `bcs_account` VALUES ('48', '长德', '10.00', '1', '超级用户', '1', '2014-05-23 15:19:05', '1', '1', '', '0', 'E10ADC3949BA59ABBE56E057F20F883E', '1', null, '');
INSERT INTO `bcs_account` VALUES ('49', 'dddd', '0.00', null, null, '1', '2014-05-23 15:46:16', '1', null, null, '0', '96E79218965EB72C92A549DD5A330112', '1', null, null);
INSERT INTO `bcs_account` VALUES ('50', 'baixuesong', '99999999.99', null, null, '1', '2014-05-23 17:29:10', '1', null, null, '0', 'E10ADC3949BA59ABBE56E057F20F883E', '1', null, '账户资金增加');
INSERT INTO `bcs_account` VALUES ('51', '11', '99999999.99', null, null, '1', '2014-05-28 11:00:14', '1', '1', null, '0', '96E79218965EB72C92A549DD5A330112', '1', null, '订单支付-交易');
INSERT INTO `bcs_account` VALUES ('52', 'zzz', '200.00', null, null, '1', '2014-05-29 11:43:34', '1', '1', null, '0', '96E79218965EB72C92A549DD5A330112', '1', null, 'FSGz账务服务网关充值');
INSERT INTO `bcs_account` VALUES ('53', 'zhaozq', '0.00', null, null, '1', '2014-05-29 14:41:25', '1', '1', null, '0', 'E10ADC3949BA59ABBE56E057F20F883E', '1', null, null);
INSERT INTO `bcs_account` VALUES ('54', 'qq449220264', '272.41', null, null, '1', '2014-05-29 17:27:41', '1', '1', '123321990909011', '0', 'E3CEB5881A0A1FDAAD01296D7554868D', '1', null, '订单支付-交易');
INSERT INTO `bcs_account` VALUES ('55', 'ta', '0.00', null, null, '1', '2014-05-30 10:27:34', '1', '1', null, '0', 'AF15D5FDACD5FDFEA300E88A8E253E82', '1', null, null);
INSERT INTO `bcs_account` VALUES ('56', 'wuyang', '0.00', null, null, '1', '2014-06-03 11:38:20', '1', '1', null, '0', '96E79218965EB72C92A549DD5A330112', '1', null, null);
INSERT INTO `bcs_account` VALUES ('57', 'zsk2014', '0.00', null, null, '1', '2014-06-04 08:58:50', '1', '1', null, '0', 'E3CEB5881A0A1FDAAD01296D7554868D', '1', null, null);
INSERT INTO `bcs_account` VALUES ('58', 'panghuazhi', '0.00', null, null, '3', '2014-06-04 09:57:41', '1', '1', null, '0', 'E10ADC3949BA59ABBE56E057F20F883E', '1', null, null);
INSERT INTO `bcs_account` VALUES ('59', 'yang', '10.00', '1', '超级用户', '3', '2014-06-09 17:25:34', '1', '1', '510105198710233030', '0', '202CB962AC59075B964B07152D234B70', '1', null, '');
INSERT INTO `bcs_account` VALUES ('60', 'yang', '10.00', '1', '超级用户', '3', '2014-06-10 11:04:35', '1', '1', '', '57', '202CB962AC59075B964B07152D234B70', '1', null, '');
INSERT INTO `bcs_account` VALUES ('61', 'ceshi1', '0.00', null, null, '1', '2014-06-10 16:53:40', '1', '1', null, '0', '1A100D2C0DAB19C4430E7D73762B3423', '1', null, null);
INSERT INTO `bcs_account` VALUES ('62', 'yh1', '10.00', '1', '超级用户', '3', '2014-06-11 16:45:27', '1', '1', '', '46', '96E79218965EB72C92A549DD5A330112', '1', null, '');
INSERT INTO `bcs_account` VALUES ('63', 'yh2', '10.00', '1', '超级用户', '1', '2014-06-11 16:47:10', '1', '1', '', '46', '96E79218965EB72C92A549DD5A330112', '1', null, '');
INSERT INTO `bcs_account` VALUES ('64', '112233', '10.00', '1', '', '3', '2014-06-12 00:56:19', '1', '1', '', '0', '93279E3308BDBBEED946FC965017F67A', '1', null, '');
INSERT INTO `bcs_account` VALUES ('65', '111111', '10.00', '1', '超级用户', '1', '2014-06-12 01:01:09', '1', '1', '', '64', '96E79218965EB72C92A549DD5A330112', '1', null, '');
INSERT INTO `bcs_account` VALUES ('66', 'ggg', '10.00', '1', '超级用户', '3', '2014-06-12 14:44:30', '1', '1', '', '0', '202CB962AC59075B964B07152D234B70', '1', null, '');
INSERT INTO `bcs_account` VALUES ('67', '1', '10.00', '1', '超级用户', '1', '2014-06-12 14:51:20', '1', '1', '', '0', 'C4CA4238A0B923820DCC509A6F75849B', '1', null, '');
INSERT INTO `bcs_account` VALUES ('68', '平台结算账户（勿删）', '324.06', '1', '白雪松', '1', '2014-06-16 10:55:47', '1', '1', '511325199005275413', '0', 'E10ADC3949BA59ABBE56E057F20F883E', '1', null, '订单支付-交易');
INSERT INTO `bcs_account` VALUES ('69', '手续费代收账户（勿删）', '11.81', '1', '白雪松', '1', '2014-06-16 10:56:21', '1', '1', '511325199005275413', '0', 'E10ADC3949BA59ABBE56E057F20F883E', '1', null, '订单虚拟账户支付-交易');
INSERT INTO `bcs_account` VALUES ('70', 'tengjiao', '0.00', null, null, '1', '2014-06-16 11:21:22', '1', '1', null, '0', '91C84776F60EFF4315AC238600E007E8', '1', null, null);
INSERT INTO `bcs_account` VALUES ('71', 'bxs1', '129767.00', null, null, '1', '2014-06-17 15:59:32', '1', '1', '511325199005275413', '0', 'E10ADC3949BA59ABBE56E057F20F883E', '1', null, '订单支付-交易');
INSERT INTO `bcs_account` VALUES ('72', '13548100319', '0.00', null, null, '1', '2014-06-17 16:04:06', '1', '1', null, '0', '96E79218965EB72C92A549DD5A330112', '1', null, null);
INSERT INTO `bcs_account` VALUES ('73', 'ddd1', '20.00', null, null, '1', '2014-06-18 08:36:09', '1', '1', null, '0', 'E10ADC3949BA59ABBE56E057F20F883E', '1', null, '订单虚拟账户支付-交易');
INSERT INTO `bcs_account` VALUES ('75', '999999', '0.00', null, null, '1', '2014-06-18 13:30:42', '1', '1', null, '0', '96E79218965EB72C92A549DD5A330112', '1', null, null);
INSERT INTO `bcs_account` VALUES ('76', 'testuser', '100.00', null, null, '3', '2014-06-19 12:53:07', '1', '1', null, '0', '96E79218965EB72C92A549DD5A330112', '1', null, '订单支付-交易');
INSERT INTO `bcs_account` VALUES ('77', 'ddd4', '80.00', null, null, '1', '2014-06-19 13:18:49', '1', '1', null, '0', 'E10ADC3949BA59ABBE56E057F20F883E', '1', null, '订单虚拟账户支付-交易');
INSERT INTO `bcs_account` VALUES ('78', 'ddd5', '0.00', null, null, '1', '2014-06-19 13:44:01', '1', '1', null, '0', '96E79218965EB72C92A549DD5A330112', '1', null, null);
INSERT INTO `bcs_account` VALUES ('79', 'ddd7', '0.00', null, null, '1', '2014-06-19 13:57:57', '1', '1', null, '0', '96E79218965EB72C92A549DD5A330112', '2', null, null);
INSERT INTO `bcs_account` VALUES ('80', 'test01', '0.00', null, null, '1', '2014-06-19 14:15:50', '1', '1', null, '0', 'E10ADC3949BA59ABBE56E057F20F883E', '1', null, null);
INSERT INTO `bcs_account` VALUES ('81', 'test02', '70.00', null, null, '1', '2014-06-19 14:18:14', '1', '1', null, '0', 'E10ADC3949BA59ABBE56E057F20F883E', '1', null, '针对ID[614]支付记录做交易撤销处理00000000000000000419');
INSERT INTO `bcs_account` VALUES ('82', 'ddd8', '0.00', null, null, '1', '2014-06-19 14:46:03', '1', '1', null, '0', '96E79218965EB72C92A549DD5A330112', '1', null, null);
INSERT INTO `bcs_account` VALUES ('83', 'ddd9', '0.00', null, null, '1', '2014-06-19 14:50:33', '1', '1', null, '0', '96E79218965EB72C92A549DD5A330112', '1', null, null);
INSERT INTO `bcs_account` VALUES ('84', 'ddd9', '0.00', null, null, '1', '2014-06-19 14:51:22', '1', '1', null, '0', '96E79218965EB72C92A549DD5A330112', '1', null, null);
INSERT INTO `bcs_account` VALUES ('85', 'ddd10', '0.00', null, null, '1', '2014-06-19 14:56:30', '1', '1', null, '0', '96E79218965EB72C92A549DD5A330112', '1', null, null);
INSERT INTO `bcs_account` VALUES ('86', 'yu', '0.00', null, null, '1', '2014-06-20 14:40:05', '1', '1', null, '0', '96E79218965EB72C92A549DD5A330112', '1', null, null);
INSERT INTO `bcs_account` VALUES ('87', '白雪松测试01', '10.00', '1', '白雪松', '3', '2014-06-20 16:23:41', '1', '1', '610111194401012026', '0', 'E10ADC3949BA59ABBE56E057F20F883E', '1', null, '白雪松测试01');
INSERT INTO `bcs_account` VALUES ('88', 'baixstest', '0.00', null, null, '1', '2014-06-20 16:50:20', '1', '1', null, '0', 'E10ADC3949BA59ABBE56E057F20F883E', '1', null, null);
INSERT INTO `bcs_account` VALUES ('89', '11', '99999999.99', null, null, '1', '2014-06-24 09:30:16', '1', '1', null, '0', '96E79218965EB72C92A549DD5A330112', '1', null, null);
INSERT INTO `bcs_account` VALUES ('90', 'ddd9', '555515.00', null, null, '1', '2014-06-26 09:26:07', '1', '1', null, '0', '96E79218965EB72C92A549DD5A330112', '1', null, '订单虚拟账户支付-交易');
INSERT INTO `bcs_account` VALUES ('91', '测试账户duzl', '10.00', '1', '超级用户', '1', '2014-06-27 09:07:36', '1', '1', '511325199005275413', '90', '96E79218965EB72C92A549DD5A330112', '1', null, '');
INSERT INTO `bcs_account` VALUES ('92', 'testbaixs', '70.00', null, null, '1', '2014-07-01 11:03:32', '1', '1', null, '0', 'E10ADC3949BA59ABBE56E057F20F883E', '1', null, '订单虚拟账户支付-交易');
INSERT INTO `bcs_account` VALUES ('93', 'yh', '10.00', '1', '超级用户', '1', '2014-07-02 14:27:39', '1', '1', '', '0', '96E79218965EB72C92A549DD5A330112', '1', null, '');
INSERT INTO `bcs_account` VALUES ('94', 'yh1', '10.00', '1', '', '1', '2014-07-02 15:54:09', '1', '1', '', '0', '96E79218965EB72C92A549DD5A330112', '1', null, '');
INSERT INTO `bcs_account` VALUES ('95', 'sdsd', '10.00', '1', '白雪松', '1', '2014-07-02 15:56:47', '1', '1', '', '93', 'E10ADC3949BA59ABBE56E057F20F883E', '1', null, '');
INSERT INTO `bcs_account` VALUES ('96', 'yh1', '10.00', '1', '超级用户', '1', '2014-07-02 16:00:09', '1', '1', '', '93', '96E79218965EB72C92A549DD5A330112', '1', null, '');
INSERT INTO `bcs_account` VALUES ('97', '1', '10.00', '1', '超级用户', '1', '2014-07-02 16:07:40', '1', '1', '', '96', '96E79218965EB72C92A549DD5A330112', '1', null, '');
INSERT INTO `bcs_account` VALUES ('98', 'yh', '10.00', '1', '超级用户', '3', '2014-07-03 14:37:37', '1', '1', '', '0', '96E79218965EB72C92A549DD5A330112', '1', null, '');
INSERT INTO `bcs_account` VALUES ('99', '99', '10.00', '1', '超级用户', '1', '2014-07-03 15:26:44', '1', '1', '122222990909009', '0', 'CFCD208495D565EF66E7DFF9F98764DA', '1', null, '');
INSERT INTO `bcs_account` VALUES ('100', '999', '10.00', '1', '超级用户', '1', '2014-07-03 15:33:42', '1', '1', '', '99', 'CFCD208495D565EF66E7DFF9F98764DA', '1', null, '备注试试看');
INSERT INTO `bcs_account` VALUES ('101', '测试删除', '10.00', '1', '白雪松', '3', '2014-07-07 10:46:41', '1', '1', '', '0', '6512BD43D9CAA6E02C990B0A82652DCA', '1', null, '');
INSERT INTO `bcs_account` VALUES ('102', 'bxsTest', '10.00', '1', '', '3', '2014-07-09 17:51:21', '1', '1', '', '0', 'C4CA4238A0B923820DCC509A6F75849B', '1', null, '');
INSERT INTO `bcs_account` VALUES ('1000000100', '中间帐号（不可用）', '0.00', '1', '白雪松', '0', '2014-07-11 14:37:51', '1', '1', '511325199005275413', '0', 'CFCD208495D565EF66E7DFF9F98764DA', '1', null, '已删除');
INSERT INTO `bcs_account` VALUES ('1000000101', '测试会员账户10001', '10.00', '1', '白雪松', '1', '2014-07-15 11:07:02', '2', '1', '610111194401012026', '0', 'C4CA4238A0B923820DCC509A6F75849B', '1', null, '测试');
INSERT INTO `bcs_account` VALUES ('1000000102', '23', '10.00', '1', '白雪松', '3', '2014-07-15 12:48:42', '1', '1', '', '0', '37693CFC748049E45D87B8C7D8B9AACD', '1', null, '');
INSERT INTO `bcs_account` VALUES ('1000000103', '一阳真人', '10.00', '1', '白雪松', '1', '2014-07-15 12:49:18', '1', '1', '610111194401012026', '0', 'C4CA4238A0B923820DCC509A6F75849B', '1', null, '测试账户');
INSERT INTO `bcs_account` VALUES ('1000000104', '张会计', '10.00', '1', '白雪松', '1', '2014-07-15 13:39:27', '2', '1', '610111194401012026', '0', 'C4CA4238A0B923820DCC509A6F75849B', '1', null, '测试账户');
INSERT INTO `bcs_account` VALUES ('1000000105', 'bxslove@126.com', '10.00', '1', '白雪松', '1', '2014-07-15 13:39:55', '1', '1', '610111194401012026', '0', 'C4CA4238A0B923820DCC509A6F75849B', '1', null, '测试账户');
INSERT INTO `bcs_account` VALUES ('1000000106', '李阳', '10.00', '1', '白雪松', '1', '2014-07-15 13:41:10', '1', '1', '610111194401012026', '0', 'C4CA4238A0B923820DCC509A6F75849B', '1', null, '测试账户');
INSERT INTO `bcs_account` VALUES ('1000000107', '成渝湘', '10.00', '1', '白雪松', '1', '2014-07-15 13:41:30', '1', '1', '610111194401012026', '0', 'C4CA4238A0B923820DCC509A6F75849B', '1', null, '测试账户');
INSERT INTO `bcs_account` VALUES ('1000000108', '刘焕武', '10.00', '1', '白雪松', '1', '2014-07-15 13:41:48', '1', '1', '610111194401012026', '0', 'C4CA4238A0B923820DCC509A6F75849B', '1', null, '测试账户');
INSERT INTO `bcs_account` VALUES ('1000000109', 'yhtest', '10.00', '1', '白雪松', '1', '2014-07-15 13:44:37', '1', '1', '610111194401012026', '0', 'C4CA4238A0B923820DCC509A6F75849B', '1', null, '测试账户');
INSERT INTO `bcs_account` VALUES ('1000000110', '商超联盟平台', '10.00', '1', '白雪松', '1', '2014-07-15 16:58:30', '2', '1', '610111194401012026', '0', 'C4CA4238A0B923820DCC509A6F75849B', '1', null, '测试商户');
INSERT INTO `bcs_account` VALUES ('1000000111', '张家小卖部', '10.00', '1', '白雪松', '1', '2014-07-15 17:51:25', '2', '1', '610111194401012026', '1000000110', 'C4CA4238A0B923820DCC509A6F75849B', '1', null, '测试账户');
INSERT INTO `bcs_account` VALUES ('1000000112', 'lkxxx', '10.00', '1', '超级用户', '1', '2014-07-17 16:17:43', '1', '1', '', '0', '96E79218965EB72C92A549DD5A330112', '1', null, '');
INSERT INTO `bcs_account` VALUES ('1000000113', 'lkxxx', '10.00', '1', '超级用户', '1', '2014-07-17 16:17:47', '1', '1', '', '0', '96E79218965EB72C92A549DD5A330112', '1', null, '');
INSERT INTO `bcs_account` VALUES ('1000000114', 'payUser', '88.00', null, null, '1', '2014-07-21 14:09:25', '1', '1', null, '0', 'E10ADC3949BA59ABBE56E057F20F883E', '1', null, '订单支付-交易');
INSERT INTO `bcs_account` VALUES ('1000000115', 'lklkzero1', '0.00', null, null, '1', '2014-07-22 09:37:34', '1', '1', null, '0', 'E10ADC3949BA59ABBE56E057F20F883E', '1', null, '订单支付-交易');
INSERT INTO `bcs_account` VALUES ('1000000116', 'yangtest', '10.00', '1', '阳曦', '1', '2014-07-23 09:42:13', '1', '1', '', '0', '96E79218965EB72C92A549DD5A330112', '1', null, '');
INSERT INTO `bcs_account` VALUES ('1000000117', 'qqq', '160.00', null, null, '3', '2014-07-30 08:58:58', '1', '1', null, '0', '96E79218965EB72C92A549DD5A330112', '1', null, '账户资金充值');
INSERT INTO `bcs_account` VALUES ('1000000118', 'test44', '10.00', '1', '李天怡', '1', '2014-08-12 14:01:45', '1', '1', '', '0', '202CB962AC59075B964B07152D234B70', '1', null, '');
INSERT INTO `bcs_account` VALUES ('1000000119', 'yangxi', '10.00', '1', '阳曦', '1', '2014-08-13 13:53:22', '1', '1', '510105198810293030', '0', '202CB962AC59075B964B07152D234B70', '1', null, '');
INSERT INTO `bcs_account` VALUES ('1000000120', 'v大', '10.00', '1', '李天怡', '3', '2014-08-14 12:49:29', '1', '1', '', '0', 'B59C67BF196A4758191E42F76670CEBA', '1', null, '');
INSERT INTO `bcs_account` VALUES ('1000000121', '12111', '10.00', '1', '李天怡', '1', '2014-08-14 15:11:43', '2', '1', '', '1000000111', 'A8C4B738E1F56F7082C37ABFAB2F3A7C', '1', null, '');
INSERT INTO `bcs_account` VALUES ('1000000122', 'ewqeqweqe', '10.00', '1', '李成功', '1', '2014-08-18 14:47:04', '1', '1', '', '1000000121', '0B49939D6415354C950B142A0B1E696A', '1', null, '');
INSERT INTO `bcs_account` VALUES ('1000000123', 'no9子账户', '10.00', '1', 'developer', '1', '2014-08-19 09:34:53', '1', '1', '', '9', '96E79218965EB72C92A549DD5A330112', '1', null, '');
INSERT INTO `bcs_account` VALUES ('1000000124', 'bbxxss', '0.00', '1', '李天怡', '1', '2014-08-19 09:41:35', '1', '1', '510105198810293030', '0', 'C4CA4238A0B923820DCC509A6F75849B', '1', null, '测试会员账户');
INSERT INTO `bcs_account` VALUES ('1000000125', '测试账户', '10.00', '1', 'developer', '1', '2014-08-19 09:55:59', '1', '1', '', '0', '96E79218965EB72C92A549DD5A330112', '1', null, '');
INSERT INTO `bcs_account` VALUES ('1000000126', '1', '10.00', '1', 'developer', '1', '2014-08-19 09:57:50', '1', '1', '', '0', 'C4CA4238A0B923820DCC509A6F75849B', '1', null, '');
INSERT INTO `bcs_account` VALUES ('1000000127', 'zizhanghu', '0.00', '1', '李天怡', '1', '2014-08-19 13:50:23', '1', '1', '610111194401012026', '1000000121', 'C4CA4238A0B923820DCC509A6F75849B', '1', null, 'ceshi');
INSERT INTO `bcs_account` VALUES ('1000000128', '测试会员升级账户', '0.00', '1', '李天怡', '1', '2014-08-21 10:19:37', '2', '1', '610111194401012026', '0', 'C4CA4238A0B923820DCC509A6F75849B', '1', null, '测试账户');
INSERT INTO `bcs_account` VALUES ('1000000129', 'yangxi', '0.00', null, null, '1', '2014-08-22 10:14:52', '1', '1', null, '0', '96E79218965EB72C92A549DD5A330112', '1', null, null);
INSERT INTO `bcs_account` VALUES ('1000000130', 'yangxi', '0.00', null, null, '1', '2014-08-25 16:20:35', '1', '1', null, '0', '96E79218965EB72C92A549DD5A330112', '1', null, null);
INSERT INTO `bcs_account` VALUES ('1000000131', 'yangxi', '0.00', null, null, '1', '2014-08-25 16:20:36', '1', '1', null, '0', '96E79218965EB72C92A549DD5A330112', '1', null, null);
INSERT INTO `bcs_account` VALUES ('1000000132', 'yangxi', '0.00', null, null, '1', '2014-08-25 16:21:58', '1', '1', null, '0', '96E79218965EB72C92A549DD5A330112', '1', null, null);
INSERT INTO `bcs_account` VALUES ('1000000133', 'yangxi', '0.00', null, null, '1', '2014-08-25 16:22:55', '1', '1', null, '0', '96E79218965EB72C92A549DD5A330112', '1', null, null);
INSERT INTO `bcs_account` VALUES ('1000000134', 'yangxi', '0.00', null, null, '1', '2014-08-25 16:23:18', '1', '1', null, '0', '96E79218965EB72C92A549DD5A330112', '1', null, null);
INSERT INTO `bcs_account` VALUES ('1000000135', 'yangxi', '0.00', null, null, '1', '2014-08-25 16:25:13', '1', '1', null, '0', 'E10ADC3949BA59ABBE56E057F20F883E', '1', null, null);
INSERT INTO `bcs_account` VALUES ('1000000136', 'yang2', '0.00', null, null, '1', '2014-08-27 10:15:54', '1', '1', null, '0', '96E79218965EB72C92A549DD5A330112', '1', null, null);
INSERT INTO `bcs_account` VALUES ('1000000137', 'seller', '0.00', null, null, '1', '2014-09-03 15:54:32', '1', '1', null, '0', 'E10ADC3949BA59ABBE56E057F20F883E', '1', null, null);

-- ----------------------------
-- Table structure for `bcs_account_business`
-- ----------------------------
DROP TABLE IF EXISTS `bcs_account_business`;
CREATE TABLE `bcs_account_business` (
  `AB_ID` int(10) NOT NULL AUTO_INCREMENT COMMENT '账户业务关系表ID',
  `ACCOUNT_ID` int(10) NOT NULL COMMENT '账户编号ID',
  `BUSINESS_ID` int(10) NOT NULL COMMENT '业务编号ID',
  `STATUS` int(4) NOT NULL COMMENT '有效状态 0 - 无效  1 - 有效',
  PRIMARY KEY (`AB_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=519 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bcs_account_business
-- ----------------------------
INSERT INTO `bcs_account_business` VALUES ('165', '1', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('166', '2', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('167', '3', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('168', '4', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('169', '5', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('170', '6', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('171', '7', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('172', '8', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('173', '9', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('174', '10', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('175', '11', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('176', '12', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('177', '13', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('178', '14', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('179', '15', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('180', '16', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('181', '17', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('182', '18', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('183', '19', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('184', '20', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('185', '21', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('186', '22', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('187', '23', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('188', '24', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('189', '25', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('190', '26', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('191', '27', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('192', '28', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('193', '29', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('194', '30', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('195', '31', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('196', '32', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('197', '33', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('198', '34', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('199', '35', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('200', '36', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('201', '37', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('202', '38', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('203', '39', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('204', '40', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('205', '41', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('206', '42', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('207', '43', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('208', '44', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('209', '45', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('210', '46', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('211', '47', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('212', '48', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('213', '49', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('214', '50', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('215', '51', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('216', '52', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('217', '53', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('218', '54', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('219', '55', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('220', '56', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('221', '57', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('222', '58', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('223', '59', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('224', '60', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('225', '61', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('226', '62', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('227', '63', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('228', '64', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('229', '65', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('230', '66', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('231', '67', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('232', '68', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('233', '69', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('234', '70', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('235', '71', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('236', '72', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('237', '73', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('238', '74', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('239', '75', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('240', '1', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('241', '2', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('242', '3', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('243', '4', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('244', '5', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('245', '6', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('246', '7', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('247', '8', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('248', '9', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('249', '10', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('250', '11', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('251', '12', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('252', '13', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('253', '14', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('254', '15', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('255', '16', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('256', '17', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('257', '18', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('258', '19', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('259', '20', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('260', '21', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('261', '22', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('262', '23', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('263', '24', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('264', '25', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('265', '26', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('266', '27', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('267', '28', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('268', '29', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('269', '30', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('270', '31', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('271', '32', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('272', '33', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('273', '34', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('274', '35', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('275', '36', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('276', '37', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('277', '38', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('278', '39', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('279', '40', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('280', '41', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('281', '42', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('282', '43', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('283', '44', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('284', '45', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('285', '46', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('286', '47', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('287', '48', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('288', '49', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('289', '50', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('290', '51', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('291', '52', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('292', '53', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('293', '54', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('294', '55', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('295', '56', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('296', '57', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('297', '58', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('298', '59', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('299', '60', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('300', '61', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('301', '62', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('302', '63', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('303', '64', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('304', '65', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('305', '66', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('306', '67', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('307', '68', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('308', '69', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('309', '70', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('310', '71', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('311', '72', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('312', '73', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('313', '74', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('314', '75', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('315', '1', '5', '1');
INSERT INTO `bcs_account_business` VALUES ('316', '2', '5', '1');
INSERT INTO `bcs_account_business` VALUES ('317', '3', '5', '1');
INSERT INTO `bcs_account_business` VALUES ('318', '4', '5', '1');
INSERT INTO `bcs_account_business` VALUES ('319', '5', '5', '1');
INSERT INTO `bcs_account_business` VALUES ('320', '6', '5', '1');
INSERT INTO `bcs_account_business` VALUES ('321', '7', '5', '1');
INSERT INTO `bcs_account_business` VALUES ('322', '8', '5', '1');
INSERT INTO `bcs_account_business` VALUES ('323', '9', '5', '1');
INSERT INTO `bcs_account_business` VALUES ('324', '10', '5', '1');
INSERT INTO `bcs_account_business` VALUES ('325', '11', '5', '1');
INSERT INTO `bcs_account_business` VALUES ('326', '12', '5', '1');
INSERT INTO `bcs_account_business` VALUES ('327', '13', '5', '1');
INSERT INTO `bcs_account_business` VALUES ('328', '14', '5', '1');
INSERT INTO `bcs_account_business` VALUES ('329', '15', '5', '1');
INSERT INTO `bcs_account_business` VALUES ('330', '16', '5', '1');
INSERT INTO `bcs_account_business` VALUES ('331', '17', '5', '1');
INSERT INTO `bcs_account_business` VALUES ('332', '18', '5', '1');
INSERT INTO `bcs_account_business` VALUES ('333', '19', '5', '1');
INSERT INTO `bcs_account_business` VALUES ('334', '20', '5', '1');
INSERT INTO `bcs_account_business` VALUES ('335', '21', '5', '1');
INSERT INTO `bcs_account_business` VALUES ('336', '22', '5', '1');
INSERT INTO `bcs_account_business` VALUES ('337', '23', '5', '1');
INSERT INTO `bcs_account_business` VALUES ('338', '24', '5', '1');
INSERT INTO `bcs_account_business` VALUES ('339', '25', '5', '1');
INSERT INTO `bcs_account_business` VALUES ('340', '26', '5', '1');
INSERT INTO `bcs_account_business` VALUES ('341', '27', '5', '1');
INSERT INTO `bcs_account_business` VALUES ('342', '28', '5', '1');
INSERT INTO `bcs_account_business` VALUES ('343', '29', '5', '1');
INSERT INTO `bcs_account_business` VALUES ('344', '30', '5', '1');
INSERT INTO `bcs_account_business` VALUES ('345', '31', '5', '1');
INSERT INTO `bcs_account_business` VALUES ('346', '32', '5', '1');
INSERT INTO `bcs_account_business` VALUES ('347', '33', '5', '1');
INSERT INTO `bcs_account_business` VALUES ('348', '34', '5', '1');
INSERT INTO `bcs_account_business` VALUES ('349', '35', '5', '1');
INSERT INTO `bcs_account_business` VALUES ('350', '36', '5', '1');
INSERT INTO `bcs_account_business` VALUES ('351', '37', '5', '1');
INSERT INTO `bcs_account_business` VALUES ('352', '38', '5', '1');
INSERT INTO `bcs_account_business` VALUES ('353', '39', '5', '1');
INSERT INTO `bcs_account_business` VALUES ('354', '40', '5', '1');
INSERT INTO `bcs_account_business` VALUES ('355', '41', '5', '1');
INSERT INTO `bcs_account_business` VALUES ('356', '42', '5', '1');
INSERT INTO `bcs_account_business` VALUES ('357', '43', '5', '1');
INSERT INTO `bcs_account_business` VALUES ('358', '44', '5', '1');
INSERT INTO `bcs_account_business` VALUES ('359', '45', '5', '1');
INSERT INTO `bcs_account_business` VALUES ('360', '46', '5', '1');
INSERT INTO `bcs_account_business` VALUES ('361', '47', '5', '1');
INSERT INTO `bcs_account_business` VALUES ('362', '48', '5', '1');
INSERT INTO `bcs_account_business` VALUES ('363', '49', '5', '1');
INSERT INTO `bcs_account_business` VALUES ('364', '50', '5', '1');
INSERT INTO `bcs_account_business` VALUES ('365', '51', '5', '1');
INSERT INTO `bcs_account_business` VALUES ('366', '52', '5', '1');
INSERT INTO `bcs_account_business` VALUES ('367', '53', '5', '1');
INSERT INTO `bcs_account_business` VALUES ('368', '54', '5', '1');
INSERT INTO `bcs_account_business` VALUES ('369', '55', '5', '1');
INSERT INTO `bcs_account_business` VALUES ('370', '56', '5', '1');
INSERT INTO `bcs_account_business` VALUES ('371', '57', '5', '1');
INSERT INTO `bcs_account_business` VALUES ('372', '58', '5', '1');
INSERT INTO `bcs_account_business` VALUES ('373', '59', '5', '1');
INSERT INTO `bcs_account_business` VALUES ('374', '60', '5', '1');
INSERT INTO `bcs_account_business` VALUES ('375', '61', '5', '1');
INSERT INTO `bcs_account_business` VALUES ('376', '62', '5', '1');
INSERT INTO `bcs_account_business` VALUES ('377', '63', '5', '1');
INSERT INTO `bcs_account_business` VALUES ('378', '64', '5', '1');
INSERT INTO `bcs_account_business` VALUES ('379', '65', '5', '1');
INSERT INTO `bcs_account_business` VALUES ('380', '66', '5', '1');
INSERT INTO `bcs_account_business` VALUES ('381', '67', '5', '1');
INSERT INTO `bcs_account_business` VALUES ('382', '68', '5', '1');
INSERT INTO `bcs_account_business` VALUES ('383', '69', '5', '1');
INSERT INTO `bcs_account_business` VALUES ('384', '70', '5', '1');
INSERT INTO `bcs_account_business` VALUES ('385', '71', '5', '1');
INSERT INTO `bcs_account_business` VALUES ('386', '72', '5', '1');
INSERT INTO `bcs_account_business` VALUES ('387', '73', '5', '1');
INSERT INTO `bcs_account_business` VALUES ('388', '74', '5', '1');
INSERT INTO `bcs_account_business` VALUES ('389', '75', '5', '1');
INSERT INTO `bcs_account_business` VALUES ('390', '76', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('391', '76', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('392', '77', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('393', '77', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('394', '78', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('395', '78', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('396', '79', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('397', '79', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('398', '80', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('399', '80', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('400', '81', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('401', '81', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('402', '82', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('403', '82', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('404', '83', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('405', '83', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('406', '84', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('407', '84', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('408', '85', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('409', '85', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('410', '81', '5', '1');
INSERT INTO `bcs_account_business` VALUES ('411', '86', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('412', '86', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('413', '87', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('414', '87', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('415', '88', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('416', '88', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('417', '89', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('418', '89', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('419', '90', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('420', '90', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('421', '91', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('422', '91', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('423', '92', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('424', '92', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('425', '93', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('426', '93', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('427', '94', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('428', '94', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('429', '95', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('430', '95', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('431', '96', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('432', '96', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('433', '97', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('434', '97', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('435', '98', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('436', '98', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('437', '99', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('438', '99', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('439', '100', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('440', '100', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('441', '101', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('442', '101', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('443', '102', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('444', '102', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('445', '1000000101', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('446', '1000000101', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('447', '1000000102', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('448', '1000000102', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('449', '1000000103', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('450', '1000000103', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('451', '1000000104', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('452', '1000000104', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('453', '1000000105', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('454', '1000000105', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('455', '1000000106', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('456', '1000000106', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('457', '1000000107', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('458', '1000000107', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('459', '1000000108', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('460', '1000000108', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('461', '1000000109', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('462', '1000000109', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('463', '1000000110', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('464', '1000000110', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('465', '1000000111', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('466', '1000000111', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('467', '1000000112', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('468', '1000000112', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('469', '1000000113', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('470', '1000000113', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('471', '1000000114', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('472', '1000000114', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('473', '1000000115', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('474', '1000000115', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('475', '1000000116', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('476', '1000000116', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('477', '1000000117', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('478', '1000000117', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('479', '1000000118', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('480', '1000000118', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('481', '1000000119', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('482', '1000000119', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('483', '1000000120', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('484', '1000000120', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('485', '1000000121', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('486', '1000000121', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('487', '1000000122', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('488', '1000000122', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('489', '1000000123', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('490', '1000000123', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('491', '1000000124', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('492', '1000000124', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('493', '1000000125', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('494', '1000000125', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('495', '1000000126', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('496', '1000000126', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('497', '1000000127', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('498', '1000000127', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('499', '1000000128', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('500', '1000000128', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('501', '1000000129', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('502', '1000000129', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('503', '1000000130', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('504', '1000000130', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('505', '1000000131', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('506', '1000000131', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('507', '1000000132', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('508', '1000000132', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('509', '1000000133', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('510', '1000000133', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('511', '1000000134', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('512', '1000000134', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('513', '1000000135', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('514', '1000000135', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('515', '1000000136', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('516', '1000000136', '3', '1');
INSERT INTO `bcs_account_business` VALUES ('517', '1000000137', '1', '1');
INSERT INTO `bcs_account_business` VALUES ('518', '1000000137', '3', '1');

-- ----------------------------
-- Table structure for `bcs_bank_card`
-- ----------------------------
DROP TABLE IF EXISTS `bcs_bank_card`;
CREATE TABLE `bcs_bank_card` (
  `bank_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '银行卡编号',
  `bank_card_no` varchar(50) NOT NULL COMMENT '银行卡卡号',
  `account_id` int(10) NOT NULL COMMENT '账户编号',
  `add_time` datetime NOT NULL COMMENT '银行卡添加时间',
  `belongs_bank` int(4) NOT NULL COMMENT '所属银行 1-中国建设银行；2-中国工商银行；3-中国银行 ; 4-民生银行',
  `telephone` varchar(30) DEFAULT NULL COMMENT '开通银行卡时预留电话（手机号码）',
  `is_quick_card` int(2) NOT NULL COMMENT '是否开通快捷支付 1 - 是 2 - 否',
  `bank_type` int(2) NOT NULL COMMENT '银行卡类型  1 -储蓄卡 2 - 信用卡',
  `status` int(2) NOT NULL COMMENT '银行卡状态 1-正常；2-暂停；3-注销',
  `remark` varchar(255) DEFAULT NULL COMMENT '银行卡备注',
  `issuing_bank` varchar(100) NOT NULL COMMENT '办理银行卡 银行卡所属地',
  `is_default` int(2) DEFAULT NULL COMMENT '是否作为缺省银行卡 1 - 是  2 - 否',
  PRIMARY KEY (`bank_id`),
  KEY `FK_Reference_3` (`account_id`),
  CONSTRAINT `FK_Reference_3` FOREIGN KEY (`account_id`) REFERENCES `bcs_account` (`account_id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COMMENT='银行卡信息表';

-- ----------------------------
-- Records of bcs_bank_card
-- ----------------------------
INSERT INTO `bcs_bank_card` VALUES ('2', '6222021001116245702', '6', '2014-05-09 15:05:47', '1', '15208214529', '2', '1', '1', '暂无', '四川省成都市锦江区三色路3段233号中国工商银行万水行支行', '1');
INSERT INTO `bcs_bank_card` VALUES ('3', '6222021001116248704', '3', '2014-05-09 15:48:15', '1', '15287654529', '2', '1', '2', '暂无', '四川省成都市双流区三色路3段233号中国工商银行万水行支行', '1');
INSERT INTO `bcs_bank_card` VALUES ('4', '5214234234234234', '18', '2014-05-14 16:58:14', '1', '13548423432', '2', '1', '1', '23423432', '成都市金象支行', '1');
INSERT INTO `bcs_bank_card` VALUES ('5', '5345245352354', '18', '2014-05-15 10:58:09', '1', '13354354454', '2', '1', '2', '111', '24214', '1');
INSERT INTO `bcs_bank_card` VALUES ('6', '6222021001116248704', '1', '2014-05-22 10:17:04', '1', '15287654529', '2', '1', '2', '暂无', '四川省成都市双流区三色路3段233号中国工商银行万水行支行', '1');
INSERT INTO `bcs_bank_card` VALUES ('7', '', '56', '2014-06-10 09:35:28', '1', '', '2', '2', '2', '', '', '1');
INSERT INTO `bcs_bank_card` VALUES ('8', '12312312323', '56', '2014-06-10 09:37:44', '1', '123', '2', '1', '1', '2323vdvf', '123', '1');
INSERT INTO `bcs_bank_card` VALUES ('9', '1111111', '47', '2014-06-11 09:44:39', '1', '', '2', '2', '1', '', '', '1');
INSERT INTO `bcs_bank_card` VALUES ('10', '1231222222222', '54', '2014-06-11 15:54:36', '1', '', '2', '1', '2', '', '', '1');
INSERT INTO `bcs_bank_card` VALUES ('11', '232323233卡', '54', '2014-06-11 15:54:57', '1', '', '2', '2', '1', '', '', '1');
INSERT INTO `bcs_bank_card` VALUES ('12', '1222222222222222', '54', '2014-06-11 15:59:05', '1', '', '2', '1', '1', '', '', '1');
INSERT INTO `bcs_bank_card` VALUES ('13', '12444444444444234234', '69', '2014-06-20 14:18:10', '1', '13453453454', '2', '1', '1', 'xxxxx', 'xxxxxx', '1');
INSERT INTO `bcs_bank_card` VALUES ('14', '', '89', '2014-06-24 10:36:06', '2', '1212121212', '1', '1', '1', '2121', '1212121212', '1');
INSERT INTO `bcs_bank_card` VALUES ('15', '611325199005275413', '10', '2014-06-26 11:21:29', '2', '1520328293', '2', '1', '1', 'sdsd', 'sdsd', '1');
INSERT INTO `bcs_bank_card` VALUES ('16', '811325199005275413', '68', '2014-06-26 11:22:16', '4', '15207362892', '2', '1', '1', 'sdsd', 'sdsd', '1');
INSERT INTO `bcs_bank_card` VALUES ('17', '2342343412', '90', '2014-06-26 13:39:32', '1', '13564654544', '1', '1', '1', '1111', 'xxxxx', '1');
INSERT INTO `bcs_bank_card` VALUES ('18', '123', '93', '2014-07-02 14:59:33', '1', '122', '2', '1', '2', '', '', '1');
INSERT INTO `bcs_bank_card` VALUES ('19', '1', '93', '2014-07-02 15:51:42', '1', '1', '2', '1', '1', '', '', '1');
INSERT INTO `bcs_bank_card` VALUES ('20', '11111', '96', '2014-07-02 16:03:46', '2', '1', '1', '2', '1', '', '', '2');
INSERT INTO `bcs_bank_card` VALUES ('21', '0', '96', '2014-07-02 16:39:52', '1', '不清楚', '1', '1', '1', '', '', '1');
INSERT INTO `bcs_bank_card` VALUES ('22', '1212121212', '100', '2014-07-07 14:05:34', '2', '1212121', '2', '2', '1', '', '', '1');
INSERT INTO `bcs_bank_card` VALUES ('23', '1212', '100', '2014-07-07 14:06:20', '3', '12121', '2', '1', '1', '2121', '122121', '1');
INSERT INTO `bcs_bank_card` VALUES ('24', '611325199005245413', '1000000105', '2014-07-15 16:40:50', '3', '15208214876', '2', '1', '1', '测试银行卡', '四川成都市郫县红光农业银行支行', '1');
INSERT INTO `bcs_bank_card` VALUES ('25', '1234567890', '9', '2014-08-19 09:36:00', '1', '13980990001', '2', '1', '1', '', '', '1');
INSERT INTO `bcs_bank_card` VALUES ('26', '123456789', '1000000124', '2014-08-19 11:24:56', '1', '123456789', '1', '1', '1', '孙道存', '四川成都', '1');

-- ----------------------------
-- Table structure for `bcs_bills`
-- ----------------------------
DROP TABLE IF EXISTS `bcs_bills`;
CREATE TABLE `bcs_bills` (
  `BILLS_ID` int(10) NOT NULL AUTO_INCREMENT,
  `ACCOUNT_ID` int(10) DEFAULT NULL COMMENT '账户编号',
  `OPT_NUMBER` varchar(100) NOT NULL COMMENT '操作流水号',
  `CREATE_TIME` datetime NOT NULL COMMENT '生成时间',
  `BUSINESS_NAME` varchar(50) NOT NULL COMMENT '业务名称',
  `BUSINESS_ID` int(10) NOT NULL COMMENT '业务编号',
  `SON_BUSINESS_ID` char(10) DEFAULT NULL COMMENT '子业务编号',
  `SON_BUSINESS_NAME` varchar(50) DEFAULT NULL COMMENT '子业务名称',
  `COST_WAY` int(2) DEFAULT NULL COMMENT '扣费方式 1-按次   2-按率',
  `COST_PERCENT` varchar(50) DEFAULT NULL COMMENT '费率 1-1元/次  2-0.3%   3-0.1%',
  `UNDO_TIME` datetime DEFAULT NULL COMMENT '撤销时间',
  `RELATE_BILLS_ID` int(10) DEFAULT NULL COMMENT '关联账单编号',
  `STATUS` int(2) NOT NULL COMMENT '账单状态 1-已完成   2-未完成；3-待下账；4-处理失败',
  `MONEY_DIRECTION` int(2) NOT NULL COMMENT '资金流向 1-支出   2-转入',
  `ORIGINAL_BALANCE` double(10,2) DEFAULT NULL COMMENT '原始金额',
  `BILLS_BALANCE` double(10,2) NOT NULL COMMENT '账单金额',
  `HANDING_MONEY` double(10,2) DEFAULT NULL COMMENT '处理金额',
  `ACCOUNT_BALANCE` double(10,2) DEFAULT NULL COMMENT '账户余额',
  `REMARK` varchar(254) DEFAULT NULL COMMENT '账单备注',
  PRIMARY KEY (`BILLS_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=519 DEFAULT CHARSET=utf8 COMMENT='账单信息表';

-- ----------------------------
-- Records of bcs_bills
-- ----------------------------
INSERT INTO `bcs_bills` VALUES ('3', '1', '1000000239', '2014-05-19 14:12:49', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '2060.00', '10000.00', '2.00', '10000.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('4', '1', '1000000239', '2014-05-19 14:13:16', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '12060.00', '11.00', '2.00', '11.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('5', '33', '1000000239', '2014-05-21 09:19:49', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '0.00', '1000.00', '2.00', '1000.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('6', '33', '1000000239', '2014-05-21 09:20:04', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '1000.00', '5000.00', '2.00', '5000.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('7', '33', '1000000239', '2014-05-21 09:20:20', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '6000.00', '20000.00', '2.00', '20000.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('8', '33', '1000000239', '2014-05-21 09:20:32', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '26000.00', '45000.00', '2.00', '45000.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('9', '33', '1000000239', '2014-05-21 09:21:01', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '71000.00', '45000.00', '2.00', '45000.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('10', '33', '1000000239', '2014-05-21 09:21:15', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '116000.00', '50000.00', '2.00', '50000.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('11', '33', '1000000239', '2014-05-21 09:21:30', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '166000.00', '8000.00', '2.00', '8000.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('12', '33', '1000000239', '2014-05-21 09:21:40', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '174000.00', '6000.00', '2.00', '6000.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('13', '1', '1000000239', '2014-05-21 15:10:16', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '12071.00', '100.00', '2.00', '100.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('14', '33', '1000000239', '2014-05-21 16:51:15', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '180000.00', '98.00', '2.00', '98.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('15', '33', '1000000239', '2014-05-21 16:51:31', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '180098.00', '8766.00', '2.00', '8766.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('16', '33', '1000000239', '2014-05-21 16:51:58', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '188864.00', '765.00', '2.00', '765.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('17', '33', '1000000239', '2014-05-21 16:52:09', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '189629.00', '9977.00', '2.00', '9977.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('18', '44', '1000000239', '2014-05-22 11:24:31', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '0.00', '100.00', '2.00', '100.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('19', '45', '1000000239', '2014-05-22 13:56:36', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '0.00', '5.00', '2.00', '5.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('20', '45', '1000000239', '2014-05-22 14:01:19', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '5.00', '11.00', '2.00', '11.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('21', '45', '1000000239', '2014-05-22 14:01:44', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '16.00', '10001.00', '2.00', '10001.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('22', '46', '1000000239', '2014-05-22 15:52:49', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '0.00', '10.00', '2.00', '10.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('23', '47', '1000000239', '2014-05-22 16:22:53', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '100.00', '100.00', '2.00', '100.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('24', '46', '1000000239', '2014-05-23 10:07:50', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '10.00', '10000.00', '2.00', '10000.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('25', '1', '1000000239', '2014-05-23 11:30:21', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '12171.00', '100.00', '2.00', '100.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('26', '1', '1000000239', '2014-05-23 11:31:24', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '12271.00', '100.00', '2.00', '100.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('27', '1', '1000000239', '2014-05-23 11:31:40', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '12371.00', '11.00', '2.00', '11.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('28', '1', '1000000239', '2014-05-23 11:33:53', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '12382.00', '11.00', '2.00', '11.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('29', '1', '1000000239', '2014-05-23 13:02:48', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '12393.00', '11.00', '2.00', '11.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('30', '1', '1000000239', '2014-05-23 13:03:51', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '12404.00', '11.00', '2.00', '11.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('31', '45', '1000000239', '2014-05-23 14:09:03', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '10017.00', '100.00', '2.00', '100.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('32', '46', '1000000239', '2014-05-23 15:06:06', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '10010.00', '50000.00', '2.00', '50000.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('33', '33', '1000000239', '2014-05-23 16:47:04', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '199606.00', '10000.00', '2.00', '10000.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('34', '33', '1000000239', '2014-05-23 16:47:47', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '209606.00', '20000.00', '2.00', '20000.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('35', '50', '1000000239', '2014-05-23 17:29:25', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '0.00', '1000.00', '2.00', '1000.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('36', '1', '1000000239', '2014-05-26 09:42:11', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '12415.00', '300.00', '2.00', '12115.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('37', '3', '1000000239', '2014-05-26 09:42:11', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '10.00', '300.00', '2.00', '310.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('38', '1', '1000000239', '2014-05-26 09:42:44', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '12415.00', '300.00', '2.00', '12115.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('39', '3', '1000000239', '2014-05-26 09:42:44', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '10.00', '300.00', '2.00', '310.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('40', '1', '1000000239', '2014-05-26 09:45:53', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '12415.00', '300.00', '2.00', '12115.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('41', '3', '1000000239', '2014-05-26 09:45:53', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '10.00', '300.00', '2.00', '310.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('42', '1', '1000000239', '2014-05-26 09:47:53', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '12415.00', '300.00', '2.00', '12115.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('43', '3', '1000000239', '2014-05-26 09:47:53', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '10.00', '300.00', '2.00', '310.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('44', '1', '1000000239', '2014-05-26 09:59:08', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '12115.00', '300.00', '2.00', '11815.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('45', '3', '1000000239', '2014-05-26 09:59:08', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '310.00', '300.00', '2.00', '610.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('46', '46', '1000000239', '2014-05-26 10:06:46', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '60010.00', '10.00', '2.00', '10.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('47', '33', '1000000239', '2014-05-26 15:27:10', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '229606.00', '10009.00', '2.00', '10009.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('48', '45', '1000000239', '2014-05-27 09:18:20', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '10117.00', '100.00', '2.00', '100.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('49', '45', '1000000239', '2014-05-27 09:23:47', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '10217.00', '100.00', '2.00', '100.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('50', '3', '100000000', '2014-05-27 13:35:46', '转账', '4', '1', '1', '1', '1', null, null, '1', '1', '610.00', '300.00', '2.00', '8700.00', '虚拟账户内部转账');
INSERT INTO `bcs_bills` VALUES ('51', '3', '1000000239', '2014-05-27 13:35:46', '转账', '4', '1', '1', '1', '1', null, null, '1', '0', '610.00', '300.00', '2.00', '910.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('52', '1', '100000000', '2014-05-27 13:49:05', '转账', '4', '1', '1', '1', '1', null, null, '1', '1', '8700.00', '300.00', '2.00', '8400.00', '虚拟账户内部转账');
INSERT INTO `bcs_bills` VALUES ('53', '3', '1000000239', '2014-05-27 13:49:05', '转账', '4', '1', '1', '1', '1', null, null, '1', '0', '910.00', '300.00', '2.00', '1210.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('54', '45', '1000000239', '2014-05-27 14:53:01', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '2317.00', '100.00', '2.00', '100.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('55', '45', '1000000239', '2014-05-28 10:29:28', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '2417.00', '100.00', '2.00', '100.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('56', '51', '1000000239', '2014-05-28 11:00:39', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '0.00', '5000.00', '2.00', '5000.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('57', '51', '1000000239', '2014-05-28 11:00:49', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '5000.00', '5000.00', '2.00', '5000.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('58', '51', '1000000239', '2014-05-28 11:01:01', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '10000.00', '50000.00', '2.00', '50000.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('59', '51', '1000000239', '2014-05-28 11:01:10', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '60000.00', '50000.00', '2.00', '50000.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('60', '1', '1000000239', '2014-05-28 14:42:18', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '8400.00', '200.00', '2.00', '200.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('61', '1', '1000000239', '2014-05-28 14:46:37', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '8600.00', '200.00', '2.00', '200.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('62', '3', '100000110', '2014-05-28 15:11:14', '转账', '4', '1', '1', '1', '1', null, null, '1', '1', '1210.00', '200.00', '2.00', '1010.00', 'FSG账务服务网关转账');
INSERT INTO `bcs_bills` VALUES ('63', '1', '1000000239', '2014-05-28 15:11:14', '转账', '4', '1', '1', '1', '1', null, null, '1', '0', '8400.00', '200.00', '2.00', '8600.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('64', '3', '100000110', '2014-05-28 15:19:17', '转账', '4', '1', '1', '1', '1', null, null, '1', '1', '1010.00', '200.00', '2.00', '810.00', 'FSG账务服务网关转账');
INSERT INTO `bcs_bills` VALUES ('65', '1', '1000000239', '2014-05-28 15:19:17', '转账', '4', '1', '1', '1', '1', null, null, '1', '0', '8400.00', '200.00', '2.00', '8600.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('66', '1', '1000000239', '2014-05-28 15:28:14', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '8600.00', '300.00', '2.00', '8300.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('67', '3', '1000000239', '2014-05-28 15:28:14', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '810.00', '300.00', '2.00', '1110.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('68', '1', '1000000239', '2014-05-28 15:44:31', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '8300.00', '1700.00', '2.00', '1700.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('69', '45', '1000000239', '2014-05-28 15:59:24', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '2517.00', '100.00', '2.00', '100.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('70', '45', '1000000239', '2014-05-28 15:59:35', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '2617.00', '11.00', '2.00', '11.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('71', '52', '1000000239', '2014-05-29 11:49:39', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '0.00', '100.00', '2.00', '100.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('72', '52', '1000000239', '2014-05-29 11:54:34', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '100.00', '100.00', '2.00', '100.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('73', '46', '1000000239', '2014-05-29 16:26:00', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '60020.00', '50000.00', '2.00', '50000.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('74', '46', '1000000239', '2014-05-29 16:26:50', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '110020.00', '50000.00', '2.00', '50000.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('75', '46', '1000000239', '2014-05-29 16:27:12', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '160020.00', '50000.00', '2.00', '50000.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('76', '46', '1000000239', '2014-05-29 16:27:32', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '210020.00', '50000.00', '2.00', '50000.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('77', '46', '1000000239', '2014-05-29 16:28:03', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '260020.00', '50000.00', '2.00', '50000.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('78', '46', '1000000239', '2014-05-29 16:28:09', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '310020.00', '50000.00', '2.00', '50000.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('79', '46', '1000000239', '2014-05-29 16:28:37', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '360020.00', '50000.00', '2.00', '50000.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('80', '46', '1000000239', '2014-05-29 16:28:42', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '410020.00', '50000.00', '2.00', '50000.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('81', '46', '1000000239', '2014-05-29 16:28:52', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '460020.00', '50000.00', '2.00', '50000.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('82', '46', '1000000239', '2014-05-29 16:29:02', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '510020.00', '50000.00', '2.00', '50000.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('83', '46', '1000000239', '2014-05-29 16:29:11', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '560020.00', '50000.00', '2.00', '50000.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('84', '46', '1000000239', '2014-05-29 16:29:18', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '610020.00', '50000.00', '2.00', '50000.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('85', '46', '1000000239', '2014-05-29 16:29:22', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '660020.00', '50000.00', '2.00', '50000.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('86', '46', '1000000239', '2014-05-29 16:29:35', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '710020.00', '50000.00', '2.00', '50000.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('87', '46', '1000000239', '2014-05-29 16:29:50', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '760020.00', '50000.00', '2.00', '50000.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('88', '46', '1000000239', '2014-05-29 16:29:59', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '810020.00', '50000.00', '2.00', '50000.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('89', '46', '1000000239', '2014-05-29 16:30:03', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '860020.00', '50000.00', '2.00', '50000.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('90', '46', '1000000239', '2014-05-29 16:30:09', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '910020.00', '50000.00', '2.00', '50000.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('91', '46', '1000000239', '2014-05-29 16:30:12', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '960020.00', '50000.00', '2.00', '50000.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('92', '46', '1000000239', '2014-05-29 16:30:17', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '1010020.00', '50000.00', '2.00', '50000.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('93', '46', '1000000239', '2014-05-29 16:30:22', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '1060020.00', '50000.00', '2.00', '50000.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('94', '46', '1000000239', '2014-05-29 16:30:26', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '1110020.00', '50000.00', '2.00', '50000.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('95', '46', '1000000239', '2014-05-29 16:30:29', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '1160020.00', '50000.00', '2.00', '50000.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('96', '54', '1000000239', '2014-05-29 17:27:54', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '0.00', '500.00', '2.00', '500.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('97', '54', '1000000239', '2014-06-03 15:04:33', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '500.00', '10.00', '2.00', '10.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('98', '45', '1000000239', '2014-06-03 17:35:18', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '2628.00', '0.00', '2.00', '2628.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('99', '10', '1000000239', '2014-06-03 17:35:18', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '10.00', '0.00', '2.00', '10.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('100', '51', '1000000239', '2014-06-03 20:55:59', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '110000.00', '5000.00', '2.00', '5000.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('101', '45', '1000000239', '2014-06-04 09:46:25', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '2628.00', '0.00', '2.00', '2628.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('102', '10', '1000000239', '2014-06-04 09:46:25', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '10.00', '0.00', '2.00', '10.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('103', '46', '1000000239', '2014-06-04 14:32:20', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '1210020.00', '1212.00', '2.00', '1212.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('104', '46', '1000000239', '2014-06-04 14:33:53', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '1211232.00', '50000.00', '2.00', '50000.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('105', '46', '1000000239', '2014-06-04 14:41:29', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '1261232.00', '9919.00', '2.00', '9919.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('106', '3', '1000000239', '2014-06-04 16:25:30', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '1110.00', '3.00', '2.00', '1107.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('107', '1', '1000000239', '2014-06-04 16:25:30', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '10000.00', '3.00', '2.00', '10003.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('108', '3', '1000000239', '2014-06-04 16:27:09', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '1107.00', '3.00', '2.00', '1104.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('109', '1', '1000000239', '2014-06-04 16:27:09', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '10003.00', '3.00', '2.00', '10006.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('110', '3', '1000000239', '2014-06-04 16:27:46', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '1104.00', '3.00', '2.00', '1101.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('111', '1', '1000000239', '2014-06-04 16:27:46', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '10006.00', '3.00', '2.00', '10009.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('112', '3', '1000000239', '2014-06-04 16:29:52', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '1101.00', '3.00', '2.00', '1098.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('113', '1', '1000000239', '2014-06-04 16:29:52', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '10009.00', '3.00', '2.00', '10012.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('114', '3', '1000000239', '2014-06-04 16:31:35', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '1098.00', '3.00', '2.00', '1095.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('115', '1', '1000000239', '2014-06-04 16:31:35', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '10012.00', '3.00', '2.00', '10015.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('116', '3', '1000000239', '2014-06-04 16:33:37', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '1095.00', '3.00', '2.00', '1092.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('117', '1', '1000000239', '2014-06-04 16:33:37', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '10015.00', '3.00', '2.00', '10018.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('118', '3', '1000000239', '2014-06-04 16:35:09', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '1092.00', '3.00', '2.00', '1089.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('119', '1', '1000000239', '2014-06-04 16:35:09', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '10018.00', '3.00', '2.00', '10021.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('120', '3', '1000000239', '2014-06-04 16:35:38', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '1089.00', '3.00', '2.00', '1086.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('121', '1', '1000000239', '2014-06-04 16:35:38', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '10021.00', '3.00', '2.00', '10024.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('122', '3', '1000000239', '2014-06-04 16:36:46', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '1086.00', '3.00', '2.00', '1083.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('123', '1', '1000000239', '2014-06-04 16:36:46', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '10024.00', '3.00', '2.00', '10027.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('124', '3', '1000000239', '2014-06-04 16:38:21', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '1083.00', '3.00', '2.00', '1080.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('125', '1', '1000000239', '2014-06-04 16:38:21', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '10027.00', '3.00', '2.00', '10030.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('126', '3', '1000000239', '2014-06-04 16:40:09', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '1080.00', '3.00', '2.00', '1077.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('127', '1', '1000000239', '2014-06-04 16:40:09', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '10030.00', '3.00', '2.00', '10033.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('128', '3', '1000000239', '2014-06-04 16:48:38', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '1077.00', '3.00', '2.00', '1074.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('129', '1', '1000000239', '2014-06-04 16:48:38', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '10033.00', '3.00', '2.00', '10036.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('130', '3', '1000000239', '2014-06-04 16:50:40', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '1074.00', '3.00', '2.00', '1071.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('131', '1', '1000000239', '2014-06-04 16:50:40', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '10036.00', '3.00', '2.00', '10039.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('132', '3', '1000000239', '2014-06-04 17:08:14', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '1071.00', '3.00', '2.00', '1068.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('133', '1', '1000000239', '2014-06-04 17:08:14', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '10039.00', '3.00', '2.00', '10042.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('134', '3', '1000000239', '2014-06-04 17:09:02', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '1068.00', '3.00', '2.00', '1065.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('135', '1', '1000000239', '2014-06-04 17:09:02', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '10042.00', '3.00', '2.00', '10045.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('136', '3', '1000000239', '2014-06-04 17:10:43', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '1065.00', '3.00', '2.00', '1062.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('137', '1', '1000000239', '2014-06-04 17:10:43', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '10045.00', '3.00', '2.00', '10048.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('138', '3', '1000000239', '2014-06-04 17:11:32', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '1062.00', '3.00', '2.00', '1059.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('139', '1', '1000000239', '2014-06-04 17:11:32', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '10048.00', '3.00', '2.00', '10051.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('140', '3', '1000000239', '2014-06-04 17:11:50', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '1059.00', '3.00', '2.00', '1056.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('141', '1', '1000000239', '2014-06-04 17:11:50', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '10051.00', '3.00', '2.00', '10054.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('142', '3', '1000000239', '2014-06-04 17:17:37', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '1056.00', '0.01', '2.00', '1055.99', '暂无');
INSERT INTO `bcs_bills` VALUES ('143', '1', '1000000239', '2014-06-04 17:17:37', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '10054.00', '0.01', '2.00', '10054.01', '暂无');
INSERT INTO `bcs_bills` VALUES ('144', '46', '1000000239', '2014-06-04 17:27:49', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '1271151.00', '123.00', '2.00', '123.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('145', '3', '1000000239', '2014-06-05 09:56:38', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '1055.99', '0.01', '2.00', '1055.98', '暂无');
INSERT INTO `bcs_bills` VALUES ('146', '1', '1000000239', '2014-06-05 09:56:38', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '10054.01', '0.01', '2.00', '10054.02', '暂无');
INSERT INTO `bcs_bills` VALUES ('147', '3', '1000000239', '2014-06-05 09:57:48', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '1055.98', '0.01', '2.00', '1055.97', '暂无');
INSERT INTO `bcs_bills` VALUES ('148', '1', '1000000239', '2014-06-05 09:57:48', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '10054.02', '0.01', '2.00', '10054.03', '暂无');
INSERT INTO `bcs_bills` VALUES ('149', '45', '1000000239', '2014-06-06 14:04:52', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '2627.98', '0.01', '2.00', '2627.97', '暂无');
INSERT INTO `bcs_bills` VALUES ('150', '1', '1000000239', '2014-06-06 14:04:52', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '10054.03', '0.01', '2.00', '10054.04', '暂无');
INSERT INTO `bcs_bills` VALUES ('151', '45', '1000000239', '2014-06-06 14:11:38', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '2627.97', '0.01', '2.00', '2627.96', '暂无');
INSERT INTO `bcs_bills` VALUES ('152', '1', '1000000239', '2014-06-06 14:11:38', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '10054.04', '0.01', '2.00', '10054.05', '暂无');
INSERT INTO `bcs_bills` VALUES ('153', '45', '1000000239', '2014-06-06 14:13:13', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '2627.96', '0.01', '2.00', '2627.95', '暂无');
INSERT INTO `bcs_bills` VALUES ('154', '1', '1000000239', '2014-06-06 14:13:13', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '10054.05', '0.01', '2.00', '10054.06', '暂无');
INSERT INTO `bcs_bills` VALUES ('155', '45', '1000000239', '2014-06-06 14:14:04', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '2627.95', '0.01', '2.00', '2627.94', '暂无');
INSERT INTO `bcs_bills` VALUES ('156', '1', '1000000239', '2014-06-06 14:14:04', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '10054.06', '0.01', '2.00', '10054.07', '暂无');
INSERT INTO `bcs_bills` VALUES ('157', '45', '1000000239', '2014-06-06 14:17:34', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '2627.94', '0.01', '2.00', '2627.93', '暂无');
INSERT INTO `bcs_bills` VALUES ('158', '1', '1000000239', '2014-06-06 14:17:34', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '10054.07', '0.01', '2.00', '10054.08', '暂无');
INSERT INTO `bcs_bills` VALUES ('159', '45', '1000000239', '2014-06-06 14:27:45', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '2627.93', '40.00', '2.00', '2587.93', '暂无');
INSERT INTO `bcs_bills` VALUES ('160', '1', '1000000239', '2014-06-06 14:27:45', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '10054.08', '40.00', '2.00', '10094.08', '暂无');
INSERT INTO `bcs_bills` VALUES ('161', '45', '1000000239', '2014-06-06 14:33:19', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '2587.93', '38.00', '2.00', '2549.93', '暂无');
INSERT INTO `bcs_bills` VALUES ('162', '1', '1000000239', '2014-06-06 14:33:19', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '10094.08', '38.00', '2.00', '10132.08', '暂无');
INSERT INTO `bcs_bills` VALUES ('163', '45', '1000000239', '2014-06-06 14:34:27', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '2000.00', '108.00', '2.00', '1892.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('164', '1', '1000000239', '2014-06-06 14:34:27', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '10132.08', '108.00', '2.00', '10240.08', '暂无');
INSERT INTO `bcs_bills` VALUES ('165', '45', '1000000239', '2014-06-06 14:53:51', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '1892.00', '40.00', '2.00', '1852.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('166', '1', '1000000239', '2014-06-06 14:53:51', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '10240.08', '40.00', '2.00', '10280.08', '暂无');
INSERT INTO `bcs_bills` VALUES ('167', '45', '1000000239', '2014-06-06 14:55:33', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '1852.00', '40.00', '2.00', '1812.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('168', '1', '1000000239', '2014-06-06 14:55:33', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '10280.08', '40.00', '2.00', '10320.08', '暂无');
INSERT INTO `bcs_bills` VALUES ('169', '45', '1000000239', '2014-06-06 15:08:49', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '1812.00', '40.00', '2.00', '1772.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('170', '1', '1000000239', '2014-06-06 15:08:49', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '10320.08', '40.00', '2.00', '10360.08', '暂无');
INSERT INTO `bcs_bills` VALUES ('171', '45', '1000000239', '2014-06-06 16:18:53', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '1772.00', '40.00', '2.00', '1732.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('172', '1', '1000000239', '2014-06-06 16:18:53', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '10360.08', '40.00', '2.00', '10400.08', '暂无');
INSERT INTO `bcs_bills` VALUES ('173', '45', '1000000239', '2014-06-06 16:20:51', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '1732.00', '10000.00', '2.00', '10000.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('174', '45', '1000000239', '2014-06-06 16:21:50', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '11732.00', '7290.00', '2.00', '4442.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('175', '1', '1000000239', '2014-06-06 16:21:50', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '10400.08', '7290.00', '2.00', '17690.08', '暂无');
INSERT INTO `bcs_bills` VALUES ('176', '45', '1000000239', '2014-06-06 16:46:25', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '4442.00', '100.00', '2.00', '100.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('177', '45', '1000000239', '2014-06-06 16:49:24', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '4542.00', '62.00', '2.00', '4480.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('178', '1', '1000000239', '2014-06-06 16:49:24', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '17690.08', '62.00', '2.00', '17752.08', '暂无');
INSERT INTO `bcs_bills` VALUES ('179', '45', '1000000239', '2014-06-06 16:51:01', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '4480.00', '20.00', '2.00', '20.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('180', '45', '1000000239', '2014-06-06 16:52:49', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '4500.00', '110.00', '2.00', '110.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('181', '45', '1000000239', '2014-06-06 17:21:08', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '4610.00', '158.00', '2.00', '4452.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('182', '1', '1000000239', '2014-06-06 17:21:08', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '17752.08', '158.00', '2.00', '17910.08', '暂无');
INSERT INTO `bcs_bills` VALUES ('183', '45', '1000000239', '2014-06-06 17:40:19', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '4452.00', '0.01', '2.00', '0.01', '暂无');
INSERT INTO `bcs_bills` VALUES ('184', '45', '1000000239', '2014-06-06 17:44:50', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '4452.01', '0.01', '2.00', '0.01', '暂无');
INSERT INTO `bcs_bills` VALUES ('185', '45', '1000000239', '2014-06-06 18:08:24', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '4452.02', '0.01', '2.00', '4452.01', '暂无');
INSERT INTO `bcs_bills` VALUES ('186', '10', '1000000239', '2014-06-06 18:08:24', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '10.02', '0.01', '2.00', '10.03', '暂无');
INSERT INTO `bcs_bills` VALUES ('187', '45', '1000000239', '2014-06-10 10:14:52', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '4452.01', '0.01', '2.00', '4452.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('188', '10', '1000000239', '2014-06-10 10:14:52', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '10.03', '0.01', '2.00', '10.04', '暂无');
INSERT INTO `bcs_bills` VALUES ('189', '1', '1000000239', '2014-06-10 14:52:13', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '17910.08', '100.00', '2.00', '100.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('190', '1', '1000000239', '2014-06-10 14:54:18', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '18010.08', '0.01', '2.00', '18010.07', '暂无');
INSERT INTO `bcs_bills` VALUES ('191', '10', '1000000239', '2014-06-10 14:54:18', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '10.04', '0.01', '2.00', '10.05', '暂无');
INSERT INTO `bcs_bills` VALUES ('192', '45', '1000000239', '2014-06-11 08:46:05', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '4452.00', '0.01', '2.00', '4451.99', '暂无');
INSERT INTO `bcs_bills` VALUES ('193', '10', '1000000239', '2014-06-11 08:46:05', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '10.05', '0.01', '2.00', '10.06', '暂无');
INSERT INTO `bcs_bills` VALUES ('194', '1', '1000000239', '2014-06-11 09:02:59', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '18010.07', '0.01', '2.00', '18010.06', '暂无');
INSERT INTO `bcs_bills` VALUES ('195', '10', '1000000239', '2014-06-11 09:02:59', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '10.06', '0.01', '2.00', '10.07', '暂无');
INSERT INTO `bcs_bills` VALUES ('196', '45', '1000000239', '2014-06-11 09:13:22', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '4451.99', '0.01', '2.00', '4451.98', '暂无');
INSERT INTO `bcs_bills` VALUES ('197', '10', '1000000239', '2014-06-11 09:13:22', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '10.07', '0.01', '2.00', '10.08', '暂无');
INSERT INTO `bcs_bills` VALUES ('198', '1', '1000000239', '2014-06-11 09:22:15', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '18010.06', '0.01', '2.00', '18010.05', '暂无');
INSERT INTO `bcs_bills` VALUES ('199', '10', '1000000239', '2014-06-11 09:22:15', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '10.08', '0.01', '2.00', '10.09', '暂无');
INSERT INTO `bcs_bills` VALUES ('200', '1', '1000000239', '2014-06-11 09:22:44', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '18010.05', '40.00', '2.00', '17970.05', '暂无');
INSERT INTO `bcs_bills` VALUES ('201', '1', '1000000239', '2014-06-11 09:22:44', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '18010.05', '40.00', '2.00', '18050.05', '暂无');
INSERT INTO `bcs_bills` VALUES ('202', '45', '1000000239', '2014-06-11 09:56:28', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '4451.98', '0.01', '2.00', '4451.97', '暂无');
INSERT INTO `bcs_bills` VALUES ('203', '10', '1000000239', '2014-06-11 09:56:28', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '10.09', '0.01', '2.00', '10.10', '暂无');
INSERT INTO `bcs_bills` VALUES ('204', '45', '1000000239', '2014-06-11 10:08:23', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '4451.97', '0.01', '2.00', '4451.96', '暂无');
INSERT INTO `bcs_bills` VALUES ('205', '10', '1000000239', '2014-06-11 10:08:23', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '10.10', '0.01', '2.00', '10.11', '暂无');
INSERT INTO `bcs_bills` VALUES ('206', '46', '1000000239', '2014-06-11 16:13:24', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '1271274.00', '7406.00', '2.00', '1263868.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('207', '1', '1000000239', '2014-06-11 16:13:24', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '18050.05', '7406.00', '2.00', '25456.05', '暂无');
INSERT INTO `bcs_bills` VALUES ('208', '46', '1000000239', '2014-06-11 16:14:30', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '1263868.00', '7406.00', '2.00', '1256462.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('209', '1', '1000000239', '2014-06-11 16:14:30', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '25456.05', '7406.00', '2.00', '32862.05', '暂无');
INSERT INTO `bcs_bills` VALUES ('210', '46', '1000000239', '2014-06-11 16:16:00', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '1256462.00', '96.00', '2.00', '1256366.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('211', '1', '1000000239', '2014-06-11 16:16:00', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '32862.05', '96.00', '2.00', '32958.05', '暂无');
INSERT INTO `bcs_bills` VALUES ('212', '46', '1000000239', '2014-06-11 16:24:44', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '1256366.00', '62.00', '2.00', '1256304.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('213', '1', '1000000239', '2014-06-11 16:24:44', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '32958.05', '62.00', '2.00', '33020.05', '暂无');
INSERT INTO `bcs_bills` VALUES ('214', '1', '1000000239', '2014-06-11 16:27:21', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '33020.05', '0.01', '2.00', '33020.04', '暂无');
INSERT INTO `bcs_bills` VALUES ('215', '10', '1000000239', '2014-06-11 16:27:21', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '10.11', '0.01', '2.00', '10.12', '暂无');
INSERT INTO `bcs_bills` VALUES ('216', '1', '1000000239', '2014-06-11 16:45:26', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '33020.04', '0.01', '2.00', '33020.03', '暂无');
INSERT INTO `bcs_bills` VALUES ('217', '10', '1000000239', '2014-06-11 16:45:26', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '10.12', '0.01', '2.00', '10.13', '暂无');
INSERT INTO `bcs_bills` VALUES ('218', '45', '1000000239', '2014-06-12 00:53:57', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '4451.96', '38.00', '2.00', '4413.96', '暂无');
INSERT INTO `bcs_bills` VALUES ('219', '1', '1000000239', '2014-06-12 00:53:57', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '33020.03', '38.00', '2.00', '33058.03', '暂无');
INSERT INTO `bcs_bills` VALUES ('220', '45', '1000000239', '2014-06-12 00:56:37', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '4413.96', '100.00', '2.00', '100.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('221', '45', '1000000239', '2014-06-12 00:58:36', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '4513.96', '100.00', '2.00', '100.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('222', '46', '1000000239', '2014-06-12 01:00:09', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '1256304.00', '1280.00', '2.00', '1255024.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('223', '1', '1000000239', '2014-06-12 01:00:09', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '33058.03', '1280.00', '2.00', '34338.03', '暂无');
INSERT INTO `bcs_bills` VALUES ('224', '46', '1000000239', '2014-06-12 01:00:44', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '1255024.00', '1280.00', '2.00', '1253744.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('225', '1', '1000000239', '2014-06-12 01:00:44', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '34338.03', '1280.00', '2.00', '35618.03', '暂无');
INSERT INTO `bcs_bills` VALUES ('226', '54', '1000000239', '2014-06-12 17:18:04', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '510.00', '229.79', '2.00', '280.21', '暂无');
INSERT INTO `bcs_bills` VALUES ('227', '1', '1000000239', '2014-06-12 17:18:04', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '35618.03', '229.79', '2.00', '35847.82', '暂无');
INSERT INTO `bcs_bills` VALUES ('228', '54', '1000000239', '2014-06-12 17:35:00', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '280.21', '7.80', '2.00', '272.41', '暂无');
INSERT INTO `bcs_bills` VALUES ('229', '1', '1000000239', '2014-06-12 17:35:00', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '35847.82', '7.80', '2.00', '35855.62', '暂无');
INSERT INTO `bcs_bills` VALUES ('230', '46', '1000000239', '2014-06-12 13:41:51', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '1253744.00', '2.00', '2.00', '1253742.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('231', '1', '1000000239', '2014-06-12 13:41:51', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '35855.62', '2.00', '2.00', '35857.62', '暂无');
INSERT INTO `bcs_bills` VALUES ('232', '46', '1000000239', '2014-06-12 13:44:15', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '1253742.00', '7290.00', '2.00', '1246452.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('233', '1', '1000000239', '2014-06-12 13:44:15', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '35857.62', '7290.00', '2.00', '43147.62', '暂无');
INSERT INTO `bcs_bills` VALUES ('234', '46', '1000000239', '2014-06-12 13:44:48', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '1246452.00', '5.00', '2.00', '1246447.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('235', '1', '1000000239', '2014-06-12 13:44:48', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '43147.62', '5.00', '2.00', '43152.62', '暂无');
INSERT INTO `bcs_bills` VALUES ('236', '46', '1000000239', '2014-06-12 13:59:57', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '1246447.00', '8888.00', '2.00', '1237559.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('237', '1', '1000000239', '2014-06-12 13:59:57', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '43152.62', '8888.00', '2.00', '52040.62', '暂无');
INSERT INTO `bcs_bills` VALUES ('238', '45', '1000000239', '2014-06-12 14:15:34', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '4613.96', '21.00', '2.00', '4592.96', '暂无');
INSERT INTO `bcs_bills` VALUES ('239', '1', '1000000239', '2014-06-12 14:15:34', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '52040.62', '21.00', '2.00', '52061.62', '暂无');
INSERT INTO `bcs_bills` VALUES ('240', '45', '1000000239', '2014-06-12 14:34:46', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '4592.96', '256.00', '2.00', '4336.96', '暂无');
INSERT INTO `bcs_bills` VALUES ('241', '1', '1000000239', '2014-06-12 14:34:46', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '52061.62', '256.00', '2.00', '52317.62', '暂无');
INSERT INTO `bcs_bills` VALUES ('242', '45', '1000000239', '2014-06-13 11:24:08', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '4336.96', '729.00', '2.00', '3607.96', '暂无');
INSERT INTO `bcs_bills` VALUES ('243', '1', '1000000239', '2014-06-13 11:24:08', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '52317.62', '729.00', '2.00', '53046.62', '暂无');
INSERT INTO `bcs_bills` VALUES ('244', '45', '1000000239', '2014-06-13 11:24:27', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '3607.96', '729.00', '2.00', '2878.96', '暂无');
INSERT INTO `bcs_bills` VALUES ('245', '1', '1000000239', '2014-06-13 11:24:27', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '53046.62', '729.00', '2.00', '53775.62', '暂无');
INSERT INTO `bcs_bills` VALUES ('246', '45', '1000000239', '2014-06-13 11:27:07', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '2878.96', '729.00', '2.00', '2149.96', '暂无');
INSERT INTO `bcs_bills` VALUES ('247', '1', '1000000239', '2014-06-13 11:27:07', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '53775.62', '729.00', '2.00', '54504.62', '暂无');
INSERT INTO `bcs_bills` VALUES ('248', '46', '1000000239', '2014-06-13 14:14:54', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '1237559.00', '10.00', '2.00', '1237549.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('249', '1', '1000000239', '2014-06-13 14:14:54', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '54504.62', '10.00', '2.00', '54514.62', '暂无');
INSERT INTO `bcs_bills` VALUES ('250', '46', '1000000239', '2014-06-13 14:17:05', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '1237549.00', '1.00', '2.00', '1237548.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('251', '1', '1000000239', '2014-06-13 14:17:05', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '54514.62', '1.00', '2.00', '54515.62', '暂无');
INSERT INTO `bcs_bills` VALUES ('252', '45', '1000000239', '2014-06-13 14:52:58', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '2149.96', '239.00', '2.00', '1910.96', '暂无');
INSERT INTO `bcs_bills` VALUES ('253', '1', '1000000239', '2014-06-13 14:52:58', '订单交易', '3', '1', '1', '1', '1', null, null, '1', '1', '54515.62', '239.00', '2.00', '54754.62', '暂无');
INSERT INTO `bcs_bills` VALUES ('349', '1', '1000000239', '2014-06-17 11:04:32', '充值', '1', '1', '1', '1', '1', null, null, '1', '1', '10000.00', '300.00', '2.00', '10300.00', '暂无');
INSERT INTO `bcs_bills` VALUES ('350', '1', '0000000000140520134742800000', '2014-06-17 19:03:14', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '1', '1', '10300.00', '300.00', '0.00', '10000.00', '订单交易-买家支付付款');
INSERT INTO `bcs_bills` VALUES ('351', '3', '0000000000140520134742800000', '2014-06-17 19:03:14', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '3', '2', '5854.17', '300.00', '0.90', '6153.27', '订单交易-卖家下账货款');
INSERT INTO `bcs_bills` VALUES ('352', '1', '0000000000140520134742800000', '2014-06-17 19:12:53', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '1', '1', '10000.00', '300.00', '0.00', '9700.00', '订单交易-买家支付付款');
INSERT INTO `bcs_bills` VALUES ('353', '3', '0000000000140520134742800000', '2014-06-17 19:12:53', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '3', '2', '6153.27', '300.00', '0.90', '6452.37', '订单交易-卖家下账货款');
INSERT INTO `bcs_bills` VALUES ('354', '1', '0000000000140520134742800000', '2014-06-17 19:19:31', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '1', '1', '9700.00', '300.00', '0.00', '9400.00', '订单交易-买家支付付款');
INSERT INTO `bcs_bills` VALUES ('355', '3', '0000000000140520134742800000', '2014-06-17 19:19:31', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '3', '2', '6452.37', '300.00', '0.90', '6751.47', '订单交易-卖家下账货款');
INSERT INTO `bcs_bills` VALUES ('356', '1', '100000000', '2014-06-17 23:12:57', '充值', '1', '', '', '2', '0.0', null, null, '1', '2', '9400.00', '100.00', '0.00', '9500.00', '账户资金增加');
INSERT INTO `bcs_bills` VALUES ('357', '71', '1003900120140617162755517438', '2014-06-18 00:24:40', '充值', '1', '', '', '2', '0.0', null, null, '1', '2', '0.00', '100.00', '0.00', '100.00', '账户资金充值');
INSERT INTO `bcs_bills` VALUES ('358', '71', '1002900120140617171539300648', '2014-06-18 01:12:02', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '1', '1', '100.00', '78.00', '0.00', '22.00', '[订单交易-买家]-订单虚拟账户支付-交易');
INSERT INTO `bcs_bills` VALUES ('359', '1', '1002900120140617171539300648', '2014-06-18 01:12:02', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '3', '2', '9500.00', '78.00', '0.23', '9577.77', '[订单交易-卖家]-订单虚拟账户支付-交易');
INSERT INTO `bcs_bills` VALUES ('360', '71', '1003900120140617172109814133', '2014-06-18 01:18:12', '充值', '1', '', '', '2', '0.0', null, null, '1', '2', '22.00', '100.00', '0.00', '122.00', '账户资金充值');
INSERT INTO `bcs_bills` VALUES ('361', '45', '1002900120140617173146442599', '2014-06-18 01:28:08', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '1', '1', '1910.96', '119.00', '0.00', '1791.96', '[订单交易-买家]-订单虚拟账户支付-交易');
INSERT INTO `bcs_bills` VALUES ('362', '1', '1002900120140617173146442599', '2014-06-18 01:28:08', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '3', '2', '9577.77', '119.00', '0.36', '9696.41', '[订单交易-卖家]-订单虚拟账户支付-交易');
INSERT INTO `bcs_bills` VALUES ('363', '73', '1003900120140618092148279125', '2014-06-18 17:22:08', '充值', '1', '', '', '2', '0.0', null, null, '1', '2', '0.00', '100.00', '0.00', '100.00', '账户资金充值');
INSERT INTO `bcs_bills` VALUES ('364', '73', '1002900120140618100617706061', '2014-06-18 18:03:00', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '1', '1', '100.00', '40.00', '0.00', '60.00', '[订单交易-买家]-订单虚拟账户支付-交易');
INSERT INTO `bcs_bills` VALUES ('365', '1', '1002900120140618100617706061', '2014-06-18 18:03:00', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '3', '2', '9696.41', '40.00', '0.12', '9736.29', '[订单交易-卖家]-订单虚拟账户支付-交易');
INSERT INTO `bcs_bills` VALUES ('366', '71', '1001900120140618135528127368', '2014-06-18 13:54:55', '充值', '1', '', '', '2', '0.0', null, null, '1', '2', '122.00', '0.01', '0.00', '122.01', '订单交易-非虚拟账户完成的交易充值记录.');
INSERT INTO `bcs_bills` VALUES ('367', '71', '1001900120140618135528127368', '2014-06-18 13:54:55', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '1', '1', '122.01', '0.01', '0.00', '122.00', '[订单交易-买家]-订单支付-交易');
INSERT INTO `bcs_bills` VALUES ('368', '10', '1001900120140618135528127368', '2014-06-18 13:54:55', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '3', '2', '10.13', '0.01', '0.00', '10.14', '[订单交易-卖家]-订单支付-交易');
INSERT INTO `bcs_bills` VALUES ('369', '71', '1003900120140618141033323970', '2014-06-18 14:09:08', '充值', '1', '', '', '2', '0.0', null, null, '1', '2', '122.00', '100.00', '0.00', '222.00', '账户资金充值');
INSERT INTO `bcs_bills` VALUES ('370', '71', '1002900120140618142225946061', '2014-06-18 14:20:35', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '1', '1', '222.00', '40.00', '0.00', '182.00', '[订单交易-买家]-订单虚拟账户支付-交易');
INSERT INTO `bcs_bills` VALUES ('371', '1', '1002900120140618142225946061', '2014-06-18 14:20:35', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '3', '2', '9736.29', '40.00', '0.12', '9776.17', '[订单交易-卖家]-订单虚拟账户支付-交易');
INSERT INTO `bcs_bills` VALUES ('372', '71', '1001900120140618142339178326', '2014-06-18 14:22:17', '充值', '1', '', '', '2', '0.0', null, null, '1', '2', '182.00', '0.01', '0.00', '182.01', '订单交易-非虚拟账户完成的交易充值记录.');
INSERT INTO `bcs_bills` VALUES ('373', '71', '1001900120140618142339178326', '2014-06-18 14:22:17', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '1', '1', '182.01', '0.01', '0.00', '182.00', '[订单交易-买家]-订单支付-交易');
INSERT INTO `bcs_bills` VALUES ('374', '10', '1001900120140618142339178326', '2014-06-18 14:22:17', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '3', '2', '10.14', '0.01', '0.00', '10.15', '[订单交易-卖家]-订单支付-交易');
INSERT INTO `bcs_bills` VALUES ('375', '71', '1002900120140619113029792863', '2014-06-19 11:28:45', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '1', '1', '182.00', '73.00', '0.00', '109.00', '[订单交易-买家]-订单虚拟账户支付-交易');
INSERT INTO `bcs_bills` VALUES ('376', '1', '1002900120140619113029792863', '2014-06-19 11:28:45', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '3', '2', '9776.17', '73.00', '0.22', '9848.95', '[订单交易-卖家]-订单虚拟账户支付-交易');
INSERT INTO `bcs_bills` VALUES ('377', '71', '1003900120140619113110962437', '2014-06-19 11:29:50', '充值', '1', '', '', '2', '0.0', null, null, '1', '2', '109.00', '100.00', '0.00', '209.00', '账户资金充值');
INSERT INTO `bcs_bills` VALUES ('378', '71', '1002900120140619123022203639', '2014-06-19 12:28:32', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '1', '1', '209.00', '30.00', '0.00', '179.00', '[订单交易-买家]-订单虚拟账户支付-交易');
INSERT INTO `bcs_bills` VALUES ('379', '1', '1002900120140619123022203639', '2014-06-19 12:28:32', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '3', '2', '9848.95', '30.00', '0.09', '9878.86', '[订单交易-卖家]-订单虚拟账户支付-交易');
INSERT INTO `bcs_bills` VALUES ('380', '76', '1003900120140619125936266313', '2014-06-19 12:58:19', '充值', '1', '', '', '2', '0.0', null, null, '1', '2', '0.00', '100.00', '0.00', '100.00', '账户资金充值');
INSERT INTO `bcs_bills` VALUES ('381', '76', '1001900120140619130336438949', '2014-06-19 13:02:03', '充值', '1', '', '', '2', '0.0', null, null, '1', '2', '100.00', '0.01', '0.00', '100.01', '订单交易-非虚拟账户完成的交易充值记录.');
INSERT INTO `bcs_bills` VALUES ('382', '76', '1001900120140619130336438949', '2014-06-19 13:02:03', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '1', '1', '100.01', '0.01', '0.00', '100.00', '[订单交易-买家]-订单支付-交易');
INSERT INTO `bcs_bills` VALUES ('383', '10', '1001900120140619130336438949', '2014-06-19 13:02:03', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '3', '2', '10.15', '0.01', '0.00', '10.16', '[订单交易-卖家]-订单支付-交易');
INSERT INTO `bcs_bills` VALUES ('384', '77', '1003900120140619132403474825', '2014-06-19 13:22:37', '充值', '1', '', '', '2', '0.0', null, null, '1', '2', '0.00', '100.00', '0.00', '100.00', '账户资金充值');
INSERT INTO `bcs_bills` VALUES ('385', '77', '1002900120140619133522832262', '2014-06-19 13:33:31', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '1', '1', '100.00', '20.00', '0.00', '80.00', '[订单交易-买家]-订单虚拟账户支付-交易');
INSERT INTO `bcs_bills` VALUES ('386', '1', '1002900120140619133522832262', '2014-06-19 13:33:31', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '3', '2', '9878.86', '20.00', '0.06', '9898.80', '[订单交易-卖家]-订单虚拟账户支付-交易');
INSERT INTO `bcs_bills` VALUES ('387', '71', '1002900120140619133932839548', '2014-06-19 13:37:41', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '1', '1', '179.00', '40.00', '0.00', '139.00', '[订单交易-买家]-订单虚拟账户支付-交易');
INSERT INTO `bcs_bills` VALUES ('388', '10', '1002900120140619133932839548', '2014-06-19 13:37:41', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '3', '2', '9898.80', '40.00', '0.12', '9938.68', '[订单交易-卖家]-订单虚拟账户支付-交易');
INSERT INTO `bcs_bills` VALUES ('399', '81', '1003900120140619143824225347', '2014-06-19 14:37:15', '充值', '1', '', '', '2', '0.0', null, null, '1', '2', '0.00', '100.00', '0.00', '100.00', '账户资金充值');
INSERT INTO `bcs_bills` VALUES ('400', '81', '1002900120140619144034681764', '2014-06-19 14:38:44', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '1', '1', '100.00', '30.00', '0.00', '70.00', '[订单交易-买家]-订单虚拟账户支付-交易');
INSERT INTO `bcs_bills` VALUES ('401', '1', '1002900120140619144034681764', '2014-06-19 14:38:45', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '3', '2', '9938.68', '30.00', '0.09', '9968.59', '[订单交易-卖家]-订单虚拟账户支付-交易');
INSERT INTO `bcs_bills` VALUES ('402', '81', '1002900120140619145228904142', '2014-06-19 14:50:38', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '1', '1', '70.00', '38.00', '0.00', '32.00', '[订单交易-买家]-订单虚拟账户支付-交易');
INSERT INTO `bcs_bills` VALUES ('403', '10', '1002900120140619145228904142', '2014-06-19 14:50:38', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '3', '2', '-189.84', '38.00', '0.11', '-151.95', '[订单交易-卖家]-订单虚拟账户支付-交易');
INSERT INTO `bcs_bills` VALUES ('404', '81', '0000000000000000000000000001', '2014-06-19 15:01:25', '交易撤销', '5', '1', '1', '2', '0', '2014-06-19 15:01:25', '402', '1', '2', '32.00', '38.00', '0.00', '70.00', '[交易撤销-买家]-针对ID[614]支付记录做交易撤销处理00000000000000000419');
INSERT INTO `bcs_bills` VALUES ('405', '10', '0000000000000000000000000001', '2014-06-19 15:01:25', '交易撤销', '5', '1', '1', '2', '0', '2014-06-19 15:01:25', '403', '3', '1', '-151.95', '38.11', '0.00', '-190.06', '[交易撤销-卖家]-针对ID[614]支付记录做交易撤销处理00000000000000000419');
INSERT INTO `bcs_bills` VALUES ('406', '73', '1002900120140619174028351292', '2014-06-19 17:38:41', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '1', '1', '60.00', '40.00', '0.00', '20.00', '[订单交易-买家]-订单虚拟账户支付-交易');
INSERT INTO `bcs_bills` VALUES ('407', '10', '1002900120140619174028351292', '2014-06-19 17:38:41', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '3', '2', '100000.00', '40.00', '0.12', '100039.88', '[订单交易-卖家]-订单虚拟账户支付-交易');
INSERT INTO `bcs_bills` VALUES ('408', '71', '1002900120140619181608789497', '2014-06-19 18:14:18', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '1', '1', '339.00', '70.00', '0.00', '269.00', '[订单交易-买家]-订单虚拟账户支付-交易');
INSERT INTO `bcs_bills` VALUES ('409', '10', '1002900120140619181608789497', '2014-06-19 18:14:18', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '3', '2', '100039.88', '70.00', '0.21', '100109.67', '[订单交易-卖家]-订单虚拟账户支付-交易');
INSERT INTO `bcs_bills` VALUES ('410', '71', '1002900120140620150135542682', '2014-06-20 15:06:55', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '1', '1', '269.00', '99.00', '0.00', '170.00', '[订单交易-买家]-订单虚拟账户支付-交易');
INSERT INTO `bcs_bills` VALUES ('411', '10', '1002900120140620150135542682', '2014-06-20 15:06:55', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '3', '2', '100109.67', '99.00', '0.30', '100208.37', '[订单交易-卖家]-订单虚拟账户支付-交易');
INSERT INTO `bcs_bills` VALUES ('412', '71', '1002900120140620151010991074', '2014-06-20 15:08:20', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '1', '1', '170.00', '99.00', '0.00', '71.00', '[订单交易-买家]-订单虚拟账户支付-交易');
INSERT INTO `bcs_bills` VALUES ('413', '10', '1002900120140620151010991074', '2014-06-20 15:08:20', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '3', '2', '100208.37', '99.00', '0.30', '100307.07', '[订单交易-卖家]-订单虚拟账户支付-交易');
INSERT INTO `bcs_bills` VALUES ('414', '71', '1003900120140620151602591217', '2014-06-20 15:14:48', '充值', '1', '', '', '2', '0.0', null, null, '1', '2', '71.00', '100.00', '0.00', '171.00', '账户资金充值');
INSERT INTO `bcs_bills` VALUES ('415', '71', '1001900120140620151930850341', '2014-06-25 15:17:49', '充值', '1', '', '', '2', '0.0', null, null, '1', '2', '171.00', '0.01', '0.00', '171.01', '订单交易-非虚拟账户完成的交易充值记录.');
INSERT INTO `bcs_bills` VALUES ('416', '71', '1001900120140620151930850341', '2014-06-20 15:17:49', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '1', '1', '171.01', '0.01', '0.00', '171.00', '[订单交易-买家]-订单支付-交易');
INSERT INTO `bcs_bills` VALUES ('417', '10', '1001900120140620151930850341', '2014-06-20 15:17:49', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '3', '2', '100307.07', '0.01', '0.00', '100307.08', '[订单交易-卖家]-订单支付-交易');
INSERT INTO `bcs_bills` VALUES ('418', '71', '1002900120140620154240820863', '2014-06-20 15:40:50', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '1', '1', '171.00', '158.00', '0.00', '13.00', '[订单交易-买家]-订单虚拟账户支付-交易');
INSERT INTO `bcs_bills` VALUES ('419', '10', '1002900120140620154240820863', '2014-06-20 15:40:50', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '3', '2', '100307.08', '158.00', '0.47', '100464.61', '[订单交易-卖家]-订单虚拟账户支付-交易');
INSERT INTO `bcs_bills` VALUES ('420', '90', '1002900120140626100133361662', '2014-06-26 09:59:39', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '1', '1', '555555.00', '40.00', '0.00', '555515.00', '[订单交易-买家]-订单虚拟账户支付-交易');
INSERT INTO `bcs_bills` VALUES ('421', '10', '1002900120140626100133361662', '2014-06-26 09:59:39', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '3', '2', '100464.61', '40.00', '0.12', '100504.49', '[订单交易-卖家]-订单虚拟账户支付-交易');
INSERT INTO `bcs_bills` VALUES ('426', '71', '1002900120140626113045965854', '2014-06-26 11:28:51', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '1', '1', '130000.00', '62.00', '0.00', '129938.00', '[订单交易-买家]-订单虚拟账户支付-交易');
INSERT INTO `bcs_bills` VALUES ('427', '10', '1002900120140626113045965854', '2014-06-26 11:28:51', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '3', '2', '100504.49', '62.00', '0.19', '100566.30', '[订单交易（即时下账）-卖家]-订单虚拟账户支付-交易');
INSERT INTO `bcs_bills` VALUES ('428', '71', '1002900120140626113302407185', '2014-06-26 11:31:06', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '1', '1', '129938.00', '119.00', '0.00', '129819.00', '[订单交易-买家]-订单虚拟账户支付-交易');
INSERT INTO `bcs_bills` VALUES ('429', '68', '1002900120140626113302407185', '2014-06-26 11:31:06', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '1', '2', '10.00', '118.64', '0.36', '128.64', '[订单交易-平台]-订单虚拟账户支付-交易');
INSERT INTO `bcs_bills` VALUES ('430', '71', '1003900120140626170642761121', '2014-06-26 17:05:16', '充值', '1', '', '', '2', '0.0', null, null, '1', '2', '129819.00', '100.00', '0.00', '129919.00', '账户资金充值');
INSERT INTO `bcs_bills` VALUES ('431', '71', '1001900120140626171112933616', '2014-06-30 17:09:44', '充值', '1', '', '', '2', '0.0', null, null, '1', '2', '129919.00', '0.01', '0.00', '129919.01', '订单交易-非虚拟账户完成的交易充值记录.');
INSERT INTO `bcs_bills` VALUES ('432', '71', '1001900120140626171112933616', '2014-06-26 17:09:44', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '1', '1', '129919.01', '0.01', '0.00', '129919.00', '[订单交易-买家]-订单支付-交易');
INSERT INTO `bcs_bills` VALUES ('433', '68', '1001900120140626171112933616', '2014-06-26 17:09:44', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '1', '2', '128.64', '0.01', '0.00', '128.65', '[订单交易-平台]-订单支付-交易');
INSERT INTO `bcs_bills` VALUES ('434', '71', '1002900120140701091256364149', '2014-07-01 09:10:59', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '1', '1', '129919.00', '62.00', '0.00', '129857.00', '[订单交易-买家]-订单虚拟账户支付-交易');
INSERT INTO `bcs_bills` VALUES ('435', '68', '1002900120140701091256364149', '2014-07-01 09:10:59', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '1', '2', '128.65', '61.81', '0.19', '190.46', '[订单交易-平台]-订单虚拟账户支付-交易');
INSERT INTO `bcs_bills` VALUES ('436', '92', '1003900120140701110823745928', '2014-07-01 11:07:38', '充值', '1', '', '', '2', '0.0', null, null, '1', '2', '0.00', '100.00', '0.00', '100.00', '账户资金充值');
INSERT INTO `bcs_bills` VALUES ('437', '92', '1002900120140701111134539469', '2014-07-01 11:09:35', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '1', '1', '100.00', '30.00', '0.00', '70.00', '[订单交易-买家]-订单虚拟账户支付-交易');
INSERT INTO `bcs_bills` VALUES ('438', '68', '1002900120140701111134539469', '2014-07-01 11:09:35', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '1', '2', '190.46', '29.91', '0.09', '220.37', '[订单交易-平台]-订单虚拟账户支付-交易');
INSERT INTO `bcs_bills` VALUES ('439', '71', '1002900120140702171851944029', '2014-07-02 17:16:53', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '1', '1', '129857.00', '30.00', '0.00', '129827.00', '[订单交易-买家]-订单虚拟账户支付-交易');
INSERT INTO `bcs_bills` VALUES ('440', '68', '1002900120140702171851944029', '2014-07-02 17:16:53', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '1', '2', '220.37', '29.91', '0.09', '250.28', '[订单交易-平台]-订单虚拟账户支付-交易');
INSERT INTO `bcs_bills` VALUES ('441', '46', '1002900120140709162122836945', '2014-07-09 16:19:47', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '1', '1', '1237528.00', '62.00', '0.00', '1237466.00', '[订单交易-买家]-订单虚拟账户支付-交易');
INSERT INTO `bcs_bills` VALUES ('442', '68', '1002900120140709162122836945', '2014-07-09 16:19:47', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '1', '2', '250.28', '61.81', '0.19', '312.09', '[订单交易-平台]-订单虚拟账户支付-交易');
INSERT INTO `bcs_bills` VALUES ('443', '1000000114', '1003900120140721141001277499', '2014-07-21 14:12:25', '充值', '1', '', '', '2', '0.0', null, null, '1', '2', '0.00', '100.00', '0.00', '100.00', '账户资金充值');
INSERT INTO `bcs_bills` VALUES ('444', '1000000114', '1002900120140721141439404345', '2014-07-21 14:14:37', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '1', '1', '100.00', '12.00', '0.00', '88.00', '[订单交易-买家]-订单虚拟账户支付-交易');
INSERT INTO `bcs_bills` VALUES ('445', '68', '1002900120140721141439404345', '2014-07-21 14:14:37', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '1', '2', '312.09', '11.96', '0.04', '324.05', '[订单交易-平台]-订单虚拟账户支付-交易');
INSERT INTO `bcs_bills` VALUES ('446', '1000000114', '1001900120140721141545253527', '2014-07-21 14:16:09', '充值', '1', '', '', '2', '0.0', null, null, '1', '2', '88.00', '0.01', '0.00', '88.01', '订单交易-非虚拟账户完成的交易充值记录.');
INSERT INTO `bcs_bills` VALUES ('447', '1000000114', '1001900120140721141545253527', '2014-07-21 14:16:09', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '1', '1', '88.01', '0.01', '0.00', '88.00', '[订单交易-买家]-订单支付-交易');
INSERT INTO `bcs_bills` VALUES ('448', '68', '1001900120140721141545253527', '2014-07-21 14:16:09', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '1', '2', '324.05', '0.01', '0.00', '324.06', '[订单交易-平台]-订单支付-交易');
INSERT INTO `bcs_bills` VALUES ('449', '1000000115', '1001900120140722093858798129', '2014-07-22 09:39:10', '充值', '1', '', '', '2', '0.0', null, null, '1', '2', '0.00', '0.01', '0.00', '0.01', '订单交易-非虚拟账户完成的交易充值记录.');
INSERT INTO `bcs_bills` VALUES ('450', '1000000115', '1001900120140722093858798129', '2014-07-22 09:39:10', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '1', '1', '0.01', '0.01', '0.00', '0.00', '[订单交易-买家]-订单支付-交易');
INSERT INTO `bcs_bills` VALUES ('451', '10', '1001900120140722093858798129', '2014-07-22 09:39:10', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '1', '2', '100566.30', '0.01', '0.00', '100566.31', '[订单交易（即时下账）-卖家]-订单支付-交易');
INSERT INTO `bcs_bills` VALUES ('452', '1000000117', '1003900120140730090103736647', '2014-07-30 09:00:02', '充值', '1', '', '', '2', '0.0', null, null, '1', '2', '0.00', '100.00', '0.00', '100.00', '账户资金充值');
INSERT INTO `bcs_bills` VALUES ('453', '1000000117', '1002900120140806125026751924', '2014-08-06 12:48:53', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '1', '1', '100.00', '40.00', '0.00', '60.00', '[订单交易-买家]-订单虚拟账户支付-交易');
INSERT INTO `bcs_bills` VALUES ('454', '10', '1002900120140806125026751924', '2014-08-06 12:48:53', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '1', '2', '100566.31', '40.00', '0.12', '100606.19', '[订单交易（即时下账）-卖家]-订单虚拟账户支付-交易');
INSERT INTO `bcs_bills` VALUES ('455', '1000000117', '1003900120140806125146988064', '2014-08-06 12:51:14', '充值', '1', '', '', '2', '0.0', null, null, '1', '2', '60.00', '100.00', '0.00', '160.00', '账户资金充值');
INSERT INTO `bcs_bills` VALUES ('456', '1000000115', '1001900120140806132316246819', '2014-08-06 13:22:01', '充值', '1', '', '', '2', '0.0', null, null, '1', '2', '0.00', '0.01', '0.00', '0.01', '订单交易-非虚拟账户完成的交易充值记录.');
INSERT INTO `bcs_bills` VALUES ('457', '1000000115', '1001900120140806132316246819', '2014-08-06 13:22:01', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '1', '1', '0.01', '0.01', '0.00', '0.00', '[订单交易-买家]-订单支付-交易');
INSERT INTO `bcs_bills` VALUES ('458', '10', '1001900120140806132316246819', '2014-08-06 13:22:01', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '1', '2', '100606.19', '0.01', '0.00', '100606.20', '[订单交易（即时下账）-卖家]-订单支付-交易');
INSERT INTO `bcs_bills` VALUES ('459', '71', '1005900120140813173545401692', '2014-08-13 17:35:31', '充值', '1', '', '', '2', '0.0', null, null, '1', '2', '129827.00', '0.01', '0.00', '129827.01', '订单交易-非虚拟账户完成的交易充值记录.');
INSERT INTO `bcs_bills` VALUES ('460', '71', '1005900120140813173545401692', '2014-08-13 17:35:31', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '1', '1', '129827.01', '0.01', '0.00', '129827.00', '[订单交易-买家]-订单支付-交易');
INSERT INTO `bcs_bills` VALUES ('461', '10', '1005900120140813173545401692', '2014-08-13 17:35:31', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '1', '2', '100606.20', '0.01', '0.00', '100606.21', '[订单交易（即时下账）-卖家]-订单支付-交易');
INSERT INTO `bcs_bills` VALUES ('462', '71', '1001900120140813173836340197', '2014-08-13 17:37:13', '充值', '1', '', '', '2', '0.0', null, null, '1', '2', '129827.00', '0.01', '0.00', '129827.01', '订单交易-非虚拟账户完成的交易充值记录.');
INSERT INTO `bcs_bills` VALUES ('463', '71', '1001900120140813173836340197', '2014-08-13 17:37:13', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '1', '1', '129827.01', '0.01', '0.00', '129827.00', '[订单交易-买家]-订单支付-交易');
INSERT INTO `bcs_bills` VALUES ('464', '10', '1001900120140813173836340197', '2014-08-13 17:37:13', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '1', '2', '100606.21', '0.01', '0.00', '100606.22', '[订单交易（即时下账）-卖家]-订单支付-交易');
INSERT INTO `bcs_bills` VALUES ('465', '71', '1002900120140813174327569975', '2014-08-13 17:41:36', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '1', '1', '129827.00', '60.00', '0.00', '129767.00', '[订单交易-买家]-订单虚拟账户支付-交易');
INSERT INTO `bcs_bills` VALUES ('466', '10', '1002900120140813174327569975', '2014-08-13 17:41:36', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '1', '2', '100606.22', '60.00', '0.18', '100666.04', '[订单交易（即时下账）-卖家]-订单虚拟账户支付-交易');
INSERT INTO `bcs_bills` VALUES ('467', '71', '1005900120140813173545401692', '2014-08-13 17:51:31', '充值', '1', '', '', '2', '0.0', null, null, '1', '2', '129767.00', '0.01', '0.00', '129767.01', '订单交易-非虚拟账户完成的交易充值记录.');
INSERT INTO `bcs_bills` VALUES ('468', '71', '1005900120140813173545401692', '2014-08-13 17:51:31', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '1', '1', '129767.01', '0.01', '0.00', '129767.00', '[订单交易-买家]-订单支付-交易');
INSERT INTO `bcs_bills` VALUES ('469', '10', '1005900120140813173545401692', '2014-08-13 17:51:31', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '1', '2', '100666.04', '0.01', '0.00', '100666.05', '[订单交易（即时下账）-卖家]-订单支付-交易');
INSERT INTO `bcs_bills` VALUES ('470', '71', '1001900120140813180730800902', '2014-08-13 18:06:13', '充值', '1', '', '', '2', '0.0', null, null, '1', '2', '129767.00', '0.01', '0.00', '129767.01', '订单交易-非虚拟账户完成的交易充值记录.');
INSERT INTO `bcs_bills` VALUES ('471', '71', '1001900120140813180730800902', '2014-08-13 18:06:13', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '1', '1', '129767.01', '0.01', '0.00', '129767.00', '[订单交易-买家]-订单支付-交易');
INSERT INTO `bcs_bills` VALUES ('472', '10', '1001900120140813180730800902', '2014-08-13 18:06:13', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '1', '2', '100666.05', '0.01', '0.00', '100666.06', '[订单交易（即时下账）-卖家]-订单支付-交易');
INSERT INTO `bcs_bills` VALUES ('473', '71', '1005900120140813173545401692', '2014-08-13 18:07:31', '充值', '1', '', '', '2', '0.0', null, null, '1', '2', '129767.00', '0.01', '0.00', '129767.01', '订单交易-非虚拟账户完成的交易充值记录.');
INSERT INTO `bcs_bills` VALUES ('474', '71', '1005900120140813173545401692', '2014-08-13 18:07:31', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '1', '1', '129767.01', '0.01', '0.00', '129767.00', '[订单交易-买家]-订单支付-交易');
INSERT INTO `bcs_bills` VALUES ('475', '10', '1005900120140813173545401692', '2014-08-13 18:07:31', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '1', '2', '100666.06', '0.01', '0.00', '100666.07', '[订单交易（即时下账）-卖家]-订单支付-交易');
INSERT INTO `bcs_bills` VALUES ('476', '71', '1005900120140813173545401692', '2014-08-13 21:35:30', '充值', '1', '', '', '2', '0.0', null, null, '1', '2', '129767.00', '0.01', '0.00', '129767.01', '订单交易-非虚拟账户完成的交易充值记录.');
INSERT INTO `bcs_bills` VALUES ('477', '71', '1005900120140813173545401692', '2014-08-13 21:35:30', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '1', '1', '129767.01', '0.01', '0.00', '129767.00', '[订单交易-买家]-订单支付-交易');
INSERT INTO `bcs_bills` VALUES ('478', '10', '1005900120140813173545401692', '2014-08-13 21:35:30', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '1', '2', '100666.07', '0.01', '0.00', '100666.08', '[订单交易（即时下账）-卖家]-订单支付-交易');
INSERT INTO `bcs_bills` VALUES ('479', '71', '1005900120140813173545401692', '2014-08-14 01:35:30', '充值', '1', '', '', '2', '0.0', null, null, '1', '2', '129767.00', '0.01', '0.00', '129767.01', '订单交易-非虚拟账户完成的交易充值记录.');
INSERT INTO `bcs_bills` VALUES ('480', '71', '1005900120140813173545401692', '2014-08-14 01:35:30', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '1', '1', '129767.01', '0.01', '0.00', '129767.00', '[订单交易-买家]-订单支付-交易');
INSERT INTO `bcs_bills` VALUES ('481', '10', '1005900120140813173545401692', '2014-08-14 01:35:30', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '1', '2', '100666.08', '0.01', '0.00', '100666.09', '[订单交易（即时下账）-卖家]-订单支付-交易');
INSERT INTO `bcs_bills` VALUES ('482', '71', '1001900120140814093029940002', '2014-08-14 09:29:18', '充值', '1', '', '', '2', '0.0', null, null, '1', '2', '129767.00', '0.01', '0.00', '129767.01', '订单交易-非虚拟账户完成的交易充值记录.');
INSERT INTO `bcs_bills` VALUES ('483', '71', '1001900120140814093029940002', '2014-08-14 09:29:18', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '1', '1', '129767.01', '0.01', '0.00', '129767.00', '[订单交易-买家]-订单支付-交易');
INSERT INTO `bcs_bills` VALUES ('484', '10', '1001900120140814093029940002', '2014-08-14 09:29:18', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '1', '2', '100666.09', '0.01', '0.00', '100666.10', '[订单交易（即时下账）-卖家]-订单支付-交易');
INSERT INTO `bcs_bills` VALUES ('485', '71', '1005900120140813173545401692', '2014-08-14 09:35:30', '充值', '1', '', '', '2', '0.0', null, null, '1', '2', '129767.00', '0.01', '0.00', '129767.01', '订单交易-非虚拟账户完成的交易充值记录.');
INSERT INTO `bcs_bills` VALUES ('486', '71', '1005900120140813173545401692', '2014-08-14 09:35:30', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '1', '1', '129767.01', '0.01', '0.00', '129767.00', '[订单交易-买家]-订单支付-交易');
INSERT INTO `bcs_bills` VALUES ('487', '10', '1005900120140813173545401692', '2014-08-14 09:35:30', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '1', '2', '100666.10', '0.01', '0.00', '100666.11', '[订单交易（即时下账）-卖家]-订单支付-交易');
INSERT INTO `bcs_bills` VALUES ('488', '71', '1005900120140814100450973293', '2014-08-14 10:04:51', '充值', '1', '', '', '2', '0.0', null, null, '1', '2', '129767.00', '0.01', '0.00', '129767.01', '订单交易-非虚拟账户完成的交易充值记录.');
INSERT INTO `bcs_bills` VALUES ('489', '71', '1005900120140814100450973293', '2014-08-14 10:04:51', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '1', '1', '129767.01', '0.01', '0.00', '129767.00', '[订单交易-买家]-订单支付-交易');
INSERT INTO `bcs_bills` VALUES ('490', '10', '1005900120140814100450973293', '2014-08-14 10:04:51', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '1', '2', '100666.11', '0.01', '0.00', '100666.12', '[订单交易（即时下账）-卖家]-订单支付-交易');
INSERT INTO `bcs_bills` VALUES ('491', '71', '1001900120140814101326335540', '2014-08-14 10:13:11', '充值', '1', '', '', '2', '0.0', null, null, '1', '2', '129767.00', '0.01', '0.00', '129767.01', '订单交易-非虚拟账户完成的交易充值记录.');
INSERT INTO `bcs_bills` VALUES ('492', '71', '1001900120140814101326335540', '2014-08-14 10:13:11', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '1', '1', '129767.01', '0.01', '0.00', '129767.00', '[订单交易-买家]-订单支付-交易');
INSERT INTO `bcs_bills` VALUES ('493', '10', '1001900120140814101326335540', '2014-08-14 10:13:11', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '1', '2', '100666.12', '0.01', '0.00', '100666.13', '[订单交易（即时下账）-卖家]-订单支付-交易');
INSERT INTO `bcs_bills` VALUES ('494', '71', '1005900120140814100450973293', '2014-08-14 10:20:51', '充值', '1', '', '', '2', '0.0', null, null, '1', '2', '129767.00', '0.01', '0.00', '129767.01', '订单交易-非虚拟账户完成的交易充值记录.');
INSERT INTO `bcs_bills` VALUES ('495', '71', '1005900120140814100450973293', '2014-08-14 10:20:51', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '1', '1', '129767.01', '0.01', '0.00', '129767.00', '[订单交易-买家]-订单支付-交易');
INSERT INTO `bcs_bills` VALUES ('496', '10', '1005900120140814100450973293', '2014-08-14 10:20:51', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '1', '2', '100666.13', '0.01', '0.00', '100666.14', '[订单交易（即时下账）-卖家]-订单支付-交易');
INSERT INTO `bcs_bills` VALUES ('497', '71', '1005900120140814100450973293', '2014-08-14 10:36:51', '充值', '1', '', '', '2', '0.0', null, null, '1', '2', '129767.00', '0.01', '0.00', '129767.01', '订单交易-非虚拟账户完成的交易充值记录.');
INSERT INTO `bcs_bills` VALUES ('498', '71', '1005900120140814100450973293', '2014-08-14 10:36:51', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '1', '1', '129767.01', '0.01', '0.00', '129767.00', '[订单交易-买家]-订单支付-交易');
INSERT INTO `bcs_bills` VALUES ('499', '10', '1005900120140814100450973293', '2014-08-14 10:36:51', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '1', '2', '100666.14', '0.01', '0.00', '100666.15', '[订单交易（即时下账）-卖家]-订单支付-交易');
INSERT INTO `bcs_bills` VALUES ('500', '71', '1005900120140814100450973293', '2014-08-14 14:04:50', '充值', '1', '', '', '2', '0.0', null, null, '1', '2', '129767.00', '0.01', '0.00', '129767.01', '订单交易-非虚拟账户完成的交易充值记录.');
INSERT INTO `bcs_bills` VALUES ('501', '71', '1005900120140814100450973293', '2014-08-14 14:04:50', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '1', '1', '129767.01', '0.01', '0.00', '129767.00', '[订单交易-买家]-订单支付-交易');
INSERT INTO `bcs_bills` VALUES ('502', '10', '1005900120140814100450973293', '2014-08-14 14:04:50', '订单交易（勿删）', '3', '2', '2', '2', '0.3', null, null, '1', '2', '100666.15', '0.01', '0.00', '100666.16', '[订单交易（即时下账）-卖家]-订单支付-交易');
INSERT INTO `bcs_bills` VALUES ('503', '71', '1005900120140814100450973293', '2014-08-14 18:04:50', '充值', '1', '', '', '2', '0.0', null, null, '1', '2', '129767.00', '0.01', '0.00', '129767.01', '订单交易-非虚拟账户完成的交易充值记录.');
INSERT INTO `bcs_bills` VALUES ('504', '71', '1005900120140814100450973293', '2014-08-14 18:04:50', '订单交易（勿删）', '3', '1', '1', '2', '0.3', null, null, '1', '1', '129767.01', '0.01', '0.00', '129767.00', '[订单交易-买家]-订单支付-交易');
INSERT INTO `bcs_bills` VALUES ('505', '10', '1005900120140814100450973293', '2014-08-14 18:04:50', '订单交易（勿删）', '3', '1', '1', '2', '0.3', null, null, '1', '2', '100666.16', '0.01', '0.00', '100666.17', '[订单交易（即时下账）-卖家]-订单支付-交易');
INSERT INTO `bcs_bills` VALUES ('506', '71', '1005900120140814100450973293', '2014-08-15 02:04:50', '充值', '1', '', '', '2', '0.0', null, null, '1', '2', '129767.00', '0.01', '0.00', '129767.01', '订单交易-非虚拟账户完成的交易充值记录.');
INSERT INTO `bcs_bills` VALUES ('507', '71', '1005900120140814100450973293', '2014-08-15 02:04:50', '订单交易（勿删）', '3', '1', '1', '2', '0.3', null, null, '1', '1', '129767.01', '0.01', '0.00', '129767.00', '[订单交易-买家]-订单支付-交易');
INSERT INTO `bcs_bills` VALUES ('508', '10', '1005900120140814100450973293', '2014-08-15 02:04:50', '订单交易（勿删）', '3', '1', '1', '2', '0.3', null, null, '1', '2', '100666.17', '0.01', '0.00', '100666.18', '[订单交易（即时下账）-卖家]-订单支付-交易');
INSERT INTO `bcs_bills` VALUES ('509', '71', '1001900120140815145917306120', '2014-08-15 14:57:58', '充值', '1', '', '', '2', '0.0', null, null, '1', '2', '129767.00', '0.01', '0.00', '129767.01', '订单交易-非虚拟账户完成的交易充值记录.');
INSERT INTO `bcs_bills` VALUES ('510', '71', '1001900120140815145917306120', '2014-08-15 14:57:58', '订单交易（勿删）', '3', '1', '1', '2', '0.3', null, null, '1', '1', '129767.01', '0.01', '0.00', '129767.00', '[订单交易-买家]-订单支付-交易');
INSERT INTO `bcs_bills` VALUES ('511', '10', '1001900120140815145917306120', '2014-08-15 14:57:58', '订单交易（勿删）', '3', '1', '1', '2', '0.3', null, null, '1', '2', '100666.18', '0.01', '0.00', '100666.19', '[订单交易（即时下账）-卖家]-订单支付-交易');
INSERT INTO `bcs_bills` VALUES ('512', '71', '1001900120140819144207471056', '2014-08-19 14:41:00', '充值', '1', '', '', '2', '0.0', null, null, '1', '2', '129767.00', '0.01', '0.00', '129767.01', '订单交易-非虚拟账户完成的交易充值记录.');
INSERT INTO `bcs_bills` VALUES ('513', '71', '1001900120140819144207471056', '2014-08-19 14:41:00', '订单交易（勿删）', '3', '1', '1', '2', '0.3', null, null, '1', '1', '129767.01', '0.01', '0.00', '129767.00', '[订单交易-买家]-订单支付-交易');
INSERT INTO `bcs_bills` VALUES ('514', '10', '1001900120140819144207471056', '2014-08-19 14:41:00', '订单交易（勿删）', '3', '1', '1', '2', '0.3', null, null, '1', '2', '100666.19', '0.01', '0.00', '100666.20', '[订单交易（即时下账）-卖家]-订单支付-交易');
INSERT INTO `bcs_bills` VALUES ('515', '33', '1002900120140822140656370395', '2014-08-22 14:06:07', '订单交易（勿删）', '3', '1', '1', '2', '0.3', null, null, '1', '1', '237615.00', '40.00', '0.12', '237574.88', '[订单交易-买家]-订单虚拟账户支付-交易');
INSERT INTO `bcs_bills` VALUES ('516', '10', '1002900120140822140656370395', '2014-08-22 14:06:07', '订单交易（勿删）', '3', '1', '1', '2', '0.3', null, null, '1', '2', '100666.20', '40.00', '0.00', '100706.20', '[订单交易（即时下账）-卖家]-订单虚拟账户支付-交易');
INSERT INTO `bcs_bills` VALUES ('517', '33', '1002900120140822141213488165', '2014-08-22 14:10:15', '订单交易（勿删）', '3', '1', '1', '2', '0.3', null, null, '1', '1', '237574.88', '40.00', '0.12', '237534.76', '[订单交易-买家]-订单虚拟账户支付-交易');
INSERT INTO `bcs_bills` VALUES ('518', '10', '1002900120140822141213488165', '2014-08-22 14:10:15', '订单交易（勿删）', '3', '1', '1', '2', '0.3', null, null, '1', '2', '100706.20', '40.00', '0.00', '100746.20', '[订单交易（即时下账）-卖家]-订单虚拟账户支付-交易');

-- ----------------------------
-- Table structure for `bcs_business_code`
-- ----------------------------
DROP TABLE IF EXISTS `bcs_business_code`;
CREATE TABLE `bcs_business_code` (
  `business_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '业务代码编号ID',
  `business_name` varchar(50) DEFAULT NULL COMMENT '业务名称',
  `business_type` int(10) NOT NULL COMMENT '业务类型 1-虚拟结算交易  2-AB结算交易  3-普通交易  4-单方资金结算交易',
  `status` int(2) NOT NULL COMMENT '业务状态 1-正常  0-注销',
  `is_system` int(2) NOT NULL COMMENT '是否是系统定义 1-是 2-否',
  `settle_strategy_id` int(10) DEFAULT NULL COMMENT '结算代码编号',
  `code_id` int(10) DEFAULT NULL COMMENT '计费代码编号',
  `son_business` int(2) DEFAULT NULL COMMENT '手续费计收子业务 1-付款业务  2-卖家下账  3-卖家资金结算',
  `is_intime` int(4) DEFAULT NULL COMMENT '是否及时到账（虚拟账户） 1 - 是  2 - 否',
  `business_desc` varchar(200) DEFAULT NULL COMMENT '业务信息描述',
  PRIMARY KEY (`business_id`),
  KEY `FK_Reference_1` (`code_id`)
) ENGINE=InnoDB AUTO_INCREMENT=100012 DEFAULT CHARSET=utf8 COMMENT='支付清结算业务信息表';

-- ----------------------------
-- Records of bcs_business_code
-- ----------------------------
INSERT INTO `bcs_business_code` VALUES ('1', '充值', '3', '1', '1', null, '10000005', null, '1', '暂无');
INSERT INTO `bcs_business_code` VALUES ('2', '提现', '4', '1', '1', '11000001', '10000001', null, '1', '暂无');
INSERT INTO `bcs_business_code` VALUES ('3', '订单交易（勿删）', '2', '1', '2', '11000002', '10000004', '1', '1', '暂无');
INSERT INTO `bcs_business_code` VALUES ('4', '转账', '4', '1', '1', '1', '1', '1', null, null);
INSERT INTO `bcs_business_code` VALUES ('5', '交易撤销', '3', '1', '1', null, '7', '1', null, null);
INSERT INTO `bcs_business_code` VALUES ('6', '交易1', '1', '0', '2', null, '1', null, null, null);
INSERT INTO `bcs_business_code` VALUES ('7', '测试1', '3', '1', '2', null, '1', '1', null, null);
INSERT INTO `bcs_business_code` VALUES ('8', '（测试）新增充值业务', '2', '1', '1', '1', '1', '1', null, null);
INSERT INTO `bcs_business_code` VALUES ('100009', '冻结', '3', '1', '1', null, null, null, null, '暂无');
INSERT INTO `bcs_business_code` VALUES ('100010', 'test5', '3', '0', '2', null, '3', null, '1', null);
INSERT INTO `bcs_business_code` VALUES ('100011', 'tssssasd', '3', '1', '2', null, '1', null, '1', null);

-- ----------------------------
-- Table structure for `bcs_client_infos`
-- ----------------------------
DROP TABLE IF EXISTS `bcs_client_infos`;
CREATE TABLE `bcs_client_infos` (
  `CLIENT_ID` int(100) NOT NULL AUTO_INCREMENT COMMENT '客户端编号ID',
  `CLIENT_PUB_KEY` varchar(500) NOT NULL COMMENT '客户端携带公钥',
  `STATUS` int(4) NOT NULL DEFAULT '1' COMMENT '客户端有效状态 1 有效 2 无效 99 已注销',
  `CLIENT_NAME` varchar(100) NOT NULL COMMENT '客户端名称',
  PRIMARY KEY (`CLIENT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9018 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bcs_client_infos
-- ----------------------------
INSERT INTO `bcs_client_infos` VALUES ('9001', 'MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCueEWO8qPU5uhtH1DQRTCHCTpKfVzkDrkZrFzmlpU1dSE4sfUcKZEkDVtwBjO4NUwXud00R7d1II4cZ8NQTU5XutQ8W8ZLJjGU6o3RAKY4RA/IdPjChZzSE76pGIOo/Wx82ADs6EkAJpLbmewg78cwM2jo+6rIGdQRhpyQeJchDwIDAQAB', '1', '测试客户端（勿删）');
INSERT INTO `bcs_client_infos` VALUES ('9002', 'no', '2', 'baixs');
INSERT INTO `bcs_client_infos` VALUES ('9003', 'safvavadfvavasdv', '2', 'test');
INSERT INTO `bcs_client_infos` VALUES ('9004', '222222', '2', 'qwwe');
INSERT INTO `bcs_client_infos` VALUES ('9005', '11111111111111', '2', 'qwwe');
INSERT INTO `bcs_client_infos` VALUES ('9006', '11111111111111', '2', 'qwwe');
INSERT INTO `bcs_client_infos` VALUES ('9007', '222222', '2', 'qwwe');
INSERT INTO `bcs_client_infos` VALUES ('9008', '12312s21s12s33333', '99', 'test1');
INSERT INTO `bcs_client_infos` VALUES ('9009', '等待系统分配密钥值.', '2', '测试平台接入功能');
INSERT INTO `bcs_client_infos` VALUES ('9010', 'IJCDInISDCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCueEWO8qPU5uhtH1DQRTCHCTpKfVzkDrkZrFzmlpU1dSE4sfUcKZEkDVtwBjO4NUwXud00R7d1II4cZ8NQTU5XutQ8W8ZLJjGU6o3RAKY4RA/IdPjChZzSE76pGIOo/Wx82ADs6EkAJpLbmewg78cwM2j3', '1', '长德商超平台');
INSERT INTO `bcs_client_infos` VALUES ('9011', 'IJCDInISDCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCueEWO8qPU5uhtH1DQRTCHCTpKfVzkDrkZrFzmlpU1dSE4sfUcKZEkJUtwBjO4NUwXud00R7d1II4cZ8NQTU5XutQ8W8ZLJjGU6o3RAKY4RA/IdPjChZzSE76pGIOo/Wx82ADs6EkAJpLbmewg78cwM2j3', '1', '4+1平台系统');
INSERT INTO `bcs_client_infos` VALUES ('9012', '1112额', '2', '阿斯蒂芬');
INSERT INTO `bcs_client_infos` VALUES ('9013', '试试萨斯城市dasd', '1', '四十四的打算打');
INSERT INTO `bcs_client_infos` VALUES ('9014', '11111', '1', '测试1213232312312312');
INSERT INTO `bcs_client_infos` VALUES ('9015', 'eqwe', '2', '2哇13');
INSERT INTO `bcs_client_infos` VALUES ('9016', '31231231213213', '1', '231231');
INSERT INTO `bcs_client_infos` VALUES ('9017', '等待系统分配密钥值.', '1', 'eqwewqeqwq');

-- ----------------------------
-- Table structure for `bcs_daily_check`
-- ----------------------------
DROP TABLE IF EXISTS `bcs_daily_check`;
CREATE TABLE `bcs_daily_check` (
  `daily_check_id` int(10) NOT NULL AUTO_INCREMENT,
  `account_out` double(10,2) NOT NULL DEFAULT '0.00' COMMENT '总账支出',
  `account_in` double(10,2) NOT NULL DEFAULT '0.00' COMMENT '总账收入',
  `settle_out` double(10,2) NOT NULL DEFAULT '0.00' COMMENT '结算支出',
  `settle_in` double(10,2) NOT NULL DEFAULT '0.00' COMMENT '结算收入',
  `out_diff` double(10,2) NOT NULL DEFAULT '0.00' COMMENT '支出差异',
  `in_diff` double(10,2) NOT NULL DEFAULT '0.00' COMMENT '收入差异',
  `check_time` date NOT NULL COMMENT '对账时间',
  `account_total_balance` double(10,2) NOT NULL DEFAULT '0.00' COMMENT '总账余额',
  `settle_total_balance` double(10,2) NOT NULL DEFAULT '0.00' COMMENT '结算账户余额',
  `status` int(4) NOT NULL COMMENT '状态 0-待确认，1-已确认 ,2-差异处理中',
  `isdiff` int(4) NOT NULL DEFAULT '0' COMMENT '是否差异 0-无差异，1-有差异',
  PRIMARY KEY (`daily_check_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bcs_daily_check
-- ----------------------------
INSERT INTO `bcs_daily_check` VALUES ('1', '123.00', '122.00', '123.00', '121.00', '0.00', '1.00', '2014-07-08', '10000.00', '9999.00', '1', '0');
INSERT INTO `bcs_daily_check` VALUES ('2', '100.00', '99.00', '100.00', '100.00', '0.00', '1.00', '2014-07-09', '2222222.00', '1233.00', '1', '1');

-- ----------------------------
-- Table structure for `bcs_freeze_bills`
-- ----------------------------
DROP TABLE IF EXISTS `bcs_freeze_bills`;
CREATE TABLE `bcs_freeze_bills` (
  `freeze_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '冻结清单编号ID',
  `account_id` int(10) NOT NULL COMMENT '虚拟账户ID',
  `opt_num` varchar(50) NOT NULL COMMENT '操作流水号OPTNUM',
  `freeze_balance` double(10,2) NOT NULL COMMENT '冻结金额',
  `freeze_time` datetime NOT NULL COMMENT '冻结时间',
  `freeze_type` int(2) DEFAULT NULL COMMENT '冻结类型（保留字段）',
  `status` int(2) NOT NULL COMMENT '1--已冻结   2--已解冻',
  `lock_key` varchar(50) DEFAULT NULL COMMENT '锁定Key值',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`freeze_id`),
  KEY `FK_Reference_4` (`account_id`),
  CONSTRAINT `FK_Reference_4` FOREIGN KEY (`account_id`) REFERENCES `bcs_account` (`account_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='账户冻结清单';

-- ----------------------------
-- Records of bcs_freeze_bills
-- ----------------------------
INSERT INTO `bcs_freeze_bills` VALUES ('2', '1', '100000001', '1000.00', '2014-05-27 09:37:04', null, '0', 'U7s8cHHwei9923UUwcnnweuUUwciUUU', '担保交易-购物');
INSERT INTO `bcs_freeze_bills` VALUES ('3', '1', '100000001', '815.00', '2014-05-27 09:39:58', null, '0', 'U7s8cHHwei9923UUwcnnweuUUwciUUU', '担保交易-购物');
INSERT INTO `bcs_freeze_bills` VALUES ('4', '1', '100000001', '1000.00', '2014-05-27 09:40:46', null, '0', 'U7s8cHHwei9923UUwcnnweuUUwciUUU', '担保交易-购物');
INSERT INTO `bcs_freeze_bills` VALUES ('5', '33', '100000001', '1000.00', '2014-05-27 09:41:47', null, '0', 'U7s8cHHwei9923UUwcnnweuUUwciUUU', '担保交易-购物');
INSERT INTO `bcs_freeze_bills` VALUES ('6', '33', '100000001', '1000.00', '2014-05-27 09:41:52', null, '0', 'U7s8cHHwei9923UUwcnnweuUUwciUUU', '担保交易-购物');
INSERT INTO `bcs_freeze_bills` VALUES ('7', '45', '100000001', '1000.00', '2014-05-27 09:42:01', null, '0', 'U7s8cHHwei9923UUwcnnweuUUwciUUU', '担保交易-购物');
INSERT INTO `bcs_freeze_bills` VALUES ('8', '45', '100000001', '1000.00', '2014-05-27 09:42:06', null, '0', 'U7s8cHHwei9923UUwcnnweuUUwciUUU', '担保交易-购物');
INSERT INTO `bcs_freeze_bills` VALUES ('9', '45', '100000001', '6000.00', '2014-05-27 09:42:14', null, '0', 'U7s8cHHwei9923UUwcnnweuUUwciUUU', '担保交易-购物');
INSERT INTO `bcs_freeze_bills` VALUES ('10', '1', '100000110', '200.00', '2014-05-28 14:59:11', null, '0', 'U7s8cHHwei9923UUwcnnweuUUwciUUU', 'FSGz账务服务网关冻结');
INSERT INTO `bcs_freeze_bills` VALUES ('11', '1', '100000110', '200.00', '2014-05-28 15:11:14', null, '0', 'U7s8cHHwei9923UUwcnnweuUUwciUUU', 'FSGz账务服务网关冻结');
INSERT INTO `bcs_freeze_bills` VALUES ('12', '1', '100000110', '200.00', '2014-05-28 15:19:17', null, '0', 'U7s8cHHwei9923UUwcnnweuUUwciUUU', 'FSGz账务服务网关冻结');
INSERT INTO `bcs_freeze_bills` VALUES ('13', '10', '000000000100', '61.81', '2014-07-01 17:31:21', '1', '1', '', '待下账账单下账操作');

-- ----------------------------
-- Table structure for `bcs_hand_tip`
-- ----------------------------
DROP TABLE IF EXISTS `bcs_hand_tip`;
CREATE TABLE `bcs_hand_tip` (
  `tip_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '手续费ID',
  `amount` double(10,2) NOT NULL COMMENT '手续费额',
  `add_time` datetime NOT NULL COMMENT '创建时间',
  `biz_name` varchar(50) NOT NULL COMMENT '业务名称',
  `step` int(4) DEFAULT NULL COMMENT '计收阶段  1 买家付款  2 卖家下账  3 卖家结算',
  `receive_account` int(10) NOT NULL COMMENT '手续费代收账户',
  `pay_account` int(10) DEFAULT NULL COMMENT '支付手续费的账户',
  `optno` varchar(100) DEFAULT NULL COMMENT '操作流水号',
  PRIMARY KEY (`tip_id`)
) ENGINE=InnoDB AUTO_INCREMENT=143 DEFAULT CHARSET=utf8 COMMENT='手续费计收记录';

-- ----------------------------
-- Records of bcs_hand_tip
-- ----------------------------
INSERT INTO `bcs_hand_tip` VALUES ('33', '0.90', '2014-06-17 19:03:14', '订单交易（勿删）', '2', '69', '0', '');
INSERT INTO `bcs_hand_tip` VALUES ('34', '0.90', '2014-06-17 19:12:45', '订单交易（勿删）', '2', '69', '0', '');
INSERT INTO `bcs_hand_tip` VALUES ('35', '0.90', '2014-06-17 19:19:06', '订单交易（勿删）', '2', '69', '0', '');
INSERT INTO `bcs_hand_tip` VALUES ('37', '0.00', '2014-06-17 23:12:57', '充值', null, '69', '0', '');
INSERT INTO `bcs_hand_tip` VALUES ('38', '0.00', '2014-06-18 00:24:40', '充值', null, '69', '0', '');
INSERT INTO `bcs_hand_tip` VALUES ('39', '0.23', '2014-06-18 01:12:02', '订单交易（勿删）', '2', '69', '0', '');
INSERT INTO `bcs_hand_tip` VALUES ('40', '0.00', '2014-06-18 01:18:12', '充值', null, '69', '0', '');
INSERT INTO `bcs_hand_tip` VALUES ('41', '0.36', '2014-06-18 01:28:08', '订单交易（勿删）', '2', '69', '0', '');
INSERT INTO `bcs_hand_tip` VALUES ('42', '0.00', '2014-06-18 17:22:08', '充值', null, '69', '0', '');
INSERT INTO `bcs_hand_tip` VALUES ('43', '0.12', '2014-06-18 18:03:00', '订单交易（勿删）', '2', '69', '0', '');
INSERT INTO `bcs_hand_tip` VALUES ('44', '0.00', '2014-06-18 13:54:55', '充值', null, '69', '0', '');
INSERT INTO `bcs_hand_tip` VALUES ('45', '0.00', '2014-06-18 13:54:55', '订单交易（勿删）', '2', '69', '0', '');
INSERT INTO `bcs_hand_tip` VALUES ('46', '0.00', '2014-06-18 14:09:08', '充值', null, '69', '0', '');
INSERT INTO `bcs_hand_tip` VALUES ('47', '0.12', '2014-06-18 14:20:35', '订单交易（勿删）', '2', '69', '0', '');
INSERT INTO `bcs_hand_tip` VALUES ('48', '0.00', '2014-06-18 14:22:17', '充值', null, '69', '0', '');
INSERT INTO `bcs_hand_tip` VALUES ('49', '0.00', '2014-06-18 14:22:17', '订单交易（勿删）', '2', '69', '0', '');
INSERT INTO `bcs_hand_tip` VALUES ('50', '0.22', '2014-06-19 11:28:45', '订单交易（勿删）', '2', '69', null, null);
INSERT INTO `bcs_hand_tip` VALUES ('51', '0.00', '2014-06-19 11:29:50', '充值', null, '69', null, null);
INSERT INTO `bcs_hand_tip` VALUES ('52', '0.09', '2014-06-19 12:28:32', '订单交易（勿删）', '2', '69', '1', '1002900120140619123022203639');
INSERT INTO `bcs_hand_tip` VALUES ('53', '0.00', '2014-06-19 12:58:19', '充值', null, '69', '76', '1003900120140619125936266313');
INSERT INTO `bcs_hand_tip` VALUES ('54', '0.00', '2014-06-19 13:02:03', '充值', null, '69', '76', '1001900120140619130336438949');
INSERT INTO `bcs_hand_tip` VALUES ('55', '0.00', '2014-06-19 13:02:03', '订单交易（勿删）', '2', '69', '10', '1001900120140619130336438949');
INSERT INTO `bcs_hand_tip` VALUES ('56', '0.00', '2014-06-19 13:22:37', '充值', null, '69', '77', '1003900120140619132403474825');
INSERT INTO `bcs_hand_tip` VALUES ('57', '0.06', '2014-06-19 13:33:31', '订单交易（勿删）', '2', '69', '1', '1002900120140619133522832262');
INSERT INTO `bcs_hand_tip` VALUES ('58', '0.12', '2014-06-19 13:37:41', '订单交易（勿删）', '2', '69', '1', '1002900120140619133932839548');
INSERT INTO `bcs_hand_tip` VALUES ('64', '0.00', '2014-06-19 14:37:15', '充值', null, '69', '81', '1003900120140619143824225347');
INSERT INTO `bcs_hand_tip` VALUES ('65', '0.09', '2014-06-19 14:38:44', '订单交易（勿删）', '2', '69', '1', '1002900120140619144034681764');
INSERT INTO `bcs_hand_tip` VALUES ('66', '0.11', '2014-06-19 14:50:38', '订单交易（勿删）', '2', '69', '10', '1002900120140619145228904142');
INSERT INTO `bcs_hand_tip` VALUES ('67', '0.00', '2014-06-19 15:01:23', '交易撤销', '1', '69', '81', '0000000000000000000000000001');
INSERT INTO `bcs_hand_tip` VALUES ('68', '0.12', '2014-06-19 17:38:41', '订单交易（勿删）', '2', '69', '10', '1002900120140619174028351292');
INSERT INTO `bcs_hand_tip` VALUES ('69', '0.21', '2014-06-19 18:14:18', '订单交易（勿删）', '2', '69', '10', '1002900120140619181608789497');
INSERT INTO `bcs_hand_tip` VALUES ('70', '0.30', '2014-06-20 15:06:55', '订单交易（勿删）', '2', '69', '10', '1002900120140620150135542682');
INSERT INTO `bcs_hand_tip` VALUES ('71', '0.30', '2014-06-20 15:08:20', '订单交易（勿删）', '2', '69', '10', '1002900120140620151010991074');
INSERT INTO `bcs_hand_tip` VALUES ('72', '0.00', '2014-06-20 15:14:48', '充值', null, '69', '71', '1003900120140620151602591217');
INSERT INTO `bcs_hand_tip` VALUES ('73', '0.00', '2014-06-20 15:17:49', '充值', null, '69', '71', '1001900120140620151930850341');
INSERT INTO `bcs_hand_tip` VALUES ('74', '0.00', '2014-06-20 15:17:49', '订单交易（勿删）', '2', '69', '10', '1001900120140620151930850341');
INSERT INTO `bcs_hand_tip` VALUES ('75', '0.47', '2014-06-20 15:40:50', '订单交易（勿删）', '2', '69', '10', '1002900120140620154240820863');
INSERT INTO `bcs_hand_tip` VALUES ('80', '0.12', '2014-06-26 09:59:39', '订单交易（勿删）', '2', '69', '10', '1002900120140626100133361662');
INSERT INTO `bcs_hand_tip` VALUES ('83', '0.19', '2014-06-26 11:28:51', '订单交易（勿删）', '2', '69', '10', '1002900120140626113045965854');
INSERT INTO `bcs_hand_tip` VALUES ('84', '0.36', '2014-06-26 11:31:06', '订单交易（勿删）', '2', '69', '10', '1002900120140626113302407185');
INSERT INTO `bcs_hand_tip` VALUES ('85', '0.00', '2014-06-26 17:05:16', '充值', null, '69', '71', '1003900120140626170642761121');
INSERT INTO `bcs_hand_tip` VALUES ('86', '0.00', '2014-06-26 17:09:44', '充值', null, '69', '71', '1001900120140626171112933616');
INSERT INTO `bcs_hand_tip` VALUES ('87', '0.00', '2014-06-26 17:09:44', '订单交易（勿删）', '2', '69', '10', '1001900120140626171112933616');
INSERT INTO `bcs_hand_tip` VALUES ('88', '0.19', '2014-07-01 09:10:59', '订单交易（勿删）', '2', '69', '10', '1002900120140701091256364149');
INSERT INTO `bcs_hand_tip` VALUES ('89', '0.00', '2014-07-01 11:07:38', '充值', null, '69', '92', '1003900120140701110823745928');
INSERT INTO `bcs_hand_tip` VALUES ('90', '0.09', '2014-07-01 11:09:35', '订单交易（勿删）', '2', '69', '10', '1002900120140701111134539469');
INSERT INTO `bcs_hand_tip` VALUES ('91', '0.09', '2014-07-02 17:16:53', '订单交易（勿删）', '2', '69', '10', '1002900120140702171851944029');
INSERT INTO `bcs_hand_tip` VALUES ('92', '0.19', '2014-07-09 16:19:47', '订单交易（勿删）', '2', '69', '10', '1002900120140709162122836945');
INSERT INTO `bcs_hand_tip` VALUES ('93', '0.00', '2014-07-21 14:12:25', '充值', null, '69', '1000000114', '1003900120140721141001277499');
INSERT INTO `bcs_hand_tip` VALUES ('94', '0.04', '2014-07-21 14:14:37', '订单交易（勿删）', '2', '69', '10', '1002900120140721141439404345');
INSERT INTO `bcs_hand_tip` VALUES ('95', '0.00', '2014-07-21 14:16:09', '充值', null, '69', '1000000114', '1001900120140721141545253527');
INSERT INTO `bcs_hand_tip` VALUES ('96', '0.00', '2014-07-21 14:16:09', '订单交易（勿删）', '2', '69', '10', '1001900120140721141545253527');
INSERT INTO `bcs_hand_tip` VALUES ('97', '0.00', '2014-07-22 09:39:10', '充值', null, '69', '1000000115', '1001900120140722093858798129');
INSERT INTO `bcs_hand_tip` VALUES ('98', '0.00', '2014-07-22 09:39:10', '订单交易（勿删）', '2', '69', '10', '1001900120140722093858798129');
INSERT INTO `bcs_hand_tip` VALUES ('99', '0.00', '2014-07-30 09:00:02', '充值', null, '69', '1000000117', '1003900120140730090103736647');
INSERT INTO `bcs_hand_tip` VALUES ('100', '0.12', '2014-08-06 12:48:53', '订单交易（勿删）', '2', '69', '10', '1002900120140806125026751924');
INSERT INTO `bcs_hand_tip` VALUES ('101', '0.00', '2014-08-06 12:51:14', '充值', null, '69', '1000000117', '1003900120140806125146988064');
INSERT INTO `bcs_hand_tip` VALUES ('102', '0.00', '2014-08-06 13:22:01', '充值', null, '69', '1000000115', '1001900120140806132316246819');
INSERT INTO `bcs_hand_tip` VALUES ('103', '0.00', '2014-08-06 13:22:01', '订单交易（勿删）', '2', '69', '10', '1001900120140806132316246819');
INSERT INTO `bcs_hand_tip` VALUES ('104', '0.00', '2014-08-13 17:35:31', '充值', null, '69', '71', '1005900120140813173545401692');
INSERT INTO `bcs_hand_tip` VALUES ('105', '0.00', '2014-08-13 17:35:31', '订单交易（勿删）', '2', '69', '10', '1005900120140813173545401692');
INSERT INTO `bcs_hand_tip` VALUES ('106', '0.00', '2014-08-13 17:37:13', '充值', null, '69', '71', '1001900120140813173836340197');
INSERT INTO `bcs_hand_tip` VALUES ('107', '0.00', '2014-08-13 17:37:13', '订单交易（勿删）', '2', '69', '10', '1001900120140813173836340197');
INSERT INTO `bcs_hand_tip` VALUES ('108', '0.18', '2014-08-13 17:41:36', '订单交易（勿删）', '2', '69', '10', '1002900120140813174327569975');
INSERT INTO `bcs_hand_tip` VALUES ('109', '0.00', '2014-08-13 17:51:31', '充值', null, '69', '71', '1005900120140813173545401692');
INSERT INTO `bcs_hand_tip` VALUES ('110', '0.00', '2014-08-13 17:51:31', '订单交易（勿删）', '2', '69', '10', '1005900120140813173545401692');
INSERT INTO `bcs_hand_tip` VALUES ('111', '0.00', '2014-08-13 18:06:13', '充值', null, '69', '71', '1001900120140813180730800902');
INSERT INTO `bcs_hand_tip` VALUES ('112', '0.00', '2014-08-13 18:06:13', '订单交易（勿删）', '2', '69', '10', '1001900120140813180730800902');
INSERT INTO `bcs_hand_tip` VALUES ('113', '0.00', '2014-08-13 18:07:31', '充值', null, '69', '71', '1005900120140813173545401692');
INSERT INTO `bcs_hand_tip` VALUES ('114', '0.00', '2014-08-13 18:07:31', '订单交易（勿删）', '2', '69', '10', '1005900120140813173545401692');
INSERT INTO `bcs_hand_tip` VALUES ('115', '0.00', '2014-08-13 21:35:30', '充值', null, '69', '71', '1005900120140813173545401692');
INSERT INTO `bcs_hand_tip` VALUES ('116', '0.00', '2014-08-13 21:35:30', '订单交易（勿删）', '2', '69', '10', '1005900120140813173545401692');
INSERT INTO `bcs_hand_tip` VALUES ('117', '0.00', '2014-08-14 01:35:30', '充值', null, '69', '71', '1005900120140813173545401692');
INSERT INTO `bcs_hand_tip` VALUES ('118', '0.00', '2014-08-14 01:35:30', '订单交易（勿删）', '2', '69', '10', '1005900120140813173545401692');
INSERT INTO `bcs_hand_tip` VALUES ('119', '0.00', '2014-08-14 09:29:18', '充值', null, '69', '71', '1001900120140814093029940002');
INSERT INTO `bcs_hand_tip` VALUES ('120', '0.00', '2014-08-14 09:29:18', '订单交易（勿删）', '2', '69', '10', '1001900120140814093029940002');
INSERT INTO `bcs_hand_tip` VALUES ('121', '0.00', '2014-08-14 09:35:30', '充值', null, '69', '71', '1005900120140813173545401692');
INSERT INTO `bcs_hand_tip` VALUES ('122', '0.00', '2014-08-14 09:35:30', '订单交易（勿删）', '2', '69', '10', '1005900120140813173545401692');
INSERT INTO `bcs_hand_tip` VALUES ('123', '0.00', '2014-08-14 10:04:51', '充值', null, '69', '71', '1005900120140814100450973293');
INSERT INTO `bcs_hand_tip` VALUES ('124', '0.00', '2014-08-14 10:04:51', '订单交易（勿删）', '2', '69', '10', '1005900120140814100450973293');
INSERT INTO `bcs_hand_tip` VALUES ('125', '0.00', '2014-08-14 10:13:11', '充值', null, '69', '71', '1001900120140814101326335540');
INSERT INTO `bcs_hand_tip` VALUES ('126', '0.00', '2014-08-14 10:13:11', '订单交易（勿删）', '2', '69', '10', '1001900120140814101326335540');
INSERT INTO `bcs_hand_tip` VALUES ('127', '0.00', '2014-08-14 10:20:51', '充值', null, '69', '71', '1005900120140814100450973293');
INSERT INTO `bcs_hand_tip` VALUES ('128', '0.00', '2014-08-14 10:20:51', '订单交易（勿删）', '2', '69', '10', '1005900120140814100450973293');
INSERT INTO `bcs_hand_tip` VALUES ('129', '0.00', '2014-08-14 10:36:51', '充值', null, '69', '71', '1005900120140814100450973293');
INSERT INTO `bcs_hand_tip` VALUES ('130', '0.00', '2014-08-14 10:36:51', '订单交易（勿删）', '2', '69', '10', '1005900120140814100450973293');
INSERT INTO `bcs_hand_tip` VALUES ('131', '0.00', '2014-08-14 14:04:50', '充值', null, '69', '71', '1005900120140814100450973293');
INSERT INTO `bcs_hand_tip` VALUES ('132', '0.00', '2014-08-14 14:04:50', '订单交易（勿删）', '2', '69', '10', '1005900120140814100450973293');
INSERT INTO `bcs_hand_tip` VALUES ('133', '0.00', '2014-08-14 18:04:50', '充值', null, '69', '71', '1005900120140814100450973293');
INSERT INTO `bcs_hand_tip` VALUES ('134', '0.00', '2014-08-14 18:04:50', '订单交易（勿删）', '1', '69', '71', '1005900120140814100450973293');
INSERT INTO `bcs_hand_tip` VALUES ('135', '0.00', '2014-08-15 02:04:50', '充值', null, '69', '71', '1005900120140814100450973293');
INSERT INTO `bcs_hand_tip` VALUES ('136', '0.00', '2014-08-15 02:04:50', '订单交易（勿删）', '1', '69', '71', '1005900120140814100450973293');
INSERT INTO `bcs_hand_tip` VALUES ('137', '0.00', '2014-08-15 14:57:58', '充值', null, '69', '71', '1001900120140815145917306120');
INSERT INTO `bcs_hand_tip` VALUES ('138', '0.00', '2014-08-15 14:57:58', '订单交易（勿删）', '1', '69', '71', '1001900120140815145917306120');
INSERT INTO `bcs_hand_tip` VALUES ('139', '0.00', '2014-08-19 14:41:00', '充值', null, '69', '71', '1001900120140819144207471056');
INSERT INTO `bcs_hand_tip` VALUES ('140', '0.00', '2014-08-19 14:41:00', '订单交易（勿删）', '1', '69', '71', '1001900120140819144207471056');
INSERT INTO `bcs_hand_tip` VALUES ('141', '0.12', '2014-08-22 14:06:07', '订单交易（勿删）', '1', '69', '33', '1002900120140822140656370395');
INSERT INTO `bcs_hand_tip` VALUES ('142', '0.12', '2014-08-22 14:10:15', '订单交易（勿删）', '1', '69', '33', '1002900120140822141213488165');

-- ----------------------------
-- Table structure for `bcs_money_transfer_records`
-- ----------------------------
DROP TABLE IF EXISTS `bcs_money_transfer_records`;
CREATE TABLE `bcs_money_transfer_records` (
  `TRANSFER_ID` int(10) NOT NULL,
  `TRADE_SN` varchar(50) NOT NULL,
  `OUT_BANK_ACCOUNT_ID` varchar(50) NOT NULL,
  `OUT_BANK_ACCOUNT_NAME` varchar(50) NOT NULL,
  `IN_BANK_ACCOUNT_ID` varchar(50) NOT NULL,
  `IN_BANK_ACCOUNT_NAME` varchar(50) NOT NULL,
  `IS_INTER_BANK` int(2) NOT NULL COMMENT '1--��  2--��',
  `IN_BANK_TYPE` int(2) NOT NULL COMMENT '1--��˽  2--�Թ�',
  `IN_BANK_NAME` varchar(50) NOT NULL,
  `TRANSFER_TIME` datetime NOT NULL,
  `STATUS` int(2) NOT NULL COMMENT '1--�ɹ�  2--ʧ��  3--������',
  `USERS` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`TRANSFER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='�ʽ𻮲���¼';

-- ----------------------------
-- Records of bcs_money_transfer_records
-- ----------------------------

-- ----------------------------
-- Table structure for `bcs_settle_account`
-- ----------------------------
DROP TABLE IF EXISTS `bcs_settle_account`;
CREATE TABLE `bcs_settle_account` (
  `CUS_ID` int(10) NOT NULL,
  `SETTLE_ACCOUNT_NAME` varchar(50) NOT NULL,
  `BELONGS_BANK` int(2) NOT NULL COMMENT '1--�й���������   2--�й���������  3--�й�ũҵ����   4--�й�����',
  `BANK_CARD_NUM` varchar(50) NOT NULL,
  `SIGN_DATE` date NOT NULL,
  `SETTLE_ACCOUNT_BALANCE` double(10,2) NOT NULL,
  `ENABLE_BALANCE` double(10,2) NOT NULL,
  `FREEZE_BALANCE` double(10,2) NOT NULL,
  `STATUS` int(2) NOT NULL COMMENT '1--����   2--��ͣ  3--ע��',
  `LAST_UPDATE_TIME` datetime NOT NULL,
  PRIMARY KEY (`CUS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bcs_settle_account
-- ----------------------------

-- ----------------------------
-- Table structure for `bcs_settle_bills`
-- ----------------------------
DROP TABLE IF EXISTS `bcs_settle_bills`;
CREATE TABLE `bcs_settle_bills` (
  `settle_bills_id` int(10) NOT NULL AUTO_INCREMENT,
  `settle_create_time` datetime NOT NULL COMMENT '结算生成时间',
  `betch` int(2) NOT NULL COMMENT '结算批次 1-20140324J001  2-20140324J002   3-20140324J003',
  `settle_balance` double(10,2) NOT NULL COMMENT '结算金额',
  `settle_strategy_id` int(10) NOT NULL COMMENT '结算代码',
  `settle_way` int(2) DEFAULT NULL COMMENT '结算方式 1-及时结算   2-周期结算   3-定时结算',
  `settle_cycle` varchar(50) DEFAULT NULL COMMENT '1-按月    2-按周   3-指定时间（t+3） 4-指定时间（t+0）',
  `plan_execute_time` datetime DEFAULT NULL COMMENT '计划结算执行时间',
  `opt_number` varchar(50) NOT NULL COMMENT '操作流水号',
  `settle_auto` int(2) NOT NULL COMMENT '是否是自动结算 1-是  2-否',
  `account_id` int(10) NOT NULL COMMENT '结算账户',
  `bank_number` varchar(50) NOT NULL COMMENT '银行卡号',
  `belongs_bank` int(2) NOT NULL COMMENT '所属银行 1-中国工商银行  2-中国建设银行  3-中国农业银行  4-中国银行',
  `business_name` varchar(50) DEFAULT NULL COMMENT '业务名称',
  `business_id` int(10) NOT NULL COMMENT '业务代码',
  `TIPS_GET_STEP` int(2) DEFAULT NULL COMMENT '手续费计收阶段 1.付款业务   2.卖家下账   3.买家资金结算',
  `cast_way` int(2) DEFAULT NULL COMMENT '计费方式 1.按次   2.按率',
  `cast_percent` varchar(50) DEFAULT NULL COMMENT '手续费计收费率 1-1元/次   2-0.3%   3-0.1%',
  `status` int(2) NOT NULL COMMENT '结算状态  1-未结算  2-结算中  3-结算失败 4-结算成功',
  `remark` varchar(255) DEFAULT NULL COMMENT '结算信息备注',
  `process_success_time` datetime DEFAULT NULL COMMENT '结算成功的时间',
  PRIMARY KEY (`settle_bills_id`)
) ENGINE=InnoDB AUTO_INCREMENT=79 DEFAULT CHARSET=utf8 COMMENT='结算账单信息表';

-- ----------------------------
-- Records of bcs_settle_bills
-- ----------------------------
INSERT INTO `bcs_settle_bills` VALUES ('30', '2014-06-17 19:03:14', '2012', '299.10', '2', '1', '4', '2014-06-26 09:38:26', '0000000000140520134742800000', '2', '3', '1222222222222222', '1', '订单交易（勿删）', '3', '2', '2', '0.3', '2', '（测试）手动结算手工状态值修改备注.Mon Jul 07 10:47:12 CST 2014', '2014-06-25 10:12:53');
INSERT INTO `bcs_settle_bills` VALUES ('31', '2014-06-17 19:12:53', '2012', '299.10', '2', '1', '4', '2014-06-26 09:38:26', '0000000000140520134742800000', '2', '3', '1222222222222222', '1', '订单交易（勿删）', '3', '2', '2', '0.3', '2', '（测试）手动结算手工状态值修改备注.Thu Jul 03 16:24:34 CST 2014', '2014-06-25 11:13:06');
INSERT INTO `bcs_settle_bills` VALUES ('32', '2014-06-17 19:19:31', '2012', '299.10', '2', '1', '4', '2014-06-26 09:38:26', '0000000000140520134742800000', '2', '3', '1222222222222222', '1', '订单交易（勿删）', '3', '2', '2', '0.3', '2', '导出结算清单.Thu Jul 10 10:06:53 CST 2014', '2014-06-25 22:13:15');
INSERT INTO `bcs_settle_bills` VALUES ('33', '2014-06-18 01:12:02', '2014031012', '77.77', '2', '1', '4', '2014-06-26 09:38:26', '1002900120140617171539300648', '2', '1', '1222222222222222', '1', '订单交易（勿删）', '3', '2', '2', '0.3', '2', '导出结算清单.Thu Jul 10 10:06:53 CST 2014', '2014-06-26 10:13:27');
INSERT INTO `bcs_settle_bills` VALUES ('34', '2014-06-18 01:28:08', '2014031012', '118.64', '2', '1', '4', '2014-06-26 09:38:26', '1002900120140617173146442599', '2', '1', '1222222222222222', '1', '订单交易（勿删）', '3', '2', '2', '0.3', '1', '（测试）手动结算手工状态值修改备注.Fri Jun 20 16:45:26 CST 2014', '2014-06-26 11:13:48');
INSERT INTO `bcs_settle_bills` VALUES ('35', '2014-07-14 18:03:00', '2014031012', '39.88', '2', '1', '4', '2014-07-08 12:38:26', '1002900120140618100617706061', '2', '1', '1222222222222222', '1', '订单交易（勿删）', '3', '2', '2', '0.3', '1', '（测试）手动结算手工状态值修改备注.Tue Jun 24 10:40:40 CST 2014', '2014-06-27 10:13:58');
INSERT INTO `bcs_settle_bills` VALUES ('36', '2014-06-18 13:54:55', '2014031012', '0.01', '2', '1', '4', '2014-07-08 19:38:26', '1001900120140618135528127368', '2', '10', '1222222222222222', '1', '订单交易（勿删）', '3', '2', '2', '0.3', '1', '（测试）手动结算手工状态值修改备注.Fri Jun 20 16:45:24 CST 2014', '2014-06-27 15:14:08');
INSERT INTO `bcs_settle_bills` VALUES ('37', '2014-06-18 14:20:35', '2014031012', '39.88', '2', '1', '4', '2014-07-09 09:38:26', '1002900120140618142225946061', '2', '1', '1222222222222222', '1', '订单交易（勿删）', '3', '2', '2', '0.3', '1', '（测试）手动结算手工状态值修改备注.Tue Jun 24 10:26:42 CST 2014', '2014-06-27 19:14:17');
INSERT INTO `bcs_settle_bills` VALUES ('38', '2014-06-18 14:22:17', '2014031012', '0.01', '2', '1', '4', '2014-07-08 09:38:26', '1001900120140618142339178326', '2', '10', '1222222222222222', '1', '订单交易（勿删）', '3', '2', '2', '0.3', '1', '（测试）手动结算手工状态值修改备注.Tue Jun 24 10:26:43 CST 2014', '2014-06-29 10:14:27');
INSERT INTO `bcs_settle_bills` VALUES ('39', '2014-06-19 11:28:45', '2014031012', '72.78', '2', '1', '4', '2014-07-10 09:38:26', '1002900120140619113029792863', '2', '1', '1222222222222222', '1', '订单交易（勿删）', '3', '2', '2', '0.3', '1', '（测试）手动结算手工状态值修改备注.Tue Jun 24 10:40:41 CST 2014', '2014-06-29 12:14:39');
INSERT INTO `bcs_settle_bills` VALUES ('40', '2014-06-19 12:28:32', '2014031012', '29.91', '2', '1', '4', '2014-07-11 09:38:26', '1002900120140619123022203639', '2', '1', '1222222222222222', '1', '订单交易（勿删）', '3', '2', '2', '0.3', '1', '（测试）手动结算手工状态值修改备注.Mon Jun 23 16:37:59 CST 2014', '2014-06-30 10:14:47');
INSERT INTO `bcs_settle_bills` VALUES ('41', '2014-06-19 13:02:03', '2014031012', '0.01', '2', '1', '4', '2014-07-12 09:38:26', '1001900120140619130336438949', '2', '10', '1222222222222222', '1', '订单交易（勿删）', '3', '2', '2', '0.3', '1', '（测试）手动结算手工状态值修改备注.Tue Jun 24 10:41:31 CST 2014', '2014-07-04 10:15:29');
INSERT INTO `bcs_settle_bills` VALUES ('42', '2014-06-19 13:33:31', '2014031012', '19.94', '2', '1', '4', '2014-07-13 09:38:26', '1002900120140619133522832262', '2', '1', '1222222222222222', '1', '订单交易（勿删）', '3', '2', '2', '0.3', '1', '（测试）手动结算手工状态值修改备注.Tue Jun 24 10:41:31 CST 2014', '2014-07-04 10:15:33');
INSERT INTO `bcs_settle_bills` VALUES ('43', '2014-06-19 13:37:41', '2014031012', '39.88', '2', '1', '4', '2014-07-14 09:38:26', '1002900120140619133932839548', '1', '1', '1222222222222222', '1', '订单交易（勿删）', '3', '2', '2', '0.3', '2', '导出结算清单.Thu Jul 24 14:41:59 CST 2014', '2014-07-04 09:15:41');
INSERT INTO `bcs_settle_bills` VALUES ('44', '2014-06-19 14:38:45', '2014031012', '29.91', '2', '1', '4', '2014-07-16 09:38:26', '1002900120140619144034681764', '1', '1', '1222222222222222', '1', '订单交易（勿删）', '3', '2', '2', '0.3', '2', '（测试）手动结算手工状态值修改备注.Tue Jul 22 16:41:45 CST 2014', null);
INSERT INTO `bcs_settle_bills` VALUES ('45', '2014-06-19 14:50:38', '2014031012', '37.89', '2', '1', '4', '2014-07-15 09:38:26', '1002900120140619145228904142', '1', '10', '1222222222222222', '1', '订单交易（勿删）', '3', '2', '2', '0.3', '2', '（测试）手动结算手工状态值修改备注.Tue Aug 12 16:56:01 CST 2014', null);
INSERT INTO `bcs_settle_bills` VALUES ('46', '2014-06-19 17:38:41', '2014031012', '39.88', '2', '1', '4', '2014-06-26 09:38:26', '1002900120140619174028351292', '1', '10', '1222222222222222', '1', '订单交易（勿删）', '3', '2', '2', '0.3', '2', '（测试）手动结算手工状态值修改备注.Thu Jul 31 14:35:47 CST 2014', null);
INSERT INTO `bcs_settle_bills` VALUES ('47', '2014-06-19 18:14:18', '2014031012', '69.79', '2', '1', '4', '2014-06-26 09:38:26', '1002900120140619181608789497', '1', '10', '1222222222222222', '1', '订单交易（勿删）', '3', '2', '2', '0.3', '2', '（测试）手动结算手工状态值修改备注.Wed Aug 06 17:19:42 CST 2014', null);
INSERT INTO `bcs_settle_bills` VALUES ('48', '2014-06-20 15:06:55', '2014031012', '98.70', '2', '1', '4', '2014-06-21 09:38:26', '1002900120140620150135542682', '1', '10', '12444444444444234234', '1', '订单交易（勿删）', '3', '2', '2', '0.3', '2', '（测试）手动结算手工状态值修改备注.Thu Jul 24 14:41:44 CST 2014', null);
INSERT INTO `bcs_settle_bills` VALUES ('49', '2014-06-20 15:08:20', '2014031012', '98.70', '2', '1', '4', '2014-06-22 09:38:26', '1002900120140620151010991074', '1', '10', '12444444444444234234', '1', '订单交易（勿删）', '3', '2', '2', '0.3', '2', '（测试）手动结算手工状态值修改备注.Tue Aug 19 17:16:18 CST 2014', null);
INSERT INTO `bcs_settle_bills` VALUES ('50', '2014-06-20 15:17:49', '2014031012', '0.01', '2', '1', '4', '2014-06-23 09:38:26', '1001900120140620151930850341', '1', '10', '12444444444444234234', '1', '订单交易（勿删）', '3', '2', '2', '0.3', '2', '（测试）手动结算手工状态值修改备注.Wed Aug 20 09:04:36 CST 2014', null);
INSERT INTO `bcs_settle_bills` VALUES ('51', '2014-06-20 15:40:50', '2014031012', '157.53', '2', '1', '4', '2014-07-24 09:38:26', '1002900120140620154240820863', '1', '10', '12444444444444234234', '1', '订单交易（勿删）', '3', '2', '2', '0.3', '2', '（测试）手动结算手工状态值修改备注.Tue Aug 12 15:52:27 CST 2014', null);
INSERT INTO `bcs_settle_bills` VALUES ('52', '2014-06-26 09:59:39', '2014031012', '39.88', '2', '1', '4', '2014-06-25 10:08:38', '1002900120140626100133361662', '2', '10', '', '2', '订单交易（勿删）', '3', '2', '2', '0.3', '1', '订单虚拟账户支付-交易', null);
INSERT INTO `bcs_settle_bills` VALUES ('53', '2014-06-26 11:28:51', '2014031012', '61.81', '2', '2', 'T+4', '2014-06-30 11:28:51', '1002900120140626113045965854', '1', '10', '811325199005275413', '4', '订单交易（勿删）', '3', '2', '2', '0.3', '1', '导出结算清单.Mon Jul 21 16:23:17 CST 2014', null);
INSERT INTO `bcs_settle_bills` VALUES ('54', '2014-07-01 17:32:09', '2014031012', '61.81', '11000002', '2', 'T+4', '2014-07-20 17:32:09', '1002900120140701091256364149', '1', '10', '611325199005275413', '2', '订单交易（勿删）', '3', '2', '2', '0.3', '1', '待下账账单进行下账操作', null);
INSERT INTO `bcs_settle_bills` VALUES ('55', '2014-07-22 09:39:10', '2014031012', '0.01', '11000002', '2', 'T+4', '2014-07-26 09:39:10', '1001900120140722093858798129', '1', '10', '611325199005245413', '3', '订单交易（勿删）', '3', '2', '2', '0.3', '2', '（测试）手动结算手工状态值修改备注.Wed Aug 13 14:59:20 CST 2014', null);
INSERT INTO `bcs_settle_bills` VALUES ('56', '2014-08-06 12:48:53', '2014031012', '39.88', '11000002', '2', 'T+4', '2014-08-10 12:48:53', '1002900120140806125026751924', '1', '10', '611325199005245413', '3', '订单交易（勿删）', '3', '2', '2', '0.3', '1', '订单虚拟账户支付-交易', null);
INSERT INTO `bcs_settle_bills` VALUES ('57', '2014-08-06 13:22:01', '2014031012', '0.01', '11000002', '2', 'T+4', '2014-08-10 13:22:01', '1001900120140806132316246819', '1', '10', '611325199005245413', '3', '订单交易（勿删）', '3', '2', '2', '0.3', '1', '订单支付-交易', null);
INSERT INTO `bcs_settle_bills` VALUES ('58', '2014-08-13 17:35:31', '2014031012', '0.01', '11000002', '2', 'T+4', '2014-08-17 17:35:31', '1005900120140813173545401692', '1', '10', '611325199005245413', '3', '订单交易（勿删）', '3', '2', '2', '0.3', '1', '订单支付-交易', null);
INSERT INTO `bcs_settle_bills` VALUES ('59', '2014-08-13 17:37:13', '2014031012', '0.01', '11000002', '2', 'T+4', '2014-08-17 17:37:13', '1001900120140813173836340197', '1', '10', '611325199005245413', '3', '订单交易（勿删）', '3', '2', '2', '0.3', '1', '订单支付-交易', null);
INSERT INTO `bcs_settle_bills` VALUES ('60', '2014-08-13 17:41:36', '2014031012', '59.82', '11000002', '2', 'T+4', '2014-08-17 17:41:36', '1002900120140813174327569975', '1', '10', '611325199005245413', '3', '订单交易（勿删）', '3', '2', '2', '0.3', '1', '订单虚拟账户支付-交易', null);
INSERT INTO `bcs_settle_bills` VALUES ('61', '2014-08-13 17:51:31', '2014031012', '0.01', '11000002', '2', 'T+4', '2014-08-17 17:51:31', '1005900120140813173545401692', '1', '10', '611325199005245413', '3', '订单交易（勿删）', '3', '2', '2', '0.3', '1', '订单支付-交易', null);
INSERT INTO `bcs_settle_bills` VALUES ('62', '2014-08-13 18:06:13', '2014031012', '0.01', '11000002', '2', 'T+4', '2014-08-17 18:06:13', '1001900120140813180730800902', '1', '10', '611325199005245413', '3', '订单交易（勿删）', '3', '2', '2', '0.3', '1', '订单支付-交易', null);
INSERT INTO `bcs_settle_bills` VALUES ('63', '2014-08-13 18:07:31', '2014031012', '0.01', '11000002', '2', 'T+4', '2014-08-17 18:07:31', '1005900120140813173545401692', '1', '10', '611325199005245413', '3', '订单交易（勿删）', '3', '2', '2', '0.3', '1', '订单支付-交易', null);
INSERT INTO `bcs_settle_bills` VALUES ('64', '2014-08-13 21:35:30', '2014031012', '0.01', '11000002', '2', 'T+4', '2014-08-17 21:35:30', '1005900120140813173545401692', '1', '10', '611325199005245413', '3', '订单交易（勿删）', '3', '2', '2', '0.3', '1', '订单支付-交易', null);
INSERT INTO `bcs_settle_bills` VALUES ('65', '2014-08-14 01:35:30', '2014031012', '0.01', '11000002', '2', 'T+4', '2014-08-18 01:35:30', '1005900120140813173545401692', '1', '10', '611325199005245413', '3', '订单交易（勿删）', '3', '2', '2', '0.3', '1', '订单支付-交易', null);
INSERT INTO `bcs_settle_bills` VALUES ('66', '2014-08-14 09:29:18', '2014031012', '0.01', '11000002', '2', 'T+4', '2014-08-18 09:29:18', '1001900120140814093029940002', '1', '10', '611325199005245413', '3', '订单交易（勿删）', '3', '2', '2', '0.3', '1', '订单支付-交易', null);
INSERT INTO `bcs_settle_bills` VALUES ('67', '2014-08-14 09:35:30', '2014031012', '0.01', '11000002', '2', 'T+4', '2014-08-18 09:35:30', '1005900120140813173545401692', '1', '10', '611325199005245413', '3', '订单交易（勿删）', '3', '2', '2', '0.3', '1', '订单支付-交易', null);
INSERT INTO `bcs_settle_bills` VALUES ('68', '2014-08-14 10:04:51', '2014031012', '0.01', '11000002', '2', 'T+4', '2014-08-18 10:04:51', '1005900120140814100450973293', '1', '10', '611325199005245413', '3', '订单交易（勿删）', '3', '2', '2', '0.3', '1', '订单支付-交易', null);
INSERT INTO `bcs_settle_bills` VALUES ('69', '2014-08-14 10:13:11', '2014031012', '0.01', '11000002', '2', 'T+4', '2014-08-18 10:13:11', '1001900120140814101326335540', '1', '10', '611325199005245413', '3', '订单交易（勿删）', '3', '2', '2', '0.3', '1', '订单支付-交易', null);
INSERT INTO `bcs_settle_bills` VALUES ('70', '2014-08-14 10:20:51', '2014031012', '0.01', '11000002', '2', 'T+4', '2014-08-18 10:20:51', '1005900120140814100450973293', '1', '10', '611325199005245413', '3', '订单交易（勿删）', '3', '2', '2', '0.3', '1', '订单支付-交易', null);
INSERT INTO `bcs_settle_bills` VALUES ('71', '2014-08-14 10:36:51', '2014031012', '0.01', '11000002', '2', 'T+4', '2014-08-18 10:36:51', '1005900120140814100450973293', '1', '10', '611325199005245413', '3', '订单交易（勿删）', '3', '2', '2', '0.3', '1', '订单支付-交易', null);
INSERT INTO `bcs_settle_bills` VALUES ('72', '2014-08-14 14:04:50', '2014031012', '0.01', '11000002', '2', 'T+4', '2014-08-18 14:04:50', '1005900120140814100450973293', '1', '10', '611325199005245413', '3', '订单交易（勿删）', '3', '2', '2', '0.3', '1', '订单支付-交易', null);
INSERT INTO `bcs_settle_bills` VALUES ('73', '2014-08-14 18:04:50', '2014031012', '0.01', '11000002', '2', 'T+4', '2014-08-18 18:04:50', '1005900120140814100450973293', '1', '10', '611325199005245413', '3', '订单交易（勿删）', '3', '1', '2', '0.3', '1', '订单支付-交易', null);
INSERT INTO `bcs_settle_bills` VALUES ('74', '2014-08-15 02:04:50', '2014031012', '0.01', '11000002', '2', 'T+4', '2014-08-19 02:04:50', '1005900120140814100450973293', '1', '10', '611325199005245413', '3', '订单交易（勿删）', '3', '1', '2', '0.3', '1', '订单支付-交易', null);
INSERT INTO `bcs_settle_bills` VALUES ('75', '2014-08-15 14:57:58', '2014031012', '0.01', '11000002', '2', 'T+4', '2014-08-19 14:57:58', '1001900120140815145917306120', '1', '10', '611325199005245413', '3', '订单交易（勿删）', '3', '1', '2', '0.3', '1', '订单支付-交易', null);
INSERT INTO `bcs_settle_bills` VALUES ('76', '2014-08-19 14:41:00', '2014031012', '0.01', '11000002', '2', 'T+4', '2014-08-23 14:41:00', '1001900120140819144207471056', '1', '10', '123456789', '1', '订单交易（勿删）', '3', '1', '2', '0.3', '1', '订单支付-交易', null);
INSERT INTO `bcs_settle_bills` VALUES ('77', '2014-08-22 14:06:07', '2014031012', '40.00', '11000002', '2', 'T+4', '2014-08-26 14:06:07', '1002900120140822140656370395', '1', '10', '123456789', '1', '订单交易（勿删）', '3', '1', '2', '0.3', '1', '订单虚拟账户支付-交易', null);
INSERT INTO `bcs_settle_bills` VALUES ('78', '2014-08-22 14:10:15', '2014031012', '40.00', '11000002', '2', 'T+4', '2014-08-26 14:10:15', '1002900120140822141213488165', '1', '10', '123456789', '1', '订单交易（勿删）', '3', '1', '2', '0.3', '1', '订单虚拟账户支付-交易', null);

-- ----------------------------
-- Table structure for `bcs_settle_info_config`
-- ----------------------------
DROP TABLE IF EXISTS `bcs_settle_info_config`;
CREATE TABLE `bcs_settle_info_config` (
  `settle_cinfig_id` int(10) NOT NULL,
  `settle_way` int(2) NOT NULL COMMENT '1--���������   2--������֧�������',
  `bank_card_no` varchar(50) DEFAULT NULL,
  `bank_belongs` int(4) DEFAULT NULL COMMENT '1--�й��������У�2--�й��������У�3--�й����У�4--�й�ũҵ����',
  `bank_front_m_address` varchar(50) DEFAULT NULL,
  `pay3_merchant_code` varchar(50) DEFAULT NULL,
  `pay3_belongs` int(4) DEFAULT NULL COMMENT '1--֧������2--��Ǯ��3--��Ѷ',
  `pay3_interface_address` varchar(50) DEFAULT NULL,
  `pay3_merchant_key` varchar(255) DEFAULT NULL,
  `pay3_merchant_certificate` varchar(50) DEFAULT NULL,
  `status` int(2) NOT NULL COMMENT '1--��Ч��2--��Ч',
  PRIMARY KEY (`settle_cinfig_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='������Ϣ���ñ�\r\n\r\n�ֶ�ǰ�';

-- ----------------------------
-- Records of bcs_settle_info_config
-- ----------------------------

-- ----------------------------
-- Table structure for `bcs_settle_log`
-- ----------------------------
DROP TABLE IF EXISTS `bcs_settle_log`;
CREATE TABLE `bcs_settle_log` (
  `SETTLEP_LOG_ID` int(15) NOT NULL,
  `QPA_settle_billing_id` int(10) DEFAULT NULL,
  `SETTLE_BILLING_ID` int(10) NOT NULL,
  `SETTLEP_LOG_TIME` datetime NOT NULL,
  `SETTLEP_LOG_CONTENT` varchar(255) NOT NULL,
  `SETTLEP_LOG_CLASS` int(2) NOT NULL COMMENT '��־���1--��¼��־  2--������־   3--�쳣��־',
  PRIMARY KEY (`SETTLEP_LOG_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='�����嵥��־��';

-- ----------------------------
-- Records of bcs_settle_log
-- ----------------------------

-- ----------------------------
-- Table structure for `bcs_settle_strategy`
-- ----------------------------
DROP TABLE IF EXISTS `bcs_settle_strategy`;
CREATE TABLE `bcs_settle_strategy` (
  `SETTLE_STRATEGY_ID` int(10) NOT NULL AUTO_INCREMENT COMMENT '结算策略编号',
  `SETTLE_STRATEGY_NAME` varchar(50) NOT NULL COMMENT '结算策略名称',
  `DEFAULT_ACCOUNT_LEVEL` varchar(50) DEFAULT NULL COMMENT '1-普通账户  2-中级账户  3-高级账户   99-所有账户',
  `DEFAULT_SETTLE_AUTO` int(2) DEFAULT NULL COMMENT '是否自动结算 1-是   2-否',
  `DEFAULT_SETTLE_WAY` int(2) DEFAULT '0' COMMENT '1-及时结算   2-周期结算   3-定时结算',
  `DEFAULT_SETTLE_CYCLE` varchar(50) DEFAULT NULL COMMENT '结算周期 T+模式 T+(0,1,2,3,4...)',
  `DEFAULT_SETTLE_TIME` varchar(50) DEFAULT NULL COMMENT '定时结算的结算时间 W+/M+',
  `OTHER_ACCOUNT_IDS` varchar(254) DEFAULT NULL COMMENT '例外账户编号ids',
  `OTHER_SETTLE_AUTO` int(2) DEFAULT NULL COMMENT '是否自动结算 1-是   2-否',
  `OTHER_SETTLE_WAY` int(2) DEFAULT NULL COMMENT '1-即时结算   2-周期结算   3-定时结算',
  `OTHER_SETTLE_CYCLE` varchar(50) DEFAULT NULL COMMENT '结算周期 T+模式 T+(0,1,2,3,4...)',
  `OTHER_SETTLE_TIME` varchar(50) DEFAULT NULL COMMENT '定时结算的结算时间 W+/M+',
  `IS_SYSTEM` int(2) NOT NULL COMMENT '1-是 2-否',
  `ADD_TIME` datetime NOT NULL COMMENT '新增时间',
  `ADD_PERSON` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '新增用户',
  `STATUS` int(2) NOT NULL COMMENT '1-启用 2-暂停  3-注销',
  PRIMARY KEY (`SETTLE_STRATEGY_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11000008 DEFAULT CHARSET=utf8 COMMENT='结算策略信息表';

-- ----------------------------
-- Records of bcs_settle_strategy
-- ----------------------------
INSERT INTO `bcs_settle_strategy` VALUES ('1', '测试结算策略名称', '1,2', '2', '3', 'T+1', '', '2,3', null, '2', 'T+1', 'W+2', '1', '2014-06-16 09:57:52', '10000', '1');
INSERT INTO `bcs_settle_strategy` VALUES ('3', '测试1', '1,2,3', null, '0', null, null, '70', '0', '2', 'T+2', 'W+2', '2', '2014-06-17 14:29:28', '999999999', '0');
INSERT INTO `bcs_settle_strategy` VALUES ('4', '测试2', '1,2', '1', '3', null, 'W+2', '88,87', '2', '1', 'T+3', 'W+2', '2', '2014-06-17 16:24:12', '999999999', '0');
INSERT INTO `bcs_settle_strategy` VALUES ('5', '测试01', '1,2,3', null, null, null, null, '88', '1', '2', 'T+5', null, '2', '2014-06-25 16:49:30', '999999999', '0');
INSERT INTO `bcs_settle_strategy` VALUES ('6', '测试02', '1,2,3', '1', '1', 'T+0', null, '1000000115,1000000114', '1', '1', 'T+0', 'W+2', '2', '2014-06-25 16:51:29', '999999999', '0');
INSERT INTO `bcs_settle_strategy` VALUES ('7', '测试03', '1,2,3', null, null, null, null, '87', '1', '1', null, null, '2', '2014-06-26 08:52:50', '999999999', '0');
INSERT INTO `bcs_settle_strategy` VALUES ('8', '测试04', '1,2,3', null, null, null, null, '84', '1', '2', 'T+3', null, '2', '2014-06-26 10:27:28', '999999999', '0');
INSERT INTO `bcs_settle_strategy` VALUES ('11000001', '提现结算策略', '1,2,3', '1', '2', 'T+1', null, null, null, null, null, null, '1', '2014-06-26 14:42:51', '100000000', '1');
INSERT INTO `bcs_settle_strategy` VALUES ('11000002', 'AB结算策略（勿删）', '1,2', '1', '2', 'T+4', '', '', null, null, null, null, '1', '2014-06-16 11:22:43', '10000', '1');
INSERT INTO `bcs_settle_strategy` VALUES ('11000003', '11231rrt', '3,4', '1', '1', 'T+0', null, null, null, null, null, null, '2', '2014-08-14 16:47:57', '1000004431', '1');
INSERT INTO `bcs_settle_strategy` VALUES ('11000004', '玩儿', '1,2,3,4', '2', null, null, null, null, null, null, null, null, '2', '2014-08-14 16:53:17', '1000004434', '0');
INSERT INTO `bcs_settle_strategy` VALUES ('11000005', '额2额', '1', '2', null, null, null, null, null, null, null, null, '2', '2014-08-14 16:58:21', '1000004434', '1');
INSERT INTO `bcs_settle_strategy` VALUES ('11000006', 'new', '1,2,3,4', '1', '1', '0', null, '1000000127', '2', null, null, null, '2', '2014-08-19 16:40:35', '1', '0');
INSERT INTO `bcs_settle_strategy` VALUES ('11000007', 'test', '1', '2', null, null, null, null, null, null, null, null, '2', '2014-08-19 17:09:26', '1', '0');

-- ----------------------------
-- Table structure for `bcs_settle_strategy_rules`
-- ----------------------------
DROP TABLE IF EXISTS `bcs_settle_strategy_rules`;
CREATE TABLE `bcs_settle_strategy_rules` (
  `RULES_ID` int(10) NOT NULL AUTO_INCREMENT COMMENT '策略规则信息编号',
  `SETTLE_STRATEGY_ID` int(10) NOT NULL COMMENT '结算策略编号',
  `ACCOUNT_LEVEL` int(2) NOT NULL COMMENT '账户等级',
  `SETTLE_AUTO` int(2) NOT NULL COMMENT '是否自动结算 1-是   2-否',
  `SETTLE_WAY` int(2) DEFAULT NULL COMMENT '结算方式  1-即时结算   2-周期结算   3-定时结算',
  `SETTLE_CYCLE` varchar(50) DEFAULT NULL COMMENT '结算周期 T+(0,1,2...)模式',
  `SETTLE_TIME` varchar(50) DEFAULT NULL COMMENT '定时结算时间  W+/M+模式',
  `STATUS` int(2) NOT NULL COMMENT '1-正常   0-注销',
  PRIMARY KEY (`RULES_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COMMENT='策略规则信息表';

-- ----------------------------
-- Records of bcs_settle_strategy_rules
-- ----------------------------
INSERT INTO `bcs_settle_strategy_rules` VALUES ('1', '1', '1', '2', '1', 'T+1', null, '1');
INSERT INTO `bcs_settle_strategy_rules` VALUES ('2', '11000002', '1', '2', '3', 'T+4', null, '1');
INSERT INTO `bcs_settle_strategy_rules` VALUES ('3', '3', '1', '2', '3', 'T+4', null, '1');
INSERT INTO `bcs_settle_strategy_rules` VALUES ('6', '7', '1', '1', '3', '', 'W+1', '1');
INSERT INTO `bcs_settle_strategy_rules` VALUES ('7', '7', '2', '1', '2', 'T+5', '', '1');
INSERT INTO `bcs_settle_strategy_rules` VALUES ('9', '8', '1', '1', '1', 'T+0', '', '1');
INSERT INTO `bcs_settle_strategy_rules` VALUES ('10', '8', '1', '1', '1', 'T+0', '', '1');
INSERT INTO `bcs_settle_strategy_rules` VALUES ('15', '4', '1', '1', '2', 'T+30', '', '1');
INSERT INTO `bcs_settle_strategy_rules` VALUES ('16', '6', '2', '1', '2', 'T+21', '', '1');
INSERT INTO `bcs_settle_strategy_rules` VALUES ('19', '11000003', '1', '1', '3', '', 'M+1', '1');
INSERT INTO `bcs_settle_strategy_rules` VALUES ('20', '11000006', '1', '2', null, '', '', '1');
INSERT INTO `bcs_settle_strategy_rules` VALUES ('21', '11000006', '1', '2', null, '', '', '1');

-- ----------------------------
-- Table structure for `bcs_settle_trade_records`
-- ----------------------------
DROP TABLE IF EXISTS `bcs_settle_trade_records`;
CREATE TABLE `bcs_settle_trade_records` (
  `TRADE_RECORD_ID` int(10) NOT NULL,
  `CUS_ID` int(10) DEFAULT NULL,
  `TRADE_SN` varchar(50) NOT NULL,
  `BANK_CARD_NUM` varchar(50) NOT NULL,
  `TYPE` int(2) NOT NULL COMMENT '1--�跽   2--����',
  `RZ_DATE` datetime NOT NULL,
  `RZ_BALANCE` double(10,2) NOT NULL,
  `PZH` varchar(50) NOT NULL,
  `BALANCE` double(10,2) NOT NULL,
  `USERS` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`TRADE_RECORD_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='�����˻�������ϸ';

-- ----------------------------
-- Records of bcs_settle_trade_records
-- ----------------------------

-- ----------------------------
-- Table structure for `bcs_strategy`
-- ----------------------------
DROP TABLE IF EXISTS `bcs_strategy`;
CREATE TABLE `bcs_strategy` (
  `STRATEGY_ID` int(10) NOT NULL AUTO_INCREMENT COMMENT '计费策略编号',
  `STRATEGY_NAME` varchar(50) NOT NULL COMMENT '计费策略名称',
  `IS_SYSTEM` int(2) NOT NULL COMMENT '是否是系统定义 1-是  2-否',
  `DEFAULT_ACCOUNT_LEVEL` varchar(150) DEFAULT NULL COMMENT '1-普通账户  2-中级账户  3-高级账户  99-所有账户',
  `DEFAULT_COST_WAY` int(2) DEFAULT NULL COMMENT '1-按次   2-扣率',
  `DEFAULT_COST_PERCENT` varchar(50) DEFAULT NULL COMMENT '1-1元/次   2-0.3%   3-0.1%',
  `OTHER_ACCOUNT_ID` varchar(255) DEFAULT NULL COMMENT '12345,34545,45678',
  `OTHER_COST_WAY` int(2) DEFAULT NULL COMMENT '1-按次   2-扣率',
  `OTHER_COST_PERCENT` varchar(50) DEFAULT NULL COMMENT '1-1元/次   2-0.3%   3-0.1%',
  `ADD_TIME` datetime NOT NULL COMMENT '添加时间',
  `STATUS` int(2) NOT NULL COMMENT '0-暂停 1-启用',
  PRIMARY KEY (`STRATEGY_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10000008 DEFAULT CHARSET=utf8 COMMENT='业务计费策略表';

-- ----------------------------
-- Records of bcs_strategy
-- ----------------------------
INSERT INTO `bcs_strategy` VALUES ('1', '充值', '1', '1', '1', '1', '1', '1', '1', '2014-05-16 10:50:35', '1');
INSERT INTO `bcs_strategy` VALUES ('2', '充值策略', '2', '1,2,3', null, null, '67,65', '1', '1', '2014-06-13 14:09:02', '0');
INSERT INTO `bcs_strategy` VALUES ('3', '测试计费代码名称', '1', '1,2,3', '2', '0.3%', '2,3,4', '1', '1元/次', '2014-06-16 09:11:55', '1');
INSERT INTO `bcs_strategy` VALUES ('6', 'ceshi', '2', '1,2', '1', '每周一次', '88,87', '2', '3%', '2014-06-18 12:37:03', '0');
INSERT INTO `bcs_strategy` VALUES ('7', '交易撤销策略（勿删）', '1', '1,2', '2', '0', null, null, null, '2014-06-19 12:36:15', '1');
INSERT INTO `bcs_strategy` VALUES ('10000001', '提现', '1', '1,2,3', '2', '0', null, null, null, '2014-06-26 14:39:22', '1');
INSERT INTO `bcs_strategy` VALUES ('10000004', 'AB计费策略（勿删）', '1', '1,2', '2', '0.3', '2,3,4', '1', '1', '2014-06-16 11:12:53', '1');
INSERT INTO `bcs_strategy` VALUES ('10000005', '充值计费策略（勿删）', '1', '1,2', '2', '0.0', null, null, null, '2014-06-17 14:59:44', '1');
INSERT INTO `bcs_strategy` VALUES ('10000006', '测试', '2', '1,2,3,4', '1', null, null, null, null, '2014-08-14 13:06:20', '1');
INSERT INTO `bcs_strategy` VALUES ('10000007', '12121212', '2', '1,2,3,4', '2', null, null, null, null, '2014-08-14 16:34:10', '1');

-- ----------------------------
-- Table structure for `bcs_strategy_code`
-- ----------------------------
DROP TABLE IF EXISTS `bcs_strategy_code`;
CREATE TABLE `bcs_strategy_code` (
  `CODE_ID` int(10) NOT NULL AUTO_INCREMENT COMMENT '计费策略规则编号',
  `STRATEGY_ID` int(10) NOT NULL COMMENT '计费策略编号',
  `ACCOUNT_LEVEL` int(2) NOT NULL COMMENT '1-普通账户；2-中级账户；3-高级账户 ; 99-所有账户',
  `COST_WAY` int(2) NOT NULL COMMENT '1-按次；2-扣率',
  `COST_PERCENT` varchar(50) NOT NULL COMMENT '1-1元/次；2-0.3%；3-0.1%',
  `STATUS` int(2) NOT NULL COMMENT '0-无效 1-有效',
  PRIMARY KEY (`CODE_ID`),
  KEY `FK_Reference_2` (`STRATEGY_ID`),
  CONSTRAINT `FK_Reference_2` FOREIGN KEY (`strategy_id`) REFERENCES `bcs_strategy` (`strategy_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COMMENT='业务计费策略账户类型配置表';

-- ----------------------------
-- Records of bcs_strategy_code
-- ----------------------------
INSERT INTO `bcs_strategy_code` VALUES ('3', '2', '2', '2', '1%', '1');
INSERT INTO `bcs_strategy_code` VALUES ('4', '2', '1', '1', '1', '1');
INSERT INTO `bcs_strategy_code` VALUES ('5', '3', '1', '1', '0.08%', '1');
INSERT INTO `bcs_strategy_code` VALUES ('18', '6', '3', '2', '2%', '1');
INSERT INTO `bcs_strategy_code` VALUES ('19', '6', '1', '1', '每周1次', '1');
INSERT INTO `bcs_strategy_code` VALUES ('20', '10000006', '1', '2', '3', '1');
INSERT INTO `bcs_strategy_code` VALUES ('21', '10000007', '1', '2', '3', '1');

-- ----------------------------
-- Table structure for `bcs_wait_bills`
-- ----------------------------
DROP TABLE IF EXISTS `bcs_wait_bills`;
CREATE TABLE `bcs_wait_bills` (
  `WAIT_BILLS_ID` int(10) NOT NULL AUTO_INCREMENT COMMENT '结算账单编号',
  `ACCOUNT_ID` int(10) NOT NULL,
  `OPT_NUMBER` varchar(50) NOT NULL COMMENT '操作流水号',
  `CREATE_TIME` datetime NOT NULL COMMENT '创建时间',
  `BUSINESS_NAME` varchar(50) NOT NULL COMMENT '业务名称',
  `BUSINESS_ID` int(10) NOT NULL COMMENT '业务编号',
  `COST_WAY` int(2) NOT NULL COMMENT '扣费方式',
  `COST_PERCENT` varchar(50) NOT NULL COMMENT '扣费费率',
  `STRATEGY_ID` int(10) NOT NULL COMMENT '计费策略编号',
  `TIPS_GET_STEP` int(2) NOT NULL COMMENT '手续费计收步骤',
  `SETTLE_STRATEGY_ID` int(10) NOT NULL COMMENT '结算策略编号',
  `SETTLE_AUTO` int(2) NOT NULL COMMENT '是否是自动结算',
  `SETTLE_WAY` int(2) NOT NULL COMMENT '结算方式',
  `SETTLE_CYCLE` varchar(50) NOT NULL COMMENT '结算周期',
  `OPT_LOCK` varchar(50) NOT NULL COMMENT '操作',
  `UNDO_TIME` datetime DEFAULT NULL COMMENT '撤销时间',
  `RELATE_ACCOUNT_ID` int(10) DEFAULT NULL COMMENT '关联账户',
  `STATUS` int(2) NOT NULL COMMENT '状态',
  `MONEY_DIRECTION` int(2) NOT NULL COMMENT '资金方向',
  `WAIT_BILLING_BALANCE` double(10,2) NOT NULL COMMENT '待下账金额',
  `EXECUTE_TIME` datetime NOT NULL COMMENT '执行时间',
  `PROCESS_STATUS` int(2) NOT NULL COMMENT '处理状态 1 待下账  2 已下账 3 下账失败',
  `REMARK` varchar(255) DEFAULT NULL COMMENT '待下账备注',
  PRIMARY KEY (`WAIT_BILLS_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='待下账账单';

-- ----------------------------
-- Records of bcs_wait_bills
-- ----------------------------
INSERT INTO `bcs_wait_bills` VALUES ('2', '10', '1002900120140701091256364149', '2014-07-01 09:08:21', '订单交易（勿删）', '3', '2', '0.3', '10000004', '2', '11000002', '1', '2', 'T+4', 'E10ADC3949BA59ABBE56E057F20F883E', null, null, '1', '2', '61.81', '2014-07-05 09:08:21', '1', '订单交易-卖家[待下账]订单虚拟账户支付-交易');
INSERT INTO `bcs_wait_bills` VALUES ('3', '10', '1002900120140701111134539469', '2014-07-01 11:06:58', '订单交易（勿删）', '3', '2', '0.3', '10000004', '2', '11000002', '1', '2', 'T+4', 'E10ADC3949BA59ABBE56E057F20F883E', null, null, '1', '2', '29.91', '2014-07-05 11:06:58', '1', '订单交易-卖家[待下账]订单虚拟账户支付-交易');
INSERT INTO `bcs_wait_bills` VALUES ('4', '10', '1002900120140702171851944029', '2014-07-02 17:14:16', '订单交易（勿删）', '3', '2', '0.3', '10000004', '2', '11000002', '1', '2', 'T+4', 'E10ADC3949BA59ABBE56E057F20F883E', null, null, '1', '2', '29.91', '2014-07-06 17:14:16', '1', '订单交易-卖家[待下账]订单虚拟账户支付-交易');
INSERT INTO `bcs_wait_bills` VALUES ('5', '10', '1002900120140709162122836945', '2014-07-09 16:21:31', '订单交易（勿删）', '3', '2', '0.3', '10000004', '2', '11000002', '1', '2', 'T+4', 'E10ADC3949BA59ABBE56E057F20F883E', null, null, '1', '2', '61.81', '2014-07-13 16:21:31', '1', '订单交易-卖家[待下账]订单虚拟账户支付-交易');
INSERT INTO `bcs_wait_bills` VALUES ('6', '10', '1002900120140721141439404345', '2014-07-21 14:14:46', '订单交易（勿删）', '3', '2', '0.3', '10000004', '2', '11000002', '1', '2', 'T+4', 'E10ADC3949BA59ABBE56E057F20F883E', null, null, '1', '2', '11.96', '2014-07-25 14:14:46', '1', '订单交易-卖家[待下账]订单虚拟账户支付-交易');
INSERT INTO `bcs_wait_bills` VALUES ('7', '10', '1001900120140721141545253527', '2014-07-21 14:16:18', '订单交易（勿删）', '3', '2', '0.3', '10000004', '2', '11000002', '1', '2', 'T+4', 'E10ADC3949BA59ABBE56E057F20F883E', null, null, '1', '2', '0.01', '2014-07-25 14:16:18', '1', '订单交易-卖家[待下账]订单支付-交易');

-- ----------------------------
-- Table structure for `count_account`
-- ----------------------------
DROP TABLE IF EXISTS `count_account`;
CREATE TABLE `count_account` (
  `account_id` int(10) NOT NULL,
  `account_balance` double(15,2) NOT NULL COMMENT '账户余额',
  `account_count_time` datetime NOT NULL COMMENT '统计时间',
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='每日记录账户俄 ';

-- ----------------------------
-- Records of count_account
-- ----------------------------
INSERT INTO `count_account` VALUES ('1', '23444333.00', '2014-07-06 15:50:41', '1');
INSERT INTO `count_account` VALUES ('2', '33334.00', '2014-07-07 15:50:05', '2');
INSERT INTO `count_account` VALUES ('3', '22222222.00', '2014-07-06 15:51:16', '3');
INSERT INTO `count_account` VALUES ('4', '155666666.00', '2014-06-29 15:53:59', '4');
INSERT INTO `count_account` VALUES ('5', '1234552.00', '2014-06-24 15:54:18', '5');
INSERT INTO `count_account` VALUES ('6', '10004.00', '2014-06-18 15:56:18', '6');
INSERT INTO `count_account` VALUES ('7', '1223556.00', '2014-06-12 13:04:07', '7');
INSERT INTO `count_account` VALUES ('8', '333334555.00', '2014-07-01 13:04:34', '8');
INSERT INTO `count_account` VALUES ('9', '1233234.00', '2014-06-21 13:04:53', '9');
INSERT INTO `count_account` VALUES ('10', '33333333.00', '2014-06-14 13:05:15', '10');
INSERT INTO `count_account` VALUES ('11', '100000.00', '2014-06-09 13:05:51', '11');
INSERT INTO `count_account` VALUES ('12', '2223455.00', '2014-07-08 09:37:08', '12');
INSERT INTO `count_account` VALUES ('13', '9999999.99', '2014-07-09 09:37:22', '13');
INSERT INTO `count_account` VALUES ('14', '200000.00', '2014-07-10 09:37:40', '14');

-- ----------------------------
-- Table structure for `sys_bcs_code`
-- ----------------------------
DROP TABLE IF EXISTS `sys_bcs_code`;
CREATE TABLE `sys_bcs_code` (
  `CODE_TYPE` varchar(50) NOT NULL,
  `CODE_NAME` varchar(50) NOT NULL,
  `CODE_KEY` int(8) NOT NULL,
  `CODE_VALUE` varchar(50) NOT NULL,
  `ADD_TIME` datetime NOT NULL,
  `STATUS` int(2) NOT NULL,
  PRIMARY KEY (`CODE_TYPE`,`CODE_KEY`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='���';

-- ----------------------------
-- Records of sys_bcs_code
-- ----------------------------
