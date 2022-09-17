package com.example.shoppingMall.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.Data;

//@IdClass(MemberId.class)
@Entity
@Table(name = "member")
@Data
public class Member implements Serializable {
	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "member_id")
	@JsonAlias("member_id")
	private BigInteger memberId;

	@EmbeddedId
	@JsonAlias("member_email")
	private String memberEmail;

	@EmbeddedId
	@JsonAlias("member_phone")
	private String memberPhone;

	@Column(name = "member_password")
    @JsonAlias("member_password")
	private String memberPassword;

	@Column(name = "member_name")
    @JsonAlias("member_name")
	private String memberName;

	@Column(name = "seller_point")
    @JsonAlias("seller_point")
	private BigInteger sellerPoint;

	@Column(name = "buyer_point")
    @JsonAlias("buyer_point")
	private BigInteger buyerPoint;

	@Column(name = "create_time")
	@JsonAlias("create_time")
	private Date createTime;

	@Column(name = "edit_time")
    @JsonAlias("edit_time")
	private Date editTime;

	@Column(name = "available")
    @JsonAlias("abailable")
	private Boolean available;
	
}
