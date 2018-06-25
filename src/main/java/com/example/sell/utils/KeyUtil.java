package com.example.sell.utils;

import java.util.Random;

public class KeyUtil {
    /**
     * 生成唯一主键
     * 格式：时间+随机数
     *synchronized 防止多线程出现重复
     * @return
     */
    public static synchronized String genUniqueKey() {
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(number);
    }
}
