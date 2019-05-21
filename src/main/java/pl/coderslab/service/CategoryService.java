package pl.coderslab.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import pl.coderslab.entity.Category;

@Service
public class CategoryService {

	List<Category> categories = new ArrayList<>();

	public CategoryService(List<Category> categories) {
		categories.add(new Category("name1", "desc1"));
		categories.add(new Category("name2", "desc2"));
		
	}
	
	public List<Category> getCategories(){
		return categories;
	}
	
	
}
