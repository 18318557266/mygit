package com.jinqiancao.order;

import com.alibaba.csp.sentinel.annotation.aspectj.SentinelResourceAspect;
import com.jinqiancao.LuoBo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author jinqiancao
 * @date 2021/12/19 14:40
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.jinqiancao.order.mapper")
public class OrderApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(OrderApplication.class, args);
        System.out.println("run.getBean(LuoBo.class) = " + run.getBean(LuoBo.class));
    }

    @Bean
    public RestTemplate getRestTemplate(RestTemplateBuilder builder){
        RestTemplate template = builder.build();
        return template;
    }

    @Bean
    public SentinelResourceAspect  sentinelResourceAspect(){
        return new SentinelResourceAspect();
    }
}
