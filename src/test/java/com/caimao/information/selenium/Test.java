package com.caimao.information.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: genx
 * @date: 2018/12/22 20:52
 */
public class Test {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","D:/Program Files/Python36/chromedriver.exe");//chromedriver服务地址
        WebDriver driver =new ChromeDriver(); //新建一个WebDriver 的对象，但是new 的是FirefoxDriver的驱动

        driver.get("http://47.100.63.232/154173335/articleList.html");//打开指定的网站



//        driver.findElement(By.id("kw")).sendKeys(new  String[] {"hello"});//找到kw元素的id，然后输入hello
//        driver.findElement(By.id("su")).click(); //点击按扭

//        try {
//            /**
//             * WebDriver自带了一个智能等待的方法。
//             dr.manage().timeouts().implicitlyWait(arg0, arg1）；
//             Arg0：等待的时间长度，int 类型 ；
//             Arg1：等待时间的单位 TimeUnit.SECONDS 一般用秒作为单位。
//             */
//            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



        WebElement sortHeader = driver.findElement(By.id("sort-header"));



        WebElement articleUl = driver.findElement(By.id("article-ul"));

        System.out.println(articleUl.getText());


        /**
         * dr.quit()和dr.close()都可以退出浏览器,简单的说一下两者的区别：第一个close，
         * 如果打开了多个页面是关不干净的，它只关闭当前的一个页面。第二个quit，
         * 是退出了所有Webdriver所有的窗口，退的非常干净，所以推荐使用quit最为一个case退出的方法。
         */
        driver.quit();//退出浏览器
    }
}
