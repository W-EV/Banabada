package com.example.banabada.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.banabada.model.Member;
import com.example.banabada.repository.MemberRepository;
import com.example.banabada.repository.MemberRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

/*
//로그인 관련 >> ver1에서는 Security 적용 안하고 Member정보만 받기로 결정하였음 11.22

@RequiredArgsConstructor
@Service
public class MemberSecurityService implements UserDetailsService {

    private final MemberRepository memberRepository;


    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException{
        List<Member> _member = this.memberRepository.findByEmail(userEmail); //이메일로 로그인 하니까 Email찾기??
        if (_member.isEmpty()) {
            throw new UsernameNotFoundException("사용자를 찾을 수 없습니다");
        }
        Member member = _member.get();
        List<GrantedAuthority> authorities = new ArrayList<>();
        if ("admin".equals(userEmail)){
            authorities.add(new SimpleGrantedAuthority(MemberRole.ADMIN.getValue()));
        }else{
            authorities.add(new SimpleGrantedAuthority(MemberRole.MEMBER.getValue()));
        }
        return new Member(member.getEmail(), member.getPassword(), authorities);
    }
}

 */
