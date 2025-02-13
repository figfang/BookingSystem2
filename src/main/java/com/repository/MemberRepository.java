package com.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.Member;

@Repository

public interface MemberRepository extends JpaRepository<Member, Integer> {
	
    boolean existsByEmail(String email);
    
    Optional<Member> findByEmail(String email);
}