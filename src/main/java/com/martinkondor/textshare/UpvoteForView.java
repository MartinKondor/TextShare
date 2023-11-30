package com.martinkondor.textshare;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class UpvoteForView extends UpvoteModel {
    private UserModel user;
}
