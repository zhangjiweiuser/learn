package learn.chapter2022.chapter12.chapter1226;

/**
 * @author zhangjiwei1
 * @description
 * @create 2022-12-26 14:57
 */
public class SuShu {
    public static void main(String[] args) {
        System.out.println(su(11));
        System.out.println(aisaifa(11));
    }

    private static int su(int num) {
        int count = 0;
        for (int i = 2; i <= num; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isPrime(int num) {
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static int aisaifa(int num) {
        boolean[] isPrime = new boolean[num + 1];
        int count = 0;
        for (int i = 2; i <= num; i++) {
            if (!isPrime[i]) {
                count++;
                for (int j = i * i; j <= num; j += i) {
                    isPrime[j] = true;
                }
            }
        }
        return count;
    }
}
