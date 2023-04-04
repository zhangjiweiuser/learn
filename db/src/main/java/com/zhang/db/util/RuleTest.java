package com.zhang.db.util;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-04-03 10:35
 */
public class RuleTest {
    public static void main(String[] args) {
        initFlowRules();
        Map<String,Integer> map = new HashMap<>();
        Map<String,Integer> map2 = new HashMap<>();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        long start = System.currentTimeMillis();
        while(true){
            long n = System.currentTimeMillis();
            if(n - start > 5000){
                break;
            }
            try(Entry entry = SphU.entry("HelloWorld")){
                System.out.println("hello world");
                String now = LocalDateTime.now().format(dateTimeFormatter);
                Integer orDefault = map.getOrDefault(now, 0);
                map.put(now,orDefault+1);
            }catch (BlockException e){
                System.out.println("blocked");
                String now = LocalDateTime.now().format(dateTimeFormatter);
                Integer orDefault = map2.getOrDefault(now, 0);
                map2.put(now,orDefault+1);
            }
        }
        System.out.println(map.toString());
        System.out.println(map2.toString());
    }
    private static void initFlowRules(){
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule();
        rule.setResource("HelloWorld");
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule.setCount(20);
        rules.add(rule);
        FlowRuleManager.loadRules(rules);
    }
}
