package com.project.desafioTecnico.controller;

import com.project.desafioTecnico.model.Post;
import com.project.desafioTecnico.repository.PostRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.net.URI;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;



@AutoConfigureMockMvc
class PostsControllerTest {

    @Autowired
    private MockMvc mockMvc;


    public void deveCadastrarUmaPostage() throws Exception {
        URI uri = new URI("/posts");
        String json= "{\"texto\": \"texto do teste deveCadastrarUmaPostage}\"";

        mockMvc.perform(MockMvcRequestBuilders
                        .post(uri)
                        .content(json).contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().is(200));
    }
}