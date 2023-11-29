package com.martinkondor.textshare;

import jakarta.persistence.*;

@Entity
@Table(name = "upvote")
public class UpvoteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long userId;
    private long textId;

    public UpvoteModel() {}

    public UpvoteModel(long userId, long textId) {
        this.userId = userId;
        this.textId = textId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getTextId() {
        return textId;
    }

    public void setTextId(long textId) {
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
