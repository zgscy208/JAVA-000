学习笔记

第二个版本（自定义Queue）
2、去掉内存Queue，设计自定义Queue，实现消息确认和消费offset
1）自定义内存Message数组模拟Queue。
2）使用指针记录当前消息写入位置。
3）对于每个命名消费者，用指针记录消费位置。
作业相关
自定义`Queue`：就是一个生产者与消费者的实现，代码在`io.kimmking.kmq.core.MyArrayBlockingQueue`