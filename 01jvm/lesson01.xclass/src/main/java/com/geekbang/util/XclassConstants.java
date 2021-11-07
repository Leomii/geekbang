package com.geekbang.util;

import com.geekbang.exception.NotSupportException;

/**
 * constant
 *
 * @author lei.rong
 * @version 1.0.0
 * @date 2021-11-5
 */
public class XclassConstants {
    /**
     * constructor
     */
    private XclassConstants() {
        throw new NotSupportException("init not support!");
    }

    /**
     * class name
     */
    public static final String FILE_NAME = "Hello.xlass";

    /**
     * class name
     */
    public static final String CLASS_NAME = "Hello";

    /**
     * method name
     */
    public static final String METHOD_NAME = "hello";
}