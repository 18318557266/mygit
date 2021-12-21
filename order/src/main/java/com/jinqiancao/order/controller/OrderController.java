package com.jinqiancao.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author jinqiancao
 * @date 2021/12/19 14:38
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/add")
    private String add(){
        String msg = restTemplate.getForObject("http://localhost:8012/stock/reduce", String.class);
        return "hello world"+msg;
    }
}
