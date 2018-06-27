package com.example.sell.service;

import com.example.sell.dto.OrderDTO;

/**
 * 消息推送
 */
public interface PushMessageService {
    //订单状态变更信息
    void orderStatus(OrderDTO orderDTO);
}
