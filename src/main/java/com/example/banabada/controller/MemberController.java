package com.example.banabada.controller;

import com.example.banabada.model.Member;
import com.example.banabada.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Request;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@Slf4j
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    // 회원 가입

    @GetMapping("/auth/signup")
    public String signup() {
        return "signup";
    }
    @PostMapping("/auth/signup")
    public String signup(@RequestParam(name = "name", required=false) String name,
                         @RequestParam(name = "password", required=false) String pwd,
                         @RequestParam(name = "email", required=false) String email,
                         @RequestParam(name = "phoneNumber", required=false) String pnum,
                         @RequestParam(name = "address", required=false) String address) {

        Member member = new Member();

        member.setName(name);
        member.setPassword(pwd);
        member.setEmail(email);
        member.setPhoneNumber(pnum);
        member.setAddress(address);

        memberService.join(member);
        log.info(memberService.findMembers().get(0).getName());

        return "login";
    }

    /*/ 회원 가입
    @GetMapping("/auth/signup")
    public String createForm(Model model) {
        model.addAttribute("memberForm", new MemberForm());
        return "signup";  // 회원 가입 페이지로 이동 후, 회원 정보 입력
    }

    @PostMapping("/auth/signup")
    public String create(MemberForm form, BindingResult result) {  // (@Valid MemberForm memberForm --> @NotEmpty와 관련됨)

        if(result.hasErrors()) {  // 에러가 났을 경우
            return "signup";      // 회원 가입 페이지로 다시 이동
        }

        Member member = new Member();

        member.setName(form.getName());
        member.setPassword(form.getPassword());
        member.setPhoneNumber(form.getPhoneNumber());
        member.setEmail(form.getEmail());
        member.setAddress(form.getAddress());

        memberService.join(member);     // db에 사용자 생성
        return "redirect:/";  // 첫번째 페이지로 넘어감
    }


    @GetMapping("/auth/signup")
    public String signupForm() {
        return "signup";
    }

    @PostMapping("/auth/signup")
    public String signup(Member member) {
        Member newMember = member;

        memberService.join(member);
        return "signup";
    }
    */


    // 로그인
    @GetMapping("/auth/login")
    public String login() {
        //model.addAttribute("memberLoginForm", new MemberLoginForm());
        return "login";
    }

    @PostMapping("/auth/login")
    public String login(@RequestParam(name = "email", required=false) String email,
                        @RequestParam(name = "password", required=false) String pwd) {


        return "redirect:/";
    }


    /*
    @GetMapping("/auth/signin")
    public String singin(Model model, MemberLoginForm form, BindingResult result) {

        model.addAttribute("memberLoginForm", new MemberLoginForm());

        if(result.hasErrors()) {  // 에러가 났을 경우
            return "login";      // 회원 가입 페이지로 다시 이동
        }

        Member member = new Member();

        member.setEmail(form.getEmail());
        member.setPassword(form.getPassword());

        if (memberService.findByEmail(member.getEmail()) != null) {

        }


    }

     */


    // 로그아웃 : 일단 만들어만 둠
    @GetMapping("/auth/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
        return "redirect:/login";
    }




    // 백엔드에서 Member DB 확인하는 용으로 사용함
    @GetMapping("/auth/members")
    public String list(Model model) {
        model.addAttribute("members", memberService.findMembers());
        return "memberList";
    }
}


/***  @Request param 관련

 import org.springframework.web.bind.annotation.*;

 @RestController // controller임을 알려주는 표시
 @RequestMapping("/api") // 이곳으로 들어오는 API주소를 mapping, /api주소로 받겠다(localhost:8080/api)
 public class GetController {

 // RequestMapping과 다른 게 path만 설정해주면 됨, localhost:8080/api/getParameter?id=1234&password=abcd
 @GetMapping("/getParameter")
 public String getParameter(@RequestParam String id, @RequestParam(name = "password") String pwd) {
 String password = "bbbb";
 System.out.println("id: " + id);
 System.out.println("password: "+pwd);

 return id + pwd;
 }

 }



 */