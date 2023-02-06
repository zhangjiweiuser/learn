package learn.chapter2022.chapter02.chapter0214;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.validator.constraints.Range;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.Date;
import java.util.List;

/**
 * @author zhangjiwei1
 * @description
 * @create 2022-02-14 20:29
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class User {
    @NotBlank(message = "用户名不能为空")
    private String username;
    @NotBlank(message = "密码不能为空")
    private String password;
    @NotBlank(message = "手机号不能为空")
    @Pattern(regexp = "^1([34578])\\d{9}$", message = "手机号格式错误")
    private String mobile;
    @NotBlank(message = "性别不能为空")
    private String gender;
    @NotNull(message = "年龄不能为空")
    @Range(min = 5, max = 90, message = "年龄必须在5-90之间")
    private Integer age;

    @Range(min = 5, max = 90, message = "分数必须在5-90之间")
    private Integer score;

    @NotNull(message = "时间不能为空")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Future(message = "时间必须晚于当前时间")
    private Date date;
    @Valid
    @NotEmpty(message = "地址不能为空")
    private List<Address> addressList;

    @AllArgsConstructor
    @NoArgsConstructor
    @Setter
    @Getter
    static class Address {

        @NotBlank(message = "省不能为空")
        private String province;
        @NotBlank(message = "市不能为空")
        private String city;
        @NotBlank(message = "区不能为空")
        private String region;
    }
}
