package learn.vavr.tuple;

import io.vavr.Tuple;
import io.vavr.Tuple2;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-01-13 16:19
 */
public class TupleTest {
    public static void main(String[] args) {
        Tuple2<String,Integer> java = Tuple.of("java",8);
        System.out.println(java._1);
        System.out.println(java._2);
    }
}
