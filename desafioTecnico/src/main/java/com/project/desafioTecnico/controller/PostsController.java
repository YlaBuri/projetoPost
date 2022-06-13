package com.project.desafioTecnico.controller;


import com.project.desafioTecnico.model.Dto.PostDtoRequest;
import com.project.desafioTecnico.model.Post;
import com.project.desafioTecnico.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostsController {

    @Autowired
    private PostRepository postRepository;

    @RequestMapping("/")
    public String home() {
        return "Hello Docker World";
    }

    @GetMapping
    public ResponseEntity<List<Post>> listarTodos(){
        List<Post> topicos = postRepository.findAll();
        return ResponseEntity.ok().body(topicos);
    }

    @PostMapping
    public ResponseEntity<Post> postar(@RequestBody @Valid PostDtoRequest postDto){
        Post post = postDto.toModel();
        postRepository.save(post);
        return ResponseEntity.ok().body(post);
    }

    @PutMapping("/{id}")
    public ResponseEntity atualizar(@PathVariable Long id) {
        return postRepository.findById(id).map(
                p -> {
                    p.setUpvote(p.getUpvote()+1);
                    Post postAtualizado = postRepository.save(p);
                    return ResponseEntity.ok().body(postAtualizado);
                }).orElse(ResponseEntity.notFound().build());
    }

}
