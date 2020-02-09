package net.main.onlineshopbackend.dao.impl;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.main.onlineshopbackend.dao.ProductDao;
import net.main.onlineshopbackend.dto.Product;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Product getProduct(int productId) {
		try {
			return sessionFactory.getCurrentSession().get(Product.class, productId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getProducts() {
		String selectAllProducts = "FROM Product";
		
		Query<Product> query = sessionFactory.getCurrentSession().createQuery(selectAllProducts);
		
		return query.getResultList();
	}

	@Override
	public boolean addProduct(Product product) {
		try {
			sessionFactory.getCurrentSession().persist(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateProduct(Product product) {
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean deleteProduct(Product product) {
		try {
			sessionFactory.getCurrentSession().delete(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getActiveProducts() {
		String selectAllActiveProducts = "FROM Product WHERE active = :active";
		
		Query<Product> query = sessionFactory.getCurrentSession().createQuery(selectAllActiveProducts);
		query.setParameter("active", true);
		
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getActiveProductsByCategory(int categoryId) {
		String selectActiveProductsByCategory = "FROM Product WHERE categoryId = :categoryId AND active = :active";
		
		Query<Product> query = sessionFactory.getCurrentSession().createQuery(selectActiveProductsByCategory);
		query.setParameter("categoryId", categoryId);
		query.setParameter("active", true);
		
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getLatestActiveProducts(int limit) {
		String selectLatestActiveProducts = "FROM Product WHERE active = :active";
		
		Query<Product> query = sessionFactory.getCurrentSession().createQuery(selectLatestActiveProducts);
		query.setMaxResults(limit);
		query.setParameter("active", true);
		
		return query.getResultList();
	}


}
