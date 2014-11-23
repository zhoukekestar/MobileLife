/*
Navicat MySQL Data Transfer

Source Server         : 10.64.130.124_3306
Source Server Version : 50611
Source Host           : 10.64.130.124:3306
Source Database       : mybatis

Target Server Type    : MYSQL
Target Server Version : 50611
File Encoding         : 65001

Date: 2014-11-12 18:53:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `title` varchar(100) NOT NULL,
  `content` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('1', '1', 'test_title', 'test_content');
INSERT INTO `article` VALUES ('2', '1', 'test_title_2', 'test_content_2');
INSERT INTO `article` VALUES ('3', '1', 'test_title_3', 'test_content_3');
INSERT INTO `article` VALUES ('4', '1', 'test_title_4', 'test_content_4');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(50) DEFAULT NULL,
  `userAge` int(11) DEFAULT NULL,
  `userAddress` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'summer', '100', 'b1d6c67c-d6ea-441d-aa6b-e10c95d11ac0');
INSERT INTO `user` VALUES ('9', 'summer', '100', '4e2714f6-a247-45b3-9a13-0597807fb801');
