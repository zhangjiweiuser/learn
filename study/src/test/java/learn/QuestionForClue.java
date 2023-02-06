package learn;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/9/10 16:10
 */
@Data
@AllArgsConstructor
public class QuestionForClue {
    private Integer type;
    private String questionContent;
    private String questionName;
}
