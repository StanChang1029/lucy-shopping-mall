package com.example.shoppingMall.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.Data;

//@IdClass(MemberId.class)
@Entity
@Table(name = "seller_level")
@Data
public class SellerLevel implements Serializable {
	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "seller_level_id")
	@JsonAlias("seller_level_id")
	private BigInteger sellerLevelId;
	
	@Column(name = "seller_level_type")
	@JsonAlias("seller_level_type")
	private String sellerLevelType;
	
	@Column(name = "seller_level_des")
	@JsonAlias("seller_level_des")
	private String sellerLevelDes;
	
	@Column(name = "seller_level_point")
	@JsonAlias("seller_level_point")
	private BigInteger sellerLevelPoint;

	@Column(name = "create_time")
	@JsonAlias("create_time")
	private Date createTime;

	@Column(name = "edit_time")
    @JsonAlias("edit_time")
	private Date editTime;

	
}
