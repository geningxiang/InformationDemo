package com.caimao.information.selenium;

import com.caimao.information.entity.StudentJobEntity;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
 * @date: 2018/12/24 12:18
 */
public class ArticleListCheck {

    public static void check(WebDriver driver, StudentJobEntity studentJobEntity) throws InterruptedException, IOException {

        driver.get(CheckUtil.baseUrl + studentJobEntity.getStudentId() + "/articleList.html");

        Thread.sleep(5000);
        //driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        String articleListUrl = driver.getCurrentUrl();
        String html = driver.getPageSource();

        if (CheckUtil.isNotFind(html)) {
            //404
            return;
        }


        studentJobEntity.setArticleListMd5(CheckUtil.md5(html));

        try {
            WebElement articleUl = driver.findElement(By.id("article-ul"));
            if (articleUl != null) {
                String articleUlText = articleUl.getText();
                if (studentJobEntity.getArticleListData().doubleValue() < 1) {
                    //内容是否完整
                    Set<String> articleList = SportsApi.getArticleList();
                    if (articleList != null && articleList.size() > 0) {
                        int mate = 0;
                        for (String s : articleList) {
                            if (articleUlText.contains(s)) {
                                mate++;
                            }
                        }
                        studentJobEntity.setArticleListData(new BigDecimal(mate).divide(new BigDecimal(articleList.size()), 4, BigDecimal.ROUND_HALF_UP));
                    }
                }

                if (studentJobEntity.getArticleListSortEvent().doubleValue() < 1) {
                    //栏位的点击事件
                    List<WebElement> spans = driver.findElements(By.cssSelector("#sort-header span"));
                    if (spans != null && spans.size() > 1) {
                        spans.get(1).click();

                        Thread.sleep(1000);
                        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
                        String articleUlText2 = driver.findElement(By.id("article-ul")).getText();
                        if (!articleUlText.equals(articleUlText2)) {
                            studentJobEntity.setArticleListSortEvent(new BigDecimal("1"));
                        }
                    }
                }
            }


            if (studentJobEntity.getArticleListEvent().doubleValue() < 1) {
                WebElement li = driver.findElement(By.cssSelector("#article-ul li"));
                if (li != null) {
                    li.click();
                    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
                    if (!articleListUrl.equals(driver.getCurrentUrl())) {
                        studentJobEntity.setArticleListEvent(new BigDecimal("1"));
                    }

                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
