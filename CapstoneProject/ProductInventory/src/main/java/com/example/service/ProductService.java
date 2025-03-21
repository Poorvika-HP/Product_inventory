package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Product;
import com.example.repository.ProductRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public void resetAutoIncrement() {
	    Long maxId = (Long) entityManager.createQuery("SELECT COALESCE(MAX(p.id), 0) FROM Product p").getSingleResult();
	    System.out.println("Max ID: " + maxId);

	    // Reset AUTO_INCREMENT only if maxId is greater than 0
	    if (maxId > 0) {
	        entityManager.createNativeQuery("ALTER TABLE products AUTO_INCREMENT = " + (maxId + 1))
	                     .executeUpdate();
	    }
	}

	
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	public Product getProductById(Long id) {
		return productRepository.findById(id).orElse(null);
	}
   
	@Transactional
	public Product saveProduct(Product product) {
		resetAutoIncrement();

		return productRepository.save(product);
	}

	public boolean deleteProduct(Long id) {
		Optional<Product> pchk = productRepository.findById(id);
		if (pchk.isEmpty()) {
			return false;
		}
		productRepository.deleteById(id);
		return true;

	}
}