package pl.coderslab.controller;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.coderslab.entity.Article;
import pl.coderslab.service.HomeService;

@Controller
public class HomePageController {
private final HomeService homeService;
	

	public HomePageController(HomeService homeService) {
		
		this.homeService = homeService;
	}



	@RequestMapping("/")
	@ResponseBody
	public String lastFive(Model model) {
		List<Article> articles = homeService.lastFive();
		model.addAttribute("result", articles);
		return "five";
	}
}