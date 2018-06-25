package com.example.sell.service.impl;

import com.example.sell.dataobject.OrderDetail;
import com.example.sell.dto.OrderDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceImplTest {
    @Autowired
    private OrderServiceImpl orderService;
    private final String buyerOpenId = "110110";
    private final String orderId = "123456";

    @Test
    @Transactional
    public void create() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("杨春");
        orderDTO.setBuyerAddress("我家");
        orderDTO.setBuyerOpenid(buyerOpenId);
        orderDTO.setBuyerPhone("18942335915");
        //购物车
        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail o1 = new OrderDetail();
        Date date = new Date();
        o1.setCreateTime(date);
        o1.setUpdateTime(date);
        o1.setProductId("123456");
        o1.setProductQuantity(3);
        orderDetailList.add(o1);

        orderDTO.setOrderAmount(new BigDecimal(9.6));
        orderDTO.setOrderDetailList(orderDetailList);
        orderDTO.setCreateTime(date);
        orderDTO.setUpdateTime(date);
        OrderDTO orderDTO1 = orderService.create(orderDTO);
        System.out.print("--------------------\n");
        System.out.print(orderDTO1.toString() + "\n");
        System.out.print("--------------------\n");
    }

    @Test
    @Transactional
    public void findOne() {
        OrderDTO orderDTO = orderService.findOne(orderId);
        System.out.print("--------------------\n");
        System.out.print(orderDTO.toString() + "\n");
        System.out.print("--------------------\n");
    }

    @Test
    public void findList() {
        Page<OrderDTO> orderDTOPage = orderService.findList(buyerOpenId, PageRequest.of(0, 2));
        System.out.print("--------------------\n");
        for (int i = 0; i < orderDTOPage.getContent().size(); i++) {
            System.out.print(orderDTOPage.getContent().get(i) + "\n");
        }

        System.out.print("--------------------\n");
    }

    @Test
    @Transactional
    public void cancel() {
        OrderDTO orderDTO = orderService.findOne(orderId);
        System.out.print("--------------------\n");
        System.out.print(orderDTO.toString() + "\n");
        System.out.print("--------------------\n");

        OrderDTO orderDTO1 = orderService.cancel(orderDTO);
        System.out.print("--------------------\n");
        System.out.print(orderDTO1.toString() + "\n");
        System.out.print("--------------------\n");
    }

    @Test
    @Transactional
    public void finish() {
        OrderDTO orderDTO = orderService.findOne(orderId);
        System.out.print("--------------------\n");
        System.out.print(orderDTO.toString() + "\n");
        System.out.print("--------------------\n");

        OrderDTO orderDTO1 = orderService.finish(orderDTO);
        System.out.print("--------------------\n");
        System.out.print(orderDTO1.toString() + "\n");
        System.out.print("--------------------\n");
    }

    @Test
    @Transactional
    public void paid() {
        OrderDTO orderDTO = orderService.findOne(orderId);
        System.out.print("--------------------\n");
        System.out.print(orderDTO.toString() + "\n");
        System.out.print("--------------------\n");

        OrderDTO orderDTO1 = orderService.paid(orderDTO);
        System.out.print("--------------------\n");
        System.out.print(orderDTO1.toString() + "\n");
        System.out.print("--------------------\n");

    }
}