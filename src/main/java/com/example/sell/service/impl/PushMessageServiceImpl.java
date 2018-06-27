package com.example.sell.service.impl;

import com.example.sell.dto.OrderDTO;
import com.example.sell.service.PushMessageService;
import org.springframework.stereotype.Service;

@Service
public class PushMessageServiceImpl implements PushMessageService {
    //此处使用微信的推送
    @Override
    public void orderStatus(OrderDTO orderDTO) {

    }
}
