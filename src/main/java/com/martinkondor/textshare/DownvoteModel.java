package com.martinkondor.textshare;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "downvote")
@Data
@NoArgsConstructor
@ToString
public class DownvoteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    private long userId;
    @NotNull
    private long textId;

    public DownvoteModel(long userId, long textId) {
        this.userId = userId;
        this.textId = textId;
    }
}
