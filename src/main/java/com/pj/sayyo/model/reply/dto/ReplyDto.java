package com.pj.sayyo.model.reply.dto;

import java.util.Date;

public class ReplyDto {

    // 고유 ID
    private int id;
    // 댓글이 어떤 정치인한테 달린건지 저장
    private String region;
    // 작성자 닉네임
    private String nickname;
    // 댓글 좋아요 수
    private int likes;
    // 댓글 싫어요 수
    private int dislike;
    // 댓글 내용
    private String content;
    // 댓글 작성 날짜
    private Date currentDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDislike() {
        return dislike;
    }

    public void setDislike(int dislike) {
        this.dislike = dislike;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }
}
