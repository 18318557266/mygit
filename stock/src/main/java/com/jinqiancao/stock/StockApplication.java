package com.jinqiancao.stock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author jinqiancao
 * @date 2021/12/19 14:48
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.jinqiancao.**.service"})
public class StockApplication {

    public static void main(String[] args) {
        SpringApplication.run(StockApplication.class,args);
    }
}
