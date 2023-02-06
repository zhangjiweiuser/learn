package learn.chapter2021.chapter06.chapter0610;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/6/11 9:49
 */
public class StudentTest {
    public static void main(String[] args) {
        Student student = new Student();
        student.setId(1000);
        student.setName("aa");
        System.out.println(student.hashCode());
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 5, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1000));
        for (int i = 0; i < 3; i++) {
            threadPoolExecutor.submit(new StudentRun(student));
        }
    }
}

class StudentRun implements Runnable {

    private Student student;

    public StudentRun(Student student) {
        this.student = student;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getId() + "^^^" + student.hashCode());
    }
}
