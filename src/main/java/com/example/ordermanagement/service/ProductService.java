package com.example.ordermanagement.service;

import com.example.ordermanagement.exception.NotFoundException;
import com.example.ordermanagement.model.Product;
import com.example.ordermanagement.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * Get unique product
     */
    public Product getProduct(Long id){
        Optional<Product> product = productRepository.findById(id);
        if(product.isEmpty()){
            throw new NotFoundException("Product with id: "+id+" was not found");
        }
        return product.get();
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
    /**
     * Create product
     */
    public  Product createProduct(Product product){
       return productRepository.save(product);
    }
}
