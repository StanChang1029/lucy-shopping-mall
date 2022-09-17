package com.example.shoppingMall.controller;

import java.io.IOException;
import java.math.BigInteger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.shoppingMall.dto.MemberDto;
import com.example.shoppingMall.dto.MemberToQueryDto;
import com.example.shoppingMall.dto.member.CreateMemberReq;
import com.example.shoppingMall.dto.member.CreateMemberRes;
import com.example.shoppingMall.dto.member.DeleteMemberRes;
import com.example.shoppingMall.dto.member.NonAvailableMemberReq;
import com.example.shoppingMall.dto.member.NonAvailableMemberRes;
import com.example.shoppingMall.dto.member.QueryMemberWithAllReq;
import com.example.shoppingMall.dto.member.QueryMemberWithAllRes;
import com.example.shoppingMall.dto.member.QueryMemberWithIdReq;
import com.example.shoppingMall.dto.member.QueryMemberWithIdRes;
import com.example.shoppingMall.dto.member.UpdateMemberReq;
import com.example.shoppingMall.dto.member.UpdateMemberRes;
import com.example.shoppingMall.exception.DataNotFoundException;
import com.example.shoppingMall.exception.ErrorInputException;
import com.example.shoppingMall.service.MemberService;

@RestController
public class MemberController {

	@Autowired
	private MemberService memberService;

	@PostMapping(value = "/member/create")
	public CreateMemberRes createMember(@Valid @RequestBody CreateMemberReq req, Errors err)
			throws IOException, ErrorInputException, DataNotFoundException {
		if (err.hasErrors()) {
			throw new ErrorInputException();
		}
		MemberDto memberDto = req.getMember();
		return memberService.createMember(memberDto);

	}

	@PostMapping(value = "/member/update")
	public UpdateMemberRes updateMember(@Valid @RequestBody UpdateMemberReq req, Errors err)
			throws IOException, ErrorInputException, DataNotFoundException {
		if (err.hasErrors()) {
			throw new ErrorInputException();
		}
		MemberDto memberDto = req.getMember();
		return memberService.updateMember(memberDto);

	}

	@PostMapping(value = "/member/query/id")
	public QueryMemberWithIdRes queryWithIdMember(@Valid @RequestBody QueryMemberWithIdReq req, Errors err)
			throws IOException, ErrorInputException, DataNotFoundException {
		if (err.hasErrors()) {
			throw new ErrorInputException();
		}
		BigInteger memberId = req.getMemberId();
		return memberService.queryMemberWithId(memberId);

	}

	@PostMapping(value = "/member/query/all")
	public QueryMemberWithAllRes queryWithAllMember(@Valid @RequestBody QueryMemberWithAllReq req, Errors err)
			throws IOException, ErrorInputException, DataNotFoundException {
		if (err.hasErrors()) {
			throw new ErrorInputException();
		}
		MemberToQueryDto memberToQueryDto = req.getMember();
		return memberService.queryMemeberWithAll(memberToQueryDto);

	}

	@PostMapping(value = "/member/non/available")
	public NonAvailableMemberRes nonAvailableMember(@Valid @RequestBody NonAvailableMemberReq req, Errors err)
			throws IOException, ErrorInputException, DataNotFoundException {
		if (err.hasErrors()) {
			throw new ErrorInputException();
		}
		BigInteger memberId = req.getMemberId();
		return memberService.nonAvailableMember(memberId);

	}

	@PostMapping(value = "/member/delete")
	public DeleteMemberRes deleteMember() {
		return null;

	}
}
