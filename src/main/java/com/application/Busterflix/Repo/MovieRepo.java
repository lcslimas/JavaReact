package com.application.Busterflix.Repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.application.Busterflix.Model.Movie;

@Repository
public interface MovieRepo extends PagingAndSortingRepository<Movie, Long>{
	
}
