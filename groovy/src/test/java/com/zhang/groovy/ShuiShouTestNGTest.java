package com.zhang.groovy;

import com.zhang.groovy.util.ShuiShouUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/8/17 15:18
 */
public class ShuiShouTestNGTest {

    private ShuiShouUtil util;

    @BeforeMethod
    public void setUp() {
        util = new ShuiShouUtil();
    }

    @Test(dataProvider = "calData")
    public void calTest(double income, double result) {
        Assert.assertEquals(util.calc(income), result, "输入：" + income + ",输出：" + result);
    }


    @DataProvider(name = "calData")
    public Object[][] calData() {
        return new Object[][]{{-1, 0},
                {0, 0},
                {2999, 89.97},
                {3000, 90.0},
                {3001, 90.1},
                {11999, 989.9},
                {12000, 990.0},
                {12001, 990.2},
                {24999, 3589.8},
                {25000, 3590.0},
                {25001, 3590.25},
                {34999, 6089.75},
                {35000, 6090.0},
                {35001, 6090.3},
                {54999, 12089.7},
                {55000, 12090},
                {55001, 12090.35},
                {79999, 20839.65},
                {80000, 20840.0},
                {80001, 20840.45}};

    }
}