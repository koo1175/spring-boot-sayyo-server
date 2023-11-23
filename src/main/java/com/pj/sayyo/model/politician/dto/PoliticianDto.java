package com.pj.sayyo.model.politician.dto;

import java.util.Date;

public class PoliticianDto {
    // 고유 ID
    private int id;
    // 지역 이름
    private String region;
    // 이름
    private String name;
    // 좋아요 수
    private int likes;
    // 싫어요 수
    private int dislike;
    // 생년월일
    private Date birth;
    // 직급 ( 대통령, 국회의원, 시장 )
    private String grade;
    // 학력
    private String education;
    // 수상 경력
    private String awards;
    // 경력
    private String career;
    @Override
    public String toString() {
        return "PoliticianDto{" +
                "id=" + id +
                ", region='" + region + '\'' +
                ", name='" + name + '\'' +
                ", likes=" + likes +
                ", dislike=" + dislike +
                ", birth=" + birth +
                ", grade='" + grade + '\'' +
                '}';
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }
}
