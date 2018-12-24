package com.caimao.information.service.impl;

import com.alibaba.fastjson.JSON;
import com.caimao.information.entity.StudentJobEntity;
import com.caimao.information.selenium.ArticleDetailCheck;
import com.caimao.information.selenium.ArticleListCheck;
import com.caimao.information.selenium.MatchDetailCheck;
import com.caimao.information.selenium.MatchListCheck;
import com.caimao.information.service.IStudentJobService;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: genx
 * @date: 2018/12/22 21:37
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/spring/*.xml"})
public class StudentJobServiceImplTest {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private IStudentJobService studentJobService;

    @Test
    public void getModel() {
    }

    @Test
    public void save() {

    }

    @Test
    public void update() {
    }

    @Test
    public void deleteById() {
    }


    @Test
    public void buildTable() {
        StringBuilder sb = new StringBuilder(10240);
        sb.append("\r\n");
        List<StudentJobEntity> list = studentJobService.getList();
        for (StudentJobEntity model : list) {
            sb.append("<tr>");

            sb.append("<td>").append(model.getStudentId()).append("</td>");
            if(StringUtils.isNotEmpty(model.getArticleListMd5())) {
                sb.append("<td>").append("<a href=\"/").append(model.getStudentId()).append("/articleList.html\" target=\"_blank\">点击跳转</a>").append("</td>");
                sb.append("<td>").append(model.getArticleListData().multiply(new BigDecimal("100")).doubleValue()).append("%</td>");
                sb.append("<td>").append(model.getArticleListSortEvent().intValue() == 1 ? "有" : "无").append("</td>");
                sb.append("<td>").append(model.getArticleListEvent().intValue() == 1 ? "有" : "无").append("</td>");
            } else {
                sb.append("<td>-</td><td>-</td><td>-</td><td>-</td>");
            }


            if(StringUtils.isNotEmpty(model.getArticleDetailMd5())) {
                sb.append("<td>").append("<a href=\"/").append(model.getStudentId()).append("/articleDetail.html?id=78345\" target=\"_blank\">点击跳转</a>").append("</td>");
                sb.append("<td>").append(model.getArticleDetailData().intValue() == 1 ? "准确" : "不准确").append("</td>");
            } else {
                sb.append("<td>-</td><td>-</td>");
            }

            if(StringUtils.isNotEmpty(model.getMatchListMd5())) {
                sb.append("<td>").append("<a href=\"/").append(model.getStudentId()).append("/matchList.html\" target=\"_blank\">点击跳转</a>").append("</td>");
                sb.append("<td>").append(model.getMatchListData().multiply(new BigDecimal("100")).doubleValue()).append("%</td>");
                sb.append("<td>").append(model.getMatchListEvent().intValue() == 1 ? "有" : "无").append("</td>");
            } else {
                sb.append("<td>-</td><td>-</td><td>-</td>");
            }

            if(StringUtils.isNotEmpty(model.getMatchDetailMd5())) {
                sb.append("<td>").append("<a href=\"/").append(model.getStudentId()).append("/matchDetail.html?mid=1135445\" target=\"_blank\">点击跳转</a>").append("</td>");
                sb.append("<td>").append(model.getMatchDetailData().multiply(new BigDecimal("100")).doubleValue()).append("%</td>");
            } else {
                sb.append("<td>-</td><td>-</td>");
            }
            sb.append("</tr>\r\n");
        }
        System.out.println(sb.toString());
    }

        @Test
    public void doCheck() {

        System.setProperty("webdriver.chrome.driver", "D:\\github-workspace\\InformationDemo\\documents/chromedriver2.45.exe");//chromedriver服务地址
        WebDriver driver = new ChromeDriver(); //新建一个WebDriver 的对象，但是new 的是FirefoxDriver的驱动

        try {



            List<StudentJobEntity> list = studentJobService.getList();
            for (StudentJobEntity model : list) {
                logger.info(JSON.toJSONString(model));

                ArticleListCheck.check(driver, model);

                ArticleDetailCheck.check(driver, model);

                MatchListCheck.check(driver, model);

                MatchDetailCheck.check(driver, model);

                studentJobService.update(model);

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            /**
             * dr.quit()和dr.close()都可以退出浏览器,简单的说一下两者的区别：第一个close，
             * 如果打开了多个页面是关不干净的，它只关闭当前的一个页面。第二个quit，
             * 是退出了所有Webdriver所有的窗口，退的非常干净，所以推荐使用quit最为一个case退出的方法。
             */
            driver.quit();//退出浏览器
        }
    }
}