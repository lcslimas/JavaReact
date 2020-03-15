package com.application.Model;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepo extends PagingAndSortingRepository<Movie, Long>{
	
	 List<Movie> findByName(@Param("name") String name);
}
