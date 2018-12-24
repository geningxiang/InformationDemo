package com.caimao.information.selenium;

import com.caimao.information.entity.StudentJobEntity;
import org.apache.commons.codec.digest.DigestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: genx
 * @date: 2018/12/24 13:17
 */
public class MatchListCheck {
    private static Logger logger = LoggerFactory.getLogger(MatchListCheck.class);

    public static void check(WebDriver driver, StudentJobEntity studentJobEntity) throws InterruptedException, IOException {
        driver.get(CheckUtil.baseUrl + studentJobEntity.getStudentId() + "/matchList.html");

        Thread.sleep(5000);

        String matchListUrl = driver.getCurrentUrl();
        String html = driver.getPageSource();

        if (CheckUtil.isNotFind(html)) {
            //404
            return;
        }


        studentJobEntity.setMatchListMd5(CheckUtil.md5(html));

        if (studentJobEntity.getMatchListData().doubleValue() < 1) {
            //内容是否完整
            Set<String> matchList = SportsApi.getMatchList();
            if (matchList != null && matchList.size() > 0) {
                int mate = 0;
                for (String s : matchList) {
                    if (html.contains(s)) {
                        mate++;
                    } else {
                        logger.warn("【比赛列表未找到关键字】{}", s);
                    }
                }
                studentJobEntity.setMatchListData((new BigDecimal(mate).divide(new BigDecimal(matchList.size()), 4, BigDecimal.ROUND_HALF_UP)));
            }
        }


        if (studentJobEntity.getMatchListEvent().doubleValue() < 1) {

            List<WebElement> imgs = driver.findElements(By.tagName("img"));
            if (imgs != null && imgs.size() > 0) {
                imgs.get(1).click();

                driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
                if (!matchListUrl.equals(driver.getCurrentUrl())) {
                    studentJobEntity.setMatchListEvent(new BigDecimal("1"));
                }
            }
        }
    }
}
