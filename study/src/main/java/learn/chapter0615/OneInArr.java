package learn.chapter0615;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2020/6/15 15:13
 */
public class OneInArr {
    public static void main(String[] args) {
        System.out.println(oneInArr(new int[]{1, 2, 2, 1, 6}));
        System.out.println(oneInArr(new int[]{3, 1, 1, 2, 2}));
    }

    private static int oneInArr(int[] arr) {

        int num = arr[0];
        for (int i = 1; i < arr.length; i++) {
            num = num ^ arr[i];
        }
        return num;
    }
}
