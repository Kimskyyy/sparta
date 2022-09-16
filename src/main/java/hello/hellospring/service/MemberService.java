package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// 서비스는 비즈니스를 처리하는 것이 role
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    // private final MemberRepository memberRepository = new MemoryMemberRepository();를 위 코드처럼 뒷 부분 삭제
    // 위 코드처럼 new로 직접 생성하지 않고, 아래 코드처럼 외부에서 값을 넣어주는 것으로 수정
    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // 회원가입
    public Long join(Member member) {
        validateDuplicateMember(member); //중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    //         방법 1 but 코드가 예쁜 모양이 아니다
//        Optional<Member> result = memberRepository.findByName(member.getName());
//        result.ifPresent(m -> { // member를 m 으로 작성 함..(?) 만약 member에 값이 있으면
//            throw new IllegalStateException("이미 존재하는 회원입니다."); // 메시지를 던져줌
//            });

    //        방법 2 로직이 생기면(?) 메소드로 뽑아 내는 것이 좋음(아래 블록 잡고 cmd+opt+M) extract method
//        memberRepository.findByName(member.getName())
//                        .ifPresent(m -> {
//                            throw new IllegalStateException("이미 존재하는 회원입니다.");
//                        });


    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    // 전체 회원 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
