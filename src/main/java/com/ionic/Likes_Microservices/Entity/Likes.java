package com.ionic.Likes_Microservices.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "likes")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Likes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "content_id")
    private String contentId;

}
