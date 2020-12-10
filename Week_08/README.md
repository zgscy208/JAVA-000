第8周总结

## mysql进阶

## 分库分表
1. 拆分方式：垂直、水平
2. 拆分方法：代码层面硬干、借助中间件 (mycat、ss)
3. 数据迁移 （全量、全量+增量、全量binlog+增量） 相关中间件 eg: sharding scaling

## 分布式事务
1. XA ：强一致、适用 短事务、低并发 常见开源实现 （Atomikos,Narayana...）
2. TCC、AT ：base 柔性事务 相对提高并发，对业务有入侵  (Seata、Hmily...)
3. ss对分布式事务的支持，封装常用成熟的分布式事务的解决方案

## ss使用参考参考： https://shardingsphere.apache.org/document/legacy/3.x/document/cn/manual/sharding-proxy/

## homework1 :设计对前面的订单表数据进行水平分库分表，拆分2个库，每个库16张表。并在新结构在演示常见的增删改查操作。代码、sql 和配置文件，上传到 Github。

1. 先从简单开始使用测试表 t_order ，修改 conf中的分片配置规则，启动 sharding-proxy ,在 sharding-proxy模拟出来的数据库中直接执行对应的DDL语句
2. 启动成功测试符合预期，按照对应的分片规则插入对应的库表
3. 使用sharding-scaling迁移原订单表中数据到分片规则的对应库表中（迁移过程比较坎坷，总结按照步骤需要静下心检查好每一步，不能求快）
4. 迁移成功 ，指定对应订单表的crud 符合预期

## homework2: 基于hmily TCC或ShardingSphere的Atomikos XA实现一个简单的分布式 事务应用demo（二选一），提交到github  

