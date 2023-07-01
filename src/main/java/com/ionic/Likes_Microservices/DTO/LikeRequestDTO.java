package com.ionic.Likes_Microservices.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LikeRequestDTO {

    private String userId;
    private String contentId;
}
