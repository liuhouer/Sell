package com.example.sell.controller;

import com.example.sell.dataobject.ProductCategory;
import com.example.sell.dataobject.ProductInfo;
import com.example.sell.dto.OrderDTO;
import com.example.sell.enums.ResultEnum;
import com.example.sell.exception.SellException;
import com.example.sell.form.ProductForm;
import com.example.sell.service.CategoryService;
import com.example.sell.service.OrderService;
import com.example.sell.service.ProductService;
import com.example.sell.utils.KeyUtil;
import com.example.sell.utils.ResultVOUtil;
import com.example.sell.vo.ResultVO;
import org.apache.el.util.ReflectionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

//卖家商品相关操作
@RestController
@RequestMapping("/seller/product")
public class SellerProductController {

    private final Logger logger = LoggerFactory.getLogger(SellerProductController.class);

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    /**
     * 根据分页获取商品列表
     *
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/list")
    public ResultVO list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                         @RequestParam(value = "size", defaultValue = "10") Integer size) {
        PageRequest request = PageRequest.of(page - 1, size);
        Page<ProductInfo> orderDTOPage = productService.findAllProduct(request);
        return ResultVOUtil.success(orderDTOPage.getTotalElements() + "", orderDTOPage.getContent());
    }

    /**
     * 上架商品
     *
     * @param productId
     * @return
     */
    @GetMapping("/onSale")
    public ResultVO onSale(@RequestParam("productId") String productId) {
        try {
            productService.onSale(productId);
        } catch (SellException e) {
            logger.error("【上架商品失败】 e={}", e);
            return ResultVOUtil.error(e.getCode(), e.getMessage());
        }
        return ResultVOUtil.success();
    }

    /**
     * 下架商品
     *
     * @param productId
     * @return
     */
    @GetMapping("/offSale")
    public ResultVO offSale(@RequestParam("productId") String productId) {
        try {
            productService.offSale(productId);
        } catch (SellException e) {
            logger.error("【下架商品失败】 e={}", e);
            return ResultVOUtil.error(e.getCode(), e.getMessage());
        }
        return ResultVOUtil.success();
    }

    /**
     * 获取所有的类别
     *
     * @return
     */
    @GetMapping("/categoryList")
    public ResultVO getAllCategory() {

        //查询所有的类目
        List<ProductCategory> categoryList = categoryService.findAll();

        return ResultVOUtil.success(categoryList);
    }

    /**
     * 根据id获取某一个商品的详情
     *
     * @param productId
     * @return
     */
    @GetMapping("/getOneProduct")
    public ResultVO getOneProduct(@RequestParam("productId") String productId) {

        ProductInfo productInfo = productService.findOne(productId);
        return ResultVOUtil.success(productInfo);
    }

    /**
     * 新增或修改一个商品
     *
     * @return
     */
    @PostMapping("/save")
    //使用redis缓存，每次都会执行这个方法，但会把每次返回的结果放入到redis中，保证所有的数据都是最新的
    @CachePut(cacheNames = "product", key = "123")
    //使用redis缓存，每次都会执行这个方法，但会把之前的数据清除，然后将最新的数据放入redis中，一般适用于前后端不分离的项目中
//    @CacheEvict(cacheNames = "product", key = "123")
    public ResultVO save(@Valid ProductForm productForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            logger.error("【创建商品】 参数不正确 ,orderForm{}", productForm);
            return ResultVOUtil.error(ResultEnum.PARAM_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }
        ProductInfo productInfo = new ProductInfo();
        try {
            //如果productId为空, 说明是新增
            if (!StringUtils.isEmpty(productForm.getProductId())) {
                productInfo = productService.findOne(productForm.getProductId());
            } else {
                productForm.setProductId(KeyUtil.genUniqueKey());
            }
            BeanUtils.copyProperties(productForm, productInfo);
            productService.save(productInfo);
        } catch (SellException e) {
            logger.error("【保存商品失败】 e={}", e);
            return ResultVOUtil.error(e.getCode(), e.getMessage());
        }

        return ResultVOUtil.success();
    }
}
