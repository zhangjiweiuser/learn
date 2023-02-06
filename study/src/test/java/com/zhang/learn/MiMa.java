package com.zhang.learn;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2020/10/20 10:53
 */
public class MiMa {
    public static void main(String[] args) {
        String input = "%06970911010009583413801049907 63332881     2774020200807";

        String tmp = input.substring(4, input.length());
        System.out.println("tmp:" + tmp);
        char[] tmpchs = tmp.toCharArray();

        int mac = 0;
        for (int i = 0; i < tmpchs.length; i++) {
            char a = tmpchs[i];
            int num = a - 0;
            mac = mac ^ num;
        }
        char ccc = (char) (mac);
        StringBuffer macbuffer = new StringBuffer();
        macbuffer = macbuffer.append(input);
        macbuffer = macbuffer.append(ccc);
        macbuffer = macbuffer.append("000000000000000");

        System.out.println("macbuffer:" + macbuffer);

        String tmpbub9 = macbuffer.substring(9, macbuffer.length());
        System.out.println("tmpbub9:" + tmpbub9);
        StringBuffer tmpbuff = new StringBuffer();

        for (int i = 0; i < tmpbub9.length(); i++) {
            char chr = tmpbub9.charAt(i);
            if ('0' <= chr && chr <= '9') {
                tmpbuff.append((char) (48 + (chr - 48 + 10 + 5) % 10));
            } else if ('a' <= chr && chr <= 'z') {
                tmpbuff.append((char) (97 + (chr - 97 + 26 + 5) % 26));
            } else if ('A' <= chr && chr <= 'Z') {
                tmpbuff.append((char) (65 + (chr - 65 + 26 + 5) % 26));
            } else if (chr == ':') {
                tmpbuff.append(chr);
            } else if (chr == ' ') {
                tmpbuff.append(chr);
            } else {
                String asc = String.valueOf(chr);
                byte[] gc = asc.getBytes();
                int ascNum = (int) gc[0];
                tmpbuff.append((char) (ascNum + 5));
            }
        }

        String top = tmpbuff.substring(0, tmpbuff.length() - 16);
        System.out.println("top:" + top);
        String tol = tmpbuff.substring(tmpbuff.length() - 16, tmpbuff.length());
        System.out.println("tol:" + tol);
        String mid = "KS'9w";
        StringBuffer res = new StringBuffer();
        res.append((char) 0xFF);
        res.append(input.substring(1, 9));
        res.append(top);
        res.append((char) (16));
        res.append(mid);
        res.append(tol);
        System.out.println("结果为" + res.toString());
// 结果为ÿ06970911565554038968356594452 18887336     7229575755352KS'9w@555555555555555
// 结果为ÿ06970911565554038968356594452 18887336     7229575755352KS'9w@555555555555555
// 结果为ÿ06970911565554038968356594452 18887336     7229575755352KS'9w@555555555555555
    }
}
