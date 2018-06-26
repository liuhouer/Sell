package com.example.sell.controller;

import com.example.sell.dataobject.ProductCategory;
import com.example.sell.dataobject.ProductInfo;
import com.example.sell.enums.ResultEnum;
import com.example.sell.exception.SellException;
import com.example.sell.form.CategoryForm;
import com.example.sell.form.ProductForm;
import com.example.sell.service.CategoryService;
import com.example.sell.utils.KeyUtil;
import com.example.sell.utils.ResultVOUtil;
import com.example.sell.vo.ResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

//卖家关于类目的操作
@RestController
@RequestMapping("/seller/category")
public class SellerCategoryController {
    private final Logger logger = LoggerFactory.getLogger(SellerCategoryController.class);

    @Autowired
    private CategoryService categoryService;

    /**
     * 查询所有的类目
     *
     * @return
     */
    @GetMapping("/list")
    public ResultVO list() {
        List<ProductCategory> productCategoryList = categoryService.findAll();
        return ResultVOUtil.success(productCategoryList);
    }

    /**
     * 查询某一条类目
     */
    @GetMapping("/getItem")
    public ResultVO getItem(@RequestParam("categoryId") Integer categoryId) {
        ProductCategory productCategory = new ProductCategory();
        try {
            productCategory = categoryService.findOne(categoryId);
        } catch (SellException e) {
            logger.error("【获取类目失败】 e={}", e);
            return ResultVOUtil.error(e.getCode(), e.getMessage());
        } catch (Exception e) {
            logger.error("【获取类目失败】 e={}", e);
            return ResultVOUtil.error(500, e.getMessage());
        }

        return ResultVOUtil.success(productCategory);
    }

    /**
     * 新增或修改一个类目
     *
     * @return
     */
    @PostMapping("/save")
    public ResultVO save(@Valid CategoryForm categoryForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            logger.error("【创建类目】 参数不正确 ,categoryForm{}", categoryForm);
            return ResultVOUtil.error(ResultEnum.PARAM_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }
        ProductCategory productCategory = new ProductCategory();
        try {
            //如果productId为空, 说明是新增
            if (!StringUtils.isEmpty(categoryForm.getCategoryId())) {
                productCategory = categoryService.findOne(categoryForm.getCategoryId());
            }
            BeanUtils.copyProperties(categoryForm, productCategory);
            categoryService.save(productCategory);
        } catch (SellException e) {
            logger.error("【保存类目失败】 e={}", e);
            return ResultVOUtil.error(e.getCode(), e.getMessage());
        } catch (Exception e){
            logger.error("【保存类目失败】 e={}", e);
            return ResultVOUtil.error(500, e.getMessage());
        }

        return ResultVOUtil.success();
    }
}
