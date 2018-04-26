package com.lt.blog.db;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigService;
import com.lt.blog.constant.Constant;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisApi {

	private static JedisPool pool = null;
	public static JedisPool getPool() {
//		Config config = ConfigService.getAppConfig();
//		String ip = config.getProperty("redisIp", "127.0.0.1");
//		int port = config.getIntProperty("redisPort", 6379);
//		String passwd = config.getProperty("redisPasswd", "19970622");
//		System.out.println(ip+","+port+","+passwd);
		if (pool == null) {
			JedisPoolConfig redisconfig = GetRedisConfig();		
				pool = new JedisPool(redisconfig, "127.0.0.1", 6379, 300000,"19970622");			
				//pool = new JedisPool(redisconfig, ip, port, 300000,passwd);			
		}
		return pool;

	}
	
	public static Jedis getJedis() {
		return getPool().getResource();
	}
	
	
	private static JedisPoolConfig GetRedisConfig() {
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxTotal(Constant.CONFIG_REDIS_MAX_ACTIVE);
		config.setMaxIdle(Constant.CONFIG_REDIS_MAX_IDLE);
		config.setMaxWaitMillis(Constant.CONFIG_REDIS_MAX_WAIT);
		config.setTestOnBorrow(Constant.CONFIG_REDIS_TEST_BORROW);
		return config;
	}
	public static void main(String[] args) {
		Jedis jedis = RedisApi.getJedis();
		System.out.println(jedis==null);
	}
}