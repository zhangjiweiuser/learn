package learn.chapter2021.chapter06.chapter0610;

import java.util.HashMap;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/6/11 10:22
 */
public class Apple {
    private String color;

    public Apple(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object obj) {
        if (null == obj) {
            return false;
        }
        if (!(obj instanceof Apple)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        return this.color.equals(((Apple) obj).color);
    }

    @Override
    public int hashCode() {
        return 31 * color.hashCode();
//        return super.hashCode();
    }

    public static void main(String[] args) {


        Apple a2 = new Apple("red");
        System.out.println("a2:" + a2.hashCode());

        Apple a1 = new Apple("green");
        System.out.println("a1:" + a1.hashCode());

        HashMap<Apple, Integer> map = new HashMap<>();
        map.put(a1, 10);
        map.put(a2, 20);
        Apple a3 = new Apple("green");
        System.out.println("a3:" + a3.hashCode());
        System.out.println(map.get(a3));
    }
}
