package com.example.shoppingMall.controller;

import java.io.IOException;
import java.math.BigInteger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.shoppingMall.dto.SellerLevelDto;
import com.example.shoppingMall.dto.sellerLevel.CreateSellerLevelReq;
import com.example.shoppingMall.dto.sellerLevel.CreateSellerLevelRes;
import com.example.shoppingMall.dto.sellerLevel.DeleteSellerLevelReq;
import com.example.shoppingMall.dto.sellerLevel.DeleteSellerLevelRes;
import com.example.shoppingMall.dto.sellerLevel.UpdateSellerLevelReq;
import com.example.shoppingMall.dto.sellerLevel.UpdateSellerLevelRes;
import com.example.shoppingMall.exception.DataNotFoundException;
import com.example.shoppingMall.exception.ErrorInputException;
import com.example.shoppingMall.service.SellerLevelService;

@RestController
public class SellerLevelController {

	@Autowired
	private SellerLevelService sellerLevelService;
	
	

	@PostMapping(value = "/sellerLevel/create")
	public CreateSellerLevelRes createSellerLevel(@Valid @RequestBody CreateSellerLevelReq req, Errors err)
			throws IOException, ErrorInputException, DataNotFoundException {
		if (err.hasErrors()) {
			throw new ErrorInputException();
		}
		SellerLevelDto sellerLevelDto = req.getSellerLevel();
		return sellerLevelService.createSellerLevel(sellerLevelDto);

	}

	@PostMapping(value = "/sellerLevel/update")
	public UpdateSellerLevelRes updateSellerLevel(@Valid @RequestBody UpdateSellerLevelReq req, Errors err)
			throws IOException, ErrorInputException, DataNotFoundException {
		if (err.hasErrors()) {
			throw new ErrorInputException();
		}
		SellerLevelDto sellerLevelDto = req.getSellerLevel();
		return sellerLevelService.updateSellerLevel(sellerLevelDto);

	}

	@PostMapping(value = "/sellerLevel/delete")
	public DeleteSellerLevelRes deleteSellerLevelRes(@Valid @RequestBody DeleteSellerLevelReq req, Errors err)
			throws IOException, ErrorInputException, DataNotFoundException {
		if (err.hasErrors()) {
			throw new ErrorInputException();
		}
		BigInteger sellerLevelId = req.getSellerLevelId();
		return sellerLevelService.deleteSellerLevel(sellerLevelId);

	}

	
}
