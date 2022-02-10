package com.application.Busterflix.service.impl;

import java.util.List;

import com.application.Busterflix.Model.Movie;

public interface MovieService {

	Movie save(Movie movie);

	List<Movie> findAll();

	void delete(Long id) throws Exception;

	Movie findById(Long id) throws Exception;
}
