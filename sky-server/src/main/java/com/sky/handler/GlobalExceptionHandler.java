package com.sky.handler;

import com.sky.exception.AddEmployeeException;
import com.sky.exception.BaseException;
import com.sky.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器，处理项目中抛出的业务异常
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 捕获业务异常
     * @param ex
     * @return
     */
    @ExceptionHandler
    public Result exceptionHandler(BaseException ex){
        log.error("异常信息：{}", ex.getMessage());
        return Result.error(ex.getMessage());
    }

    /**
     * 捕获（用户名已存在，不能重复添加）异常
     * @param ex
     * @return
     */
    @ExceptionHandler
    public Result<String> handleAddEmployeeException(AddEmployeeException ex){
        return Result.error(ex.getMessage());
    }

    /**
     * 捕获所有未处理的异常
     */
    @ExceptionHandler(Exception.class)
    public Result<String> handleException(Exception ex) {
        log.error("未知异常：", ex);
        return Result.error("系统出现未知错误，请联系管理员。");
    }

}
