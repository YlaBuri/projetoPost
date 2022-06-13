package com.project.desafioTecnico.model.Dto;

import com.project.desafioTecnico.model.Post;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostDtoRequest {
    private String texto;

    private Integer upvote;

    private LocalDateTime dataPostagem;

    public PostDtoRequest() {

    }

    public PostDtoRequest(String texto, Integer upvote) {
        this.texto = texto;
        this.upvote = upvote;
        this.dataPostagem = LocalDateTime.now();
    }

    public Post toModel(){
        return new Post(texto, upvote, dataPostagem);
    }


}
