package com.jeremp.cachedemo.data.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author jpasseron
 */
@Entity
public class CityData implements Serializable {
	
	@Id    
    private String uuid;
	
	private long population ;
	private String mayor ;

	public CityData() {
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public long getPopulation() {
		return population;
	}

	public void setPopulation(long population) {
		this.population = population;
	}

	public String getMayor() {
		return mayor;
	}

	public void setMayor(String mayor) {
		this.mayor = mayor;
	}
	
}
