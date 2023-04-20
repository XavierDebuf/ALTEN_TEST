package com.debuf.eshop.core.service;

import com.debuf.eshop.core.entity.Product;
import com.debuf.eshop.core.repository.ProductRepositoryInterface;

import java.sql.SQLException;
import java.util.List;

public interface ProductServiceInterface {
    Product insert(Product product) throws SQLException;
    void update(Product product) throws SQLException;
    void delete(Product product) throws SQLException;
    Product select(Product product) throws SQLException;
    List<Product> selectAll() throws SQLException;
    void setProductRepository(ProductRepositoryInterface productRepository);
}
