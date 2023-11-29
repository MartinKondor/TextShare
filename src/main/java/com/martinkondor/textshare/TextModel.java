package com.martinkondor.textshare;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "text")
public class TextModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    private long userId;
    @NotNull
    private String timestamp;
    @NotNull
    private String content;

    public TextModel() {}

    public TextModel(long userId, String timestamp, String content) {
        this.setUserId(userId);
        this.setTimestamp(timestamp);
        this.setContent(content);
    }

    public TextModel(long id, long userId, String timestamp, String content) {
        this.setId(id);
        this.setUserId(userId);
        this.setTimestamp(timestamp);
        this.setContent(content);
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

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "TextModel{" +
                "id=" + id +
                ", userId=" + userId +
                ", timestamp='" + timestamp + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
