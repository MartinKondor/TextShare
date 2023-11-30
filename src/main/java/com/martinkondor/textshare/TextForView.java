package com.martinkondor.textshare;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@ToString
public class TextForView extends TextModel {
    private UserModel user;
    private List<UpvoteForView> upvotes;
    private List<DownvoteForView> downvotes;
}
