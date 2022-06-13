package com.project.desafioTecnico.repository;

import com.project.desafioTecnico.model.Post;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
class PostRepositoryTest {

    @Autowired
    private PostRepository postRepository;

    @Test
    public void deveriaCarregarUmPostAoBuscarPeloId(){
        Long id = 1L;
        Optional<Post> post = postRepository.findById(id);

        assertNotNull(post);
        assertEquals(id, post.get().getId());
    }

    @Test
    public void naoDeveriaCarregarUmPostAoBuscarPeloIdQueNaoExiste(){
        Long id = 3L;
        Optional<Post> post = postRepository.findById(id);
        assertNotNull(post);
    }

}