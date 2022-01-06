package com.jinqiancao.order.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRuleManager;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.jinqiancao.stock.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jinqiancao
 * @date 2021/12/19 14:38
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    RestTemplate restTemplate;

    private static final String RESOURCE_NAME="flow";
    private static final String DEGRADE_NAME="degrade";

    @PostConstruct
    private static void initFlowRules(){
        List<FlowRule> ruleList=new ArrayList<>();
        FlowRule rule = new FlowRule();
        rule.setResource(RESOURCE_NAME);
        rule.setCount(1);
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);

        ruleList.add(rule);
        FlowRuleManager.loadRules(ruleList);
    }

    @PostConstruct
    private static void initDeRules(){
        List<DegradeRule> ruleList = new ArrayList<>();
        DegradeRule rule = new DegradeRule();
        rule.setResource(DEGRADE_NAME);
        //规则异常数
        rule.setGrade(RuleConstant.DEGRADE_GRADE_EXCEPTION_COUNT);
        //触发熔断降级异常数
        rule.setCount(2);
        //触发熔断最小请求数
        rule.setMinRequestAmount(2);
        //统计时长 单位ms
        rule.setStatIntervalMs(60*1000);

        //半开状态 10s
        rule.setTimeWindow(10);

        ruleList.add(rule);
        DegradeRuleManager.loadRules(ruleList);
    }

    @RequestMapping("/add")
    private String add(){
        int a =1/0;
        String msg = restTemplate.getForObject("http://localhost:8012/stock/reduce", String.class);
        return "hello world version"+msg;
    }

    @GetMapping("test_flow")
    // @SentinelResource(value = RESOURCE_NAME, blockHandler = "exceptionHandler" ,fallback = "fallback")
    public String flow(){
        // int a =1/0;
        return "成功访问";
    }

    @GetMapping("test_degrade")
    @SentinelResource(value = DEGRADE_NAME,blockHandler = "exceptionHandler",fallback = "fallback")
    public String degrade(){
        int a =1/0;
        return "成功访问";
    }


    public String fallback(Throwable ex) {
        ex.printStackTrace();
        return "异常访问";
    }

    public String exceptionHandler(BlockException e){
        e.printStackTrace();
        return "流控或熔断";
    }
}
