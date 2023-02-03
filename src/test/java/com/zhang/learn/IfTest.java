package com.zhang.learn;

import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/5/27 10:58
 */
public class IfTest {
    private static final List<String> AUDIT_MOBILE_LIST = Lists.newArrayList("12345678900", "12345678901",
            "12345678902", "12345678903", "12345678904", "12345678905");

    public static void main(String[] args) throws IOException {
//        test(new MobileLoginParam("12345678903","123456"));
//        testSub();
//        LocalDateTime preparePickupTime = LocalDateTime.parse("2021-06-07 10:30:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//        LocalDateTime prepareReturnTime = LocalDateTime.parse("2021-06-07 11:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//        System.out.println(preparePickupTime.plusMinutes(30).isEqual(prepareReturnTime));
//        BufferedReader br = new BufferedReader(new FileReader(new File("D:/test.txt")));
//        List<String> list = new ArrayList<>();
//        String str = null;
//        while (null != (str = br.readLine())) {
//            if (list.contains(str)) {
//                System.out.println(str);
//            } else {
//                list.add(str);
//            }
//        }
//        System.out.println(list.size());

//        List<String> list2 = FileUtils.readLines(new File("D:/test.txt"), Charset.defaultCharset());
//        System.out.println(list2.size());
//        String idCard = "412895698741259654";
        String idCard = "41254";
        //               4128*************54
        idCard = StringUtils.left(idCard, 4).concat(StringUtils.leftPad(StringUtils.right(idCard, 2), StringUtils.length(idCard) - 4, "*"));
        System.out.println(idCard);
        System.out.println("412895698741259654");
        long start = System.currentTimeMillis();
        String phone = "18511316556";
        phone = StringUtils.left(phone, 3).concat(StringUtils.leftPad(StringUtils.right(phone, 4), StringUtils.length(phone) - 3, "*"));
        System.out.println(phone);
        System.out.println(System.currentTimeMillis() - start);
        String name = "张三力王435345345";
        name = StringUtils.rightPad(StringUtils.left(name, 1), StringUtils.length(name), "*");
        System.out.println(name);
    }

    private static void testSub() {
        List<Integer> sub1 = Lists.newArrayList(1, 2, 3, 4);
        List<Integer> sub2 = Lists.newArrayList(3, 4);
        Collection c1 = CollectionUtils.subtract(sub1, sub2);
        System.out.println(c1);

        System.out.println(CollectionUtils.subtract(sub1, sub2));
        System.out.println(CollectionUtils.subtract(sub2, sub1));
    }

    private static void test(MobileLoginParam mobileLoginParam) {
        if (AUDIT_MOBILE_LIST.contains(mobileLoginParam.getMobile())) {
            if (!"123456".equals(mobileLoginParam.getCode())) {

                System.out.println("验证码验证失败1");
            }


        } else if (!checkVerifyCode(mobileLoginParam.getMobile(), mobileLoginParam.getCode())) {
            System.out.println("验证码验证失败");

        }
    }

    private static boolean checkVerifyCode(String mobile, String code) {
        System.out.println("mobile:" + mobile);
        return true;
    }
}
