1. 教程主要参考 http://blog.didispace.com/Spring-Cloud基础教程/
2. 从 Dalston版本 开始 
    1. 服务注册与发现（Eureka、Consul）
    2. 服务消费者（基础）
    3. 服务消费者（Ribbon）
    4. 服务消费者（Feign）
    5. 分布式配置中心 ------(跳过)
    6. Hystrix服务降级 依赖隔离 断路器
    7. Hystrix监控面板
    8. Hystrix监控数据聚合 turbine ------(跳过)
    9. zuul 服务网关
    10. 消息驱动的微服务(spring-cloud-stream-rabbitmq)
    11. 消息总线-----(跳过)
    12. 增加 ali-sentinel 来替代 (Hystrix 监控,隔离,限流,断路器)
    13. 增加 Nacos (服务注册配置,配置中心[未使用])
    
### 问题
因为现在使用的 springboot 版本为 1.5.x,
gateWay 需要 springboot 2.0.x
不能轻易升级 springboot 的 版本 会导致 es,redis,mongo 全部不能使用

### 结构
* Consul_Consumer Consul消费者
* Consul_Server Consul服务者(Consul注册中心是 单独启动的 类似 zookeeper)
* Eureka_Client Eureka服务者(用来测试 多个Eureka客户端 负载均衡)
* Eureka_Client2 Eureka服务者2(测试负载均衡,+ sentinel来测试监控 限流) 
* Eureka_Consumer Eureka消费者(测试负载均衡,直接使用 spring_cloud 的 loadBalancerClient 来选择,使用 restTemplate 来调用) 
* Eureka_Server Eureka注册中心(与zookeeper,Consul,Nacos 不同,需要自己运行)
* Eureka_Server_Ribbon Eureka消费者2(使用Ribbon来调用,但好像没用上还是使用了loadBalancerClient,restTemplate, 有使用 Hystrix来进行断路器作业 )
* Eureka_Zuul 网关(作为权限拦截,和 将 请求引导至 新的 服务)
* GateWay(网关,spring-boot2.0 不在推荐 zuul. 需要升级2.0才能使用,现在为 1.5 ,无法启动)
* Hibernate 通过Hibernate的方式访问数据库 (目前想法是 将 Hibernate与Mybatis 分离 ,引入哪个jar 就使用 那种方式查询数据库,目前有问题)
* Hystrix_Dashboard Hystrix的 监控面板
* Mybatis 同 Hibernate
* Starter_Log 自动动手写的 一个 spring-boot 模块 (可以参考仿写 spring-boot 模块)
* Web 微服务中 每一个服务都是 Controller 层, 只有在 SOA 或 单体应用中 才有 web(包含前端), 前后端应该分离
* Eureka_Server_Feign Feign(使用Feign调用 注册的 rest, Feign 中已包含 Ribbon 会自动进行负载均衡)

### Sentinel
![wiki](https://github.com/alibaba/spring-cloud-alibaba/wiki/%E7%89%88%E6%9C%AC%E8%AF%B4%E6%98%8E)
![withSpringBoot](https://blog.csdn.net/tianyaleixiaowu/article/details/89916891)

### TODO
1. ~~配置中心 使用(携程 apollo)~~
2. ~~注册中心 增加 Nacos(服务注册 与 配置中心)~~
3. ~~增加 服务端 注册到 Nacos~~
4. ~~Web + Feign调用服务 Nacos~~
5. ~~增加 RocketMQ~~(位于AnewB 的 mq 模块中 与其他mq 在一起)
6. ~~增加 10 的 spring-cloud-steam~~(![wiki](https://blog.csdn.net/hubo_88/article/details/80904165))
7  ~~spring-cloud-config~~(spring-cloud-config 配置管理:使用Apollo代替)
8. ~~增加 11 的 spring-cloud-bus~~(消息总线 配合spring-cloud-config 实现配置自动刷新:使用Apollo代替) 

### 事务 
目前来看 微服务架构需要MQ来保证事务(或考虑下Fescar)(否则像以前Dubbo一样将 对数据库的操作原子化,写在一个服务中).
微服务与微服务之间的 调用只能是 查询 等不需要事务的操作.
如果是 新增,更新,删除等 通过 发送MQ,另一个服务 订阅MQ.来保证事务完整
然后需要考虑消息的 丢失(确认),重发(幂等性),顺序(分区).