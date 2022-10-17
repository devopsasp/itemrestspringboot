package com.itemrestapp.itemrestapp;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import com.dao.ItemDao;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.Item;

@SpringBootTest
class ItemTest {

	@Autowired
	ItemDao itemDao;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
System.out.println("setup started");
System.out.println("saved");
	
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
	     Item item=new Item();
	     item.setItemName("Coffee");
	     item.setPrice(20);
	     item.setQuantity(20);
	     itemDao.save(item);
	     
	     Item item1=itemDao.findById(item.getItemId()).get();
	     
	     Assertions.assertEquals(item.getItemName(), item1.getItemName());
	     
	     
	}
	
	
	
	@Test
	  void test1() throws URISyntaxException, JsonProcessingException {
		
		 
   
		
		
		RestTemplate template=new RestTemplate();
		final String url="http://localhost:9091/findbyid/1";
		URI uri=new URI(url);
		
		ResponseEntity<String> res=template.getForEntity(uri,String.class);
		Assertions.assertEquals(HttpStatus.OK,res.getStatusCode());
		
	}

}
