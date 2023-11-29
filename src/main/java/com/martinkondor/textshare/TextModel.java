package com.martinkondor.textshare;

import jakarta.persistence.*;

@Entity
@Table(name = "text")
public class TextModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int userId;
    private String timestamp;
    private String content;

    public TextModel() {}

    public TextModel(int userId, String timestamp, String content) {
        this.setUserId(userId);
        this.setTimestamp(timestamp);
        this.setContent(content);
    }

    public TextModel(int id, int userId, String timestamp, String content) {
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
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
