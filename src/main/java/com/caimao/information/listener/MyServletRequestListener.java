package com.caimao.information.listener;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: genx
 * @date: 2018/12/20 22:29
 */
public class MyServletRequestListener implements ServletRequestListener {
    private Logger logger = LoggerFactory.getLogger(getClass());

    public MyServletRequestListener(){
        logger.debug("new MyServletRequestListener()");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        logger.debug("requestDestroyed");
    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        logger.debug("requestInitialized");

        logger.debug(servletRequestEvent.getServletRequest().getClass().getName());

//        if(servletRequestEvent.getServletRequest() instanceof org.apache.catalina.connector.RequestFacade){
//            可以获取路径
//        }
    }
}
