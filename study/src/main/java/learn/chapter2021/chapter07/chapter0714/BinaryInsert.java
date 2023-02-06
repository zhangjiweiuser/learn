package learn.chapter2021.chapter07.chapter0714;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/7/15 10:08
 */
public class BinaryInsert {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 5;
        BinaryInsert insert = new BinaryInsert();
        System.out.println(insert.searchInsert(nums, target));
    }

    public int searchInsert(int[] nums, int target) {
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }
        if (target < nums[0]) {
            return 0;
        }
        int from = 0;
        int end = nums.length - 1;
        while (from <= end) {
            int mid = from + (end - from) / 2;
            if (nums[mid] < target) {
                from = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return from;
    }
}
