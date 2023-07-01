package com.ionic.Likes_Microservices.Repository;

import com.ionic.Likes_Microservices.Entity.Likes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikesRepo extends JpaRepository<Likes, Long> {

    boolean existsByUserIdAndContentId(String userId, String contentId);

    int countByContentId(String contentId);
}
