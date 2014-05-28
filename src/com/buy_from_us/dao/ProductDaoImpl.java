package com.buy_from_us.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.buy_from_us.model.Category;
import com.buy_from_us.model.Product;

@Repository("productDao")
@Transactional
public class ProductDaoImpl implements ProductDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	private static final String ADD_PRODUCT_SUCCESS = "Product is added successfully!";
	private static final String ADD_PRODUCT_FAIL = "Error on adding product!";
	private static final String ADD_CATEGORY_SUCCESS = "Category is added successfully!";
	private static final String ADD_CATEGORY_FAIL = "Error on adding category!";
	private static final String SEARCH_CAT_NAME = "from Category where categoryName= :catName";
	private static final String SELECT_ALL_CATEGORY = "from Category";
	private static final String SEARCH_BY_PRODUCT_NAME = "from Product where productName= :prodName";

	public List<Product> viewProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	

	public String addProduct(Product product, String categoryName) {
		String result = ADD_PRODUCT_SUCCESS;
		Session session = sessionFactory.openSession();
		try{
	        session.beginTransaction();
	        
	        //Category category = product.getCategory();
	        //session.save(category);
	        
	        Category category = searchByCategoryName(categoryName);
	        product.setCategory(category);
	        session.save(product);
	        session.getTransaction().commit();
	        
		}catch(Exception e){
			result = ADD_PRODUCT_FAIL;
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return result;
	}

	public String addCategory(Category category) {
		String result = ADD_CATEGORY_SUCCESS;
		Session session = sessionFactory.openSession();
		
		try {
			session.beginTransaction();
	        session.save(category);
	        session.getTransaction().commit();
		} catch (Exception e) {
			result = ADD_CATEGORY_FAIL;
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}

	public Category searchByCategoryName(String categoryName) {
		Session session = sessionFactory.getCurrentSession();
		Category category = null;
		Query query = session.createQuery(SEARCH_CAT_NAME);
		query.setParameter("catName", categoryName);
		List<Category> categoryList = (List<Category>) query.list();
		
		if (categoryList!=null) {
			category = categoryList.get(0);
			System.out.println("key:" + category.getCategoryKey());
			System.out.println("value: "+ category.getCategoryName());
		}
		
		return category;
	}

	public List<Category> getAllCategories() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(SELECT_ALL_CATEGORY);
		List<Category> categoryList = query.list();
		return categoryList;
	}

	public List<Product> getProductsByCategory(String category) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(SEARCH_CAT_NAME);
		query.setParameter("catName", category);
		List<Product> productList = new ArrayList<Product>();
		List<Category> categoryList = (List<Category>) query.list();
		
		if(categoryList!=null) {
			for(Category cat : categoryList) {
			 productList.addAll(cat.getProductList());
			}
		}
		
		return productList;
	}



	public Product searchByProductName(String productName) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(SEARCH_BY_PRODUCT_NAME);
		query.setParameter("prodName", productName);
		
		Product product = new Product();
		List<Product> productList = (List<Product>) query.list();
		
		if (productList!=null) {
			product = productList.get(0);
		}
		
		return product;
	}
	
	

}
