package com.example.ordermanagement.controller;

import com.example.ordermanagement.model.Product;
import com.example.ordermanagement.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ProductController {
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

//    GET /product/101
    @GetMapping("/product/{productId}")
    public Product getProduct(@PathVariable Long productId){
        return  productService.getProduct(productId);
    }


    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @PostMapping("/product")
    public Product createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }
}
