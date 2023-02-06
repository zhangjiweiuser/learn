package learn;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/5/27 11:00
 */
@Data
@AllArgsConstructor
public class MobileLoginParam {
    private String mobile;
    private String code;
}
