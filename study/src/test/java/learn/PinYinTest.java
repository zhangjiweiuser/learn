package learn;

import com.github.promeg.pinyinhelper.Pinyin;
import com.github.promeg.tinypinyin.lexicons.java.cncity.CnCityDict;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/1/28 16:01
 */
public class PinYinTest {
    public static void main(String[] args) {
        // 添加中文城市词典
        Pinyin.init(Pinyin.newConfig().with(CnCityDict.getInstance()));

        String pinyin = Pinyin.toPinyin("张继伟zhang","");
        System.out.println(pinyin.toLowerCase());
    }
}
