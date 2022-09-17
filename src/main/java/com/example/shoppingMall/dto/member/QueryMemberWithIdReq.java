package com.example.shoppingMall.dto.member;

import java.io.Serializable;
import java.math.BigInteger;

import com.example.shoppingMall.dto.MemberDto;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class QueryMemberWithIdReq implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty("QueryWithId")
    private BigInteger memberId;
}
