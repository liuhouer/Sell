package com.example.sell.controller;

import com.example.sell.dto.OrderDTO;
import com.example.sell.enums.ResultEnum;
import com.example.sell.exception.SellException;
import com.example.sell.service.OrderService;
import com.example.sell.utils.ResultVOUtil;
import com.example.sell.vo.ResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 卖家订单相关操作
 */
@RestController
@RequestMapping("/seller/order")
public class SellerOrderController {
    private final Logger logger = LoggerFactory.getLogger(SellerOrderController.class);

    @Autowired
    private OrderService orderService;

    /**
     * 获取所有订单
     *
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/list")
    public ResultVO list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                         @RequestParam(value = "size", defaultValue = "10") Integer size) {
        PageRequest request = PageRequest.of(page - 1, size);
        Page<OrderDTO> orderDTOPage = orderService.findList(request);
        return ResultVOUtil.success(orderDTOPage.getTotalElements() + "", orderDTOPage.getContent());
    }

    /**
     * 取消订单
     *
     * @param orderId
     * @return
     */
    @GetMapping("/cancel")
    public ResultVO cancel(@RequestParam("orderId") String orderId) {
        try {
            OrderDTO orderDTO = orderService.findOne(orderId);
            orderService.cancel(orderDTO);
        } catch (SellException e) {
            logger.error("【卖家端取消订单】 发生异常,Exception={}", e);
            return ResultVOUtil.error(e.getCode(), e.getMessage());
        }
        return ResultVOUtil.success();
    }

    /**
     * 订单详情
     *
     * @param orderId
     * @return
     */
    @GetMapping("/detail")
    public ResultVO detail(@RequestParam("orderId") String orderId) {
        OrderDTO orderDTO;
        try {
            orderDTO = orderService.findOne(orderId);
        } catch (SellException e) {
            logger.error("【卖家端查看订单详情】 发生异常,Exception={}", e);
            return ResultVOUtil.error(e.getCode(), e.getMessage());
        }
        return ResultVOUtil.success(orderDTO);
    }

    /**
     * 结束订单
     *
     * @param orderId
     * @return
     */
    @GetMapping("/finish")
    public ResultVO finish(@RequestParam("orderId") String orderId) {
        OrderDTO orderDTO;
        try {
            orderDTO = orderService.findOne(orderId);
            orderService.finish(orderDTO);
        } catch (SellException e) {
            logger.error("【卖家端完成订单】 发生异常,Exception={}", e);
            return ResultVOUtil.error(e.getCode(), e.getMessage());
        }
        return ResultVOUtil.success();
    }
}
