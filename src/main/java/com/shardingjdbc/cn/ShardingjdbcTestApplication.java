package com.shardingjdbc.cn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 要排除DataSourceAutoConfiguration，否则多数据源无法配置,配置的多个数据源交给sharding-jdbc管理，sharding-jdbc创建一个DataSource数据源提供给mybatis使用
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@MapperScan("com.shardingjdbc.cn.mapper")
public class ShardingjdbcTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardingjdbcTestApplication.class, args);
    }

}
