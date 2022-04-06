package com.example.moviedbkorpimaki.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.moviedbkorpimaki.model.MovieCategoryRepository;
import com.example.moviedbkorpimaki.model.MovieRepository;

@Controller
public class MovieController {

		@Autowired
		private MovieRepository repository;
		
		@Autowired
		private MovieCategoryRepository mrepository;
		
		@RequestMapping(value = {"/", "/movielist"})
		public String Movielist(Model model) {
			model.addAttribute("movies", repository.findAll());
			return "movielist";
		}
		
		@RequestMapping(value="/login")
		public String login() {
			return "login";
		}  
	
}

