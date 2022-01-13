package hr.matija.demopraksa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomePageController {

	private String getHomePage() {
		return "index";
	}

}
