package com.pj.sayyo.model.pLike.dto;

public class PLikeDto {
    private String memberId;
    private String region;
    private Character likeState;

    @Override
    public String toString() {
        return "PLikeDto{" +
                "memberId='" + memberId + '\'' +
                ", region='" + region + '\'' +
                ", likeState=" + likeState +
                '}';
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Character getLikeState() {
        return likeState;
    }

    public void setLikeState(Character likeState) {
        this.likeState = likeState;
    }
}
