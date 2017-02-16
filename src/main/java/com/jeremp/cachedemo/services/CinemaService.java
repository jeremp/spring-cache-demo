package com.jeremp.cachedemo.services;

import com.jeremp.cachedemo.data.entities.Movie;
import com.jeremp.cachedemo.data.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jpasseron
 */
@Service
public class CinemaService {
	
	@Autowired
	private MovieRepository movieRepository ;
	
	public Iterable<Movie> findAllMovies(){
		return movieRepository.findAll();
	}
	
}
