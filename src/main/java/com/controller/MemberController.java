package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.MemberDTO;
import com.model.Member;
import com.service.MemberService;

@RestController
@RequestMapping("/api/members")
public class MemberController {
    @Autowired
    private MemberService memberService;
    
    @PostMapping("/register")
    public ResponseEntity<Member> register(@RequestBody MemberDTO memberDTO) {
        return ResponseEntity.ok(memberService.register(memberDTO));
    }
    
    @PutMapping("/{memberId}/password")
    public ResponseEntity<Member> updatePassword(
            @PathVariable Integer memberId,
            @RequestBody String newPassword) {
        return ResponseEntity.ok(memberService.updatePassword(memberId, newPassword));
    }
}