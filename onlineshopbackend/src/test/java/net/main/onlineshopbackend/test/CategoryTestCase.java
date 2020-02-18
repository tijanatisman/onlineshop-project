package net.main.onlineshopbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.main.onlineshopbackend.dao.CategoryDao;
import net.main.onlineshopbackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;
	private static CategoryDao categoryDao;
	private Category category;
	
	@BeforeClass
	public static void init() {
		
		context = new AnnotationConfigApplicationContext();
		context.scan("net.main.onlineshopbackend");
		context.refresh();
		
		categoryDao = (CategoryDao) context.getBean(CategoryDao.class); //mozda ces u dao morati da dodas kao repository categoryDao
	}
	
//	@Test
	public void testAddCategory() {
		category = new Category();
		category.setName("Laptop");
		category.setDescription("This is some description for laptops");
		category.setImageUrl("cat_1_laptop.png");
		
		boolean categoryAdded = categoryDao.addCategory(category);
		assertEquals("Successfully added new category to the database!", true, categoryAdded); //message, expected, actual
	}
	
//	@Test
	public void testGetCategory() {
		Category category = categoryDao.getCategory(8);
		
		assertEquals("Successfully get a category from database!", 8, category.getId());
	}
	
//	@Test
	public void testUpdateCategory() {
		Category category = categoryDao.getCategory(8);
		category.setDescription("bla bla neki tekst");
		boolean categoryUpdated = categoryDao.updateCategory(category);
		
		assertEquals("Successfully updated category in the database!", true, categoryUpdated);
	}
	
//	@Test
	public void testUpdateCategory_DisableCategory() {
		Category category = categoryDao.getCategory(9);
		category.setActive(false);
		boolean categoryUpdated = categoryDao.updateCategory(category);
		
		assertEquals("Successfully updated category in the database!", true, categoryUpdated);
	}
	
//	@Test
	public void testGetAllActiveCategories() {
		assertEquals("Successfully get all 3 categories that are active from the database!", 3, categoryDao.getAllActiveCategories().size());
	}
	
//	@Test
	public void testCRUDCategory() {
		//insert category
		category = new Category();
		category.setName("Bla1");
		category.setDescription("This is some description for computers");
		category.setImageUrl("cat_12.png");
		
		boolean categoryAdded = categoryDao.addCategory(category);
		assertEquals("Successfully added new category to the database!", true, categoryAdded); //message, expected, actual
		
		
		//get category and update category
		Category category = categoryDao.getCategory(7);
		category.setDescription("bla bla neki tekst");
		boolean categoryUpdated = categoryDao.updateCategory(category);
		
		assertEquals("Successfully updated category in the database!", true, categoryUpdated);
		
		
		//disable category
		category = categoryDao.getCategory(7);
		category.setActive(false);
		categoryUpdated = categoryDao.updateCategory(category);
		
		assertEquals("Successfully updated category in the database!", true, categoryUpdated);
	}
}
