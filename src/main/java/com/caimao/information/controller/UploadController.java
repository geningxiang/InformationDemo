package com.caimao.information.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: genx
 * @date: 2018/12/24 16:17
 */
@Controller
@RequestMapping("/")
public class UploadController {

    /**
     * 上传压缩文件
     */
    @RequestMapping(value = "/upload.do", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String uploadPushContent(MultipartFile filedata, HttpSession session, HttpServletRequest request) {

        System.out.println(filedata.getContentType());

        //application/x-zip-compressed
        //application/octet-stream

        System.out.println(filedata.getOriginalFilename());

        return "test";
    }

}
