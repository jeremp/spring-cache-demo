package com.jeremp.cachedemo.services;

import com.jeremp.cachedemo.data.entities.City;
import com.jeremp.cachedemo.data.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jpasseron
 */
@Service
public class CityService {

	@Autowired
	private CityRepository cityRepository ;
	
	public Iterable<City> findAllCities(){
		return cityRepository.findAll();
	}
	
	public City findByUuid(String uuid){
		return cityRepository.findOneByUuid(uuid);
	}
	
	
	
}
