package com.example.shoppingMall.dto.sellerLevel;

import java.io.Serializable;

import com.example.shoppingMall.dto.SellerLevelDto;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class UpdateSellerLevelReq implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty("SellerLevelUpdate")
    private SellerLevelDto sellerLevel;
}
