package util;

import redis.embedded.RedisServer;

public class RedisServerUtil {
    private static RedisServer redisServer = new RedisServer();
    public static void startRedis(){
        redisServer.start();
        System.err.println("redis启动");
    }
    public static void stopRedis(){
        redisServer.stop();
        System.err.println("redis关闭");
    }
}
