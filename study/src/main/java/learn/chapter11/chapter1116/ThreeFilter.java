package learn.chapter11.chapter1116;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2020/11/19 18:10
 */
public class ThreeFilter extends AbstractFilter {
    @Override
    public List<Integer> filter(List<Integer> list) {
        System.out.println("ThreeFilter");
        return list.stream().filter(n -> n % 3 != 0).collect(Collectors.toList());
    }
}
