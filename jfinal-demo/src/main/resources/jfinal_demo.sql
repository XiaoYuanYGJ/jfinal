/*
Navicat MySQL Data Transfer

Source Server         : admin
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : jfinal_demo

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-07-29 22:59:28
*/

SET FOREIGN_KEY_CHECKS=0;


-- ----------------------------
-- Table structure for `native`
-- ----------------------------
DROP TABLE IF EXISTS `native`;
CREATE TABLE `native` (
  `nId` int(11) NOT NULL AUTO_INCREMENT,
  `nTitle` varchar(200) NOT NULL,
  `nContent` mediumtext,
  `nPicpath` varchar(1000) DEFAULT NULL,
  `uId` int(11) NOT NULL,
  `createTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`nId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of native
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(200) NOT NULL,
  `password` varchar(200) NOT NULL,
  `gender` char(1) NOT NULL,
  `picUrl` varchar(1000) DEFAULT NULL,
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', 'admin', '1', null, '2018-07-29 21:55:50');
INSERT INTO `user` VALUES ('2', 'ceshi', 'ceshi', '0', null, '2018-07-29 22:10:03');
