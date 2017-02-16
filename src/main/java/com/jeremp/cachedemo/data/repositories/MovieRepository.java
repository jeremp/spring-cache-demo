package com.jeremp.cachedemo.data.repositories;

import com.jeremp.cachedemo.data.entities.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jpasseron
 */
@Repository
public interface MovieRepository extends CrudRepository<Movie, Long>{
	
}
