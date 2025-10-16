package com.sky.exception;

/**
 * 用户名已存在，无法插入异常
 */
public class AddEmployeeException extends BaseException {
    public AddEmployeeException(String message) {
        super(message);
    }
}
