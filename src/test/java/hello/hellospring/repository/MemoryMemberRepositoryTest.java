package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MemoryMemberRepositoryTest { // 다른데서 사용하지 않을거라서 Public 안해도됨 & Test할 클래스 이름 + Test로 이름 짓는게 관례
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach // 메서드 하나가 끝날때 마다 지정한 동작을 하게함
    public void afterEach() {
        repository.clearStore();
    }

    @Test // org.junit어쩌구로 임포트
    public void save() {
        Member member = new Member();
        member.setName("spring"); // member name을 spring으로 set

        repository.save(member); // repository에 member 저장

        Member result = repository.findById(member.getId()).get(); // Optional에서 값을 꺼낼 때 Get을 사용한다.
        assertThat(result).isEqualTo(member);
//      1. assertThat과 같은 기능을 함: assertEquals(result, member); // org.junit.jupiter 임포트, expected(기대값),actual(실제값)
//      2. Assertions.assertThat -> Assertions에 opt+enter 하면 static import 할 수 있고 그렇게되면 Assertions 사라지고 assertThat만 남음
    }

    @Test
    public void findByName() {
//given
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1); // repostory에 member1 저장

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2); // repostory에 member2 저장
//when
        Member result = repository.findByName("spring1").get(); // repository에서 spring1 이름을 찾는다. (Get()을 사용하여 Optional에서 값을 꺼냄)

//then
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
//given
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);
//when
        List<Member> result = repository.findAll();
//then
        assertThat(result.size()).isEqualTo(2);
    }
}

// 테스트 순서는 랜덤이기 때문에 테스트 하나가 끝나면 데이터를 clear 해야 한다.
// 테스트는 꼭 만들기를 권장함(코드가 길어질수록 필요)