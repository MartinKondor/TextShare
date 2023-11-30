package com.martinkondor.textshare;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UpvoteRepository extends JpaRepository<UpvoteModel, Long> {
    UpvoteModel findByUserIdAndAndTextId(long userId, long textId);
    List<UpvoteModel> findAllByTextId(long textId);
}
