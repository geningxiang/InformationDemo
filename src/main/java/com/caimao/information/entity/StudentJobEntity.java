package com.caimao.information.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: genx
 * @date: 2018/12/24 14:56
 */
public class StudentJobEntity {
    private String studentId;
    private String articleListMd5;
    private BigDecimal articleListSortEvent = BigDecimal.ZERO;
    private BigDecimal articleListData = BigDecimal.ZERO;
    private BigDecimal articleListEvent = BigDecimal.ZERO;
    private String articleDetailMd5;
    private BigDecimal articleDetailData = BigDecimal.ZERO;
    private String matchListMd5;
    private BigDecimal matchListData = BigDecimal.ZERO;
    private BigDecimal matchListEvent = BigDecimal.ZERO;
    private String matchDetailMd5;
    private BigDecimal matchDetailData = BigDecimal.ZERO;
    private Timestamp createTime;

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

    public BigDecimal getArticleListData() {
        return articleListData;
    }

    public void setArticleListData(BigDecimal articleListData) {
        this.articleListData = articleListData;
    }

    public BigDecimal getArticleListEvent() {
        return articleListEvent;
    }

    public void setArticleListEvent(BigDecimal articleListEvent) {
        this.articleListEvent = articleListEvent;
    }

    public String getArticleDetailMd5() {
        return articleDetailMd5;
    }

    public void setArticleDetailMd5(String articleDetailMd5) {
        this.articleDetailMd5 = articleDetailMd5;
    }

    public BigDecimal getArticleDetailData() {
        return articleDetailData;
    }

    public void setArticleDetailData(BigDecimal articleDetailData) {
        this.articleDetailData = articleDetailData;
    }

    public String getMatchListMd5() {
        return matchListMd5;
    }

    public void setMatchListMd5(String matchListMd5) {
        this.matchListMd5 = matchListMd5;
    }

    public BigDecimal getMatchListData() {
        return matchListData;
    }

    public void setMatchListData(BigDecimal matchListData) {
        this.matchListData = matchListData;
    }

    public BigDecimal getMatchListEvent() {
        return matchListEvent;
    }

    public void setMatchListEvent(BigDecimal matchListEvent) {
        this.matchListEvent = matchListEvent;
    }

    public String getMatchDetailMd5() {
        return matchDetailMd5;
    }

    public void setMatchDetailMd5(String matchDetailMd5) {
        this.matchDetailMd5 = matchDetailMd5;
    }

    public BigDecimal getMatchDetailData() {
        return matchDetailData;
    }

    public void setMatchDetailData(BigDecimal matchDetailData) {
        this.matchDetailData = matchDetailData;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public BigDecimal getArticleListSortEvent() {
        return articleListSortEvent;
    }

    public void setArticleListSortEvent(BigDecimal articleListSortEvent) {
        this.articleListSortEvent = articleListSortEvent;
    }
}

