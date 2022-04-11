package com.jinqiancao.stock.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author jinqiancao
 * @date 2021/12/27 9:59
 */
@Component
@FeignClient(name = "service-order",path = "/order",fallback = ServiceFallback.class)
public interface StockService {

    @RequestMapping("/add")
    String add();
}
