package com.application.Busterflix.Controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

@ActiveProfiles("test")
@AutoConfigureMockMvc
@SpringBootTest
public class AppControllerTest {
	AppController controller;
	String api = "/api/movies";
	@Autowired
	MockMvc mvc;
		
	@Test
	@DisplayName("Acessa a página inicial")
	public void indexTest() throws Exception {
		mvc.perform(get("/"))
			.andDo(print())
			.andExpect(status().isOk());
	}
}
