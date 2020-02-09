package net.main.onlineshopbackend.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.main.onlineshopbackend.dao.ProductDao;
import net.main.onlineshopbackend.dto.Product;

public class ProductTestCase {
	
	private static AnnotationConfigApplicationContext context;
	private static ProductDao productDao;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.main.onlineshopbackend");
		context.refresh();
		
		productDao = (ProductDao) context.getBean(ProductDao.class);
	}
	
	@Ignore
	@Test
	public void testGetProduct() {
		Product product = productDao.getProduct(2);

		assertEquals("Successfully get product from the database", "Samsung s7", product.getName());
	}
	
	@Ignore
	@Test
	public void testGetAllProducts() {
		List<Product> products = productDao.getProducts();
		
		assertEquals("Successfully get all products from the database!", 5, products.size());
	}
	
	@Ignore
	@Test
	public void testAddProduct() {
		Product product = new Product();
		product.setName("Samsung S10+");
		product.setDescription("The best phone ever!");
		product.setUnitPrice(125000.00);
		product.setQuantity(1);
		product.setActive(true);
		product.setCategoryId(3);
		product.setSupplierId(4);
		product.setBrand("Samsung");
		
		assertEquals("Successfully added product to the database", true, productDao.addProduct(product));
	}
	
	@Ignore
	@Test
	public void testUpdateProduct() {
		Product product = productDao.getProduct(4);
		product.setUnitPrice(60000.00);
		
		assertEquals("Successfully updated product in the database", true, productDao.updateProduct(product));
	}
	
	@Ignore
	@Test
	public void deleteProduct() {
		Product product = productDao.getProduct(6);
		
		assertEquals("Successfully deleted product from the database!", true, productDao.deleteProduct(product));
	}
	
	@Ignore
	@Test
	public void testGetActiveProducts() {
		List<Product> activeProducts = productDao.getActiveProducts();
		
		assertEquals("Successfully get list of all active products!", 5, activeProducts.size());
	}
	
	@Ignore
	@Test
	public void testActiveProductsByCategory() {
		List<Product> activeProductsByCateogory = productDao.getActiveProductsByCategory(3);
		
		assertEquals("Successfully get list of all active products by category!", 3, activeProductsByCateogory.size());
	}
	
	@Ignore
	@Test
	public void testLatestActiveProducts() {
		List<Product> latestActiveProducts = productDao.getLatestActiveProducts(2);
		
		assertEquals("Successfully get list of 2 active products!", 2, latestActiveProducts.size());
	}
	
	@Ignore
	@Test
	public void testCRUDProduct() {
		//insert product
		Product product = new Product();
		product.setName("Samsung S8+");
		product.setDescription("The second best phone ever!");
		product.setUnitPrice(105000.00);
		product.setQuantity(2);
		product.setActive(true);
		product.setCategoryId(3);
		product.setSupplierId(4);
		product.setBrand("Samsung");
		
		assertEquals("Successfully added product to the database", true, productDao.addProduct(product));
	
		//get product
		product = productDao.getProduct(7);
		product.setActive(false);
		
		//update product to be unactive
		assertEquals("Successfully updated product in the database", true, productDao.updateProduct(product));
	
		//delete product
		assertEquals("Successfully deleted product from the database!", true, productDao.deleteProduct(product));
		
		//list of active products
		List<Product> activeProducts = productDao.getActiveProducts();
		assertEquals("Successfully get list of all active products!", 5, activeProducts.size());
	
		//list of active products by cateogory
		List<Product> activeProductsByCateogory = productDao.getActiveProductsByCategory(3);
		assertEquals("Successfully get list of all active products by category!", 3, activeProductsByCateogory.size());
	
		//list of latest active products with limit
		List<Product> latestActiveProducts = productDao.getLatestActiveProducts(2);
		assertEquals("Successfully get list of 2 active products!", 2, latestActiveProducts.size());

	}
}
