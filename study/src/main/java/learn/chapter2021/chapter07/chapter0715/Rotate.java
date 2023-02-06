package learn.chapter2021.chapter07.chapter0715;

import java.util.Arrays;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/7/15 11:04
 */
public class Rotate {
    public static void main(String[] args) {
        int[] nums = {1,2};
        Rotate rotate = new Rotate();
        rotate.rotate(nums,3);
        System.out.println(Arrays.toString(nums));
    }

    public void rotate(int[] nums, int k) {
        int length = nums.length;
        if(length == 1){
            return;
        }
        int yu = k % length;
        if(yu == 0){
            return;
        }
        int[] num2 = new int[length];
        for (int i = 0; i < yu; i++) {
            num2[i] = nums[length - yu + i];
        }
        for(int i=yu;i<=length-1;i++){
            num2[i] = nums[i-yu];
        }
        for(int i=0;i<=length-1;i++){
            nums[i] = num2[i];
        }

    }
}
