package com.example.shoppingMall.service.implement;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.shoppingMall.dto.HeaderRes;
import com.example.shoppingMall.dto.SellerLevelDto;
import com.example.shoppingMall.dto.sellerLevel.CreateSellerLevelRes;
import com.example.shoppingMall.dto.sellerLevel.DeleteSellerLevelRes;
import com.example.shoppingMall.dto.sellerLevel.UpdateSellerLevelRes;
import com.example.shoppingMall.entity.SellerLevel;
import com.example.shoppingMall.exception.DataNotFoundException;
import com.example.shoppingMall.repository.SellerLevelRepository;
import com.example.shoppingMall.service.SellerLevelService;
import com.example.shoppingMall.sql.SqlAction;
import com.example.shoppingMall.sql.SqlUtils;
import com.fasterxml.jackson.databind.ObjectMapper;

@Transactional(rollbackFor = Exception.class)
@Service
public class SellerLevelServiceImplement implements SellerLevelService {
	
	/**
	 * sqlAction：Native查詢使用
	 */
	@Autowired
	private SqlAction sqlAction;

	/**
	 * sqlUtils：Native查詢使用
	 */
	@Autowired
	private SqlUtils sqlUtils;

	/**
	 * 轉換並儲存map
	 */
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private SellerLevelRepository sellerLevelRepository;
	
	public CreateSellerLevelRes createSellerLevel (SellerLevelDto sellerLevelDto) throws IOException, DataNotFoundException {
		SellerLevel sellerLevel = new SellerLevel();

		sellerLevel.setSellerLevelType(sellerLevelDto.getSellerLevelType());
		sellerLevel.setSellerLevelPoint(sellerLevelDto.getSellerLevelPoint());
		sellerLevel.setSellerLevelDes(sellerLevelDto.getSellerLevelDes());
		sellerLevel.setCreateTime(sellerLevelDto.getCreateTime());
		sellerLevel.setEditTime(sellerLevelDto.getEditTime());
		
		sellerLevelRepository.save(sellerLevel);

		HeaderRes headerRes = new HeaderRes();
		CreateSellerLevelRes createSellerLevelRes = new CreateSellerLevelRes();
		createSellerLevelRes.setHeaderRes(headerRes);
		return createSellerLevelRes;
	}
	
	public UpdateSellerLevelRes updateSellerLevel (SellerLevelDto sellerLevelDto) throws IOException, DataNotFoundException {
		Optional<SellerLevel> sellerLevelOptional = sellerLevelRepository.findById(sellerLevelDto.getSellerLevelId());
		if(!sellerLevelOptional.isPresent()) {
			throw new DataNotFoundException();
		}
		SellerLevel sellerLevel = sellerLevelOptional.get();
		sellerLevel.setSellerLevelType(sellerLevel.getSellerLevelType());
		sellerLevel.setSellerLevelDes(sellerLevel.getSellerLevelDes());
		sellerLevel.setSellerLevelPoint(sellerLevel.getSellerLevelPoint());
		sellerLevel.setCreateTime(sellerLevel.getCreateTime());
		sellerLevel.setEditTime(sellerLevel.getEditTime());
		
		sellerLevelRepository.save(sellerLevel);
		HeaderRes headerRes = new HeaderRes();
		UpdateSellerLevelRes updateSellerLevelRes = new UpdateSellerLevelRes();
		updateSellerLevelRes.setHeaderRes(headerRes);
		return updateSellerLevelRes;
	}
	
	public DeleteSellerLevelRes deleteSellerLevel (BigInteger sellerLevelId) throws IOException, DataNotFoundException {
		sellerLevelRepository.deleteById(sellerLevelId);
		
		HeaderRes headerRes = new HeaderRes();
		DeleteSellerLevelRes deleteSellerLevelRes = new DeleteSellerLevelRes();
		deleteSellerLevelRes.setHeaderRes(headerRes);
		return deleteSellerLevelRes;
		
	}
	
	
}
