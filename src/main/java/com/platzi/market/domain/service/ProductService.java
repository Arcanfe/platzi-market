package com.platzi.market.domain.service;

import com.platzi.market.domain.Product;
import com.platzi.market.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// @Component
@Service // Anotacion de tipo Component
public class ProductService {
   @Autowired
    private ProductRepository productRepository;

   public List<Product> getAll() {
       return productRepository.getAll();
   }

   public Optional<Product> getProduct(int productId) {
       return productRepository.getProduct((productId));
   }

   public Optional<List<Product>> getByCategory(int categoryId) {
       return productRepository.getByCategory(categoryId);
   }

   public Product save(Product product) {
       return productRepository.save(product);
   }

   public boolean delete(int productId) {
       return getProduct(productId).map(prod -> {
           productRepository.delete(productId);
           return true;
       }).orElse(false);

       // Alternativa
       //if (getProduct(productId).isPresent()) {
       //    productRepository.delete(productId);
       //    return true;
       //}
       //else {
       //    return false;
       //}
   }
}
