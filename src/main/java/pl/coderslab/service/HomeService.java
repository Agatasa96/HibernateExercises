package pl.coderslab.service;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.coderslab.entity.Article;

@Service
@Transactional
public class HomeService {
	
	@PersistenceContext
	private EntityManager entity;
	


	public HomeService(EntityManager entity) {
		
		this.entity = entity;
	}



	
	public List<Article> lastFive() {
		Query query = entity.createQuery("Select a from Article a where created<:data");
		query.setParameter("data", LocalDate.now());
		query.setMaxResults(5);
		//model.addAttribute("result", query.getResultList());
		return query.getResultList();
	}

}
