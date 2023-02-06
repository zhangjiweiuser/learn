package learn.chapter08.chapter0827;

/**
 * 是否是回文
 *
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/8/27 14:13
 */
public class IsPalindrome {

    public static void main(String[] args) {
//        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
//        System.out.println(isPalindrome("race a car"));
        System.out.println(isPalindrome("0P"));
    }

    private static boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int i = 0, j = chars.length - 1;
        while (i < j) {
            if (Character.isLetterOrDigit(chars[i])) {
                if (Character.isLetterOrDigit(chars[j])) {
                    if (Character.toLowerCase(chars[i]) == Character.toLowerCase(chars[j])) {
                        i++;
                        j--;
                    } else {
                        return false;
                    }
                } else {
                    j--;
                }
            } else {
                i++;
            }
        }

        return true;
    }
}
