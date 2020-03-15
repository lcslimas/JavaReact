package com.application.Busterflix;

import java.sql.Date;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name="movie")
public class Movie {
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
	private String name;
	private String description;
	private Date releaseDate;
	 
	private Movie() {};
	
	public Movie(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	@Override
	public boolean equals(Object o) {
		if(this==o) {
			return true;
		}else if(o==null || getClass() != o.getClass()) {
			return false;
		}
		Movie movie = (Movie) o;
		return Objects.equals(id,movie.id) &&
				Objects.equals(description,movie.description) &&
				Objects.equals(name,movie.name);
		
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id,name,description);
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
