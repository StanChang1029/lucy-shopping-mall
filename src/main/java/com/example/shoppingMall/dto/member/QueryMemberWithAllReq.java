package com.example.shoppingMall.dto.member;

import java.io.Serializable;

import com.example.shoppingMall.dto.MemberToQueryDto;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class QueryMemberWithAllReq implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonProperty("QueryWithAll")
	private MemberToQueryDto member;
}
