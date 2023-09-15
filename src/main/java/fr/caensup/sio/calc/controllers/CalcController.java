package fr.caensup.sio.calc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import fr.caensup.sio.calc.models.Calculatrice;

@Controller
@SessionAttributes("calc")
public class CalcController {

	@ModelAttribute("calc")
	public Calculatrice getCalc() {
		return new Calculatrice();
	}

	@RequestMapping("")
	public ModelAndView indexAction() {
		ModelAndView mView = new ModelAndView("index");
		return mView;
	}

	@PostMapping("/calc")
	public RedirectView calcAction(@RequestParam(required = false) String number,
			@RequestParam(required = false) String operator, @SessionAttribute("calc") Calculatrice calc) {
		if (number != null) {
			calc.send(number, true);
		} else {
			calc.send(operator, false);
		}
		return new RedirectView("/");
	}
}
