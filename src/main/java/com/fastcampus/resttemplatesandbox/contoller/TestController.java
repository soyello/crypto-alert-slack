package com.fastcampus.resttemplatesandbox.contoller;

import com.fastcampus.resttemplatesandbox.entity.Member;
import com.fastcampus.resttemplatesandbox.entity.Team;
import com.fastcampus.resttemplatesandbox.repository.MemberRepository;
import com.fastcampus.resttemplatesandbox.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TestController {
    private final MemberRepository memberRepository;
    private final TeamRepository teamRepository;

    @GetMapping("/api/v1/member")
    public void test() {
        List<Member> all = memberRepository.findAll();
    }

    @GetMapping("/api/v1/team")
    public void test2() {
        List<Team> all = teamRepository.findAll();
    }
}
