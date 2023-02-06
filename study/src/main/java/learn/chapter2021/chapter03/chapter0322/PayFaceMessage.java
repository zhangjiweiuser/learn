package learn.chapter2021.chapter03.chapter0322;

import lombok.Data;
import lombok.ToString;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/3/22 17:57
 */
@ToString
@Data
public class PayFaceMessage extends PayBaseMessage {
    private String tradeId;

}
