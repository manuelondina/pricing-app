package com.inditex.testapp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class TestAppApplicationTests {
	@Autowired
	private MockMvc mockMvc;

	@Test
	@DisplayName("Expected price is 35.5")
	public void test1_At10AM_OnDay14th() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/prices/getProductPrice")
				.param("brandId", "1")
				.param("applicationDate", "2020-06-14 10:00:00")
				.param("productId", "35455")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.finalPrice").value(35.5));
	}

	@Test
	@DisplayName("Expected price is 25.45")
	public void test2_At4PM_OnDay14th() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/prices/getProductPrice")
				.param("brandId", "1")
				.param("applicationDate", "2020-06-14 16:00:00")
				.param("productId", "35455")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.finalPrice").value(25.45));
	}

	@Test
	@DisplayName("Expected price is 35.5")
	public void test3_At9PM_OnDay14th() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/prices/getProductPrice")
				.param("brandId", "1")
				.param("applicationDate", "2020-06-14 21:00:00")
				.param("productId", "35455")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.finalPrice").value(35.5));
	}

	@Test
	@DisplayName("Expected price is 30.5")
	public void test4_At10AM_OnDay15th() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/prices/getProductPrice")
				.param("brandId", "1")
				.param("applicationDate", "2020-06-15 10:00:00")
				.param("productId", "35455")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.finalPrice").value(30.5));
	}

	@Test
	@DisplayName("Expected price is 38.95")
	public void test5_At9PM_OnDay16th() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/prices/getProductPrice")
				.param("brandId", "1")
				.param("applicationDate", "2020-06-16 21:00:00")
				.param("productId", "35455")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.finalPrice").value(38.95));
	}
}
