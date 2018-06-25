package com.example.sell.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weixin")
public class WeixinController {
    private final Logger logger = LoggerFactory.getLogger(WeixinController.class);

    @GetMapping("/auth")
    public void auth() {
        logger.info("进入auth方法");

    }
}
