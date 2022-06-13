package com.project.desafioTecnico.model.Dto;

import com.project.desafioTecnico.model.Post;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostDtoResponse {
    private String texto;

    private Integer upvote;

    private LocalDateTime dataPostagem;

    public PostDtoResponse(Post post) {
        this.texto = post.getTexto();
        this.upvote = post.getUpvote();
        this.dataPostagem = post.getDataPostagem();

    }
}
