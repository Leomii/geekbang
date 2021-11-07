package com.geekbang.exception;

/**
 * not support exception
 *
 * @author lei.rong
 * @version 1.0.0
 * @date 2021-11-5
 */
public class NotSupportException extends RuntimeException {
    /**
     * constructor
     */
    public NotSupportException(String message) {
        super(message);
    }
}