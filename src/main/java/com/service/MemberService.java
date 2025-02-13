package com.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dto.MemberDTO;
import com.model.Member;
import com.repository.MemberRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;
    
    public Member register(MemberDTO memberDTO) {
        if (memberRepository.existsByEmail(memberDTO.getEmail())) {
            throw new RuntimeException("該電子郵件已被註冊");
        }
        
        Member member = new Member();
        member.setEmail(memberDTO.getEmail());
        member.setPassword(memberDTO.getPassword());  // 直接儲存密碼
        member.setName(memberDTO.getName());
        member.setPhoneNumber(memberDTO.getPhoneNumber());
        member.setCreateTime(LocalDateTime.now());
        
        return memberRepository.save(member);
    }
    
    public Member updatePassword(Integer memberId, String newPassword) {
        Member member = memberRepository.findById(memberId)
            .orElseThrow(() -> new RuntimeException("會員不存在"));
            
        member.setPassword(newPassword);  // 直接更新密碼
        return memberRepository.save(member);
    }
}