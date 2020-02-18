package net.main.onlineshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.main.onlineshopbackend.dao.ProductDao;
import net.main.onlineshopbackend.dto.Product;

//@Controller
@RequestMapping("/json/data")
@RestController
public class JsonDataController {
	
	@Autowired
	private ProductDao productDao;

	@RequestMapping("/all/products")
//	@ResponseBody //mozes ovo da koristis u kombinaciji sa @Controllerom ili mozes da koristis samo @RestContoller, bez @Controllera i @ResponseBody-a
	public List<Product> getAllProducts() {
		return productDao.getActiveProducts(); 
	}
	
	@RequestMapping("/category/{id}/products")
	public List<Product> getAllActiveProductsByCategory(@PathVariable("id") int id){
		return productDao.getActiveProductsByCategory(id);
	}
	
	
}
