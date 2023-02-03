package com.zhang.learn.chapter2021.chapter02.chapter0204;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/2/4 17:21
 */
public class KuaiLe {
    private static List<Integer> allNos = new ArrayList<>();

    static {
        for (int i = 1; i <= 80; i++) {
            allNos.add(i);
        }
    }

    private static List<Integer>  getNos() {
        Set<Integer> nos = new HashSet<>();
        while (nos.size() < 4) {
            nos.add(allNos.get(ThreadLocalRandom.current().nextInt(80)));
        }
        List<Integer> sorts = new ArrayList<>(nos);
        sorts.sort(Comparator.comparingInt(o -> o));
        return sorts;
    }

    public static void main(String[] args) {
        Set<Integer> nos = new HashSet<>();
        for(int i = 0;i<20;i++){
            System.out.print(i+"  ");
            List<Integer> ins = getNos();
            nos.addAll(ins);
            System.out.println(ins);
        }
        List<Integer> sorts = new ArrayList<>(nos);
        sorts.sort(Comparator.comparingInt(o -> o));
        System.out.println(sorts.size() + "  "+sorts);

    }


}
