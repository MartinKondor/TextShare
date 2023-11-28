package com.martinkondor.textshare;

import javax.persistence.*;

@Entity
@Table(name = "text")
public class TextModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int userId;
    private String timestamp;
    private String content;

    public TextModel() {}

    public TextModel(int userId, String timestamp, String content) {
        this.userId = userId;
        this.timestamp = timestamp;
        this.content = content;
    }

    public TextModel(int id, int userId, String timestamp, String content) {
        this.id = id;
        this.userId = userId;
        this.timestamp = timestamp;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
