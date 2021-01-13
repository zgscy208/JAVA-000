# Week13 作业题目：

## 周四作业
- [x] 1.（必做）搭建 ActiveMQ 服务，基于 JMS，写代码分别实现对于 queue 和 topic 的消息生产和消费，代码提交到 github。 
 
## 周六作业：
- [x] 1.（必做）搭建一个 3 节点 Kafka 集群，测试功能和性能；实现 spring kafka 下对 kafka 集群的操作，将代码提交到 github。

~~ bin/kafka-producer-perf-test.sh --topic test32 --num-records 100000 --record-size 1000 --throughput 2000 --producer-props bootstrap.servers=localhost:9002
10002 records sent, 2000.0 records/sec (1.91 MB/sec), 23.5 ms avg latency, 441.0 ms max latency.
9996 records sent, 1999.2 records/sec (1.91 MB/sec), 2.3 ms avg latency, 44.0 ms max latency.
10022 records sent, 2004.0 records/sec (1.91 MB/sec), 1.7 ms avg latency, 39.0 ms max latency.
10012 records sent, 2001.2 records/sec (1.91 MB/sec), 1.9 ms avg latency, 26.0 ms max latency.
10010 records sent, 2002.0 records/sec (1.91 MB/sec), 1.2 ms avg latency, 24.0 ms max latency.
10000 records sent, 2000.0 records/sec (1.91 MB/sec), 1.7 ms avg latency, 32.0 ms max latency.
10002 records sent, 2000.4 records/sec (1.91 MB/sec), 0.8 ms avg latency, 9.0 ms max latency.
10000 records sent, 2000.0 records/sec (1.91 MB/sec), 1.4 ms avg latency, 33.0 ms max latency.
10002 records sent, 2000.0 records/sec (1.91 MB/sec), 1.2 ms avg latency, 46.0 ms max latency.
100000 records sent, 1999.240289 records/sec (1.91 MB/sec), 3.69 ms avg latency, 441.00 ms max latency, 1 ms 50th, 7 ms 95th, 113 ms 99th, 192 ms 99.9th.
