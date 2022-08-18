package com.sparta.task03.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter  // get 함수 자동 생성
@MappedSuperclass // Entity가 자동으로 컬럼으로 인식
@EntityListeners(AuditingEntityListener.class) // 생성/변경 시 시간 자동 업데이트
public abstract class Timestamped { //상속으로만 사용 가능한 추상 클래스

    @CreatedDate  // 최초 생성 시점
    private LocalDateTime createdAt;

    @LastModifiedDate  // 최종 변경 시점
    private LocalDateTime modifiedAt;
}