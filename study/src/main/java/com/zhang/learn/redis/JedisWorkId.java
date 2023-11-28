package com.zhang.learn.redis;

import cn.hutool.core.date.DateTime;
import redis.clients.jedis.Jedis;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class JedisWorkId {
    private static Jedis jedis;
    private static Jedis getRedis(){
        synchronized (JedisWorkId.class){
            if(jedis == null){
                synchronized (JedisWorkId.class){
                    jedis = new Jedis("127.0.0.1", 6379);
                }
            }
        }

        return jedis;
    }
    public static void main(String[] args) {
        del();

    }

    private static void del(){
        Jedis jedis = getRedis();
        for(int i=0;i<1025;i++){
            jedis.del("WORKER_ID:"+i);
        }
        jedis.close();
    }

    private static void getId(){
        String hostname = "";
        String address = "";
        try {
            InetAddress ia = InetAddress.getLocalHost();
            hostname = ia.getHostName();
            address = ia.getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        String info = hostname + ";" + address + ";" + new DateTime().toString("YYYY-MM-dd HH:mm:ss") + ";";
        Jedis jedis = getRedis();
        Object eval1 = jedis.eval(SCRIPT_WORKID, 1,info);
        System.out.println(info+"===="+eval1);
//        RedisFuture<Object> eval = redisClient().connect().async().eval(SCRIPT_WORKID,
//                ScriptOutputType.INTEGER, info);
//        Long workerId = (Long) eval.get();
//        System.out.println(workerId);
    }

    public final static String SCRIPT_WORKID =
            "local current_hostname = KEYS[1];\n" +
                    "local idKey = 'snowflakeShardingWorkerId';\n" +
                    "local function scan(key)\n" +
                    "    local cursor = 0\n" +
                    "    local keynum = 0\n" +
                    "    repeat\n" +
                    "        local res = redis.call('scan', cursor, 'match', key, 'COUNT', 1500)\n" +
                    "        if (res ~= nil and #res >= 0) then\n" +
                    "            cursor = tonumber(res[1])\n" +
                    "            local ks = res[2]\n" +
                    "            keynum = keynum + #ks\n" +
                    "        end\n" +
                    "    until (cursor <= 0)\n" +
                    "    return keynum\n" +
                    "end" +
                    "\n" +
                    "local function getWorkId()\n" +
                    "   local id ;\n" +
                    "   while(true)\n" +
                    "   do\n" +
                    "       local keynum = scan('WORKER_ID:*');\n" +
                    "       if(keynum >=1023)\n" +
                    "       then\n" +
                    "           return -1;\n" +
                    "       end\n" +
                    "       id = redis.call('incr', idKey);\n" +
                    "       if(id >= 1024)\n" +
                    "       then\n" +
                    "           redis.call('DEL', idKey)\n" +
                    "       else\n" +
                    "           local key = 'WORKER_ID:'..id;\n" +
                    "           local num = redis.call('SETNX', key, current_hostname);\n" +
                    "           if(num == 1)\n" +
                    "           then\n" +
                    "               break;\n" +
                    "           end\n" +
                    "       end\n" +
                    "   end\n" +
                    "   return id;\n" +
                    "end\n" +
                    "return getWorkId();";
}
