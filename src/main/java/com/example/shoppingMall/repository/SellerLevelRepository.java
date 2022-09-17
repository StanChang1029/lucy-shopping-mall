package com.example.shoppingMall.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.shoppingMall.entity.SellerLevel;

public interface SellerLevelRepository  extends JpaRepository<SellerLevel,BigInteger>{

	
	
}
