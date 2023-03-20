## 前言
### 🍊缘由
经常看到网上很多**优秀的开源项目中，代码简洁，模块分层完美**。反观自己代码层级混乱，，却不知如何整理分层。此文**手把手教你一步一步创建模块**，左手右手一个慢动作。结合本人实际开发及个人项目中**分层思路的分享，大神请勿喷**。

### ⏲️本文阅读时长
> 约25分钟

### 🎯主要目标
1. **熟练掌握SpringBoot项目分层思路**，丝滑拆分模块
2. **熟悉代码层级依赖**，规范化管理模块分布
3. 手把手实战学习，理论实践相结合

### 👨‍🎓试用人群
1. 对于Springboot熟悉但是不知道合理分层**小白**
2. 有自己分层思路可以互相分享学习

### 🎁快速链接
公众号：**JavaDog程序狗**
**在公众号，发送【分层】 ，无任何套路即可获得**

![在这里插入图片描述](https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/a19d79aa9f1544a79d3feec43937f500~tplv-k3u1fbpfcp-zoom-1.image)
或访问[https://blog.javadog.net/archives/boot-module](https://blog.javadog.net/archives/boot-module)

### 🍩水图
> 下图反面教材，传统单体应用，结构臃肿

![在这里插入图片描述](https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/9da77e3b292744caae19877e670a8c18~tplv-k3u1fbpfcp-zoom-1.image)


> 下图分层截选自本人的一个小项目，模块清晰，分工明确

![在这里插入图片描述](https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/8438a89a9c18453288906bb2a24193e3~tplv-k3u1fbpfcp-zoom-1.image)
> 我们要实现的小栗子的分层

![在这里插入图片描述](https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/3e5cd2443144420b872420e36ee395fd~tplv-k3u1fbpfcp-zoom-1.image)


##  正文
### 🥫1.IDEA新建项目
> 起名第一步，一个好名字,说不定是个好的开始

假如我们的项目是个**聊天相关**的项目，英文对应**chat**,所以定义项目名为**chat-boot**，其他的以此效仿

>点击New->project 

![在这里插入图片描述](https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/115c384d8c774993aefb56a8c5082942~tplv-k3u1fbpfcp-zoom-1.image)
>选择**Maven项**目，并选择**合适JDK版本**,点击Next

![在这里插入图片描述](https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/6ecb922c35064dcdaf4d6ed7f5a83af3~tplv-k3u1fbpfcp-zoom-1.image)
>录入项目名称，并填写GAV坐标，点击Finish

![在这里插入图片描述](https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/98406fcff2a44f2f9b31ec68a871c69b~tplv-k3u1fbpfcp-zoom-1.image)
>删除无用文件及目录，如src目录和*.iml文件

![在这里插入图片描述](https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/ca9e2d157fa54500b586ab9949c24d80~tplv-k3u1fbpfcp-zoom-1.image)
>删除后项目目录

![在这里插入图片描述](https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/3da965a6a75f435792402d30d330178c~tplv-k3u1fbpfcp-zoom-1.image)
>修改pom.xml中依赖，增加spring-boot-starter-parent
```xml
 <parent>
     <groupId>org.springframework.boot</groupId>
     <artifactId>spring-boot-starter-parent</artifactId>
     <version>2.3.1.RELEASE</version>
 </parent>
```
![在这里插入图片描述](https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/559cedac0d9d4abf8f29436817a21b5d~tplv-k3u1fbpfcp-zoom-1.image)


******
### 🌭2.创建子模块-dependencies(依赖层)

>右击项目chat-boot，new ->Moudle新建模块chat-boot-dependencies

![在这里插入图片描述](https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/166303358e63409690de8865c823c75e~tplv-k3u1fbpfcp-zoom-1.image)
>选择对应Module SDK版本，本人选择jdk1.8

![在这里插入图片描述](https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/329503c3d25e41ab9b070fd18f3c8c8d~tplv-k3u1fbpfcp-zoom-1.image)
>填写子模块名 chat-boot-dependencies，然后检查对应GAV，点击Finish

![在这里插入图片描述](https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/2a3aedb828a544d8a6f9d47d74d9e8dd~tplv-k3u1fbpfcp-zoom-1.image)

>生成子模块**chat-boot-dependencies**如下图

![在这里插入图片描述](https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/5e8da0e8774043e4b27f6e085c3d016f~tplv-k3u1fbpfcp-zoom-1.image)

>删除**chat-boot-dependencies**下无用文件及目录，如src目录，删除无用目录如下

![在这里插入图片描述](https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/57a6f971ba284dfca38bb4714bc9e5c8~tplv-k3u1fbpfcp-zoom-1.image)


>完善**chat-boot-dependencies**下pom.xml依赖， **常用依赖**放入，作为**依赖主体**，以下是本狗常用依赖，可酌情选择；**记得把packaging改为pom**
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>chat-boot</artifactId>
        <groupId>net.javadog.chat</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <artifactId>chat-dependencies</artifactId>

    <packaging>pom</packaging>

    <properties>
        <maven.compiler.source>8</maven.compiler.source>
        <maven.compiler.target>8</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
        <mysql-connector-java.version>8.0.17</mysql-connector-java.version>
        <druid.version>1.1.21</druid.version>
        <mybatis-plus.version>3.4.1</mybatis-plus.version>
        <fastjson.version>1.2.75</fastjson.version>
        <hutool.version>5.5.8</hutool.version>
        <lombok.versin>1.18.12</lombok.versin>
        <easypoi.version>4.2.0</easypoi.version>
        <springfox-swagger2.version>2.9.2</springfox-swagger2.version>
        <springfox-swagger-ui.version>2.9.2</springfox-swagger-ui.version>
        <knife4j.version>2.0.4</knife4j.version>
        <weixin.version>4.4.5.B</weixin.version>
        <shiro.version>1.3.2</shiro.version>
        <jwt.version>3.2.0</jwt.version>
    </properties>

    <dependencyManagement>
        <dependencies>
            <!--mybatis-plus-->
            <dependency>
                <groupId>com.baomidou</groupId>
                <artifactId>mybatis-plus-boot-starter</artifactId>
                <version>${mybatis-plus.version}</version>
            </dependency>

            <!-- 数据库驱动,可根据自己需要自行删减，默认使用mysql -->
            <dependency>
                <groupId>mysql</groupId>
                <artifactId>mysql-connector-java</artifactId>
                <version>${mysql-connector-java.version}</version>
            </dependency>

            <!--数据库连接池-->
            <dependency>
                <groupId>com.alibaba</groupId>
                <artifactId>druid</artifactId>
                <version>${druid.version}</version>
            </dependency>

            <!--fastjson-->
            <dependency>
                <groupId>com.alibaba</groupId>
                <artifactId>fastjson</artifactId>
                <version>${fastjson.version}</version>
            </dependency>

            <!--hutool-->
            <dependency>
                <groupId>cn.hutool</groupId>
                <artifactId>hutool-all</artifactId>
                <version>${hutool.version}</version>
            </dependency>

            <!--lombok-->
            <dependency>
                <groupId>org.projectlombok</groupId>
                <artifactId>lombok</artifactId>
                <version>${lombok.versin}</version>
            </dependency>

            <!--swagger2-->
            <dependency>
                <groupId>io.springfox</groupId>
                <artifactId>springfox-swagger2</artifactId>
                <version>${springfox-swagger2.version}</version>
            </dependency>

            <!--swagger-ui-->
            <dependency>
                <groupId>io.springfox</groupId>
                <artifactId>springfox-swagger-ui</artifactId>
                <version>${springfox-swagger-ui.version}</version>
            </dependency>

            <!-- swagger接口文档 -->
            <dependency>
                <groupId>com.github.xiaoymin</groupId>
                <artifactId>knife4j-spring-boot-starter</artifactId>
                <version>${knife4j.version}</version>
            </dependency>

            <!--easypoi导入导出-->
            <dependency>
                <groupId>cn.afterturn</groupId>
                <artifactId>easypoi-base</artifactId>
                <version>${easypoi.version}</version>
            </dependency>

            <!--WxJava - 微信开发 Java SDK-->
            <dependency>
                <groupId>com.github.binarywang</groupId>
                <artifactId>weixin-java-miniapp</artifactId>
                <version>${weixin.version}</version>
            </dependency>

            <!--整合Shiro安全框架-->
            <dependency>
                <groupId>org.apache.shiro</groupId>
                <artifactId>shiro-spring</artifactId>
                <version>${shiro.version}</version>
            </dependency>

            <!--集成jwt实现token认证-->
            <dependency>
                <groupId>com.auth0</groupId>
                <artifactId>java-jwt</artifactId>
                <version>${jwt.version}</version>
            </dependency>
        </dependencies>
    </dependencyManagement>
</project>
```
####  🎯重点
此处用的标签是 **dependencyManagement**，
> **dependencyManagement只是声明依赖，并不实现引入**，因此**子项目需要显示的声明需要用的依赖**。如果**不在子项目中声明依赖，是不会从父项目中继承下来**；**只有在子项目中写了该依赖项，并且没有指定具体版本，才会从父项目中继承该项**，并且version和scope都读取自父pom;另外如果子项目中指定了版本号，那么会使用子项目中指定的jar版本。

******
### 🍪3.创建子模块-main(主启动层)
>右击项目chat-boot，new ->Moudle新建模块chat-boot-main

![在这里插入图片描述](https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/8b702215d47c4b1a9ef46f19521cedbd~tplv-k3u1fbpfcp-zoom-1.image)
>选择对应Module SDK版本，本狗选择jdk1.8，点击Next

![在这里插入图片描述](https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/35dfccfe08b744d5b0ad598b1e45b73c~tplv-k3u1fbpfcp-zoom-1.image)

>填写子模块名 chat-boot-main，然后检查对应GAV，点击Finish

![在这里插入图片描述](https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/5abde94615a6444b9bfde39ebaf1cba2~tplv-k3u1fbpfcp-zoom-1.image)
>生成子模块chat-boot-main如下图

![在这里插入图片描述](https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/3b75169fb0f645eba46bb975636b03eb~tplv-k3u1fbpfcp-zoom-1.image)

>完善chat-boot-main模块下pom.xml中依赖

 1. 引入必要依赖
 2. 完善profiles标签中环境相关
 3. 配置build标签中插件

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>chat-boot</artifactId>
        <groupId>net.javadog.chat</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <artifactId>chat-boot-main</artifactId>

    <properties>
        <maven.compiler.source>8</maven.compiler.source>
        <maven.compiler.target>8</maven.compiler.target>
    </properties>

    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>net.javadog.chat</groupId>
                <artifactId>chat-boot-dependencies</artifactId>
                <version>1.0-SNAPSHOT</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>

    <dependencies>
        <!-- web -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <!--lombok-->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
        </dependency>
        <!--swagger2-->
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger2</artifactId>
        </dependency>
        <!--swagger-ui-->
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger-ui</artifactId>
        </dependency>
        <!-- swagger接口文档 -->
        <dependency>
            <groupId>com.github.xiaoymin</groupId>
            <artifactId>knife4j-spring-boot-starter</artifactId>
        </dependency>
    </dependencies>

    <build>
        <finalName>chat</finalName>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <executions>
                    <execution>
                        <goals>
                            <goal>repackage</goal>
                        </goals>
                    </execution>
                </executions>
                <configuration>
                    <fork>true</fork>
                </configuration>
            </plugin>
        </plugins>
        <resources>
            <resource>
                <directory>src/main/webapp</directory>
                <filtering>false</filtering>
            </resource>
            <resource>
                <directory>src/main/resources</directory>
                <filtering>true</filtering>
            </resource>
            <resource>
                <directory>src/main/java</directory>
                <includes>
                    <include>**/*.xml</include>
                </includes>
            </resource>
        </resources>
    </build>

    <profiles>
        <profile>
            <id>local</id>
            <properties>
                <spring.active>local</spring.active>
            </properties>
            <activation>
                <activeByDefault>true</activeByDefault>
            </activation>
        </profile>
        <profile>
            <id>dev</id>
            <properties>
                <spring.active>dev</spring.active>
            </properties>
        </profile>
        <profile>
            <id>prod</id>
            <properties>
                <spring.active>prod</spring.active>
            </properties>
        </profile>
    </profiles>
</project>
```

####  🎯重点
 - 配置引入依赖chat-boot-dependencies,用作此模块依赖引入

```xml
<dependencyManagement>
     <dependencies>
         <dependency>
             <groupId>net.javadog.chat</groupId>
             <artifactId>chat-boot-dependencies</artifactId>
             <version>1.0-SNAPSHOT</version>
             <type>pom</type>
             <scope>import</scope>
         </dependency>
     </dependencies>
</dependencyManagement>
```
 - 配置build标签用于完善插件plugins，其中包含maven-compiler-plugin和maven-resources-plugin

```xml
<build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.1</version>
                <configuration>
                    <source>${java.version}</source>
                    <target>${java.version}</target>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-resources-plugin</artifactId>
                <version>2.6</version>
                <configuration>
                    <delimiters>
                        <delimiter>@</delimiter>
                    </delimiters>
                    <useDefaultDelimiters>false</useDefaultDelimiters>
                </configuration>
            </plugin>
        </plugins>
        <resources>
            <resource>
                <directory>src/main/webapp</directory>
                <filtering>false</filtering>
            </resource>
            <resource>
                <directory>src/main/resources</directory>
                <filtering>true</filtering>
            </resource>
            <resource>
                <directory>src/main/java</directory>
                <includes>
                    <include>**/*.xml</include>
                </includes>
            </resource>
        </resources>
    </build>
```
 
 - 配置profiles环境变量标签，用于方便打包切换，本狗设置了 local、dev、prod三种环境
 
```xml
 <profiles>
     <profile>
         <id>local</id>
         <properties>
             <spring.active>local</spring.active>
         </properties>
         <activation>
             <activeByDefault>true</activeByDefault>
         </activation>
     </profile>
     <profile>
         <id>dev</id>
         <properties>
             <spring.active>dev</spring.active>
         </properties>
     </profile>
     <profile>
         <id>prod</id>
         <properties>
             <spring.active>prod</spring.active>
         </properties>
     </profile>
 </profiles>
```
操作可在IDEA右上角方便切换环境
![在这里插入图片描述](https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/4d5f86d05d974bc984be4a106b23d7b3~tplv-k3u1fbpfcp-zoom-1.image)
 💥切记一定主动Reload一下Maven依赖
 💥切记一定主动Reload一下Maven依赖
 💥切记一定主动Reload一下Maven依赖
![在这里插入图片描述](https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/94bd78bc34c449dabcac88711a7e74ca~tplv-k3u1fbpfcp-zoom-1.image)

>在chat-boot-main模块中加入启动类，在src/main/java下右键New=>Java Class

![在这里插入图片描述](https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/f38538a75127412a97739b85b15dd692~tplv-k3u1fbpfcp-zoom-1.image)
>录入启动类名ChatApplication

![在这里插入图片描述](https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/8f362699829a49a1b845adb8d701b67c~tplv-k3u1fbpfcp-zoom-1.image)
>完善ChatApplication启动类代码

```java
package net.javadog.chat;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author: hdx
 * @Date: 2023-01-28 11:24
 * @version: 1.0
 **/
@SpringBootApplication
@ServletComponentScan
@Slf4j
@EnableSwagger2
@EnableKnife4j
public class ChatApplication {
    public static void main(String[] args) throws UnknownHostException {
        // 启动类
        ConfigurableApplicationContext application = SpringApplication.run(ChatApplication.class, args);
        // 打印基础信息
        info(application);
    }

    static void info(ConfigurableApplicationContext application) throws UnknownHostException {
        Environment env = application.getEnvironment();
        String ip = InetAddress.getLocalHost().getHostAddress();
        String port = env.getProperty("server.port");
        String active = env.getProperty("spring.profiles.active");
        String contextPath = env.getProperty("server.servlet.context-path");
        if (contextPath == null) {
            contextPath = "";
        }
        log.info("\n----------------------------------------------------------\n\t" +
                "欢迎访问  \thttps://blog.javadog.net\n\t" +
                "示例程序【" + active + "】环境已启动! 地址如下:\n\t" +
                "Local: \t\thttp://localhost:" + port + contextPath + "\n\t" +
                "External: \thttp://" + ip + ':' + port + contextPath + '\n' +
                "Swagger文档: \thttp://" + ip + ":" + port + contextPath + "/doc.html\n" +
                "----------------------------------------------------------");
    }
}
```

>配置application.yml文件

![在这里插入图片描述](https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/09b71ab3e8994bf9b7ee73cb6ef5f2d9~tplv-k3u1fbpfcp-zoom-1.image)
**application.yml**
```yml
#============================#
# server 配置
#============================#
server:
  port: 82
  max-http-header-size: 10240
  servlet:
    context-path: /chat/v1

#============================#
# spring 配置
#============================#
spring:
  application:
    # 应用名
    name: chat
  profiles:
    active: @spring.active@
  servlet:
    multipart:
      max-request-size: 100MB
      max-file-size: 100MB
  jackson:
    time-zone: GMT+8
    date-format: yyyy-MM-dd HH:mm:ss.SSS
    locale: zh_CN
    serialization:
      # 格式化输出
      indent_output: false
  main:
    allow-circular-references: true
    #解决swagger版本路径不兼容问题
  mvc:
    pathmatch:
      matching-strategy: ant_path_matcher

#============================#
# mybatisplus 配置
#============================#
mybatis-plus:
  mapper-locations: classpath:mapper/*.xml
  configuration:
    map-underscore-to-camel-case: true
    cache-enabled: true
    lazy-loading-enabled: true
    multiple-result-sets-enabled: true
    log-impl: org.apache.ibatis.logging.nologging.NoLoggingImpl
  global-config:
    banner: false
    db-config:
      id-type: assign_id
      table-underline: true
    enable-sql-runner: true
      #数据库类型
    db-type: MYSQL
  configuration-properties:
    prefix:
    #如果数据库为postgresql，则需要配置为blobType: BINARY
    blobType: BLOB
    #如果数据库为oracle或mssql，则需要配置为boolValue: 1
    boolValue: true

#============================#
# logging 配置
#============================#
logging:
  level:
    root: info
  file:
    path: /root/javadog/chat/logs/${spring.application.name}/
    name: ${spring.application.name}
  logback:
    rollingpolicy:
      max-history: 7
      max-file-size: 10MB

#============================#
# file 配置
#============================#
file:
  # 静态附件前缀
  static-prefix: attach
  # 上传的文件对外暴露的访问路径
  access-path-pattern: /${file.static-prefix}/**
  # 文件上传目录
  upload-folder: /root/javadog/chat/
  # 文件上传最大
  max-post-size: 10
```
**application-local.yml**
```yml
#服务配置
server:
  port: 8001
  max-http-header-size: 10240

# Mysql数据库
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/chat-boot?autoReconnect=true&useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=CONVERT_TO_NULL&useSSL=false&serverTimezone=CTT&nullCatalogMeansCurrent=true
    username: root
    password: root
  redis:
    host: localhost
    port: 6379
    password:
```

**application-dev.yml**
```yml
#服务配置
server:
  port: 7001
  max-http-header-size: 10240

# mybatisplus 配置
mybatis-plus:
  configuration:
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
```

**application-prod.yml**
```yml
#服务配置
server:
  port: 8005
```

🌊顺便加一下logback-spring.xml 日志文件
```xml
<?xml version="1.0" encoding="UTF-8" ?>
<configuration scan="true" scanPeriod="60 seconds" debug="false">
    <conversionRule conversionWord="clr" converterClass="org.springframework.boot.logging.logback.ColorConverter"/>
    <conversionRule conversionWord="wex"
                    converterClass="org.springframework.boot.logging.logback.WhitespaceThrowableProxyConverter"/>
    <conversionRule conversionWord="wEx"
                    converterClass="org.springframework.boot.logging.logback.ExtendedWhitespaceThrowableProxyConverter"/>
    <property name="CONSOLE_LOG_PATTERN"
              value="${CONSOLE_LOG_PATTERN:-%clr(%d{yyyy-MM-dd HH:mm:ss.SSS}){faint} %clr(${LOG_LEVEL_PATTERN:-%5p}) %clr(${PID:- }){magenta} %clr(---){faint} %clr([%15.15t]){faint} %clr(%-40.40logger{39}){cyan} %clr(:){faint} %m%n${LOG_EXCEPTION_CONVERSION_WORD:-%wEx}}"/>
    <property name="FILE_LOG_PATTERN"
              value="${FILE_LOG_PATTERN:-%d{yyyy-MM-dd HH:mm:ss.SSS} ${LOG_LEVEL_PATTERN:-%5p} ${PID:- } --- [%t] %-40.40logger{39} : %m%n${LOG_EXCEPTION_CONVERSION_WORD:-%wEx}}"/>

    <springProperty scope="context" name="application.name" source="spring.application.name" defaultValue="javadog"/>
    <springProperty scope="context" name="logging.path" source="logging.file.path" defaultValue="logs"/>
    <springProperty scope="context" name="logging.file.max-size" source="logging.logback.rollingpolicy.max-size"
                    defaultValue="10MB"/>
    <springProperty scope="context" name="logging.file.max-history" source="logging.logback.rollingpolicy.max-history"
                    defaultValue="30"/>
    <contextName>${application.name}</contextName>

    <springProfile name="dev,prod">
        <!--输出到控制台-->
        <appender name="console" class="ch.qos.logback.core.ConsoleAppender">
            <encoder>
                <pattern>${CONSOLE_LOG_PATTERN}</pattern>
            </encoder>
        </appender>
        <root level="info">
            <appender-ref ref="console"/>
        </root>
    </springProfile>

    <springProfile name="dev,test,prod">
        <!--输出到文件-->
        <appender name="file-info" class="ch.qos.logback.core.rolling.RollingFileAppender">
            <file>${logging.path}/info/${application.name}-info.log</file>
            <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
                <fileNamePattern>${logging.path}/info/${application.name}-info.%d{yyyy-MM-dd}.%i.log</fileNamePattern>

                <timeBasedFileNamingAndTriggeringPolicy class="ch.qos.logback.core.rolling.SizeAndTimeBasedFNATP">
                    <maxFileSize>${logging.file.max-size}</maxFileSize>
                </timeBasedFileNamingAndTriggeringPolicy>
                <!--只保留最近n天的日志-->
                <maxHistory>${logging.file.max-history}</maxHistory>
            </rollingPolicy>
            <!-- 追加方式记录日志 -->
            <append>true</append>
            <encoder>
                <pattern>${FILE_LOG_PATTERN}</pattern>
            </encoder>
        </appender>
        <appender name="file-warn" class="ch.qos.logback.core.rolling.RollingFileAppender">
            <filter class="ch.qos.logback.classic.filter.LevelFilter">
                <level>warn</level>
                <onMatch>ACCEPT</onMatch>
                <onMismatch>DENY</onMismatch>
            </filter>
            <file>${logging.path}/warn/${application.name}-warn.log</file>
            <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
                <fileNamePattern>${logging.path}$/warn/${application.name}-warn.%d{yyyy-MM-dd}.%i.log</fileNamePattern>
                <timeBasedFileNamingAndTriggeringPolicy class="ch.qos.logback.core.rolling.SizeAndTimeBasedFNATP">
                    <maxFileSize>${logging.file.max-size}</maxFileSize>
                </timeBasedFileNamingAndTriggeringPolicy>
                <!--只保留最近n天的日志-->
                <maxHistory>${logging.file.max-history}</maxHistory>
            </rollingPolicy>
            <encoder>
                <pattern>${FILE_LOG_PATTERN}</pattern>
            </encoder>
        </appender>
        <appender name="file-error" class="ch.qos.logback.core.rolling.RollingFileAppender">
            <filter class="ch.qos.logback.classic.filter.LevelFilter">
                <level>error</level>
                <onMatch>ACCEPT</onMatch>
                <onMismatch>DENY</onMismatch>
            </filter>
            <file>${logging.path}/error/${application.name}-error.log</file>
            <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
                <fileNamePattern>${logging.path}/error/${application.name}-error.%d{yyyy-MM-dd}.%i.log</fileNamePattern>
                <timeBasedFileNamingAndTriggeringPolicy class="ch.qos.logback.core.rolling.SizeAndTimeBasedFNATP">
                    <maxFileSize>${logging.file.max-size}</maxFileSize>
                </timeBasedFileNamingAndTriggeringPolicy>
                <!--只保留最近n天的日志-->
                <maxHistory>${logging.file.max-history}</maxHistory>
            </rollingPolicy>
            <encoder>
                <pattern>${FILE_LOG_PATTERN}</pattern>
            </encoder>
        </appender>

        <root level="INFO">
            <appender-ref ref="file-info"/>
            <appender-ref ref="file-warn"/>
            <appender-ref ref="file-error"/>
        </root>
    </springProfile>

</configuration>
```

>启动一下项目试试，启动如下证明成功。如果报错少依赖请再拉一下Maven依赖！！！

![在这里插入图片描述](https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/34805bf633184191bcff39cdbc873cf5~tplv-k3u1fbpfcp-zoom-1.image)
![在这里插入图片描述](https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/db27c4a8853747278ba21cf6c0e3564d~tplv-k3u1fbpfcp-zoom-1.image)

******
### 🍇4.创建子模块-module(模块层)
>右击项目chat-boot，new ->Moudle新建模块chat-boot-module

![在这里插入图片描述](https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/ca91224be5024716aa7b939fa9bc7896~tplv-k3u1fbpfcp-zoom-1.image)
>填写子模块名 chat-boot-module，然后检查对应GAV，点击Finish

![在这里插入图片描述](https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/0d64434c00404150bae16343cef9bf7c~tplv-k3u1fbpfcp-zoom-1.image)
>生成子模块**chat-boot-module**如下图

![在这里插入图片描述](https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/b9bccd0d6c614f6d8fbc1f39c3ac7187~tplv-k3u1fbpfcp-zoom-1.image)
>删除**chat-boot-module**下无用文件及目录，如src目录，删除无用目录如下

![在这里插入图片描述](https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/04dcc4a2883847c882c9d79b7eaa995c~tplv-k3u1fbpfcp-zoom-1.image)
>自此外部大框架初步搭建成功

![在这里插入图片描述](https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/e4c39ae69513457296057683cdbb331d~tplv-k3u1fbpfcp-zoom-1.image)
>完善chat-boot-module下pom.xml依赖，如lombok，web等必要依赖

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>chat-boot</artifactId>
        <groupId>net.javadog.chat</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <artifactId>chat-boot-module</artifactId>
    <packaging>pom</packaging>
    <modules>
        <module>chat-boot-common</module>
        <module>chat-boot-controller</module>
        <module>chat-boot-dao</module>
        <module>chat-boot-dto</module>
        <module>chat-boot-entity</module>
        <module>chat-boot-service</module>
    </modules>

    <properties>
        <maven.compiler.source>8</maven.compiler.source>
        <maven.compiler.target>8</maven.compiler.target>
    </properties>

    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>net.javadog.chat</groupId>
                <artifactId>chat-boot-dependencies</artifactId>
                <version>${project.parent.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>

    <dependencies>
        <!-- web -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <!--WxJava - 微信开发 Java SDK-->
        <dependency>
            <groupId>com.github.binarywang</groupId>
            <artifactId>weixin-java-miniapp</artifactId>
        </dependency>
        <!--lombok-->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
        </dependency>
        <!--hutool-->
        <dependency>
            <groupId>cn.hutool</groupId>
            <artifactId>hutool-all</artifactId>
        </dependency>
        <!--swagger2-->
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger2</artifactId>
        </dependency>
        <!--swagger-ui-->
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger-ui</artifactId>
        </dependency>
        <!--整合Knife4j-->
        <dependency>
            <groupId>com.github.xiaoymin</groupId>
            <artifactId>knife4j-spring-boot-starter</artifactId>
        </dependency>
        <!--整合Shiro安全框架-->
        <dependency>
            <groupId>org.apache.shiro</groupId>
            <artifactId>shiro-spring</artifactId>
        </dependency>
        <!--jwt-->
        <dependency>
            <groupId>com.auth0</groupId>
            <artifactId>java-jwt</artifactId>
        </dependency>
        <!--mybatis-plus-->
        <dependency>
            <groupId>com.baomidou</groupId>
            <artifactId>mybatis-plus-boot-starter</artifactId>
        </dependency>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
        </dependency>
    </dependencies>

</project>
```
**一定要重新拉取依赖！**
**一定要重新拉取依赖！**
**一定要重新拉取依赖！**

![在这里插入图片描述](https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/5ccc0ab6aee949c3aba540225597ee25~tplv-k3u1fbpfcp-zoom-1.image)


******
### 🍉5.创建chat-boot-module模块下对应功能分层
> 目前本狗分为如下6层

 - common-共通层
 - controller-控制器层
 - dao-数据持久层
 - dto-数据传输对象层
 - entity-实体层
 - service-业务逻辑层

**依次按照上述添加模块方式进行新增子模块，本狗如下示例一个，其余都如法炮制**

>右击项目chat-boot-module，new ->Moudle新建模块chat-boot-common

**一定看清楚父模块是否正确**
**一定看清楚父模块是否正确**
**一定看清楚父模块是否正确**

![在这里插入图片描述](https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/2d992f2fd8af4b539b00818fcbe4b1c2~tplv-k3u1fbpfcp-zoom-1.image)
>确认父级模块后，点击Finish，生成chat-boot-common模块

![在这里插入图片描述](https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/b324a5c8fa0745c1bae60fb0d8831aac~tplv-k3u1fbpfcp-zoom-1.image)
>依次按照上述方法，新建其他模块

**chat-boot-controller**模块

![在这里插入图片描述](https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/b67249001b534ec482a17de31b451d0f~tplv-k3u1fbpfcp-zoom-1.image)

**chat-boot-dao**模块
![在这里插入图片描述](https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/5e28ce0ab5c0436b9c738e0a1a24d9d8~tplv-k3u1fbpfcp-zoom-1.image)

**chat-boot-dto**模块
![在这里插入图片描述](https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/f91780eebb81423281f1aefce569011f~tplv-k3u1fbpfcp-zoom-1.image)

**chat-boot-entity**模块
![在这里插入图片描述](https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/d7f8d8bc358441049d5d344ccc844a09~tplv-k3u1fbpfcp-zoom-1.image)

**chat-boot-service**模块
![在这里插入图片描述](https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/d4ce9cf15a4a431b90b06fd44b34c60d~tplv-k3u1fbpfcp-zoom-1.image)
> 总体模块雏形基本完成

![在这里插入图片描述](https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/15f76a9669844f1ca0ef9baf9f363c23~tplv-k3u1fbpfcp-zoom-1.image)
### 🍧6.实际流程填充
- 模拟正常**前端请求**到**后台服务调用过程**，进行实际代码补充

>在chat-boot-entity下新建实体类User，在src/main/java下右键New=>Java Class，录入包名及类名

![在这里插入图片描述](https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/e1d49aab60d8492eba82eb060a7d5cf2~tplv-k3u1fbpfcp-zoom-1.image)
```java
package net.javadog.chat.entity;

import lombok.Data;

/**
 * @author: hdx
 * @Date: 2023-01-28 14:26
 * @version: 1.0
 **/
@Data
public class User {

    private Long id;

    private String username;

    private String idCard;
}

```
******
>在chat-boot-dto下新建目**request和response**，分别代表**请求传输对象和返回传输对象**，并分别在目录下创建UserRequest.java和UserResponse.java

![在这里插入图片描述](https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/4d8447978ab1492daccc028767c01be5~tplv-k3u1fbpfcp-zoom-1.image)
```java
package net.javadog.chat.request;

import lombok.Data;

/**
 * @author: hdx
 * @Date: 2023-01-28 14:59
 * @version: 1.0
 **/
@Data
public class UserRequest {

    private Long id;

    private String username;
}
```
```java
package net.javadog.chat.response;

import lombok.Data;

/**
 * @author: hdx
 * @Date: 2023-01-28 14:59
 * @version: 1.0
 **/
@Data
public class UserResponse {

    private Long id;

    private String username;
}
```
******
>在chat-boot-dao下修改chat-boot-dao模块下修改pom.xml文件依赖，引入chat-boot-entity;并增对应UserMapper.java
![在这里插入图片描述](https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/f897bef03c714f16adc3046214ca7451~tplv-k3u1fbpfcp-zoom-1.image)
```java
package net.javadog.chat.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import net.javadog.chat.entity.User;

/**
 * 用户mapper
 *
 * @author: hdx
 * @Date: 2023-01-10 11:43
 * @version: 1.0
 **/
public interface UserMapper extends BaseMapper<User> {
}

```
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>chat-boot-module</artifactId>
        <groupId>net.javadog.chat</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <artifactId>chat-boot-dao</artifactId>

    <properties>
        <maven.compiler.source>8</maven.compiler.source>
        <maven.compiler.target>8</maven.compiler.target>
    </properties>

    <dependencies>
        <dependency>
            <groupId>net.javadog.chat</groupId>
            <artifactId>chat-boot-entity</artifactId>
            <version>${project.parent.version}</version>
        </dependency>
    </dependencies>

</project>
```

******
>在chat-boot-service下新建目录service和impl，并在对应目录下新建UserService.java和UserServiceImpl.java，并修改chat-boot-service模块下修改pom.xml文件依赖，引入chat-boot-dto,chat-boot-dao

![在这里插入图片描述](https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/1bde9607b836418582077bd2bf9011fd~tplv-k3u1fbpfcp-zoom-1.image)
```java
package net.javadog.chat.service;

import com.baomidou.mybatisplus.extension.service.IService;
import net.javadog.chat.entity.User;

/**
 * 用户接口
 *
 * @author: hdx
 * @Date: 2023-01-10 11:53
 * @version: 1.0
 **/
public interface UserService extends IService<User> {

}

```

```java
package net.javadog.chat.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.javadog.chat.entity.User;
import net.javadog.chat.mapper.UserMapper;
import net.javadog.chat.service.UserService;
import org.springframework.stereotype.Service;

/**
 * 用户接口实现类
 *
 * @author: hdx
 * @Date: 2023-01-10 11:55
 * @version: 1.0
 **/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
```

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>chat-boot-module</artifactId>
        <groupId>net.javadog.chat</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <artifactId>chat-boot-service</artifactId>

    <properties>
        <maven.compiler.source>8</maven.compiler.source>
        <maven.compiler.target>8</maven.compiler.target>
    </properties>

    <dependencies>
        <dependency>
            <groupId>net.javadog.chat</groupId>
            <artifactId>chat-boot-dao</artifactId>
            <version>${project.parent.version}</version>
        </dependency>
        <dependency>
            <groupId>net.javadog.chat</groupId>
            <artifactId>chat-boot-dto</artifactId>
            <version>${project.parent.version}</version>
        </dependency>
    </dependencies>

</project>
```
******
>在chat-boot-controller创建UserController.java,并修改chat-boot-controller模块下修改pom.xml文件依赖，引入chat-boot-dto,chat-boot-service

![在这里插入图片描述](https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/8bbb1e8a706446ed81f82a399bf75102~tplv-k3u1fbpfcp-zoom-1.image)
```java
package net.javadog.chat.controller;

import cn.hutool.core.bean.BeanUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.javadog.chat.entity.User;
import net.javadog.chat.request.UserRequest;
import net.javadog.chat.response.UserResponse;
import net.javadog.chat.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 用户控制器
 *
 * @author: hdx
 * @Date: 2022-12-07 15:48
 * @version: 1.0
 **/
@Api(tags = "用户控制器")
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @ApiOperation(value = "用户详情", notes = "用户详情")
    @GetMapping
    public UserResponse detail(UserRequest userRequest){
        UserResponse userResponse = new UserResponse();
        User user = userService.getById(userRequest.getId());
        BeanUtil.copyProperties(user, userResponse);
        return userResponse;
    }

}

```
🎯重要补充
1.切记修改chat-boot-main下的pom.xml依赖，将chat-boot-controller模块加入
2.切记修改chat-boot-main下的pom.xml依赖，将chat-boot-dao模块加入
3.切记修改启动类ChatApplication中加入@MapperScan注解

![在这里插入图片描述](https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/252055b4f4284d6996577e3d576034c1~tplv-k3u1fbpfcp-zoom-1.image)

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>chat-boot</artifactId>
        <groupId>net.javadog.chat</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <artifactId>chat-boot-main</artifactId>

    <properties>
        <maven.compiler.source>8</maven.compiler.source>
        <maven.compiler.target>8</maven.compiler.target>
    </properties>

    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>net.javadog.chat</groupId>
                <artifactId>chat-boot-dependencies</artifactId>
                <version>1.0-SNAPSHOT</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>

    <dependencies>
        <!-- web -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <!--lombok-->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
        </dependency>
        <!--swagger2-->
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger2</artifactId>
        </dependency>
        <!--swagger-ui-->
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger-ui</artifactId>
        </dependency>
        <!-- swagger接口文档 -->
        <dependency>
            <groupId>com.github.xiaoymin</groupId>
            <artifactId>knife4j-spring-boot-starter</artifactId>
        </dependency>

        <!-- controller -->
        <dependency>
            <groupId>net.javadog.chat</groupId>
            <artifactId>chat-boot-controller</artifactId>
            <version>${project.parent.version}</version>
        </dependency>
        <!-- dao -->
        <dependency>
            <groupId>net.javadog.chat</groupId>
            <artifactId>chat-boot-dao</artifactId>
            <version>${project.parent.version}</version>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.1</version>
                <configuration>
                    <source>${java.version}</source>
                    <target>${java.version}</target>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-resources-plugin</artifactId>
                <version>2.6</version>
                <configuration>
                    <delimiters>
                        <delimiter>@</delimiter>
                    </delimiters>
                    <useDefaultDelimiters>false</useDefaultDelimiters>
                </configuration>
            </plugin>
        </plugins>
        <resources>
            <resource>
                <directory>src/main/webapp</directory>
                <filtering>false</filtering>
            </resource>
            <resource>
                <directory>src/main/resources</directory>
                <filtering>true</filtering>
            </resource>
            <resource>
                <directory>src/main/java</directory>
                <includes>
                    <include>**/*.xml</include>
                </includes>
            </resource>
        </resources>
    </build>

    <profiles>
        <profile>
            <id>local</id>
            <properties>
                <spring.active>local</spring.active>
            </properties>
            <activation>
                <activeByDefault>true</activeByDefault>
            </activation>
        </profile>
        <profile>
            <id>dev</id>
            <properties>
                <spring.active>dev</spring.active>
            </properties>
        </profile>
        <profile>
            <id>prod</id>
            <properties>
                <spring.active>prod</spring.active>
            </properties>
        </profile>
    </profiles>
</project>
```
![在这里插入图片描述](https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/c3f02a69343542d788c97565812b6c2b~tplv-k3u1fbpfcp-zoom-1.image)
```java
package net.javadog.chat;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author: hdx
 * @Date: 2023-01-28 11:24
 * @version: 1.0
 **/
@SpringBootApplication
@ServletComponentScan
@Slf4j
@EnableSwagger2
@EnableKnife4j
@MapperScan(basePackages = {"net.javadog.chat.mapper"})
public class ChatApplication {
    public static void main(String[] args) throws UnknownHostException {
        // 启动类
        ConfigurableApplicationContext application = SpringApplication.run(ChatApplication.class, args);
        // 打印基础信息
        info(application);
    }

    static void info(ConfigurableApplicationContext application) throws UnknownHostException {
        Environment env = application.getEnvironment();
        String ip = InetAddress.getLocalHost().getHostAddress();
        String port = env.getProperty("server.port");
        String active = env.getProperty("spring.profiles.active");
        String contextPath = env.getProperty("server.servlet.context-path");
        if (contextPath == null) {
            contextPath = "";
        }
        log.info("\n----------------------------------------------------------\n\t" +
                "欢迎访问  \thttps://blog.javadog.net\n\t" +
                "示例程序【" + active + "】环境已启动! 地址如下:\n\t" +
                "Local: \t\thttp://localhost:" + port + contextPath + "\n\t" +
                "External: \thttp://" + ip + ':' + port + contextPath + '\n' +
                "Swagger文档: \thttp://" + ip + ":" + port + contextPath + "/doc.html\n" +
                "----------------------------------------------------------");
    }
}
```

******

###  🦔7.示例DB更新
- 模拟正常**前端请求**到**后台服务调用过程**，进行实际代码补充

![在这里插入图片描述](https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/67401194bb5041efb0086726ce5a0323~tplv-k3u1fbpfcp-zoom-1.image)
```sql
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(20) NOT NULL COMMENT 'id',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `id_card` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'JavaDog', '123123');
```
### 🧩8.访问测试
>浏览器访问http://localhost:8001/chat/v1/user?id=1 

**测试成功如下图所示**

![在这里插入图片描述](https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/3bcff48919ff4eb589d89fef5049e6fa~tplv-k3u1fbpfcp-zoom-1.image)

## 总结
以上示例只是简单示范分层思路，其中代码逻辑实现方式有很多种，大家选取适用自己就好，希望自己的思路能对大家有帮助

如遇缺少依赖情况，**一定要重新拉取依赖！**
![在这里插入图片描述](https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/11da8bea00ea4eb393337be9260324dd~tplv-k3u1fbpfcp-zoom-1.image)
## 写在最后
此生两悔，悔遇见你，更悔未早遇见你，珍惜当下拥有，勿念昔日美好。

| JavaDog| 狗屋地址 |
| :----:| :----: | 
| 个人博客 | [https://blog.javadog.net](https://blog.javadog.net) | 
| 公众号 | [https://mp.weixin.qq.com/s/_vgnXoQ8FSobD3OfRAf5gw](https://mp.weixin.qq.com/s/_vgnXoQ8FSobD3OfRAf5gw) | 
| CSDN  | [https://blog.csdn.net/baidu_25986059](https://blog.csdn.net/baidu_25986059) | 
| 掘金 | [https://juejin.cn/user/2172290706716775](https://juejin.cn/user/2172290706716775)| 
| 知乎 | [https://www.zhihu.com/people/JavaDog](https://www.zhihu.com/people/JavaDog) | 
| 简书| [https://www.jianshu.com/u/1ff9c6bdb916](https://www.jianshu.com/u/1ff9c6bdb916) | 
| gitee|[https://gitee.com/javadog-net](https://gitee.com/javadog-net)  | 
| GitHub|[https://github.com/javadog-net](https://github.com/javadog-net)| 
