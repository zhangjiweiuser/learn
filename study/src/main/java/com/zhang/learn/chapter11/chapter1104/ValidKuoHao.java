package com.zhang.learn.chapter11.chapter1104;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhangjiwei
 * @Description TODO
 * @Date 2020/11/4 14:43
 */
public class ValidKuoHao {
    public static void main(String[] args) {
        ValidKuoHao valid = new ValidKuoHao();
        System.out.println(valid.isValid("()[]{}"));
        System.out.println(valid.isValid("(]"));
        System.out.println(valid.isValid("{[]}"));
    }

    public boolean isValid(String s) {
        Map<String, String> map = new HashMap<>();
        map.put("(", ")");
        map.put("{", "}");
        map.put("[", "]");
        Stack<String> stack = new Stack<>();
        String[] arr = s.split("");
        for (String a : arr) {
            if (null != map.get(a)) {
                stack.push(a);
            } else {
                if (stack.size() == 0) {
                    return false;
                }
                String top = stack.peek();
                if (map.get(top).equals(a)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.size() == 0;
    }
}
