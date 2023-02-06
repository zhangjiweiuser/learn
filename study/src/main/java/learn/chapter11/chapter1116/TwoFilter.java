package learn.chapter11.chapter1116;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2020/11/19 18:09
 */
public class TwoFilter extends AbstractFilter {
    @Override
    public List<Integer> filter(List<Integer> list) {
        System.out.println("TwoFilter");
        return list.stream().filter(n -> n % 2 != 0).collect(Collectors.toList());
    }
}
