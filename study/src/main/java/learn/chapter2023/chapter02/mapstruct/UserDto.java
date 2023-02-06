package learn.chapter2023.chapter02.mapstruct;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-02 14:21
 */
@Data
public class UserDto implements Serializable {
    private Integer id;
    private String name;
    private String address;
    private Date birth;
}
