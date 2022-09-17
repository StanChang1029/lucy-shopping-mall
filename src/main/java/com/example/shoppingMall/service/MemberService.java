package com.example.shoppingMall.service;

import java.io.IOException;
import java.math.BigInteger;

import com.example.shoppingMall.dto.MemberDto;
import com.example.shoppingMall.dto.MemberToQueryDto;
import com.example.shoppingMall.dto.member.CreateMemberRes;
import com.example.shoppingMall.dto.member.NonAvailableMemberRes;
import com.example.shoppingMall.dto.member.QueryMemberWithAllRes;
import com.example.shoppingMall.dto.member.QueryMemberWithIdRes;
import com.example.shoppingMall.dto.member.UpdateMemberRes;
import com.example.shoppingMall.exception.DataNotFoundException;

public interface MemberService {

	CreateMemberRes createMember(MemberDto memberDto) throws IOException, DataNotFoundException;

	UpdateMemberRes updateMember(MemberDto member) throws IOException, DataNotFoundException;
	
	NonAvailableMemberRes nonAvailableMember(BigInteger memberId) throws IOException, DataNotFoundException ;
	
	QueryMemberWithIdRes queryMemberWithId(BigInteger memberId) throws IOException, DataNotFoundException;
	
	QueryMemberWithAllRes queryMemeberWithAll(MemberToQueryDto memberToQuery) throws IOException,DataNotFoundException;



}
