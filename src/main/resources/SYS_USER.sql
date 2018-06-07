/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : khj

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2018-03-26 20:51:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `USER_ID` varchar(32) NOT NULL,
  `USER_NAME` varchar(64) DEFAULT NULL,
  `TELPHONE` varchar(20) DEFAULT NULL,
  `WEIXIN` varchar(64) DEFAULT NULL,
  `NICK_NAME` varchar(64) DEFAULT NULL,
  `SEX` varchar(1) DEFAULT NULL,
  `PROVINCE` varchar(32) DEFAULT NULL,
  `CITY` varchar(32) DEFAULT NULL,
  `BIRTHDAY` varchar(20) DEFAULT NULL,
  `XINGZUO` varchar(8) DEFAULT NULL,
  `SCHOOL` varchar(64) DEFAULT NULL,
  `XUELI` varchar(64) DEFAULT NULL,
  `ZIYE` varchar(64) DEFAULT NULL,
  `CZJL` varchar(512) DEFAULT NULL,
  `XGTD` varchar(512) DEFAULT NULL,
  `YYSJ` varchar(512) DEFAULT NULL,
  `WLQD` varchar(512) DEFAULT NULL,
  `ZWBQ` varchar(32) DEFAULT NULL,
  `YYAH` varchar(32) DEFAULT NULL,
  `XHCW` varchar(32) DEFAULT NULL,
  `DYLX` varchar(32) DEFAULT NULL,
  `PPCP` varchar(32) DEFAULT NULL,
  `DFZY` varchar(32) DEFAULT NULL,
  `DFNLD` varchar(8) DEFAULT NULL,
  `DFNLX` varchar(8) DEFAULT NULL,
  `DFXL` varchar(32) DEFAULT NULL,
  `DFXZ` varchar(32) DEFAULT NULL,
  `CREATE_TIME` varchar(19) DEFAULT NULL,
  `STATE` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('8a92a10c62625cfc0162625cfca00000', null, '', '', 'asdf', '', '', null, '', '', '', '', '', '', '', '', null, null, null, null, null, null, null, null, null, null, null, null, null);
