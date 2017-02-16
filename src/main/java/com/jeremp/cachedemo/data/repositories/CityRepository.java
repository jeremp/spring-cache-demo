
package com.jeremp.cachedemo.data.repositories;

import com.jeremp.cachedemo.data.entities.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jpasseron
 */
@Repository
public interface CityRepository extends CrudRepository<City, Long>{
	
	public City findOneByUuid(String uuid);
	
}
