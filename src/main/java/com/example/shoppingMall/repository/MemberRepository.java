package com.example.shoppingMall.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.shoppingMall.entity.Member;
import com.example.shoppingMall.entity.member.MemberId;

public interface MemberRepository extends JpaRepository<Member,MemberId>{

	
	public List<Member> findByMemberPhone(String memberPhone);

	public Member queryByMemberId(BigInteger memberId);
}
