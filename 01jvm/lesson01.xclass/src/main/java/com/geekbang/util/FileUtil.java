package com.geekbang.util;

import com.geekbang.exception.NotSupportException;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * file util
 *
 * @author lei.rong
 * @version 1.0.0
 * @date 2021-11-5
 */
public class FileUtil {
    /**
     * constructor
     */
    private FileUtil() {
        throw new NotSupportException("init not support!");
    }

    /**
     * get file absolute path
     *
     * @param fileName classpath下 文件名称
     * @return
     */
    public static String absolutePath(String fileName) throws IOException {
        URL base = Thread.currentThread().getContextClassLoader().getResource("");

        if (null == base) {
            throw new IOException("classpath root dir not found!");
        }

        return new File(base.getFile(), fileName).getCanonicalPath();
    }
}