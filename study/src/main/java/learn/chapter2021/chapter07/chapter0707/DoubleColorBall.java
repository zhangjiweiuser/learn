package learn.chapter2021.chapter07.chapter0707;

import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/7/7 14:40
 */
public class DoubleColorBall {

    private static int[] HONG = new int[33];
    private static int[] LAN = new int[16];

    static {
        for (int i = 1; i <= 33; i++) {
            HONG[i - 1] = i;
        }
        for (int j = 1; j <= 16; j++) {
            LAN[j - 1] = j;
        }
    }

    public static void main(String[] args) {
//        String source = "app";
//        if(StringUtils.isBlank(source) || (!"app".equalsIgnoreCase(source) && !"h5".equalsIgnoreCase(source))){
//            System.out.println("aaa");
//        }
//        System.out.println(trueOrFalse(""));
//        System.out.println(trueOrFalse("app"));
//        System.out.println(trueOrFalse("a"));
//        System.out.println(trueOrFalse("h5"));
//        System.out.println(trueOrFalse("H5"));
        for (int i = 0; i < 10; i++) {
            System.out.println(Arrays.toString(arr()));
        }

    }


    private static boolean trueOrFalse(String source){
        return StringUtils.isBlank(source) || (!"app".equalsIgnoreCase(source) && !"h5".equalsIgnoreCase(source));
    }

    private static Integer[] arr(){
        Set<Integer> red = new HashSet<>();

        while(red.size()<6){
            int num = ThreadLocalRandom.current().nextInt(0,33);
            red.add(HONG[num]);
        }

        Integer[] objects = red.toArray(new Integer[6]);
        Arrays.sort(objects);
        int blue = LAN[ThreadLocalRandom.current().nextInt(0,16)];
        Integer[] result = new Integer[7];
        System.arraycopy(objects,0,result,0,6);
        result[6] = blue;

        return result;
    }
}
