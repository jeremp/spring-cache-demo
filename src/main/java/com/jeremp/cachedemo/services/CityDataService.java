
package com.jeremp.cachedemo.services;

import com.jeremp.cachedemo.data.entities.CityData;
import com.jeremp.cachedemo.data.repositories.CityDataRepository;
import com.jeremp.cachedemo.web.WelcomeController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
	
	public CityData retrieveCityData(String uuid){
		LOG.info("looking for the city {} informations...", uuid);
		return dataRepository.findOne(uuid);
	}
	
	public CityData edit(String uuid, String mayor, long population){
		CityData cityData = dataRepository.findOne(uuid);
		cityData.setMayor(mayor);
		cityData.setPopulation(population);
		return dataRepository.save(cityData);
	}
	
}
