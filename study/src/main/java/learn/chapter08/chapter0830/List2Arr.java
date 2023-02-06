package learn.chapter08.chapter0830;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/8/30 10:02
 */
public class List2Arr {
    public static void main(String[] args) {
        int[] data = {1,2,3,4,5,6};
        List<Integer> list1 = Arrays.stream(data).boxed().collect(Collectors.toList());

        Integer[] integers1 = Arrays.stream(data).boxed().toArray(Integer[]::new);

        Integer[] integers2 = list1.toArray(new Integer[0]);

        int[] arr1 = list1.stream().mapToInt(Integer::valueOf).toArray();

        int[] arr2 = Arrays.stream(integers1).mapToInt(Integer::valueOf).toArray();


        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        int[] ints = list.stream().mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(ints));
    }
}
