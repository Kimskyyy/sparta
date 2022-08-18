package com.sparta.task03.service;

import com.sparta.task03.domain.Post;
import com.sparta.task03.domain.PostRequestDto;
import com.sparta.task03.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor // final로 선언된 멤버 변수 자동 생성
@Service // 서비스임을 선언
public class PostService {

    private final PostRepository postRepository;

    @Transactional //메소드 동작이 SQL 쿼리문임을 선언
    public Long update(Long id, PostRequestDto requestDto) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        post.update(requestDto);
        return id;
    }
}