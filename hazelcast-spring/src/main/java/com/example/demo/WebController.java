package com.example.demo;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class WebController {

	@RequestMapping(value = "/")
	public String index(HttpSession httpSession) {

		Integer hits = (Integer) httpSession.getAttribute("hits");
		if (hits == null) {
			hits = 0;
		}
		
		httpSession.setAttribute("hits", ++hits);

		return "index";
	}
}
