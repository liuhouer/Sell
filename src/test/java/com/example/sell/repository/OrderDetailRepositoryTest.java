package com.example.sell.repository;

import com.example.sell.dataobject.OrderDetail;
import com.example.sell.service.impl.ProductServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Test
    public void saveTest() {
//        OrderDetail orderDetail = new OrderDetail();
//        Date date = new Date();
//        orderDetail.setCreateTime(date);
//        orderDetail.setUpdateTime(date);
//        orderDetail.setDetailId("11223312");
//        orderDetail.setOrderId("123456");
//        orderDetail.setProductIcon("http://asdas.png");
//        orderDetail.setProductName("小炒肉3");
//        orderDetail.setProductPrice(new BigDecimal(23.4));
//        orderDetail.setProductQuantity(24);
//        orderDetail.setProductId("345678");
//        orderDetailRepository.save(orderDetail);
    }

    @Test
    public void findByOrderId() {
//        List<OrderDetail> orderDetails = orderDetailRepository.findByOrderId("123456");
//        System.out.print("-------------\n");
//        for (OrderDetail orderDetail : orderDetails) {
//            System.out.print(orderDetail.toString() + "\n");
//        }
//        System.out.print("-------------\n");
    }
}