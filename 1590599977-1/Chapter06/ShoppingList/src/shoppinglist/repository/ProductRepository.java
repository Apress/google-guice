package shoppinglist.repository;

import java.util.List;

import shoppinglist.model.Product;

public interface ProductRepository {
    List<Product> getProducts();
    List<Product> getProductsById(List<Long> ids);
    List<Product> getProductsComplementOf(List<Product> products);
}
