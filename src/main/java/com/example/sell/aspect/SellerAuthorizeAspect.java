package com.example.sell.aspect;

import com.example.sell.constant.CookieConstant;
import com.example.sell.constant.RedisConstant;
import com.example.sell.controller.BuyerOrderController;
import com.example.sell.enums.ResultEnum;
import com.example.sell.exception.SellException;
import com.example.sell.exception.SellerAuthorizeException;
import com.example.sell.utils.CookieUtil;
import com.example.sell.utils.ResultVOUtil;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * 验证卖家是否登录，不登录不能展示卖家相关信息
 */
@Aspect
@Component
public class SellerAuthorizeAspect {

    private final Logger logger = LoggerFactory.getLogger(SellerAuthorizeAspect.class);

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Pointcut("execution(public * com.example.sell.controller.Seller*.*(..))" +
            "&& !execution(public * com.example.sell.controller.SellerUserController.*(..))")
    public void verify() {
    }

    @Before("verify()")
    public void doVerify() {
        logger.info("doVerify");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //查询cookie
        Cookie cookie = CookieUtil.getCookie(request, CookieConstant.TOKEN);

        if (cookie == null) {
            logger.warn("【登录校验】Cookie中查不到token");
            throw new SellerAuthorizeException();
        }
        //去redis中查询
        String tokenValue = stringRedisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_PREFIX, cookie.getValue()));
        if (StringUtils.isEmpty(tokenValue)) {
            logger.warn("【登录校验】Redis中查不到token");
            throw new SellerAuthorizeException();
        }
    }
}
