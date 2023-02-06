package learn.chapter0615;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2020/6/15 14:47
 */
public class StrUtil {
    public static void main(String[] args) {
        System.out.println(strStr("a", "a"));
        System.out.println(strStr("hello", "ll"));
        System.out.println(strStr("hello", "la"));
        System.out.println(strStr("aaaaa", "bba"));
    }

    private static int strStr(String haystack, String needle) {
        if (null == needle || "".equals(needle)) {
            return 0;
        }

        char[] hayStackChar = haystack.toCharArray();
        char[] needleChar = needle.toCharArray();
        int hayStackLen = hayStackChar.length;
        int needleLen = needleChar.length;
        if (hayStackLen < needleLen) {
            return -1;
        }
        for (int i = 0; i < hayStackChar.length; i++) {
            if (hayStackLen - i < needleLen) {
                return -1;
            }
            int t = i;
            for (int j = 0; j < needleChar.length; j++) {
                if (hayStackChar[t++] != needleChar[j]) {
                    break;
                }
                if (j == needleChar.length - 1) {
                    return i;
                }
            }
        }
        return -1;
    }
}
