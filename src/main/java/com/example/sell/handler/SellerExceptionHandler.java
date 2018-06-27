package com.example.sell.handler;

import com.example.sell.aspect.SellerAuthorizeAspect;
import com.example.sell.enums.ResultEnum;
import com.example.sell.exception.ResponseBankException;
import com.example.sell.exception.SellException;
import com.example.sell.exception.SellerAuthorizeException;
import com.example.sell.utils.ResultVOUtil;
import com.example.sell.vo.ResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class SellerExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(SellerExceptionHandler.class);

    //拦截登录异常
    @ExceptionHandler(value = SellerAuthorizeException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ResultVO handlerAuthorizeException() {
        logger.warn("handlerAuthorizeException");
        return ResultVOUtil.error(ResultEnum.LOGIN_FAILED_NO_TOKEN.getCode(), ResultEnum.LOGIN_FAILED_NO_TOKEN.getMessage());
    }

    @ExceptionHandler(value = SellException.class)
    @ResponseBody
    public ResultVO handlerSellerException(SellException e) {
        logger.warn("handlerSellerException");
        return ResultVOUtil.error(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(value = ResponseBankException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public void handleResponseBankException() {

    }
}

