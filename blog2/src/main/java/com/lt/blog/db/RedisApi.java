package com.lt.blog.db;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigService;
import com.lt.blog.constant.Constant;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisApi {

	

	private static JedisPool pool = null;
	private static Config config = ConfigService.getAppConfig();
	public static JedisPool getPool() {
		String ip = config.getProperty("redisIp", "127.0.0.1");
		int port = config.getIntProperty("redisPort", 6379);
		if (pool == null) {
			JedisPoolConfig config = GetRedisConfig();			
				pool = new JedisPool(config, ip, port, 300000);			
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
}