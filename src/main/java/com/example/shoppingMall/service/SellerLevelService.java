package com.example.shoppingMall.service;

import java.io.IOException;
import java.math.BigInteger;

import com.example.shoppingMall.dto.SellerLevelDto;
import com.example.shoppingMall.dto.sellerLevel.CreateSellerLevelRes;
import com.example.shoppingMall.dto.sellerLevel.DeleteSellerLevelRes;
import com.example.shoppingMall.dto.sellerLevel.UpdateSellerLevelRes;
import com.example.shoppingMall.exception.DataNotFoundException;

public interface SellerLevelService {

	CreateSellerLevelRes createSellerLevel(SellerLevelDto sellerLevelDto) throws IOException, DataNotFoundException;

	UpdateSellerLevelRes updateSellerLevel (SellerLevelDto sellerLevelDto) throws IOException, DataNotFoundException;
	
	DeleteSellerLevelRes deleteSellerLevel (BigInteger sellerLevelId) throws IOException, DataNotFoundException;
}
