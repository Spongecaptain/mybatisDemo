# README

本项目用于说明一个简单的 Spring Boot 整合 MyBatis 的案例，一共使用两种策略来实现 MyBatis 式 MySQL 数据库查询：

- 注解式（用 Java 代码来配置 SQL 语句）；
- XML 式（用 XML 文件来配置 SQL 语句）；

## 1. 项目依赖以及启动配置

首先利用 [Spring Boot Initializr](https://start.spring.io/) 引入 Spring Web 依赖。

其次，引入 MyBatis 以及 MySQL 驱动的相关依赖：

```xml
<!--MySQL 驱动依赖-->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
</dependency>
<!--MyBatis 依赖-->
<dependency>
    <groupId>org.mybatis.spring.boot</groupId>
    <artifactId>mybatis-spring-boot-starter</artifactId>
</dependency>
```

然后，我们需要在 applicaiton.properties 配置文件中加入如下的配置：

```properties
mybatis.type-aliases-package=com.neo.model

spring.datasource.url=jdbc:mysql://localhost:3306/test?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8&useSSL=true
spring.datasource.username=root
spring.datasource.password=199701
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```

> 连接的 MySQL 部署于本地，监听本地端口 3306。

## 2. 数据库准备

在数据库 mydatabase 下创建一个用户表 users，每一个用户有有三个字段 id（主键，自增）、name、age，然后仅仅有一条数据：

- i=1
- name=Spongecaptain
- age=20

## 3. 注解式 MyBatis 使用案例

见项目的 default(main)分支。

## 4. XML 式 MyBatis 使用案例

见项目的 xml 分支。

更完整的例子可以参考：https://www.cnblogs.com/ityouknow/p/6037431.html


## 5. Spring Boot 结合 jsp

见项目的 jsp 分支。

Spring Boot 结合 jsp 项目主要参考于：https://www.cnblogs.com/luzhanshi/p/10923867.html

大致步骤为：

- 在 src/main 目录下创建目录 webapp/WEB-INF/jsp 用于存放 jsp 页面;
- 在 Project Structure 的 Module 栏中选则 Spring 的 Web，然后将 Web App 设置为 Web resource directory
- 在 application.properties 配置文件中添加如下的配置
    ```properties
    # jsp 资源目录配置
    spring.mvc.view.prefix=/WEB-INF/jsp
    spring.mvc.view.suffix=.jsp    
    ```
- 添加额外依赖
    ```xml
    <!--web支持-->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    
    <!--JavaServer Pages Standard Tag Library，JSP标准标签库-->
    <dependency>
        <groupId>javax.servlet</groupId>
        <artifactId>jstl</artifactId>
    </dependency>
    
    <!--内置tomcat对Jsp支持的依赖，用于编译Jsp-->
    <dependency>
        <groupId>org.apache.tomcat.embed</groupId>
        <artifactId>tomcat-embed-jasper</artifactId>
        <scope>provided</scope>
    </dependency>
   ```
  - 去除模板框架的依赖
