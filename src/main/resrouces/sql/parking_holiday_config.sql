/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50719
 Source Host           : localhost:3306
 Source Schema         : carfree_park

 Target Server Type    : MySQL
 Target Server Version : 50719
 File Encoding         : 65001

 Date: 08/08/2018 18:34:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for parking_holiday_config
-- ----------------------------
DROP TABLE IF EXISTS `parking_holiday_config`;
CREATE TABLE `parking_holiday_config`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `holiday_year` int(4) NOT NULL COMMENT '年份',
  `start_date` date NOT NULL COMMENT '开始日期',
  `end_date` date NOT NULL COMMENT '结束日期',
  `holiday_type` tinyint(1) NOT NULL COMMENT '节假日类型',
  `operator` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '操作人Id',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最近修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '节假日配置表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of parking_holiday_config
-- ----------------------------
INSERT INTO `parking_holiday_config` VALUES (15, 2018, '2018-09-01', '2018-09-10', 7, '马亮', '2018-07-25 16:48:54', '2018-08-01 13:40:33');
INSERT INTO `parking_holiday_config` VALUES (16, 2018, '2018-08-20', '2018-08-30', 6, '马亮', '2018-07-26 13:17:43', '2018-08-01 13:40:20');
INSERT INTO `parking_holiday_config` VALUES (17, 2018, '2018-07-01', '2018-07-02', 1, '马亮', '2018-07-26 14:17:20', '2018-08-02 09:44:02');
INSERT INTO `parking_holiday_config` VALUES (18, 2018, '2018-07-10', '2018-07-20', 2, '马亮', '2018-07-26 14:17:28', '2018-08-01 13:39:14');
INSERT INTO `parking_holiday_config` VALUES (19, 2018, '2018-07-20', '2018-07-30', 3, '马亮', '2018-07-26 14:17:37', '2018-08-01 13:39:25');
INSERT INTO `parking_holiday_config` VALUES (20, 2018, '2018-07-02', '2018-07-03', 4, '马亮', '2018-07-26 14:24:03', '2018-08-02 09:44:21');
INSERT INTO `parking_holiday_config` VALUES (21, 2018, '2018-08-10', '2018-08-20', 5, '马亮', '2018-07-26 14:24:17', '2018-08-01 13:39:58');

SET FOREIGN_KEY_CHECKS = 1;
