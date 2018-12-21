package com.caimao.information.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.ContextLoaderListener;

import javax.servlet.ServletContextEvent;
import java.util.Enumeration;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * ServletContext对象监听器
 * @author: genx
 * @date: 2018/12/20 22:09
 */
public class MyServletContextListener extends ContextLoaderListener {
    private Logger logger = LoggerFactory.getLogger(getClass());

    public MyServletContextListener(){
        logger.debug("new MyServletContextListener()");
    }

    @Override
    public void contextInitialized(ServletContextEvent event) {
        logger.debug("contextInitialized");
        Enumeration<String> s = event.getServletContext().getInitParameterNames();
        while(s.hasMoreElements()){
            String key = s.nextElement();
            logger.debug("{}={}", key, event.getServletContext().getInitParameter(key));
        }
        super.contextInitialized(event);
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        logger.debug("contextDestroyed");
        super.contextDestroyed(event);
    }
}
