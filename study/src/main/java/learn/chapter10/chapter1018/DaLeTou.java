package learn.chapter10.chapter1018;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/10/18 11:05
 */
public class DaLeTou {
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.println(generate());
        }
    }

    private static List<Integer> generate() {
        Set<Integer> hong = new TreeSet<>();
        Set<Integer> lan = new TreeSet<>();

        while (hong.size() < 5) {
            hong.add(ThreadLocalRandom.current().nextInt(1, 36));
        }
        while (lan.size() < 2) {
            lan.add(ThreadLocalRandom.current().nextInt(1, 13));
        }
        List<Integer> result = new ArrayList<>();
        result.addAll(hong);
        result.addAll(lan);
        return result;
    }
}
