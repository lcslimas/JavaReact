package com.application.Busterflix.Repo;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.application.Busterflix.Model.Movie;

@Repository
public interface MovieRepo extends PagingAndSortingRepository<Movie, Long>{
	
}
