package com.example.shoppingMall.dto.member;

import java.io.Serializable;

import com.example.shoppingMall.dto.HeaderRes;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CreateMemberRes implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty("HeaderRes")
    private HeaderRes headerRes ;
}
