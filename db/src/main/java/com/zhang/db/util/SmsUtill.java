package com.zhang.db.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/8/12 14:22
 */
@Slf4j
public class SmsUtill {
    private static final Pattern PATTERN = Pattern.compile("(\\{\\{\\w*}})");

    /**
     * 短信模板模板替换
     *
     * @param template
     * @param variables
     * @return
     */
    public static String templateToSms(String template, Map<String, String> variables) {
        if (!StringUtils.hasLength(template) || CollectionUtils.isEmpty(variables)) {
            log.info("template or variables is null!");
            return null;
        }

        Matcher matcher = PATTERN.matcher(template);
        while (matcher.find()) {
            String key = matcher.group();
            String value = variables.get(key.replace("{","").replace("}",""));
            if (null == value) {
                value = "";
            }
            template = template.replace(key, value);
            log.info("发送短信，变量替换：{} -> {}", key, value);
        }
        return template;
    }

    public static void main(String[] args) {
//        String template = "验证码为{{code}}，有效期为{{time}}分钟，仅个人有效，不允许泄露";
//        Map<String, String> variable = new HashMap<>();
//        variable.put("code", "12345");
//        variable.put("time", "5");
//        String sms = SmsUtill.templateToSms(template, variable);
//        System.out.println(sms);
//        System.out.println(template);
        System.out.println(BigDecimal.valueOf(0).divide(new BigDecimal("100"), 2, RoundingMode.HALF_UP).stripTrailingZeros());
        System.out.println(BigDecimal.valueOf(900).divide(new BigDecimal("100"), 2, RoundingMode.HALF_UP).stripTrailingZeros());
        System.out.println(BigDecimal.valueOf(910).divide(new BigDecimal("100"), 2, RoundingMode.HALF_UP).stripTrailingZeros());
        System.out.println(BigDecimal.valueOf(912).divide(new BigDecimal("100"), 2, RoundingMode.HALF_UP).stripTrailingZeros().toPlainString());
    }
}
