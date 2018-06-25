package com.example.sell.service;

import com.example.sell.dataobject.ProductInfo;
import com.example.sell.dto.CartDTO;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 商品service
 */
public interface ProductService {
    ProductInfo findOne(String productId);

    /**
     * 查询所有在架的商品列表
     *
     * @return
     */
    List<ProductInfo> findUpAll();

    /**
     * 分页查询所有的商品信息
     *
     * @return
     */
    Page<ProductInfo> findAllProduct(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    //加库存
    void increaseStock(List<CartDTO> cartDTOS);

    //减库存
    void decreaseStock(List<CartDTO> cartDTOS);
}
