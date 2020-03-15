package com.application.Busterflix;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepo extends CrudRepository<Movie, Long>{
}
