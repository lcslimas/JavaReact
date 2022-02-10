package com.application.Busterflix.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.application.Busterflix.Model.Movie;
import com.application.Busterflix.Repo.MovieRepo;

@Service
public class MovieServiceImpl implements MovieService {
	MovieRepo repository;
	
	public MovieServiceImpl(MovieRepo repository) {
		this.repository = repository;
	}

	@Override
	public Movie save(Movie movie) {
		return repository.save(movie);
	}

	@Override
	public List<Movie> findAll() {
		List<Movie> movies = new ArrayList<Movie>();
		
		repository.findAll()
			.forEach(movies::add);
		
		return movies;
	}
	
	@Override
	public void delete(Long id) throws Exception {
		Optional<Movie> movie = repository.findById(id);
		
		if(movie.isPresent()) {
			repository.deleteById(id);
		} else {
			throw new Exception("Filme não encontrado");
		}
	}

	@Override
	public Movie findById(Long id) throws Exception {
		Optional<Movie> movie = repository.findById(id);
		
		if(movie != null && movie.isPresent()) {
			return movie.get();
		} else {
			throw new Exception("Filme não encontrado");
		}
	}
}
