package com.zhang.learn.chapter2021.chapter05.chapter0525;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.*;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/5/25 10:27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Serializable {

    private int age;
    private String name;
    private Book book;


    public Object deepClone() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(outputStream);
        oos.writeObject(this);

        ByteArrayInputStream bis = new ByteArrayInputStream(outputStream.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return ois.readObject();
    }
}
