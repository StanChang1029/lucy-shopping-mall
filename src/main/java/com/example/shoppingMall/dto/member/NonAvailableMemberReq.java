package com.example.shoppingMall.dto.member;

import java.io.Serializable;
import java.math.BigInteger;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class NonAvailableMemberReq implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonProperty("MemberNonAvailable")
	private BigInteger memberId;
}
