package metro.rail.metrorail.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
	
	@RequestMapping(value="/")
	public String test(ModelAndView model){
		System.out.println("Hello------");
		return "dashboard/index";
	}
}
