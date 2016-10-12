package shoppinglist.web.secured;

import static junit.framework.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.opensymphony.xwork2.Action;

import shoppinglist.model.Product;
import shoppinglist.repository.ProductRepository;


public class ProductListActionTest {
    @Test
    public void returnsSuccess() {
        ProductRepository pr = new ProductRepository() {
            public List<Product> getProducts() {
                return null; // never used
            }
            public List<Product> getProductsById(List<Long> ids) {
                return null; // never used
            }
            public List<Product> getProductsComplementOf(List<Product> products) {
                return null; // never used
            }
        };
        ProductListAction pa = new ProductListAction(pr);
        assertEquals(Action.SUCCESS, pa.execute());
    }
    
    @Test
    public void returnsAllProducts() {
        ProductRepository mockRepo = new ProductRepository() {
            public List<Product> getProducts() {
                return productList();
            }
            public List<Product> getProductsById(List<Long> ids) {
                return null; // never used
            }
            public List<Product> getProductsComplementOf(List<Product> products) {
                return null; // never used
            }
        };
        ProductListAction pa = new ProductListAction(mockRepo);
        pa.execute();
        assertEquals(productList(), pa.getProductList());
    }
    
    @Test
    public void returnsComplement() {
        final List<Product> products = Arrays.asList(newProduct(2L, "name2"));
        ProductRepository pr = new ProductRepository() {
            public List<Product> getProducts() {
                return null; // never used
            }
            public List<Product> getProductsById(List<Long> ids) {
                return null; // never used
            }
            public List<Product> getProductsComplementOf(List<Product> p) {
                return products;
            }
        };
        ProductListAction pa = new ProductListAction(pr);
        pa.setSelectedProducts(Arrays.asList(newProduct(1L, "name1")));
        pa.execute();
        assertEquals(products, pa.getProductList());
    }

    private List<Product> productList() {
        Product p1 = newProduct(1L, "name1");
        Product p2 = newProduct(2L, "name2");
        return Arrays.asList(p1, p2);
    }

    private Product newProduct(Long id, String name) {
        Product p = new Product(); p.setId(id); p.setName(name);
        return p;
    }
}
