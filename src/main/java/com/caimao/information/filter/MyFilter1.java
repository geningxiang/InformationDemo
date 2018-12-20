package com.caimao.information.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: genx
 * @date: 2018/12/20 22:05
 */
public class MyFilter1 implements Filter {

    private Logger logger = LoggerFactory.getLogger(getClass());

    public MyFilter1(){
        logger.debug("new MyFilter1()");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.debug("init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.debug("doFilter start");
        filterChain.doFilter(servletRequest, servletResponse);
        logger.debug("doFilter end");
    }

    @Override
    public void destroy() {
        logger.debug("destroy");
    }
}
