package com.example.banabada.controller;

import com.example.banabada.model.Member;
import com.example.banabada.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/auth/signup")
    public String createForm(Model model) {
        model.addAttribute("memberForm", new MemberForm());
        return "signup";  // 회원 가입 페이지로 이동 후, 회원 정보 입력
    }

    @PostMapping("/auth/signup")
    public String create(MemberForm form, BindingResult result) {  // (@Valid MemberForm memberForm --> @NotEmpty와 관련됨)

        if(result.hasErrors()) {  // 에러가 났을 경우
            return "signup";  // 회원 가입 페이지로 다시 이동
        }

        Member member = new Member();

        member.setName(form.getName());
        member.setPassword(form.getPassword());
        member.setPhoneNumber(form.getPhoneNumber());
        member.setEmail(form.getEmail());
        member.setAddress(form.getAddress());

        memberService.join(member);
        return "redirect:/";  // 첫번째 페이지로 넘어감
    }

    // 백엔드에서 Member DB 확인하는 용으로 사용함
    @GetMapping("/auth/members")
    public String list(Model model) {
        model.addAttribute("members", memberService.findMembers());
        return "memberList";
    }
}
