package com.example.moviedbkorpimaki.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface MovieCategoryRepository extends CrudRepository<MovieCategory, Long>{

	List<MovieCategory> findByName(String name);
}
