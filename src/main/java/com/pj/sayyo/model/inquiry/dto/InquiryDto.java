package com.pj.sayyo.model.inquiry.dto;

import java.util.Date;

public class InquiryDto {
    // 글 번호
    private int num;
    // 작성한 사람 id
    private String memberId;
    // 문의내역 제목
    private String title;
    // 문의내역 작성 시간
    private Date nowDate;
    // 문의내역 카테고리
    private String category;
    // 문의내역 답변 여부
    private char complete;
    // 문의내역 내용
    private String content;

    @Override
    public String toString() {
        return "InquiryDto{" +
                "num=" + num +
                ", memberId='" + memberId + '\'' +
                ", title='" + title + '\'' +
                ", nowDate=" + nowDate +
                ", category='" + category + '\'' +
                ", complete=" + complete +
                ", content='" + content + '\'' +
                '}';
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public char getComplete() {
        return complete;
    }

    public void setComplete(char complete) {
        this.complete = complete;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
