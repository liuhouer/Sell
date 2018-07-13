package com.example.sell.service.impl;

import com.example.sell.dataobject.SellerInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerServiceImplTest {
    private final Logger logger = LoggerFactory.getLogger(SellerServiceImplTest.class);

    @Autowired
    private SellerServiceImpl sellerService;

    @Test
    public void findSellerInfoByOpenid() {
//        SellerInfo resultInfo = sellerService.findSellerInfoByOpenid("abc");
//        logger.info(resultInfo.toString());
    }
}