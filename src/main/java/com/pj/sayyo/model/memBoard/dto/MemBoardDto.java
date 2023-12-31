package com.pj.sayyo.model.memBoard.dto;

import java.util.Date;

public class MemBoardDto {
    // 유저 id
    private String memberId;
    // pk 글 num
    private int num;
    // 글 제목
    private String title;
    // 글 내용
    private String content;
    // 글 작성 날짜
    private Date nowDate;
    private int views;
    // 카테고리
    private String category;



    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getNowDate() {
        return nowDate;
    }

    public void setNowDate(Date nowDate) {
        this.nowDate = nowDate;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
