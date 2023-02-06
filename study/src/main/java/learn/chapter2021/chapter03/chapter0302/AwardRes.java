package learn.chapter2021.chapter03.chapter0302;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/3/2 11:32
 */
@Data
@AllArgsConstructor
public class AwardRes {
    /**
     * 编码
     */
    private String code;
    /**
     * 描述
     */
    private String info;
}
