
package com.jeremp.cachedemo.data.repositories;


import com.jeremp.cachedemo.data.entities.CityData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jpasseron
 */
@Repository
public interface CityDataRepository extends CrudRepository<CityData, String>{
	
}
