package cz.bernhard.slovicka.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cz.bernhard.slovicka.services.ITranslateService;

@Controller
public class WebController {
	
	@Autowired
	public ITranslateService translateService;

//	@RequestMapping(value = "/index")
//	public ModelAndView index() {
//		return new ModelAndView("index");
//	}
	
	@RequestMapping(value = "/translate")
	public ModelAndView index(@RequestParam(required=false) String word) {
		ModelAndView mv = new ModelAndView();
		
		if (word != null) {
			mv.addObject("translation", translateService.translate(word, "en", "cs"));
		}
		
		mv.setViewName("translate");
		return mv;
	}
	
	
}