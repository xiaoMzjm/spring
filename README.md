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

### 1.4 [el](https://github.com/xiaoMzjm/spring/tree/master/spring4/src/main/java/com/wisely/hightlight_spring4/ch2/el)

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
| [@Conditional(XXXCondition.class)](https://github.com/xiaoMzjm/spring/blob/master/spring4/src/main/java/com/wisely/hightlight_spring4/ch3/conditional/ConditionConfig.java) | XXXCondition.class这个类中的match方法返回true，则...。一般跟@Bean一起使用，但满足Condition时，才创建bean |



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



# 二、spring  mvc

## 2.1 [控制器](https://github.com/xiaoMzjm/spring/tree/master/springmvc4/src/main/java/com/wisely/highlight_springmvc4)

| 注解                                       | 含义                                       |
| ---------------------------------------- | ---------------------------------------- |
| [@Controller](https://github.com/xiaoMzjm/spring/blob/master/springmvc4/src/main/java/com/wisely/highlight_springmvc4/HelloController.java) | 注解在类上，表明这个类是spring mvc里的Controller。可以被http请求访问到。 |
| [@RequestMapping(value="xxx")](https://github.com/xiaoMzjm/spring/blob/master/springmvc4/src/main/java/com/wisely/highlight_springmvc4/HelloController.java) | 用来映射web请求（访问路径和参数）、处理类和方法的。注解在类上，代表该类所有方法的访问的前缀URL。注解在方法上，代表该方法的访问地址。 |
| @ResponseBody                            | 注解在类上，代表该类所有方法都直接放回数据（ajax）。注解在方法上，代表该方法直接返回数据（用户ajax）。 |
| [@RequestMapping(produces = "text/plain;charset=UTF-8")](https://github.com/xiaoMzjm/spring/blob/master/springmvc4/src/main/java/com/wisely/highlight_springmvc4/domain/DemoAnnoController.java) | prodeces，申明返回数据的格式，一般配合@ResponseBody一起使用。 |
| [@RequestMapping(value="/pathvar/{str}" , produces = "text/plain;charset=UTF-8")](https://github.com/xiaoMzjm/spring/blob/master/springmvc4/src/main/java/com/wisely/highlight_springmvc4/domain/DemoAnnoController.java) | value="/pathvar/{str}"，意思是URL中，/pathvar/后面的部分将会作为参数传入方法，参数名为str。 |
| [method(@PathVariable String str)](https://github.com/xiaoMzjm/spring/blob/master/springmvc4/src/main/java/com/wisely/highlight_springmvc4/domain/DemoAnnoController.java) | @PathVaribale，注解方法的参数左边，结合上面的value注解，把URL上的东西注入到该属性中去。 |
| method(Long id)                          | 访问路径：/xxx/xxx?id=1，那么id直接会注入到方法的入参中      |
| method(MyDemo)                           | 访问路径：/xxx/xxx?id=1，假如MyDemo类中有一个字段叫id，那么会自动注入。 |
| method(HttpServletRequest request)       | HttpServletRequest可以随时被注入                |
| @RequestMapping(value= {"/name1" , "/name2"}) | value可以是个数组，这样多个地址都放进入到该                 |
| @RestController                          | 注解在类上，相当于@Controller和@ResponseBody的结合。   |



## 2.2 拦截器

| 注解                                       | 含义                                       |
| ---------------------------------------- | ---------------------------------------- |
| [HandlerInterceptorAdapter](https://github.com/xiaoMzjm/spring/blob/master/springmvc4/src/main/java/com/wisely/highlight_springmvc4/interceptor/DemoInterceptor.java) | 继承该类，实现两个方法，分别在请求前和请求后进行拦截。1、实现类要@Bean交给spring管理。2、要手动添加实现类到拦截器链中。 |
| [@ControllerAdvice](https://github.com/xiaoMzjm/spring/blob/master/springmvc4/src/main/java/com/wisely/highlight_springmvc4/advice/AdviceController.java) | 配置在类上，该类的配置适用于所有的@RequestMapping方法。例如设置全局的KV变量，在所有方法中可以获取；例如设置对URL中的参数进行过滤等等。 |
|                                          |                                          |



## 2.3 文件上传

依赖三方包：

```java
		<!--  文件上传 -->
		<dependency>
			<groupId>commons-fileupload</groupId>
			<artifactId>commons-fileupload</artifactId>
			<version>1.3.1</version>
		</dependency>
		<!-- 非必须，可简化IO操作 -->
		<dependency>
			<groupId>commons-io</groupId>
			<artifactId>commons-io</artifactId>
			<version>2.3</version>
		</dependency>
```

配置上传大小，编码格式代码例子：[点我](https://github.com/xiaoMzjm/spring/blob/master/springmvc4/src/main/java/com/wisely/highlight_springmvc4/MyMvcConfig.java)

接收文件代码例子：[点我](https://github.com/xiaoMzjm/spring/blob/master/springmvc4/src/main/java/com/wisely/highlight_springmvc4/fileupload/UploadController.java)





## 2.4 服务器推送

[Controllor](https://github.com/xiaoMzjm/spring/blob/master/springmvc4/src/main/java/com/wisely/highlight_springmvc4/push/SseController.java)

[js](https://github.com/xiaoMzjm/spring/blob/master/springmvc4/src/main/webapp/views/sse.jsp)

# 三、springboot

### 3.1 手动创建springBoot项目需要的依赖

[pom.xml](https://github.com/xiaoMzjm/spring/blob/master/springboot/spring_boot_min_need_pom.xml)



### 3.2 关闭特定的自动配置类

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})



### 3.3 定制Banner

1. 修改src/main/resources下新建一个banner.txt，复制字符串进去(快速生成：http://patorjk.com/software/taag/)，项目启动时就会打印该字符串

### 3.4 特殊场景下不得不使用xml配置

@ImportResource({"classpath:some-context.xml","classpath:some-context2.xml"})



### 3.5 简化版@Value——@ConfigurationProperties

```java
@ConfigurationProperties(prefix="book")
public class Application{
  private String name;
  private String price;
}
```

如上配置后application.properties文件以book开头的配置都会读进来。

```x
book.name = 亲热天堂
book.price = 50
```

也可以指定一个配置文件：

```java
@ConfigurationProperties(prefix="book",locations={"classpath:config/author.propereties"})
```



### 3.6 profile配置





