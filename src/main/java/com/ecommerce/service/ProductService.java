package com.ecommerce.service;

import com.ecommerce.model.Product;
import com.ecommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductService {

    private final ProductRepository productRepo;

    @Autowired
    public ProductService(ProductRepository productRepo)
    {
        this.productRepo = productRepo;
    }

    public Product getProductById(int id)
    {
        return productRepo.findProductById(id);
    }

    public Product getProductByName(String name)
    {
        return productRepo.findProductByName(name);
    }

    public List<Product> getAllProducts()
    {
        return productRepo.findAllProduct();
    }

    public Product save(Product p)
    {
        return productRepo.save(p);
    }
}
