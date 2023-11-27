package com.martinkondor.textshare.models;

public class UpvoteModel {
    private int userId = -1;
    private int textId = -1;

    public UpvoteModel(int userId, int textId) {
        this.userId = userId;
        this.textId = textId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTextId() {
        return textId;
    }

    public void setTextId(int textId) {
        this.textId = textId;
    }

    @Override
    public String toString() {
        return "UpvoteModel{" +
                "userId=" + userId +
                ", textId=" + textId +
                '}';
    }
}
