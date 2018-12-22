package com.caimao.information.entity;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: genx
 * @date: 2018/12/22 21:25
 */
public class StudentJobEntity {
    private String studentId;
    private String articleListMd5;

    /**
     * 是否有栏位
     */
    private Short articleListSorts;
    private Short articleListData;
    private Short articleListEvent;

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

    public Short getArticleListSorts() {
        return articleListSorts;
    }

    public void setArticleListSorts(Short articleListSorts) {
        this.articleListSorts = articleListSorts;
    }

    public Short getArticleListData() {
        return articleListData;
    }

    public void setArticleListData(Short articleListData) {
        this.articleListData = articleListData;
    }

    public Short getArticleListEvent() {
        return articleListEvent;
    }

    public void setArticleListEvent(Short articleListEvent) {
        this.articleListEvent = articleListEvent;
    }


}
