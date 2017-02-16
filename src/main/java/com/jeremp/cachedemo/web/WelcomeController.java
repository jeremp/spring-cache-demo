package com.jeremp.cachedemo.web;

import com.jeremp.cachedemo.services.CinemaService;
import com.jeremp.cachedemo.services.CityDataService;
import com.jeremp.cachedemo.services.CityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author jpasseron
 */
@Controller
public class WelcomeController {
	
	private static final Logger LOG = LoggerFactory.getLogger(WelcomeController.class);
	
	@Autowired
	private CinemaService cinemaService ;
	
	@Autowired
	private CityService cityService ;
	
	@Autowired
	private CityDataService dataService ;
	
	@RequestMapping("/")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {        
		model.addAttribute("cities", cityService.findAllCities());
        return "greeting";
    }
	
	@RequestMapping("/data")
    public String data(@RequestParam(value="uuid") String uuid, Model model) {
        model.addAttribute("uuid", uuid);
		model.addAttribute("data", dataService.retrieveCityData(uuid));
		model.addAttribute("city", cityService.findByUuid(uuid));
        return "data";
    }
	
	@RequestMapping(value = "/data/edit", method = RequestMethod.POST)
    public String edit(@RequestParam String uuid, @RequestParam String mayor, @RequestParam long population, Model model) {
        LOG.info("on edite {}", uuid);
		dataService.edit(uuid, mayor, population);
		model.addAttribute("cities", cityService.findAllCities());
        return "greeting";
    }
	
}
