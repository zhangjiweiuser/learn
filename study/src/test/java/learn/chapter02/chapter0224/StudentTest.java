package learn.chapter02.chapter0224;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/2/24 10:42
 */
public class StudentTest {


    @Test
    void groupTest() {
        List<Student> studentList = Arrays.asList(new Student("zhangsan", 30),
                new Student("zhangsan2", 10),
                new Student("zhangsan3", 40),
                new Student("zhangsan4", 20),
                new Student("zhangsan5", 50));
        Map<String, List<Student>> map = studentList.stream().collect(Collectors.groupingBy(s -> s.getAge() < 30 ? "青年组" : "中年组"));
        System.out.println(map);
    }
}
