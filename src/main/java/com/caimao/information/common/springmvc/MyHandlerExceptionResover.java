package com.caimao.information.common.springmvc;

import com.alibaba.fastjson.JSON;
import com.caimao.information.common.ResponseEntity;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @className:MyHandlerExceptionResover.java
 * @classDescription: 全局的异常处理 并记录logger
 * @author:genx
 * @createTime:2017年5月25日 下午3:36:41
 */
@Component
public class MyHandlerExceptionResover implements HandlerExceptionResolver {
    private static Logger logger = LoggerFactory.getLogger(MyHandlerExceptionResover.class);


    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {


        if (handler.getClass().isAssignableFrom(HandlerMethod.class)) {
            if (((HandlerMethod) handler).hasMethodAnnotation(ResponseBody.class)) {
                logger.debug("方法中包含@ResponseBody");
            } else if (((HandlerMethod) handler).getBeanType().isAnnotationPresent(RestController.class)) {
                logger.debug("Controller包含@RestController");
            }
        }

        //把异常信息记入日志
        logger.error("拦截器捕获异常", ex);
        ResponseEntity responseEntity = null;
        try {
            if (ex instanceof MaxUploadSizeExceededException) {
                responseEntity = ResponseEntity.of(HttpStatus.BAD_REQUEST, "上传文件超出最大限制", null);

            } else if (ex instanceof IllegalArgumentException) {
                responseEntity = ResponseEntity.of(HttpStatus.BAD_REQUEST, StringUtils.isNotEmpty(ex.getMessage()) ? ex.getMessage() : "参数错误", null);

            } else {
                responseEntity = ResponseEntity.of(HttpStatus.INTERNAL_SERVER_ERROR, StringUtils.isNotEmpty(ex.getMessage()) && ex.getMessage().length() < 20 ? ex.getMessage() : "内部错误", null);
            }

            if (isResponseBody(handler)) {
                //将错误信息传递给view
                response.setHeader("Cache-Control", "no-cache");
                response.setHeader("Pragma", "no-cache");
                response.setHeader("expires", "0");
                response.setStatus(HttpStatus.OK.value());
                response.setCharacterEncoding("UTF-8");
                response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                response.getWriter().write(JSON.toJSONString(responseEntity));
                response.getWriter().close();
                return null;
            }

            response.sendError(responseEntity.getStatus(), responseEntity.getMsg());
        } catch (Exception e) {
            e.printStackTrace();
        }

        ModelAndView m = new ModelAndView();
        return m;
    }


    private boolean isResponseBody(Object handler) {
        if (handler.getClass().isAssignableFrom(HandlerMethod.class)) {
            if (((HandlerMethod) handler).hasMethodAnnotation(ResponseBody.class)) {
                logger.debug("方法中包含@ResponseBody");
                return true;
            } else if (((HandlerMethod) handler).getBeanType().isAnnotationPresent(RestController.class)) {
                logger.debug("Controller包含@RestController");
                return true;
            }
        }
        return false;
    }
}
