package com.zhang.learn.chapter2023.chapter10.chapter1011;

import java.util.*;

public class TopStudents {
    public static void main(String[] args) {
        String[] positive_feedback = {"smart", "brilliant", "studious"};
        String[] negative_feedback = {"not"};
        String[] report = {"this student is studious", "the student is smart"};
        int[] student_id = {1, 2};
        int k = 2;
        List<Integer> list = topStudents(positive_feedback, negative_feedback, report, student_id, k);
        System.out.println(list);
    }

    public static List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        Map<String, Integer> positive = new HashMap<>();
        for (String s : positive_feedback) {
            positive.put(s, 3);
        }
        Map<String, Integer> negative = new HashMap<>();
        for (String s : negative_feedback) {
            negative.put(s, -1);
        }
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < report.length; i++) {
            String[] split = report[i].split("\\s");
            int sum = 0;
            for (String str : split) {
                sum += positive.getOrDefault(str, 0);
                sum += negative.getOrDefault(str, 0);
            }
            int[] param = new int[2];
            param[0] = sum;
            param[1] = student_id[i];
            list.add(param);
        }
        Collections.sort(list, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o2[0] - o1[0];
            }
        });
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ans.add(list.get(i)[1]);
        }
        return ans;
    }
}
