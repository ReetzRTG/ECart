package com.niit.eshop.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.eshop.dao.CategoryDao;
import com.niit.eshop.model.Category;

@Controller
public class CategoryController {

	@Autowired
	CategoryDao categoryDao;
	
	@RequestMapping("/addCategory")
	public ModelAndView showform() {
		return new ModelAndView("addCategory","command",new Category());
	}
	
	@RequestMapping(value="/saveCategory",method=RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("Category") Category category)
	{
		categoryDao.insertCategory(category);
		return new ModelAndView("redirect:/viewCategory");
	}
	@RequestMapping("/viewCategory")
	public ModelAndView viewCategory(){
		List<Category> List=categoryDao.getlist();
		return new ModelAndView("viewCategory","list",List);
	}
	@RequestMapping(value="/editCategory/{id}")
	public ModelAndView edit (@PathVariable int id){
		Category category=categoryDao.getCategoryById(id);
		return new ModelAndView("categoryeditform","command",category);
	}
	@RequestMapping(value="/editsaveCategory",method=RequestMethod.POST)
	public ModelAndView editsave(@ModelAttribute("Category")Category category){
	categoryDao.updateCategory(category);
	return new ModelAndView("redirect:/viewCategory");
	}
	@RequestMapping(value="/deleteCategory/{id}",method=RequestMethod.GET)
	public ModelAndView delete(@PathVariable int id){
		System.out.println("Delete is called");
		categoryDao.deleteCategory(id);
		return new ModelAndView("redirect:/viewCategory");
		}
	
}
