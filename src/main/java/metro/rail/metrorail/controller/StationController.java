package metro.rail.metrorail.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import metro.rail.metrorail.model.Station;
import metro.rail.metrorail.service.StationService;

@Controller
public class StationController {
	
	@Autowired
	private StationService stationService;

	@RequestMapping(value = "/newStation", method = RequestMethod.GET)
	public ModelAndView newStation(ModelAndView model) {
			
		Station station = new Station();
		model.addObject("station", station);
		model.setViewName("dashboard/addStation");
		return model;		
	}
	
	@RequestMapping(value="/saveStation", method = RequestMethod.POST)
	public ModelAndView saveStation(@ModelAttribute Station station){
		
		stationService.addStation(station);
		return new ModelAndView("redirect:/viewStation");
	}
	
	@RequestMapping(value="/viewStation")
	public ModelAndView viewStation(ModelAndView model) {
		
		model.setViewName("dashboard/viewStation");
		
		List<Station> station = stationService.getAllStations();
		model.addObject("station", station);
		System.out.println("view station");
		return model;
	}
	
	
}
