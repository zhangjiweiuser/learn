package learn.chapter2021.chapter12.chapter1224;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/12/24 17:15
 */
@Data
@AllArgsConstructor
public class Employee implements Comparable<Employee> {
    private int id;
    private String name;
    private LocalDate date;

    @Override
    public int compareTo(Employee o) {
        return this.getId() - o.getId();
    }
}
