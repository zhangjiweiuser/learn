package learn;

import java.util.Arrays;
import java.util.Random;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2020/12/16 16:13
 */
public class DoubleChromosphere {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            test();
        }
    }

    private static void test() {
        //定义红球池
        int[] redpool = new int[33];
//添加红球数字
        for (int i = 0; i < redpool.length; i++) {
            redpool[i] = i + 1;
        }
//定义篮球池
        int[] bluepool = new int[16];
        for (int j = 0; j < bluepool.length; j++) {
            bluepool[j] = j + 1;
        }
//定义被选中的红球
        int[] redballs = new int[6];
        int x;
        A:
        for (int i = 0; i < redballs.length; i++) {
            x = new Random().nextInt(33);
            for (int j = 0; j <= i; j++) {
//去重过程
//判断当前循环取出的红球是否跟前几次取出的一样
//如果一样 大循环A向后退一次，重新取出红球
                if (redballs[j] == redpool[x]) {
                    i--;
                    continue A;
                }
            }
//如果不一样，则把取出的红球池中取出的红球放入红球数组中
            redballs[i] = redpool[x];
        }
//取出篮球
        int a = bluepool[new Random().nextInt(16)];
//利用冒泡排序对红球进行排序
        int temp;
        for (int i = 0; i < redballs.length - 1; i++) {
            for (int j = 0; j < redballs.length - i - 1; j++) {
                if (redballs[j] > redballs[j + 1]) {
                    temp = redballs[j + 1];
                    redballs[j + 1] = redballs[j];
                    redballs[j] = temp;
                }
            }
        }
        if(9 == a){
            System.out.println("红球为：" + Arrays.toString(redballs) + "  " + "蓝球为：" + a);
        }

    }
}
