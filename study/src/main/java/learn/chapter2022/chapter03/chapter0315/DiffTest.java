package learn.chapter2022.chapter03.chapter0315;

import org.apache.commons.collections.CollectionUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhangjiwei1
 * @description
 * @create 2022-03-15 17:33
 */
public class DiffTest {
    public static void main(String[] args) {
        String s1 = "3,4,5,11,12,14,18,24,26,27,32,34,35,39,40,47,69,81,122,181,181,227,409,542,755,789,819,936,1219,1428,1550,1574,1646,1667,1745,1758,1936,1968,1975,1985";
        String s2 = "11,18,14,4,5,27,26,39,47,35,40,32,181,409,789,755,81,34,819,122,1219,936,542,1968,227,1646,1975,1936,1758,1428,1985";

        List<Integer> l1 =Arrays.stream(s1.split(",")).mapToInt(Integer::valueOf).boxed().collect(Collectors.toList());
        List<Integer> l2 =Arrays.stream(s2.split(",")).mapToInt(Integer::valueOf).boxed().collect(Collectors.toList());
        System.out.println(CollectionUtils.subtract(l1,l2));
        System.out.println(CollectionUtils.subtract(l2,l1));
    }
}
