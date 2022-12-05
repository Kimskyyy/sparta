package com.sparta.task03.controller;

import com.sparta.task03.domain.Post;
import com.sparta.task03.domain.PostRequestDto;
import com.sparta.task03.repository.PostRepository;
import com.sparta.task03.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor // final로 선언된 멤버 변수를 자동으로 생성
@RestController // JSON으로 데이터를 주고받음을 선언
public class PostRestController {

    private final PostRepository postRepository;
    private final PostService postService;

//// 등록된 전체 게시글 목록 조회
//    @GetMapping("/api/posts")
//    public List<Post> getPosts() {
//        return PostRepository.findAll();
//    }

    @PostMapping("/api/posts")
    public Post createPost(@RequestBody PostRequestDto requestDto) {
        Post post = new Post(requestDto);
        return postRepository.save(post);
    }

    @GetMapping("/api/posts")
    public List<Post> getPosts() {
        return postRepository.findAllByOrderByModifiedAtDesc();
    }

    @PutMapping("/api/posts/{id}")
    public Long updatePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto) {
        postService.update(id, requestDto);
        return id;
    }

    @DeleteMapping("/api/posts/{id}")
    public Long deletePost(@PathVariable Long id) {
        postRepository.deleteById(id);
        return id;
    }
}


