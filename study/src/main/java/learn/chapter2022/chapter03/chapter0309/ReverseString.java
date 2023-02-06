package learn.chapter2022.chapter03.chapter0309;

/**
 * @author zhangjiwei1
 * @description
 * @create 2022-03-09 10:21
 */
public class ReverseString {
    public static void main(String[] args) {
        ReverseString reverse = new ReverseString();
        System.out.println(reverse.reverseString("a"));
        System.out.println(reverse.reverseString("ab"));
        System.out.println(reverse.reverseString("abc"));
        System.out.println(reverse.reverseString("abba"));
    }

    public String reverseString(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right){
            char c = chars[left];
            chars[left] = chars[right];
            chars[right] = c;
            left++;
            right--;
        }
        return new String(chars);
    }
}
