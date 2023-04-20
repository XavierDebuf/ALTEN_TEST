package com.debuf.eshop.core.service;

import com.debuf.eshop.core.entity.Product;
import com.debuf.eshop.core.repository.ProductRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements ProductServiceInterface {
    public ProductRepositoryInterface getProductRepository() {
        return productRepository;
    }

    public void setProductRepository(ProductRepositoryInterface productRepository) {
        this.productRepository = productRepository;
    }

    @Autowired
    private ProductRepositoryInterface productRepository;
    public ProductService(ProductRepositoryInterface ProductRepository){
         this.productRepository = ProductRepository;
    }

      /* @Override
    public Iterable<Product> insertMany(Iterable<Product> products) {
        JsonFromFile jff =new JsonFromFile();
        List<Product> iterator = jff.getFromJsonFile();
        List<Product> product= (List<Product>) products;
        while (iterator.listIterator().hasNext()) {
            product.add(iterator.listIterator().next());

        }
        return productRepository.saveAll(product);
    }*/

    @Override
    public Product insert(Product product){
        return productRepository.save(product);
    }

    @Override
    public void update(Product product){
        productRepository.save(product);
    }

    @Override
    public void delete(Product product){
        productRepository.delete(product);
    }

    @Override
    public Product select(Product product){
        return productRepository.findById((long) product.getId()).orElse(null);
    }

    @Override
    public List<Product> selectAll(){
        return (List<Product>) productRepository.findAll();
    }
}



