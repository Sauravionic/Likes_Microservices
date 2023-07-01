package com.ionic.Likes_Microservices.Service;

public interface LikesService {
    public String storeLike(String userId, String contentId);

    public boolean checkLiked(String userId, String contentId);

    public int getTotalLikes(String contentId);

    public void sendPushNotification(String userId);
}
