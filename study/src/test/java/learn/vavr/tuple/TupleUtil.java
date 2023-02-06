package learn.vavr.tuple;

import io.vavr.Tuple;
import io.vavr.Tuple2;
import org.junit.jupiter.api.Test;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-01-13 16:29
 */
public class TupleUtil {
    @Test
    void tuple(){
        Tuple2<String,Integer> java = Tuple.of("java",8);
        System.out.println(java._1);
        System.out.println(java._2);
    }

    @Test
    void tuple2(){
        Tuple2<String,Integer> java = Tuple.of("java",8);
        Tuple2<String, Integer> map = java.map(s -> s.substring(2) + "vr", i -> i / 8);
        System.out.println(map);
    }
}
