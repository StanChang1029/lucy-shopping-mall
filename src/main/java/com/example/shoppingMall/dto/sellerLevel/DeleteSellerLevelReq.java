package com.example.shoppingMall.dto.sellerLevel;

import java.io.Serializable;
import java.math.BigInteger;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class DeleteSellerLevelReq implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty("SellerLevelDelete")
    private BigInteger sellerLevelId;
}
