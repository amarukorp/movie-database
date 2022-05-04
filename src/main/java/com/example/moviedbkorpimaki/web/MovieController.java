package com.example.moviedbkorpimaki.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.moviedbkorpimaki.model.Movie;
import com.example.moviedbkorpimaki.model.MovieCategory;
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
	
		@RequestMapping(value = "/add")
	    public String addMovie(Model model){
	    	model.addAttribute("movie", new Movie());
	    	model.addAttribute("categories", mrepository.findAll());
	        return "addmovie";
	    }
		@RequestMapping(value= "/addCategory")
		public String addCategory(Model model) {
			model.addAttribute("category", new MovieCategory());
			return "addCategory";
		}
		
		@RequestMapping(value="/saveCategory")
		public String saveCategory(MovieCategory category) {
			mrepository.save(category);
			return "redirect:movielist";
		}
		
	    @RequestMapping(value = "/save", method = RequestMethod.POST)
	    public String save(Movie movie){
	        repository.save(movie);
	        return "redirect:movielist";
	    }
	    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	    public String deleteMovie(@PathVariable("id") Long movieId, Model model) {
	    	repository.deleteById(movieId);
	    	return "redirect:../movielist";
	    }
	    @RequestMapping(value = "/edit/{id}", method= RequestMethod.GET)
	    public String editMovie (@PathVariable("id") Long id, Model model) {
	    	model.addAttribute("movie", repository.findById(id));
	    	model.addAttribute("categories", mrepository.findAll());
	    	return "editmovie";
	    }
}

