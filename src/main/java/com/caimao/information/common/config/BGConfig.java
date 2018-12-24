package com.caimao.information.common.config;

import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: genx
 * @date: 2018/7/9 23:58
 */
public class BGConfig {
    private static Logger logger = LoggerFactory.getLogger(BGConfig.class);
    final private static String CONFIG_FILE = "SystemParameter.properties";

    private static Properties configuration = new Properties();

    static {

        try {
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            InputStream stream = loader.getResourceAsStream(CONFIG_FILE);
            configuration.load(stream);
            stream.close();
        } catch (IOException e) {
            logger.error("加载系统文件[" + CONFIG_FILE + "]出现异常,请检查...", e);

        }
    }

    public static String get(String key) {
        return configuration.getProperty(key);
    }

    public static int getInt(String key) {
        return NumberUtils.toInt(get(key));
    }
}
