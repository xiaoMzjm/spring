# spring

以下功能都是annotation配置，无需写一个xml。

## 一、spring4

### 1.1 [配置类](https://github.com/xiaoMzjm/spring/tree/master/spring4/src/main/java/com/wisely/hightlight_spring4/ch1/di)

| 注解                                       | 含义                   |
| ---------------------------------------- | -------------------- |
| [@Configuration](https://github.com/xiaoMzjm/spring/blob/master/spring4/src/main/java/com/wisely/hightlight_spring4/ch1/di/DiConfig.java) | 配置该注解的类，就是配置类，替代xml。 |
| [@ComponentScan("com.xxx")](https://github.com/xiaoMzjm/spring/blob/master/spring4/src/main/java/com/wisely/hightlight_spring4/ch1/di/DiConfig.java) | 扫包路径                 |

### 1.2 [aop](https://github.com/xiaoMzjm/spring/tree/master/spring4/src/main/java/com/wisely/hightlight_spring4/ch1/aop)

| 注解                                       | 含义                                       |
| ---------------------------------------- | ---------------------------------------- |
| [@EnableAspectJAutoProxy](https://github.com/xiaoMzjm/spring/blob/master/spring4/src/main/java/com/wisely/hightlight_spring4/ch1/aop/AopConfig.java) | 开启切片功能，配在配置类上                            |
| [@Aspect](https://github.com/xiaoMzjm/spring/blob/master/spring4/src/main/java/com/wisely/hightlight_spring4/ch1/aop/LogAspect.java) | 注解一个切面，配置在切面类上。                          |
| [@Pointcut("@annotation(com.xx.MyAnnotaionClazz)")](https://github.com/xiaoMzjm/spring/blob/master/spring4/src/main/java/com/wisely/hightlight_spring4/ch1/aop/LogAspect.java) | 声明切点。注解在一个void,没有方法体的方法上。                |
| [@After("annotationPointCut()")](https://github.com/xiaoMzjm/spring/blob/master/spring4/src/main/java/com/wisely/hightlight_spring4/ch1/aop/LogAspect.java) | 声明建言，使用@PointCut定义的切点。建言就是要插入（不是被插）的一个方法。 |
| [@Before("execution(* com.xxx.aop.MyService.*(..))")](https://github.com/xiaoMzjm/spring/blob/master/spring4/src/main/java/com/wisely/hightlight_spring4/ch1/aop/LogAspect.java) | 声明建言。使用表达式配置哪些方法需要被插入。                   |

### 1.3 [@Bean](https://github.com/xiaoMzjm/spring/tree/master/spring4/src/main/java/com/wisely/hightlight_spring4/ch1/javaconfig)

| 注解                                       | 含义                                       |
| ---------------------------------------- | ---------------------------------------- |
| [@Bean](https://github.com/xiaoMzjm/spring/blob/master/spring4/src/main/java/com/wisely/hightlight_spring4/ch1/javaconfig/JavaConfig.java) | 在一个方法上配置@Bean，该方法返回的对象将会交给spring管理。该方法的方法名就是该bean的名称。 |

### 1.4 el

使用el表达式，从配置文件读取配置，注入到bean的属性中。

| 注解                                       | 含义                  |
| ---------------------------------------- | ------------------- |
| [@PropertySource("classpath:com/xxx/test.properties")](https://github.com/xiaoMzjm/spring/blob/master/spring4/src/main/java/com/wisely/hightlight_spring4/ch2/el/ElConfig.java) | 注解在配置类上。引入配置文件。     |
| [@Value("常量")](https://github.com/xiaoMzjm/spring/blob/master/spring4/src/main/java/com/wisely/hightlight_spring4/ch2/el/ElConfig.java) | 配置在bean的属性上，注入一个常量。 |
| @Value("#{systemProperties['os.name']}") | 注入系统                |
| @Value("T(java.lang.Math).random() * 100.0") | 注入一段表达式结果           |
| @Value("#{myService.myname}")            | 注入其他bean的属性         |
| @Value("${book.name}")                   | 注入配置文件的属性           |
| @Value("classpath:com/xxx/test.properties") | 注解在Resource类型的属性上   |
| @Value("http://www.baidu.com")           | 注解在Resource类型的属性上   |
|                                          |                     |

### 1.5 [组合注解](https://github.com/xiaoMzjm/spring/blob/master/spring4/src/main/java/com/wisely/hightlight_spring4/ch3/annotation/WiselyConfiguration.java)

直接在注解类A上注解B、C，再用这个注解类A，那么这个注解会同时有B、C注解的功能。



### 1.6 [Condition](https://github.com/xiaoMzjm/spring/tree/master/spring4/src/main/java/com/wisely/hightlight_spring4/ch3/conditional)

需要先实现一个[Conditon](https://github.com/xiaoMzjm/spring/blob/master/spring4/src/main/java/com/wisely/hightlight_spring4/ch3/conditional/LinuxCondition.java)接口，实现match方法。

| 注解                                       | 含义                                       |
| ---------------------------------------- | ---------------------------------------- |
| [@Conditional(XXXCondition.class)](https://github.com/xiaoMzjm/spring/blob/master/spring4/src/main/java/com/wisely/hightlight_spring4/ch3/conditional/ConditionConfig.java) | XXXCondition.class这个类中的match方法返回true，则...。一般配置@Bean使用 |



### 1.7 [单元测试](https://github.com/xiaoMzjm/spring/tree/master/spring4/src/main/java/com/wisely/hightlight_spring4/ch3/fortest)

| 注解                                       | 含义                                |
| ---------------------------------------- | --------------------------------- |
| [@RunWith(SpringJunit4ClassRunner.class)](https://github.com/xiaoMzjm/spring/blob/master/spring4/src/main/java/com/wisely/hightlight_spring4/ch3/fortest/Main.java) | 在junit环境下提供spring功能。配置在Main启动函数中。 |
| [@ContextConfiguration(classes={TestConfig.class})](https://github.com/xiaoMzjm/spring/blob/master/spring4/src/main/java/com/wisely/hightlight_spring4/ch3/fortest/Main.java) | spring配置类。配置在Main启动函数中。           |



### 1.8 [异步执行](https://github.com/xiaoMzjm/spring/tree/master/spring4/src/main/java/com/wisely/hightlight_spring4/ch3/taskexecutor)

| 注解                                       | 含义                                       |
| ---------------------------------------- | ---------------------------------------- |
| [@EnableAsync](https://github.com/xiaoMzjm/spring/blob/master/spring4/src/main/java/com/wisely/hightlight_spring4/ch3/taskexecutor/MainConfig.java) | 开启异步注解支持功能。配置在配置类。                       |
| [@Async](https://github.com/xiaoMzjm/spring/blob/master/spring4/src/main/java/com/wisely/hightlight_spring4/ch3/taskexecutor/AsyncTaskService.java) | 通过该注解，表明该方法是个异步方法，如果注解在类级别，则表明该类所有方法都是异步方法。 |



### 1.9 [计划任务](https://github.com/xiaoMzjm/spring/tree/master/spring4/src/main/java/com/wisely/hightlight_spring4/ch3/taskscheduler)

| 注解                                       | 含义                                  |
| ---------------------------------------- | ----------------------------------- |
| [@EnableScheduling](https://github.com/xiaoMzjm/spring/blob/master/spring4/src/main/java/com/wisely/hightlight_spring4/ch3/taskscheduler/TaskSchedulerConfig.java) | 开启计划任务。配置在配置类上。                     |
| [@Scheduled(fixedRate=5000)](https://github.com/xiaoMzjm/spring/blob/master/spring4/src/main/java/com/wisely/hightlight_spring4/ch3/taskscheduler/ScheduledTaskService.java) | 配置在方法上，代表计划任务。fixedRate=5000标识每5秒执行 |
| [@Scheduled(cron="10 54 0 ? * *")](https://github.com/xiaoMzjm/spring/blob/master/spring4/src/main/java/com/wisely/hightlight_spring4/ch3/taskscheduler/ScheduledTaskService.java) | 每月，每周，每天的0时54分10秒执行。                |