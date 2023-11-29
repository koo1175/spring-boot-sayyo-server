package com.pj.sayyo.model.mail.dto;


public class MailDto {

    @Override
    public String toString() {
        return "MailDto{" +
                "email='" + email + '\'' +
                ", authCode='" + authCode + '\'' +
                '}';
    }

    private String email;
    private String authCode;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

}