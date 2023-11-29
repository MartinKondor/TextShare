package com.martinkondor.textshare;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class BaseResponse {
    private int status;
    private String message;

    public BaseResponse(int status) {
        this.status = status;
        this.message = null;
    }

    public BaseResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
