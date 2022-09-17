package com.example.shoppingMall.dto;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.Data;

@Data
public class MemberDto implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @JsonAlias("member_id")
    private BigInteger memberId;
    
    @JsonAlias("member_email")
    private String memberEmail;
    
    @JsonAlias("member_phone")
    private String memberPhone;
    
    @JsonAlias("member_password")
    private String memberPassword;
    
    @JsonAlias("member_name")
    private String memberName;
    
    @JsonAlias("seller_point")
    private BigInteger sellerPoint;
    
    @JsonAlias("buyer_point")
    private BigInteger buyerPoint;
    
    @JsonAlias("create_time")
    private Date createTime;
    
    @JsonAlias("edit_time")
    private Date editTime;
    
    @JsonAlias("abailable")
    private Boolean available;

}
