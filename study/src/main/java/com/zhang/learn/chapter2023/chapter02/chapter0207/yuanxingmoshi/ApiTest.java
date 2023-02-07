package com.zhang.learn.chapter2023.chapter02.chapter0207.yuanxingmoshi;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-07 9:55
 */
public class ApiTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        QuestionBankController questionBankController = new QuestionBankController();
        System.out.println(questionBankController.createPaper2("花花", "1000001921032"));
        System.out.println(questionBankController.createPaper2("豆豆", "1000001921051"));
        System.out.println(questionBankController.createPaper2("大宝", "1000001921987"));
    }
}
