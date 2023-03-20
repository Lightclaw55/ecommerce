package com.ecommerce.repositories;

import com.ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository {

    Product findProductById(int id);

    Product findProductByName(String name);

    List<Product> findAllProduct();

    Product save(Product p);

}
