package com.example.shoppingMall.dto;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.Data;

@Data
public class SellerLevelDto implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @JsonAlias("seller_level_id")
	private BigInteger sellerLevelId;
	
	@JsonAlias("seller_level_type")
	private String sellerLevelType;
	
	@JsonAlias("seller_level_des")
	private String sellerLevelDes;
	
	@JsonAlias("seller_level_point")
	private BigInteger sellerLevelPoint;

	@JsonAlias("create_time")
	private Date createTime;

    @JsonAlias("edit_time")
	private Date editTime;

}
