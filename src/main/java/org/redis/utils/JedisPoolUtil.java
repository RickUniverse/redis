package org.redis.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author lijichen
 * @date 2021/2/6 - 19:02
 */
public class JedisPoolUtil {
    private JedisPoolUtil() {}

    private static volatile JedisPool jedisPool = null;

    public static JedisPool getJedisPoolInstance() {
        if (null == jedisPool) {
            synchronized (JedisPoolUtil.class) {
                if (null == jedisPool) {
                    JedisPoolConfig poolConfig = new JedisPoolConfig();
                    poolConfig.setMaxTotal(1000);
                    poolConfig.setMaxIdle(32);
                    poolConfig.setMaxWaitMillis(100 * 1000);
                    poolConfig.setTestOnBorrow(true);

                    jedisPool = new JedisPool(poolConfig,"192.168.43.154",6379);
                    return jedisPool;
                }
            }
        }
        return jedisPool;
    }

    // 将JedisPool放回池子
    public static void release(JedisPool jedisPool, Jedis jedis) {
        if (null != jedisPool) {
            // 放回去
            jedisPool.returnResourceObject(jedis);
        }
    }
}
