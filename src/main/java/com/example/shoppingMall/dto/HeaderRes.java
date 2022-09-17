package com.example.shoppingMall.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class HeaderRes implements Serializable {
    private static final long serialVersionUID = 1L;    
	
    @JsonProperty("RETURNCODE")
    private String returnCode;
    
    @JsonProperty("RETURNDESC")
    private String returnDesc; 
}
