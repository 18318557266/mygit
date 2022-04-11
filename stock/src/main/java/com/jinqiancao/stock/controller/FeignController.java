package com.jinqiancao.stock.controller;

import com.jinqiancao.stock.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jinqiancao
 * @date 2021/12/27 11:18
 */
@RestController
@RequestMapping("/feign")
public class FeignController {

    @Autowired
    StockService service;

    @RequestMapping("/add")
    private String add(){
        // int a =1/0;
        // String msg = restTemplate.getForObject("http://localhost:8012/stock/reduce", String.class);
        String msg = service.add();
        return "hello world version"+msg;
    }
}
