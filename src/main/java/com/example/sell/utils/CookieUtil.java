package com.example.sell.utils;

import com.example.sell.aspect.SellerAuthorizeAspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * cookie工具类
 */
public class CookieUtil {
    public static final Logger logger = LoggerFactory.getLogger(CookieUtil.class);

    /**
     * 设置cookie
     *
     * @param response
     * @param name     名字
     * @param value    值
     * @param maxAge   过期时间
     */
    public static void setCookie(HttpServletResponse response,
                                 String name, String value, int maxAge) {
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        cookie.setMaxAge(maxAge);
        response.addCookie(cookie);
    }

    /**
     * 获取cookie
     *
     * @param request
     * @param name
     */
    public static Cookie getCookie(HttpServletRequest request,
                                   String name) {
        Map<String, Cookie> cookieMap = readCookieMap(request);
        for (String key : cookieMap.keySet()) {
            logger.info("key= " + key + " and value= " + cookieMap.get(key));
        }

        if (cookieMap.containsKey(name)) {
            return cookieMap.get(name);
        } else {
            return null;
        }
    }

    /**
     * 将cookie封装成map
     *
     * @param request
     * @return
     */
    private static Map<String, Cookie> readCookieMap(HttpServletRequest request) {
        Map<String, Cookie> cookieMap = new HashMap<>();
        Cookie[] cookies = request.getCookies();
        logger.info((cookies == null) + "");
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                logger.info(cookie.getName());
                cookieMap.put(cookie.getName(), cookie);
            }
        }
        return cookieMap;
    }
}
