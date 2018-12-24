package com.caimao.information.selenium;

import com.caimao.information.entity.StudentJobEntity;
import org.apache.commons.codec.digest.DigestUtils;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: genx
 * @date: 2018/12/24 13:12
 */
public class ArticleDetailCheck {

    public static void check(WebDriver driver, StudentJobEntity studentJobEntity) throws InterruptedException, IOException {

        driver.get(CheckUtil.baseUrl + studentJobEntity.getStudentId() + "/articleDetail.html?id=78345");

        Thread.sleep(3000);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);


        String html = driver.getPageSource();

        if (CheckUtil.isNotFind(html)) {
            //404
            return;
        }

        studentJobEntity.setArticleDetailMd5(CheckUtil.md5(html));


        if (studentJobEntity.getArticleDetailData().doubleValue() < 1) {
            if (html.contains("马尔卡宁31+4公牛轻取骑士")) {
                studentJobEntity.setArticleDetailData(new BigDecimal("1"));
            }
        }

    }
}
