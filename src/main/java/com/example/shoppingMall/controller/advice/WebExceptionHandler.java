package com.example.shoppingMall.controller.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.shoppingMall.dto.HeaderRes;
import com.example.shoppingMall.enums.ReturnCodeAndDescEnum;
import com.example.shoppingMall.exception.DataNotFoundException;
import com.example.shoppingMall.exception.ErrorInputException;

@ControllerAdvice //處理錯誤exception的切面
public class WebExceptionHandler {

    /**
     * 處理ErrorInputException 在WebExceptionHandler實做
     */
    @ResponseBody
    @ExceptionHandler(ErrorInputException.class)
    public HeaderRes handleErrorInputException() {
    	HeaderRes resp = new HeaderRes();
        resp.setReturnCode(ReturnCodeAndDescEnum.ERROR_INPUT.getCode());
        resp.setReturnDesc(ReturnCodeAndDescEnum.ERROR_INPUT.getDesc());
        return resp;

    }
//
    /**
     * 處理DataNotFoundException 在Service要實做
     */
    @ResponseBody
    @ExceptionHandler(DataNotFoundException.class)
    public HeaderRes handleDataNotFoundException() {
    	HeaderRes resp = new HeaderRes();
        resp.setReturnCode(ReturnCodeAndDescEnum.DATA_NOT_FOUND.getCode());
        resp.setReturnDesc(ReturnCodeAndDescEnum.DATA_NOT_FOUND.getDesc());
        return resp;
    }
    
   

}
