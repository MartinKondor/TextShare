package com.martinkondor.textshare;

import jakarta.persistence.*;

@Entity
@Table(name = "downvote")
public class DownvoteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int userId;
    private int textId;

    public DownvoteModel() {}

    public DownvoteModel(int userId, int textId) {
        this.userId = userId;
        this.textId = textId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
        return "DownvoteModel{" +
                "userId=" + userId +
                ", textId=" + textId +
                '}';
    }
}
