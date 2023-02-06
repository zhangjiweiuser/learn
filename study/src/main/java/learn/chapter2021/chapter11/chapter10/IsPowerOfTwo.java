package learn.chapter2021.chapter11.chapter10;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/11/10 16:56
 */
public class IsPowerOfTwo {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(16));
        System.out.println(isPowerOfTwo(3));
    }

    public static boolean isPowerOfTwo(int n) {
        while(n > 1){
            if (n % 2 == 1) {
                return false;
            }
            n = n / 2;
        }
        return true;
    }
}
