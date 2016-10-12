package shoppinglist.web.secured;

import java.util.List;

import net.jcip.annotations.NotThreadSafe;
import shoppinglist.model.Product;
import shoppinglist.repository.ProductRepository;

import com.google.inject.Inject;
import com.opensymphony.xwork2.Action;

@NotThreadSafe
public class ProductListAction {
    private final ProductRepository productRepo;
    private List<Product> productList;
    private List<Product> selectedProducts;
    
    @Inject
    public ProductListAction(ProductRepository productRepo) {
        this.productRepo = productRepo;
    }
    
    public String execute() {
        if (this.selectedProducts == null)
            this.productList = productRepo.getProducts();
        else
            this.productList = productRepo.getProductsComplementOf(this.selectedProducts);
        return Action.SUCCESS;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setSelectedProducts(List<Product> selectedProducts) {
        this.selectedProducts = selectedProducts;
    }
}
