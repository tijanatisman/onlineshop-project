package net.main.onlineshopbackend.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import net.main.onlineshopbackend.dao.CategoryDao;
import net.main.onlineshopbackend.dto.Category;

@Repository /*ovo moras da stavis da bi dispatcher-servlet mogao u pageControlleru da pozove categoryDao, tj da ga Autowired-uje, mozes da stavis ovako, a mozes i da mu dodelis defaultni name u zagradi ("categoryDao")*/
public class CategoryDaoImpl implements CategoryDao {

	private static List<Category> categories = new ArrayList<>();
	
	static {
		Category cat1 = new Category();
		cat1.setId(1);
		cat1.setName("Laptop");
		cat1.setDescription("bla bla");
		cat1.setImageUrl("nekiurl.png");
		categories.add(cat1);
		
		Category cat2 = new Category();
		cat2.setId(2);
		cat2.setName("Telefon");
		cat2.setDescription("bla bla telefon nekiii");
		cat2.setImageUrl("nekiurl.png");
		categories.add(cat2);
		
		Category cat3 = new Category();
		cat3.setId(3);
		cat3.setName("Komp");
		cat3.setDescription("blaaaa");
		cat3.setImageUrl("nekiurl.png");
		categories.add(cat3);
		
	}
	
	
	@Override
	public List<Category> getAllCategories() {
		return categories;
	}

	@Override
	public Category getCategory(int categoryId) {
		for (Category category : categories) {
			if(category.getId() == categoryId) {
				return category;
			}
		}
		return null;
	}
}
