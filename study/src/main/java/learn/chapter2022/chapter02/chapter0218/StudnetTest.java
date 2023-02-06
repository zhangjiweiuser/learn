package learn.chapter2022.chapter02.chapter0218;


import com.alibaba.fastjson2.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangjiwei1
 * @description
 * @create 2022-02-18 13:59
 */
public class StudnetTest {
    public static void main(String[] args) {
        List<Score> scoreList = new ArrayList<>();
        scoreList.add(new Score(100L, 100L));
        scoreList.add(new Score(200L, 100L));
        Student student = new Student();
        student.setScoreList(scoreList);
        student.getScoreList().forEach(s->s.setS1(s.getS1() + s.getS2()));
        System.out.println(JSONObject.toJSONString(student));
    }
}
