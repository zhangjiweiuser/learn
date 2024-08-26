package com.zhang.db.repayplan;

public interface UserRepayPlanService {
    default String generate(int a,int b){
        return "";
    }
    String firstPeriod(int payMethod);
    String middlePeriod(int payMethod);
    String lastPeriod(int payMethod);

}
