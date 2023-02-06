package learn.chapter2022.chapter02.chapter0214;


import com.alibaba.fastjson2.JSONObject;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Collections;
import java.util.Date;
import java.util.Set;

/**
 * @author zhangjiwei1
 * @description
 * @create 2022-02-14 20:31
 */
public class UserClient {
    private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    public static void main(String[] args) {
        User user = new User();
//        user.setScore(2);
        Date date = new Date();
        date.setTime(date.getTime() + 5000);
        user.setDate(date);
        System.out.println(date);
        System.out.println(JSONObject.toJSONString(user));
        User.Address address = new User.Address();
        address.setCity("北京");
        user.setAddressList(Collections.singletonList(address));
        Set<ConstraintViolation<User>> constraintViolationSet = validator.validate(user);
        for (ConstraintViolation<User> constraintViolation : constraintViolationSet) {
            System.out.println(constraintViolation.getMessage() + "-" + constraintViolation.getPropertyPath().toString());
        }
        StringBuffer sb = new StringBuffer();
        sb.append("你好").append(";");
        sb.append("你好").append(";");
        System.out.println(sb.deleteCharAt(sb.length() - 1).toString());
    }
}
