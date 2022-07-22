package hello.servlet.mvcbasic.web.frontcontroller.v3.controller;

import hello.servlet.mvcbasic.domain.member.Member;
import hello.servlet.mvcbasic.domain.member.MemberRepository;
import hello.servlet.mvcbasic.web.frontcontroller.ModelView;
import hello.servlet.mvcbasic.web.frontcontroller.v3.ControllerV3;

import java.util.List;
import java.util.Map;

public class MemberListControllerV3 implements ControllerV3 {
    private MemberRepository memberRepository = MemberRepository.getInstance();


    @Override
    public ModelView process(Map<String, String> paramMap) {
        List<Member> allMember = memberRepository.findAll();
        ModelView mv = new ModelView("members");
        mv.getModel().put("members", allMember);
        return mv;
    }
}
