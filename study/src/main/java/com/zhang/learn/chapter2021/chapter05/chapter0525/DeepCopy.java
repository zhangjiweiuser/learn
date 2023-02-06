package com.zhang.learn.chapter2021.chapter05.chapter0525;




import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/5/25 10:27
 */
public class DeepCopy {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        Book book = new Book(10, "计算机");
        Student student1 = new Student(1, "aa", book);
        Student student2 = (Student) student1.deepClone();
        System.out.println(student1.toString());
        System.out.println(student2.toString());
        Book newBook = student2.getBook();
        newBook.setName("漫画");
        student2.setBook(newBook);
        System.out.println("------------");
        System.out.println(student1.toString());
        System.out.println(student2.toString());
        System.out.println("------------");
        Student student3 = new Student();
//        Student student3 = (Student) BeanUtils.cloneBean(student1);
        Book book3 = student3.getBook();
        book3.setName("java");
        student3.setBook(book3);
        System.out.println(student1);
        System.out.println(student3);
    }
}
