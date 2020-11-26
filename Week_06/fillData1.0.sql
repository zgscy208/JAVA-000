# 插入数据到用户表中
DROP PROCEDURE IF EXISTS users_initData;
DELIMITER $
CREATE PROCEDURE users_initData()
BEGIN
    DECLARE i INT DEFAULT 1;
    set autocommit=0;
    WHILE i<=100 DO
        insert into mall.users (name, password, phoneNumber, identify_card, money) VALUES (CONCAT("user", i),
                                                                                           "password",
                                                                            CONCAT("phoneNumber", i),
                                                                                           "identify_card", 0);
        SET i = i+1;
    END WHILE;
    commit;
END $
CALL users_initData();

# 插入数据到店铺表中
DROP PROCEDURE IF EXISTS stores_initData;
DELIMITER $
CREATE PROCEDURE stores_initData()
BEGIN
    DECLARE i INT DEFAULT 1;
    set autocommit=0;
    WHILE i<=100 DO
            insert into mall.stores (name, description) VALUES (CONCAT("store", i), CONCAT("description", i));
            SET i = i+1;
        END WHILE;
    commit;
END $
CALL stores_initData();

# 插入数据到商品表中
DROP PROCEDURE IF EXISTS goods_initData;
DELIMITER $
CREATE PROCEDURE goods_initData()
BEGIN
    DECLARE i INT DEFAULT 1;
    set autocommit=0;
    WHILE i<=10000 DO
        insert into mall.goods(name, description, price, weight, store_id, store_name, status)
        VALUES (CONCAT("name", i), CONCAT("description", i), 1, 1, CEILING(rand()*100), "storeName", 1);
        SET i = i+1;
    END WHILE;
    commit;
END $
CALL goods_initData();

# 插入数据到订单表中
DROP PROCEDURE IF EXISTS orders_initData;
DELIMITER $
CREATE PROCEDURE orders_initData()
BEGIN
    DECLARE i INT DEFAULT 1;
    set autocommit=0;
    WHILE i<=10000 DO
            insert into mall.orders (user_id, commodities, status, deliver_status, total_price)
            VALUES (CEILING(rand()*100), '{"key": "value"}', 0, '{"key":"value"}', 1);
        SET i = i+1;
    END WHILE;
    commit;
END $
CALL orders_initData();

