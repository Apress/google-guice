package shoppinglist.web.secured;

import java.util.Arrays;

import net.jcip.annotations.NotThreadSafe;
import shoppinglist.model.ShoppingList;
import shoppinglist.repository.ProductRepository;
import shoppinglist.repository.ShoppingListRepository;

import com.google.inject.Inject;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Actions related to a single {@link ShoppingList}.
 * @author Robbie Vanbrabant
 */
@NotThreadSafe
public class ShoppingListAction extends ActionSupport {
    private ShoppingList shoppingList;
    private Long[] selectedProducts;
    
    private final ShoppingListRepository shoppingListRepository;
    private final ProductRepository productRepo;
    
    @Inject
    public ShoppingListAction(ShoppingListRepository repository, ProductRepository productRepo) {
        this.shoppingListRepository = repository;
        this.productRepo = productRepo;
    }
    
    //-------------------------------------------------------------------------
    // Navigation
    //-------------------------------------------------------------------------
    
    public String createSubmit() {
        shoppingList.setProducts(productRepo.getProductsById(Arrays.asList(getSelectedProducts())));
        shoppingListRepository.create(shoppingList);
        return SUCCESS;
    }
    
    public String editSubmit() {
        shoppingList.setProducts(productRepo.getProductsById(Arrays.asList(getSelectedProducts())));
        shoppingListRepository.update(shoppingList);
        return SUCCESS;
    }
    
    //-------------------------------------------------------------------------
    // Mutators / Accessors
    //-------------------------------------------------------------------------

    public ShoppingList getShoppingList() {
        return shoppingList;
    }

    public Long[] getSelectedProducts() {
        return selectedProducts;
    }

    public void setSelectedProducts(Long[] selectedProducts) {
        this.selectedProducts = selectedProducts;
    }

    public void setShoppingList(ShoppingList shoppingList) {
        this.shoppingList = shoppingList;
    }
}
