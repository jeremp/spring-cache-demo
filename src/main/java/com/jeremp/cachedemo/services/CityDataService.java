
package com.jeremp.cachedemo.services;

import com.jeremp.cachedemo.data.entities.CityData;
import com.jeremp.cachedemo.data.repositories.CityDataRepository;
import com.jeremp.cachedemo.web.WelcomeController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 *
 * @author jpasseron
 */
@Service
public class CityDataService {
	
	private static final Logger LOG = LoggerFactory.getLogger(WelcomeController.class);
	
	@Autowired
	private CityDataRepository dataRepository ;
	
	@Cacheable(cacheNames="citydata", key="#uuid")
	public CityData retrieveCityData(String uuid){
		LOG.info("looking for the city {} informations...", uuid);		
		simulateSlowRequest(3);
		return dataRepository.findOne(uuid);
	}
	
	@CachePut(cacheNames="citydata", key="#uuid")
	public CityData edit(String uuid, String mayor, long population){
		CityData cityData = dataRepository.findOne(uuid);
		cityData.setMayor(mayor);
		cityData.setPopulation(population);
		return dataRepository.save(cityData);
	}
	
	private void simulateSlowRequest(int seconds){
	   /* AWFUL Hack to make it slow */
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			LOG.error("something goes wrong while trying to sleep", e);
		}
	}
	
}
