package com.example.sell.repository;

import com.example.sell.dataobject.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {
    @Autowired
    private ProductCategoryRepository repository;

    @Test
    //事物，做完之后自动回滚，service中是失败之后回滚
    @Transactional
    public void findOneTest() {
//        ProductCategory productCategory = repository.getOne(2);
//        System.out.print("---------------------\n");
//        System.out.print(productCategory.toString() + "\n");
//        System.out.print("---------------------\n");

//        List<ProductCategory> productCategory = repository.findAll();
//        System.out.print("---------------------\n");
//        System.out.print(productCategory.size() + "\n");
//        System.out.print("---------------------\n");
    }

    @Test
    public void saveTest() {
//        ProductCategory productCategory = new ProductCategory();
//        productCategory.setCategoryId(2);
//        productCategory.setCategoryName("老夫子最爱");
//        productCategory.setCategoryType(3);
//        Date date = new Date();
//        productCategory.setCreateTime(date);
//        productCategory.setUpdateTime(date);
//        repository.save(productCategory);
    }

    @Test
    public void findByCategoryTypeIn() {
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(14);
//        List<ProductCategory> list1 = repository.findByCategoryTypeIn(list);
//        for (int i = 0; i < list1.size(); i++) {
//            System.out.print("---------------------\n");
//            System.out.print(list1.get(i).toString() + "\n");
//            System.out.print("---------------------\n");
//        }
    }
}