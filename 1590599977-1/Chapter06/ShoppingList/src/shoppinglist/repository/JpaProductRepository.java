package shoppinglist.repository;

import java.util.List;

import shoppinglist.model.Product;

import com.google.inject.name.Named;
import com.wideplay.warp.persist.TransactionType;
import com.wideplay.warp.persist.Transactional;
import com.wideplay.warp.persist.dao.Finder;

public class JpaProductRepository implements ProductRepository {
    @Finder(namedQuery=Product.Q_ALL_PRODUCTS)
    @Transactional(type=TransactionType.READ_ONLY)
    public List<Product> getProducts() {
        return null;
    }
    
    @Finder(namedQuery=Product.Q_PRODUCTS_WITH_IDS)
    @Transactional(type=TransactionType.READ_ONLY)
    public List<Product> getProductsById(@Named("ids") List<Long> ids) {
        return null;
    }

    @Finder(namedQuery=Product.Q_PRODUCTS_COMPLEMENT)
    @Transactional(type=TransactionType.READ_ONLY)
    public List<Product> getProductsComplementOf(@Named("products") List<Product> products) {
        return null;
    }
}
