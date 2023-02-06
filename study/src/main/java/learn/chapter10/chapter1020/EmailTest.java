package learn.chapter10.chapter1020;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/10/20 9:26
 */
public class EmailTest {
    public static void main(String[] args) {
        String EMAIL_REGEX = "^[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]?)*[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
        String email1 = "---------@aa.com";
        System.out.println(email1.matches(EMAIL_REGEX));
        email1 = "---------@aa.com";
        System.out.println(email1.matches(EMAIL_REGEX));
        email1 = "____________@aa.com";
        System.out.println(email1.matches(EMAIL_REGEX));
        email1 = "_.....@aa.com";
        System.out.println(email1.matches(EMAIL_REGEX));
        email1 = "---------@@aa.com";
        System.out.println(email1.matches(EMAIL_REGEX));
    }
}
