package com.zhang.learn.chapter2023.chapter03.chapter0305;

public class MyString {
    final int maxSize = 100;
    char[] data;
    int size;

    public MyString() {
        data = new char[maxSize];
        size = 0;
    }

    public MyString subStr(int i, int j) {
        if (i < 0 || i >= size || i - j + 1 < 0 || i - j + 1 >= size) {
            throw new IndexOutOfBoundsException();
        }
        MyString t = new MyString();
        t.size = j;
        for (int k = 0; k < j; k++) {
            t.data[k] = data[i + k];
        }
        return t;
    }

    public int strCompare(MyString s, MyString t) {
        int sL = s.size;
        int tL = t.size;
        int min = Math.min(sL, tL);
        for (int i = 0; i < min; i++) {
            if (s.data[i] < t.data[i]) {
                return -1;
            } else if (s.data[i] == t.data[i]) {

            } else {
                return 1;
            }
        }
        if (sL == min && tL == min) {
            return 0;
        }
        if (sL > min) {
            return 1;
        }
        return -1;
    }
}
