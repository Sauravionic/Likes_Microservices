package com.ionic.Likes_Microservices.Repository;

import com.ionic.Likes_Microservices.Entity.Likes;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LikesRepoTest {

    private Likes likes;
    @Autowired
    private LikesRepo likesRepo;

    @BeforeEach
    void setUp() {
        likes = new Likes();
        likes.setUserId("01");
        likes.setContentId("10");
        likesRepo.save(likes);
    }

    @AfterEach
    void tearDown() {
        likes = null;
        likesRepo.deleteAll();
    }

    @Test
    void existsByUserIdAndContentId() {
        boolean exists = likesRepo.existsByUserIdAndContentId("01", "10");
        assertThat(exists).isTrue();
    }

    @Test
    void countByContentId() {
        int count = likesRepo.countByContentId("10");
        assertThat(count).isEqualTo(1);
    }
}