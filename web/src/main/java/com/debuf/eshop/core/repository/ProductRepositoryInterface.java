package com.debuf.eshop.core.repository;

import com.debuf.eshop.core.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepositoryInterface extends CrudRepository<Product,Long> {

}
