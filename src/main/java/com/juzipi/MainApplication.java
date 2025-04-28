package com.juzipi;


import cn.dev33.satoken.SaManager;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author juzipi
 */
@SpringBootApplication
@MapperScan("com.juzipi.mapper")
@ServletComponentScan
public class MainApplication {
    
    public static void main(String[] args) throws JsonProcessingException {
        SpringApplication.run(MainApplication.class, args);
        System.out.println("启动成功，Sa-Token 配置如下：" + SaManager.getConfig());
    }
}
