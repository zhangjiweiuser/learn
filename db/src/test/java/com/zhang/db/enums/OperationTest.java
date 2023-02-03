package com.zhang.db.enums;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/9/27 10:46
 */
public class OperationTest {
    public static void main(String[] args) {
        double x = 2d;
        double y = 4d;

        for (Operation operation : Operation.values()) {
            System.out.printf("%f  %s  %f = %f%n", x, operation.getSymbol(), y, operation.apply(x, y));
        }


    }
}
