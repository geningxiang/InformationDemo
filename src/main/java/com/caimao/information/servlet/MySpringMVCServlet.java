package com.caimao.information.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: genx
 * @date: 2018/12/20 23:13
 */
public class MySpringMVCServlet extends DispatcherServlet {

    private static Logger logger = LoggerFactory.getLogger(MySpringMVCServlet.class);

    public MySpringMVCServlet() {
        logger.debug("new MySpringMVCServlet()");
    }

    /*
     * HttpServletBean

     public final void init() throws ServletException {
        /..../
        this.initServletBean();
    }

        FrameworkServlet
        protected final void initServletBean() throws ServletException {
            /..../
             this.initFrameworkServlet();
        }

    */
    @Override
    protected void initFrameworkServlet() throws ServletException {
        logger.debug("initFrameworkServlet");
        super.initFrameworkServlet();
    }

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        logger.debug("service");
        super.service(request, response);
    }

    @Override
    public void destroy() {
        logger.debug("destroy");
        super.destroy();
    }


    /**
     * 在 FrameworkServlet 中调用
     * <p>
     * wac.addApplicationListener(new SourceFilteringListener(wac, new FrameworkServlet.ContextRefreshListener()));
     * 注册了事件  来触发这个 onRefresh
     *
     * @param context
     */
    @Override
    protected void onRefresh(ApplicationContext context) {
        logger.debug("onRefresh");

        this.initStrategies(context);
    }

    @Override
    protected void initStrategies(ApplicationContext context) {
        logger.debug("initStrategies");

        super.initStrategies(context);

        /*
        初始化 springmvc 组件

        //文件上传解析，如果请求类型是multipart将通过MultipartResolver进行文件上传解析；
        this.initMultipartResolver(context);

        //本地化解析
        this.initLocaleResolver(context);

        //主题解析
        this.initThemeResolver(context);

        //通过HandlerMapping，将请求映射到处理器
        this.initHandlerMappings(context);

        //通过HandlerAdapter支持多种类型的处理器
        this.initHandlerAdapters(context);

        //如果执行过程中遇到异常将交给HandlerExceptionResolver来解析
        this.initHandlerExceptionResolvers(context);

        //直接解析请求到视图名
        this.initRequestToViewNameTranslator(context);

        //通过ViewResolver解析逻辑视图名到具体视图实现
        this.initViewResolvers(context);

        //flash映射管理器
        this.initFlashMapManager(context);
         */

        logger.debug("initStrategies finish");

        List<HandlerMapping> list = super.getHandlerMappings();
        for (HandlerMapping handlerMapping : list) {
            logger.debug(handlerMapping.getClass().getName());
        }
    }
}
