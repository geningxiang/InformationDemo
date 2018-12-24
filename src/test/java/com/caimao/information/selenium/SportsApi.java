package com.caimao.information.selenium;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.caimao.information.common.base.Charsets;
import com.caimao.information.common.http.HttpRequest;
import com.caimao.information.common.http.HttpResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: genx
 * @date: 2018/12/24 12:30
 */
public class SportsApi {

    //https://sports.fcaimao.com/interface.do?jsonpcallback=jQuery33106203254072746525_1545625743170&fn=3001&sortId=2&maxId=0&limit=20&_=1545625743172

    public static Set<String> getArticleList() throws IOException {
        Set<String> list = new HashSet<>();
        HttpResponse response = new HttpRequest().doRequest("http://sports.fcaimao.com/interface.do?fn=3001&sortId=2&maxId=0&limit=20", null);
        if (response.isSuccessful()) {
            JSONObject json = JSON.parseObject(response.getBody(Charsets.UTF_8));
            JSONArray data = json.getJSONArray("data");
            for (int i = 0; i < data.size(); i++) {
                JSONObject item = data.getJSONObject(i);
                list.add(item.getString("title"));
            }
        }
        return list;
    }

    public static Set<String> getMatchList() throws IOException {
        Set<String> lst = new HashSet<>();
        HttpResponse response = new HttpRequest().doRequest("http://sports.fcaimao.com/interface.do?fn=3103", null);
        if (response.isSuccessful()) {
            JSONObject json = JSON.parseObject(response.getBody(Charsets.UTF_8));
            JSONArray list = json.getJSONArray("list");
            for (int i = 0; i < list.size(); i++) {
                JSONObject item = list.getJSONObject(i);
                lst.add(item.getString("lname"));
                lst.add(item.getString("hostName"));
                lst.add(item.getString("guestName"));
                lst.add(item.getString("issueNo"));
            }
        }
        return lst;
    }

    public static Set<String> getMatchDetailKeyWords() throws IOException {
        Set<String> lst = new HashSet<>();

        return lst;
    }

    public static void main(String[] args) {
        Set<String> set = new HashSet<>(
        );
        String str = "{\"flag\":1,\"data\":{\"shootTarget\":\"3,8\",\"cornerNum\":\"2,1\",\"yellowCard\":\"0,2\",\"mid\":1135445,\"controlTime\":\"41%,59%\",\"saveNum\":\"2,1\",\"id\":336025,\"shootNum\":\"8,16\",\"offsideNum\":\"4,2\",\"foulNum\":\"13,9\"},\"errorMessage\":\"\",\"event\":[{\"act\":\"1\",\"eventName\":\"换人\",\"time\":\"83'\",\"event\":\"7\",\"userName\":\"卢卡斯|穆萨·西索科\"},{\"act\":\"0\",\"eventName\":\"换人\",\"time\":\"83'\",\"event\":\"7\",\"userName\":\"托松|西古德森\"},{\"act\":\"1\",\"eventName\":\"换人\",\"time\":\"79'\",\"event\":\"7\",\"userName\":\"斯基普|孙兴慜\"},{\"act\":\"0\",\"eventName\":\"换人\",\"time\":\"75'\",\"event\":\"7\",\"userName\":\"贝尔纳德|理查利森\"},{\"act\":\"1\",\"eventName\":\"入球\",\"time\":\"74'\",\"event\":\"1\",\"userName\":\"哈里·凯恩\"},{\"act\":\"1\",\"eventName\":\"黄牌\",\"time\":\"71'\",\"event\":\"4\",\"userName\":\"埃里克森\"},{\"act\":\"1\",\"eventName\":\"入球\",\"time\":\"61'\",\"event\":\"1\",\"userName\":\"孙兴慜\"},{\"act\":\"0\",\"eventName\":\"换人\",\"time\":\"53'\",\"event\":\"7\",\"userName\":\"施奈德林|安德烈·戈麦斯\"},{\"act\":\"0\",\"eventName\":\"入球\",\"time\":\"51'\",\"event\":\"1\",\"userName\":\"西古德森\"},{\"act\":\"1\",\"eventName\":\"入球\",\"time\":\"48'\",\"event\":\"1\",\"userName\":\"埃里克森\"},{\"act\":\"1\",\"eventName\":\"换人\",\"time\":\"46'\",\"event\":\"7\",\"userName\":\"拉梅拉|阿里\"},{\"act\":\"1\",\"eventName\":\"入球\",\"time\":\"42'\",\"event\":\"1\",\"userName\":\"哈里·凯恩\"},{\"act\":\"1\",\"eventName\":\"入球\",\"time\":\"35'\",\"event\":\"1\",\"userName\":\"阿里\"},{\"act\":\"1\",\"eventName\":\"黄牌\",\"time\":\"32'\",\"event\":\"4\",\"userName\":\"特里皮尔\"},{\"act\":\"1\",\"eventName\":\"入球\",\"time\":\"27'\",\"event\":\"1\",\"userName\":\"孙兴慜\"},{\"act\":\"0\",\"eventName\":\"入球\",\"time\":\"21'\",\"event\":\"1\",\"userName\":\"沃尔科特\"}],\"timestamp\":\"2018-12-24 13:49:35\"}";
        JSONObject json = JSON.parseObject(str);
        JSONArray data = json.getJSONArray("event");

        for (int i = 0; i < data.size(); i++) {
            JSONObject item = data.getJSONObject(i);
            String[] ss = item.getString("userName").split("\\|");
            for (String s : ss) {
                set.add(s);
            }
        }
        System.out.println(set);


        str = "{\"nearGuest\":{\"matchs\":[{\"hostName\":\"阿森纳\",\"lname\":\"英联杯\",\"goal\":\"0-2\",\"lcolor\":\"fb4253\",\"lid\":5,\"midBifen\":\"0-1\",\"hostId\":493,\"matchTime\":\"2018-12-20 03:45:00\",\"idx\":1,\"guestId\":157,\"guestName\":\"热刺\"},{\"hostName\":\"热刺\",\"lname\":\"英超\",\"goal\":\"1-0\",\"lcolor\":\"F90000\",\"lid\":20,\"midBifen\":\"0-0\",\"hostId\":157,\"matchTime\":\"2018-12-15 23:00:00\",\"idx\":2,\"guestId\":448,\"guestName\":\"伯恩利\"},{\"hostName\":\"巴萨\",\"lname\":\"欧冠杯\",\"goal\":\"1-1\",\"lcolor\":\"8D7321\",\"lid\":12,\"midBifen\":\"1-0\",\"hostId\":462,\"matchTime\":\"2018-12-12 04:00:00\",\"idx\":3,\"guestId\":157,\"guestName\":\"热刺\"},{\"hostName\":\"莱切斯特\",\"lname\":\"英超\",\"goal\":\"0-2\",\"lcolor\":\"F90000\",\"lid\":20,\"midBifen\":\"0-1\",\"hostId\":260,\"matchTime\":\"2018-12-09 03:45:00\",\"idx\":4,\"guestId\":157,\"guestName\":\"热刺\"},{\"hostName\":\"热刺\",\"lname\":\"英超\",\"goal\":\"3-1\",\"lcolor\":\"F90000\",\"lid\":20,\"midBifen\":\"1-0\",\"hostId\":157,\"matchTime\":\"2018-12-06 04:00:00\",\"idx\":5,\"guestId\":22,\"guestName\":\"南安普敦\"},{\"hostName\":\"阿森纳\",\"lname\":\"英超\",\"goal\":\"4-2\",\"lcolor\":\"F90000\",\"lid\":20,\"midBifen\":\"1-2\",\"hostId\":493,\"matchTime\":\"2018-12-02 22:05:00\",\"idx\":6,\"guestId\":157,\"guestName\":\"热刺\"},{\"hostName\":\"热刺\",\"lname\":\"欧冠杯\",\"goal\":\"1-0\",\"lcolor\":\"8D7321\",\"lid\":12,\"midBifen\":\"0-0\",\"hostId\":157,\"matchTime\":\"2018-11-29 04:00:00\",\"idx\":7,\"guestId\":334,\"guestName\":\"国际米兰\"},{\"hostName\":\"热刺\",\"lname\":\"英超\",\"goal\":\"3-1\",\"lcolor\":\"F90000\",\"lid\":20,\"midBifen\":\"2-0\",\"hostId\":157,\"matchTime\":\"2018-11-25 01:30:00\",\"idx\":8,\"guestId\":401,\"guestName\":\"切尔西\"},{\"hostName\":\"水晶宫\",\"lname\":\"英超\",\"goal\":\"0-1\",\"lcolor\":\"F90000\",\"lid\":20,\"midBifen\":\"0-0\",\"hostId\":100,\"matchTime\":\"2018-11-11 01:30:00\",\"idx\":9,\"guestId\":157,\"guestName\":\"热刺\"},{\"hostName\":\"热刺\",\"lname\":\"欧冠杯\",\"goal\":\"2-1\",\"lcolor\":\"8D7321\",\"lid\":12,\"midBifen\":\"0-1\",\"hostId\":157,\"matchTime\":\"2018-11-07 04:00:00\",\"idx\":10,\"guestId\":514,\"guestName\":\"埃因霍温\"}],\"bifenInfo\":\"8-1-1-80.00\",\"name\":\"热刺\",\"id\":157},\"flag\":1,\"nearHost\":{\"matchs\":[{\"hostName\":\"曼城\",\"lname\":\"英超\",\"goal\":\"3-1\",\"lcolor\":\"F90000\",\"lid\":20,\"midBifen\":\"1-0\",\"hostId\":213,\"matchTime\":\"2018-12-15 20:30:00\",\"idx\":1,\"guestId\":481,\"guestName\":\"埃弗顿\"},{\"hostName\":\"埃弗顿\",\"lname\":\"英超\",\"goal\":\"2-2\",\"lcolor\":\"F90000\",\"lid\":20,\"midBifen\":\"1-0\",\"hostId\":481,\"matchTime\":\"2018-12-11 04:00:00\",\"idx\":2,\"guestId\":158,\"guestName\":\"沃特福德\"},{\"hostName\":\"埃弗顿\",\"lname\":\"英超\",\"goal\":\"1-1\",\"lcolor\":\"F90000\",\"lid\":20,\"midBifen\":\"1-1\",\"hostId\":481,\"matchTime\":\"2018-12-06 03:45:00\",\"idx\":3,\"guestId\":178,\"guestName\":\"纽卡斯尔\"},{\"hostName\":\"利物浦\",\"lname\":\"英超\",\"goal\":\"1-0\",\"lcolor\":\"F90000\",\"lid\":20,\"midBifen\":\"0-0\",\"hostId\":247,\"matchTime\":\"2018-12-03 00:15:00\",\"idx\":4,\"guestId\":481,\"guestName\":\"埃弗顿\"},{\"hostName\":\"埃弗顿\",\"lname\":\"英超\",\"goal\":\"1-0\",\"lcolor\":\"F90000\",\"lid\":20,\"midBifen\":\"0-0\",\"hostId\":481,\"matchTime\":\"2018-11-24 23:00:00\",\"idx\":5,\"guestId\":293,\"guestName\":\"加的夫城\"},{\"hostName\":\"切尔西\",\"lname\":\"英超\",\"goal\":\"0-0\",\"lcolor\":\"F90000\",\"lid\":20,\"midBifen\":\"0-0\",\"hostId\":401,\"matchTime\":\"2018-11-11 22:15:00\",\"idx\":6,\"guestId\":481,\"guestName\":\"埃弗顿\"},{\"hostName\":\"埃弗顿\",\"lname\":\"球会友谊\",\"goal\":\"4-0\",\"lcolor\":\"5691D8\",\"lid\":83,\"midBifen\":\"2-0\",\"hostId\":481,\"matchTime\":\"2018-11-07 03:00:00\",\"idx\":7,\"guestId\":9028,\"guestName\":\"高玛希亚\"},{\"hostName\":\"埃弗顿\",\"lname\":\"英超\",\"goal\":\"3-1\",\"lcolor\":\"F90000\",\"lid\":20,\"midBifen\":\"1:1\",\"hostId\":481,\"matchTime\":\"2018-11-03 23:00:00\",\"idx\":8,\"guestId\":455,\"guestName\":\"布赖顿\"},{\"hostName\":\"曼联\",\"lname\":\"英超\",\"goal\":\"2-1\",\"lcolor\":\"F90000\",\"lid\":20,\"midBifen\":\"1-0\",\"hostId\":212,\"matchTime\":\"2018-10-28 23:59:00\",\"idx\":9,\"guestId\":481,\"guestName\":\"埃弗顿\"},{\"hostName\":\"埃弗顿\",\"lname\":\"英超\",\"goal\":\"2-0\",\"lcolor\":\"F90000\",\"lid\":20,\"midBifen\":\"0-0\",\"hostId\":481,\"matchTime\":\"2018-10-21 23:00:00\",\"idx\":10,\"guestId\":100,\"guestName\":\"水晶宫\"}],\"bifenInfo\":\"4-3-3-40.00\",\"name\":\"埃弗顿\",\"id\":481},\"errorMessage\":\"\",\"match\":{\"hostName\":\"埃弗顿\",\"guestGoal\":6,\"lid\":20,\"midBifen\":\"1-3\",\"memo\":\"广东电视体育频道<br>上海体育<br>北京体育<br>ASTRO SUPERSPORT 3<br>(HD) mio Stadium<br>韩国SPO电视台2<br>香港NOW621台<br>Astro SuperSport 3 HD<br>mio Stadium<br>beIN Sports 1 (Indovision)\",\"hs\":\"1.07\",\"sid\":0,\"guestName\":\"热刺\",\"hostGoal\":2,\"weather\":\"2\",\"statusName\":\"结束\",\"id\":1135445,\"guestId\":157,\"tem\":\"3℃～4℃\",\"hostLogo\":\"http://img1.fcaimao.com/logo/fteam/4/t_481.png\",\"hpm\":\"11\",\"gpm\":\"3\",\"guestLogo\":\"http://img1.fcaimao.com/logo/fteam/1/t_157.png\",\"hostId\":481,\"matchTime\":\"2018-12-23 23:59:00\",\"gs\":\"0.86\",\"guestRed\":0,\"hostRed\":0,\"matchIndex\":\"18\",\"rq\":\"-0.25\",\"status\":20},\"history\":{\"spf\":\"0|3|3\",\"list\":[{\"bet\":\"1.75\",\"hostName\":\"托特纳姆热刺\",\"ln\":\"英超\",\"guestGoal\":0,\"hostGoal\":4,\"midBifen\":\"1-0\",\"binfo\":\"赢\",\"hostId\":157,\"matchTime\":\"2018-01-14 01:30:00\",\"idx\":1,\"guestId\":481,\"guestName\":\"埃弗顿\"},{\"bet\":\"-0.25\",\"hostName\":\"埃弗顿\",\"ln\":\"英超\",\"guestGoal\":3,\"hostGoal\":0,\"midBifen\":\"0-2\",\"binfo\":\"输\",\"hostId\":481,\"matchTime\":\"2017-09-09 22:00:00\",\"idx\":2,\"guestId\":157,\"guestName\":\"托特纳姆热刺\"},{\"bet\":\"0.75\",\"hostName\":\"托特纳姆热刺\",\"ln\":\"英超\",\"guestGoal\":2,\"hostGoal\":3,\"midBifen\":\"1-0\",\"binfo\":\"赢\",\"hostId\":157,\"matchTime\":\"2017-03-05 21:30:00\",\"idx\":3,\"guestId\":481,\"guestName\":\"埃弗顿\"},{\"bet\":\"-0.25\",\"hostName\":\"埃弗顿\",\"ln\":\"英超\",\"guestGoal\":1,\"hostGoal\":1,\"midBifen\":\"1-0\",\"binfo\":\"赢\",\"hostId\":481,\"matchTime\":\"2016-08-13 22:00:00\",\"idx\":4,\"guestId\":157,\"guestName\":\"托特纳姆热刺\"},{\"bet\":\"0\",\"hostName\":\"埃弗顿\",\"ln\":\"英超\",\"guestGoal\":1,\"hostGoal\":1,\"midBifen\":\"1-1\",\"binfo\":\"走\",\"hostId\":481,\"matchTime\":\"2016-01-03 23:59:00\",\"idx\":5,\"guestId\":157,\"guestName\":\"托特纳姆热刺\"},{\"bet\":\"0.5\",\"hostName\":\"托特纳姆热刺\",\"ln\":\"英超\",\"guestGoal\":0,\"hostGoal\":0,\"midBifen\":\"0-0\",\"binfo\":\"输\",\"hostId\":157,\"matchTime\":\"2015-08-30 00:30:00\",\"idx\":6,\"guestId\":481,\"guestName\":\"埃弗顿\"}]},\"futureHost\":{\"matchs\":[{\"hostName\":\"埃弗顿\",\"lname\":\"英超\",\"lcolor\":\"F90000\",\"lid\":20,\"hostId\":481,\"matchTime\":\"2018-12-23 23:59:00\",\"idx\":1,\"guestId\":157,\"guestName\":\"热刺\"},{\"hostName\":\"伯恩利\",\"lname\":\"英超\",\"lcolor\":\"F90000\",\"lid\":20,\"hostId\":448,\"matchTime\":\"2018-12-26 23:00:00\",\"idx\":2,\"guestId\":481,\"guestName\":\"埃弗顿\"},{\"hostName\":\"布赖顿\",\"lname\":\"英超\",\"lcolor\":\"F90000\",\"lid\":20,\"hostId\":455,\"matchTime\":\"2018-12-29 23:00:00\",\"idx\":3,\"guestId\":481,\"guestName\":\"埃弗顿\"},{\"hostName\":\"埃弗顿\",\"lname\":\"英超\",\"lcolor\":\"F90000\",\"lid\":20,\"hostId\":481,\"matchTime\":\"2019-01-03 23:00:00\",\"idx\":4,\"guestId\":260,\"guestName\":\"莱切斯特\"},{\"hostName\":\"埃弗顿\",\"lname\":\"英超\",\"lcolor\":\"F90000\",\"lid\":20,\"hostId\":481,\"matchTime\":\"2019-01-12 23:00:00\",\"idx\":5,\"guestId\":571,\"guestName\":\"伯恩茅斯\"},{\"hostName\":\"南安普敦\",\"lname\":\"英超\",\"lcolor\":\"F90000\",\"lid\":20,\"hostId\":22,\"matchTime\":\"2019-01-19 23:00:00\",\"idx\":6,\"guestId\":481,\"guestName\":\"埃弗顿\"}],\"name\":\"埃弗顿\",\"id\":481},\"timestamp\":\"2018-12-24 13:54:51\",\"futureGuest\":{\"matchs\":[{\"hostName\":\"埃弗顿\",\"lname\":\"英超\",\"lcolor\":\"F90000\",\"lid\":20,\"hostId\":481,\"matchTime\":\"2018-12-23 23:59:00\",\"idx\":1,\"guestId\":157,\"guestName\":\"热刺\"},{\"hostName\":\"热刺\",\"lname\":\"英超\",\"lcolor\":\"F90000\",\"lid\":20,\"hostId\":157,\"matchTime\":\"2018-12-26 23:00:00\",\"idx\":2,\"guestId\":571,\"guestName\":\"伯恩茅斯\"},{\"hostName\":\"热刺\",\"lname\":\"英超\",\"lcolor\":\"F90000\",\"lid\":20,\"hostId\":157,\"matchTime\":\"2018-12-29 23:00:00\",\"idx\":3,\"guestId\":267,\"guestName\":\"狼队\"},{\"hostName\":\"加的夫城\",\"lname\":\"英超\",\"lcolor\":\"F90000\",\"lid\":20,\"hostId\":293,\"matchTime\":\"2019-01-03 23:00:00\",\"idx\":4,\"guestId\":157,\"guestName\":\"热刺\"},{\"hostName\":\"热刺\",\"lname\":\"英超\",\"lcolor\":\"F90000\",\"lid\":20,\"hostId\":157,\"matchTime\":\"2019-01-12 23:00:00\",\"idx\":5,\"guestId\":212,\"guestName\":\"曼联\"},{\"hostName\":\"富勒姆\",\"lname\":\"英超\",\"lcolor\":\"F90000\",\"lid\":20,\"hostId\":359,\"matchTime\":\"2019-01-19 23:00:00\",\"idx\":6,\"guestId\":157,\"guestName\":\"热刺\"}],\"name\":\"热刺\",\"id\":157}}";
        System.out.println(str);

        json = JSON.parseObject(str);

        JSONArray historys = json.getJSONObject("history").getJSONArray("list");
        for (int i = 0; i < historys.size(); i++) {
            JSONObject item = historys.getJSONObject(i);
            set.add(item.getString("ln"));
            set.add(item.getString("hostName"));
            set.add(item.getString("guestName"));
        }


        JSONArray nears = json.getJSONObject("nearHost").getJSONArray("matchs");
        for (int i = 0; i < nears.size(); i++) {
            JSONObject item = nears.getJSONObject(i);
            set.add(item.getString("lname"));
            set.add(item.getString("hostName"));
            set.add(item.getString("guestName"));
        }

        nears = json.getJSONObject("nearGuest").getJSONArray("matchs");
        for (int i = 0; i < nears.size(); i++) {
            JSONObject item = nears.getJSONObject(i);
            set.add(item.getString("lname"));
            set.add(item.getString("hostName"));
            set.add(item.getString("guestName"));
        }

        JSONArray futures = json.getJSONObject("futureHost").getJSONArray("matchs");

        for (int i = 0; i < futures.size(); i++) {
            JSONObject item = futures.getJSONObject(i);
            set.add(item.getString("lname"));
            set.add(item.getString("hostName"));
            set.add(item.getString("guestName"));
        }

        futures = json.getJSONObject("futureGuest").getJSONArray("matchs");
        for (int i = 0; i < futures.size(); i++) {
            JSONObject item = futures.getJSONObject(i);
            set.add(item.getString("lname"));
            set.add(item.getString("hostName"));
            set.add(item.getString("guestName"));
        }

        StringBuilder sb = new StringBuilder();
        for (String s : set) {
            sb.append("\"").append(s).append("\",");
        }
        System.out.println(sb);
    }
}
