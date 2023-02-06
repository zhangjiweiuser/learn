package learn.redis;

import learn.entity.User;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Objects;

public class RedisTest {
    public static void main(String[] args) {
        RedisTemplate<String, Object> template = RedisUtil.getRedisTemplate();
        template.opsForValue().set("hello", "hello");
        System.out.println(template.opsForValue().get("hello"));
        template.delete("hello");
        System.out.println(template.opsForValue().get("hello"));
        template.boundValueOps("hello").set("hello2");
        System.out.println(template.opsForValue().get("hello"));
        template.boundValueOps("user_1").set(new User(1, "zhang"));
        User user = (User) template.opsForValue().get("user_1");
        System.out.println("---> " + user.toString());
        long LOCK_EXPIRE = 1000 * 60;
        String lock = "LOCK_EXPIRE_" + "userid";
        Boolean lockFlag = template.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection redisConnection) throws DataAccessException {
                long expireAt = System.currentTimeMillis() + LOCK_EXPIRE + 1;
                Boolean acquire = redisConnection.setNX(lock.getBytes(), String.valueOf(expireAt).getBytes());
                if (null != acquire && acquire) {
                    return true;
                } else {
                    byte[] value = redisConnection.get(lock.getBytes());
                    if (Objects.nonNull(value) && value.length > 0) {
                        long expireTime = Long.parseLong(new String(value));
                        // 如果锁已经过期
                        if (expireTime < System.currentTimeMillis()) {
                            // 防止死锁
                            byte[] oldValue = redisConnection.getSet(lock.getBytes(), String.valueOf(System.currentTimeMillis() + LOCK_EXPIRE + 1).getBytes());
                            return true;
                        }
                    }
                }
                return false;
            }
        });


    }
}
