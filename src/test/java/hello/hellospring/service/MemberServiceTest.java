package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    // MemberService memberService = new MemberService();를 위 코드 처럼 뒷 부분 삭제
    // MemoryMemberRepository memberRepository = new MemoryMemberRepository();를 위 코드 처럼 뒷 부분 삭제

    @BeforeEach
    public void beforeEach() { // 메소드 실행 전 동작 지정
        memberRepository = new MemoryMemberRepository(); // MemoryMemberRepository를 만들고 위에 memberRepository에 넣고
        memberService = new MemberService(memberRepository); // memberRepository를  memberService에 넣어 줌
    }

    @AfterEach // 메서드 하나가 끝날 때 마다 지정한 동작을 하게함(지정 동작: clear)
    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void 회원가입() throws Exception{ // 테스트는 한글로 적어도 된다.(외국인과 일하는것 아닌 이상) 빌드 될 때 test 부분은 제외된다.
        // given
        Member member = new Member();
        member.setName("hello");

        // when
        Long saveId = memberService.join(member);

        // then
//         강의 자료 코드
//        Member findMember = memberRepository.findById(saveId).get();
//        assertEquals(member.getName(), findMember.getName());
        // 강의 코드
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());

    }

    @Test
    public void 중복_회원_예외() {
        // given
        Member member1 = new Member();
        member1.setName("Spring");

        Member member2 = new Member();
        member2.setName("Spring");

        // when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
/*
      // try~catch를 이용한 예외 처리
        memberService.join(member1);
        try {
            memberService.join(member2);
            fail();
        } catch (IllegalStateException e) {
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.1");
        }
 */

        // then

    }

    @Test
    void findMembers() {
        // given
        // when
        // then
    }

    @Test
    void findOne() {
        // given
        // when
        // then
    }
}

// Test는 정상 flow도 중요하지만 예외 flow가 더 중요하다.