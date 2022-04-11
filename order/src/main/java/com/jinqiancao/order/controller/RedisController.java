package com.jinqiancao.order.controller;

import com.jinqiancao.order.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jinqiancao
 * @date 2022/1/15 15:36
 */
@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate redisTemplate;

    @GetMapping
    public void ops(){
        User user = new User("zs", "25");
        redisTemplate.opsForValue().set("user",user);
        System.out.println(redisTemplate.opsForValue().get("user"));
    }


}
