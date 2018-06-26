/*
 Navicat Premium Data Transfer

 Source Server         : MySQL80
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost:3306
 Source Schema         : backstage

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

 Date: 26/06/2018 22:18:00
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_clothings
-- ----------------------------
DROP TABLE IF EXISTS `t_clothings`;
CREATE TABLE `t_clothings`  (
  `ClothingCode` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '货号',
  `ClothingColor` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '色号\r\n',
  `ClothingSize` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '尺码',
  `ClothingName` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '品名',
  `ClothingOuterM` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '面料',
  `ClothingInnerM` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '里料',
  `ClothingPrice` float(10, 2) NULL DEFAULT NULL COMMENT '成本价',
  `ClothingFlag` tinyint(255) NULL DEFAULT 0 COMMENT '删除状 默认为0',
  PRIMARY KEY (`ClothingCode`, `ClothingColor`, `ClothingSize`) USING BTREE,
  INDEX `ClothingCode`(`ClothingCode`) USING BTREE,
  INDEX `ClothingColor`(`ClothingColor`) USING BTREE,
  INDEX `ClothingSize`(`ClothingSize`) USING BTREE,
  INDEX `ClothingCode_2`(`ClothingCode`) USING BTREE,
  INDEX `ClothingColor_2`(`ClothingColor`) USING BTREE,
  INDEX `ClothingSize_2`(`ClothingSize`) USING BTREE,
  INDEX `ClothingCode_3`(`ClothingCode`) USING BTREE,
  INDEX `ClothingColor_3`(`ClothingColor`) USING BTREE,
  INDEX `ClothingSize_3`(`ClothingSize`) USING BTREE,
  INDEX `ClothingCode_4`(`ClothingCode`) USING BTREE,
  INDEX `ClothingColor_4`(`ClothingColor`) USING BTREE,
  INDEX `ClothingSize_4`(`ClothingSize`) USING BTREE,
  INDEX `ClothingCode_5`(`ClothingCode`) USING BTREE,
  INDEX `ClothingColor_5`(`ClothingColor`) USING BTREE,
  INDEX `ClothingSize_5`(`ClothingSize`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_clothings
-- ----------------------------
INSERT INTO `t_clothings` VALUES ('0', '0', '0', '0', '0', '0', 0.00, 0);
INSERT INTO `t_clothings` VALUES ('1', '1', '1', '1', NULL, NULL, 1.00, 0);
INSERT INTO `t_clothings` VALUES ('11', 'Cyan', '165', '11', NULL, NULL, 11.00, 0);
INSERT INTO `t_clothings` VALUES ('111', 'Yellow', '170', '222', NULL, NULL, 222.00, 0);
INSERT INTO `t_clothings` VALUES ('13', 'Orange', '170', '2', NULL, NULL, 100.00, 0);
INSERT INTO `t_clothings` VALUES ('22', 'Green', '170', '2', NULL, NULL, 222.00, 0);

-- ----------------------------
-- Table structure for t_orderdetails
-- ----------------------------
DROP TABLE IF EXISTS `t_orderdetails`;
CREATE TABLE `t_orderdetails`  (
  `OrderInDetailsOrderNo` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '单据号',
  `OrderInDetailsCode` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '货号',
  `OrderInDetailsColor` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '色号',
  `OrderInDetailsSize` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '尺码',
  `OrderInDetailsCount` int(255) NULL DEFAULT NULL COMMENT '数量',
  PRIMARY KEY (`OrderInDetailsOrderNo`, `OrderInDetailsCode`, `OrderInDetailsColor`, `OrderInDetailsSize`) USING BTREE,
  INDEX `OrderInDetailsCode`(`OrderInDetailsCode`) USING BTREE,
  INDEX `OrderInDetailsColor`(`OrderInDetailsColor`) USING BTREE,
  INDEX `OrderInDetailsSize`(`OrderInDetailsSize`) USING BTREE,
  CONSTRAINT `t_orderdetails_ibfk_2` FOREIGN KEY (`OrderInDetailsCode`) REFERENCES `t_clothings` (`clothingcode`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `t_orderdetails_ibfk_3` FOREIGN KEY (`OrderInDetailsColor`) REFERENCES `t_clothings` (`clothingcolor`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `t_orderdetails_ibfk_4` FOREIGN KEY (`OrderInDetailsSize`) REFERENCES `t_clothings` (`clothingsize`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_orderdetails
-- ----------------------------
INSERT INTO `t_orderdetails` VALUES ('10', '11', 'Cyan', '165', 11);
INSERT INTO `t_orderdetails` VALUES ('10', '111', 'Yellow', '170', 222);
INSERT INTO `t_orderdetails` VALUES ('2', '0', '1', '1', 22);
INSERT INTO `t_orderdetails` VALUES ('2', '1', '1', '1', 1);

-- ----------------------------
-- Table structure for t_orderin
-- ----------------------------
DROP TABLE IF EXISTS `t_orderin`;
CREATE TABLE `t_orderin`  (
  `OrderInNo` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '单据号',
  `OrderInDate` datetime(0) NULL DEFAULT NULL COMMENT '入库日期',
  `OrderinPerson` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '经办人',
  `OrderInWarehouse` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '所入仓库',
  `OrderInBefrom` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '来源',
  `OrderInRemark` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  `OrderInFlag` tinyint(255) NULL DEFAULT 0 COMMENT '确认状态 默认为0 确认 1 删除 2',
  PRIMARY KEY (`OrderInNo`) USING BTREE,
  INDEX `OrderInNo`(`OrderInNo`) USING BTREE,
  INDEX `OrderInNo_2`(`OrderInNo`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_orderin
-- ----------------------------
INSERT INTO `t_orderin` VALUES ('10', '2018-06-25 18:50:00', 'admin', '2', '55555', NULL, 1);
INSERT INTO `t_orderin` VALUES ('1529924133272', '2018-06-25 18:55:33', 'admin', '1', '8888888', NULL, 0);
INSERT INTO `t_orderin` VALUES ('I1529927550649', '2018-06-25 19:52:30', 'admin', '555', '77777777', NULL, 0);
INSERT INTO `t_orderin` VALUES ('In1529927585524', '2018-06-25 19:53:05', 'admin', '5', '666666', NULL, 0);

-- ----------------------------
-- Table structure for t_orderout
-- ----------------------------
DROP TABLE IF EXISTS `t_orderout`;
CREATE TABLE `t_orderout`  (
  `OrderOutNo` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '单据号',
  `OrderOutDate` datetime(0) NULL DEFAULT NULL COMMENT '出库日期',
  `OrderOutPerson` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '经办人',
  `OrderOutWarehouse` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '所出仓库',
  `OrderOutRperson` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '接收人',
  `OrderOutTel` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '接收人电话',
  `OrderOutAddress` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '接收地址',
  `OrderOutRemark` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  `OrderOutFlag` tinyint(255) NULL DEFAULT 0 COMMENT '确认状态 默认为0',
  PRIMARY KEY (`OrderOutNo`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_orderout
-- ----------------------------
INSERT INTO `t_orderout` VALUES ('1', '2018-06-25 21:48:11', '2', '2', '2', '2', NULL, NULL, 2);
INSERT INTO `t_orderout` VALUES ('2', '2018-06-26 00:35:45', '2', '2', '2', '2', '2', '2', 0);
INSERT INTO `t_orderout` VALUES ('3', '2018-06-26 00:38:30', 'admin', '555', '555', '555', NULL, NULL, 1);
INSERT INTO `t_orderout` VALUES ('Out1529944724892', '2018-06-26 00:38:44', 'admin', '3', '333', '333', NULL, NULL, 0);

-- ----------------------------
-- Table structure for t_users
-- ----------------------------
DROP TABLE IF EXISTS `t_users`;
CREATE TABLE `t_users`  (
  `UserAccount` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '1' COMMENT '用户账号',
  `UserName` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户名',
  `UserPassword` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户密码',
  `UserDescription` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户简介',
  `UserFlag` tinyint(255) NULL DEFAULT 0 COMMENT '删除状态  默认为0',
  `UserSign` tinyint(255) NULL DEFAULT 0 COMMENT '用户标记 默认为0 普通用户',
  PRIMARY KEY (`UserAccount`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_users
-- ----------------------------
INSERT INTO `t_users` VALUES ('1', '222', '2222', '2', 1, 0);
INSERT INTO `t_users` VALUES ('10', '12', '123', '1231231231231231231231232131231231232131231231231231231231232131231231231232131232131313123123131312313123123123', 1, 0);
INSERT INTO `t_users` VALUES ('2', '22', '222', '2222', 0, 0);
INSERT INTO `t_users` VALUES ('3', '333', '333', '333', 1, 0);
INSERT INTO `t_users` VALUES ('4', '44', '444', '4444', 1, 0);
INSERT INTO `t_users` VALUES ('5', '5', '5', '5', 0, 0);
INSERT INTO `t_users` VALUES ('admin', 'paul', '123', NULL, 0, 1);
INSERT INTO `t_users` VALUES ('hahahah', NULL, NULL, '2', 1, 0);

-- ----------------------------
-- Table structure for t_warehouses
-- ----------------------------
DROP TABLE IF EXISTS `t_warehouses`;
CREATE TABLE `t_warehouses`  (
  `WarehouseNo` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '仓库号',
  `WarehouseName` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '仓库名',
  `WarehouseContact` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '仓库联系人',
  `WarehouseContactTele` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '仓库联系电话',
  `WarehouseStorageCapacity` int(255) NULL DEFAULT 0 COMMENT '仓库存储量 默认为0',
  `WarehouseFlag` tinyint(255) NULL DEFAULT 0 COMMENT '删除状态 默认为0',
  PRIMARY KEY (`WarehouseNo`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_warehouses
-- ----------------------------
INSERT INTO `t_warehouses` VALUES ('1', '1', '1', '1', 0, 0);
INSERT INTO `t_warehouses` VALUES ('2', '2', '2', '2', 324, 0);
INSERT INTO `t_warehouses` VALUES ('3', '1', '1', '1', 0, 0);
INSERT INTO `t_warehouses` VALUES ('4', '4', '4', '4', 0, 0);
INSERT INTO `t_warehouses` VALUES ('5', '555', '555', '555', 466, 0);
INSERT INTO `t_warehouses` VALUES ('555', '555', '555', '555', 0, 0);

-- ----------------------------
-- Procedure structure for Proc_ChangePassword
-- ----------------------------
DROP PROCEDURE IF EXISTS `Proc_ChangePassword`;
delimiter ;;
CREATE PROCEDURE `Proc_ChangePassword`(IN `Account` VARCHAR(16) ,IN `userPassword` VARCHAR(16))
BEGIN
UPDATE t_users 
SET t_users.UserPassword = userPassword
WHERE UserAccount=Account;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Proc_CheckProduct
-- ----------------------------
DROP PROCEDURE IF EXISTS `Proc_CheckProduct`;
delimiter ;;
CREATE PROCEDURE `Proc_CheckProduct`(IN `clothingCode` VARCHAR(16))
BEGIN
SELECT COUNT(*) FROM t_clothings
WHERE t_clothings.ClothingCode = clothingCode;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Proc_CheckUser
-- ----------------------------
DROP PROCEDURE IF EXISTS `Proc_CheckUser`;
delimiter ;;
CREATE PROCEDURE `Proc_CheckUser`(IN `Account` VARCHAR(16) ,IN `userPassword` VARCHAR(16) ,IN UserSign VARCHAR(2))
BEGIN
IF(userPassword != "null")
THEN
SELECT * FROM t_users
WHERE t_users.UserAccount = Account AND t_users.UserSign = UserSign AND t_users.UserPassword = userPassword;
ELSE
SELECT COUNT(*) FROM t_users
WHERE t_users.UserAccount = Account AND t_users.UserSign = UserSign;
END if;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Proc_CheckWarehouse
-- ----------------------------
DROP PROCEDURE IF EXISTS `Proc_CheckWarehouse`;
delimiter ;;
CREATE PROCEDURE `Proc_CheckWarehouse`(IN `warehouseNo` VARCHAR(16))
BEGIN
SELECT COUNT(*) FROM t_warehouses
WHERE t_warehouses.WarehouseNo = warehouseNo;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Proc_CheckWarehouseProduct
-- ----------------------------
DROP PROCEDURE IF EXISTS `Proc_CheckWarehouseProduct`;
delimiter ;;
CREATE PROCEDURE `Proc_CheckWarehouseProduct`(IN `warehouseNo` VARCHAR(16),IN `pageNo` VARCHAR(6))
BEGIN
DECLARE beginIndex INT DEFAULT 0;
set beginIndex := pageNo * 10;
if (SELECT t_warehouses.WarehouseStorageCapacity FROM t_warehouses
WHERE t_warehouses.WarehouseNo = warehouseNo) > 0
THEN
SELECT * FROM t_orderin
INNER JOIN t_orderdetails ON t_orderdetails.OrderInDetailsOrderNo = t_orderin.OrderInNo
WHERE t_orderin.OrderInWarehouse = warehouseNo
LIMIT beginIndex,10;
END IF;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Proc_ComfirmOrderInInfo
-- ----------------------------
DROP PROCEDURE IF EXISTS `Proc_ComfirmOrderInInfo`;
delimiter ;;
CREATE PROCEDURE `Proc_ComfirmOrderInInfo`(IN orderInNo VARCHAR(16),IN warehouse VARCHAR(16))
BEGIN
UPDATE t_warehouses
set t_warehouses.WarehouseStorageCapacity 
= t_warehouses.WarehouseStorageCapacity + (SELECT SUM(OrderInDetailsCount) FROM  t_orderdetails
	WHERE t_orderdetails.OrderInDetailsOrderNo = orderInNo)
WHERE t_warehouses.WarehouseNo = warehouse;
UPDATE t_orderin
SET t_orderin.OrderInFlag = 1
WHERE t_orderin.OrderInNo = orderInNo;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Proc_ComfirmOrderOutInfo
-- ----------------------------
DROP PROCEDURE IF EXISTS `Proc_ComfirmOrderOutInfo`;
delimiter ;;
CREATE PROCEDURE `Proc_ComfirmOrderOutInfo`(IN orderOutNo VARCHAR(16),IN warehouse VARCHAR(16))
BEGIN
UPDATE t_warehouses
set t_warehouses.WarehouseStorageCapacity 
= t_warehouses.WarehouseStorageCapacity - (SELECT SUM(OrderInDetailsCount) FROM  t_orderdetails
	WHERE t_orderdetails.OrderInDetailsOrderNo = orderOutNo)
WHERE t_warehouses.WarehouseNo = warehouse;
UPDATE t_orderout
SET t_orderout.OrderOutFlag = 1
WHERE t_orderout.OrderOutNo = orderOutNo;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Proc_DeleteOrderInInfo
-- ----------------------------
DROP PROCEDURE IF EXISTS `Proc_DeleteOrderInInfo`;
delimiter ;;
CREATE PROCEDURE `Proc_DeleteOrderInInfo`(IN orderInNo VARCHAR(16))
BEGIN
UPDATE t_orderin
SET OrderInFlag = 2
WHERE t_orderin.OrderInNo = orderInNo;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Proc_DeleteOrderOutInfo
-- ----------------------------
DROP PROCEDURE IF EXISTS `Proc_DeleteOrderOutInfo`;
delimiter ;;
CREATE PROCEDURE `Proc_DeleteOrderOutInfo`(IN orderOutNo VARCHAR(16))
BEGIN
UPDATE t_orderout
SET t_orderout.OrderOutFlag = 2
WHERE t_orderout.OrderOutNo = orderOutNo;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Proc_DeleteProductInfo
-- ----------------------------
DROP PROCEDURE IF EXISTS `Proc_DeleteProductInfo`;
delimiter ;;
CREATE PROCEDURE `Proc_DeleteProductInfo`(IN clothingCode VARCHAR(16))
BEGIN
UPDATE t_clothings
SET ClothingFlag = 1
WHERE t_clothings.ClothingCode = clothingCode;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Proc_DeleteProductOrder
-- ----------------------------
DROP PROCEDURE IF EXISTS `Proc_DeleteProductOrder`;
delimiter ;;
CREATE PROCEDURE `Proc_DeleteProductOrder`(IN orderNo VARCHAR(16),IN pcode VARCHAR(16),IN color VARCHAR(16),IN size VARCHAR(16))
BEGIN
DELETE FROM t_orderdetails
WHERE t_orderdetails.OrderInDetailsOrderNo = orderNo AND t_orderdetails.OrderInDetailsCode = pcode AND
t_orderdetails.OrderInDetailsColor = color AND t_orderdetails.OrderInDetailsSize = size;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Proc_DeleteUserInfo
-- ----------------------------
DROP PROCEDURE IF EXISTS `Proc_DeleteUserInfo`;
delimiter ;;
CREATE PROCEDURE `Proc_DeleteUserInfo`(IN Account VARCHAR(16))
BEGIN
UPDATE t_users
SET UserFlag = 1
WHERE t_users.UserAccount = Account;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Proc_DeleteWarehouseInfo
-- ----------------------------
DROP PROCEDURE IF EXISTS `Proc_DeleteWarehouseInfo`;
delimiter ;;
CREATE PROCEDURE `Proc_DeleteWarehouseInfo`(IN warehouseNo VARCHAR(16))
BEGIN
UPDATE t_warehouses
SET t_warehouses.WarehouseFlag = 1
WHERE t_warehouses.WarehouseNo = warehouseNo;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Proc_EditOrderInInfo
-- ----------------------------
DROP PROCEDURE IF EXISTS `Proc_EditOrderInInfo`;
delimiter ;;
CREATE PROCEDURE `Proc_EditOrderInInfo`(IN `orderInNo` VARCHAR(16),
																						IN `orderinPerson` VARCHAR(16),IN `orderInWarehouse` VARCHAR(16),IN `orderInBefrom` VARCHAR(128))
BEGIN
SELECT @i:=COUNT(*) FROM t_orderin
WHERE t_orderin.OrderInNo = orderInNo;
IF @i>0 THEN
	UPDATE t_orderin
	SET t_orderin.OrderInDate = NOW(),t_orderin.OrderinPerson = orderinPerson, 
	t_orderin.OrderInWarehouse = orderInWarehouse, t_orderin.OrderInBefrom = orderInBefrom
	WHERE t_orderin.OrderInNo = orderInNo;
ELSE
	INSERT INTO t_orderin(OrderInNo,OrderInDate,OrderinPerson,OrderInWarehouse,OrderInBefrom) 
	VALUES(orderInNo, NOW(),orderinPerson,orderInWarehouse,orderInBefrom);
END IF;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Proc_EditOrderOutInfo
-- ----------------------------
DROP PROCEDURE IF EXISTS `Proc_EditOrderOutInfo`;
delimiter ;;
CREATE PROCEDURE `Proc_EditOrderOutInfo`(IN `orderOutNo` VARCHAR(16),IN `orderOutPerson` VARCHAR(16),
																								IN `orderOutWarehouse` VARCHAR(16),IN `orderOutRperson` VARCHAR(16),IN `orderOutTel` VARCHAR(16))
BEGIN
SELECT @i:=COUNT(*) FROM t_orderout
WHERE t_orderout.OrderOutNo = orderOutNo;
IF @i>0 THEN
	UPDATE t_orderout
	SET t_orderout.OrderOutDate = NOW(),t_orderout.OrderOutPerson = orderOutPerson, 
	t_orderout.OrderOutWarehouse = orderOutWarehouse, t_orderout.OrderOutRperson = orderOutRperson,t_orderout.OrderOutTel=orderOutTel
	WHERE t_orderout.OrderOutNo = orderOutNo;
ELSE
	INSERT INTO t_orderout(OrderOutNo,OrderOutDate,OrderOutPerson,OrderOutWarehouse,OrderOutRperson,OrderOutTel) 
	VALUES(orderOutNo, NOW(),orderOutPerson,orderOutWarehouse,orderOutRperson,orderOutTel);
END IF;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Proc_EditProductInfo
-- ----------------------------
DROP PROCEDURE IF EXISTS `Proc_EditProductInfo`;
delimiter ;;
CREATE PROCEDURE `Proc_EditProductInfo`(IN `clothingCode` VARCHAR(16) ,IN `clothingColor` VARCHAR(16),
																						IN `clothingSize` VARCHAR(16),IN `clothingName` VARCHAR(16),IN `clothingPrice` VARCHAR(16))
BEGIN
SELECT @i:=COUNT(*) FROM t_clothings
WHERE t_clothings.ClothingCode = clothingCode;
IF @i>0 THEN
	UPDATE t_clothings
	SET t_clothings.ClothingColor = clothingColor,t_clothings.ClothingName = clothingName, 
	t_clothings.ClothingSize = clothingSize, t_clothings.ClothingPrice = clothingPrice
	WHERE t_clothings.ClothingCode = clothingCode;
ELSE
	INSERT INTO t_clothings(ClothingCode,ClothingColor,ClothingName, ClothingSize, ClothingPrice) 
	VALUES(clothingCode, clothingColor,clothingName,clothingSize,clothingPrice);
END IF;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Proc_EditProductInOrder
-- ----------------------------
DROP PROCEDURE IF EXISTS `Proc_EditProductInOrder`;
delimiter ;;
CREATE PROCEDURE `Proc_EditProductInOrder`(IN orderNo VARCHAR(16),IN pcode VARCHAR(16),IN color VARCHAR(16),
																					IN size VARCHAR(16),IN pcount VARCHAR(16),IN pname VARCHAR(16),IN price VARCHAR(16))
BEGIN
SELECT @i:=COUNT(*) FROM t_orderdetails
WHERE t_orderdetails.OrderInDetailsOrderNo = orderNo AND t_orderdetails.OrderInDetailsCode = pcode AND
t_orderdetails.OrderInDetailsSize = size AND t_orderdetails.OrderInDetailsColor = color;
IF @i>0 THEN
	CALL Proc_EditProductInfo(pcode, color, size, pname, price);
	UPDATE t_orderdetails
	SET t_orderdetails.OrderInDetailsCount = pcount
	WHERE t_orderdetails.OrderInDetailsOrderNo = orderNo AND t_orderdetails.OrderInDetailsCode = pcode AND
t_orderdetails.OrderInDetailsSize = size AND t_orderdetails.OrderInDetailsColor = color;
ELSE
	CALL Proc_EditProductInfo(pcode, color, size, pname, price);
	INSERT INTO t_orderdetails(OrderInDetailsOrderNo,OrderInDetailsCode,OrderInDetailsColor,OrderInDetailsSize,OrderInDetailsCount)
	VALUES(orderNo, pcode,color,size,pcount);
END IF;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Proc_EditProductOutOrder
-- ----------------------------
DROP PROCEDURE IF EXISTS `Proc_EditProductOutOrder`;
delimiter ;;
CREATE PROCEDURE `Proc_EditProductOutOrder`(IN orderNo VARCHAR(16),IN pcode VARCHAR(16),IN color VARCHAR(16),
																					IN size VARCHAR(16),IN pcount VARCHAR(16),IN pname VARCHAR(16),IN price VARCHAR(16))
BEGIN
SELECT @i:=COUNT(*) FROM t_orderdetails
WHERE t_orderdetails.OrderInDetailsOrderNo = orderNo AND t_orderdetails.OrderInDetailsCode = pcode AND
t_orderdetails.OrderInDetailsSize = size AND t_orderdetails.OrderInDetailsColor = color;
IF @i>0 THEN
	CALL Proc_EditProductInfo(pcode, color, size, pname, price);
	UPDATE t_orderdetails
	SET t_orderdetails.OrderInDetailsCount = pcount
	WHERE t_orderdetails.OrderInDetailsOrderNo = orderNo AND t_orderdetails.OrderInDetailsCode = pcode AND
t_orderdetails.OrderInDetailsSize = size AND t_orderdetails.OrderInDetailsColor = color;
ELSE
	CALL Proc_EditProductInfo(pcode, color, size, pname, price);
	INSERT INTO t_orderdetails(OrderInDetailsOrderNo,OrderInDetailsCode,OrderInDetailsColor,OrderInDetailsSize,OrderInDetailsCount)
	VALUES(orderNo, pcode,color,size,pcount);
END IF;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Proc_EditUserInfo
-- ----------------------------
DROP PROCEDURE IF EXISTS `Proc_EditUserInfo`;
delimiter ;;
CREATE PROCEDURE `Proc_EditUserInfo`(IN `Account` VARCHAR(16) ,IN `Name` VARCHAR(16),
																												IN `userPassword` VARCHAR(16),IN `description` VARCHAR(128))
BEGIN
SELECT @i:=COUNT(*) FROM t_users
WHERE t_users.UserAccount = Account AND t_users.UserSign = UserSign;
IF @i>0 THEN
	UPDATE t_users
	SET UserName = `Name`,UserPassword = userPassword ,UserDescription = description
	WHERE UserAccount = Account;
ELSE
	INSERT INTO t_users(UserAccount,UserName,UserPassword,UserDescription) VALUES(Account, `Name`,userPassword,description);
END IF;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Proc_EditWarehouseInfo
-- ----------------------------
DROP PROCEDURE IF EXISTS `Proc_EditWarehouseInfo`;
delimiter ;;
CREATE PROCEDURE `Proc_EditWarehouseInfo`(IN `warehouseNo` VARCHAR(16) ,IN `warehouseName` VARCHAR(16),
																						IN `warehouseContact` VARCHAR(16),IN `warehouseContactTele` VARCHAR(16))
BEGIN
SELECT @i:=COUNT(*) FROM t_warehouses
WHERE t_warehouses.WarehouseNo = warehouseNo;
IF @i>0 THEN
	UPDATE t_warehouses
	SET t_warehouses.WarehouseName = warehouseName, t_warehouses.WarehouseContact = warehouseContact,
	t_warehouses.WarehouseContactTele = warehouseContactTele
	WHERE t_warehouses.WarehouseNo = warehouseNo;
ELSE
	INSERT INTO t_warehouses(WarehouseNo,WarehouseName,WarehouseContact,WarehouseContactTele)
	VALUES(warehouseNo, warehouseName,warehouseContact,warehouseContactTele);
END IF;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Proc_SearchAllOrderIn
-- ----------------------------
DROP PROCEDURE IF EXISTS `Proc_SearchAllOrderIn`;
delimiter ;;
CREATE PROCEDURE `Proc_SearchAllOrderIn`(IN `pageNo` VARCHAR(6))
BEGIN
DECLARE beginIndex INT DEFAULT 0;
set beginIndex :=  pageNo * 10;
SELECT * FROM t_orderin
WHERE t_orderin.OrderInFlag < 2
LIMIT beginIndex,10;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Proc_SearchAllOrderOut
-- ----------------------------
DROP PROCEDURE IF EXISTS `Proc_SearchAllOrderOut`;
delimiter ;;
CREATE PROCEDURE `Proc_SearchAllOrderOut`(IN `pageNo` VARCHAR(6))
BEGIN
DECLARE beginIndex INT DEFAULT 0;
set beginIndex :=  pageNo * 10;
SELECT * FROM t_orderout
WHERE t_orderout.OrderOutFlag < 2
LIMIT beginIndex,10;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Proc_SearchAllProduct
-- ----------------------------
DROP PROCEDURE IF EXISTS `Proc_SearchAllProduct`;
delimiter ;;
CREATE PROCEDURE `Proc_SearchAllProduct`(IN `pageNo` VARCHAR(6))
BEGIN
DECLARE beginIndex INT DEFAULT 0;
set beginIndex :=  pageNo * 10;
SELECT * FROM t_clothings
WHERE t_clothings.ClothingFlag = 0
LIMIT beginIndex,10;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Proc_SearchAllProductOrder
-- ----------------------------
DROP PROCEDURE IF EXISTS `Proc_SearchAllProductOrder`;
delimiter ;;
CREATE PROCEDURE `Proc_SearchAllProductOrder`(IN `orderID` VARCHAR(16),IN `pageNo` VARCHAR(6))
BEGIN
DECLARE beginIndex INT DEFAULT 0;
set beginIndex :=  pageNo * 10;
SELECT * FROM t_orderdetails
WHERE t_orderdetails.OrderInDetailsOrderNo = orderID
LIMIT beginIndex,10;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Proc_SearchAllUser
-- ----------------------------
DROP PROCEDURE IF EXISTS `Proc_SearchAllUser`;
delimiter ;;
CREATE PROCEDURE `Proc_SearchAllUser`(IN `pageNo` VARCHAR(6))
BEGIN
DECLARE beginIndex INT DEFAULT 0;
set beginIndex :=  pageNo * 10;
SELECT * FROM t_users
WHERE t_users.UserFlag = 0 AND t_users.UserSign = 0
LIMIT beginIndex,10;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Proc_SearchAllWarehouse
-- ----------------------------
DROP PROCEDURE IF EXISTS `Proc_SearchAllWarehouse`;
delimiter ;;
CREATE PROCEDURE `Proc_SearchAllWarehouse`(IN `pageNo` VARCHAR(6))
BEGIN
DECLARE beginIndex INT DEFAULT 0;
set beginIndex :=  pageNo * 10;
SELECT * FROM t_warehouses
WHERE t_warehouses.WarehouseFlag = 0
LIMIT beginIndex,10;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Proc_SearchAllWarehouseInfo
-- ----------------------------
DROP PROCEDURE IF EXISTS `Proc_SearchAllWarehouseInfo`;
delimiter ;;
CREATE PROCEDURE `Proc_SearchAllWarehouseInfo`()
BEGIN
SELECT * FROM t_warehouses
WHERE t_warehouses.WarehouseFlag = 0;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Proc_SearchOrderInFuzzy
-- ----------------------------
DROP PROCEDURE IF EXISTS `Proc_SearchOrderInFuzzy`;
delimiter ;;
CREATE PROCEDURE `Proc_SearchOrderInFuzzy`(IN fuzzyStr VARCHAR(16), IN `pageNo` TINYINT)
BEGIN
DECLARE beginIndex INT DEFAULT 0;
set beginIndex := pageNo * 10;
SELECT * FROM t_orderin
WHERE t_orderin.OrderInFlag < 2
AND (
POSITION(fuzzyStr IN t_orderin.OrderInDate)
OR POSITION(fuzzyStr IN t_orderin.OrderInNo)
OR POSITION(fuzzyStr IN t_orderin.OrderInBefrom)
OR POSITION(fuzzyStr IN t_orderin.OrderinPerson)
OR POSITION(fuzzyStr IN t_orderin.OrderInWarehouse))
LIMIT beginIndex,10;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Proc_SearchOrderOutFuzzy
-- ----------------------------
DROP PROCEDURE IF EXISTS `Proc_SearchOrderOutFuzzy`;
delimiter ;;
CREATE PROCEDURE `Proc_SearchOrderOutFuzzy`(IN fuzzyStr VARCHAR(16), IN `pageNo` TINYINT)
BEGIN
DECLARE beginIndex INT DEFAULT 0;
set beginIndex := pageNo * 10;
SELECT * FROM t_orderout
WHERE t_orderout.OrderOutFlag < 2
AND (
POSITION(fuzzyStr IN t_orderout.OrderOutNo)
OR POSITION(fuzzyStr IN t_orderout.OrderOutDate)
OR POSITION(fuzzyStr IN t_orderout.OrderOutPerson)
OR POSITION(fuzzyStr IN t_orderout.OrderOutRperson)
OR POSITION(fuzzyStr IN t_orderout.OrderOutTel)
OR POSITION(fuzzyStr IN t_orderout.OrderOutWarehouse))
LIMIT beginIndex,10;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Proc_SearchProductFuzzy
-- ----------------------------
DROP PROCEDURE IF EXISTS `Proc_SearchProductFuzzy`;
delimiter ;;
CREATE PROCEDURE `Proc_SearchProductFuzzy`(IN fuzzyStr VARCHAR(16), IN `pageNo` TINYINT)
BEGIN
DECLARE beginIndex INT DEFAULT 0;
set beginIndex := pageNo * 10;
SELECT * FROM t_clothings
WHERE t_clothings.ClothingFlag = 0
AND (
POSITION(fuzzyStr IN t_clothings.ClothingCode)
OR POSITION(fuzzyStr IN t_clothings.ClothingColor)
OR POSITION(fuzzyStr IN t_clothings.ClothingInnerM)
OR POSITION(fuzzyStr IN t_clothings.ClothingName)
OR POSITION(fuzzyStr IN t_clothings.ClothingOuterM)
OR POSITION(fuzzyStr IN t_clothings.ClothingPrice)
OR POSITION(fuzzyStr IN t_clothings.ClothingSize))
LIMIT beginIndex,10;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Proc_SearchProductOrderFuzzy
-- ----------------------------
DROP PROCEDURE IF EXISTS `Proc_SearchProductOrderFuzzy`;
delimiter ;;
CREATE PROCEDURE `Proc_SearchProductOrderFuzzy`(IN `orderID` VARCHAR(16),IN fuzzyStr VARCHAR(16), IN `pageNo` TINYINT)
BEGIN
DECLARE beginIndex INT DEFAULT 0;
set beginIndex := pageNo * 10;
SELECT * FROM t_orderdetails
WHERE t_orderdetails.OrderInDetailsOrderNo = orderID
AND (
POSITION(fuzzyStr IN t_orderdetails.OrderInDetailsCode)
OR POSITION(fuzzyStr IN t_orderdetails.OrderInDetailsColor)
OR POSITION(fuzzyStr IN t_orderdetails.OrderInDetailsSize)
OR POSITION(fuzzyStr IN t_orderdetails.OrderInDetailsCount))
LIMIT beginIndex,10;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Proc_SearchUserFuzzy
-- ----------------------------
DROP PROCEDURE IF EXISTS `Proc_SearchUserFuzzy`;
delimiter ;;
CREATE PROCEDURE `Proc_SearchUserFuzzy`(IN fuzzyStr VARCHAR(16), IN `pageNo` TINYINT)
BEGIN
DECLARE beginIndex INT DEFAULT 0;
set beginIndex := pageNo * 10;
SELECT * FROM t_users
WHERE t_users.UserFlag = 0 AND t_users.UserSign = 0
AND (
POSITION(fuzzyStr IN t_users.UserAccount)
OR POSITION(fuzzyStr IN t_users.UserDescription)
OR POSITION(fuzzyStr IN t_users.UserName))
LIMIT beginIndex,10;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Proc_SearchWarehouseFuzzy
-- ----------------------------
DROP PROCEDURE IF EXISTS `Proc_SearchWarehouseFuzzy`;
delimiter ;;
CREATE PROCEDURE `Proc_SearchWarehouseFuzzy`(IN fuzzyStr VARCHAR(16), IN `pageNo` TINYINT)
BEGIN
DECLARE beginIndex INT DEFAULT 0;
set beginIndex := pageNo * 10;
SELECT * FROM t_warehouses
WHERE t_warehouses.WarehouseFlag = 0
AND (
POSITION(fuzzyStr IN t_warehouses.WarehouseNo)
OR POSITION(fuzzyStr IN t_warehouses.WarehouseName)
OR POSITION(fuzzyStr IN t_warehouses.WarehouseContact)
OR POSITION(fuzzyStr IN t_warehouses.WarehouseContactTele))
LIMIT beginIndex,10;
END
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
