package com.application.Busterflix;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepo extends PagingAndSortingRepository<Movie, Long>{
	
}
