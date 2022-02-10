package com.application.Busterflix.Controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.application.Busterflix.Controller.Api.MovieController;
import com.application.Busterflix.Model.Movie;
import com.application.Busterflix.service.impl.MovieService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class AppControllerTest {
	MovieController controller;
	String api = "/api/movies";
	
	@Autowired
	MockMvc mvc;
	
	@MockBean
	MovieService service;
	
	@Test
	@DisplayName("Acessa a página inicial")
	public void indexTest() throws Exception {
		mvc.perform(get("/movies"))
			.andDo(print())
			.andExpect(status().isOk());
	}
	
	@Test
	@DisplayName("Insere Filme")
	public void insereTest() throws Exception {
		Movie movie = new Movie("Nome", "Descrição", "urlImg");

		when(service.save(movie)).thenReturn(movie);
		
		mvc.perform(post(api+"/new")
				.contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(movie)))
			.andDo(print())
			.andExpect(jsonPath("$.name", is(movie.getName())))
			.andExpect(jsonPath("$.description", is(movie.getDescription())))
			.andExpect(jsonPath("$.image", is(movie.getImage())))
			.andExpect(status().isOk());
		
		verify(service).save(movie);
	}
	
	@Test
	public void findByIdTest() throws Exception {
		Long id = 2l;
		Movie movie = new Movie("Nome", "Descrição", "urlImg");
		movie.setId(id);
		when(service.findById(id)).thenReturn(movie);
		
		mvc.perform(get(api+"/"+ id))
			.andDo(print())
			.andExpect(jsonPath("$.id", is(Integer.parseInt(id.toString()))))
			.andExpect(jsonPath("$.name", is(movie.getName())))
			.andExpect(jsonPath("$.description", is(movie.getDescription())))
			.andExpect(jsonPath("$.image", is(movie.getImage())))
			.andExpect(status().isOk());
	}
	
	@Test
	@DisplayName("Acessa página de edição de filme")
	public void deleteTest() throws Exception {
		Long id = 2l;
		Movie movie = new Movie("Nome", "Descrição", "urlImg");
		movie.setId(id);
		when(service.findById(id)).thenReturn(movie);
		
		mvc.perform(delete(api+"/"+ id))
			.andDo(print())
			.andExpect(status().isOk());
		verify(service).delete(id);
	}
	
    static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
