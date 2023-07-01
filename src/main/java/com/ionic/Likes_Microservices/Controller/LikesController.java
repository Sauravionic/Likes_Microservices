package com.ionic.Likes_Microservices.Controller;

import com.ionic.Likes_Microservices.DTO.LikeCountDTO;
import com.ionic.Likes_Microservices.DTO.LikeRequestDTO;
import com.ionic.Likes_Microservices.DTO.LikeResponseDTO;
import com.ionic.Likes_Microservices.Service.LikesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/likes")
public class LikesController {

    @Autowired
    private LikesService likesService;

    @PostMapping
    public ResponseEntity<String> storeLike(@RequestBody LikeRequestDTO likeRequestDTO) {
        String msg = likesService.storeLike(likeRequestDTO.getUserId(), likeRequestDTO.getContentId());
        return ResponseEntity.ok(msg);
    }

    @GetMapping("/check")
    public ResponseEntity<LikeResponseDTO> checkLiked(@RequestParam String userId, @RequestParam String contentId) {
        boolean liked = likesService.checkLiked(userId, contentId);
        LikeResponseDTO response = new LikeResponseDTO(liked);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/total")
    public ResponseEntity<LikeCountDTO> getTotalLikes(@RequestParam String contentId) {
        int likes = likesService.getTotalLikes(contentId);
        LikeCountDTO response = new LikeCountDTO(likes);
        return ResponseEntity.ok(response);
    }
}
