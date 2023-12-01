package com.pj.sayyo.model.inquiry.dto;

import java.util.Date;

public class InquiryReDto {
    // 글 번호
    private int num;
    // 문의내역 답변 제목
    private String title;
    // 문의내역 답변 작성 시간
    private Date nowDate;
    // 문의내역 답변 내용
    private String content;


    @Override
    public String toString() {
        return "InquiryReDto{" +
                "num=" + num +
                ", title='" + title + '\'' +
                ", nowDate=" + nowDate +
                ", content='" + content + '\'' +
                '}';
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

    public Date getNowDate() {
        return nowDate;
    }

    public void setNowDate(Date nowDate) {
        this.nowDate = nowDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
