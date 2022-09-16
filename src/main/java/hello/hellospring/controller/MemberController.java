package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private final MemberService memberService;
    //     private final MemberService memberService = new MemberService(); 로 MemberService를 생성해서 사용할 수는 있지만
    //     다른 컨트롤러에서 MemberService를 사용한다면 반복적으로 MemberService를 new 해야함
    //     스프링 컨테이너에게 등록을 하고 사용하는 것으로 변경(한번의 등록으로 여러번, 여러곳에서 사용가능하며 여러 부가적인 기능을 사용할 수 있다

    @Autowired // 생성자에 @Autowired가 있으면  MemberService를 스프링 컨테이너안에있는 MemberService와 연결 시켜줌(연관 관계 생성)
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
