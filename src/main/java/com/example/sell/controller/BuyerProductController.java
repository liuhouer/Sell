package com.example.sell.controller;

import com.example.sell.dataobject.ProductCategory;
import com.example.sell.dataobject.ProductInfo;
import com.example.sell.service.CategoryService;
import com.example.sell.service.ProductService;
import com.example.sell.utils.ResultVOUtil;
import com.example.sell.vo.ProductInfoVO;
import com.example.sell.vo.ProductVO;
import com.example.sell.vo.ResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 卖家商品相关
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    private final Logger logger = LoggerFactory.getLogger(BuyerProductController.class);
    /**
     * 获取所有商品
     *
     * @return
     */
    @GetMapping("/list")
    //假设sellerId为该方法的参数,condition为如果sellerId的长度大于3，则进行缓存，不大于3不缓存
    //unless为如果result的code不为0则不缓存(为0缓存，不为0不缓存)
//    @Cacheable(cacheNames = "product", key = "#sellerId", condition = "#sellerId.length()>3",unless = "#result.getCode() != 0")
    //增加redis缓存，使用该缓存之后，第一次访问会进入该接口中，第二次访问就会从redis中访问
    @Cacheable(cacheNames = "product", key = "123")
    public ResultVO list() {
        logger.info("list");
        //1.查询所有的上架商品
        List<ProductInfo> productInfoList = productService.findUpAll();
        //2.查询类目(一次性查询)
//        List<Integer> categoryTypeList = new ArrayList<>();
        //传统方法使用for循环，将productInfoList中的所有的type加入到categoryTypeList中
        //精简写法(java8,lambda)
        List<Integer> categoryTypeList = productInfoList.stream().map(e -> e.getCategoryType()).collect(Collectors.toList());

        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);
        //3.数据拼装,for循环中不要加数据库操作
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList) {
            ProductVO productVO = new ProductVO();

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }

            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }
        ResultVO resultVO = ResultVOUtil.success(productVOList);

        return resultVO;
    }
}
