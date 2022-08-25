package com.sparta.task04.controller;

import com.sparta.task04.dto.MemberResponseDto;
import com.sparta.task04.repository.MemberRepository;
import com.sparta.task04.security.SecurityUtil;
import com.sparta.task04.security.TokenProvider;
import com.sparta.task04.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/me")
    public ResponseEntity<MemberResponseDto> getMyMemberInfo() {
        return ResponseEntity.ok(memberService.getMyInfo());
    }

    @GetMapping("/{nickname}")
    public ResponseEntity<MemberResponseDto> getMemberInfo(@PathVariable String nickname) {
        return ResponseEntity.ok(memberService.getMemberInfo(nickname));
    }
}