package order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author jinqiancao
 * @date 2021/12/19 14:40
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderApplication2 {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication2.class,args);
    }

    @Bean
    public RestTemplate getRestTemplate(RestTemplateBuilder builder){
        RestTemplate template = builder.build();
        return template;
    }
}
