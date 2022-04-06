package com.example.moviedbkorpimaki;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.moviedbkorpimaki.model.Movie;
import com.example.moviedbkorpimaki.model.MovieCategory;
import com.example.moviedbkorpimaki.model.MovieCategoryRepository;
import com.example.moviedbkorpimaki.model.MovieRepository;
import com.example.moviedbkorpimaki.model.User;
import com.example.moviedbkorpimaki.model.UserRepository;

@SpringBootApplication
public class MoviedbKorpimakiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviedbKorpimakiApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner movieDemo(MovieRepository repository, MovieCategoryRepository mrepository, UserRepository urepository) {
		return(args)-> {
		//adding some movie categories		
			System.out.println("saving movie categories");
			mrepository.save(new MovieCategory("Horror"));
			mrepository.save(new MovieCategory("Romance"));
			mrepository.save(new MovieCategory("Sci-Fi"));
			
			//Adding some movies to the db
			System.out.println("saving movies");
			repository.save(new Movie("Focus", "Glenn Ficarra", 2015, 105, mrepository.findByName("Romance").get(0)));
			repository.save(new Movie("Interstellar", "Christopher Nolan", 2014, 169, mrepository.findByName("Sci-Fi").get(0)));
		
			//adding users to for the login
			
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "user.user@email.com" ,"USER");
			User user2 = new User("admin", "$2a$08$bCCcGjB03eulCWt3CY0AZew2rVzXFyouUolL5dkL/pBgFkUH9O4J2", "admin.admin@email.com" ,"ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			System.out.println("Fetching all movies");
			for(Movie movie : repository.findAll()) {
				System.out.println(movie.toString());
			}
		};
}
}
