package hello.servlet.mvcbasic.web.frontcontroller.v4.impl;

import hello.servlet.mvcbasic.domain.member.Member;
import hello.servlet.mvcbasic.domain.member.MemberRepository;
import hello.servlet.mvcbasic.web.frontcontroller.v4.ControllerV4;

import java.util.List;
import java.util.Map;

public class MemberListControllerV4 implements ControllerV4 {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> Model) {
        List<Member> members =  memberRepository.findAll();
        Model.put("members", members);
        return "members";
    }
}
