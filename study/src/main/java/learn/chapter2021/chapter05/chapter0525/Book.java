package learn.chapter2021.chapter05.chapter0525;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/5/25 10:54
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book implements Serializable {

    private int price;
    private String name;


}
