/*
SQLyog Ultimate v12.5.0 (64 bit)
Database - coffee
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`coffee` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;

USE `coffee`;

/*Table structure for table `tb_item` */

DROP TABLE IF EXISTS `tb_item`;

CREATE TABLE `tb_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '商品名',
  `unit_price` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '单价',
  `created` date NOT NULL COMMENT '创建时间',
  `desc` text COLLATE utf8_bin NOT NULL COMMENT '商品描述',
  `updated` date NOT NULL COMMENT '更新时间',
  `ingredients` tinyint(1) NOT NULL COMMENT '是否为辅料',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `tb_item` */

insert  into `tb_item`(`id`,`name`,`unit_price`,`created`,`desc`,`updated`,`ingredients`) values (1,'摩卡','10','2020-08-07','','2020-08-07',0);
insert  into `tb_item`(`id`,`name`,`unit_price`,`created`,`desc`,`updated`,`ingredients`) values (2,'卡普奇诺','15','2020-08-07',' ','2020-08-07',0);
insert  into `tb_item`(`id`,`name`,`unit_price`,`created`,`desc`,`updated`,`ingredients`) values (3,'美式','18','2020-08-07','','2020-08-07',0);
insert  into `tb_item`(`id`,`name`,`unit_price`,`created`,`desc`,`updated`,`ingredients`) values (4,'糖','1','2020-08-07','','2020-08-07',1);
insert  into `tb_item`(`id`,`name`,`unit_price`,`created`,`desc`,`updated`,`ingredients`) values (5,'牛奶','8','2020-08-07','','2020-08-07',1);
insert  into `tb_item`(`id`,`name`,`unit_price`,`created`,`desc`,`updated`,`ingredients`) values (6,'奶盖','12','2020-08-07','','2020-08-07',1);

/*Table structure for table `tb_order` */

DROP TABLE IF EXISTS `tb_order`;

CREATE TABLE `tb_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `price` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '总价格',
  `created` date NOT NULL COMMENT '订单创建时间',
  `pay_state` int(11) NOT NULL COMMENT '订单状态（1、进行中，0、初始化，2、完成）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `tb_order` */

insert  into `tb_order`(`id`,`price`,`created`,`pay_state`) values (14,'64.0','2020-08-07',0);

/*Table structure for table `tb_order_item` */

DROP TABLE IF EXISTS `tb_order_item`;

CREATE TABLE `tb_order_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `item_id` bigint(20) NOT NULL COMMENT '商品ID',
  `order_id` bigint(20) NOT NULL COMMENT '订单ID',
  `ingredients` tinyint(1) NOT NULL COMMENT '是否为辅料',
  `unit_price` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '单价',
  `name` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '商品名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=85 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `tb_order_item` */

insert  into `tb_order_item`(`id`,`item_id`,`order_id`,`ingredients`,`unit_price`,`name`) values (79,1,14,0,'10','摩卡');
insert  into `tb_order_item`(`id`,`item_id`,`order_id`,`ingredients`,`unit_price`,`name`) values (80,2,14,0,'15','卡普奇诺');
insert  into `tb_order_item`(`id`,`item_id`,`order_id`,`ingredients`,`unit_price`,`name`) values (81,3,14,0,'18','美式');
insert  into `tb_order_item`(`id`,`item_id`,`order_id`,`ingredients`,`unit_price`,`name`) values (82,4,14,1,'1','美式+糖');
insert  into `tb_order_item`(`id`,`item_id`,`order_id`,`ingredients`,`unit_price`,`name`) values (83,5,14,1,'8','美式+牛奶');
insert  into `tb_order_item`(`id`,`item_id`,`order_id`,`ingredients`,`unit_price`,`name`) values (84,6,14,1,'12','美式+奶盖');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
