package com.caimao.information.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * HttpSession对象监听器
 *
 * @author: genx
 * @date: 2018/12/20 22:27
 */
public class MyHttpSessionListener implements HttpSessionListener {
    private Logger logger = LoggerFactory.getLogger(getClass());

    public MyHttpSessionListener(){
        logger.debug("new MyHttpSessionListener()");
    }

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        logger.debug("sessionCreated");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        logger.debug("sessionDestroyed");
    }
}
