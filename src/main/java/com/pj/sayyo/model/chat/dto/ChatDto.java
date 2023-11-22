package com.pj.sayyo.model.chat.dto;


import lombok.Builder;

import java.util.Date;

@Builder
public class ChatDto {

    public enum MessageType{
        ENTER, LEAVE, TALK
    }
    private String roomId;
    private MessageType type;
    private String nickname;
    private String content;
    private Date sendTime;

    @Override
    public String toString() {
        return "ChatDto{" +
                "nickname='" + nickname + '\'' +
                ", content='" + content + '\'' +
                ", sendTime=" + sendTime +
                '}';
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }
}
