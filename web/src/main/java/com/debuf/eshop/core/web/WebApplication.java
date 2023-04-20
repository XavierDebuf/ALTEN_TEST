package com.debuf.eshop.core.web;

import com.debuf.eshop.core.entity.Product;
import com.debuf.eshop.core.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@SpringBootApplication
@ComponentScan(basePackages = "com.debuf.eshop.core.*")
@EntityScan("com.debuf.eshop.core.entity")
@EnableJpaRepositories(basePackages = "com.debuf.eshop.core.repository")
@RestController
@RequestMapping("/")
public class WebApplication {
    @Autowired
    ProductService ProductService;
    @GetMapping("/{id}")
    public Product get(@PathVariable("id") Product product) {
        System.out.println("retrieve one product");
        return ProductService.select(product);
    }

    @GetMapping("/")
    public List<Product> getAll() {
        System.out.println("retrieve all product");
        return  ProductService.selectAll();
    }

    @PostMapping("/")
    public Product create(Product product) {
        System.out.println("create product");
        return ProductService.insert(product);
    }

    @PatchMapping("/{id}")
    public void update(@PathVariable("id") Product product) {
        System.out.println("update product");
        ProductService.update(product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Product product) {
        ProductService.delete(product);
        System.out.println("produit supprimé");
    }
/*
    @PostMapping("/insert")
    public List<Product> insertMany(Iterable<Product> products) {
        return (List<Product>) ProductService.insertMany(products);
    }*/

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }

}
