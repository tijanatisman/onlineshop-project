package net.main.onlineshopbackend.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.main.onlineshopbackend.dao.CategoryDao;
import net.main.onlineshopbackend.dto.Category;

@Repository
@Transactional
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getAllActiveCategories() {
		String selectAllActiveCategories = "FROM Category WHERE active = :active";
		
		Query<Category> query = sessionFactory.getCurrentSession().createQuery(selectAllActiveCategories);
		query.setParameter("active", true);
		
		return query.getResultList();
	}
	
	@Override
	public Category getCategory(int categoryId) {
		try {
			return sessionFactory.getCurrentSession().get(Category.class, categoryId); 
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public boolean addCategory(Category category) {
		try {
			sessionFactory.getCurrentSession().persist(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateCategory(Category category) {
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return false;
	}
}
