package learn.chapter11.chapter1119;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author zhangjiwei
 * @Description TODO
 * @Date 2020/11/19 9:59
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {0,1,0,3,12};
        solution.moveZeroes2(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    /**
     * 两次循环，第一次先找到不是0的，保存下标
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        List<Integer> index = new ArrayList<>();
        for(int i=0,j=nums.length;i<j;i++){
            if(nums[i] != 0){
                index.add(i);
            }
        }
        int k=0;
        for(int i=0,j=nums.length;i<j;i++){
            if(k<index.size()){
                nums[i] = nums[index.get(k++)];
            }else {
                nums[i] = 0;
            }
        }
    }

    /**
     * 双指针循环
     * @param nums
     */
    public void moveZeroes2(int[] nums){
        if(null == nums){
            return;
        }
        // 两个指针i和j
        int j = 0;
        for(int i=0;i<nums.length;i++){
            // 当前元素 != 0，就把他交换到左边
            if(nums[i] != 0){
                if(i > j){
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                j++;
            }
        }
    }
}
