package com.martinkondor.textshare;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DownvoteRepository extends JpaRepository<DownvoteModel, Long> {
    DownvoteModel findByUserIdAndAndTextId(long userId, long textId);
    List<DownvoteModel> findAllByTextId(long textId);
}
