package org.redis.test;

import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * @author lijichen
 * @date 2021/2/6 - 17:15
 */
public class TestPing {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.43.154",6379);
        System.out.println(jedis.ping());

        jedis.set("k1","v1");
        System.out.println(jedis.get("k1"));

        Set<String> keys = jedis.keys("*");
        System.out.println(keys);

        jedis.close();
    }
}
