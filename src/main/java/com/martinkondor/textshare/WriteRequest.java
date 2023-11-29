package com.martinkondor.textshare;

import jakarta.validation.constraints.NotNull;

public class WriteRequest {
    @NotNull
    private String content;

    public WriteRequest() {}

    public WriteRequest(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "WriteRequest{" +
                "content='" + content + '\'' +
                '}';
    }
}
