package com.jinqiancao.stock.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jinqiancao
 * @date 2021/12/19 14:46
 */
@RestController
@RequestMapping("/stock")
public class StockController {

    @RequestMapping("/reduce")
    public String reduce() {
        System.out.println("减库存");
        return "减库存";
    }
}
