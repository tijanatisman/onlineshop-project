package net.main.onlineshopbackend.dao;

import java.util.List;

import net.main.onlineshopbackend.dto.Category;

public interface CategoryDao {
	
	List<Category> getAllCategories();
	
	Category getCategory(int categoryId);
	
}
