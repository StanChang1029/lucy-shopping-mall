package com.example.shoppingMall.dto.member;

import java.io.Serializable;

import com.example.shoppingMall.dto.MemberDto;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CreateMemberReq implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty("MemberCreate")
    private MemberDto member;
}
