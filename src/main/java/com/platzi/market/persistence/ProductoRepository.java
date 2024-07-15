package com.platzi.market.persistence;

import com.platzi.market.domain.ProductDTO;
import com.platzi.market.domain.repository.ProductRepository;
import com.platzi.market.persistence.crud.ProductCrudRepository;
import com.platzi.market.persistence.entity.Producto;
import com.platzi.market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository {
    @Autowired
    private ProductCrudRepository productCrudRepository;

    @Autowired
    private ProductMapper mapper;

    @Override
    public List<ProductDTO> getAll() {
        List<Producto> productos = (List<Producto>) productCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    @Override
    public Optional<List<ProductDTO>> getByCategory(int categoryId) {
        List<Producto> productos = productCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<ProductDTO>> getScarseProducts(int quantity) {
        Optional<List<Producto>> productos = productCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        return productos.map(prods -> mapper.toProducts(prods));
    }

    @Override
    public Optional<ProductDTO> getProduct(int productId) {
        return productCrudRepository.findById(productId).map(producto -> mapper.toProduct(producto));
    }

    @Override
    public ProductDTO save(ProductDTO product) {
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(productCrudRepository.save(producto));
    }

    @Override
    public void delete(int productId) {
        productCrudRepository.deleteById(productId);
    }
}
