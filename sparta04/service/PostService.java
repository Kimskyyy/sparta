package com.sparta.task04.service;

import com.sparta.task04.dto.PasswordDto;
import com.sparta.task04.dto.PostRequestDto;
import com.sparta.task04.dto.ResponseDto;
import com.sparta.task04.entity.Post;
import com.sparta.task04.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor  // final로 선언된 멤버 변수 자동 생성
@Service // 서비스임을 선언
public class PostService {

    private final PostRepository postRepository; // 멤버 변수 선언

    // 게시글 생성
    @Transactional // 메소드 동작이 SQL 쿼리문임을 선언(db에 반영 되게함)
    public ResponseDto<?> createPost(PostRequestDto requestDto) { // 반환타입 메소드명(재로)

        Post post = new Post(requestDto);
        postRepository.save(post);
        return ResponseDto.success(post);
    }
    //  게시글 상세 조회
    @Transactional(readOnly = true)
    public ResponseDto<?> getPost(Long id) {
        Optional<Post> optionalPost = postRepository.findById(id);

        if (optionalPost.isEmpty()) {
            return ResponseDto.fail("NULL_POST_ID", "post id isn't exist");
        }

        return ResponseDto.success(optionalPost.get());
    }

    // 전체 목록 조회
    @Transactional(readOnly = true)
    public ResponseDto<?> getAllPost() {
        return ResponseDto.success(postRepository.findAllByOrderByModifiedAtDesc());
    }

    // 게시글 업데이트
    @Transactional
    public ResponseDto<Post> updatePost(Long id, PostRequestDto requestDto) {
        Optional<Post> optionalPost = postRepository.findById(id);

        if (optionalPost.isEmpty()) {
            return ResponseDto.fail("NULL_POST_ID", "post id isn't exist");
        }

        Post post = optionalPost.get();
        post.update(requestDto);

        return ResponseDto.success(post);
    }
    //게시글 삭제
    @Transactional
    public ResponseDto<?> deletePost(Long id) {
        Optional<Post> optionalPost = postRepository.findById(id);

        if (optionalPost.isEmpty()) {
            return ResponseDto.fail("NOT_FOUND", "post id is not exist");
        }

        Post post = optionalPost.get();

        postRepository.delete(post);

        return ResponseDto.success(true);
    }

    // 비밀번호 확인 후 게시글 수정
    @Transactional(readOnly = true)
    public ResponseDto<?> validateAuthorByPassword(Long id, PasswordDto password) {
        Optional<Post> optionalPost = postRepository.findById(id);

        if (optionalPost.isEmpty()) {
            return ResponseDto.fail("NOT_FOUND", "post id is not exist");
        }

        Post post = optionalPost.get();

        if (!post.getPassword().equals(password.getPassword())) {
            return ResponseDto.fail("PASSWORD_NOT_CORRECT", "password is not correct");
        }

        return ResponseDto.success(true);
    }


}