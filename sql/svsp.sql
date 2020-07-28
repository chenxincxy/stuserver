-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.7.26 - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- 导出 SVSP 的数据库结构
CREATE DATABASE IF NOT EXISTS `SVSP` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;
USE `SVSP`;

-- 导出  表 SVSP.gd_information 结构
CREATE TABLE IF NOT EXISTS `gd_information` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `glist_id` int(11) DEFAULT NULL COMMENT '商品分类id',
  `name` varchar(45) DEFAULT NULL COMMENT '商品名字',
  `price` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '价格',
  `provider_id` int(11) DEFAULT NULL COMMENT '卖家id',
  `description` varchar(45) DEFAULT NULL COMMENT '描述',
  `shelf_date` date DEFAULT NULL,
  `picture` varchar(100) DEFAULT NULL COMMENT '商品图片',
  PRIMARY KEY (`id`),
  KEY `FK_gd_information_good_list` (`glist_id`),
  KEY `FK_gd_information_t_user` (`provider_id`),
  CONSTRAINT `FK_gd_information_good_list` FOREIGN KEY (`glist_id`) REFERENCES `gd_list` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8 COMMENT='商品信息表';

-- 正在导出表  SVSP.gd_information 的数据：~12 rows (大约)
/*!40000 ALTER TABLE `gd_information` DISABLE KEYS */;
INSERT INTO `gd_information` (`id`, `glist_id`, `name`, `price`, `provider_id`, `description`, `shelf_date`, `picture`) VALUES
	(2, 9, '路飞手办', 80.00, 4, '刚买发现不喜欢，便宜出', '2020-03-23', NULL),
	(32, 1, '水杯', 0.00, 1, '没用过', '2020-03-29', 'null'),
	(34, 4, '鸭舌帽', 0.00, 1, '', '2020-03-29', NULL),
	(39, 5, '深入理解jvm虚拟机', 0.00, 1, '7成新', '2020-03-29', NULL),
	(47, 1, '拖鞋', 30.00, 1, '30两双', '2020-04-01', NULL),
	(54, 1, '眼镜盒', 20.00, 1, '全新', '2020-04-08', NULL),
	(59, 1, '化妆包', 40.00, 1, '半价', '2020-04-08', NULL),
	(61, 4, '渔夫帽', 35.00, 1, '七成新', '2020-04-08', NULL),
	(63, 4, '发圈', 0.00, 1, '4个', '2020-05-28', NULL),
	(64, 5, '计算机组成原理', 0.00, 1, '八成新', '2020-05-28', NULL),
	(65, 2, 'lll', 0.00, 1, '', '2020-05-28', NULL),
	(66, 2, 'hjks', 0.00, 1, '', '2020-05-28', NULL);
/*!40000 ALTER TABLE `gd_information` ENABLE KEYS */;

-- 导出  表 SVSP.gd_list 结构
CREATE TABLE IF NOT EXISTS `gd_list` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品分类id',
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='商品一级目录表';

-- 正在导出表  SVSP.gd_list 的数据：~8 rows (大约)
/*!40000 ALTER TABLE `gd_list` DISABLE KEYS */;
INSERT INTO `gd_list` (`id`, `name`) VALUES
	(1, '生活用品'),
	(2, '学习用品'),
	(3, '服装'),
	(4, '配饰'),
	(5, '书籍'),
	(6, '家具'),
	(7, '鞋子'),
	(8, '电子产品'),
	(9, '玩具'),
	(10, '乐器');
/*!40000 ALTER TABLE `gd_list` ENABLE KEYS */;

-- 导出  表 SVSP.gd_order 结构
CREATE TABLE IF NOT EXISTS `gd_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单号',
  `total` decimal(10,2) DEFAULT NULL COMMENT '总价',
  `username` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `userphone` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `useraddress` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `provider_id` int(11) NOT NULL COMMENT '商品所有者id',
  `consumer_id` int(11) NOT NULL COMMENT '商品购买者id',
  `gd_date` date DEFAULT NULL COMMENT '日期',
  `gd_id` int(11) DEFAULT NULL COMMENT '商品id',
  `paymentstatus` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '支付状态',
  `orderstatus` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '订单状态',
  `shipstatus` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '发货状态',
  PRIMARY KEY (`id`),
  KEY `FK_gd_order_t_user_2` (`consumer_id`),
  KEY `FK_gd_order_gd_information` (`gd_id`),
  KEY `FK_gd_order_t_user` (`provider_id`),
  CONSTRAINT `FK_gd_order_t_user` FOREIGN KEY (`provider_id`) REFERENCES `t_user` (`id`),
  CONSTRAINT `FK_gd_order_t_user_2` FOREIGN KEY (`consumer_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='商品订单表';

-- 正在导出表  SVSP.gd_order 的数据：~4 rows (大约)
/*!40000 ALTER TABLE `gd_order` DISABLE KEYS */;
INSERT INTO `gd_order` (`id`, `total`, `username`, `userphone`, `useraddress`, `provider_id`, `consumer_id`, `gd_date`, `gd_id`, `paymentstatus`, `orderstatus`, `shipstatus`) VALUES
	(12, 12.00, 'cx', '15577931180', '银滩', 5, 3, '2020-06-07', 34, '微信', '待确认', '未发货'),
	(13, 0.00, 'cx', '15577931180', '银滩', 1, 3, '2020-06-08', 32, '微信', '待确认', '未发货'),
	(14, 55.00, 'user', '12345678910', 'baidu', 1, 3, '2020-06-08', 59, '货到付款', '待确认', '已发货'),
	(15, 20.00, '小明', '12345678910', '流花街春町36号', 1, 3, '2020-06-14', 54, '支付宝余额', '待确认', '未发货');
/*!40000 ALTER TABLE `gd_order` ENABLE KEYS */;

-- 导出  表 SVSP.g_level 结构
CREATE TABLE IF NOT EXISTS `g_level` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- 正在导出表  SVSP.g_level 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `g_level` DISABLE KEYS */;
INSERT INTO `g_level` (`id`, `name`) VALUES
	(1, '买家'),
	(2, '卖家'),
	(3, '管理员');
/*!40000 ALTER TABLE `g_level` ENABLE KEYS */;

-- 导出  表 SVSP.logistics 结构
CREATE TABLE IF NOT EXISTS `logistics` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '物流单号',
  `name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '物流',
  `fee` decimal(10,0) NOT NULL DEFAULT '0' COMMENT '邮费',
  `receiverName` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `receiverPhone` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `receiverAddress` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `remarks` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  `Deliverytime` date NOT NULL COMMENT '发货时间',
  `gorder_id` int(11) NOT NULL COMMENT '订单编号',
  PRIMARY KEY (`id`),
  KEY `FK_logistics_gd_order` (`gorder_id`),
  CONSTRAINT `FK_logistics_gd_order` FOREIGN KEY (`gorder_id`) REFERENCES `gd_order` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- 正在导出表  SVSP.logistics 的数据：~3 rows (大约)
/*!40000 ALTER TABLE `logistics` DISABLE KEYS */;
INSERT INTO `logistics` (`id`, `name`, `fee`, `receiverName`, `receiverPhone`, `receiverAddress`, `remarks`, `Deliverytime`, `gorder_id`) VALUES
	(14, '韵达', 0, '小明', '15577931180', '银滩大道', '速速送达。', '2020-06-08', 12),
	(15, '圆通', 15, '小花', '12345678910', '流花街道春町路32号', NULL, '2020-06-08', 14);
/*!40000 ALTER TABLE `logistics` ENABLE KEYS */;

-- 导出  表 SVSP.orderstatus 结构
CREATE TABLE IF NOT EXISTS `orderstatus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- 正在导出表  SVSP.orderstatus 的数据：~6 rows (大约)
/*!40000 ALTER TABLE `orderstatus` DISABLE KEYS */;
INSERT INTO `orderstatus` (`id`, `name`) VALUES
	(1, '已确认'),
	(2, '待确认'),
	(3, '已收货'),
	(4, '已取消'),
	(5, '已完成'),
	(6, '已作废');
/*!40000 ALTER TABLE `orderstatus` ENABLE KEYS */;

-- 导出  表 SVSP.payment 结构
CREATE TABLE IF NOT EXISTS `payment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '支付方式',
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- 正在导出表  SVSP.payment 的数据：~4 rows (大约)
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` (`id`, `name`) VALUES
	(1, '微信'),
	(2, '支付宝余额'),
	(3, '货到付款'),
	(4, '花呗'),
	(5, '银行卡'),
	(6, '未支付');
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;

-- 导出  表 SVSP.sk_information 结构
CREATE TABLE IF NOT EXISTS `sk_information` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '技能id',
  `slist_id` int(11) NOT NULL COMMENT '技能分类id',
  `name` varchar(45) DEFAULT NULL COMMENT '技能名字',
  `description` varchar(300) DEFAULT NULL COMMENT '技能描述',
  `price` decimal(10,2) DEFAULT NULL COMMENT '价格',
  `provider_id` int(11) NOT NULL COMMENT '所有者id',
  `shelf_date` date DEFAULT NULL COMMENT '上架时间',
  `favorable_number` int(11) DEFAULT NULL COMMENT '好评数',
  `purchase_number` int(11) DEFAULT NULL COMMENT '购买数',
  `picture` varchar(100) DEFAULT NULL COMMENT '图片',
  PRIMARY KEY (`id`),
  KEY `FK_sk_information_sk_id` (`slist_id`),
  KEY `FK_sk_information_t_user` (`provider_id`),
  CONSTRAINT `FK_sk_information_sk_id` FOREIGN KEY (`slist_id`) REFERENCES `sk_list` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='技能信息表';

-- 正在导出表  SVSP.sk_information 的数据：~3 rows (大约)
/*!40000 ALTER TABLE `sk_information` DISABLE KEYS */;
INSERT INTO `sk_information` (`id`, `slist_id`, `name`, `description`, `price`, `provider_id`, `shelf_date`, `favorable_number`, `purchase_number`, `picture`) VALUES
	(1, 1, 'logo设计', '专业做logo设计，挺好的', 1245.00, 2, '2020-03-24', 4400, 4532, NULL),
	(2, 1, '服装设计', '本人精通服装设计', 120.22, 1, '2020-03-24', 88, 66, NULL),
	(4, 4, '动画制作', '专业做动画', 156.20, 5, '2020-03-24', 9999999, 9999999, NULL),
	(5, 3, '小学数学辅导', '本人，复旦大学在读大学生，可提供相应学生证进行证明。50/节课，周六周日都可以，上门辅导。联系电话:12345678910', 50.00, 123456, '2020-06-12', NULL, NULL, NULL);
/*!40000 ALTER TABLE `sk_information` ENABLE KEYS */;

-- 导出  表 SVSP.sk_list 结构
CREATE TABLE IF NOT EXISTS `sk_list` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='技能一级目录表';

-- 正在导出表  SVSP.sk_list 的数据：~5 rows (大约)
/*!40000 ALTER TABLE `sk_list` DISABLE KEYS */;
INSERT INTO `sk_list` (`id`, `name`) VALUES
	(1, '设计'),
	(2, 'PS'),
	(3, '功课辅导'),
	(4, '动画制作'),
	(5, '舞蹈'),
	(6, '音乐');
/*!40000 ALTER TABLE `sk_list` ENABLE KEYS */;

-- 导出  表 SVSP.sk_order 结构
CREATE TABLE IF NOT EXISTS `sk_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单号',
  `total` decimal(10,2) DEFAULT NULL COMMENT '金额',
  `provider_id` int(11) NOT NULL COMMENT '所有者id',
  `date` date DEFAULT NULL COMMENT '日期',
  `sk_id` int(11) NOT NULL COMMENT '技能id',
  PRIMARY KEY (`id`),
  KEY `FK_sk_order_sk_information` (`sk_id`),
  KEY `FK_sk_order_t_user` (`provider_id`),
  CONSTRAINT `FK_sk_order_t_user` FOREIGN KEY (`provider_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1 COMMENT='技能订单表';

-- 正在导出表  SVSP.sk_order 的数据：~4 rows (大约)
/*!40000 ALTER TABLE `sk_order` DISABLE KEYS */;
INSERT INTO `sk_order` (`id`, `total`, `provider_id`, `date`, `sk_id`) VALUES
	(1, 15000.00, 5, '2020-03-24', 4),
	(2, 270.00, 1, '2020-03-24', 2),
	(3, 450.00, 3, '2020-03-24', 1),
	(4, 20000.00, 5, '2020-03-24', 4);
/*!40000 ALTER TABLE `sk_order` ENABLE KEYS */;

-- 导出  表 SVSP.s_level 结构
CREATE TABLE IF NOT EXISTS `s_level` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- 正在导出表  SVSP.s_level 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `s_level` DISABLE KEYS */;
INSERT INTO `s_level` (`id`, `name`) VALUES
	(1, '买家'),
	(2, '卖家'),
	(3, '管理员');
/*!40000 ALTER TABLE `s_level` ENABLE KEYS */;

-- 导出  表 SVSP.t_user 结构
CREATE TABLE IF NOT EXISTS `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `name` varchar(20) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '用户name',
  `password` varchar(20) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '密码',
  `address` varchar(100) COLLATE utf8_bin DEFAULT '' COMMENT '地址',
  `phone` varchar(20) COLLATE utf8_bin DEFAULT '' COMMENT '电话号码',
  `IDcard` varchar(20) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '身份证号码',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `status` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '身份：学生/非学生',
  `picture` varchar(100) COLLATE utf8_bin DEFAULT '' COMMENT '头像照片',
  `school` varchar(20) COLLATE utf8_bin DEFAULT '' COMMENT '学校',
  `major` varchar(20) COLLATE utf8_bin DEFAULT '' COMMENT '专业',
  `email` varchar(30) COLLATE utf8_bin DEFAULT '' COMMENT '邮箱地址',
  `slevelName` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '卖技能平台的权限id',
  `glevelName` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '二手平台权限id',
  PRIMARY KEY (`id`),
  KEY `FK_t_user_s_level` (`slevelName`,`id`),
  KEY `FK_t_user_g_level` (`glevelName`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- 正在导出表  SVSP.t_user 的数据：~6 rows (大约)
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` (`id`, `name`, `password`, `address`, `phone`, `IDcard`, `birthday`, `status`, `picture`, `school`, `major`, `email`, `slevelName`, `glevelName`) VALUES
	(1, '张三', '123456', '广西桂林雁山区', '15577931180', '', '1999-12-30', '', '', '', '', '', '卖家', '买家'),
	(2, '李四', '789456', '黑龙江哈尔滨道里区', '12345678911', '', '2000-03-20', '学生', '', '', '', '', '买家', '管理员'),
	(3, '葛优', 'lil123456', '金海岸大道', '12345678910', '500222200002055946', '2001-06-14', '', '', '', '', '', '卖家', '买家'),
	(4, '路飞', '15213cd', '广西北海杭州路深海豪庭', '12345678912', '', NULL, '', '', '', '', '', '卖家', '卖家'),
	(5, '尾田', '156789', '日本东京东京都千代田区一ツ桥2510 株式会社 集英社', '55468311', '', NULL, '', '', '', '', '', '买家', '卖家'),
	(6, 'admin', '123456', '流花街春町路32号', '12345678913', '', NULL, '', '', '', '', '', '管理员', '管理员');
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
