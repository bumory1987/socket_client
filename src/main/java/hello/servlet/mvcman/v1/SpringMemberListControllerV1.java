package hello.servlet.mvcman.v1;


import hello.servlet.mvcbasic.domain.member.Member;
import hello.servlet.mvcbasic.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class SpringMemberListControllerV1 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @RequestMapping("/springmvc/v1/members")
    public ModelAndView save(){

        List<Member> allMember = memberRepository.findAll();
        ModelAndView mv = new ModelAndView("members");
        mv.addObject("members", allMember);
        return mv;
    }
}
