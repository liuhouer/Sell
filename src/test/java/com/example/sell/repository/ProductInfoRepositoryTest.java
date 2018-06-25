package com.example.sell.repository;

import com.example.sell.dataobject.ProductInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {
    @Autowired
    private ProductInfoRepository repository;

    @Test
    public void saveTest() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setCategoryType(1);
        Date date = new Date();
        productInfo.setCreateTime(date);
        productInfo.setUpdateTime(date);
        productInfo.setProductDescription("这个很好吃");
        productInfo.setProductIcon("http:img.png");
        productInfo.setProductId("123456");
        productInfo.setProductName("麻辣烫");
        productInfo.setProductPrice(new BigDecimal(3.2));
        productInfo.setProductStatus(0);
        productInfo.setProductStock(100);
        repository.save(productInfo);
    }

    @Test
    public void findByProductStatus() {
        List<ProductInfo> list = repository.findByProductStatus(0);
        System.out.print("---------------------\n");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i).toString() + "\n");
        }
        System.out.print("---------------------\n");
    }
}