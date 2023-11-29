package com.martinkondor.textshare;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UpvoteRepository extends JpaRepository<UpvoteModel, Long> {
    UpvoteModel findByUserIdAndAndTextId(long userId, long textId);
}
