package com.martinkondor.textshare;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class DownvoteForView extends DownvoteModel {
    private UserModel user;
}
