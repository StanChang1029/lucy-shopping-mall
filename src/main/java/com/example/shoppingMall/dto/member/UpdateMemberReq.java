package com.example.shoppingMall.dto.member;

import java.io.Serializable;

import com.example.shoppingMall.dto.MemberDto;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class UpdateMemberReq implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty("MemberUpdate")
    private MemberDto member;
}
