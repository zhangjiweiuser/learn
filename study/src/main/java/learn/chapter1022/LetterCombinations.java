package learn.chapter1022;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.*;

/**
 * 电话号码组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 2->abc
 * 3->def
 * 4->ghi
 * 5->jkl
 * 6->mno
 * 7->pqrs
 * 8->tuv
 * 9->wxyz
 * 例如：输入23-> ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
 *
 * @author zhangjiwei
 * @Description TODO
 * @Date 2020/10/22 9:54
 */
public class LetterCombinations {
    private static Map<Integer, List<String>> map = new HashMap<>();

    static {
        map.put(2, Arrays.asList("a","b","c"));
        map.put(3, Arrays.asList("d", "e", "f"));
        map.put(4, Arrays.asList("g", "h", "i"));
        map.put(5, Arrays.asList("j", "k", "l"));
        map.put(6, Arrays.asList("m", "n", "o"));
        map.put(7, Arrays.asList("p", "q", "r", "s"));
        map.put(8, Arrays.asList("t", "u", "v"));
        map.put(9, Arrays.asList("w", "x", "y", "z"));
    }

    public static void main(String[] args) {
        List<String> result = letterCombination("23456789");
        for (String s : result) {
            System.out.print(s + "\t");
        }
    }

    private static List<String> letterCombination(String digits) {
        if(digits.length() == 0){
            return new ArrayList<>();
        }
        char[] chars = digits.toCharArray();
        List<String> origin = map.get(Integer.valueOf("" + chars[0]));
        for (int i = 1; i < chars.length; i++) {
            origin = combin(origin, Integer.valueOf("" + chars[i]));
        }

        return origin;
    }

    private static List<String> combin(List<String> origin, int num) {
        List<String> result = new ArrayList<>();
        for (String o : origin) {
            for (String s : map.get(num)) {
                result.add(o + s);
            }
        }
        return result;
    }
}
