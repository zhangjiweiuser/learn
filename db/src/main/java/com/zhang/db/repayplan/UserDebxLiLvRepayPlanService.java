package com.zhang.db.repayplan;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service("userDebxLiLv")
public class UserDebxLiLvRepayPlanService implements UserRepayPlanService{
    @Override
    public String firstPeriod(int payMethod) {
        throw new RuntimeException("暂不支持");
    }

    @Override
    public String middlePeriod(int payMethod) {
        return null;
    }

    @Override
    public String lastPeriod(int payMethod) {
        return null;
    }
}
