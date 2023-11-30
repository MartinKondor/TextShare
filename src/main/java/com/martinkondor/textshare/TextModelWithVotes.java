package com.martinkondor.textshare;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@ToString
public class TextModelWithVotes extends TextModel {
    private List<UpvoteModel> upvotes;
    private List<DownvoteModel> downvotes;
}
