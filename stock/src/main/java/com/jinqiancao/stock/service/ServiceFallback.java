package com.jinqiancao.stock.service;

import org.springframework.stereotype.Component;

/**
 * @author jinqiancao
 * @date 2022/1/5 15:34
 */
@Component
public class ServiceFallback implements StockService{
    @Override
    public String add() {
        return "降级处理";
    }
}
