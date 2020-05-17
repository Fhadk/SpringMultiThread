package com.SpringMultiThread.controller;

import java.math.BigDecimal;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringMultiThread.config.AsyncConfiguration;
import com.SpringMultiThread.service.MultiThreadManager;

@RestController
@RequestMapping("/api/HXC")
public class RequestController {
	@Autowired
	MultiThreadManager multiTheradManager;

	private Logger logger = Logger.getLogger(RequestController.class);

	/**
	 * 
	 * @param MSISDN
	 * @param source
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getServiceStatus/{MSISDN}/{source}")
	public ResponseEntity<Object> getServiceStatus(@PathVariable(value = "MSISDN", required = true) String MSISDN,
			@PathVariable(value = "source", required = true) String source) throws Exception {

		logger.info("Function: " + "getServiceStatus" + " MSISDN: " + MSISDN + " Source: " + source);
		return new ResponseEntity<Object>(multiTheradManager.getServiceStatus(MSISDN, source), HttpStatus.OK);
	}

}
