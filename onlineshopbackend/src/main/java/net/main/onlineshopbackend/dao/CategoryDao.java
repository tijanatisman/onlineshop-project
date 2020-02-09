package net.main.onlineshopbackend.dao;

import java.util.List;

import net.main.onlineshopbackend.dto.Category;

public interface CategoryDao {
	

	/**
	 * Get single category based on category id
	 * 
	 * @param 
	 * 		categoryId
	 * @return
	 * 		category
	 * @throws SQLException
	 * 
	 * */
	Category getCategory(int categoryId);
	
	/**
	 * Get all active categories
	 * 
	 * @return
	 * 		  List of all active categories
	 */
	List<Category> getAllActiveCategories();
	
	
	/**
	 * Add a category to the database
	 * 
	 * @param 
	 * 		category
	 * @return
	 * 		true if category is added, or false if it's not
	 * 
	 * */
	boolean addCategory(Category category);
	
	/**
	 * Update single category in the database
	 * 
	 * @param 
	 * 		category
	 * @return
	 * 		true if category is updated, or false if it's not
	 * 
	 * */
	boolean updateCategory(Category category);
}
