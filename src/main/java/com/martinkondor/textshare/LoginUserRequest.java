package com.martinkondor.textshare;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class LoginUserRequest {
    @NotNull
    private String emailOrUsername;
    @NotNull
    private String password;
}
