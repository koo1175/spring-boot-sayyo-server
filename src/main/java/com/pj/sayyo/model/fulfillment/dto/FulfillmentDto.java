package com.pj.sayyo.model.fulfillment.dto;

public class FulfillmentDto {
    // 정치인 담당 지역
    private String region;
    // 정치인 이름
    private String name;
    // 계획 안건 수
    private int planNum;
    // 완료한 안건 수
    private int completeNum;
    // 시도한 안건 수 ( 진행중인 )
    private int tryNum;
    // 시행못한 안건 수
    private int notCompleteNum;
    // 지역 발전도
    private int regionDev;
    // 이행률
    private double fulfillment;


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

    public int getPlanNum() {
        return planNum;
    }

    public void setPlanNum(int planNum) {
        this.planNum = planNum;
    }

    public int getCompleteNum() {
        return completeNum;
    }

    public void setCompleteNum(int completeNum) {
        this.completeNum = completeNum;
    }

    public int getTryNum() {
        return tryNum;
    }

    public void setTryNum(int tryNum) {
        this.tryNum = tryNum;
    }

    public int getNotCompleteNum() {
        return notCompleteNum;
    }

    public void setNotCompleteNum(int notCompleteNum) {
        this.notCompleteNum = notCompleteNum;
    }

    public int getRegionDev() {
        return regionDev;
    }

    public void setRegionDev(int regionDev) {
        this.regionDev = regionDev;
    }

    public double getFulfillment() {
        return fulfillment;
    }

    public void setFulfillment(double fulfillment) {
        this.fulfillment = fulfillment;
    }
}
