package org.redis.test;

import redis.clients.jedis.Jedis;

/**
 * @author lijichen
 * @date 2021/2/6 - 18:43
 */
public class MasterAndSlave {
    public static void main(String[] args) {
        Jedis jedis_m = new Jedis("192.168.43.154",6379);
        Jedis jedis_s = new Jedis("192.168.43.154",6380);

        jedis_s.slaveof("192.168.43.154",6379);

        jedis_m.set("kkkk","vvvv");

        System.out.println(jedis_s.get("kkkk"));
    }
}
