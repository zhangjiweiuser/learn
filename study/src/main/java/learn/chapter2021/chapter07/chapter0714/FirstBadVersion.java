package learn.chapter2021.chapter07.chapter0714;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/7/15 9:58
 */
public class FirstBadVersion extends VersionControl {

    public static void main(String[] args) {
        FirstBadVersion version = new FirstBadVersion();
        System.out.println(version.firstBadVersion(2));
    }

    public int firstBadVersion(int n) {

        int from = 1;
        int end = n ;

        while (from < end) {
            int mid = from + (end - from) / 2;
            if (isBadVersion(mid)) {

                end = mid ;
            } else {
                from = mid + 1;
            }
        }
        return from;
    }
}
