package com.example.shoppingMall.service.implement;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.shoppingMall.dto.HeaderRes;
import com.example.shoppingMall.dto.MemberDto;
import com.example.shoppingMall.dto.MemberToQueryDto;
import com.example.shoppingMall.dto.member.CreateMemberRes;
import com.example.shoppingMall.dto.member.NonAvailableMemberRes;
import com.example.shoppingMall.dto.member.QueryMemberWithAllRes;
import com.example.shoppingMall.dto.member.QueryMemberWithIdRes;
import com.example.shoppingMall.dto.member.UpdateMemberRes;
import com.example.shoppingMall.entity.Member;
import com.example.shoppingMall.exception.DataNotFoundException;
import com.example.shoppingMall.repository.MemberRepository;
import com.example.shoppingMall.service.MemberService;
import com.example.shoppingMall.sql.SqlAction;
import com.example.shoppingMall.sql.SqlUtils;
import com.fasterxml.jackson.databind.ObjectMapper;

@Transactional(rollbackFor = Exception.class)
@Service
public class MemberServiceImplement implements MemberService{

	/**
	 * sqlAction：Native查詢使用
	 */
	@Autowired
	private SqlAction sqlAction;

	/**
	 * sqlUtils：Native查詢使用
	 */
	@Autowired
	private SqlUtils sqlUtils;

	/**
	 * 轉換並儲存map
	 */
	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private MemberRepository memberRepository;

	public CreateMemberRes createMember(MemberDto member) throws IOException, DataNotFoundException {
		Member memberToCreate = new Member();

		memberToCreate.setMemberEmail(member.getMemberEmail());
		memberToCreate.setMemberPhone(member.getMemberPhone());
		memberToCreate.setMemberPassword(member.getMemberPassword());
		memberToCreate.setMemberName(member.getMemberName());
		memberToCreate.setSellerPoint(member.getSellerPoint());
		memberToCreate.setBuyerPoint(member.getBuyerPoint());
		memberToCreate.setCreateTime(member.getCreateTime());
		//TODO  edit time 要不要換成today()?
		memberToCreate.setEditTime(member.getEditTime()); 
		memberToCreate.setAvailable(member.getAvailable());

		memberRepository.save(memberToCreate);

		HeaderRes headerRes = new HeaderRes();
		CreateMemberRes createmembers = new CreateMemberRes();
		createmembers.setHeaderRes(headerRes);
		return createmembers;
	}

	public UpdateMemberRes updateMember(MemberDto member) throws IOException, DataNotFoundException {

		Member memberToUpdate = memberRepository.queryByMemberId(member.getMemberId());
		memberToUpdate.setMemberPassword(member.getMemberPassword());
		memberToUpdate.setMemberName(member.getMemberName());
		memberToUpdate.setSellerPoint(member.getSellerPoint());
		memberToUpdate.setBuyerPoint(member.getBuyerPoint());
		memberToUpdate.setCreateTime(member.getCreateTime());
		memberToUpdate.setEditTime(member.getEditTime());
		memberToUpdate.setAvailable(member.getAvailable());

		memberRepository.save(memberToUpdate);

		HeaderRes headerRes = new HeaderRes();
		UpdateMemberRes updateMemberRes = new UpdateMemberRes();
		updateMemberRes.setHeaderRes(headerRes);
		return updateMemberRes;
	}

	public NonAvailableMemberRes nonAvailableMember(BigInteger memberId) throws IOException, DataNotFoundException {

		Member memberToNonAvailable = memberRepository.queryByMemberId(memberId);
		memberToNonAvailable.setAvailable(true);
		memberRepository.save(memberToNonAvailable);

		HeaderRes headerRes = new HeaderRes();
		NonAvailableMemberRes nonAvailableMemberRes = new NonAvailableMemberRes();
		nonAvailableMemberRes.setHeaderRes(headerRes);
		return nonAvailableMemberRes;
	}
	
	public QueryMemberWithIdRes queryMemberWithId(BigInteger memberId) throws IOException, DataNotFoundException {

		Member memberQueryWithId = memberRepository.queryByMemberId(memberId);
		
		MemberDto memberDto = new MemberDto();
		memberDto.setMemberId(memberQueryWithId.getMemberId());
		memberDto.setMemberEmail(memberQueryWithId.getMemberEmail());
		memberDto.setMemberPhone(memberQueryWithId.getMemberPhone());
		memberDto.setMemberPassword(memberQueryWithId.getMemberPassword());
		memberDto.setMemberName(memberQueryWithId.getMemberName());
		memberDto.setSellerPoint(memberQueryWithId.getSellerPoint());
		memberDto.setBuyerPoint(memberQueryWithId.getBuyerPoint());
		memberDto.setCreateTime(memberQueryWithId.getCreateTime());
		memberDto.setEditTime(memberQueryWithId.getEditTime());
		memberDto.setAvailable(memberQueryWithId.getAvailable());
		
		HeaderRes headerRes = new HeaderRes();
		QueryMemberWithIdRes queryMemberWithIdRes = new QueryMemberWithIdRes();
		queryMemberWithIdRes.setHeaderRes(headerRes);
		queryMemberWithIdRes.setMember(memberDto);
		
		return queryMemberWithIdRes;
	}
	
	public QueryMemberWithAllRes queryMemeberWithAll(MemberToQueryDto memberToQuery) throws IOException,DataNotFoundException{
		
		List<Map<String, Object>> memberList = queryByMemberDetails(memberToQuery.getMemberEmail(),memberToQuery.getMemberPhone(),memberToQuery.getMemberName(),
				memberToQuery.getBuyerPointMin(),memberToQuery.getBuyerPointMax(),memberToQuery.getSellerPointMin(),memberToQuery.getSellerPointMax(),
				memberToQuery.getCreateTimeFrom(),memberToQuery.getCreateTimeTo(),memberToQuery.getEditTimeFrom(),memberToQuery.getEditTimeTo());
		if(memberList.isEmpty()) {
			throw new DataNotFoundException();
		}		
		// 新建List<Items>來接foreach itemsList的資料，要放到回傳值內
				List<MemberDto> membersToShow = new ArrayList<>();
				for (Map<String, Object> map : memberList) {
					MemberDto member = objectMapper.convertValue(map, MemberDto.class);
					membersToShow.add(member);
				}
		HeaderRes headerRes = new HeaderRes();
		QueryMemberWithAllRes queryMemberWithAllRes= new QueryMemberWithAllRes();
		queryMemberWithAllRes.setMembers(membersToShow);
		queryMemberWithAllRes.setHeaderRes(headerRes);
		
		return queryMemberWithAllRes;
		
	}

	
	private List<Map<String, Object>> queryByMemberDetails(String memberEmail, String memberPhone, String memberName, 
			BigInteger minSellerPoint, BigInteger maxSellerPoint, BigInteger minBuyerPoint, BigInteger maxBuyerPoint,
			Date fromCreateTime, Date ToCreateTime,Date FromEditTime, Date ToEditTime) throws IOException {

		Map<String, Object> map = new HashMap<>();
		if (!memberEmail.isEmpty()) {
			map.put("MEM_EMAIL", memberEmail);			
		}if (!memberPhone.isEmpty()) {
			map.put("MEM_PHONE", memberPhone);			
		}if (!memberName.isEmpty()) {
		map.put("MEM_NAME", memberName);
		}if (minSellerPoint != null ) {
		map.put("MEM_SELLERMIN", minSellerPoint);
		}if (maxSellerPoint != null ) {
		map.put("MEM_SELLERMAX", maxSellerPoint);
		}if (minBuyerPoint != null ) {
		map.put("MEM_BUYERMIN", minBuyerPoint);
		}if (maxBuyerPoint != null ) {
		map.put("MEM_BUYERMAX", maxBuyerPoint);
		}if (fromCreateTime != null) {
		map.put("MEM_CREATEFROM", fromCreateTime);
		}if (ToCreateTime != null ) {
		map.put("MEM_CREATETO", ToCreateTime);
		}if (FromEditTime != null ) {
		map.put("MEM_EDITFROM", FromEditTime);
		}if (ToEditTime != null ) {
		map.put("MEM_EDITTO", ToEditTime);
		}
		String sql = sqlUtils.getDynamicQuerySQL("Query_Member.sql", map);
		return sqlAction.queryForList(sql, map);
	}
	

}
