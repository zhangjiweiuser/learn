package com.zhang.learn.chapter2023.chapter09.chapter0919;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-09-19 16:33
 */
public class IPUtil {
    public static void main(String[] args) {
//        System.out.println(solve("1a1.4.5.6"));
//        System.out.println(solve("2001:0db8:85a3::8A2E:0370:7334"));
//        System.out.println(solve("2001:db8:85a3:0:0:8A2E:0370:7334"));
//        System.out.println(solve("2001:0db8:85a3:0000:0000:8a2e:0370:7334"));
//        System.out.println(solve("02001:0db8:85a3:0000:0000:8a2e:0370:7334"));
//        System.out.println(solve("20EE:FGb8:85a3:0:0:8A2E:0370:7334"));
        System.out.println(solve("2001:0db8:85a3:0:0:8A2E:0370:7334:::"));
    }

    public static String solve(String IP) {
        IP = IP.toLowerCase();
        // ipv4
        if (IP.indexOf(".") > 0) {
            String[] split = IP.split("\\.");
            for (String s : split) {
                if (s.charAt(0) == '0') {
                    return "Neither";
                }
                try {
                    int value = Integer.parseInt(s);

                    if (value > 255) {
                        return "Neither";
                    }
                } catch (Exception e) {
                    return "Neither";
                }
            }
            return "IPv4";
        } else {
            // ipv6 进行判断
            String[] split = IP.split(":",-1);
            for (int i = 0; i < split.length; i++) {
                if ("".equals(split[i])) {
                    return "Neither";
                }
                if (i == 0) {
                    String s = split[i];
                    if (s.charAt(0) == '0') {
                        for (int j = 1; j < s.length(); j++) {
                            if (s.charAt(j) != '0') {
                                return "Neither";
                            }
                        }
                    }
                }
                String s = split[i];
                for(int j=0;j<s.length();j++){
                    if(s.charAt(j) <'0' || s.charAt(j) > 'f'){
                        return "Neither";
                    }
                }
            }
            return "IPv6";
        }
    }
}
