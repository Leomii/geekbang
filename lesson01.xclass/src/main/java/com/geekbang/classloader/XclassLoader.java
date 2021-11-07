package com.geekbang.classloader;

import com.geekbang.exception.XclassNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * x class extension loader
 *
 * @author lei.rong
 * @version 1.0.0
 * @date 2021-11-5
 */
public class XclassLoader extends ClassLoader {
    private static final Logger LOGGER = LoggerFactory.getLogger(XclassLoader.class);
    /**
     * extension class file path
     */
    private final String filePath;

    /**
     * constructor
     */
    public XclassLoader(String filePath) {
        this.filePath = filePath;
    }

    @Override
    protected Class<?> findClass(String name) {
        byte[] classBytes = null;
        Path path;

        try {
            //load file to byte array
            path = Paths.get(filePath);
            classBytes = Files.readAllBytes(path);
        } catch (IOException e) {
            LOGGER.error("class loader error.", e);
        }

        //empty check
        if (null == classBytes || classBytes.length == 0) {
            throw new XclassNotFoundException("x class not found,name:".concat(name));
        }

        //offset calculate
        for (int i = 0; i < classBytes.length; i++) {
            int temp = 255 - classBytes[i];
            classBytes[i] = (byte) temp;
        }

        //load class and return
        return defineClass(name, classBytes, 0, classBytes.length);
    }
}