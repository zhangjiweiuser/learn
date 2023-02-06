package learn.shiro;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2020/8/20 14:18
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysUser implements Serializable {

    private String username;
    private String password;
    private int status;
}
