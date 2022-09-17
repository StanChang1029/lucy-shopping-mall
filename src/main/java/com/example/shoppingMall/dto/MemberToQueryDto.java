package com.example.shoppingMall.dto;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.Data;

@Data
public class MemberToQueryDto implements Serializable {
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
    
    @JsonAlias("seller_point_min")
    private BigInteger sellerPointMin;
    
    @JsonAlias("seller_point_max")
    private BigInteger sellerPointMax;
    
    @JsonAlias("buyer_point_min")
    private BigInteger buyerPointMin;
    
    @JsonAlias("buyer_point_max")
    private BigInteger buyerPointMax;
    
    @JsonAlias("create_time_from")
    private Date createTimeFrom;
    
    @JsonAlias("create_time_to")
    private Date createTimeTo;
    
    @JsonAlias("edit_time_from")
    private Date editTimeFrom;
    
    @JsonAlias("edit_time_to")
    private Date editTimeTo;
    
    @JsonAlias("abailable")
    private Boolean available;

}
