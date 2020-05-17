package com.SpringMultiThread.service;

import java.io.StringReader;
import java.math.BigDecimal;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import com.SpringMultiThread.controller.RequestController;
import com.SpringMultiThread.model.Customer;

/**
 * 
 * @author Fhadk
 *
 */

@Service
public class MultiThreadManager {

	private Logger logger = Logger.getLogger(MultiThreadManager.class);
	private Customer obj;

	public MultiThreadManager() {
		obj = new Customer();
	}
	
	@Async
	public Customer getServiceStatus(String MSISDN, String source) {
		try {
			logger.info(" Setting object Values ");
			obj.setMSISDN(MSISDN);
			obj.setSource(source);
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return obj;
	}
}
