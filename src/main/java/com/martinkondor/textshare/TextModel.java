package com.martinkondor.textshare;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "text")
@Data
@NoArgsConstructor
@ToString
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

    public static String createTimestamp() {
        long unixTimestampMillis = System.currentTimeMillis();
        long unixTimestampSeconds = unixTimestampMillis / 1000;
        return String.valueOf(unixTimestampSeconds);
    }
}
