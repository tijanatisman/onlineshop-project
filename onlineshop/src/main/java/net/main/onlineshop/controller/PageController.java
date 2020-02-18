package net.main.onlineshop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.main.onlineshop.exception.ProductNotFoundException;
import net.main.onlineshopbackend.dao.CategoryDao;
import net.main.onlineshopbackend.dao.ProductDao;
import net.main.onlineshopbackend.dto.Category;
import net.main.onlineshopbackend.dto.Product;



@Controller
public class PageController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PageController.class);

	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private ProductDao productDao;

	
	@RequestMapping(value = {"/", "/home", "/index"})
	public ModelAndView index() {		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		mv.addObject("categories", categoryDao.getAllActiveCategories());
		mv.addObject("userClickHome", true);
		
		LOGGER.info("Inside the PageController index method - INFO");
		LOGGER.debug("Inside the PageController index method - DEBUG");
		
		return mv;
	}
	
	@RequestMapping(value = "/about")
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About Us");
		mv.addObject("userClickAbout", true);
		return mv;
	}
	
	@RequestMapping(value = "/contact")
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact");
		mv.addObject("userClickContact", true);
		return mv;
	}
	
	/*
	 * Methods to load all the products based on category
	 * */
	@RequestMapping(value = "/show/all/products")
	public ModelAndView showAllProducts() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "All products");
		
		//passing all the categories
		mv.addObject("categories", categoryDao.getAllActiveCategories());
		
		mv.addObject("userClickAllProducts", true);
		return mv;
	}
	
	@RequestMapping(value = "/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("page");
		
		
		Category category = categoryDao.getCategory(id);
		
		mv.addObject("title", category.getName());
		
		//passing all the categories
		mv.addObject("categories", categoryDao.getAllActiveCategories());
		
		//passing category by id
		mv.addObject("category", category);
		
		mv.addObject("userClickCategoryProducts", true);
		return mv;
	}
	
	/**
	 * Viewing a single product
	 * 
	 * */
	
	@RequestMapping(value = "/show/{id}/product")
	public ModelAndView showProduct(@PathVariable int id) throws ProductNotFoundException{
		ModelAndView mv = new ModelAndView("page");
		
		Product product = productDao.getProduct(id);
	
		if(product == null) throw new ProductNotFoundException();
		
		product.setViews(product.getViews() + 1);
		
		//update view count
		productDao.updateProduct(product);
		
		mv.addObject("product", product);
		
		Category category = categoryDao.getCategory(product.getCategoryId());
		mv.addObject("category", category);
		mv.addObject("title", product.getName());
		mv.addObject("userClickProduct", true);
		return mv;
	}
	
	
}
