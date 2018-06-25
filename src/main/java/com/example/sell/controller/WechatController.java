package com.example.sell.controller;

import com.example.sell.service.impl.BuyerServiceImpl;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wechat")
public class WechatController {
    private final Logger logger = LoggerFactory.getLogger(WechatController.class);
    @GetMapping("/authorize")
    public void authorize(@RequestParam("returnUrl") String returnUrl){
//        WxMpService wxMpService = new WxMpServiceImpl();
//        wxMpService.setWxMpConfigStorage();
//        returnUrl
    }
}
