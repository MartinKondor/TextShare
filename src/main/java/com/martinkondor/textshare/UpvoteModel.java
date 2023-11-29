package com.martinkondor.textshare;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "upvote")
@Data
@NoArgsConstructor
@ToString
public class UpvoteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    private long userId;
    @NotNull
    private long textId;

    public UpvoteModel(long userId, long textId) {
        this.userId = userId;
        this.textId = textId;
    }
}
