package com.sparta.task03.domain;

import lombok.Getter;

@Getter
public class PostRequestDto {
    private String username;
    private String title;
    private String contents;
    private String pass;
}