package com.sparta.task04.controller;

import com.sparta.task04.dto.PasswordDto;
import com.sparta.task04.dto.PostRequestDto;
import com.sparta.task04.dto.ResponseDto;
import com.sparta.task04.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor // final로 선언된 멤버 변수를 자동으로 생성
@RestController // JSON으로 데이터를 주고받음을 선언
public class PostController {
    private final PostService postService;

    @PostMapping("/api/post") // 게시글 생성
    public ResponseDto<?> createPost(@RequestBody PostRequestDto requestDto) { // 반환타입 메소드명(재료)
        return postService.createPost(requestDto);
    }

    @GetMapping("/api/post/{id}") // 게시글 상세 조회
    public ResponseDto<?> getPost(@PathVariable Long id) {
        return postService.getPost(id);
    }

    @GetMapping("/api/post") // 게시글 전체 목록 조회
    public ResponseDto<?> getAllPosts() {
        return postService.getAllPost();
    }

    @PutMapping("/api/post/{id}") // 게시글 수정
    public ResponseDto<?> updatePost(@PathVariable Long id, @RequestBody PostRequestDto postRequestDto) {
        return postService.updatePost(id, postRequestDto);
    }

    @DeleteMapping("/api/post/{id}") // 게시글 삭제
    public ResponseDto<?> deletePost(@PathVariable Long id) {
        return postService.deletePost(id);
    }

    @PostMapping("/api/post/{id}") // 게시글 수정 비밀번호 확인
    public ResponseDto<?> validateAuthorByPassword(@PathVariable Long id, @RequestBody PasswordDto password) {
        return postService.validateAuthorByPassword(id, password);
    }

}
