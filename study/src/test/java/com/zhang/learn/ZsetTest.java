package com.zhang.learn;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/10/20 11:22
 */
//@Slf4j
//@ExtendWith(SpringExtension.class)
//@SpringBootTest
public class ZsetTest {

    @Resource
    private RedisTemplate redisTemplate;

    @Test
    public void zsetTest() {
//        redisTemplate.opsForZSet().add("window", 1, 1);
//        redisTemplate.opsForZSet().add("window", 2, 1);
//        redisTemplate.opsForZSet().add("window", 3, 3);
//        redisTemplate.opsForZSet().add("window", 4, 4);
//        redisTemplate.opsForZSet().add("window", 5, 5);

//        long nums = redisTemplate.opsForZSet().zCard("window");
//        System.out.println("nums:" + nums);
//
//        long num2 = redisTemplate.opsForZSet().count("window", 1, 5);
//        System.out.println("num2:" + num2);
//
        List<Integer> str = Lists.newArrayList(1,2,3);
//        String[] arr = str.toArray(new String[0]);
//        for(String s : arr){
//            System.out.println(s);
//        }
        int[] ints = str.stream().mapToInt(Integer::intValue).toArray();
        Integer[] integers = str.toArray(new Integer[0]);
//        int[] integers2 = str.toArray(new int[0]);
    }
}
