package com.zhang.db.repayplan;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service("userDebxQiGong")
public class UserDebxQiGongRepayPlanService implements UserRepayPlanService{
    @Override
    public String firstPeriod(int payMethod) {
            // 判断是24还是36
            boolean is36 = true;
            if(is36){
               firstPeriod36();
            }else{
                //
                firstPeriod24();
            }
        return "用户等额本息期供轧差";
    }
    void firstPeriod24(){
        System.out.println("我是等额本息期供24");
        boolean guize1 = true;
        boolean guize2 = true;
        if(guize1){
            // 24%的算法
//            BigDecimal lixi = 本金 * 成单利率 / 365 * 占用天数;
//            BigDecimal benjin = -ppmt(月利率,1,12,本金);
//            担保费 = lixi + benjin - 对资月供;
        }else if(guize2){
            // 按期计息
            throw new RuntimeException("暂不支持");
        }else{
            // 规则3
            boolean isZhengQi = true;
            if(isZhengQi){

            }else{
                // 非整齐
            }
        }

    }
    void firstPeriod36(){
        System.out.println("我是等额本息期供36");
        boolean guize1 = true;
        boolean guize2 = true;
        if(guize1){
            // 36%的算法
//            BigDecimal user_104_36 = 本金 * 24% / 365 * 占用天数;
//            BigDecimal benjin = -ppmt(24%/12,1,12,本金);
//            担保费 = lixi + benjin - 对资月供;
//
//            BigDecimal lixi2 = 本金 * 24% / 365 * 占用天数;
//            BigDecimal lixi3 = 本金 * 成单利率% / 365 * 占用天数;
//            BigDecimal benjin2 = -ppmt(24%/12,1,12,本金);
//            BigDecimal benjin3 = -ppmt(成单利率%/12,1,12,本金);
//            融担费 = lixi3 + benjin3 - lixi2 - benjin2;
        }else if(guize2){
            // 按期计息
            throw new RuntimeException("暂不支持");
        }else{
            // 规则3
            boolean isZhengQi = true;
            if(isZhengQi){

            }else{
                // 非整齐
            }
        }

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
