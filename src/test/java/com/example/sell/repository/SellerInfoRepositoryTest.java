package com.example.sell.repository;

import com.example.sell.dataobject.ProductInfo;
import com.example.sell.dataobject.SellerInfo;
import com.example.sell.service.impl.BuyerServiceImpl;
import com.example.sell.utils.KeyUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerInfoRepositoryTest {

    private final Logger logger = LoggerFactory.getLogger(BuyerServiceImpl.class);

    @Autowired
    private SellerInfoRepository sellerInfoRepository;

    @Test
    public void saveTest() {
        SellerInfo sellerInfo = new SellerInfo();
        sellerInfo.setSellerId(KeyUtil.genUniqueKey());
        sellerInfo.setUsername("admin");
        sellerInfo.setPassword("admin");
        Date date = new Date();
        sellerInfo.setCreateTime(date);
        sellerInfo.setUpdateTime(date);
        sellerInfo.setOpenid("abc");
        sellerInfoRepository.save(sellerInfo);
    }

    @Test
    public void findByOpenid() {
        SellerInfo sellerInfo = sellerInfoRepository.findByOpenid("abc");
        System.out.print("-----------------\n");
        System.out.print(sellerInfo.toString() + "\n");
        System.out.print("-----------------\n");
    }
}