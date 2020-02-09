package net.main.onlineshopbackend.dao;

import java.util.List;

import net.main.onlineshopbackend.dto.Product;

public interface ProductDao {
	
	/**
	 * Get single product based on product id
	 * 
	 * @param 
	 * 		productId
	 * @return
	 * 		product
	 * @throws SQLException
	 * 
	 * */
	Product getProduct(int productId);
	
	/**
	 * Get all products
	 * 
	 * @return
	 * 		  List of all products
	 */
	List<Product> getProducts();
	
	/**
	 * Add a product to the database
	 * 
	 * @param 
	 * 		product
	 * @return
	 * 		true if product is added, or false if it's not
	 * 
	 * */
	boolean addProduct(Product product);
	
	/**
	 * Update a product in the database
	 * 
	 * @param 
	 * 		product
	 * @return
	 * 		true if product is updated, or false if it's not
	 * 
	 * */
	boolean updateProduct(Product product);
	
	/**
	 * Delete a product from the database
	 * 
	 * @param 
	 * 		product
	 * @return
	 * 		true if product is deleted, or false if it's not
	 * 
	 * */
	boolean deleteProduct(Product product);
	
	/**
	 * Get all active products
	 * 
	 * @return
	 * 		  List of all active products
	 */
	List<Product> getActiveProducts();
	
	/**
	 * Get all active products by category
	 * 
	 * @param 
	 * 		categoryId
	 * 
	 * @return
	 * 		List of all active products by category
	 */
	List<Product> getActiveProductsByCategory(int categoryId);
	
	/**
	 * Get latest active products
	 * 
	 * @param 
	 * 		limit
	 * 
	 * @return
	 * 		List of latest active products
	 */
	List<Product> getLatestActiveProducts(int limit);
	
}
