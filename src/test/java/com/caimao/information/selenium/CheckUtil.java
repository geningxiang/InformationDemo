package com.caimao.information.selenium;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: genx
 * @date: 2018/12/24 12:20
 */
public class CheckUtil {
    public static final String baseUrl = "http://47.100.63.232/";


    public static boolean isNotFind(String html){
        if(html.contains("404 Not Found")){
            return true;
        }
        return false;
    }

    public static String md5(String html) {
//        String dest = "";
//        if (html != null) {
//            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
//            Matcher m = p.matcher(html);
//            dest = m.replaceAll("");
//        }
        return DigestUtils.md2Hex(html);
    }


}

