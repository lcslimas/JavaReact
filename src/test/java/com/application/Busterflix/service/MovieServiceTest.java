package com.application.Busterflix.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.application.Busterflix.Model.Movie;
import com.application.Busterflix.Repo.MovieRepo;
import com.application.Busterflix.service.impl.MovieService;
import com.application.Busterflix.service.impl.MovieServiceImpl;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class MovieServiceTest {
	MovieService service;
	
	@Mock
	MovieRepo repository;
	
	@BeforeEach
	public void setUp() {
		service = new MovieServiceImpl(repository);
	}
	
	@Test
	public void saveTest() {
		Movie movie = new Movie("Nome", "Descrição", "urlImg");
		
		when(repository.save(movie)).thenReturn(movie);
		
		Movie movieSaved = service.save(movie);
		
		assertEquals(movie.getId(), movieSaved.getId());
		assertEquals(movie.getName(), movieSaved.getName());
		assertEquals(movie.getDescription(), movieSaved.getDescription());
		assertEquals(movie.getImage(), movieSaved.getImage());
	}
	
	@Test
	public void findAllTest() {
		Movie movie1 = new Movie("Nome", "Descrição", "urlImg");
		Movie movie2 = new Movie("Nome2", "Descrição2", "urlImg2");
		
		List<Movie> movies = new ArrayList<Movie>();
		
		movies.add(movie1);
		movies.add(movie2);
		
		when(repository.findAll()).thenReturn(movies);
		
		List<Movie> moviesSaved = service.findAll();
		
		assertEquals(movies.size(), moviesSaved.size());
		assertEquals(movies.get(0).getId(), moviesSaved.get(0).getId());
		assertEquals(movies.get(1).getId(), moviesSaved.get(1).getId());
	}
	
	@Test
	public void findByIdTest() throws Exception {
		Long id = 1l;
		Movie movie = new Movie("Nome", "Descrição", "urlImg");
		movie.setId(id);
		
		when(repository.findById(id)).thenReturn(Optional.of(movie));
		
		Movie movieFound = service.findById(id);
		
		assertEquals(movieFound.getId(), movieFound.getId());
		assertEquals(movieFound.getName(), movieFound.getName());
		assertEquals(movieFound.getDescription(), movieFound.getDescription());
		assertEquals(movieFound.getImage(), movieFound.getImage());
	}
	
	@Test
	public void findByIdNotFoundTest() throws Exception {
		Long id = 1l;
		Movie movie = new Movie("Nome", "Descrição", "urlImg");
		movie.setId(id);
		try {
			when(repository.findById(id)).thenReturn(null);
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Filme não encontrado");
		}
		
	}
	
	@Test
	public void deleteTest() throws Exception {
		Long id = 1l;
		Movie movie = new Movie("Nome", "Descrição", "urlImg");
		movie.setId(id);
		when(repository.findById(id)).thenReturn(Optional.of(movie));
		
		service.delete(id);
		
		verify(repository).deleteById(id);
	}
	
	@Test
	public void deleteNotFoundTest() throws Exception {
		Long id = 1l;
		Movie movie = new Movie("Nome", "Descrição", "urlImg");
		movie.setId(id);
		when(repository.findById(id)).thenReturn(Optional.of(movie));
		
		service.delete(id);
		try {
			when(repository.findById(id)).thenReturn(null);
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Filme não encontrado");
		}
	}
}
