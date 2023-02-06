package learn.chapter2021.chapter02.chapter0209;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/2/9 17:41
 */
public class SubListUtil {
    public static void main(String[] args) {
        subList2();
    }

    private static void subList2() {
        List<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int everySize = 3;
//        int cycleNo = list.size() % everySize == 0 ? list.size() / everySize : list.size() / everySize + 1;
//        for (int i = 0; i < cycleNo; i++) {
//            if (i != cycleNo - 1) {
//
//                List<Integer> sub = list.subList(i * everySize, (i + 1) * everySize);
//                System.out.println("第" + i + "次循环" + sub);
//            } else {
//                List<Integer> sub = list.subList(i * everySize, list.size());
//                System.out.println("第" + i + "次循环" + sub);
//            }
//        }
        List<List<Integer>> lists = Lists.partition(list,3);
        for(List<Integer> li : lists){
            System.out.println(li);
        }
        // 终于可以了
    }
}
