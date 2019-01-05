package com.pcitc.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
@Api(value = "Decision-API",description = "经费决策中心相关的接口")
@RestController
@RequestMapping("/hana/scientificFunds") 
public class ScientificFundsProvideClient {
	
}
