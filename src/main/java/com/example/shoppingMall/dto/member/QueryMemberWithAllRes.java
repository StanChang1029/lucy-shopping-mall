package com.example.shoppingMall.dto.member;

import java.io.Serializable;
import java.util.List;

import com.example.shoppingMall.dto.HeaderRes;
import com.example.shoppingMall.dto.MemberDto;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class QueryMemberWithAllRes implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonProperty("HeaderRes")
	private HeaderRes headerRes;

	@JsonProperty("QueryWithAllResult")
	private List<MemberDto> members;

}
