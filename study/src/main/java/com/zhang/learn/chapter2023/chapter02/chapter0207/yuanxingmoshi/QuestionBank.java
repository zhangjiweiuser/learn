package com.zhang.learn.chapter2023.chapter02.chapter0207.yuanxingmoshi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-07 11:10
 */
public class QuestionBank implements Cloneable {
    private String candidate;

    private String number;

    private ArrayList<ChoiceQuestion> choiceQuestions = new ArrayList<>();

    private ArrayList<AnswerQuestion> answerQuestions = new ArrayList<>();

    public QuestionBank append(ChoiceQuestion choiceQuestion) {
        choiceQuestions.add(choiceQuestion);
        return this;
    }

    public QuestionBank append(AnswerQuestion answerQuestion) {
        answerQuestions.add(answerQuestion);
        return this;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        QuestionBank questionBank = (QuestionBank) super.clone();
        questionBank.choiceQuestions = (ArrayList<ChoiceQuestion>) choiceQuestions.clone();
        questionBank.answerQuestions = (ArrayList<AnswerQuestion>) answerQuestions.clone();
        Collections.shuffle(questionBank.choiceQuestions);
        Collections.shuffle(questionBank.answerQuestions);
        ArrayList<ChoiceQuestion> choiceQuestionList = questionBank.choiceQuestions;
        for (ChoiceQuestion question : choiceQuestionList) {
            Topic random = TopicRandomUtil.random(question.getOption(), question.getKey());
            question.setOption(random.getOption());
            question.setKey(random.getKey());
        }
        return questionBank;
    }

    public void setCandidate(String candidate) {
        this.candidate = candidate;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {

        StringBuilder detail = new StringBuilder("考生：" + candidate + "\r\n" +
                "考号：" + number + "\r\n" +
                "--------------------------------------------\r\n" +
                "一、选择题" + "\r\n\n");

        for (int idx = 0; idx < choiceQuestions.size(); idx++) {
            detail.append("第").append(idx + 1).append("题：").append(choiceQuestions.get(idx).getName()).append("\r\n");
            Map<String, String> option = choiceQuestions.get(idx).getOption();
            for (String key : option.keySet()) {
                detail.append(key).append("：").append(option.get(key)).append("\r\n");
                ;
            }
            detail.append("答案：").append(choiceQuestions.get(idx).getKey()).append("\r\n\n");
        }

        detail.append("二、问答题" + "\r\n\n");

        for (int idx = 0; idx < answerQuestions.size(); idx++) {
            detail.append("第").append(idx + 1).append("题：").append(answerQuestions.get(idx).getName()).append("\r\n");
            detail.append("答案：").append(answerQuestions.get(idx).getKey()).append("\r\n\n");
        }

        return detail.toString();
    }
}
