/*
 Navicat Premium Data Transfer

 Source Server         : test
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost:3306
 Source Schema         : company_eat_db

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

 Date: 25/06/2018 17:56:24
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for order_detail
-- ----------------------------
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail`  (
  `detail_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `order_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品名称',
  `product_price` decimal(8, 2) NOT NULL COMMENT '商品价格',
  `product_quantity` int(11) NOT NULL COMMENT '商品数量',
  `product_icon` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品小图',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`detail_id`) USING BTREE,
  INDEX `idx_order_id`(`order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单详情' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_detail
-- ----------------------------
INSERT INTO `order_detail` VALUES ('112233', '123456', 'product2', '名称', 21.00, 1, 'http://asdas.png', '2018-06-20 16:26:18', '2018-06-22 17:16:09');
INSERT INTO `order_detail` VALUES ('1122331', '123456', 'product3', '麻婆豆腐', 21.00, 3, 'http://asdas.png', '2018-06-20 16:26:45', '2018-06-22 17:15:23');
INSERT INTO `order_detail` VALUES ('11223312', '123456', '123456', '麻辣烫', 3.20, 24, 'http://asdas.png', '2018-06-20 16:28:31', '2018-06-22 17:15:45');
INSERT INTO `order_detail` VALUES ('1529895153126931397', '1529895153079886843', '123456', '麻辣烫', 3.20, 2, 'http:img.png', '2018-06-25 10:52:33', '2018-06-25 10:52:33');
INSERT INTO `order_detail` VALUES ('1529895376811912278', '1529895376769369223', '123456', '麻辣烫', 3.20, 2, 'http:img.png', '2018-06-25 10:56:17', '2018-06-25 10:56:17');
INSERT INTO `order_detail` VALUES ('1529895720362437551', '1529895720099595850', '123456', '麻辣烫', 3.20, 2, 'http:img.png', '2018-06-25 11:02:00', '2018-06-25 11:02:00');
INSERT INTO `order_detail` VALUES ('1529895864238963866', '1529895864198168727', '123456', '麻辣烫', 3.20, 2, 'http:img.png', '2018-06-25 11:04:24', '2018-06-25 11:04:24');
INSERT INTO `order_detail` VALUES ('1529918517320954474', '1529918517275259534', '123456', '麻辣烫', 3.20, 2, 'http:img.png', '2018-06-25 17:21:57', '2018-06-25 17:21:57');
INSERT INTO `order_detail` VALUES ('1529918585584709670', '1529918585536796879', '123456', '麻辣烫', 3.20, 2, 'http:img.png', '2018-06-25 17:23:06', '2018-06-25 17:23:06');
INSERT INTO `order_detail` VALUES ('1529918647548902317', '1529918647509542730', '123456', '麻辣烫', 3.20, 2, 'http:img.png', '2018-06-25 17:24:08', '2018-06-25 17:24:08');
INSERT INTO `order_detail` VALUES ('1529918676524665816', '1529918676480297676', '123456', '麻辣烫', 3.20, 2, 'http:img.png', '2018-06-25 17:24:36', '2018-06-25 17:24:36');
INSERT INTO `order_detail` VALUES ('1529918731409542816', '1529918731366463787', '123456', '麻辣烫', 3.20, 2, 'http:img.png', '2018-06-25 17:25:31', '2018-06-25 17:25:31');

-- ----------------------------
-- Table structure for order_master
-- ----------------------------
DROP TABLE IF EXISTS `order_master`;
CREATE TABLE `order_master`  (
  `order_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `buyer_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '买家名字',
  `buyer_phone` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '买家电话',
  `buyer_address` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '买家地址',
  `buyer_openid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '买家微信的openid',
  `order_amount` decimal(8, 2) NOT NULL COMMENT '订单总金额',
  `order_status` tinyint(3) NOT NULL DEFAULT 0 COMMENT '订单状态,默认0新下单',
  `pay_status` tinyint(3) NOT NULL DEFAULT 0 COMMENT '支付状态，默认0未支付',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间,',
  PRIMARY KEY (`order_id`) USING BTREE,
  INDEX `idx_buyer_openid`(`buyer_openid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单主表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_master
-- ----------------------------
INSERT INTO `order_master` VALUES ('123456', '冰冰', '18942335915', '上海市', '110110', 2.30, 0, 0, '2018-06-20 16:03:53', '2018-06-20 16:03:53');
INSERT INTO `order_master` VALUES ('1234567', '冰冰', '18942335915', '上海市', '110110', 2.30, 0, 0, '2018-06-20 16:10:09', '2018-06-20 16:10:09');
INSERT INTO `order_master` VALUES ('1529895153079886843', '张三', '18598745612', '慕课网总部', '123456789', 6.40, 2, 0, '2018-06-25 10:52:33', '2018-06-25 11:49:53');
INSERT INTO `order_master` VALUES ('1529895376769369223', '张三', '18598745612', '慕课网总部', '123456789', 6.40, 0, 0, '2018-06-25 10:56:17', '2018-06-25 10:56:17');
INSERT INTO `order_master` VALUES ('1529895720099595850', '张三', '18598745612', '慕课网总部', '123456789', 6.40, 0, 0, '2018-06-25 11:02:00', '2018-06-25 11:02:00');
INSERT INTO `order_master` VALUES ('1529895864198168727', '张三', '18598745612', '慕课网总部', '123456789', 6.40, 0, 0, '2018-06-25 11:04:24', '2018-06-25 11:04:24');
INSERT INTO `order_master` VALUES ('1529918517275259534', '张三', '18598745612', '慕课网总部', '123456789', 6.40, 0, 0, '2018-06-25 17:21:57', '2018-06-25 17:21:57');
INSERT INTO `order_master` VALUES ('1529918585536796879', '张三', '18598745612', '慕课网总部', '123456789', 6.40, 0, 0, '2018-06-25 17:23:06', '2018-06-25 17:23:06');
INSERT INTO `order_master` VALUES ('1529918647509542730', '张三', '18598745612', '慕课网总部', '123456789', 6.40, 0, 0, '2018-06-25 17:24:08', '2018-06-25 17:24:08');
INSERT INTO `order_master` VALUES ('1529918676480297676', '张三', '18598745612', '慕课网总部', '123456789', 6.40, 0, 0, '2018-06-25 17:24:36', '2018-06-25 17:24:36');
INSERT INTO `order_master` VALUES ('1529918731366463787', '张三', '18598745612', '慕课网总部', '123456789', 6.40, 0, 0, '2018-06-25 17:25:31', '2018-06-25 17:25:31');

-- ----------------------------
-- Table structure for product_category
-- ----------------------------
DROP TABLE IF EXISTS `product_category`;
CREATE TABLE `product_category`  (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '类目名字',
  `category_type` int(11) NOT NULL COMMENT '类目编号',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间,',
  PRIMARY KEY (`category_id`) USING BTREE,
  UNIQUE INDEX `uqe_category_type`(`category_type`) USING BTREE COMMENT 'unique key 主要是用来防止数据插入的时候重复的'
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '类目表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product_category
-- ----------------------------
INSERT INTO `product_category` VALUES (1, '热销榜', 2, '2018-06-19 14:31:18', '2018-06-19 14:31:18');
INSERT INTO `product_category` VALUES (2, '老夫子最爱', 3, '2018-06-19 15:44:58', '2018-06-19 15:44:58');
INSERT INTO `product_category` VALUES (4, '男生最爱', 1, '2018-06-19 15:16:08', '2018-06-19 15:16:08');
INSERT INTO `product_category` VALUES (5, '老生最爱', 4, '2018-06-19 15:27:44', '2018-06-19 15:27:44');
INSERT INTO `product_category` VALUES (8, '老子最爱', 5, '2018-06-19 15:40:00', '2018-06-19 15:40:00');
INSERT INTO `product_category` VALUES (9, '哈哈', 6, '2018-06-19 16:46:27', '2018-06-19 16:46:27');

-- ----------------------------
-- Table structure for product_info
-- ----------------------------
DROP TABLE IF EXISTS `product_info`;
CREATE TABLE `product_info`  (
  `product_id` varchar(21) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品名称',
  `product_price` decimal(8, 2) NOT NULL COMMENT '单价，8位，2个小数点',
  `product_stock` int(11) NOT NULL COMMENT '库存',
  `product_description` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `product_icon` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '小图链接',
  `category_type` int(11) NOT NULL COMMENT '类目编号',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间,on update 是更新的时候mysql自动更新该字段',
  `product_status` tinyint(255) NOT NULL DEFAULT 0 COMMENT '商品的状态，0正常，1下架',
  PRIMARY KEY (`product_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product_info
-- ----------------------------
INSERT INTO `product_info` VALUES ('123456', '麻辣烫', 3.20, 102, '这个很好吃', 'http:img.png', 1, '2018-06-19 17:03:52', '2018-06-19 17:03:52', 0);
INSERT INTO `product_info` VALUES ('product2', '名称', 21.00, 25, '这个很好哦', 'http://xxxaaaa.png', 1, '2018-06-20 11:25:05', '2018-06-20 14:18:38', 0);
INSERT INTO `product_info` VALUES ('product3', '麻婆豆腐', 21.00, 25, '这个很好哦', 'http://xxxaaaa.png', 1, '2018-06-20 11:25:05', '2018-06-20 14:18:38', 0);

SET FOREIGN_KEY_CHECKS = 1;
