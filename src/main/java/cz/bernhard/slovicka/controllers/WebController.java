package cz.bernhard.slovicka.controllers;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cz.bernhard.slovicka.services.ITranslationService;

/**
 * Controller for handling all standard web requests (ie. not rest api, not mobile version)
 * 
 * @author Michal Bernhard <michal@bernhard.cz>
 *
 */
@Controller
public class WebController {
	
	@Autowired public ITranslationService translateService;
	
	@RequestMapping(value = "/translate")
	public ModelAndView index(@RequestParam(required=false) String word) {
		ModelAndView mv = new ModelAndView();
		
		if (!StringUtils.isBlank(word)) {
			mv.addObject("translation", translateService.translate(word, "en", "cs"));
			mv.addObject("word", word);
		}
		
		mv.setViewName("translate");
		return mv;
	}
	
	
}
