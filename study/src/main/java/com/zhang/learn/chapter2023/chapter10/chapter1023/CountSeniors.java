package com.zhang.learn.chapter2023.chapter10.chapter1023;

public class CountSeniors {
    public static void main(String[] args) {
        String[] details = {"7868190130M7522","5303914400F9211","9273338290F4010"};
        System.out.println(countSeniors(details));
    }

    public static int countSeniors(String[] details) {
        int ans = 0;
        for(String s : details){
            char t11 = s.charAt(11);
            if(t11 > '6'){
                ans +=1;
            }else if(t11 == '6'){
                char t12 = s.charAt(12);
                if(t12 > '0'){
                    ans+=1;
                }
            }
        }
        return ans;
    }
}
