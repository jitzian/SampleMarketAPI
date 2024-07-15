package com.platzi.market.domain.service;

import com.platzi.market.domain.ProductDTO;
import com.platzi.market.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<ProductDTO> getAll() {
        return productRepository.getAll();
    }

    public Optional<ProductDTO> getProduct(int productId) {
        return productRepository.getProduct(productId);
    }

    public Optional<List<ProductDTO>> getByCategory(int categoryId) {
        return productRepository.getByCategory(categoryId);
    }

    public ProductDTO save(ProductDTO product) {
        return productRepository.save(product);
    }

    public boolean delete(int productId) {
        return getProduct(productId).map(product -> {
            productRepository.delete(productId);
            return true;
        }).orElse(false);
    }
}
