package com.caimao.information.selenium;

import com.caimao.information.entity.StudentJobEntity;
import org.apache.commons.codec.digest.DigestUtils;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: genx
 * @date: 2018/12/24 13:47
 */
public class MatchDetailCheck {
    private static Logger logger = LoggerFactory.getLogger(MatchDetailCheck.class);

    //TODO 暂时用写死的检测吧
    private static int mid = 1135445;

    private static String[] keywords = {"哈里·凯恩", "利物浦", "埃因霍温", "沃尔科特", "阿森纳", "理查利森", "水晶宫", "国际米兰", "南安普敦", "切尔西", "沃特福德", "穆萨·西索科", "拉梅拉", "卢卡斯", "曼联", "西古德森", "伯恩茅斯", "埃弗顿", "曼城", "布赖顿", "孙兴慜", "热刺", "特里皮尔", "英超", "安德烈·戈麦斯", "球会友谊", "托松", "欧冠杯", "斯基普", "纽卡斯尔", "狼队", "托特纳姆热刺", "加的夫城", "高玛希亚", "施奈德林", "贝尔纳德", "英联杯", "伯恩利", "莱切斯特", "埃里克森", "阿里", "巴萨"};

    public static void check(WebDriver driver, StudentJobEntity studentJobEntity) throws InterruptedException, IOException {
        driver.get(CheckUtil.baseUrl + studentJobEntity.getStudentId() + "/matchDetail.html?mid=" + mid);

        Thread.sleep(5000);

        String html = driver.getPageSource();

        if (CheckUtil.isNotFind(html)) {
            //404
            return;
        }

        studentJobEntity.setMatchDetailMd5(CheckUtil.md5(html));


        if (studentJobEntity.getMatchDetailData().doubleValue() < 1) {


            int mate = 0;
            for (String s : keywords) {
                if (html.contains(s)) {
                    mate++;
                } else {
                    logger.warn("【比赛详情未找到关键字】{}", s);
                }
            }
            studentJobEntity.setMatchDetailData((new BigDecimal(mate).divide(new BigDecimal(keywords.length), 4, BigDecimal.ROUND_HALF_UP)));

        }
    }
}
