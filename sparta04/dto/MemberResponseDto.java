package com.sparta.task04.dto;

import com.sparta.task04.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MemberResponseDto {
    private String nickname;

    public static MemberResponseDto of(Member member) {
        return new MemberResponseDto(member.getNickname());
    }
}


//@NoArgsConstructor
//@Getter
//public class MemberResponseDto {
//
//    @NotEmpty(message = "닉네임은 필수 입력 값입니다.") // 빈 문자열 불가
//    @Size(min = 4, max = 12, message = "닉네임은 4자 이상, 12자 이하로 입력해주세요.") // 지정된 사이즈에 벗어나는 값 입력 시 에러 메시지
//    @Pattern(regexp = "[a-zA-z0-9]", message = "알파벳 대소문자(a~z, A~Z), 숫자(0~9)로 입력해주세요.") // 닉네임 구성
//    private String nickname;
//
//    @NotEmpty(message = "비밀번호는 필수 입력 값입니다.")
//    @Size(min = 4, max = 32, message = "비밀번호는 4자 이상, 32자 이하로 입력해주세요.")
//    @Pattern(regexp = "[a-zA-z0-9]", message = "알파벳 소문자(a~z), 숫자(0~9)로 입력해주세요.") // 비밀번호 구성
//    private String password;
//
//    @Builder
//    public MemberResponseDto(String nickname, String password) {
//        this.nickname = nickname;
//        this.password = password;
//    }
//}
