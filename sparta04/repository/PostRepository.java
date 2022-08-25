package com.sparta.task04.repository;

import com.sparta.task04.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> { //<@Entity클래스, @ID의 데이터타입>
    List<Post> findAllByOrderByModifiedAtDesc(); // 전체 조회, ModifiedAt 멤버 변수(수정 시간 내림차순으로)기준으로 정렬, post 리스트에 넣음

}