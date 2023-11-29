package com.martinkondor.textshare;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DownvoteRepository extends JpaRepository<DownvoteModel, Long> {
    DownvoteModel findByUserIdAndAndTextId(long userId, long textId);
}
