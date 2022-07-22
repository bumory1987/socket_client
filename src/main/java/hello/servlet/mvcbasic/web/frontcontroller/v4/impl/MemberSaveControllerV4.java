package hello.servlet.mvcbasic.web.frontcontroller.v4.impl;

import hello.servlet.mvcbasic.domain.member.Member;
import hello.servlet.mvcbasic.domain.member.MemberRepository;
import hello.servlet.mvcbasic.web.frontcontroller.v4.ControllerV4;

import java.util.Map;

public class MemberSaveControllerV4 implements ControllerV4 {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> Model) {
        String username = paramMap.get("username");
        int age = Integer.parseInt(paramMap.get("age"));
        Member member = new Member(username,age );
        memberRepository.save(member);
        Model.put("member", member);
        return "save-result";
    }
}
