# 用于用户数据库及表的初始化

CREATE DATABASE if not exists `mall`;

USE `mall`;

# 用户表:用户id、名称、密码、手机号、身份证号、账户余额
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(16) NOT NULL,
  `password` varchar(16) NOT NULL,
  `phoneNumber` varchar(15) NOT NULL,
  `identify_card` varchar(16) NOT NULL,
  `money` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

# 店铺表：店铺id、名称、描述
CREATE TABLE IF NOT EXISTS `stores` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `name` varchar(16) NOT NULL,
    `description` varchar(1024) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

# 商品表：id、名称、描述、价格、重量、所属店铺id、所属店铺名称、商品状态
CREATE TABLE IF NOT EXISTS `goods` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `name` varchar(16) NOT NULL,
    `description` varchar(1024) NOT NULL,
    `price` int(11) NOT NULL,
    `weight` int(11) NOT NULL,
    `store_id` int(11) NOT NULL,
    `store_name` varchar(16) NOT NULL,
    `status` int(1) NOT NULL,
    PRIMARY KEY (`id`),
    foreign key (store_id) references stores(id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

# 订单表:id、用户id、商品列表、订单状态、物流状态、总价
CREATE TABLE IF NOT EXISTS `orders` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `user_id` int(11) NOT NULL,
    `commodities` varchar(10024) NOT NULL,
    `status` int(1) NOT NULL,
    `deliver_status` varchar(10024) NOT NULL,
    `total_price` int(11) NOT NULL,
    PRIMARY KEY (`id`),
    foreign key (user_id) references users(id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

# SQL FOREIGN KEY 约束:https://www.runoob.com/sql/sql-foreignkey.html

insert into mall.users (name, password, phoneNumber, identify_card, money) VALUES ("name", "password",
                                                                                        "phoneNumber",
                                                                                   "1234567890123456", 0);
insert into mall.stores (name, description) VALUES ("name", "description");
insert into mall.goods(name, description, price, weight, store_id, store_name, status) VALUES ("name",
                                                                                                "description", 1, 1, 1,
                                                                                               "name",
                                                                                    1);
insert into mall.orders (user_id, commodities, status, deliver_status, total_price) VALUES (1, '{"key": "value"}', 0, '{"key":
"value"}', 1);