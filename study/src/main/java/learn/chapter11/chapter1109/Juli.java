package learn.chapter11.chapter1109;

import java.util.*;

/**
 * 我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。
 * <p>
 * （这里，平面上两点之间的距离是欧几里德距离。）
 * <p>
 * 你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：points = [[1,3],[-2,2]], K = 1
 * 输出：[[-2,2]]
 * 解释：
 * (1, 3) 和原点之间的距离为 sqrt(10)，
 * (-2, 2) 和原点之间的距离为 sqrt(8)，
 * 由于 sqrt(8) < sqrt(10)，(-2, 2) 离原点更近。
 * 我们只需要距离原点最近的 K = 1 个点，所以答案就是 [[-2,2]]。
 * 示例 2：
 * <p>
 * 输入：points = [[3,3],[5,-1],[-2,4]], K = 2
 * 输出：[[3,3],[-2,4]]
 * （答案 [[-2,4],[3,3]] 也会被接受。）
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= K <= points.length <= 10000
 * -10000 < points[i][0] < 10000
 * -10000 < points[i][1] < 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/k-closest-points-to-origin
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhangjiwei
 * @Description TODO
 * @Date 2020/11/9 17:45
 */
public class Juli {
    public static void main(String[] args) {
        int[][] arr = {{68,97},{34,-84},{60,100},{2,31},{-27,-38},{-73,-74},{-55,-39},{62,91},{62,92},{-57,-67}};
        int K = 5;
        Juli juli = new Juli();
        int[][] res = juli.kClosest(arr, K);
        for (int[] it : res) {
            System.out.println(it[0] + "--" + it[1]);
        }
    }

    public int[][] kClosest(int[][] points, int K) {
        double max = 0;
        String key = "";
        int num = 0;
        Map<String, int[]> map = new HashMap<>();

        for (int i = 0; i < points.length; i++) {
            int[] p = points[i];
            double d = Math.sqrt(p[0] * p[0] + p[1] * p[1]);
            if (num < K) {
                map.put(d + "_" + i, p);

                num++;
            } else {
                if (d < max) {
                    map.remove(key);
                    map.put(d + "_" + i, p);

                }
            }
            max = 0;
            Set<String> keys = map.keySet();
            Iterator<String> it = keys.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if(max < Double.valueOf(next.split("_")[0])){
                    max = Double.valueOf(next.split("_")[0]);
                    key = next;
                }
            }
        }
        int[][] result = new int[map.size()][2];
        Set<Map.Entry<String, int[]>> sets = map.entrySet();
        Iterator<Map.Entry<String, int[]>> its = sets.iterator();
        int i = 0;
        while (its.hasNext()) {
            result[i++] = its.next().getValue();
        }
        return result;
    }

}
