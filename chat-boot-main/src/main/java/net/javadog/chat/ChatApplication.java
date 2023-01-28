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
