package hello.servlet.domain.member;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class MemberRepositoryTest {
    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void save(){
        Member member = new Member("hello", 20);
        MemberRepository.save(member);

        Member findMember = MemberRepository.findById(member.getId());
        assertThat(findMember).isEqualTo(member);
    }


    @Test
    void findAll(){
        Member member1 = new Member("member1", 20 );
        Member member2 = new Member("member2", 30 );
        MemberRepository.save(member1);
        MemberRepository.save(member2);
        List<Member> memberList = MemberRepository.findAll();

        assertThat(memberList.size()).isEqualTo(2);
        assertThat(memberList).contains(member1,member2);


    }

}