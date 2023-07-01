package com.ionic.Likes_Microservices.Service;

import com.ionic.Likes_Microservices.Entity.Likes;
import com.ionic.Likes_Microservices.Repository.LikesRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

@EnableCaching
@Service
@AllArgsConstructor
public class LikesServiceIMPL implements LikesService{

    @Autowired
    private LikesRepo likesRepo;


    @Override
    @CachePut(cacheNames = "likesCache", key = "#userId + ':' + #contentId")
    public String storeLike(String userId, String contentId) {
        String msg = "Already Liked By User";

        //Check if user has liked the content. If not then if statement executes
        if(!likesRepo.existsByUserIdAndContentId(userId, contentId)) {
            Likes likes = new Likes();
            likes.setUserId(userId);
            likes.setContentId(contentId);
            likesRepo.save(likes);
            msg = "Content Liked Successsfully";
        }

        int likeCount = likesRepo.countByContentId(contentId);
        if(likeCount == 100) {
            sendPushNotification(userId);
        }
        return msg;

    }

    @Override
    @Cacheable(cacheNames = "likesCache", key = "#userId + ':' + #contentId")
    public boolean checkLiked(String userId, String contentId) {
        // Check the cache first
        // If not found in cache, fetch from the database
//        System.out.println("FROM DB");
        return likesRepo.existsByUserIdAndContentId(userId, contentId);
    }

    @Override
    @Cacheable(cacheNames = "likesCache", key = "'getTotalLikes:' + #contentId")
    public int getTotalLikes(String contentId) {
        // Check the cache first
        // If not found in cache, fetch from the database
//        System.out.println("FROM DB");
        return likesRepo.countByContentId(contentId);
    }

    @Override
    public void sendPushNotification(String userId) {
        System.out.println("Sending Push Notification");
    }
}
