package com.sparta.task04.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sparta.task04.dto.PostRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter  // get 함수 자동 생성
@MappedSuperclass // Entity가 자동으로 컬럼으로 인식
@EntityListeners(AuditingEntityListener.class) // 생성, 수정 시간 자동 업데이트
public abstract class Timestamped { // 상속으로만 사용 가능한 추상 클래스(빵을 못만드는 빵틀)

    @CreatedDate  // 최초 생성 시점
    private LocalDateTime createdAt;

    @LastModifiedDate  // 최종 변경 시점
    private LocalDateTime modifiedAt;
}