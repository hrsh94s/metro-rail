package metro.rail.metrorail.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import metro.rail.metrorail.model.MetroCard;
import metro.rail.metrorail.model.RechargeCard;
import metro.rail.metrorail.service.MetroCardService;

@Controller
public class MetroCardController {

	@Autowired
	private MetroCardService metroCardService;
	
	@RequestMapping(value = "/newMetroCard", method = RequestMethod.GET)
	public ModelAndView newMetroCard(ModelAndView model) {
		List<MetroCard> metroCards = metroCardService.listMetroCard();
		model.addObject("metroCards", metroCards);
		MetroCard metroCard = new MetroCard();
		model.addObject("metroCard", metroCard);
		model.setViewName("dashboard/newMetroCard");
		return model;
	}
	
	@RequestMapping(value = "/saveMetroCard", method = RequestMethod.POST)
	public ModelAndView saveMetroCard(@ModelAttribute MetroCard metroCard, ModelAndView model) {
		metroCardService.newMetroCard(metroCard);
		
		return new ModelAndView("redirect:/newMetroCard");
			
		
	}

	
	
	@RequestMapping(value = "/rechargeCard", method=RequestMethod.POST)
	public ModelAndView rechargeCard(@ModelAttribute RechargeCard rechargeCard){
		
		
		ModelAndView model = new ModelAndView();
		float balance = metroCardService.recharge(rechargeCard);
		model.addObject("balance", balance);
		model.setViewName("dashboard/user/rechargeCard");
		
		return model;
		
	}
	
	@RequestMapping(value = "/deleteMetroCard")
	public ModelAndView deleteMetroCard(@RequestParam(name = "id") long id) {
		
		metroCardService.deleteMetroCard(id);
		return new ModelAndView("redirect:/newMetroCard");
	}
	
	@RequestMapping(value = "/cardInitials")
	public ModelAndView recharge() {
		
		ModelAndView model = new ModelAndView();
		RechargeCard rechargeCard = new RechargeCard();
		model.addObject("recharge", rechargeCard);
		model.setViewName("dashboard/user/cardInitials");
		return model;
		
	}
}
