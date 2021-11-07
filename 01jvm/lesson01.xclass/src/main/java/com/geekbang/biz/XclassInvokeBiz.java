package com.geekbang.biz;

import com.geekbang.classloader.XclassLoader;
import com.geekbang.exception.XclassInvokeException;
import com.geekbang.util.FileUtil;
import com.geekbang.util.XclassConstants;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * x class invoke biz
 *
 * @author lei.rong
 * @version 1.0.0
 * @date 2021-11-5
 */
public class XclassInvokeBiz {

    public void invoke() throws XclassInvokeException {
        //get file path
        String filePath;

        try {
            filePath = FileUtil.absolutePath(XclassConstants.FILE_NAME);
        } catch (IOException e) {
            throw new XclassInvokeException(e);
        }

        XclassLoader loader = new XclassLoader(filePath);

        try {
            //load class
            Class<?> helloClass = loader.loadClass(XclassConstants.CLASS_NAME);

            //reflect method
            Method helloClassMethod = helloClass.getMethod(XclassConstants.METHOD_NAME);

            //invoke method
            Object helloObject = helloClass.newInstance();
            helloClassMethod.invoke(helloObject);

        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | IllegalAccessException | InstantiationException e) {
            throw new XclassInvokeException(e);
        }
    }
}
