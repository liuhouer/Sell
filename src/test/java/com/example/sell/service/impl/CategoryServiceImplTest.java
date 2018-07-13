package com.example.sell.service.impl;

import com.example.sell.dataobject.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.util.*;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

    @Autowired
    private CategoryServiceImpl categoryService;

    @Test
    @Transactional
    public void findOne() {
//        ProductCategory productCategory = categoryService.findOne(1);
//        System.out.print("-----------------------------");
//        System.out.print(productCategory.toString() + "\n");
//        System.out.print("-----------------------------");
    }

    @Test
    public void findAll() {
//        List<ProductCategory> productCategory = categoryService.findAll();
//        System.out.print("-----------------------------");
//        System.out.print(productCategory.size() + "\n");
//        System.out.print("-----------------------------");
    }

    @Test
    public void findByCategoryTypeIn() {
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(4);
//        List<ProductCategory> productCategory = categoryService.findByCategoryTypeIn(list);
//        System.out.print("-----------------------------");
//        System.out.print(productCategory.size() + "\n");
//        System.out.print("-----------------------------");
    }

    @Test
    public void save() {
//        ProductCategory productCategory = new ProductCategory();
//        productCategory.setCategoryType(6);
//        productCategory.setCategoryName("哈哈");
//        Date date = new Date();
//        productCategory.setCreateTime(date);
//        productCategory.setUpdateTime(date);
//        categoryService.save(productCategory);
    }
}