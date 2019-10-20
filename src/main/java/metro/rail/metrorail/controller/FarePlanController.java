package metro.rail.metrorail.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import metro.rail.metrorail.model.FarePlan;
//import metro.rail.metrorail.service.FarePlanService;
import metro.rail.metrorail.service.FarePlanService;

@Controller
public class FarePlanController {

	@Autowired
	private FarePlanService farePlanService;
	

	
	@RequestMapping(value = "/newFarePlan", method=RequestMethod.GET)
	public ModelAndView newFarePlan(ModelAndView model){
		
		List<FarePlan> plan = farePlanService.listFarePlan();
		model.addObject("plan", plan);
		
		FarePlan farePlan = new FarePlan();
		model.addObject("farePlan", farePlan);
		
		model.setViewName("dashboard/fare/newFarePlan");
		return model;
	}
	
	@RequestMapping(value="/saveFarePlan", method = RequestMethod.POST)
	public ModelAndView saveStation(@ModelAttribute FarePlan farePlan) {
		
		farePlanService.addFarePlan(farePlan);
		return new ModelAndView("redirect:/newFarePlan");
	}
	
	@RequestMapping(value="/updateFarePlan")
	public ModelAndView update(@RequestParam(name = "id") long id) {
		
		FarePlan farePlan = (FarePlan) farePlanService.getFarePlan(id);
		ModelAndView model = new ModelAndView("dashboard/fare/updateFarePlan");
		model.addObject("farePlan", farePlan);
		return model;
	}
	
	
}
