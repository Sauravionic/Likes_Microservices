package com.ionic.Likes_Microservices.Controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.ionic.Likes_Microservices.DTO.LikeRequestDTO;
import com.ionic.Likes_Microservices.Service.LikesService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;




@WebMvcTest(LikesController.class)
class LikesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LikesService likesService;

    LikeRequestDTO likeRequestDTO;

    @BeforeEach
    void setUp() {
        likeRequestDTO = new LikeRequestDTO("1","2");
    }

    @Test
    void storeLike() throws Exception {

        //Converts likeRequestDTO to json so that it can be passed as content
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter objectWriter = mapper.writer().withDefaultPrettyPrinter();
        String requestJSON = objectWriter.writeValueAsString(likeRequestDTO);

        when(likesService.storeLike(likeRequestDTO.getUserId(), likeRequestDTO.getContentId())).thenReturn(String.valueOf(likeRequestDTO));
        this.mockMvc.perform(post("/api/v1/likes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void checkLiked() throws Exception{

        when(likesService.checkLiked(likeRequestDTO.getUserId(), likeRequestDTO.getContentId())).thenReturn(true);
        this.mockMvc.perform(get("/api/v1/likes/check?userId=1&contentId=2"))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    void getTotalLikes() throws Exception{

        when(likesService.getTotalLikes(likeRequestDTO.getContentId())).thenReturn(1);
        this.mockMvc.perform(get("/api/v1/likes/total?&contentId=2"))
                .andDo(print()).andExpect(status().isOk());
    }
}