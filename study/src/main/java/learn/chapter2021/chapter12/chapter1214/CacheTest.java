package learn.chapter2021.chapter12.chapter1214;

import com.google.common.base.CaseFormat;
import org.apache.commons.lang3.StringUtils;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/12/14 14:10
 */
public class CacheTest {
    public static void main(String[] args) {
        String userName = CaseFormat.LOWER_HYPHEN.to(CaseFormat.LOWER_CAMEL, "user-name");
        System.out.println(userName);

        System.out.println(StringUtils.uncapitalize("Cat"));
        System.out.println(StringUtils.uncapitalize("cat"));
    }
}
