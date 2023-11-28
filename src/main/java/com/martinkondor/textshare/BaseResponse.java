package com.martinkondor.textshare;

public class BaseResponse {
    private int status;
    private String message;

    public BaseResponse() {}

    public BaseResponse(int status) {
        this.status = status;
        this.message = null;
    }

    public BaseResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "status=" + status +
                ", message='" + message + '\'' +
                '}';
    }
}
