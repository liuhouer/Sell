package com.example.sell.controller;

import com.example.sell.constant.CookieConstant;
import com.example.sell.constant.RedisConstant;
import com.example.sell.dataobject.SellerInfo;
import com.example.sell.enums.ResultEnum;
import com.example.sell.service.SellerService;
import com.example.sell.utils.CookieUtil;
import com.example.sell.utils.ResultVOUtil;
import com.example.sell.vo.ResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * 卖家
 */
@RestController
@RequestMapping("/seller")
public class SellerUserController {

    private final Logger logger = LoggerFactory.getLogger(SellerUserController.class);

    @Autowired
    private SellerService sellerService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/login")
    public ResultVO sellerLogin(@RequestParam("openid") String openid, HttpServletResponse response) {
        //1.根据openid获取数据库中的数据
        SellerInfo sellerInfo = sellerService.findSellerInfoByOpenid(openid);

        if (sellerInfo == null) {
            logger.error("【卖家登陆失败】openid={}", openid);
            return ResultVOUtil.error(ResultEnum.LOGIN_FAILED.getCode(), ResultEnum.LOGIN_FAILED.getMessage());
        }
        //2.设置token至redis
        String token = UUID.randomUUID().toString();
        //过期时间
        Integer expire = RedisConstant.EXPIRE;
        stringRedisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_PREFIX, token),
                openid, expire, TimeUnit.SECONDS);
        //3.设置token至cookie
        CookieUtil.setCookie(response, CookieConstant.TOKEN, token, expire);

        return ResultVOUtil.success();
    }

    @GetMapping("/logout")
    public ResultVO logout(HttpServletRequest request, HttpServletResponse response) {
        //1.从cookie中查询
        Cookie cookie = CookieUtil.getCookie(request, CookieConstant.TOKEN);
        if (cookie != null) {
            //2.清除redis
            stringRedisTemplate.opsForValue().getOperations().delete(String.format(RedisConstant.TOKEN_PREFIX, cookie.getValue()));
            //3.清除cookie
            CookieUtil.setCookie(response, CookieConstant.TOKEN, null, 0);
        }
        return ResultVOUtil.success();
    }
}
