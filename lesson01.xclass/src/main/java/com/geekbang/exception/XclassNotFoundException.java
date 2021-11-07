package com.geekbang.exception;

/**
 * x class not found exception
 *
 * @author lei.rong
 * @version 1.0.0
 * @date 2021-11-5
 */
public class XclassNotFoundException extends RuntimeException {
    /**
     * constructor
     */
    public XclassNotFoundException(String message) {
        super(message);
    }
}