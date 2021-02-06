package org.redis.test;

import org.redis.utils.JedisPoolUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author lijichen
 * @date 2021/2/6 - 19:12
 */
public class TestJedisPool {
    public static void main(String[] args) {
        JedisPool jedisPool = JedisPoolUtil.getJedisPoolInstance();
        JedisPool jedisPool2 = JedisPoolUtil.getJedisPoolInstance();
        System.out.println(jedisPool2 == jedisPool);

        Jedis jedis = null;

        try {
            jedis = jedisPool.getResource();

            jedis.set("kekekeke","veveve");

            System.out.println(jedis.get("k1"));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JedisPoolUtil.release(jedisPool,jedis);
        }


    }
}
