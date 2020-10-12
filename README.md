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

见项目的 xml 分支