package com.example.banabada.service;

import com.example.banabada.model.Member;
import com.example.banabada.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

//  @Autowired
    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

/*/  @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
*/

    // 회원 가입
    @Transactional
    public Long join(Member member) {

        validateDuplicateMember(member);
        String rawPassword = member.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword); //고려사항 11.22
        member.setPassword(encPassword);

        memberRepository.save(member);

        return member.getId();

    }


    // 회원 조회
//  @Transactional(readOnly = true)
    public List<Member> findMembers() { return memberRepository.findAll(); }
    // 회원 단건 조회
//  @Transactional(readOnly = true)
    public Member findOne(Long memberId) { return memberRepository.findOne(memberId); }
    public List<Member> findByEmail(String email) { return memberRepository.findByEmail(email); }

    private void validateDuplicateMember(Member member) {  // member name 속성 unique로 하는 것 추천
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }
}
