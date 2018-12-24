package com.caimao.information.entity;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: genx
 * @date: 2018/12/22 21:25
 */
public class StudentJobEntity1 {
    private String studentId;
    private String articleListMd5;


    /**
     * 资讯列表 数据实时度
     */
    private Double articleListData = 0d;
    /**
     * 资讯列表 栏位点击事件
     */
    private Double articleListSortEvent = 0d;

    /**
     * 资讯列表 单条元素的点击事件
     */
    private Double articleListItemEvent = 0d;


    /**
     * 资讯详情
     */
    private String articleDetailMd5;

    /**
     * 资讯详情的内容完整度
     */
    private Double articleDetailData = 0d;


    /**
     * 比赛列表 的MD5
     */
    private String matchListMd5;

    /**
     * 比赛列表数据 完整度
     */
    private Double matchListData = 0d;

    /**
     * 比赛列表 单条的点击事件
     */
    private Double matchListEvent = 0d;


    private String matchDetailMd5;

    private Double matchDetailData = 0d;

    public String getMatchListMd5() {
        return matchListMd5;
    }

    public void setMatchListMd5(String matchListMd5) {
        this.matchListMd5 = matchListMd5;
    }

    public Double getMatchListData() {
        return matchListData;
    }

    public void setMatchListData(Double matchListData) {
        this.matchListData = matchListData;
    }

    public Double getMatchListEvent() {
        return matchListEvent;
    }

    public void setMatchListEvent(Double matchListEvent) {
        this.matchListEvent = matchListEvent;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getArticleListMd5() {
        return articleListMd5;
    }

    public void setArticleListMd5(String articleListMd5) {
        this.articleListMd5 = articleListMd5;
    }

    public Double getArticleListData() {
        return articleListData;
    }

    public void setArticleListData(Double articleListData) {
        this.articleListData = articleListData;
    }

    public Double getArticleListSortEvent() {
        return articleListSortEvent;
    }

    public void setArticleListSortEvent(Double articleListSortEvent) {
        this.articleListSortEvent = articleListSortEvent;
    }

    public Double getArticleListItemEvent() {
        return articleListItemEvent;
    }

    public void setArticleListItemEvent(Double articleListItemEvent) {
        this.articleListItemEvent = articleListItemEvent;
    }

    public String getArticleDetailMd5() {
        return articleDetailMd5;
    }

    public void setArticleDetailMd5(String articleDetailMd5) {
        this.articleDetailMd5 = articleDetailMd5;
    }

    public Double getArticleDetailData() {
        return articleDetailData;
    }

    public void setArticleDetailData(Double articleDetailData) {
        this.articleDetailData = articleDetailData;
    }

    public String getMatchDetailMd5() {
        return matchDetailMd5;
    }

    public void setMatchDetailMd5(String matchDetailMd5) {
        this.matchDetailMd5 = matchDetailMd5;
    }

    public Double getMatchDetailData() {
        return matchDetailData;
    }

    public void setMatchDetailData(Double matchDetailData) {
        this.matchDetailData = matchDetailData;
    }
}
