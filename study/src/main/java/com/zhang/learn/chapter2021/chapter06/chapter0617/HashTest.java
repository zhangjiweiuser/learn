package com.zhang.learn.chapter2021.chapter06.chapter0617;

import com.vdurmont.emoji.EmojiManager;
import com.vdurmont.emoji.EmojiParser;
import org.apache.commons.lang3.StringUtils;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/6/17 11:24
 */
public class HashTest {
    public static void main(String[] args) {
        Long t = new Long(1L);
        Integer i = new Integer(1);
        System.out.println(t.hashCode());
        System.out.println(i.hashCode());

        System.out.println(StringUtils.isBlank(EmojiParser.removeAllEmojis("你好啊☀123")));
        System.out.println(StringUtils.isBlank(EmojiParser.removeAllEmojis("☀")));
        System.out.println(EmojiManager.containsEmoji("☀"));
    }
}
