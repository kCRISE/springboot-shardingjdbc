package com.shardingjdbc.cn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.shardingjdbc.cn.mapper")
public class ShardingjdbcTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardingjdbcTestApplication.class, args);
    }

}
