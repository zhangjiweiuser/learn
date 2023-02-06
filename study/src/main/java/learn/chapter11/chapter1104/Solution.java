package learn.chapter11.chapter1104;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 * 示例 2：
 * <p>
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insert-interval
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhangjiwei
 * @Description TODO
 * @Date 2020/11/4 10:50
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] ints = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval = {4,8};
        int[][] arr = solution.insert(ints,newInterval);
        for(int[] a : arr){
            System.out.println(a[0]+","+a[1]);
        }
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];
        List<int[]> result = new ArrayList<>();
        for (int[] in : intervals) {
            if (left >= in[0] && left <= in[1]) {
                left = Math.min(left,in[0]);
                right = Math.max(right, in[1]);
            } else if (left <= in[0] && right >= in[0]) {
                left = Math.min(left,in[0]);
                right = Math.max(right, in[1]);
            } else {
                result.add(in);
            }
        }
        result.add(new int[]{left, right});
        result.sort(Comparator.comparingInt(o -> o[0]));
        int[][] arr = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            arr[i] = result.get(i);
        }

        return arr;
    }

}
