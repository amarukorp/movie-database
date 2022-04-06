package com.example.moviedbkorpimaki.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Movie {
	
	//Attributes
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long id;
	
	private String title;
	private String director;
	private int releaseYear;
	private int length;
	
	@ManyToOne
	@JoinColumn(name= "movieCategoryId")
	private MovieCategory category;
	
	// Constructors
	public Movie() {
		super();
	}
	
	public Movie(String title, String director, int releaseYear, int length, MovieCategory category ) {
		super();
		this.title = title;
		this.director = director;
		this.releaseYear = releaseYear;
		this.length = length;
		this.category= category;
	}
	
	//getters and setters for all attributes
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDirector() {
		return director;
	}
	
	public void setDirector(String director) {
		this.director = director;
	}
	
	public int getReleaseYear() {
		return releaseYear;
	}
	
	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}
	
	public int getLength() {
		return length;
	}
	
	public void setLength(int length) {
		this.length = length;
	}

	public MovieCategory getCategory() {
		return category;
	}

	public void setCategory(MovieCategory category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", director=" + director + ", releaseYear=" + releaseYear
				+ ", length=" + length + ", category=" + category + "]";
	}
	
	
	
	
	
	
}
