package com.cts.pension.process.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cts.pension.process.exception.AadharNumberNotFound;
import com.cts.pension.process.exception.AuthorizationException;
import com.cts.pension.process.model.ProcessPensionInput;
import com.cts.pension.process.model.ProcessPensionResponse;

	

@FeignClient(name = "PensionDisbursement-Microservices",url = "http://PMS-877629-Microser-lb-1715310510.us-east-1.elb.amazonaws.com/disbursement/api/v1")
public interface PensionDisbursementFeignClient {
	
	@PostMapping("/disbursePension")
	public ProcessPensionResponse getResponse(
			@RequestHeader(value = "Authorization", required = true) String requestTokenHeader,
			@RequestBody ProcessPensionInput processpensionInput) throws AuthorizationException, AadharNumberNotFound;
	
}
