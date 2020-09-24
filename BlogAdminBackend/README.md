# Chapter 1 Spring Boot 入门
## 1.1 Spring Boot的自定义配置
随机端口： 因为微服务开发人员是不需要记住端口号的，可以给随机端口，这样就不用每个都单独配置端口了
并且如果不配置，一个服务器有多个微服务就会出现端口冲突

```
server.port=${random.int[1024,9999]}
```

## 1.2 # 日志配置
从spring-boot-starter-logging可以看出，它依赖了三个框架：slf4j, logback, log4j

### 1.2.1 区别：
1. logback, log4j：是日志实现框架，实现如何记录日志
2. slf4j：提供了额java中所有日志框架的简单抽象（日志的门面设计模式），即日志API，没有实现类所以不能单独使用，所以要结合logback或者log4j来实现
3. springboot的默认搭配：
    - 2.0默认采用slf4j+logback的日志搭配
    - spring默认打印info级别的日志

设置日志打印等级：
```
logging.level.org.mengsoft.webbackend=info
```

### 1.2.2 日志存储路径
```
logging.file.path=output/logs/
```
### 1.2.3配置日志格式
```
%d时间格式 %thread 线程 %-5从左五个字符宽度 %logger{50} 日志50个字符 %msg信息 %n换行
logging.pattern.console=%d{yyyy-MM-dd} [%thread] %-5level %logger{50} %msg%n
logging.pattern.file=%d{yyyy-MM-dd} [%thread] %-5level %logger{50} %msg%n
```
# Chapter 2 Using lombok in Spring Boot
## 2.1 What problem does lombok solve?
Developers do not need to write getter/setter, constructor, 
equals and other methods. And when you need to change properties,
 you don't need to modify the functions.

## 2.2 How to use lombok?
- Install plugin lombok in Idea
- import dependency
- @Data on Entity
- @Slf4j instead of 
```
private static final Logger logger = LoggerFactory.getLogger(UserController.class);
```

# Chapter 3 Spring boot's asynchronous framework
## 3.1 Outline
@Async
## 3.2 Why use an asynchronous framework?
Asynchronous communication can improve performance and improve fault tolerance.
### 3.2.1 Performance
For example, registered users send points. It takes 20ms for registered users 
and 50ms to send points. User registration can be completed within 
20ms using asynchronous communication.
### 3.2.2 Fault tolerance
Again, let's talk about the example of users registering to send points. If the 
reward of points fails, we cannot directly tell the user that the registration 
failed.

## 3.3. How to use it?
### 3.3.1 Step 1
```
@Configuration
@EnableAsync
public class SyncConfiguration {
}
```
### 3.3.2 Step 2
Mark method as Async
```
@Async
public void addScore(){
}
```
### 3.4 Set custom thread pool for @Async
@Async default thread pool is SimpleAsyncTaskExecutor. The thread pool thread is not reused, and a new thread is created each time.

ThreadPoolTaskExecutor: Packaging java.util.concurrent.ThreadPoolExecutor

# Chapter 4 Swagger
Automatically generate interface documentation.

1. Method CreatRestApi need package name, which represent your document package.

Swagger Annotation|Usage|Position
---|---|---
@Api|The role of classes|Class
@ApiOperation|The role of Method|Method
@Apipattern|The role of parameter|Parameter of Method
@ApiModel|Object|Object
@ApiModelPropert|Property in Model

URL: http://localhost:8082/swagger-ui.html

# Chapter 4 Response Encapsulation

# Chapter 5 Global exception handler
1. JSR303 cannot be caught by try{}catch{}

# Chapter 6 Validator


















