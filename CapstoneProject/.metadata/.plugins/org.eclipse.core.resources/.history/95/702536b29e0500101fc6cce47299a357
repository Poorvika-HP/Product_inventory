package com.example.service;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.model.Product;
import com.example.repository.ProductRepository;

@SpringBootTest
public class ProductServiceTest2 {
	@Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    @Test
    void testSaveProduct() {
        Product product = new Product(null, "Laptop", "High performance", "Dell", 1200.00, 5);
        Product savedProduct = productService.saveProduct(product);

        assertNotNull(savedProduct);
        assertNotNull(savedProduct.getId());
        assertEquals("Laptop", savedProduct.getName());
    }

    @Test
    void testGetAllProducts() {
        productService.saveProduct(new Product(null, "Laptop", "High performance", "Dell", 1200.00, 5));
        productService.saveProduct(new Product(null, "Phone", "Smartphone", "Samsung", 800.00, 10));

        List<Product> products = productService.getAllProducts();
        assertFalse(products.isEmpty());
    }

    @Test
    void testGetProductById() {
        Product product = new Product(null, "Laptop", "High performance", "Dell", 1200.00, 5);
        Product savedProduct = productService.saveProduct(product);

        Product foundProduct = productService.getProductById(savedProduct.getId());
        assertNotNull(foundProduct);
        assertEquals("Laptop", foundProduct.getName());
    }

    @Test
    void testDeleteProduct() {
        Product product = productService.saveProduct(new Product(null, "Laptop", "High performance", "Dell", 1200.00, 5));

        boolean deleted = productService.deleteProduct(product.getId());
        assertTrue(deleted);
        assertNull(productService.getProductById(product.getId()));
    }
}