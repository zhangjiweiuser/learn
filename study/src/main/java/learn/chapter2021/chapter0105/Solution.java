package learn.chapter2021.chapter0105;

import java.util.ArrayList;
import java.util.List;

/**
 * 在一个由小写字母构成的字符串 s 中，包含由一些连续的相同字符所构成的分组。
 *
 * 例如，在字符串 s = "abbxxxxzyy" 中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。
 *
 * 分组可以用区间 [start, end] 表示，其中 start 和 end 分别表示该分组的起始和终止位置的下标。上例中的 "xxxx" 分组用区间表示为 [3,6] 。
 *
 * 我们称所有包含大于或等于三个连续字符的分组为 较大分组 。
 *
 * 找到每一个 较大分组 的区间，按起始位置下标递增顺序排序后，返回结果。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/positions-of-large-groups
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 输入：s = "abbxxxxzzy"
 * 输出：[[3,6]]
 * 解释："xxxx" 是一个起始于 3 且终止于 6 的较大分组
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/1/5 17:36
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> result = solution.largeGroupPositions("aaa");
        System.out.println(result);
    }

    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> result = new ArrayList<>();
        int start = 0;
        char from = s.charAt(0);
        for(int i=1;i<s.length();i++){
            char a = s.charAt(i);
            if(i == s.length()-1 && from == a && i-start>=2){
                List<Integer> group = new ArrayList<>();
                group.add(start);
                group.add(i);
                result.add(group);
            }
            if(from != a){
                int num = i-start;
                if(num >=3){
                    List<Integer> group = new ArrayList<>();
                    group.add(start);
                    group.add(i-1);
                    result.add(group);
                }
                start = i;
                from = a;
            }
        }
        return result;
    }
}
