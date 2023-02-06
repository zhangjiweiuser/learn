package com.zhang.learn;

import com.alibaba.fastjson2.JSONObject;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/9/10 16:23
 */
public class QuestionForClueTest {

    @Test
    void questionForClueTest() {
        List<QuestionForClue> questionForClues = Lists.newArrayList(new QuestionForClue(1, "您对外观", "外观"),
                new QuestionForClue(1, "您对内饰", "内饰"),
                new QuestionForClue(1, "您对AA", "AA"),
                new QuestionForClue(0, "您对BB", "BB"),
                new QuestionForClue(0, "竞品信息", "CC"));
        String careListStr = "";
        if (CollectionUtils.isNotEmpty(questionForClues)) {
            careListStr = questionForClues.stream().filter(q -> q.getType() == 0).map(QuestionForClue::getQuestionName).collect(Collectors.joining("、"));
            QuestionForClue other = questionForClues.stream().filter(q -> q.getType() == 5).findFirst().orElse(null);
            if (null != other) {
                careListStr += (StringUtils.isNotBlank(careListStr) ? "、" : "") + "其他(" + other.getQuestionContent() + ")";
            }
        }
        JSONObject careList = new JSONObject();
        careList.put("careList", careListStr);
        System.out.println(careList.toJSONString());
    }
}
