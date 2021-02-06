package org.redis.test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

/**
 * @author lijichen
 * @date 2021/2/6 - 18:01
 */
public class TestTransaction {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.43.154",6379);
        Transaction transaction = jedis.multi();

        transaction.set("k3","v3");
        transaction.set("k3","v3");
        transaction.set("k3","v3");

        transaction.exec();
    }
}
