package com.example.sell.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * Created by 廖师兄
 * 2017-08-07 23:55
 */
@Component

public class RedisLock {

    private final Logger log = LoggerFactory.getLogger(RedisLock.class);

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 加锁
     *
     * @param key
     * @param value 当前时间+超时时间
     * @return
     */
    public boolean lock(String key, String value) {
        //说明该key以前没有，表明是第一次，就让其加锁
        if (redisTemplate.opsForValue().setIfAbsent(key, value)) {
            return true;
        }
        //假设同时有2个线程进入该方法
        //currentValue=A   这两个线程的value都是B  其中一个线程拿到锁
        //加这段以防死锁的现象出现
        String currentValue = redisTemplate.opsForValue().get(key);
        log.info("currentValue:" + currentValue);

        //如果锁过期
        if (!StringUtils.isEmpty(currentValue)
                && Long.parseLong(currentValue) < System.currentTimeMillis()) {
            //获取上一个锁的时间,设置新值并返回旧值
            String oldValue = redisTemplate.opsForValue().getAndSet(key, value);
            log.info("oldValue:" + oldValue);
            if (!StringUtils.isEmpty(oldValue) && oldValue.equals(currentValue)) {
                return true;
            }
        }

        return false;
    }

    /**
     * 解锁
     *
     * @param key
     * @param value
     */
    public void unlock(String key, String value) {
        try {
            String currentValue = redisTemplate.opsForValue().get(key);
            if (!StringUtils.isEmpty(currentValue) && currentValue.equals(value)) {
                redisTemplate.opsForValue().getOperations().delete(key);
            }
        } catch (Exception e) {
            log.error("【redis分布式锁】解锁异常, {}", e);
        }
    }

}
