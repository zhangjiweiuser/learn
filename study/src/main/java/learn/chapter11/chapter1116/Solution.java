package learn.chapter11.chapter1116;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，
 * 其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。
 * <p>
 * 注意：
 * 总人数少于1100人。
 * <p>
 * 示例
 * <p>
 * 输入:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * <p>
 * 输出:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/queue-reconstruction-by-height
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhangjiwei
 * @Description TODO
 * @Date 2020/11/16 10:35
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] result = solution.reconstructQueue(people);
        for (int[] ints : result) {
            System.out.println(ints[0] + "--" + ints[1]);
        }
    }

    public int[][] reconstructQueue(int[][] people) {
        // 先排序，h不同，h按照从大到小，h相同，k按照从小到大
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] == o1[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        });
        // 以K为索引插入列表
        List<int[]> list = new ArrayList<>(people.length);
        for (int[] person : people) {
            list.add(person[1], person);
        }
        int[][] arr = new int[people.length][2];
        list.toArray(arr);
        return arr;
    }
}
