package com.caimao.information.selenium;

import com.alibaba.fastjson.JSON;
import com.caimao.information.entity.StudentJobEntity;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: genx
 * @date: 2018/12/22 20:52
 */
public class Test {




    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver","D:\\github-workspace\\InformationDemo\\documents/chromedriver2.45.exe");//chromedriver服务地址
        WebDriver driver =new ChromeDriver(); //新建一个WebDriver 的对象，但是new 的是FirefoxDriver的驱动

        try {
            StudentJobEntity model = new StudentJobEntity();
            model.setStudentId("154173335");

            ArticleListCheck.check(driver, model);

            ArticleDetailCheck.check(driver, model);

            MatchListCheck.check(driver, model);

            MatchDetailCheck.check(driver, model);

            System.out.println(JSON.toJSONString(model));


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            /**
             * dr.quit()和dr.close()都可以退出浏览器,简单的说一下两者的区别：第一个close，
             * 如果打开了多个页面是关不干净的，它只关闭当前的一个页面。第二个quit，
             * 是退出了所有Webdriver所有的窗口，退的非常干净，所以推荐使用quit最为一个case退出的方法。
             */
            driver.quit();//退出浏览器
        }


    }
}
