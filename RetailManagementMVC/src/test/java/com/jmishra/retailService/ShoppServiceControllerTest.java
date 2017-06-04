package com.jmishra.retailService;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.jmishra.retailService.Service.ShopServiceImpl;
import com.jmishra.retailService.controller.ShopServiceController;
import com.jmishra.retailService.model.Address;
import com.jmishra.retailService.model.Shop;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ShopServiceController.class, secure = false)
public class ShoppServiceControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ShopServiceImpl shopService;
	
	Shop tempShop= new Shop("Shop_1","MyFashionStop", new Address("15A","Green Park Market","New Delhi"));
	
	String exampleJSON = "{"+
    "\"id\": \"Shop_4\","+
    "\"shopName\": \"MyJewelleryStop\","+
    "\"shopAddress\": {"+
      "\"shopNumber\": \"15/1B\","+
      "\"shopStreet\": \"Hauz Khas Market\","+
      "\"shopcity\": \"New Delhi\""+
    "}"+
  "}";
	
	@Test
	public void retrieveDetailsForShop() throws Exception {
		Mockito.when(shopService.getAShopDetails(Mockito.anyString())).thenReturn(tempShop);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/shops/Shop_1").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		String expected = "{"+
			    "\"id\": \"Shop_1\","+
			    "\"shopName\": \"MyFashionStop\","+
			    "\"shopAddress\": {"+
			      "\"shopNumber\": \"15A\","+
			      "\"shopStreet\": \"Green Park Market\","+
			      "\"shopcity\": \"New Delhi\""+
			    "}"+
			  "}";

		// {"id":"Course1","name":"Spring","description":"10 Steps, 25 Examples and 10K Students","steps":["Learn Maven","Import Project","First Example","Second Example"]}

		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}
	
	@Test
	public void addANewShop() throws Exception {
		
		Shop tempShop2= new Shop("Shop_4", "MyJewelleryStop", new Address("15/1B","Hauz Khas Market","New Delhi"));
		
		Mockito.when(shopService.addShop(Mockito.any(Shop.class))).thenReturn(tempShop2);
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/shops")
				.accept(MediaType.APPLICATION_JSON).content(exampleJSON)
				.contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();
		
		String expectedString = "{"+
			    "\"id\": \"Shop_4\","+
			    "\"shopName\": \"MyJewelleryStop\","+
			    "\"shopAddress\": {"+
			      "\"shopNumber\": \"15/1B\","+
			      "\"shopStreet\": \"Hauz Khas Market\","+
			      "\"shopcity\": \"New Delhi\""+
			    "}"+
			  "}";

		JSONAssert.assertEquals(expectedString, result.getResponse().getContentAsString(), false);
		//assertEquals(HttpStatus.CREATED.value(), response.getStatus());

		//assertEquals("http://localhost:8080/shops/Shop_4",
				//response.getHeader(HttpHeaders.LOCATION));
	}
	
}
