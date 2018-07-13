package com.example.sell.repository;

import com.example.sell.dataobject.OrderMaster;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    @Autowired
    OrderMasterRepository repository;

    @Test
    public void saveTest() {
//        OrderMaster orderMaster = new OrderMaster();
//        orderMaster.setOrderId("1234567");
//        orderMaster.setBuyerName("冰冰");
//        orderMaster.setBuyerPhone("18942335915");
//        orderMaster.setBuyerAddress("上海市");
//        orderMaster.setBuyerOpenid("110110");
//        orderMaster.setOrderAmount(new BigDecimal(2.3));
//        Date date = new Date();
//        orderMaster.setCreateTime(date);
//        orderMaster.setUpdateTime(date);
//        repository.save(orderMaster);
    }

    @Test
    public void findByBuyerOpenid() {
//        Sort sort = new Sort(Sort.Direction.DESC, "createTime");
//        PageRequest request = PageRequest.of(0, 10, sort);
//        Page<OrderMaster> result = repository.findByBuyerOpenid("110110", request);
//        List<OrderMaster> list = result.getContent();
//        System.out.print("-------------\n");
//        for (OrderMaster orderMaster : list) {
//            System.out.print(orderMaster.toString() + "\n");
//        }
//        System.out.print("-------------\n");
//        System.out.print(result.getTotalElements());
    }
}