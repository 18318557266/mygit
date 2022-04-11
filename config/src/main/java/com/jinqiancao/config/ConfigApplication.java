package com.jinqiancao.config;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author jinqiancao
 * @date 2021/12/20 11:16
 */
@SpringBootApplication
public class ConfigApplication {

    public static void main(String[] args) throws NacosException {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(ConfigApplication.class, args);
        String name = applicationContext.getEnvironment().getProperty("user.name");
        String age = applicationContext.getEnvironment().getProperty("user.age");
        System.out.println(name+age);
        ConfigService server = NacosFactory.createConfigService("localhost");
        String config = server.getConfig("nacos-config", "DEFAULT_GROUP", 5000);
        System.out.println(config);
    }
}
