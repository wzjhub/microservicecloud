package com.wzj.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

//If you have database settings to be loaded from a particular profile you may need to active it
// (no profiles are currently active)
// 排除数据库的自动启动
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableZuulProxy
public class Zuul_9527_StartSpringCloudApp {

    public static void main(String[] args) {
        SpringApplication.run(Zuul_9527_StartSpringCloudApp.class,args);
    }
}
