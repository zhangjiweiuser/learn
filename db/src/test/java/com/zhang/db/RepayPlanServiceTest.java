package com.zhang.db;

import com.zhang.db.repayplan.UserRepayPlanService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RepayPlanServiceTest {
    @Resource
    private Map<String,UserRepayPlanService> userRepayPlanService;
    @Test
    public void repayPlanTest(){
        UserRepayPlanService userDebx = userRepayPlanService.get("userDebxLiLv");
        String s = userDebx.firstPeriod(1);
        System.out.println(s);
    }
}
