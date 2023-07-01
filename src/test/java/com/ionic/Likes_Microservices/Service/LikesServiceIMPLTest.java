package com.ionic.Likes_Microservices.Service;

import com.ionic.Likes_Microservices.Entity.Likes;
import com.ionic.Likes_Microservices.Repository.LikesRepo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class LikesServiceIMPLTest {

    @Mock
    private LikesRepo likesRepo;

    private LikesService likesService;   // I did not autowire it because i did not want to take data from likeserviceimpl's likerepo therefore I made constructor for it

    AutoCloseable autoCloseable;

    Likes likes;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        likesService = new LikesServiceIMPL(likesRepo);
        likes = new Likes();
        likes.setContentId("120");
        likes.setUserId("02");
    }

    @AfterEach
    void tearDown() throws Exception{
        autoCloseable.close();
    }

    @Test
    void storeLike() {
        mock(Likes.class);
        mock(LikesRepo.class);

        //when likesRepo.save will be called then likes should be returned
        when(likesRepo.save(likes)).thenReturn(likes);
        assertThat(likesService.storeLike(likes.getUserId(),likes.getContentId())).isEqualTo("Content Liked Successsfully");
    }

    @Test
    void checkLiked() {
        mock(Likes.class);
        mock(LikesRepo.class);

        when(likesRepo.existsByUserIdAndContentId(likes.getUserId(), likes.getContentId())).thenReturn(true);
        assertThat(likesService.checkLiked(likes.getUserId(), likes.getContentId())).isTrue();
    }

    @Test
    void getTotalLikes() {
        mock(Likes.class);
        mock(LikesRepo.class);

        when(likesRepo.countByContentId(likes.getContentId())).thenReturn(1);
        assertThat(likesService.getTotalLikes(likes.getContentId())).isEqualTo(1);

    }

}