package com.example.sell.service;

import com.example.sell.dataobject.SellerInfo;

/**
 * 卖家端
 */
public interface SellerService {
    /**
     * 根据卖家openid获取卖家信息
     * @param openid
     * @return
     */
    SellerInfo findSellerInfoByOpenid(String openid);
}
