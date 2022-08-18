package com.sparta.task03.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter // get 함수 일괄적으로 생성
@NoArgsConstructor // 기본 생성자 만듦
@Entity // DB 테이블 역할
public class Post extends Timestamped{

    // ID가 자동으로 생성 및 증가합니다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    // 반드시 값을 가지도록 합니다.
    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private String pass;

//    // 생성자?
//    public Post(String username, String title, String contents) {
//        this.username = username;
//        this.title = title;
//        this.contents = contents;
//    }
    public Post(PostRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
        this.pass = requestDto.getPass();
    }

    public void update(PostRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
        this.pass = requestDto.getPass();
    }
}