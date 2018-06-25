package com.example.sell.service.impl;

import com.example.sell.dataobject.ProductInfo;
import com.example.sell.enums.ProductStatusEnum;
import com.example.sell.repository.ProductInfoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    private ProductServiceImpl productService;

    @Test
    @Transactional
    public void findOne() {
        ProductInfo productInfo = productService.findOne("123456");
        System.out.print("-------------\n");
        System.out.print(productInfo.toString() + "\n");
        System.out.print("-------------\n");
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> productInfo = productService.findUpAll();
        System.out.print("-------------\n");
        System.out.print(productInfo.size() + "\n");
        System.out.print("-------------\n");
    }

    @Test
    public void findAllProduct() {
        PageRequest request = PageRequest.of(0, 2);
        Page<ProductInfo> productInfo = productService.findAllProduct(request);
        System.out.print("-------------\n");
        System.out.print(productInfo.getTotalPages() + "\n");
        System.out.print(productInfo.getContent().size() + "\n");
        System.out.print("-------------\n");
    }

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        Date date = new Date();
        productInfo.setCreateTime(date);
        productInfo.setUpdateTime(date);
        productInfo.setProductStock(25);
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        productInfo.setProductPrice(new BigDecimal(21));
        productInfo.setProductName("名称");
        productInfo.setProductId("product2");
        productInfo.setProductIcon("http://xxxaaaa.png");
        productInfo.setProductDescription("这个很好哦");
        productInfo.setCategoryType(1);
        productService.save(productInfo);
    }
}