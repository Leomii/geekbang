package com.geekbang;


import com.geekbang.biz.XclassInvokeBiz;
import com.geekbang.exception.XclassInvokeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * entrance
 *
 * @author lei.rong
 * @version 1.0.0
 * @date 2021-11-5
 */
public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        XclassInvokeBiz biz = new XclassInvokeBiz();

        try {
            biz.invoke();
        } catch (XclassInvokeException e) {
            LOGGER.error("x class invoke error", e);
        }

    }
}