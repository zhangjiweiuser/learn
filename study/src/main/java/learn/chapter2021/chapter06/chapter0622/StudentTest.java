package learn.chapter2021.chapter06.chapter0622;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/6/22 14:18
 */
public class StudentTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        List<Student> studentList = Lists.newArrayList(new Student(1,"张三"),new Student(2,"李四"));
//        String names = studentList.stream().map(Student::getName).collect(Collectors.joining(","));
//        System.out.println(names);
//
//        List<StudentVo> studentVoList = studentList.stream().map(s->new StudentVo(s.getName())).collect(Collectors.toList());
//        System.out.println(studentVoList);
        StudentTest test = new StudentTest();
        test.futureTest();
    }

    public void futureTest() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("future1 finished!");
            return "future1 finished!";
        });
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("future2 finished!");
            return "future2 finished!";
        });
        CompletableFuture<Void> combindFuture = CompletableFuture.allOf(future1, future2);
//        try {
//            combindFuture.get();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
        System.out.println("aaaaaaaaaaaaa"+future1.get());
        System.out.println("future1: " + future1.isDone() + " future2: " + future2.isDone());
    }
}
