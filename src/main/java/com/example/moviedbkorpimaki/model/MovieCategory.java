package com.example.moviedbkorpimaki.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class MovieCategory {
	
	//Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long movieCategoryId;
	private String name;
	
	@JsonIgnore
	@OneToMany(cascade= CascadeType.ALL, mappedBy= "category")
	private List<Movie> movies;

	//constructors
	public MovieCategory() {
		super();
	}

	public MovieCategory(String name) {
		super();
		this.name = name;
	}

	public Long getMovieCategoryId() {
		return movieCategoryId;
	}

	public void setMovieCategoryId(Long movieCategoryId) {
		this.movieCategoryId = movieCategoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}
	
	
	
}
